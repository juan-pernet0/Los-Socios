<%-- 
    Document   : index
    Created on : 29/06/2021, 09:02:54 AM
    Author     : USUARIO
--%>

<%@page import="dto.DTOCilindro"%>
<%@page import="dto.DTOEmpresa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Cilindros</title>
    </head>
    <body>
        <div class="container">
            <div class="form">
                <form action="ControlCilindro" method="post">
                    <select name="nit" class="form-select">
                        <%
                            List<DTOEmpresa> listaempresas = (List<DTOEmpresa>) request.getAttribute("listaempresas");
                            for (DTOEmpresa i : listaempresas) {
                                out.println("<option value='" + i.getNit() + "'>" + i.getNombre() + "</option>");
                            }
                        %>
                    </select>
                    <input class="form-control" type="number" name="capacidad" placeholder="Capacidad">
                    <input class="form-control" type="number" name="precio" placeholder="Precio">
                    <input type="submit" value="Registrar" name="accion" class="btn btn-primary">            
                </form> 
            </div>
            <div class="lista">
                <table class='table table-bordered'>
                    <tr>
                        <th scope="col">Codigo Lote</th>
                        <th scope="col">Empresa</th>                        
                        <th scope="col">Precio</th>
                        <th scope="col">Capacidad</th>
                        <th scope="col">Cilindros llenos</th>
                        <th scope="col">Cilindros vacios</th>
                        <th scope="col">Cilindros Prestados</th>
                        <th scope="col" colspan="2">Acciones</th>

                    </tr>
                    <%
                        List<DTOCilindro> ListaCilindros = (List<DTOCilindro>) request.getAttribute("ListaCilindros");
                        for (int i = 0; i < ListaCilindros.size(); i++) {
                            out.print("<tr>");
                            out.print("<td>" + ListaCilindros.get(i).getCodigo() + " " + "</td>");
                            out.print("<td>" + ListaCilindros.get(i).getEmpresa() + " " + "</td>");
                            out.print("<td>" + ListaCilindros.get(i).getPrecio() + " " + "</td>");
                            out.print("<td>" + ListaCilindros.get(i).getCapacidad() + " " + "</td>");
                            out.print("<td>" + ListaCilindros.get(i).getCilindros_llenos() + " " + "</td>");
                            out.print("<td>" + ListaCilindros.get(i).getCilindros_Vacios() + " " + "</td>");
                            out.print("<td>" + ListaCilindros.get(i).getCilindros_Prestados() + " " + "</td>");
                            out.print("<td><button class='btn btn-warning'><a href='./ControlCilindro?accion=Seleccionar&codigoA=" + ListaCilindros.get(i).getCodigo() + "'>Modificar</a></button></td>");
                            out.print("</tr>");
                        }
                    %>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    </body>

</html>
