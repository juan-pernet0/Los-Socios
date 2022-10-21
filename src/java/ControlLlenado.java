/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DAOCilindro;
import dao.DAOEmpresa;
import dao.DAOLlenado;
import dao.DAOLlenadoCilindro;
import dto.DTOCarritoLlenado;
import dto.DTOCilindro;
import dto.DTOEmpresa;
import dto.DTOLlenado;
import dto.DTOLlenado_Cilindros;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/ControlLlenado"})
public class ControlLlenado extends HttpServlet {

    DAOLlenado daoLlenado = new DAOLlenado();
    DTOCilindro dtoCilindro = new DTOCilindro();
    DTOLlenado dtoLlenado = new DTOLlenado();
    DAOEmpresa daoEmpresa = new DAOEmpresa();
    DTOEmpresa dtoEmpresa = new DTOEmpresa();
    DAOCilindro daoCilindro = new DAOCilindro();
    DAOLlenadoCilindro daoLlenadoCilindro = new DAOLlenadoCilindro();
    DTOLlenado_Cilindros dtoLlenado_Cilindros = new DTOLlenado_Cilindros();

    int item;
    List<DTOCarritoLlenado> listaCarrito = new ArrayList<>();
    double total = 0.0;

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
            String buscar1 = request.getParameter("buscar");
            String buscar2 = request.getParameter("codigoem");
            List<DTOEmpresa> listaEmpresas = daoEmpresa.mostrarEmpresa();
            List<DTOLlenado> listallenados = daoLlenado.mostrarLlenados();
//            List<DTOLlenado_Cilindros> listaLlenadoCilindros = daoLlenadoCilindro.mostrarLlenadoCilindro();
            int codigo;
            String accion = request.getParameter("accion");

