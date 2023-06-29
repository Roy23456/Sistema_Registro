
package Controlador;

import Modelo.Despacho;
import Modelo.DespachoDAO;
import Modelo.DetalleDespacho;
import Modelo.DetalleDespachoDAO;
import Modelo.Equipo;
import Modelo.EquipoDAO;
import Modelo.Personal;
import Modelo.PersonalDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EquipoControlador", urlPatterns = {"/EquipoControlador"})
public class EquipoControlador extends HttpServlet {
    
    Equipo eq = new Equipo();
    EquipoDAO edao = new EquipoDAO();
    
    Personal p = new Personal();
    PersonalDAO pdao = new PersonalDAO();
    
    Despacho d = new Despacho();
    DespachoDAO ddao = new DespachoDAO();
    
    DetalleDespacho de = new DetalleDespacho();
    DetalleDespachoDAO dedao = new DetalleDespachoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");

        switch (accion) {
            case "ListarEquipos":
                List lista = edao.listarEquipos();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("Registro_Equipos.jsp").forward(request, response);
                break;
                
            case "AgregarEquipo":
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                int codigo_SAP = Integer.parseInt(request.getParameter("codigoSAP"));
                String Serie = request.getParameter("serie");
                String Descripcion = request.getParameter("descripcion");
                int Cantidad = Integer.parseInt(request.getParameter("cantidad"));
                double Precio = Double.parseDouble(request.getParameter("precio"));
                String Fecha = request.getParameter("fecha");
                
                eq.setIdUsuario(idUsuario);
                eq.setCodigo_SAP(codigo_SAP);
                eq.setSerie(Serie);
                eq.setDescripcion(Descripcion);
                eq.setCantidad(Cantidad);
                eq.setPrecio(Precio);
                eq.setFecha(Fecha);
                
                edao.agregarEquipo(eq);
                break;
                
            case "eliminarEquipo":
                int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
                edao.eliminarEquipo(idEquipo);
                break;
                
            case "listarDespachos":
                List listar = dedao.listarDetalle();
                List equipo = edao.listarEquipos();
                List personal = pdao.listarPersonal();
                
                
                request.setAttribute("listar", listar);
                request.setAttribute("equipo", equipo);
                request.setAttribute("personal", personal);
                request.getRequestDispatcher("Despacho.jsp").forward(request, response);
                break;
            
            case "agregarDespacho":
                int Equipo = Integer.parseInt(request.getParameter("idEquipo"));
                int Personal = Integer.parseInt(request.getParameter("idPersonal"));
                int Usuario = Integer.parseInt(request.getParameter("idUsuario"));
                int cantidadDespacho = Integer.parseInt(request.getParameter("Cantidad"));
                String fechaDespacho = request.getParameter("fecha");
                
                d.setIdPersonal(Personal);
                d.setIdUsuario(Usuario);
                d.setFechaDespacho(fechaDespacho);
                ddao.agregarDespacho(d);
                
                int idDesp = Integer.parseInt(ddao.idDespacho());
                
                de.setIdDespacho(idDesp);
                de.setIdEquipo(Equipo);
                de.setCantidad(cantidadDespacho);
                dedao.agregarDetalle(de);
                
                break;
                
            case "editarDespacho":
                int idDespacho = Integer.parseInt(request.getParameter("idDespacho"));
                List listado = dedao.filtrarDetalle(idDespacho);
                List equipo1 = edao.listarEquipos();
                
                request.setAttribute("equipo", equipo1);
                request.setAttribute("listado", listado);
                request.getRequestDispatcher("Editar.jsp").forward(request, response);
                break;
                
            case "actualizarDespacho":
                int codEquipo = Integer.parseInt(request.getParameter("equipo"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                String fecha = request.getParameter("fecha");
                
                d.setFechaDespacho(fecha);
                ddao.editarDespacho(d);
                
                de.setIdEquipo(codEquipo);
                de.setCantidad(cantidad);
                dedao.editarDetalle(de);
                
                request.getRequestDispatcher("EquipoControlador?accion=listarDespachos").forward(request, response);
                break;
                
            case "listarPersonal":
                List listap = pdao.listarPersonal();
                request.setAttribute("lista", listap);
                request.getRequestDispatcher("Personal.jsp").forward(request, response);
                break;
                
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
