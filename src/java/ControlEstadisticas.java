/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import dao.DAOEstadisticas;
import dto.DTOEstadisticas;
import dto.DTORol;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
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

@WebServlet(urlPatterns = {"/ControlEstadisticas"})
public class ControlEstadisticas extends HttpServlet {

    int ParametroPrimeraConsulta = 10;

    String ParametroSegundaConsultaFechaInicial = "2000-01-01";
    String ParametroSegundaConsultaFechaFinal = "2100-01-01";

    int ParametroTerceraConsulta = 10;

    int ParametroCuartaConsulta = 10;

    String ParametroQuintaConsultaFechaInicial = "2000-01-01";
    String ParametroQuintaConsultaFechaFinal = "2100-01-01";

    String ParametroSextaConsultaFechaInicial = "2000-01-01";
    String ParametroSextaConsultaFechaFinal = "2100-01-01";

    int ParametroSeptimaConsulta = 10;
    int ParametroNovenaConsulta = 10;

    int ParametroDecimaConsulta = 24;
    int ParametroUndecimaConsulta = 7;

    String DocumentoEmpleado;

    private void GenerarPDF(List<DTOEstadisticas> Lista, String Nombre, String Encabezado, String Primera_Columna, String Segunda_Columna) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        if (Lista.size() > 0) {

            Document documento = new Document();
            String ruta = System.getProperty("user.home");

            /*Rute de descargas*/
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" + Nombre + ".pdf"));

            /*Imagen de la compañia*/
            Image Imagen = Image.getInstance("C:/Users/user/Documents/NetBeansProjects/Miproyecto2244220/Factura/imagen.png");
            Imagen.scaleToFit(75, 75);
            Imagen.setAbsolutePosition(50, 770);
            Imagen.setAlignment(Chunk.ALIGN_CENTER);

            /*Titulo*/
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.setFont(FontFactory.getFont("arial", 20));
            Titulo.add("" + Encabezado + "\n\n\n");

            /*Tabla de Reporte*/
            PdfPTable Tabla_Reporte = new PdfPTable(2);
            Tabla_Reporte.setWidthPercentage(100);

            PdfPCell Celda_Usuarios = new PdfPCell(new Phrase("                            " + Primera_Columna + ""));
            PdfPCell Celda_Cilindros = new PdfPCell(new Phrase("                   " + Segunda_Columna + ""));

            Tabla_Reporte.addCell(Celda_Usuarios);
            Tabla_Reporte.addCell(Celda_Cilindros);

            for (int i = 0; i < Lista.size(); i++) {
                Tabla_Reporte.addCell(Lista.get(i).getFecha());
                Tabla_Reporte.addCell(Integer.toString(Lista.get(i).getNumero_de_pedidos()));
            }

            /*Agregar todos los elementos al documento*/
            documento.open();
            documento.add(Imagen);
            documento.add(Titulo);
            documento.add(Tabla_Reporte);
            documento.close();

        }
    }

    private void GenerarPDF2(List<DTORol> Lista, String Nombre, String Encabezado, String Primera_Columna, String Segunda_Columna) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        if (Lista.size() > 0) {

            Document documento = new Document();
            String ruta = System.getProperty("user.home");

            /*Rute de descargas*/
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" + Nombre + ".pdf"));

            /*Imagen de la compañia*/
            Image Imagen = Image.getInstance("C:/Users/user/Documents/NetBeansProjects/Miproyecto2244220/Factura/imagen.png");
            Imagen.scaleToFit(75, 75);
            Imagen.setAbsolutePosition(50, 770);
            Imagen.setAlignment(Chunk.ALIGN_CENTER);

            /*Titulo*/
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.setFont(FontFactory.getFont("arial", 20));
            Titulo.add("" + Encabezado + "\n\n\n");

            /*Tabla de Reporte*/
            PdfPTable Tabla_Reporte = new PdfPTable(2);
            Tabla_Reporte.setWidthPercentage(100);

            PdfPCell Celda_Usuarios = new PdfPCell(new Phrase("                    " + Primera_Columna + ""));
            PdfPCell Celda_Cilindros = new PdfPCell(new Phrase("                   " + Segunda_Columna + ""));

            Tabla_Reporte.addCell(Celda_Usuarios);
            Tabla_Reporte.addCell(Celda_Cilindros);

            for (int i = 0; i < Lista.size(); i++) {
                Tabla_Reporte.addCell(Lista.get(i).getRol());
                Tabla_Reporte.addCell(Lista.get(i).getNombres());
            }

            /*Agregar todos los elementos al documento*/
            documento.open();
            documento.add(Imagen);
            documento.add(Titulo);
            documento.add(Tabla_Reporte);
            documento.close();

        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, FileNotFoundException, DocumentException {
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

            DAOEstadisticas daoEstadisticas = new DAOEstadisticas();
            List<DTOEstadisticas> listaMeses = daoEstadisticas.meses();

            List<DTOEstadisticas> Lista_Primera_Consulta = daoEstadisticas.Primera_Consulta(ParametroPrimeraConsulta);
            List<DTOEstadisticas> Lista_Segunda_Consulta = daoEstadisticas.Segunda_Consulta(ParametroSegundaConsultaFechaInicial, ParametroSegundaConsultaFechaFinal);
            List<DTOEstadisticas> Lista_Tercera_Consulta = daoEstadisticas.Tercera_Consulta(ParametroTerceraConsulta);
            List<DTOEstadisticas> Lista_Cuarta_Consulta = daoEstadisticas.Cuarta_Consulta(ParametroCuartaConsulta);
            List<DTOEstadisticas> Lista_Quinta_Consulta = daoEstadisticas.Quinta_Consulta(ParametroQuintaConsultaFechaInicial, ParametroQuintaConsultaFechaFinal);
            List<DTOEstadisticas> Lista_Sexta_Consulta = daoEstadisticas.Sexta_Consulta(ParametroSextaConsultaFechaInicial, ParametroSextaConsultaFechaFinal);

            List<DTORol> Lista_Septima_Consulta = daoEstadisticas.Septima_Consulta(ParametroSeptimaConsulta);
            int Octava_Consulta = daoEstadisticas.Octava_Consulta();

            List<DTOEstadisticas> Lista_Novena_Consulta = daoEstadisticas.Novena_Consulta(ParametroNovenaConsulta);
            List<DTOEstadisticas> Lista_Decima_Consulta = daoEstadisticas.Decima_Consulta(ParametroDecimaConsulta);
            List<DTOEstadisticas> Lista_Undecima_Consulta = daoEstadisticas.Undecima_Consulta(ParametroUndecimaConsulta);

            if (accion != null) {
                switch (accion) {
                    case "PrimeraConsulta":
                        ParametroPrimeraConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Primera_Consulta = daoEstadisticas.Primera_Consulta(ParametroPrimeraConsulta);
                        break;
                    case "PrimerReporte":
                        GenerarPDF(Lista_Primera_Consulta, "Reporte-Cilindros-Clientes", "Reporte  Clientes / Cilindros", "Usuarios", "N° de Cilidros Pedidos");
                        break;
                    case "SegundaConsulta":
                        ParametroSegundaConsultaFechaInicial = request.getParameter("FechaIncial");
                        ParametroSegundaConsultaFechaFinal = request.getParameter("FechaFinal");
                        Lista_Segunda_Consulta = daoEstadisticas.Segunda_Consulta(ParametroSegundaConsultaFechaInicial, ParametroSegundaConsultaFechaFinal);
                        break;
                    case "SegundoReporte":
                        GenerarPDF(Lista_Segunda_Consulta, "  Reporte-Meses-ClientesPedidos", "Reporte Meses / N° de Cilidros Pedidos", "Meses", "N° de Cilidros Pedidos");
                        break;
                    case "TerceraConsulta":
                        ParametroTerceraConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Tercera_Consulta = daoEstadisticas.Tercera_Consulta(ParametroTerceraConsulta);
                        break;
                    case "TercerReporte":
                        GenerarPDF(Lista_Tercera_Consulta, "  Reporte-Clientes-Pedidos", "Clientes / N° de Pedidos", "Clientes", "N° de Pedidos");
                        break;
                    case "CuartaConsulta":
                        ParametroCuartaConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Cuarta_Consulta = daoEstadisticas.Cuarta_Consulta(ParametroCuartaConsulta);
                        break;
                    case "CuartoReporte":
                        GenerarPDF(Lista_Cuarta_Consulta, "  Reporte-Empresas-Pedidos", "Empresas / N° de Pedidos", "Empresas", "N° de Pedidos");
                        break;
                    case "QuintaConsulta":
                        ParametroQuintaConsultaFechaInicial = request.getParameter("FechaIncial");
                        ParametroQuintaConsultaFechaFinal = request.getParameter("FechaFinal");
                        Lista_Quinta_Consulta = daoEstadisticas.Quinta_Consulta(ParametroQuintaConsultaFechaInicial, ParametroQuintaConsultaFechaFinal);
                        break;
                    case "QuintoReporte":
                        GenerarPDF(Lista_Quinta_Consulta, "  Reporte-Dias-Pedidos", "Dias / N° de Pedidos", "Dias", "N° de Pedidos");
                        break;
                    case "SextaConsulta":
                        ParametroSextaConsultaFechaInicial = request.getParameter("FechaIncial");
                        ParametroSextaConsultaFechaFinal = request.getParameter("FechaFinal");
                        Lista_Sexta_Consulta = daoEstadisticas.Sexta_Consulta(ParametroSextaConsultaFechaInicial, ParametroSextaConsultaFechaFinal);
                        break;
                    case "SextoReporte":
                        GenerarPDF(Lista_Sexta_Consulta, "  Reporte-Semanas-Pedidos", "Semana / N° de Pedidos", "Semana/Año", "N° de Pedidos");
                        break;
                    case "SeptimaConsulta":
                        ParametroSeptimaConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Septima_Consulta = daoEstadisticas.Septima_Consulta(ParametroSeptimaConsulta);
                        break;
                    case "SeptimoReporte":
                        GenerarPDF2(Lista_Septima_Consulta, "  Promedio-Cilindros-Pedidos", "Cliente / Promedio Cilindros Pedidos", "Documento-Cliente", "Promedio Cilindros Pedidos");
                        break;
                    case "NovenaConsulta":
                        ParametroNovenaConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Novena_Consulta = daoEstadisticas.Novena_Consulta(ParametroNovenaConsulta);
                        break;
                    case "NovenoReporte":
                        GenerarPDF(Lista_Novena_Consulta, "Reporte-Empleado-Pedidos Asignados", "Empleado / Pedidos Asignados", "Documento-Empleado", "Pedidos Asignados");
                        break;
                    case "DecimaConsulta":
                        ParametroDecimaConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Decima_Consulta = daoEstadisticas.Decima_Consulta(ParametroDecimaConsulta);
                        break;
                    case "DecimoReporte":
                        GenerarPDF(Lista_Decima_Consulta, "Reporte-Pedidos-Hora", "Hora / Pedidos Realizados", "Hora", "Pedidos Realizados");
                        break;
                    case "UndecimaConsulta":
                        ParametroUndecimaConsulta = Integer.parseInt(request.getParameter("cantidad"));
                        Lista_Undecima_Consulta = daoEstadisticas.Undecima_Consulta(ParametroUndecimaConsulta);
                        break;
                    case "UndecimoReporte":
                        GenerarPDF(Lista_Undecima_Consulta, "Reporte-Pedidos-Dia de la Semana", "Dia de la semana / Pedidos Realizados", "Dia", "Pedidos Realizados");
                        break;
                }
            }
            request.setAttribute("Lista_Segunda_Consulta", Lista_Segunda_Consulta);
            request.setAttribute("Lista_Primera_Consulta", Lista_Primera_Consulta);
            request.setAttribute("Lista_Tercera_Consulta", Lista_Tercera_Consulta);
            request.setAttribute("Lista_Cuarta_Consulta", Lista_Cuarta_Consulta);
            request.setAttribute("Lista_Quinta_Consulta", Lista_Quinta_Consulta);
            request.setAttribute("Lista_Sexta_Consulta", Lista_Sexta_Consulta);
            request.setAttribute("Lista_Septima_Consulta", Lista_Septima_Consulta);
            request.setAttribute("Octava_Consulta", Octava_Consulta);
            request.setAttribute("Lista_Novena_Consulta", Lista_Novena_Consulta);
            request.setAttribute("Lista_Decima_Consulta", Lista_Decima_Consulta);
            request.setAttribute("Lista_Undecima_Consulta", Lista_Undecima_Consulta);

            request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);

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
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ControlEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
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
