
import dao.DAORol;
import dao.DAOUsuario;
import dto.DTORol;
import dto.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ControlUsuario"})
public class ControlUsuario extends HttpServlet {
String DocumentoEmpleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, SQLException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                HttpSession sesion = request.getSession();
                DocumentoEmpleado = (String) sesion.getAttribute("user").toString();
            } catch (Exception e) {
                String caso = "12";
                request.setAttribute("caso", caso);
                request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
            }
            DAOUsuario daoUsuario = new DAOUsuario();
            DTOUsuario dtoUsuario = new DTOUsuario();
            DAORol daorol = new DAORol();
            String accion = request.getParameter("accion");
            String docum = request.getParameter("docum");
            String buscar = request.getParameter("buscar");

            List<DTORol> listaRoles = daorol.mostrarRoles();
            DTORol dtoRol = new DTORol();
            request.setAttribute("listaRoles", listaRoles);

            if (buscar == null) {
                buscar = "";
                List<DTOUsuario> listaUsuarios = daoUsuario.buscarLike(buscar,docum);
                request.setAttribute("ListaUsuarios", listaUsuarios);
            } else {

                List<DTOUsuario> listaUsuarios = daoUsuario.buscarLike(buscar,docum);
                request.setAttribute("ListaUsuarios", listaUsuarios);
            }

            if (accion != null) {
                switch (accion) {
                    case "Eliminar":
                        String documento = request.getParameter("documento");                        
                        if (daoUsuario.eliminarUsuario(documento)) {
                            String caso = "3";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "4";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                    case "Seleccionar":
                        documento = request.getParameter("documento");
                        dtoUsuario = daoUsuario.buscarUsuario(documento);
                        request.setAttribute("dtoUsuario", dtoUsuario);
                        request.getRequestDispatcher("CRUDusuario.jsp").forward(request, response);
                        break;
                    case "Registrar":
                        String docidentidad = request.getParameter("docidentidad");
                        String nombres = request.getParameter("nombres");
                        String apellidos = request.getParameter("apellidos");
                        String direccion = request.getParameter("direccion");
                        String telefono = request.getParameter("telefono");
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        String rol = request.getParameter("rol");

                        dtoUsuario = new DTOUsuario(docidentidad, nombres, apellidos, direccion, telefono, email, password, rol);
                        if (daoUsuario.registrarUsuario(dtoUsuario)) {
                            String caso = "1";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "2";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }

                        break;
                    case "Modificar":
                        docidentidad = request.getParameter("docidentidad");
                        nombres = request.getParameter("nombres");
                        apellidos = request.getParameter("apellidos");
                        direccion = request.getParameter("direccion");
                        telefono = request.getParameter("telefono");
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        rol = request.getParameter("rol");

                        dtoUsuario = new DTOUsuario(docidentidad, nombres, apellidos, direccion, telefono, email, password, rol);                        
                        if (daoUsuario.modificarUsuario(dtoUsuario)) {
                            String caso = "5";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "6";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                    case "Registrarse":
                        docidentidad = request.getParameter("docidentidad");
                        nombres = request.getParameter("nombres");
                        apellidos = request.getParameter("apellidos");
                        direccion = request.getParameter("direccion");
                        telefono = request.getParameter("telefono");
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        rol = request.getParameter("rol");

                        dtoUsuario = new DTOUsuario(docidentidad, nombres, apellidos, direccion, telefono, email, password, rol);
                        if (daoUsuario.registrarUsuario(dtoUsuario)) {
                            String caso = "7";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "8";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }

                        break;
                        case "DatosUsu":
                        docidentidad = request.getParameter("Doc");
                        dtoUsuario = daoUsuario.buscarUsuario(docidentidad);
                        dtoRol = daorol.buscarRol(dtoUsuario.getRol());
                        request.setAttribute("Documento", dtoUsuario.getDocumento());
                        request.setAttribute("Nombres", dtoUsuario.getNombres());
                        request.setAttribute("Apellidos", dtoUsuario.getApellidos());
                        request.setAttribute("Direccion", dtoUsuario.getDireccion());
                        request.setAttribute("Telefono", dtoUsuario.getTelefono());
                        request.setAttribute("Email", dtoUsuario.getEmail());
                        request.setAttribute("Password", dtoUsuario.getPassword());
                        request.setAttribute("Rol", dtoRol.getNombres());
                        request.getRequestDispatcher("DatosUsuario.jsp").forward(request, response);
                        break;
                    case "ModiDatosUsu":
                        documento = request.getParameter("documento");
                        dtoUsuario = daoUsuario.buscarUsuario(documento);
                        request.setAttribute("dtoUsuario", dtoUsuario);
                        request.getRequestDispatcher("ModificarDatos.jsp").forward(request, response);
                        break;
                    case "Modificar Datos":
                        docidentidad = request.getParameter("docidentidad");
                        nombres = request.getParameter("nombres");
                        apellidos = request.getParameter("apellidos");
                        direccion = request.getParameter("direccion");
                        telefono = request.getParameter("telefono");
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        rol = request.getParameter("rol");

                        dtoUsuario = new DTOUsuario(docidentidad, nombres, apellidos, direccion, telefono, email, password, rol);                        
                        if (daoUsuario.modificarUsuario(dtoUsuario)) {
                            String caso = "29";
                            request.setAttribute("caso", caso);
                            request.setAttribute("doc", docidentidad);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "30";
                            request.setAttribute("caso", caso);
                            request.setAttribute("doc", docidentidad);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                }

            }

            request.getRequestDispatcher("IndexUsuario.jsp").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
