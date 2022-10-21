package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.DTORol;
import dto.DTOUsuario;
import java.util.List;

public final class IndexUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <title>Usuarios</title>\n");
      out.write("  </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-light\" style=\"background-color: #e3f2fd;\">\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" href=\"./ControlUsuario\">Usuarios</a>\n");
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
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlLogin?accion=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Cerrar sesion</a>\n");
      out.write("                        </li>\n");
      out.write("                        \n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            \n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("        </nav>\n");
      out.write("        <form action=\"ControlUsuario\" method=\"post\">\n");
      out.write("            <div class=\"form-group col\">\n");
      out.write("                <input autofocus class=\"form-control\" type=\"text\" name=\"buscar\" placeholder=\"Nombre, Apellidos o identificacion\">\n");
      out.write("                <button type=\"submit\" name=\"boton1\" class=\"btn btn-dark\">Buscar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <div class=\"form\">\n");
      out.write("         <form action=\"ControlUsuario\" method=\"post\">\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"docidentidad\" placeholder=\"Documento\">\n");
      out.write("            <input class=\"form-control\" type=\"text\" name=\"nombres\" placeholder=\"Nombres\">\n");
      out.write("            <input class=\"form-control\" type=\"text\" name=\"apellidos\" placeholder=\"Apellidos\">\n");
      out.write("            <input class=\"form-control\" type=\"text\" name=\"direccion\" placeholder=\"Direccion\">\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"telefono\" placeholder=\"Telefono\">\n");
      out.write("            <input class=\"form-control\" type=\"email\" name=\"email\" placeholder=\"Email\">\n");
      out.write("            <input class=\"form-control\" type=\"password\" name=\"password\" placeholder=\"password\">\n");
      out.write("            <select name=\"rol\" class=\"form-select\">\n");
      out.write("            ");

            List<DTORol> listaRoles = (List<DTORol>) request.getAttribute("listaRoles");
            for(DTORol i: listaRoles){
                out.println("<option value='"+i.getRol()+"'>"+i.getNombres()+"</option>");
            }
            
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"Registrar\" name=\"button\" class=\"btn btn-primary\"> \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("                       <div class=\"lista\">\n");
      out.write("                ");

                List<DTOUsuario> ListaUsuarios = (List<DTOUsuario>) request.getAttribute("ListaUsuarios");
            if(ListaUsuarios.size()>=1){
                
      out.write("\n");
      out.write("                <table class='table table-bordered'>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Documento</th>\n");
      out.write("                        <th scope=\"col\">Nombres</th>\n");
      out.write("                        <th scope=\"col\">Apellidos</th>\n");
      out.write("                        <th scope=\"col\">Direccion</th>\n");
      out.write("                        <th scope=\"col\">Telefono</th>\n");
      out.write("                        <th scope=\"col\">Email</th>\n");
      out.write("                        <th scope=\"col\">Password</th>\n");
      out.write("                        <th scope=\"col\">Rol</th>\n");
      out.write("                        <th scope=\"col\" colspan=\"2\">Acciones</th>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("        ");

            for(int i = 0; i < ListaUsuarios.size(); i++){
                out.print("<tr>");
                out.print("<td>"+ListaUsuarios.get(i).getDocumento()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getNombres()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getApellidos()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getDireccion()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getTelefono()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getEmail()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getPassword()+" "+"</td>");
                out.print("<td>"+ListaUsuarios.get(i).getRol()+" "+"</td>");
                out.print("<td><button class='btn btn-danger'><a href='./ControlUsuario?id="+ListaUsuarios.get(i).getDocumento()+"'>Eliminar</a></button></td>");
                out.print("<td><button class='btn btn-warning'><a href='./ControlUsuario?documento="+ListaUsuarios.get(i).getDocumento()+"'>Modificar</a></button></td>");
                out.print("</tr>");                       
            }
            
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");

            }else{
               out.print("<p>NO HAY REGISTROS PARA ESTA BUSQUEDA</p>");
            }
            
      out.write("\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("    <!-- Optional JavaScript; choose one of the two! -->\n");
      out.write("\n");
      out.write("    <!-- Option 1: Bootstrap Bundle with Popper -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    <!-- Option 2: Separate Popper and Bootstrap JS -->\n");
      out.write("    <!--\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" integrity=\"sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/\" crossorigin=\"anonymous\"></script>\n");
      out.write("    -->\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
