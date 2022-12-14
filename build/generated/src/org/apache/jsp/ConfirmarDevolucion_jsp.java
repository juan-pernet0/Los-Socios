package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.DTOCilindro;
import dto.DTOPrestamoCilindro;
import java.util.List;

public final class ConfirmarDevolucion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <title>Confirmar devolucion</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Confirmar Devoluci??n</h1>\n");
      out.write("        <div class=\"listapedido\">\n");
      out.write("            <form action=\"ControlPrestamo\" method=\"POST\">\n");
      out.write("                <table class='table table-bordered'>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\" >Codigo Prestamo</th>\n");
      out.write("                        <th scope=\"col\">Codigo Cilindros</th>\n");
      out.write("                        <th scope=\"col\">Empresa</th>\n");
      out.write("                        <th scope=\"col\">Capacidad</th>\n");
      out.write("                        <th scope=\"col\">Precio</th>\n");
      out.write("                        <th scope=\"col\">Cantidad de cilindros prestados</th>\n");
      out.write("                        <th scope=\"col\">Devolver</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        List<DTOPrestamoCilindro> listaPrestamoCilindro = (List<DTOPrestamoCilindro>) request.getAttribute("listaPrestamoCilindro");
                        List<DTOCilindro> listaCilindros = (List<DTOCilindro>) request.getAttribute("listaCilindrosPrestados");
                        List<String> listaCilindrosDevolver = (List<String>) request.getAttribute("listaCilindrosDevolver");
                        List<Integer> cantidades = (List<Integer>) request.getAttribute("cantidades");
                        int j = 0;
                        for (int i = 0; j < listaCilindrosDevolver.size(); i++) {
                            if (listaCilindros.get(i).getCodigo() == Integer.parseInt(listaCilindrosDevolver.get(j))) {
                                out.print("<tr>");
                                out.print("<td>" + listaPrestamoCilindro.get(i).getCodigoPrestamo() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getCodigo() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getEmpresa() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getCapacidad() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getPrecio() + " " + "</td>");
                                out.print("<td>" + listaPrestamoCilindro.get(i).getCantidad() + " " + "</td>");
                                out.print("<td>");
                                out.print("<input type='hidden' id='CodCilindro' value='" + listaPrestamoCilindro.get(i).getCodCilindro() + "'>");
                                out.print("<input type='number' id='CantidadDevolucion' value='" + cantidades.get(j) + "' class='form-control text-center' min='1' max='" + listaPrestamoCilindro.get(i).getCantidad() + "'>");
                                out.print("</td>");
                                out.print("</tr>");
                                j++;
                            }

                        }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <button class='btn btn-success' type=\"submit\" value=\"Listo\" name=\"accion\">Listo</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.0.min.js\"></script>\n");
      out.write("        <script src=\"js/funciones.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
