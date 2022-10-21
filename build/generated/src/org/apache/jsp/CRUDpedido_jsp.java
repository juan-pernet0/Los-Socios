package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.DTOPedido;
import dto.DTOUsuario;
import java.util.List;

public final class CRUDpedido_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("\n");
      out.write("        <title>Modificar Usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 class=\"TRU\">Modificar Pedido</h1>\n");
      out.write("        <form action=\"ControlPedido\" method=\"post\">\n");
      out.write("            <div class=\"container-registrar\">  \n");
      out.write("\n");
      out.write("                ");


                    DTOPedido dtoPedido = (DTOPedido) request.getAttribute("dtoPedido");
                    List<DTOUsuario> listaUsuarios = (List<DTOUsuario>) request.getAttribute("listaUsuarios");
                    out.print("<input name='Codigo' value='" + dtoPedido.getCodigo() + "' hidden>");

                    out.print("<div class='PPFR'>");
                        for (DTOUsuario i : listaUsuarios) {
                            if (i.getDocumento().equals(dtoPedido.getDocCliente())) {
                                out.print("<div class='form-group'>");
                                out.print("<label>Cliente:</label>");
                                out.print("<input name='DocumentoCliente' value='" + dtoPedido.getDocCliente()+ "' hidden>");
                                out.print("<input class='form-control' type='text' name='nombres' value='" + i.getNombres() + " " + i.getApellidos() + "' readonly>");
                            out.print("</div>");
                            }
                        }
                        
                        for (DTOUsuario i : listaUsuarios) {
                            if (i.getDocumento().equals(dtoPedido.getDocEmpleado())) {
                                out.print("<div class='form-group'>");
                                out.print("<label>Empleado:</label>");
                                out.print("<input name='DocumentoEmpleado' value='" + dtoPedido.getDocCliente()+ "' hidden>");
                                out.print("<input class='form-control' type='text' name='nombres' value='" + i.getNombres() + " " + i.getApellidos() + "' readonly>");
                            out.print("</div>");
                            }
                        }
                    out.print("</div>");
                    
                        
                    /*out.print("<select name='doccliente' class='form-select'>");
                        for (DTOUsuario i : listaUsuarios) {
                        if (!i.getRol().equals("Empleado") && !i.getRol().equals("Administrador")) {
                            out.println("<option value='" + i.getDocumento() + "'>" + i.getNombres() + " " + i.getApellidos() + "</option>");
                        }
                    }
                    out.print("</select>");*/

                    out.print("<select name='docempleado' class='form-select'>");

                    for (DTOUsuario i : listaUsuarios) {
                        if (i.getRol().equals("Empleado")) {
                            out.println("<option value='" + i.getDocumento() + "'>" + i.getNombres() + " " + i.getApellidos() + "</option>");
                        }
                    }
                    out.print("</select>");
                    out.print("<input class='form-control' type='datetime-local' name='fechapedido'>");
                    out.print("<input class='form-control' type='datetime-local' name='fechaentrega'>");
                    out.print("<input class='form-control' type='text' name='nombredestinatario' value='" + dtoPedido.getNombredestinatario() + "'>");
                    out.print("<input class='form-control' type='number' name='documentodestinatario' value='" + dtoPedido.getDocumentodestinatario() + "'>");
                    out.print("<input class='btn btn-primary' type='submit' value='Modificar' name='button'>");


                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <!-- Optional JavaScript; choose one of the two! -->\n");
      out.write("\n");
      out.write("        <!-- Option 1: Bootstrap Bundle with Popper -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <!-- Option 2: Separate Popper and Bootstrap JS -->\n");
      out.write("        <!--\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" integrity=\"sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/\" crossorigin=\"anonymous\"></script>\n");
      out.write("        -->\n");
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
