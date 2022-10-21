<%@page import="dto.DTOPedido"%>
<%@page import="dto.DTOUsuario"%>
<%@page import="java.util.List"%>
<%@include file="Navbar.jsp"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">

        <title>Pedidos</title>
    </head>
    <body>

        <div class="buscar">
            <form action="ControlPedido" method="post">
                <div class="form-group col">
                    <input autofocus class="form-control" type="text" name="buscar" placeholder="Cliente, Empleado">
                    <button type="submit" name="accion" value="buscar" class="btn btn-dark">Buscar</button>                    
                </div>
            </form>
        
        </div>
        <div class="listapedido">
            <%
                List<DTOPedido> ListaPedidos = (List<DTOPedido>) request.getAttribute("ListaPedidos");
                if (ListaPedidos.size() >= 1) {
            %>
            <table class='table table-bordered'>
                <tr>
                    <th scope="col" >Codigo</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Empleado</th>
                    <th scope="col">Fecha Pedido</th>
                    <th scope="col">Fecha Entrega</th>
                    <th scope="col">Nombre Destinatario</th>
                    <th scope="col">Documento Destinatario</th>
                    <th scope="col">Precio Domicilio</th>
                    <th scope="col">Modificar</th>

                </tr>
                <%
                    for (int i = 0; i < ListaPedidos.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + ListaPedidos.get(i).getCodigo() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getDocCliente() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getDocEmpleado() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getFechapedido() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getFechaentrega() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getNombredestinatario() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getDocumentodestinatario() + " " + "</td>");
                        out.print("<td>" + ListaPedidos.get(i).getPrecio_Domicilio() + " " + "</td>");
                        out.print("<td><button class='btn btn-warning'><a href='./ControlPedido?accion=Modificar&Codigo=" + ListaPedidos.get(i).getCodigo() + "'>Modificar</a></button></td>");
                        /*out.print("<td><button class='btn btn-warning'><a href='./ControlPedido?codigo=" + ListaPedidos.get(i).getCodigo() + "'>Modificar</a></button></td>");*/
                        out.print("</tr>");
                    }
                %>
            </table>
            <%
                } else {
                    out.print("<p>NO HAY REGISTROS PARA ESTA BUSQUEDA</p>");
                }
            %>
        </div>

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