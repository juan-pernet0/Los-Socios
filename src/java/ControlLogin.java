/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DAOLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;
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
@WebServlet(urlPatterns = {"/ControlLogin"})
public class ControlLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession sesion = request.getSession();
            String accion = request.getParameter("accion");

            if (accion != null) {
                switch (accion) {
                    case "Ingresar":

                        int Documento = Integer.parseInt(request.getParameter("Documento"));
                        String password = request.getParameter("password");
                        DAOLogin daoLogin = new DAOLogin();

                        String[] UsuarioValidado = daoLogin.validar(Documento);

                        if (UsuarioValidado != null) {
                            int rol = Integer.parseInt(UsuarioValidado[0]);
                            if (UsuarioValidado[1].equals(password)) {
                                sesion.setAttribute("user", Documento);
                                sesion.setAttribute("nombres", UsuarioValidado[2]);

                                switch (rol) {
                                    case 1:
                                        request.getRequestDispatcher("ControlUsuario?docum=" + Documento).forward(request, response);
                                        break;
                                    case 4:
                                        out.print("usted es usuario");
                                        break;
                                    case 5:
                                        out.print("usted es Empleado");
                                        break;
                                }
                            } else {
                                int caso = 1;
                                request.setAttribute("caso", caso);
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            }
                        } else {
                            int caso = 2;
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                        break;
                    case "Eliminar":
                        sesion.removeAttribute("user");
                        sesion.removeAttribute("nombres");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                }
            } else {
                sesion.removeAttribute("user");
                sesion.removeAttribute("nombres");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }

            //cuando no hay una sesion iniciada
            if (sesion.getAttribute("user") == null) {
                int caso = 3;
                request.setAttribute("caso", caso);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

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
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
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
