<%-- 
    Document   : CRUDusuario
    Created on : 2/08/2021, 11:57:37 AM
    Author     : USUARIO
--%>
<%@include file="Icono.jsp"%>
<%@page import="dto.DTORol"%>
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
        <h1 class="TRU">Modificar</h1>
        <form action="ControlUsuario" method="post">
            <div class="container-registrar">                
                    <%
                        DTOUsuario dtoUsuario = (DTOUsuario) request.getAttribute("dtoUsuario");
                    out.print("<div class='PPFR'>");
                        out.print("<div class='form-group'>");
                            out.print("<label>Documento de Identidad:</label>");
                            out.print("<input  class='form-control' name='docidentidad' value='" + dtoUsuario.getDocumento() + "' readonly>");
                        out.print("</div>");
                        
                        out.print("<div class='form-group'>");
                            out.print("<label>Nombres:</label>");
                            out.print("<input class='form-control' type='text' name='nombres' value='" + dtoUsuario.getNombres() + "' readonly>");
                        out.print("</div>");
                        
                        out.print("<div class='form-group'>");
                            out.print("<label>Apellidos:</label>");
                            out.print("<input class='form-control' type='text' name='apellidos' value='" + dtoUsuario.getApellidos() + "' readonly>");
                        out.print("</div>");
                        
                        out.print("<div class='form-group'>");
                            out.print("<label>Direccion:</label>");
                            out.print("<input class='form-control' type='text' name='direccion' value='" + dtoUsuario.getDireccion() + "' maxlength='100' minlength='20' required=''>");
                        out.print("</div>");
                    out.print("</div>");    
                    out.print("<div class='SPFR'>");       
                        out.print("<div class='form-group'>");
                            out.print("<label>Telefono:</label>");
                            out.print("<input class='form-control' type='number' name='telefono' value='" + dtoUsuario.getTelefono() + "'  max='9999999999' min='999999999' required=''>");
                        out.print("</div>");
                        
                        out.print("<div class='form-group'>");
                            out.print("<label>Email:</label>");
                            out.print("<input class='form-control' type='email' name='email' value='" + dtoUsuario.getEmail() + "' maxlength='80' required=''>");
                        out.print("</div>");
                        
                        
                        out.print("<div class='form-group'>");
                            out.print("<label>Rol:</label>");
                            out.print("<select name='rol' class='form-select'>");
                            List<DTORol> listaRoles = (List<DTORol>) request.getAttribute("listaRoles");
                            for (DTORol i : listaRoles) {
                                out.println("<option value='" + i.getRol() + "'>" + i.getNombres() + "</option>");
                            }
                            out.print("</select>");
                            
                        out.print("</div>");
                    out.print("</div>");
                    out.print("<input name='password' value='" + dtoUsuario.getPassword() + "' hidden>");
                    out.print("<div class='boton'>");
                        out.print("<input class='btn btn-primary' type='submit' value='Modificar' name='accion'>");
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
