import dao.DAOCilindro;
import dao.DAODevolucion;
import dao.DAODevolucionCilindro;
import dao.DAOPrestamo;
import dao.DAOPrestamoCilindro;
import dao.DAOUsuario;
import dto.DTOCilindro;
import dto.DTODevolucion;
import dto.DTODevolucionCilindro;
import dto.DTOPrestamo;
import dto.DTOPrestamoCilindro;
import dto.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(urlPatterns = {"/ControlPrestamo"})
public class ControlPrestamo extends HttpServlet {

    DAOPrestamo daoPrestamo = new DAOPrestamo();
    DTOPrestamo dtoPrestamo = new DTOPrestamo();
    DAOUsuario daoUsuario = new DAOUsuario();

    DTOCilindro dtoCilindro = new DTOCilindro();
    DAOCilindro daoCilindro = new DAOCilindro();

    DTODevolucion dtoDevolucion = new DTODevolucion();
    DAODevolucion daoDevolucion = new DAODevolucion();
    DAODevolucionCilindro daoDevolucionCilindro = new DAODevolucionCilindro();
    DTODevolucionCilindro dtoDevolucionCilindro = new DTODevolucionCilindro();

    DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro();
    DAOPrestamoCilindro daoPrestamoCilindro = new DAOPrestamoCilindro();

    List<String> listaCilindrosDevolver;
    List<Integer> cantidades = new ArrayList<Integer>();
    int Prestamo;

    /* Lista de cilindros prestados actualmente*/
    List<DTODevolucionCilindro> ListaCilindrosPrestadostodavia = new ArrayList<DTODevolucionCilindro>();

    String DocumentoEmpleado;
    List<DTOCilindro> listaCilindros;
    List<DTOPrestamoCilindro> listaPrestamoCilindro = new ArrayList<DTOPrestamoCilindro>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, SQLException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

//            verificar si hay una sesion iniciada
            try {
                HttpSession sesion = request.getSession();
                DocumentoEmpleado = (String) sesion.getAttribute("user").toString();
            } catch (Exception e) {
                String caso = "12";
                request.setAttribute("caso", caso);
                request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
            }
            
            String buscar = request.getParameter("buscar");
            String accion = request.getParameter("accion");
            List<DTOPrestamoCilindro> listaPrestados = daoPrestamoCilindro.ListaCilindrosPrestados();
            
