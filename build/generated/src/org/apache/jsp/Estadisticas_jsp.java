package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.DTOEstadisticas;
import java.util.List;

public final class Estadisticas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Estadisticas</title>\n");
      out.write("        <script src=\"https://cdn.plot.ly/plotly-latest.min.js\"></script>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body><nav class=\"navbar navbar-expand-lg navbar navbar-light\" style=\"background-color: #e3f2fd;\">\n");
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
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlLlenado\">Llenado</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlEstadisticas\">Estadisticas</a>\n");
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
      out.write("        <h1>Estadisticas</h1> \n");
      out.write("        \n");
      out.write("        <div class=\"conatiner_estadistica\">\n");
      out.write("            <h2>Numero de Pedidos por Mes</h2>\n");
      out.write("            <div id=\"grafico\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"conatiner_estadistica\">\n");
      out.write("            <h2>Numero de Pedidos de cilindros por Cliente</h2>\n");
      out.write("            <div id=\"barras\"></div>\n");
      out.write("        </div>             \n");
      out.write("\n");
      out.write("        ");

            List<DTOEstadisticas> listaMeses = (List<DTOEstadisticas>) request.getAttribute("listaMeses");
            String fechas[] = new String[listaMeses.size()];
            int Numero_de_pedidos[] = new int[listaMeses.size()];
            for (int i = 0; i < listaMeses.size(); i++) {
                fechas[i] = listaMeses.get(i).getFecha();
                Numero_de_pedidos[i] = listaMeses.get(i).getNumero_de_pedidos();
            }
            
             List<DTOEstadisticas> listaClientes = (List<DTOEstadisticas>) request.getAttribute("listaClientes");
            String clientes[] = new String[listaClientes.size()];
            int Numero_de_pedidos_cliente[] = new int[listaClientes.size()];
            for (int i = 0; i < listaClientes.size(); i++) {
                clientes[i] = listaClientes.get(i).getFecha();
                Numero_de_pedidos_cliente[i] = listaClientes.get(i).getNumero_de_pedidos();
            }
            
            out.print("<script type='text/javascript'>");
            out.print("var parametros = [];");
            out.print("var valores = [];");
            out.print("parametros.push('');");
            out.print("valores.push(parseInt(0));");
            
            for (int i = 0; i < fechas.length; i++) {
                out.print("parametros.push('" + fechas[i] + "');");
                out.print("valores.push(parseInt('" + Numero_de_pedidos[i] + "'));");

            }
            out.print("var data = [{");
            out.print("x: parametros,");
            out.print("y: valores,");
            out.print("type: 'linear'");
            out.print("}];");
            out.print("Plotly.newPlot('grafico',data);"); 
            
            /*Clientes*/
            
            out.print("var clientes = [];");
            out.print("var pedidos = [];");
            
            for (int i = 0; i < clientes.length; i++) {
                out.print("clientes.push('" + clientes[i] + "');");
                out.print("pedidos.push(parseInt('" + Numero_de_pedidos_cliente[i] + "'));");

            }
            out.print("var barras = [{");
            out.print("x: clientes,");
            out.print("y: pedidos,");
            out.print("type: 'bar'");
            out.print("}];");
            out.print("Plotly.newPlot('barras',barras);"); 
            
            
            out.print("</script>");
            

        
      out.write("\n");
      out.write("\n");
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
