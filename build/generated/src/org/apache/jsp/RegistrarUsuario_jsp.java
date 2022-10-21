package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <title>Registrar Usuarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 class=\"TRU\">Registrarse</h1>\n");
      out.write("        <form action=\"ControlUsuario\"  method=\"POST\">\n");
      out.write("            <div class=\"container-registrar\">\n");
      out.write("                <div class=\"PPFR\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Documento de Identidad:</label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" name=\"docidentidad\"  placeholder=\"Documento\" min=\"999999999\" max=\"9999999999\" required=\"\" title=\"Ingresa Solo numeros\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Nombres:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nombres\" placeholder=\"Nombres\" maxlength=\"45\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Apellidos:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"apellidos\" placeholder=\"Apellidos\" maxlength=\"45\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Dirección:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"direccion\" placeholder=\"Dirección\" maxlength=\"100\" minlength=\"20\"required=\"\" >\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("                <div class=\"SPFR\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Telofono:</label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" name=\"telefono\" placeholder=\"Telefono\" max=\"9999999999\" min=\"999999999\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Email:</label>\n");
      out.write("                        <input type=\"email\" class=\"form-control\" placeholder=\"Email\" name=\"email\" maxlength=\"80\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Password:</label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"password\" minlength=\"8\" required=\"\" id=\"Password_Registrar\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Confirmar Password:</label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" placeholder=\"Confirmar Password\" required=\"\" id=\"Confirm_Password_Registrar\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"boton\">\n");
      out.write("                    <input type=\"hidden\" name=\"rol\" value=\"3\">\n");
      out.write("                    <a href=\"login.jsp\">Ya tengo cuenta</a>\n");
      out.write("                    <button type=\"submit\" id=\"Registrarse_Usuarios\" class=\"btn btn-primary\" value=\"Registrarse\" name=\"accion\">Registrarme</button>                    \n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.0.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("    <script src=\"js/funciones.js\" type=\"text/javascript\"></script>\n");
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
