
import Email.EmailSender;
import com.itextpdf.text.Chunk;
import dao.DAOCilindro;
import dao.DAOPedido;
import dto.DTOCilindro;
import dao.DAOEmpresa;
import dao.DAOPedido_Cilindro;
import dao.DAOPrestamo;
import dao.DAOPrestamoCilindro;
import dao.DAOUsuario;
import dto.DTOCarrito;
import dto.DTOEmpresa;
import dto.DTOPedido;
import dto.DTOPedido_Cilindro;
import dto.DTOPrestamo;
import dto.DTOPrestamoCilindro;
import dto.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(urlPatterns = {"/ControlCilindro"})
public class ControlCilindro extends HttpServlet {

    DTOCilindro dtoCilindro = new DTOCilindro();
    DAOCilindro daoCilindro = new DAOCilindro();
    DAOEmpresa daoEmpresa = new DAOEmpresa();
    DTOUsuario dtoUsuario = new DTOUsuario();
    DAOUsuario daoUsuario = new DAOUsuario();
    DTOPedido dtoPedido = new DTOPedido();
    DAOPedido daoPedido = new DAOPedido();
    DTOPrestamo dtoPrestamo = new DTOPrestamo();
    DAOPrestamo daoPrestamo = new DAOPrestamo();
    DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro();
    DAOPrestamoCilindro daoPrestamoCilindro = new DAOPrestamoCilindro();
    DAOPedido_Cilindro daoPedido_Cilindro = new DAOPedido_Cilindro();
    DTOPedido_Cilindro dtoPedido_Cilindro = new DTOPedido_Cilindro();

    int item;
    List<DTOCarrito> listaCarrito = new ArrayList<>();
    double totalPagar = 0.0;
    
