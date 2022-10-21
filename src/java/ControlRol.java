/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DAORol;
import dto.DTORol;
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
 * @author user
 */
@WebServlet(urlPatterns = {"/ControlRol"})
public class ControlRol extends HttpServlet {
String DocumentoEmpleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException {
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
            DAORol daorol = new DAORol();  
            DTORol dtorol = new DTORol();
           
            String accion = request.getParameter("accion");
            
            List<DTORol> listaRoles = daorol.mostrarRoles();
            request.setAttribute("listaRoles", listaRoles);
            
            if (accion != null) {
                switch (accion) {   
                    case "Seleccionar":
                        String codigo = request.getParameter("codigo");
                        dtorol = daorol.buscarRol(codigo);
                        request.setAttribute("dtorol", dtorol);
                        request.getRequestDispatcher("CRUDRol.jsp").forward(request, response);
                    break;     
                    
                    case "Registrar":      
                        String CodRol = request.getParameter("CodRol");
                        String nombres = request.getParameter("nombres");
                           
                            dtorol = new DTORol(CodRol,nombres);   
                        if (daorol.registrarRol(dtorol)) {
                            String caso = "26";
                            request.setAttribute("caso", caso);                            
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "27";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;         
                        case "Modificar":
                            CodRol = request.getParameter("CodRol");
                            nombres = request.getParameter("nombres");
                            
                            dtorol = new DTORol(CodRol,nombres);                   
                        if (daorol.modificarRol(dtorol)) {
                            String caso = "28";
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
            
            request.getRequestDispatcher("indexRol.jsp").forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(ControlRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlRol.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ControlRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlRol.class.getName()).log(Level.SEVERE, null, ex);
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