            if (accion != null) {
                switch (accion) {
                    case "listas":
                        listaCilindros = new ArrayList<DTOCilindro>();//Lista de Cilindros que estan asociados a un prestamo
                        Prestamo = Integer.parseInt(request.getParameter("Prestamo"));//Codigo del prestamo enviado por url que nos permite buscar los cilindros de este prestamo

                        listaPrestamoCilindro = daoPrestamoCilindro.mostrarPrestamoCilindroxCodigoPrestamo(Prestamo);//Lista de cilindros por codigo de pretamo solo me retorna codigo de prestamo (que en teoria seria seria el mismo en todas las pocisiones del CodPrestamo), tambien me retorna el codigo del cilindro que es el que necesitamos y la cantidad de cilindros preestados en un principio recien se  registro el prestamo

                        for (int i = 0; i < listaPrestamoCilindro.size(); i++) {//Bucle para llenar la lista de cilindros con los datos de Capacidad, Empresa, Precio etc de un cilindro ya que con el objeto anterior "listaPrestamoCilindro" no trae esos datos
                            listaCilindros.add(dtoCilindro = daoCilindro.buscarCilindro(listaPrestamoCilindro.get(i).getCodCilindro()));
                        }

                        ListaCilindrosPrestadostodavia = daoDevolucionCilindro.ListaCilindrosPrestadostodavia(Integer.toString(Prestamo));//Este Objeto sirve para traer la cantidad de cilindros que aun estan prestados ya que hay que hacer una resta en la consulta y ningun objeto anterior los trae

                        if (ListaCilindrosPrestadostodavia.size() > 0) {//si la lista de los cilindros prestados es mayor a 0 
                            int j = 0;//entre al bucle para insertar la cantidad de cilindros aun prestados en el codgio correcto.
                            for (int i = 0; j < ListaCilindrosPrestadostodavia.size(); i++) {
                                if (listaPrestamoCilindro.get(i).getCodCilindro() == Integer.parseInt(ListaCilindrosPrestadostodavia.get(j).getCodCilindros())) {
                                    listaPrestamoCilindro.get(i).setCantidad(ListaCilindrosPrestadostodavia.get(i).getCantidad());
                                    j++;
                                }
                            }
                        }

                        request.setAttribute("listaCilindrosPrestados", listaCilindros);
                        request.setAttribute("listaPrestamoCilindro", listaPrestamoCilindro);

                        request.getRequestDispatcher("Devolver.jsp").forward(request, response);
                        break;

                    case "Devolver":
                        listaCilindrosDevolver = new ArrayList<String>();
                        request.getRequestDispatcher("ControlPrestamo?accion=listas").forward(request, response);
                        break;

                    case "anadir":
                        String codigo = request.getParameter("codCilindro");
                        boolean repetido = false;

                        if (listaCilindrosDevolver.size() > 0) {
                            for (int i = 0; i < listaCilindrosDevolver.size(); i++) {
                                if (codigo.equals(listaCilindrosDevolver.get(i))) {
                                    repetido = true;
                                }
                            }
                            if (repetido) {
                                String caso = "11";
                                request.setAttribute("caso", caso);
                                request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                            } else {
                                listaCilindrosDevolver.add(codigo);
                            }
                        } else {
                            listaCilindrosDevolver.add(codigo);
                        }
                        request.setAttribute("contador", listaCilindrosDevolver.size());
                        request.getRequestDispatcher("ControlPrestamo?accion=listas").forward(request, response);
                        break;

                    case "regresarmensaje":
                        request.setAttribute("contador", listaCilindrosDevolver.size());
                        request.getRequestDispatcher("ControlPrestamo?accion=listas&Prestamo=" + Prestamo + "").forward(request, response);//                        

//                        request.getRequestDispatcher("ControlPrestamo?accion=Devolver&Prestamo=" + Prestamo + "").forward(request, response);//                        
                        break;

                    case "regresarmensaje2":
//                        request.getRequestDispatcher("ControlPrestamo?accion=Devolver&Prestamo=" + Prestamo + "").forward(request, response);//                        
                        if (buscar == null) {
                            buscar = "";
                            List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar);
                            request.setAttribute("ListaPrestamos", listaPrestamos);
                        } else {
                            List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar);
                            request.setAttribute("ListaPrestamos", listaPrestamos);
                        }
                        request.setAttribute("ListaPrestados", listaPrestados);
                        request.getRequestDispatcher("IndexPrestamo.jsp").forward(request, response);
                        break;
                    case "inicializar":
                        if (listaCilindrosDevolver.size() < 1) {
                            String caso = "15";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            cantidades = new ArrayList<Integer>();
                            request.getRequestDispatcher("ControlPrestamo?accion=confirmar").forward(request, response);
                        }

                        break;

                    case "confirmar":// arreglar doble bucle
                        //Ordernar arreglo
                        if (listaCilindrosDevolver.size() > 1) {
                            int pos, aux;
                            for (int i = 0; i < listaCilindrosDevolver.size(); i++) {
                                pos = i;
                                aux = Integer.parseInt(listaCilindrosDevolver.get(i));

                                while ((pos > 0) && (Integer.parseInt(listaCilindrosDevolver.get(pos - 1)) > aux)) {
                                    listaCilindrosDevolver.set(pos, listaCilindrosDevolver.get(pos - 1));
                                    pos--;
                                }
                                listaCilindrosDevolver.set(pos, Integer.toString(aux));
                            }
                        }

                        int j = 0;
                        for (int i = 0; j < listaCilindrosDevolver.size(); i++) {
                            if (listaPrestamoCilindro.get(i).getCodCilindro() == Integer.parseInt(listaCilindrosDevolver.get(j))) {
                                cantidades.add(listaPrestamoCilindro.get(i).getCantidad());
                                j++;
                            }
                        }