    String DocumentoEmpleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, SQLException, IllegalAccessException, MessagingException {
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
            String accion = request.getParameter("accion");

            List<DTOCilindro> ListaCilindros = daoCilindro.mostrarCilindro();
            List<DTOEmpresa> listaempresas = daoEmpresa.mostrarEmpresa();
            List<DTOUsuario> listaUsu = daoUsuario.mostrarUsuarios();

            int codigo;

            if (accion != null) {

                switch (accion) {
                    case "Seleccionar":

                        List<DTOEmpresa> listaEmpresas = daoEmpresa.mostrarEmpresa();
                        request.setAttribute("Listaempresas", listaEmpresas);

                        int codigoA = Integer.parseInt(request.getParameter("codigoA"));
                        dtoCilindro = daoCilindro.buscarCilindro(codigoA);
                        request.setAttribute("dtoCilindro", dtoCilindro);
                        request.getRequestDispatcher("CRUDcilindro.jsp").forward(request, response);

                        break;
                    case "Registrar":
                        String nit = request.getParameter("nit");
                        int Capacidad = Integer.parseInt(request.getParameter("capacidad"));
                        int Precio = Integer.parseInt(request.getParameter("precio"));

                        dtoCilindro = new DTOCilindro(0, Capacidad, Precio, nit, 0, 0, 0);
                        if (daoCilindro.registrarCilindro(dtoCilindro)) {
                            String caso = "9";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "10";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }

                        break;

                    case "Modificar":

                        nit = request.getParameter("nit");
                        codigo = Integer.parseInt(request.getParameter("codigo"));
                        Capacidad = Integer.parseInt(request.getParameter("capacidad"));
                        Precio = Integer.parseInt(request.getParameter("precio"));

                        dtoCilindro = new DTOCilindro(codigo, Capacidad, Precio, nit, 0, 0, 0);

                        if (daoCilindro.modificarCilindro(dtoCilindro)) {
                            String caso = "33";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        } else {
                            String caso = "25";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }

                        break;

                    case "Modificado":
                        nit = request.getParameter("nit");
                        codigo = Integer.parseInt(request.getParameter("codigo"));
                        Capacidad = Integer.parseInt(request.getParameter("capacidad"));
                        Precio = Integer.parseInt(request.getParameter("precio"));
                        int Cilindros_llenos = Integer.parseInt(request.getParameter("Cilindros_llenos"));

                        dtoCilindro = new DTOCilindro(codigo, Capacidad, Precio, nit, Cilindros_llenos, 0, 0);
                        daoCilindro.modificarCilindro(dtoCilindro);
                        break;
                    case "comprar":
                        request.setAttribute("ListaCilindros", ListaCilindros);
                        request.getRequestDispatcher("Carrito_Compras.jsp").forward(request, response);

                        break;
                    case "Agregar":
                        int pos = 0;
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        codigo = Integer.parseInt(request.getParameter("codigo"));
                        dtoCilindro = daoCilindro.buscarCilindro(codigo);
                        if (listaCarrito.size() > 0) {
                            for (int i = 0; i < listaCarrito.size(); i++) {
                                if (codigo == listaCarrito.get(i).getCodigo()) {
                                    pos = i;
                                }
                            }

                            if (codigo == listaCarrito.get(pos).getCodigo()) {
                                cantidad += listaCarrito.get(pos).getCantidad();
                                double subtotal = listaCarrito.get(pos).getPrecio() * cantidad;
                                listaCarrito.get(pos).setCantidad(cantidad);
                                listaCarrito.get(pos).setSubTotal(subtotal);
//                                    for (int i = 0; i < ListaCilindros.size(); i++) {
//                                        if (ListaCilindros.get(i).getCodigo()==codigo) {
//                                           Cilindros_llenos=ListaCilindros.get(i).getCilindros_llenos();
//                                           ListaCilindros.get(i).setCilindros_llenos(Cilindros_llenos-cantidad);
//                                        }
//                                    }

                            } else {
                                item = item + 1;
                                DTOCarrito car = new DTOCarrito();
                                car.setItem(item);
                                car.setCodigo(dtoCilindro.getCodigo());
                                car.setCapacidad(dtoCilindro.getCapacidad());
                                car.setPrecio(dtoCilindro.getPrecio());
                                car.setEmpresa(dtoCilindro.getEmpresa());
                                car.setCantidad(cantidad);
                                car.setSubTotal(dtoCilindro.getPrecio() * cantidad);
                                listaCarrito.add(car);
                            }
                        } else {
                            item = item + 1;
                            DTOCarrito car = new DTOCarrito();
                            car.setItem(item);
                            car.setCodigo(dtoCilindro.getCodigo());
                            car.setCapacidad(dtoCilindro.getCapacidad());
                            car.setPrecio(dtoCilindro.getPrecio());
                            car.setEmpresa(dtoCilindro.getEmpresa());
                            car.setCantidad(cantidad);
                            car.setSubTotal(dtoCilindro.getPrecio() * cantidad);
                            listaCarrito.add(car);
                        }

                        request.setAttribute("contador", listaCarrito.size());
                        request.getRequestDispatcher("ControlCilindro?accion=comprar").forward(request, response);
                        break;
                    case "Delete":
                        int idLote = Integer.parseInt(request.getParameter("idl"));
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (listaCarrito.get(i).getCodigo() == idLote) {
                                listaCarrito.remove(i);
                                out.print("eliminado");
                            }
                        }
                        break;
                    case "Carrito":
                        totalPagar = 0.0;
                        request.setAttribute("carrito", listaCarrito);
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            totalPagar += listaCarrito.get(i).getSubTotal();
                        }

                        request.setAttribute("ListaUsuarios", listaUsu);
                        request.setAttribute("totalPagar", totalPagar);
                        request.getRequestDispatcher("carrito.jsp").forward(request, response);

                        break;
                    case "ActualizarCantidad":
                        int idl = Integer.parseInt(request.getParameter("idl"));
                        int cant = Integer.parseInt(request.getParameter("Cantidad"));
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (listaCarrito.get(i).getCodigo() == idl) {
                                listaCarrito.get(i).setCantidad(cant);
                                double st = listaCarrito.get(i).getPrecio() * cant;
                                listaCarrito.get(i).setSubTotal(st);
                            }
                        }
                        break;
                    case "regresarmensaje":
                        listaCarrito = new ArrayList<>();
                        request.setAttribute("ListaCilindros", ListaCilindros);
                        request.setAttribute("listaempresas", listaempresas);
                        request.getRequestDispatcher("IndexCilindro.jsp").forward(request, response);
                        break;
                    case "HacerPedido":

