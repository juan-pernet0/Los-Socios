import dao.DAOEmpresa;
import dto.DTOEmpresa;
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

/**
 *
 * @author USUARIO
 */
@WebServlet(urlPatterns = {"/ControlEmpresa"})
public class ControlEmpresa extends HttpServlet {

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
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            DTOEmpresa dtoEmpresa = new DTOEmpresa();
            

            String accion = request.getParameter("accion");
            String buscar = request.getParameter("buscar");
            
            List<DTOEmpresa> listaEmpresas = daoEmpresa.mostrarEmpresa();
                request.setAttribute("ListaEmpresas", listaEmpresas);
            
            if (buscar == null) {
                buscar  = "";
                List<DTOEmpresa> ListaEmpresas = daoEmpresa.buscarLike(buscar);
                request.setAttribute("ListaEmpresas", ListaEmpresas);
            } else {
                List<DTOEmpresa> ListaEmpresas = daoEmpresa.buscarLike(buscar);
                request.setAttribute("ListaEmpresas", ListaEmpresas);
            }
                
                
            if (accion != null) {
                switch (accion) {   
                    case "Seleccionar":
                        String nitEm = request.getParameter("nitEm");
                        dtoEmpresa = daoEmpresa.buscarEmpresa(nitEm);
                        request.setAttribute("dtoEmpresa", dtoEmpresa);
                        request.getRequestDispatcher("CRUDempresa.jsp").forward(request, response);
                        break;
                        
                    case "Registrar":
                           String nit = request.getParameter("nit");
                           String nombre = request.getParameter("nombre");
                           
                           dtoEmpresa = new DTOEmpresa(nit, nombre);   
                        if (daoEmpresa.registrarEmpresa(dtoEmpresa)) {
                            String caso = "22";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "23";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;    
                        
                        case "Modificar":
                            nit = request.getParameter("nit");
                            nombre = request.getParameter("nombre");
                            dtoEmpresa = new DTOEmpresa(nit, nombre);                   
                        if (daoEmpresa.modificarEmpresa(dtoEmpresa)) {
                            String caso = "24";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "25";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                       
                    }
                }
              
            request.getRequestDispatcher("IndexEmpresa.jsp").forward(request, response);
            
          
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
            Logger.getLogger(ControlEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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