                        request.setAttribute("listaCilindrosDevolver", listaCilindrosDevolver);
                        request.setAttribute("listaCilindrosPrestados", listaCilindros);
                        request.setAttribute("listaPrestamoCilindro", listaPrestamoCilindro);
                        request.setAttribute("cantidades", cantidades);
                        request.getRequestDispatcher("ConfirmarDevolucion.jsp").forward(request, response);

                        break;

                    //case para actualizar la cantidad en el input, cantidad de cilindros que quiere devolver
                    case "ActualizarCantidad":
                        int CodigoCilindro = Integer.parseInt(request.getParameter("CodCilindro"));
                        int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                        for (int i = 0; i < listaCilindrosDevolver.size(); i++) {
                            if (Integer.parseInt(listaCilindrosDevolver.get(i)) == CodigoCilindro) {
                                cantidades.set(i, cantidad);
                            }
                        }
                        break;

                    case "Listo":
                        /*Registrar Devolucion en tbldevolucion                   
                         */
                        String InsertarPrestamo = Integer.toString(Prestamo);
                        dtoDevolucion = new DTODevolucion(0, InsertarPrestamo, DocumentoEmpleado, "");
                        if (daoDevolucion.registrarDevolucion(dtoDevolucion)) {
                            String ultimo_insertado = daoDevolucion.ultimo_insertado();
                            for (int i = 0; i < listaCilindrosDevolver.size(); i++) {
                                dtoDevolucionCilindro = new DTODevolucionCilindro(ultimo_insertado, listaCilindrosDevolver.get(i), cantidades.get(i));
                                dtoCilindro = new DTOCilindro();
                                dtoCilindro = daoCilindro.buscarCilindro(Integer.parseInt(listaCilindrosDevolver.get(i)));
                                dtoCilindro.setCilindros_Prestados(dtoCilindro.getCilindros_Prestados() - cantidades.get(i));
                                dtoCilindro.setCilindros_Vacios(dtoCilindro.getCilindros_Vacios() + cantidades.get(i));
                                if ((daoCilindro.modificarCilindro(dtoCilindro) == false) || (daoDevolucionCilindro.registrarDevolucionIntermedia(dtoDevolucionCilindro) == false)) {
                                    String caso = "13";
                                    request.setAttribute("caso", caso);
                                    request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                                }
                            }
                        } else {
                            String caso = "13";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        String caso = "14";
                        request.setAttribute("caso", caso);
                        request.getRequestDispatcher("Mensajes.jsp").forward(request, response);

                        break;
                    case "cancelar":
                        listaCilindrosDevolver = new ArrayList<String>();
                        listaCilindros = new ArrayList<DTOCilindro>();
                        listaPrestamoCilindro = new ArrayList<DTOPrestamoCilindro>();
                        cantidades = new ArrayList<Integer>();
                        ListaCilindrosPrestadostodavia = new ArrayList<DTODevolucionCilindro>();
                        if (buscar == null) {
                            buscar = "";
                            List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar);
                            request.setAttribute("ListaPrestamos", listaPrestamos);
                        } else {
                            List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar);
                            request.setAttribute("ListaPrestamos", listaPrestamos);
                        }
                        
                        request.setAttribute("ListaPrestados", listaPrestados);
                        request.getRequestDispatcher("IndexPrestamo.jsp").forward(request, response);

                        break;
                    case "confirmarlista":
                        if (listaCilindrosDevolver.size() == 0) {
                            caso = "16";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("ControlPrestamo?accion=confirmar").forward(request, response);
                        }
                        break;
                    case "Delete":
                        String CodCilindro = request.getParameter("CodigoCilindro");
                        for (int i = 0; i < listaCilindrosDevolver.size(); i++) {
                            if (CodCilindro.equals(listaCilindrosDevolver.get(i))) {
                                listaCilindrosDevolver.remove(i);
                                cantidades.remove(i);
                            }
                        }
                        break;
                }
            } else {
                if (buscar == null) {
                    buscar = "";
                    List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar);
                     request.setAttribute("ListaPrestamos", listaPrestamos);
                } else {
                    List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar);
                    request.setAttribute("ListaPrestamos", listaPrestamos);
                }
                request.setAttribute("ListaPrestados", listaPrestados);
           
                request.getRequestDispatcher("IndexPrestamo.jsp").forward(request, response);
            }

