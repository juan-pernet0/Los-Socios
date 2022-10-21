package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("\n");
      out.write("    <title>Login</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <h1>Ingreso Usuarios</h1>\n");
      out.write("      <div class=\"contenedor\">\n");
      out.write("          <div class=\"form\">\n");
      out.write("              <form action=\"ControlLogin\" method=\"post\">\n");
      out.write("                  <label>Documento:</label>\n");
      out.write("                  <input class=\"form-control\" type=\"number\" name=\"Documento\" placeholder=\"Documento de identidad\" required minlength=\"8\">\n");
      out.write("                  \n");
      out.write("                  <label>Contraseña:</label>\n");
      out.write("                  <input class=\"form-control\" type=\"password\" name=\"password\" placeholder=\"Contraseña\" required >\n");
      out.write("                  <input type=\"submit\" value=\"Login\" name=\"accion\" class=\"btn btn-primary\"> \n");
      out.write("\n");
      out.write("              </form>\n");
      out.write("                  <a href=\"RegistrarUsuario.jsp\">No tengo cuenta</a>\n");
      out.write("                  ");

                  try {
                          int caso;  
                  caso = (int) request.getAttribute("caso");
                  if (caso == 1) {
                        out.print("<script type='text/javascript'>");
                        out.print("alert('La contraseña es incorrecta');");
                        out.print("</script>");
                      }else{
                      if (caso == 2) {
                        out.print("<script type='text/javascript'>");
                        out.print("alert('no esta registarado el documento');");
                        out.print("</script>");
                          }else{
                          if (caso == 3) {
                                out.print("<script type='text/javascript'>");
                        out.print("alert('Ingrese a la aplicacion por medio del login');");
                        out.print("</script>");  
                              }
                      }
                  }
                    caso = 0;  
                      } catch (Exception ex) {
                      }
                      

              
      out.write("\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("   \n");
      out.write("    <!-- Optional JavaScript; choose one of the two! -->\n");
      out.write("\n");
      out.write("    <!-- Option 1: Bootstrap Bundle with Popper -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.0.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("    <script src=\"js/prueba.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- Option 2: Separate Popper and Bootstrap JS -->\n");
      out.write("    <!--\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js\" integrity=\"sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/\" crossorigin=\"anonymous\"></script>\n");
      out.write("    -->\n");
      out.write("  </body>\n");
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