            if (accion != null) {
                switch (accion) {
                    case "eliminar":
                        codigo = Integer.parseInt(request.getParameter("id"));
                        daoLlenado.eliminarLlenado(codigo);
                        request.getRequestDispatcher("ControlLlenado?").forward(request, response);
                        break;
                    case "Modifi":
                        codigo = Integer.parseInt(request.getParameter("id"));
                        dtoLlenado = daoLlenado.buscarLlenado(codigo);
                        request.setAttribute("dtoLlenado", dtoLlenado);
                        request.getRequestDispatcher("CRUDLlenado.jsp").forward(request, response);
                        break;
                    case "Registrar":
                        String nitempresa = request.getParameter("nitempresa");
                        dtoLlenado = new DTOLlenado(0, "", nitempresa);
                        daoLlenado.registrarLlenado(dtoLlenado);
                        request.getRequestDispatcher("ControlLlenado?").forward(request, response);
                        break;
                    case "Modificar":
                        codigo = Integer.parseInt(request.getParameter("codigo"));
                        String fechallenado = request.getParameter("fechallenado");
                        nitempresa = request.getParameter("nitempresa");
                        dtoLlenado = new DTOLlenado(codigo, fechallenado, nitempresa);
                        daoLlenado.modificarLlenado(dtoLlenado);
                        break;
                    case "llend":
                        request.setAttribute("cont", listaCarrito.size());
                        if (buscar2 != null) {
                            dtoEmpresa = daoEmpresa.buscarEmpresa(buscar2);
                            String empre = dtoEmpresa.getNombre();
                            request.setAttribute("empresa", empre);
                        }
                        if (buscar2 != null) {
                            dtoEmpresa = daoEmpresa.buscarEmpresa(buscar2);
                            String empre = dtoEmpresa.getNombre();
                            request.setAttribute("empre", empre);
                        }
                        if (buscar2 != null) {
                            List<DTOCilindro> ListaCilindrosem = daoCilindro.buscarCilindroempresa(buscar2);
                            request.setAttribute("ListaCilindros", ListaCilindrosem);
                        } else {
                            buscar2 = "";
                            List<DTOCilindro> ListaCilindros = daoCilindro.buscarCilindroempresa(buscar2);
                            request.setAttribute("ListaCilindros", ListaCilindros);
                        }
                        request.setAttribute("listaEmpresas", listaEmpresas);
                        request.getRequestDispatcher("Llend.jsp").forward(request, response);
                        break;
                    case "Agregar":

                        int pos = 0;
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        int precio = Integer.parseInt(request.getParameter("precio"));
                        codigo = Integer.parseInt(request.getParameter("codigo"));
                        dtoCilindro = daoCilindro.buscarCilindro(codigo);

                        if (listaCarrito.size() > 0) {
                            for (int i = 0; i < listaCarrito.size(); i++) {
                                if (codigo == listaCarrito.get(i).getCodigo()) {
                                    pos = i;
                                }
                            }
                            if (codigo == listaCarrito.get(pos).getCodigo()) {
                                listaCarrito.get(pos).setCantidad(cantidad);
                                listaCarrito.get(pos).setCantidad(precio);
                                listaCarrito.get(pos).setSubTotal(cantidad * precio);
                            } else {
                                item = item + 1;
                                DTOCarritoLlenado carr = new DTOCarritoLlenado();
                                carr.setItem(item);
                                carr.setCodigo(dtoCilindro.getCodigo());
                                carr.setEmpresa(dtoCilindro.getEmpresa());
                                carr.setCapacidad(dtoCilindro.getCapacidad());
                                carr.setCantidad(cantidad);
                                carr.setPrecio(precio);
                                carr.setSubTotal(cantidad * precio);
                                listaCarrito.add(carr);
                            }
                        } else {
                            item = item + 1;
                            DTOCarritoLlenado carr = new DTOCarritoLlenado();
                            carr.setItem(item);
                            carr.setCodigo(dtoCilindro.getCodigo());
                            carr.setEmpresa(dtoCilindro.getEmpresa());
                            carr.setCapacidad(dtoCilindro.getCapacidad());
                            carr.setCantidad(cantidad);
                            carr.setPrecio(precio);
                            carr.setSubTotal(cantidad * precio);
                            listaCarrito.add(carr);
                        }

                        out.print(listaCarrito.get(0).getEmpresa());      
                        out.print(listaCarrito.get(0).getCodigo());

                            request.setAttribute("cont", listaCarrito.size());
                            request.getRequestDispatcher("ControlLlenado?accion=llend&codigoem="+dtoCilindro.getEmpresa()).forward(request, response);
                        break;
                    case "volver":
                        request.getRequestDispatcher("ControlLlenado?accion=llend&codigoem=" + dtoCilindro.getEmpresa()).forward(request, response);
                        break;
                    case "nuevo":
                        listaCarrito = new ArrayList<>();
                        request.getRequestDispatcher("ControlLlenado?accion=llend&codigoem=" + buscar2).forward(request, response);
                        break;
                    case "ProcesoConfirmar":
                        total = 0.0;
                        request.setAttribute("carrito", listaCarrito);
                        dtoEmpresa = daoEmpresa.buscarEmpresa(dtoCilindro.getEmpresa());
                        String empre = dtoEmpresa.getNombre();
                        request.setAttribute("empre", empre);
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            total += listaCarrito.get(i).getSubTotal();
                        }
                        request.setAttribute("totalPagar", total);
                        if (listaCarrito.size() > 0) {
                            request.getRequestDispatcher("ProcesoLlenado.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("ControlLlenado?accion=llend").forward(request, response);
                        }
                        break;
                    case "confirmar":
                        if (listaCarrito.size() > 0) {
                            request.getRequestDispatcher("ControlLlenado?accion=ProcesoConfirmar").forward(request, response);
                        } else {
                            String caso = "32";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                    case "ActualizarCantidad":
                        int idl = Integer.parseInt(request.getParameter("idl"));
                        int cant = Integer.parseInt(request.getParameter("Cantidadllenado"));
                        int preci = Integer.parseInt(request.getParameter("Precio"));
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (listaCarrito.get(i).getCodigo() == idl) {
                                listaCarrito.get(i).setCantidad(cant);
                                listaCarrito.get(i).setSubTotal(cant * preci);
                            }
                        }
                        break;
                    case "ActualizarPrecio":
                        int idll = Integer.parseInt(request.getParameter("idl"));
                        int preci1 = Integer.parseInt(request.getParameter("Precio"));
                        int cant1 = Integer.parseInt(request.getParameter("Cantidadllenado"));
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (listaCarrito.get(i).getCodigo() == idll) {
                                listaCarrito.get(i).setPrecio(preci1);
                                listaCarrito.get(i).setSubTotal(cant1 * preci1);
                            }
                        }
                        break;
                    case "Delete":
                        int idLote = Integer.parseInt(request.getParameter("id1"));
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (listaCarrito.get(i).getCodigo() == idLote) {
                                listaCarrito.remove(i);
                                out.print("eliminado");
                            }
                        }
                        break;
                    case "HacerLlenado":
                        DTOLlenado dtoLlenado = new DTOLlenado(0, "", dtoCilindro.getEmpresa());//con llaves foranes es decir con documentos que obligatoriamente esten en tblusuario        
                        daoLlenado.registrarLlenado(dtoLlenado);
                        int codigo_insertado = daoLlenado.ultimo_insertado();
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            
                            dtoLlenado_Cilindros = new DTOLlenado_Cilindros(codigo_insertado, listaCarrito.get(i).getCodigo(), listaCarrito.get(i).getCantidad(), listaCarrito.get(i).getPrecio());
                            daoLlenadoCilindro.registrarLlenado_Cilindros(dtoLlenado_Cilindros);
                            DTOCilindro dtoCilindro = new DTOCilindro();
                            dtoCilindro = daoCilindro.buscarCilindro(listaCarrito.get(i).getCodigo());
                            if (dtoCilindro.getCilindros_Vacios() < listaCarrito.get(i).getCantidad()) {
                                dtoCilindro.setCilindros_Vacios(0);
                            } else {
                                dtoCilindro.setCilindros_Vacios(dtoCilindro.getCilindros_Vacios() - listaCarrito.get(i).getCantidad());
                            }
                            dtoCilindro.setCilindros_llenos(dtoCilindro.getCilindros_llenos() + listaCarrito.get(i).getCantidad());
                            daoCilindro.modificarCilindro(dtoCilindro);
                        }
                        listaCarrito = new ArrayList<>();
                        String caso = "21";
                        request.setAttribute("caso", caso);
                        request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                    default:
                }
            } else {
                request.setAttribute("listaEmpresas", listaEmpresas);
                if (buscar1 == null) {
                    buscar1 = "";
                    List<DTOLlenado_Cilindros> listaLlenadoCilindros = daoLlenadoCilindro.buscarLlenadoCilindro(buscar1);
                    request.setAttribute("listallenadoscilindros", listaLlenadoCilindros);
                } else {
                    List<DTOLlenado_Cilindros> listaLlenadoCilindros = daoLlenadoCilindro.buscarLlenadoCilindro(buscar1);
                    request.setAttribute("listallenadoscilindros", listaLlenadoCilindros);
                }
                    request.setAttribute("listallenados", listallenados);
                
                request.getRequestDispatcher("IndexLlenado.jsp").forward(request, response);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlLlenado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlLlenado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlLlenado.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlLlenado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlLlenado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlLlenado.class.getName()).log(Level.SEVERE, null, ex);
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