//            String id = request.getParameter("id");
//            String accion = request.getParameter("button");
//            String codigo = request.getParameter("codigo");
//            String buscar1 = request.getParameter("buscar");
//            
//            List<DTOUsuario> listaUsuarios = daoUsuario.mostrarUsuarios();
//                request.setAttribute("listaUsuarios", listaUsuarios);
//            if(buscar1==null){
//                buscar1="";
//                List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar1);
//                request.setAttribute("ListaPrestamos", listaPrestamos);
//            }else{
//                List<DTOPrestamo> listaPrestamos = daoPrestamo.buscarLike(buscar1);
//                request.setAttribute("ListaPrestamos", listaPrestamos);
//            }   
//            if (id!=null) {
//                int eliminar = Integer.parseInt(id);
//                daoPrestamo.eliminarPrestamo(eliminar);
//                
//            } else{
//                if (codigo!=null) {
//                    int buscar = Integer.parseInt(codigo);
//                        dtoPrestamo = daoPrestamo.buscarPrestamo(buscar);
//                        request.setAttribute("dtoPrestamo", dtoPrestamo);
//                        request.getRequestDispatcher("CRUDprestamo.jsp").forward(request, response);
//                    }
//                else{
//                    if(accion.equals("Registrar")){
//                        String doccliente = request.getParameter("doccliente");
//                        String docempleado = request.getParameter("docempleado");
//                        String fechaprestamo = request.getParameter("fechapedido");
//                        String fechaentrega = request.getParameter("fechaentrega");
//                        String nombredestinatario = request.getParameter("nombredestinatario");
//                        String documentodestinatario = request.getParameter("documentodestinatario");
//
//
//
//                    dtoPrestamo = new DTOPrestamo(0,doccliente, docempleado, fechaprestamo, fechaentrega, nombredestinatario, documentodestinatario);
//
//                    daoPrestamo.registrarPrestamo(dtoPrestamo);
//                    }else{
//                        if(accion.equals("Modificar")){
//                            int Codigo1 = Integer.parseInt(request.getParameter("Codigo"));
//                            String doccliente = request.getParameter("doccliente");
//                        String docempleado = request.getParameter("docempleado");
//                        String fechaprestamo = request.getParameter("fechapedido");
//                        String fechaentrega = request.getParameter("fechaentrega");
//                        String nombredestinatario = request.getParameter("nombredestinatario");
//                        String documentodestinatario = request.getParameter("documentodestinatario");
//                            
//                            dtoPrestamo = new DTOPrestamo(Codigo1,doccliente, docempleado, fechaprestamo, fechaentrega, nombredestinatario, documentodestinatario);
//
//                            daoPrestamo.actualizarPrestamo(dtoPrestamo);
//                        }
//                    }
//                    
//                }
//            }
//case "anadir":
//                        String codigo = request.getParameter("codCilindro");
//                        if (listaCilindrosDevolver.size() > 0) {
//                            for (int i = 0; i < listaCilindrosDevolver.size(); i++) {
//                                if (listaCilindrosDevolver.get(i).toString() != codigo) {
//                                    listaCilindrosDevolver.add(codigo);
//                                }else{
//                                    String caso = "11";
//                                    request.getRequestDispatcher("Mensajes.jsp?caso='"+caso+"'").forward(request, response);
//                                }
//                            }
//                        }else{
//                            listaCilindrosDevolver.add(codigo);
//                        }
//                        
//                        out.print(listaCilindrosDevolver.size());
//                        request.setAttribute("contador", listaCilindrosDevolver.size());                        
//                        request.getRequestDispatcher("ControlPrestamo?accion=Devolver").forward(request, response);
//                        break;
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
            Logger.getLogger(ControlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
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