                        if (listaCarrito.size() < 1) {
                            out.print("Agregue un producto al carrito");
                        } else {
                            //Recoger Datos de la vista
                            String doccliente = request.getParameter("doccliente");
                            String docempleado = request.getParameter("docempleado");
                            String nombredestinatario = request.getParameter("nombredestinatario");
                            if (nombredestinatario == "") {
                                nombredestinatario = null;
                            }
                            String documentodestinatario = request.getParameter("documentodestinatario");
                            if (documentodestinatario == "") {
                                documentodestinatario = null;
                            }
                            int ValorDomicilio = Integer.parseInt(request.getParameter("ValorDomicilio"));
//
                            //hora y fecha local
                            Date Sistfecha = new Date();
                            SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                            String pmAm = "HH:mm:ss";
                            SimpleDateFormat format = new SimpleDateFormat(pmAm);
                            String Hoy = formato.format(Sistfecha) + " " + format.format(Sistfecha);

                            //Fecha Entrega
                            String HoraEntrega = ":mm:ss";
                            int hora = Sistfecha.getHours() + 1;
                            format = new SimpleDateFormat(HoraEntrega);
                            String FechaEntrega = formato.format(Sistfecha) + " " + hora + format.format(Sistfecha);

                            DTOPedido dtoPedido = new DTOPedido(0, doccliente, docempleado, Hoy, FechaEntrega, nombredestinatario, documentodestinatario, ValorDomicilio);//con llaves foranes es decir con documentos que obligatoriamente esten en tblusuario        
                            daoPedido.registrarPedido(dtoPedido);

                            int codigo_insertado = daoPedido.ultimo_insertado();
//
                            for (int i = 0; i < listaCarrito.size(); i++) {

                                dtoPedido_Cilindro = new DTOPedido_Cilindro(codigo_insertado, listaCarrito.get(i).getCodigo(), listaCarrito.get(i).getCantidad());
                                daoPedido_Cilindro.registrarPedido_Cilindro(dtoPedido_Cilindro);

                                dtoCilindro = new DTOCilindro();
                                dtoCilindro = daoCilindro.buscarCilindro(listaCarrito.get(i).getCodigo());

                                dtoCilindro.setCilindros_Vacios(listaCarrito.get(i).getCantidad() + dtoCilindro.getCilindros_Vacios());
                                dtoCilindro.setCilindros_llenos(dtoCilindro.getCilindros_llenos() - listaCarrito.get(i).getCantidad());
                                daoCilindro.modificarCilindro(dtoCilindro);
                            }

                            /*Factura*/
                            Document documento = new Document();

                            //Datos del Usuario para la Factura
                            dtoUsuario = daoUsuario.buscarUsuario(doccliente);

                            try {

                                String ruta = System.getProperty("user.home");

                                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/Factura_N°" + codigo_insertado + ".pdf"));

                                Image header = Image.getInstance("C:/Users/user/Documents/NetBeansProjects/Miproyecto2244220/Factura/imagen.png");
                                header.scaleToFit(75, 75);
                                header.setAbsolutePosition(50, 760);
                                header.setAlignment(Chunk.ALIGN_CENTER);

                                Paragraph parrafo = new Paragraph();
                                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo.setFont(FontFactory.getFont("arial", 18));

                                parrafo.add("Comprobante de Venta\n\n");
                                parrafo.setFont(FontFactory.getFont("arial", 18, BaseColor.RED));
                                parrafo.add(" N° " + codigo_insertado + "\n\n\n");
                                parrafo.setFont(FontFactory.getFont("arial", 16));
                                parrafo.add("Fecha: " + formato.format(Sistfecha));
                                parrafo.add("     Nit: 107634-3");
                                parrafo.add("     Dirección: Carrera 32# 89-54\n\n");
                                parrafo.add("Comprador: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos());
                                parrafo.add("          C.C: " + dtoUsuario.getDocumento() + "\n\n");
                                parrafo.add("Direccion: " + dtoUsuario.getDireccion());
                                parrafo.add("      Telefono: " + dtoUsuario.getTelefono() + "\n\n\n");

                                PdfPTable tablaPedido = new PdfPTable(5);
                                tablaPedido.setWidthPercentage(100);

                                PdfPCell Celda_Cantidad = new PdfPCell(new Phrase("Cantidad"));
                                Celda_Cantidad.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Capacidad = new PdfPCell(new Phrase("Capacidad LBS"));
                                Celda_Capacidad.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Empresa = new PdfPCell(new Phrase("Empresa"));
                                Celda_Empresa.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Valor = new PdfPCell(new Phrase("Valor Unitario"));
                                Celda_Valor.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Total = new PdfPCell(new Phrase("Valor Total"));
                                Celda_Total.setBackgroundColor(BaseColor.GRAY);

                                tablaPedido.addCell(Celda_Cantidad);
                                tablaPedido.addCell(Celda_Capacidad);
                                tablaPedido.addCell(Celda_Empresa);
                                tablaPedido.addCell(Celda_Valor);
                                tablaPedido.addCell(Celda_Total);

                                int Total_Pagar = 0;

                                for (int i = 0; i < listaCarrito.size(); i++) {
                                    dtoCilindro = daoCilindro.buscarCilindroNombreEmpresa(listaCarrito.get(i).getCodigo());
                                    tablaPedido.addCell(Integer.toString(listaCarrito.get(i).getCantidad()));
                                    tablaPedido.addCell("Pipeta " + dtoCilindro.getCapacidad() + "Lbs");
                                    tablaPedido.addCell(dtoCilindro.getEmpresa());
                                    tablaPedido.addCell(Integer.toString(dtoCilindro.getPrecio()));
                                    tablaPedido.addCell(Integer.toString(dtoCilindro.getPrecio() * listaCarrito.get(i).getCantidad()));
                                    Total_Pagar += (dtoCilindro.getPrecio() * listaCarrito.get(i).getCantidad());
                                }

                                Paragraph Total = new Paragraph();
                                Total.setAlignment(Paragraph.ALIGN_RIGHT);
                                Total.setFont(FontFactory.getFont("arial", 18, Font.BOLD));
                                Total.add("Total a Pagar: " + Total_Pagar);

                                Paragraph Firmas = new Paragraph();
                                Firmas.setAlignment(Paragraph.ALIGN_CENTER);
                                Firmas.setFont(FontFactory.getFont("arial", 16));
                                Firmas.add("\n\nFirma Comprador:                                        Firma Venderdor:\n\n");
                                Firmas.add("    __________________                                   __________________");

                                documento.open();
                                documento.add(parrafo);
                                documento.add(header);
                                documento.add(tablaPedido);
                                documento.add(Total);
                                documento.add(Firmas);

                                documento.close();

                            } catch (DocumentException | FileNotFoundException e) {
                                out.println("Error en PDF " + e);
                            } catch (IOException e) {
                                out.println("Error en la imagen " + e);
                            }

                            /*Enviar Correo*/
                            dtoUsuario = daoUsuario.buscarUsuario(docempleado);
                            String Correo_Empleado = dtoUsuario.getEmail();

                            EmailSender enviarCorreo1 = new EmailSender();
                            String remitente = "mateoandrescastrillonpuerta987@gmail.com";
                            String destinatario = Correo_Empleado;
                            String clave = "hijueputas";
                            String asunto = "Se ha asignado un domicilio";

                            dtoUsuario = daoUsuario.buscarUsuario(doccliente);

                            String cuerpo = "Se ha hecho un pedido Para: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos() + " Identificado con la cedula: " + dtoUsuario.getDocumento() + " .El domicilio se ha hecho para: " + dtoUsuario.getDireccion();

//                            if (nombredestinatario == "" && documentodestinatario == "") {
//                                cuerpo = "Se ha hecho un pedido Para: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos() + " Identificado con la cedula: " + dtoUsuario.getDocumento() + " .El domicilio se ha hecho para: " + dtoUsuario.getDireccion();
//                            } else if (nombredestinatario == "") {
//                                cuerpo = "Se ha hecho un pedido Para: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos() + " Identificado con la cedula: " + dtoUsuario.getDocumento() + " .El domicilio se ha hecho para: " + dtoUsuario.getDireccion()+", el pedido lo recibira una persona identificada con el numero: "+documentodestinatario;
//
//                            }else if (documentodestinatario == "") {
//                                cuerpo = "Se ha hecho un pedido Para: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos() + " Identificado con la cedula: " + dtoUsuario.getDocumento() + " .El domicilio se ha hecho para: " + dtoUsuario.getDireccion()+", el pedido lo recibira una persona llamada "+nombredestinatario;
//
//                            }else{
//                                cuerpo = "Se ha hecho un pedido Para: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos() + " Identificado con la cedula: " + dtoUsuario.getDocumento() + " .El domicilio se ha hecho para: " + dtoUsuario.getDireccion()+", el pedido lo recibira una persona llamada "+nombredestinatario+" identificada con el numero: "+documentodestinatario;
//
//                            }
                            enviarCorreo1.sendEmailSender(remitente, destinatario, clave, asunto, cuerpo);

                            /*Mensaje*/
                            String caso = "19";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);

                        }

