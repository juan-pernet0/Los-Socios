package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.DTOCilindro;
import dto.DTOEmpresa;
import java.util.List;

public final class IndexCilindro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("  </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-light\" style=\"background-color: #e3f2fd;\">\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link \" href=\"./ControlUsuario\">Usuarios</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\"  href=\"./ControlCilindro\">Cilindros</a>\n");
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
      out.write("                            <a class=\"nav-link\" href=\"./ControlCilindro?accion=comprar\">Comprar</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"form\">\n");
      out.write("        <form action=\"ControlCilindro\" method=\"post\">\n");
      out.write("            <select name=\"nit\" class=\"form-select\">\n");
      out.write("                ");

                List<DTOEmpresa> listaempresas = (List<DTOEmpresa>) request.getAttribute("listaempresas");
                for(DTOEmpresa i: listaempresas){
                    out.println("<option value='"+i.getNit()+"'>"+i.getNombre()+"</option>");
                }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"capacidad\" placeholder=\"Capacidad\">\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"precio\" placeholder=\"Precio\">\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"Cilindros_llenos\" placeholder=\"Cantidad de cilindros\">\n");
      out.write("            <input type=\"submit\" value=\"Registrar\" name=\"accion\" class=\"btn btn-primary\">            \n");
      out.write("        </form> \n");
      out.write("            </div>\n");
      out.write("            <div class=\"lista\">\n");
      out.write("                <table class='table table-bordered'>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Empresa</th>\n");
      out.write("                        <th scope=\"col\">Codigo Lote</th>\n");
      out.write("                        <th scope=\"col\">Precio</th>\n");
      out.write("                        <th scope=\"col\">capacidad</th>\n");
      out.write("                        <th scope=\"col\">Cilindros llenos</th>\n");
      out.write("                        <th scope=\"col\">Cilindros vacios</th>\n");
      out.write("                        <th scope=\"col\">Cilindros Prestados</th>\n");
      out.write("                        <th scope=\"col\" colspan=\"2\">Acciones</th>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("        ");

            List<DTOCilindro> ListaCilindros = (List<DTOCilindro>) request.getAttribute("ListaCilindros");
            for(int i = 0; i < ListaCilindros.size(); i++){
                out.print("<tr>");
                out.print("<td>"+ListaCilindros.get(i).getEmpresa()+" "+"</td>");
                out.print("<td>"+ListaCilindros.get(i).getCodigo()+" "+"</td>");
                out.print("<td>"+ListaCilindros.get(i).getPrecio()+" "+"</td>");
                out.print("<td>"+ListaCilindros.get(i).getCapacidad()+" "+"</td>");
                out.print("<td>"+ListaCilindros.get(i).getCilindros_llenos()+" "+"</td>");
                out.print("<td>"+ListaCilindros.get(i).getCilindros_Vacios()+" "+"</td>");
                out.print("<td>"+ListaCilindros.get(i).getCilindros_Prestados()+" "+"</td>");
                out.print("<td><button class='btn btn-danger'><a href='./ControlCilindro?accion=eliminar&codigo="+ListaCilindros.get(i).getCodigo()+"'>Eliminar</a></button></td>");
                out.print("<td><button class='btn btn-warning'><a href='./ControlCilindro?accion=modificar&codigo="+ListaCilindros.get(i).getCodigo()+"'>Modificar</a></button></td>");
                out.print("</tr>");                       
            }
            
      out.write("\n");
      out.write("            </table>\n");
      out.write("            </div>\n");
      out.write("                </div>\n");
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
