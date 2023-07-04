
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
                
            case "editarEquipo":
                int codEquipo = Integer.parseInt(request.getParameter("idEquipo"));
                List listado = edao.filtrarEquipo(codEquipo);
                
                request.setAttribute("listado", listado);
                request.getRequestDispatcher("Editar_Equipos.jsp").forward(request, response);
                break;
                
            case "actualizarEquipo":
                int equipo = Integer.parseInt(request.getParameter("equipo"));
                String descripcion = request.getParameter("descripcion");
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                double precio = Double.parseDouble(request.getParameter("precio"));
                String fecha = request.getParameter("fecha");
                
                eq.setIdEquipo(equipo);
                eq.setDescripcion(descripcion);
                eq.setCantidad(cantidad);
                eq.setPrecio(precio);
                eq.setFecha(fecha);
                edao.editarEquipo(eq);
                
                request.getRequestDispatcher("EquipoControlador?accion=ListarEquipos").forward(request, response);
                break;
                
            case "eliminarEquipo":
                int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
                edao.eliminarEquipo(idEquipo);
                break;
                
            case "listarPersonal":
                List listap = pdao.listarPersonal();
                request.setAttribute("lista", listap);
                request.getRequestDispatcher("Personal.jsp").forward(request, response);
                break;
                
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
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
