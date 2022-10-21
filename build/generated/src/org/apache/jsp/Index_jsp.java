package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Icono.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<link rel=\"icon\" type=\"img/png\" href=\"https://cdn.icon-icons.com/icons2/1410/PNG/128/5_97257.png\">");
      out.write(" \n");
      out.write("<!doctype html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1, maximun-scale=1.0, minimun-scale=1.0\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Index</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"main-index\">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar navbar-light\" style=\"background-color: #e3f2fd;\">            \n");
      out.write("                <a class=\"navbar-brand\">\n");
      out.write("                    <img src=\"https://cdn.icon-icons.com/icons2/1410/PNG/128/5_97257.png\" alt=\"\" width=\"40\" height=\"40\" class=\"d-inline-block align-text-top\">\n");
      out.write("                </a>\n");
      out.write("                <div class=\"links-navbar-index\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"./ControlPrecios\">Precios</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"RegistrarUsuario.jsp\">Crear Cuenta</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\"  href=\"./ControlLogin\">Iniciar Sesion</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("            <h1>Empresas Distribuidoras</h1>\n");
      out.write("\n");
      out.write("            <section class=\"cards\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"imagen-cartas\">\n");
      out.write("                        <img class=\"card-img-top img-fluid\" src=\"http://roscogas.com.co/images/logo%20nuevo.png\"  alt=\"Card image cap\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"Titulo-Carta\">\n");
      out.write("                            <h5 class=\"card-title\">Rosco Gas</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"Parrafo-Carta\">\n");
      out.write("                            <p class=\"card-text\">Es un Grupo empresarial con capital Antioqueño que se dedica al tartamiento del petróleo refinado Para obtener gas.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"imagen-cartas\">\n");
      out.write("                        <img class=\"card-img-top img-fluid\" src=\"https://linkempleo.co/wp-content/uploads/2018/11/descarga.png\"  alt=\"Card image cap\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"Titulo-Carta\">\n");
      out.write("                            <h5 class=\"card-title\">Gases de Antioquia</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"Parrafo-Carta\">\n");
      out.write("                            <p class=\"card-text\">Es una empresa, dedicada a la distribución de gas propano, en el territorio antioqueño y sus cercanias.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"imagen-cartas\">\n");
      out.write("                        <img class=\"card-img-top img-fluid\" src=\"https://www.gazclc.com/site/wp-content/uploads/2021/05/Mesa-de-trabajo-1-1.png\"  alt=\"Card image cap\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"Titulo-Carta\">\n");
      out.write("                            <h5 class=\"card-title\">Gaz</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"Parrafo-Carta\">\n");
      out.write("                            <p class=\"card-text\">Es un compañia que hace presencia en más de 32 ciudades, 24 municipios, del terrirorio colombiano.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"imagen-cartas\">\n");
      out.write("                        <img class=\"card-img-top img-fluid\" src=\"https://gasco.ines.cl/gasco/formulario/vidagas/images/header_logo.png\"  alt=\"Card image cap\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"Titulo-Carta\">\n");
      out.write("                            <h5 class=\"card-title\">Vida Gas</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"Parrafo-Carta\">\n");
      out.write("                            <p class=\"card-text\">Es una compañía chilena con más de 160 años de trayectoria. Nuestra marca Vidagas en Colombia.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"imagen-cartas\">\n");
      out.write("                        <img class=\"card-img-top img-fluid\" src=\"https://gaspais.com.co/wp-content/uploads/2020/08/LOGO-GAS-PAIS.png\"  alt=\"Card image cap\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"Titulo-Carta\">\n");
      out.write("                            <h5 class=\"card-title\">Gas Pais</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"Parrafo-Carta\">\n");
      out.write("                            <p class=\"card-text\">Empresa dedicada a entregar soluciones energéticas integrales a sus clientes.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <div class=\"main-mapa\">\n");
      out.write("                <h1>¿Como llegar?</h1>\n");
      out.write("                <div class=\"mapa\">\n");
      out.write("                    <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d991.4681463815562!2d-75.33301531525329!3d6.280476617182861!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e441f218d7a72df%3A0x14237dd9f551f243!2sTalleres%20La%20Virgen!5e0!3m2!1ses!2sco!4v1637653113518!5m2!1ses!2sco\" width=\"1300\" height=\"500\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\"></iframe>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"iconos\">\n");
      out.write("                <div class=\"icono\">\n");
      out.write("                    <img src=\"iconos/Cilindro.png\" alt=\"\" width=\"60px\" height=\"100px\"/>\n");
      out.write("                    <p>Cilindros</p>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"icono\">\n");
      out.write("                    <img src=\"iconos/Domicilio.png\" alt=\"\" width=\"60px\" height=\"90px\"/>\n");
      out.write("                    <p>Domicilios</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"icono\">\n");
      out.write("                    <img src=\"iconos/Ubicacion.png\" alt=\"\" width=\"60px\" height=\"80px\"/>\n");
      out.write("                    <p>Almacen</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"icono\">\n");
      out.write("                    <img src=\"iconos/Telefono.png\" alt=\"\" width=\"70px\" height=\"90px\"/>\n");
      out.write("                    <p>Pedidos Por Telfono</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid bg-inverse text-white py-3\" style=\"background-color: #4a8ccfd9;\">\n");
      out.write("                <div class=\"container text-center\">\n");
      out.write("                    <p>Todos los dereechos Reservados ©</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Optional JavaScript; choose one of the two! -->\n");
      out.write("\n");
      out.write("        <!-- Option 1: Bootstrap Bundle with Popper -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <!-- Option 2: Separate Popper and Bootstrap JS -->\n");
      out.write("        <!--\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>\n");
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
