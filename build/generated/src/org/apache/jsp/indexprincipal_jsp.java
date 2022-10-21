package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexprincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("        <h1>Los Socios</h1>\n");
      out.write("        \n");
      out.write("        <!--<form action=\"ControlUsuario\" method=\"post\">\n");
      out.write("            <input type=\"submit\" name=\"button\" value=\"Usuarios\"> \n");
      out.write("        </form> -->\n");
      out.write("        <a class=\"nav-link active\" href=\"./ControlUsuario\">Usuarios</a>\n");
      out.write("        <form action=\"ControlCilindro\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"Cilindros\" name=\"button\"> \n");
      out.write("        </form>\n");
      out.write("        <form action=\"ControlPedido\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"Pedidos\" name=\"button\"> \n");
      out.write("        </form>\n");
      out.write("        <form action=\"ControlEmpresa\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"Empresas\" name=\"button\"> \n");
      out.write("        </form>\n");
      out.write("        <form action=\"ControlLlenado\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"Llenados\" name=\"button\"> \n");
      out.write("        </form>\n");
      out.write("        <form action=\"ControlEstadisticas\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"Estadisticas\" name=\"button\"> \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <style>\n");
      out.write("            .container{\n");
      out.write("               text-align: center;\n");
      out.write("               font-size: 40px;\n");
      out.write("            }\n");
      out.write("            a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("                font-family: sans-serif;\n");
      out.write("                border: solid;\n");
      out.write("                border-radius: 15px;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background-color: #EEB544;\n");
      out.write("            }\n");
      out.write("        </style>    \n");
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