                        break;
                    case "HacerPrestamo":

                        if (listaCarrito.size() < 1) {
                            out.print("Agregue un producto al carrito");
                        } else {
                            //Recoger Datos de la vista
                            String doccliente = request.getParameter("doccliente");
                            String docempleado = request.getParameter("docempleado");

                            String nombredestinatario = request.getParameter("nombredestinatario");
                            String documentodestinatario = request.getParameter("documentodestinatario");

                            int ValorDomicilio = Integer.parseInt(request.getParameter("ValorDomicilio"));

                            //hora y fecha local
                            Date Sistfecha = new Date();
                            SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                            String pmAm = "HH:mm:ss";
                            SimpleDateFormat format = new SimpleDateFormat(pmAm);
                            String Hoy = formato.format(Sistfecha) + " " + format.format(Sistfecha);

                            //Fecha Entrega
                            String HoraEntrega = ":mm:ss";
                            int hora = Sistfecha.getHours() + 1;
                            format = new SimpleDateFormat(HoraEntrega);
                            String FechaEntrega = formato.format(Sistfecha) + " " + hora + format.format(Sistfecha);

                            if (documentodestinatario == "" || nombredestinatario == "") {
                                DTOPrestamo dtoPrestamo = new DTOPrestamo(0, doccliente, docempleado, Hoy, FechaEntrega, nombredestinatario, documentodestinatario, ValorDomicilio);
                                daoPrestamo.registrarPrestamo2(dtoPrestamo);
                            } else {
                                DTOPrestamo dtoPrestamo = new DTOPrestamo(0, doccliente, docempleado, Hoy, FechaEntrega, nombredestinatario, documentodestinatario, ValorDomicilio);
                                daoPrestamo.registrarPrestamo(dtoPrestamo);
                            }

                            int codigo_insertado = daoPrestamo.ultimo_insertado();
                            for (int i = 0; i < listaCarrito.size(); i++) {
                                dtoPrestamoCilindro = new DTOPrestamoCilindro(codigo_insertado, listaCarrito.get(i).getCodigo(), listaCarrito.get(i).getCantidad());
                                daoPrestamoCilindro.registrarPrestamoCilindro(dtoPrestamoCilindro);
                                DTOCilindro dtoCilindro = new DTOCilindro();
                                dtoCilindro = daoCilindro.buscarCilindro(listaCarrito.get(i).getCodigo());
                                dtoCilindro.setCilindros_Prestados(listaCarrito.get(i).getCantidad() + dtoCilindro.getCilindros_Prestados());
                                dtoCilindro.setCilindros_llenos(dtoCilindro.getCilindros_llenos() - listaCarrito.get(i).getCantidad());
                                dtoCilindro.setCapacidad(dtoCilindro.getCapacidad());
                                daoCilindro.modificarCilindro(dtoCilindro);
                            }

                            /*Factura*/
                            Document documento = new Document();

                            //Datos del Usuario para la Factura
                            dtoUsuario = daoUsuario.buscarUsuario(doccliente);

                            try {

                                String ruta = System.getProperty("user.home");

                                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/Factura-Prestamo_N°" + codigo_insertado + ".pdf"));

                                Image header = Image.getInstance("C:/Users/user/Documents/NetBeansProjects/Miproyecto2244220/Factura/imagen.png");
                                header.scaleToFit(75, 75);
                                header.setAbsolutePosition(50, 760);
                                header.setAlignment(Chunk.ALIGN_CENTER);

                                Paragraph parrafo = new Paragraph();
                                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo.setFont(FontFactory.getFont("arial", 18));

                                parrafo.add("Comprobante de Prestamo\n\n");
                                parrafo.setFont(FontFactory.getFont("arial", 18, BaseColor.RED));
                                parrafo.add(" N° " + codigo_insertado + "\n\n\n");
                                parrafo.setFont(FontFactory.getFont("arial", 16));
                                parrafo.add("Fecha: " + formato.format(Sistfecha));
                                parrafo.add("     Nit: 107634-3");
                                parrafo.add("     Dirección: Carrera 32# 89-54\n\n");
                                parrafo.add("Comprador: " + dtoUsuario.getNombres() + " " + dtoUsuario.getApellidos());
                                parrafo.add("          C.C: " + dtoUsuario.getDocumento() + "\n\n");
                                parrafo.add("Direccion: " + dtoUsuario.getDireccion());
                                parrafo.add("      Telefono: " + dtoUsuario.getTelefono() + "\n\n\n");

                                PdfPTable tablaPedido = new PdfPTable(5);
                                tablaPedido.setWidthPercentage(100);

                                PdfPCell Celda_Cantidad = new PdfPCell(new Phrase("Cantidad"));
                                Celda_Cantidad.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Capacidad = new PdfPCell(new Phrase("Capacidad LBS"));
                                Celda_Capacidad.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Empresa = new PdfPCell(new Phrase("Empresa"));
                                Celda_Empresa.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Valor = new PdfPCell(new Phrase("Valor Unitario"));
                                Celda_Valor.setBackgroundColor(BaseColor.GRAY);
                                PdfPCell Celda_Total = new PdfPCell(new Phrase("Valor Total"));
                                Celda_Total.setBackgroundColor(BaseColor.GRAY);

                                tablaPedido.addCell(Celda_Cantidad);
                                tablaPedido.addCell(Celda_Capacidad);
                                tablaPedido.addCell(Celda_Empresa);
                                tablaPedido.addCell(Celda_Valor);
                                tablaPedido.addCell(Celda_Total);

                                int Total_Pagar = 0;

                                for (int i = 0; i < listaCarrito.size(); i++) {
                                    dtoCilindro = daoCilindro.buscarCilindroNombreEmpresa(listaCarrito.get(i).getCodigo());
                                    tablaPedido.addCell(Integer.toString(listaCarrito.get(i).getCantidad()));
                                    tablaPedido.addCell("Pipeta " + dtoCilindro.getCapacidad() + "Lbs");
                                    tablaPedido.addCell(dtoCilindro.getEmpresa());
                                    tablaPedido.addCell(Integer.toString(dtoCilindro.getPrecio()));
                                    tablaPedido.addCell(Integer.toString(dtoCilindro.getPrecio() * listaCarrito.get(i).getCantidad()));
                                    Total_Pagar += (dtoCilindro.getPrecio() * listaCarrito.get(i).getCantidad());
                                }

                                Paragraph Total = new Paragraph();
                                Total.setAlignment(Paragraph.ALIGN_RIGHT);
                                Total.setFont(FontFactory.getFont("arial", 18, Font.BOLD));
                                Total.add("Total a Pagar: " + Total_Pagar);

                                Paragraph Firmas = new Paragraph();
                                Firmas.setAlignment(Paragraph.ALIGN_CENTER);
                                Firmas.setFont(FontFactory.getFont("arial", 16));
                                Firmas.add("\n\nFirma Comprador:                                        Firma Venderdor:\n\n");
                                Firmas.add("    __________________                                   __________________");

                                documento.open();
                                documento.add(parrafo);
                                documento.add(header);
                                documento.add(tablaPedido);
                                documento.add(Total);
                                documento.add(Firmas);

                                documento.close();

                            } catch (DocumentException | FileNotFoundException e) {
                                out.println("Error en PDF " + e);
                            } catch (IOException e) {
                                out.println("Error en la imagen " + e);
                            }

                            String caso = "20";
                            request.setAttribute("caso", caso);
                            request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                        }
                        break;
                    default:

                }
            } else {

                request.setAttribute("ListaCilindros", ListaCilindros);
                request.setAttribute("listaempresas", listaempresas);
                request.getRequestDispatcher("IndexCilindro.jsp").forward(request, response);

            }

