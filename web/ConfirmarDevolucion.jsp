<%-- 
    Document   : ConfirmarDevolucion
    Created on : 4/11/2021, 12:38:00 AM
    Author     : user
--%>

<%@page import="dto.DTOCilindro"%>
<%@page import="dto.DTOPrestamoCilindro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">

        <title>Confirmar devolucion</title>
    </head>
    <body>
        <div class="devolver">
            <h1>Confirmar Devolución</h1>
            <div class="listapedido">
                <form action="ControlPrestamo" method="POST">
                    <table class='table table-bordered'>
                        <tr>
                            <th scope="col" >Codigo Prestamo</th>
                            <th scope="col">Codigo Cilindros</th>
                            <th scope="col">Empresa</th>
                            <th scope="col">Capacidad</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Cantidad de cilindros prestados</th>
                            <th scope="col">Devolver</th>
                            <th scope="col">Borrar</th>
                        </tr>
                        <%
                            List<DTOPrestamoCilindro> listaPrestamoCilindro = (List<DTOPrestamoCilindro>) request.getAttribute("listaPrestamoCilindro");
                            List<DTOCilindro> listaCilindros = (List<DTOCilindro>) request.getAttribute("listaCilindrosPrestados");
                            List<String> listaCilindrosDevolver = (List<String>) request.getAttribute("listaCilindrosDevolver");
                            List<Integer> cantidades = (List<Integer>) request.getAttribute("cantidades");
                            int j = 0;
                            for (int i = 0; j < listaCilindrosDevolver.size(); i++) {
                                if (listaCilindros.get(i).getCodigo() == Integer.parseInt(listaCilindrosDevolver.get(j))) {
                                    out.print("<tr>");
                                    out.print("<td>" + listaPrestamoCilindro.get(i).getCodigoPrestamo() + " " + "</td>");
                                    out.print("<td>" + listaCilindros.get(i).getCodigo() + " " + "</td>");
                                    out.print("<td>" + listaCilindros.get(i).getEmpresa() + " " + "</td>");
                                    out.print("<td>" + listaCilindros.get(i).getCapacidad() + " " + "</td>");
                                    out.print("<td>" + listaCilindros.get(i).getPrecio() + " " + "</td>");
                                    out.print("<td>" + listaPrestamoCilindro.get(i).getCantidad() + " " + "</td>");
                                    out.print("<td>");
                                    out.print("<input type='hidden' id='CodCilindro' value='" + listaPrestamoCilindro.get(i).getCodCilindro() + "'>");
                                    out.print("<input type='number' id='CantidadDevolucion' value='" + cantidades.get(j) + "' class='form-control text-center' min='1' max='" + listaPrestamoCilindro.get(i).getCantidad() + "'>");
                                    out.print("</td>");
                                    out.print("<td>");
                                    out.print("<input type='hidden' id='CodCilindro' value='" + listaPrestamoCilindro.get(i).getCodCilindro() + "'>");
                                    out.print("<a class='nav-link' href = '#' id = 'btnDeleteConfirmar' ><i class='fas fa-trash-alt' style = 'color: black'></ i></a>");
                                    out.print("</tr>");
                                    j++;
                                }

                            }
                        %>
                    </table>
                    <div class="Listo-boton">
                        <button class='btn btn-success' type="submit" value="Listo" name="accion">Listo</button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
