package Controlador;

import Modelo.Indicador;
import Modelo.IndicadorDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    UsuarioDAO udao = new UsuarioDAO();
    Usuario us = new Usuario();
    
    Indicador in = new Indicador();
    IndicadorDAO idao = new IndicadorDAO();
    
    String Nombre, Apellido, Correo, Usuario, Password;
    int idUsuario, idRol, DNI;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session;
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Ingresar":
                Usuario = request.getParameter("usuario");
                Password = request.getParameter("password");

                if (Usuario.matches("[a-zA-Z1-9]*")) {

                    us = udao.validarUsuario(Usuario, Password);

                    if (Usuario.equals(us.getUsuario()) & Password.equals(us.getPassword())) {

                        if (us.getNombreRol().equals("User")) {
                            session = request.getSession();
                            session.setAttribute("usuario", us);
                            request.getRequestDispatcher("Principal.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("mensaje", "¡Usuario o contraseña erróneos!");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("mensaje", "¡No se permiten los caracteres especiales!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
                
            case "NuevoUsuario":
                Nombre = request.getParameter("nombre");
                Apellido = request.getParameter("apellido");
                DNI = Integer.parseInt(request.getParameter("dni"));
                Correo = request.getParameter("correo");
                Usuario = request.getParameter("usuario");
                Password = request.getParameter("password");
                idRol = 1;
                
                us.setNombre(Nombre);
                us.setApellido(Apellido);
                us.setDNI(DNI);
                us.setCorreo(Correo);
                us.setUsuario(Usuario);
                us.setPassword(Password);
                us.setIdRol(idRol);
                udao.agregarUsuario(us);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
                
            case "Dashboard":
                List lista1 = idao.totalDespacho();
                List lista2 = idao.totalRegistros();
                
                request.setAttribute("lista1", lista1);
                request.setAttribute("lista2", lista2);
                request.getRequestDispatcher("Dashboard.jsp").forward(request, response);;
                break;
                
            default:
                session = request.getSession();
                session.invalidate();
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