//            if (eliminar != null) {
//                int eliminar2 = Integer.parseInt(eliminar);
//                daoCilindro.eliminarCilindro(eliminar2);
//            } else {
//                if (modificar != null) {
//                    int modificar2 = Integer.parseInt(modificar);
//                    dtoCilindro = daoCilindro.buscarCilindro(modificar2);
//                    request.setAttribute("dtoCilindro", dtoCilindro);
//                    request.getRequestDispatcher("CRUDcilindro.jsp").forward(request, response);
//                } else {
//                    if (accion != null) {
//                        if (accion.equals("Registrar")) {
//                            String nit = request.getParameter("nit");
//                            int Capacidad = Integer.parseInt(request.getParameter("capacidad"));
//                            int Precio = Integer.parseInt(request.getParameter("precio"));
//
//                            dtoCilindro = new DTOCilindro(0, nit, Capacidad, Precio);
//                            daoCilindro.registrarCilindro(dtoCilindro);
//
//                        } else {
//                            if (accion.equals("Modificar")) {
//
//                                String nit = request.getParameter("nit");
//                                int codigo = Integer.parseInt(request.getParameter("codigo"));
//                                int Capacidad = Integer.parseInt(request.getParameter("capacidad"));
//                                int Precio = Integer.parseInt(request.getParameter("precio"));
//
//                                out.print(nit);
//                                out.print(codigo);
//                                out.print(Capacidad);
//                                out.print(Precio);
//
//                                dtoCilindro = new DTOCilindro(codigo, nit, Capacidad, Precio);
//                                daoCilindro.modificarCilindro(dtoCilindro);
//                            }
//                        }
//                    }
//
//                }
//            }
            /*$(document).ready(function(){
$('#submit').click(function(event){
var nombreVar=$('#nombre').val();

$.post('ActionServlet',{
    nombre:nombreVar
    
},function(responseText){
    
    $('#tabla').html(responseText);
});

});

});



<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-1.10.2.js"	type="text/javascript"></script>
<script src="app1.js" type="text/javascript"></script>
<form id="form1">
		Nombre:<input type="text" id="nombre" /> <br>
		Apellido: <input type="text" id="apellido" /> <br>
		Edad: <input type="text" id="edad" /> <br>
		<input type="button" id="submit" value="Añadir" /> 
	</form>
	<br>
	<!-- 	En este div metemos el contenido de la tabla con AJAX -->
	<div id="tabla"></div>
    </body>
</html>

String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");

		// Compruebo que los campos del formulario tienen datos para añadir a la tabla
		if (!nombre.equals("") && !apellido.equals("") && !edad.equals("")) {
			// Creo el objeto persona y lo añado al arrayList
			Persona persona = new Persona(nombre, apellido, edad);
			personas.add(persona);
		}

		out.println("<table style= cellspacing='1' bgcolor='#0099cc'>");
		out.println("<tr>");
		out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'> NOMBRE </td>");			
		out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>APELLIDO</td>");
		out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>EDAD</td>");
		out.println("</tr>");
		for(int i=0; i<personas.size(); i++){
			Persona persona = personas.get(i);
			out.println("<tr>");
			out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>"+persona.getNombre()+"</td>");			
			out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>"+persona.getApellido()+"</td>");
			out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>"+persona.getEdad()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");



public class Persona {
private String nombre;
	private String apellido;
	private String edad;

	public Persona(){
	}

	public Persona(String nombre, String apellido, String edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}    
}


$(document).ready(function(){
$('#submit').click(function(event){
var nombreVar=$('#nombre').val();
var apellidoVar=$('#apellido').val();
var edadVar=$('#edad').val();
$.post('ActionServlet',{
    nombre:nombreVar, apellido:apellidoVar,edad:edadVar
    
},function(responseText){
    
    $('#tabla').html(responseText);
});

});

});*/
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
        } catch (InstantiationException | SQLException | IllegalAccessException ex) {
            Logger.getLogger(ControlCilindro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ControlCilindro.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlCilindro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlCilindro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlCilindro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ControlCilindro.class.getName()).log(Level.SEVERE, null, ex);
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
