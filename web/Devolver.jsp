<%-- 
    Document   : Devolver
    Created on : 3/11/2021, 08:21:36 PM
    Author     : user
--%>

<%@page import="dto.DTOCilindro"%>
<%@page import="dto.DTOCilindro"%>
<%@page import="dto.DTOPrestamoCilindro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"> 
        <link rel="stylesheet" href="style.css">
        <title>Devolver</title>
    </head>
    <body>
        <div class="devolver">
            <h1>Selecionar Cilindros a Devolver</h1>        
            <div class="listapedido">
                <table class='table table-bordered'>
                    <tr>
                        <th scope="col" >Codigo Prestamo</th>
                        <th scope="col">Codigo Cilindros</th>
                        <th scope="col">Empresa</th>
                        <th scope="col">Capacidad</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad de cilindros prestados Actualmente</th>
                        <th scope="col">Accion</th>
                    </tr>
                    <%
                        List<DTOPrestamoCilindro> listaPrestamoCilindro = (List<DTOPrestamoCilindro>) request.getAttribute("listaPrestamoCilindro");
                        List<DTOCilindro> listaCilindros = (List<DTOCilindro>) request.getAttribute("listaCilindrosPrestados");
                        for (int i = 0; i < listaPrestamoCilindro.size(); i++) {
                            if(listaPrestamoCilindro.get(i).getCantidad()>0){
                                out.print("<tr>");
                                out.print("<td>" + listaPrestamoCilindro.get(i).getCodigoPrestamo() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getCodigo() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getEmpresa() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getCapacidad() + " " + "</td>");
                                out.print("<td>" + listaCilindros.get(i).getPrecio() + " " + "</td>");
                                out.print("<td>" + listaPrestamoCilindro.get(i).getCantidad() + " " + "</td>");
                                out.print("<td><button class='btn btn-success'><a href='./ControlPrestamo?accion=anadir&codCilindro=" + listaCilindros.get(i).getCodigo() + "&Prestamo=" + listaPrestamoCilindro.get(i).getCodigoPrestamo() + "'>Añadir</a></button></td>");
                                out.print("</tr>");
                            }
                        }
                    %>
                </table>
                <div class="footer-devolver">
                    <button class='btn btn-success'><a href='ControlPrestamo?accion=inicializar'>Confirmar Cilindros</a></button>
                    <div class="botones-footer">
                        <button class='btn btn-danger'><a href='ControlPrestamo?accion=cancelar'>Cancelar Proceso</a></button>
                        <p>Añadidos(${contador})</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>