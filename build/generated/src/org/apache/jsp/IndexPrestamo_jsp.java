package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.DTOPrestamo;
import dto.DTOUsuario;
import java.util.List;

public final class IndexPrestamo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Navbar.jsp");
  }

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
      response.setContentType("text/html");
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
      out.write("            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-light\" style=\"background-color: #e3f2fd;\">\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlUsuario\">Usuarios</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\"  href=\"./ControlCilindro\">Cilindros</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlPedido\">Pedidos</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlEmpresa\">Empresas</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlRol\">Roles</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlLlenado\">Llenado</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlEstadisticas\">Estadisticas</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlCilindro?accion=comprar\">Selecionar</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlCilindro?accion=Carrito\"><i class=\"fas fa-cart-plus\">(<label style=\"color: orange\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contador}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>)</i>Accion</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a id=\"salir\" class=\"nav-link cursor-pointer\" href=\"#\">Cerrar sesion</a>\n");
      out.write("                        </li>                        \n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("        </nav>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.0.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("    <script src=\"js/funciones.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("\n");
      out.write("        <title>Prestamos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"buscar\">\n");
      out.write("            <div class=\"form-group col\">\n");
      out.write("                <input autofocus class=\"form-control\" type=\"text\" id=\"buscarPrestamoVar\" placeholder=\"Nombre, Apellidos o identificacion\">\n");
      out.write("                <button type=\"submit\" name=\"accion\" id=\"buscarPrestamo\" class=\"btn btn-dark\">Buscar</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"lista\">\n");
      out.write("                ");

                    List<DTOPrestamo> ListaPrestamos = (List<DTOPrestamo>) request.getAttribute("ListaPrestamos");
                    if (ListaPrestamos.size() >= 1) {
                
      out.write("\n");
      out.write("                <table class='table table-bordered'>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\" >Codigo</th>\n");
      out.write("                        <th scope=\"col\">Documento Cliente</th>\n");
      out.write("                        <th scope=\"col\">Documento Empleado</th>\n");
      out.write("                        <th scope=\"col\">Fecha Pedido</th>\n");
      out.write("                        <th scope=\"col\">Fecha Entrega</th>\n");
      out.write("                        <th scope=\"col\">Nombre Destinatario</th>\n");
      out.write("                        <th scope=\"col\">Documento Destinatario</th>\n");
      out.write("                        <th scope=\"col\" colspan=\"2\">Acciones</th>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        for (int i = 0; i < ListaPrestamos.size(); i++) {
                            out.print("<tr>");
                            out.print("<td>" + ListaPrestamos.get(i).getCodigo() + " " + "</td>");
                            out.print("<td>" + ListaPrestamos.get(i).getDocCliente() + " " + "</td>");
                            out.print("<td>" + ListaPrestamos.get(i).getDocEmpleado() + " " + "</td>");
                            out.print("<td>" + ListaPrestamos.get(i).getFechapedido() + " " + "</td>");
                            out.print("<td>" + ListaPrestamos.get(i).getFechaentrega() + " " + "</td>");
                            out.print("<td>" + ListaPrestamos.get(i).getNombredestinatario() + " " + "</td>");
                            out.print("<td>" + ListaPrestamos.get(i).getDocumentodestinatario() + " " + "</td>");
                            out.print("<td><button class='btn btn-success'><a href='./ControlPrestamo?accion=Devolver&Prestamo=" + ListaPrestamos.get(i).getCodigo() + "'>Devolver</a></button></td>");
                            out.print("</tr>");
                        }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("                ");

                    } else {
                        out.print("<p>NO HAY REGISTROS PARA ESTA BUSQUEDA</p>");
                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Optional JavaScript; choose one of the two! -->\n");
      out.write("\n");
      out.write("        <!-- Option 1: Bootstrap Bundle with Popper -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/Controles.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!-- Option 2: Separate Popper and Bootstrap JS -->\n");
      out.write("        <!--\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" integrity=\"sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/\" crossorigin=\"anonymous\"></script>\n");
      out.write("        -->\n");
      out.write("    </body>\n");
      out.write("</html>");
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
