/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DAOCilindro;
import dao.DAOEmpresa;
import dao.DAOPedido;
import dao.DAOUsuario;
import dto.DTOCilindro;
import dto.DTOEmpresa;
import dto.DTOPedido;
import dto.DTOPedido_Cilindro;
import dto.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;
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
@WebServlet(urlPatterns = {"/ControlPedido"})
public class ControlPedido extends HttpServlet {

    DTOPedido dtoPedido = new DTOPedido();
    DAOCilindro daoCilindro = new DAOCilindro();
    /*Cantidad agredados*/
    List<DTOPedido_Cilindro> ListaCilindrosAgregados;
    List<DTOCilindro> ListaCilindros;

    String Empresa;
    int CodCilindro;

    List<DTOEmpresa> listaEmpresas;

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
            DAOPedido daoPedido = new DAOPedido();
            DAOEmpresa daoEmpresa = new DAOEmpresa();

            String accion = request.getParameter("accion");

            if (accion != null) {
                switch (accion) {
                    case "Modificar":
                        DAOUsuario daoUsuario = new DAOUsuario();
                        String codigo = request.getParameter("Codigo");

                        dtoPedido = daoPedido.buscarPedido(Integer.parseInt(codigo));
                        List<DTOUsuario> listaUsuarios = daoUsuario.mostrarUsuarios();

                        request.setAttribute("listaUsuarios", listaUsuarios);
                        request.setAttribute("dtoPedido", dtoPedido);

                        request.getRequestDispatcher("CRUDpedido.jsp").forward(request, response);
                        break;
                    case "Modificado":
                        int Codigo = Integer.parseInt(request.getParameter("Codigo"));
                        String doccliente = request.getParameter("doccliente");
                        String docempleado = request.getParameter("docempleado");
                        String fechapedido = request.getParameter("fechapedido");
                        String fechaentrega = request.getParameter("fechaentrega");
                        String nombredestinatario = request.getParameter("nombredestinatario");
                        String documentodestinatario = request.getParameter("documentodestinatario");
                        int Precio_Domicilio = Integer.parseInt(request.getParameter("Precio_Domicilio"));
//
//                        out.print(Codigo);
//                        out.print(doccliente);
//                        out.print(docempleado);
//                        out.print(fechapedido);
//                        out.print(fechaentrega);
//                        out.print(nombredestinatario);
//                        out.print(documentodestinatario);
//                        out.print(Precio_Domicilio);

                        dtoPedido = new DTOPedido(Codigo, doccliente, docempleado, fechapedido, fechaentrega, nombredestinatario, documentodestinatario, Precio_Domicilio);

                        if (daoPedido.modificarPedido(dtoPedido)) {
                            String caso = "17";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "18";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                    case "buscar":
                        String buscar = request.getParameter("buscar");
                        List<DTOPedido> listaPedidos = daoPedido.buscarLike(buscar);
                        request.setAttribute("ListaPedidos", listaPedidos);
                        request.getRequestDispatcher("IndexPedido.jsp").forward(request, response);
                        break;

                    case "regresar":
                        request.setAttribute("ListaEmpresas", listaEmpresas);
                        request.setAttribute("ListaCilindros", ListaCilindros);
                        request.setAttribute("Empresa", Empresa);
                        request.setAttribute("CodCilindro", CodCilindro);
                        request.getRequestDispatcher("newjsp.jsp").forward(request, response);
                        break;
                }
            } else {
                List<DTOPedido> listaPedidos = daoPedido.mostrarPedidos();
                request.setAttribute("ListaPedidos", listaPedidos);

                request.getRequestDispatcher("IndexPedido.jsp").forward(request, response);

            }

//            List<DTOUsuario> listaUsuarios = daoUsuario.mostrarUsuarios();
//            request.setAttribute("listaUsuarios", listaUsuarios);
//
//            if (buscar1 == null) {
//                buscar1 = "";
//                List<DTOPedido> listaPedidos = daoPedido.buscarLike(buscar1);
//                request.setAttribute("ListaPedidos", listaPedidos);
//            } else {
//                List<DTOPedido> listaPedidos = daoPedido.buscarLike(buscar1);
//                request.setAttribute("ListaPedidos", listaPedidos);
//            }
//
//            if (id != null) {
//                int eliminar = Integer.parseInt(id);
//                daoPedido.eliminarPedido(eliminar);
//
//            } else {
//                if (codigo != null) {
//                    int buscar = Integer.parseInt(codigo);
//                    dtoPedido = daoPedido.buscarPedido(buscar);
//                    request.setAttribute("dtoPedido", dtoPedido);
//                    request.getRequestDispatcher("CRUDpedido.jsp").forward(request, response);
//                } else {
//                    if (accion != null) {
//                        if (accion.equals("Registrar")) {
//                            String doccliente = request.getParameter("doccliente");
//                            String docempleado = request.getParameter("docempleado");
//                            String fechapedido = request.getParameter("fechapedido");
//                            String fechaentrega = request.getParameter("fechaentrega");
//                            String nombredestinatario = request.getParameter("nombredestinatario");
//                            String documentodestinatario = request.getParameter("documentodestinatario");
//                            int Precio_Domicilio = Integer.parseInt("Precio_Domicilio");
//
//                            dtoPedido = new DTOPedido(0, doccliente, docempleado, fechapedido, fechaentrega, nombredestinatario, documentodestinatario, Precio_Domicilio);
//
//                            daoPedido.registrarPedido(dtoPedido);
//                        } else {
//                            if (accion.equals("Modificar")) {
//                                int Codigo1 = Integer.parseInt(request.getParameter("Codigo"));
//                                String doccliente = request.getParameter("doccliente");
//                                String docempleado = request.getParameter("docempleado");
//                                String fechapedido = request.getParameter("fechapedido");
//                                String fechaentrega = request.getParameter("fechaentrega");
//                                String nombredestinatario = request.getParameter("nombredestinatario");
//                                String documentodestinatario = request.getParameter("documentodestinatario");
//                                int Precio_Domicilio = Integer.parseInt("Precio_Domicilio");
//
//                                dtoPedido = new DTOPedido(0, doccliente, docempleado, fechapedido, fechaentrega, nombredestinatario, documentodestinatario, Precio_Domicilio);
//
//                                daoPedido.modificarPedido(dtoPedido);
//                            }
//                        }
//
//                    }
//                }
//            }
//
//            request.getRequestDispatcher("IndexPedido.jsp").forward(request, response);
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
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
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
