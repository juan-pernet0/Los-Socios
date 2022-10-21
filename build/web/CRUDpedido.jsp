<%@include file="Icono.jsp"%>
<%@page import="dto.DTOPedido"%>
<%@page import="dto.DTOUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">

        <title>Modificar Usuario</title>
    </head>
    <body>
        <h1 class="TRU">Modificar Pedido</h1>
        <form action="ControlPedido" method="post">
            <div class="container-registrar">  

                <%

                    DTOPedido dtoPedido = (DTOPedido) request.getAttribute("dtoPedido");
                    List<DTOUsuario> listaUsuarios = (List<DTOUsuario>) request.getAttribute("listaUsuarios");
                    out.print("<input name='Codigo' value='" + dtoPedido.getCodigo() + "' hidden>");

                    out.print("<div class='PPFR'>");
                    for (DTOUsuario i : listaUsuarios) {
                        if (i.getDocumento().equals(dtoPedido.getDocCliente())) {
                            out.print("<div class='form-group'>");
                                out.print("<label>Cliente:</label>");
                                out.print("<input name='doccliente' value='" + dtoPedido.getDocCliente() + "' hidden>");
                                out.print("<input class='form-control' type='text' name='nombres' value='" + i.getNombres() + " " + i.getApellidos() + "' readonly>");
                            out.print("</div>");
                        }
                    }

                        out.print("<div class='form-group'>");
                            out.print("<label>Empleado:</label>");
                            out.print("<select name='docempleado' class='form-select'>");
                            for (DTOUsuario i : listaUsuarios) {
                                if (i.getRol().equals("Empleado")) {
                                    out.println("<option class='form-control' value='" + i.getDocumento() + "'>" + i.getNombres() + " " + i.getApellidos() + "</option>");
                                }
                            }
                            out.print("</select>");
                        out.print("</div>");
                        out.print("<div class='form-group'>");
                            out.print("<label>Nombre del destinatario:</label>");
                            out.print("<input class='form-control' type='text' name='nombredestinatario' value='" + dtoPedido.getNombredestinatario() + "'minlength='5' maxlength='45'>");
                        out.print("</div>");                        
                    out.print("</div>");
                    out.print("<div class='SPFR'>"); 
                        out.print("<div class='form-group'>");
                            out.print("<label>Fecha Pedido:</label>");   
                            out.print("<input class='form-control' type='text' name='fechapedido' value='" + dtoPedido.getFechapedido()+ "' readonly>");
                        out.print("</div>"); 
                        out.print("<div class='form-group'>");
                            out.print("<label>Fecha Entrega:</label>");   
                            out.print("<input class='form-control' type='text' name='fechaentrega' value='" + dtoPedido.getFechaentrega()+ "' readonly>");
                        out.print("</div>"); 
                        out.print("<div class='form-group'>");
                            out.print("<label>Documento destinatario:</label>");   
                            out.print("<input class='form-control' type='number' name='documentodestinatario' value='" + dtoPedido.getDocumentodestinatario()+ "' max='9999999999' min='999999999'>");
                        out.print("</div>"); 
                        out.print("<div class='form-group'>");
                            out.print("<label>Precio Domicilio:</label>");   
                            out.print("<input class='form-control' type='number' name='Precio_Domicilio' value='" + dtoPedido.getPrecio_Domicilio()+ "' max='9999999999' min='3000'>");
                        out.print("</div>"); 
                    out.print("</div>");                    
                    out.print("<div class='boton'>");
                    out.print("<input class='btn btn-primary' type='text' value='Modificado' name='accion' hidden>");
                        out.print("<input class='btn btn-primary' type='submit' value='Modificar'>");
                    out.print("</div>");  

                %>
            </div>
        </form>
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        -->
    </body>
</html>
