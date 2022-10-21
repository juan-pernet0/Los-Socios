<%-- 
    Document   : IndexUsuario
    Created on : 2/08/2021, 11:56:24 AM
    Author     : USUARIO
--%>

<%@page import="dto.DTORol"%>
<%@page import="dto.DTOUsuario"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

        <link rel="stylesheet" href="style.css">
        <title>Usuarios</title>
    </head>
    <body>        
        <div class="buscar">
            <form action="ControlUsuario" method="post">
                <div class="form-group col">
                    <input autofocus class="form-control" type="text" name="docum" value="${user}" hidden>
                    <input autofocus class="form-control" type="text" name="buscar" placeholder="Nombre, Apellidos o identificacion">
                    <button type="submit" name="boton1" class="btn btn-dark">Buscar</button>
                </div>
            </form>
        </div>
        <div class="container">
            <div class="form">
                <form action="ControlUsuario" method="post">
                    <input class="form-control" type="number" name="docidentidad" placeholder="Documento" min="999999999" max="9999999999" required="" title="Verifique que el Documento tenge de 8 a 10 digitos">
                    <input class="form-control" type="text" name="nombres" placeholder="Nombres" maxlength="45" required="">
                    <input class="form-control" type="text" name="apellidos" placeholder="Apellidos" maxlength="45" required="">
                    <input class="form-control" type="text" name="direccion" placeholder="Direccion" maxlength="100" required="">
                    <input class="form-control" type="number" name="telefono" placeholder="Telefono" max="9999999999" min="999999999" required="" title="Verifique que el Telefono tenge 10 digitos">
                    <input class="form-control" type="email" name="email" placeholder="Email" maxlength="80" required="">
                    <input class="form-control" type="password" name="password" placeholder="password" minlength="8" required="">
                    <select name="rol" class="form-select">
                        <%
                            List<DTORol> listaRoles = (List<DTORol>) request.getAttribute("listaRoles");
                            for (DTORol i : listaRoles) {
                                out.println("<option value='" + i.getRol() + "'>" + i.getNombres() + "</option>");
                            }
                        %>
                    </select>
                    <input type="submit" value="Registrar" name="accion" class="btn btn-primary" id="Registrar_Usuario_Admin"> 
                </form>
            </div>
            <div class="lista">
                <%
                    List<DTOUsuario> ListaUsuarios = (List<DTOUsuario>) request.getAttribute("ListaUsuarios");
                    if (ListaUsuarios.size() >= 1) {
                %>
                <table class='table table-bordered'>
                    <tr>
                        <th scope="col">Documento</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Direccion</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">Email</th>
                        <th scope="col">Rol</th>
                        <th scope="col" colspan="2">Acciones</th>

                    </tr>
                    <%
                        for (int i = 0; i < ListaUsuarios.size(); i++) {
                            out.print("<tr>");
                            out.print("<td>" + ListaUsuarios.get(i).getDocumento() + " " + "</td>");
                            out.print("<td>" + ListaUsuarios.get(i).getNombres() + " " + "</td>");
                            out.print("<td>" + ListaUsuarios.get(i).getApellidos() + " " + "</td>");
                            out.print("<td>" + ListaUsuarios.get(i).getDireccion() + " " + "</td>");
                            out.print("<td>" + ListaUsuarios.get(i).getTelefono() + " " + "</td>");
                            out.print("<td>" + ListaUsuarios.get(i).getEmail() + " " + "</td>");
                            out.print("<td>" + ListaUsuarios.get(i).getRol() + " " + "</td>");
                            out.print("<td><button class='btn btn-danger'><a href='./ControlUsuario?accion=Eliminar&documento=" + ListaUsuarios.get(i).getDocumento() + "'>Eliminar</a></button></td>");
                            out.print("<td><button class='btn btn-warning'><a href='./ControlUsuario?accion=Seleccionar&documento=" + ListaUsuarios.get(i).getDocumento() + "'>Modificar</a></button></td>");
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
        </div>
    </body>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/funciones.js" type="text/javascript"></script>
    

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
</body>
</html>





