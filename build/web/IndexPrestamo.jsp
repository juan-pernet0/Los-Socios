<%@page import="dto.DTOPrestamoCilindro"%>
<%@page import="dto.DTOPrestamo"%>
<%@page import="dto.DTOUsuario"%>
<%@page import="java.util.List"%>
<%@include file="Navbar.jsp"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"> 
        <link rel="stylesheet" href="style.css">

        <title>Prestamos</title>
    </head>
    <body>
        <div class="buscar">
            <form action="ControlPrestamo" method="post">
                <div class="form-group col">
                    <input autofocus class="form-control" type="text" name="buscar" placeholder="Cliente, Empleado">
                    <button type="submit" name="boton1" class="btn btn-dark">Buscar</button>
                </div>
            </form>
        </div>


        <div class="listapedido">
            <%
                List<DTOPrestamo> ListaPrestamos = (List<DTOPrestamo>) request.getAttribute("ListaPrestamos");
                List<DTOPrestamoCilindro> listaPrestados = (List<DTOPrestamoCilindro>) request.getAttribute("ListaPrestados");
                /*if (ListaPrestamos.size() >= 1) {*/
            %>
            <table class='table table-bordered'>
                <tr>
                    <th scope="col" >Codigo</th>
                    <th scope="col">Documento Cliente</th>
                    <th scope="col">Documento Empleado</th>
                    <th scope="col">Fecha Pedido</th>
                    <th scope="col">Fecha Entrega</th>
                    <th scope="col">Nombre Destinatario</th>
                    <th scope="col">Documento Destinatario</th>
                    <th scope="col" colspan="2">Acciones</th>

                </tr>
                <%
                    for (int i = 0; i < ListaPrestamos.size(); i++) {
                        for (int j = 0; j < listaPrestados.size(); j++) {
                            if(ListaPrestamos.get(i).getCodigo()==listaPrestados.get(j).getCodigoPrestamo()){
                                if(listaPrestados.get(j).getCantidad()>0){
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
                            }
                        }
                    }
                %>
            </table>
            <%/*
                } else {
                    out.print("<p>NO HAY REGISTROS PARA ESTA BUSQUEDA</p>");
                }*/
            %>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

        <script src="js/Controles.js" type="text/javascript"></script>
        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
        -->
    </body>
</html>