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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DespachoControlador", urlPatterns = {"/DespachoControlador"})
public class DespachoControlador extends HttpServlet {
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
                
            case "eliminarDespacho":
                int codDespacho = Integer.parseInt(request.getParameter("idDespacho"));
                ddao.eliminarDespacho(codDespacho);    
                dedao.eliminarDetalle(codDespacho);
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
