<%-- 
    Document   : DatosUsuario
    Created on : 17/11/2021, 11:08:28 AM
    Author     : DUVAN
--%>
<%@include file="Icono.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Del Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1 class='title-usu'>Datos De Usuario</h1>
        <div class='datos'>
            <div class='column-1'>
                <div>
                    <label>Documento:</label>
                    <input class="form-control" type="number" value="${Documento}" readonly>
                 </div>
                <div>
                    <label>Nombres:</label>
                    <input class="form-control" type="text" value="${Nombres}" readonly>
                </div>
                <div>
                    <label>Apellidos:</label>
                    <input class="form-control" type="text" value="${Apellidos}" readonly>
                </div>
                <div>
                    <label>Direccion:</label>
                    <input class="form-control" type="text" value="${Direccion}" readonly>
                </div>
             </div>
             <div class='column-1'>
                <div>
                    <label>Telefono:</label>
                    <input class="form-control" type="number" value="${Telefono}" readonly>
                </div>
                <div>
                    <label>Email:</label>
                    <input class="form-control" type="text" value="${Email}" readonly>
                </div>
                <input class="form-control" type="text" value="${Password}" readonly hidden>
                <div>
                    <label>Rol:</label>
                    <input class="form-control" type="text" value="${Rol}" readonly>
                </div>
             </div>
            <div class='button-datos'>
                <button class='btn btn-primary'><a href='./ControlUsuario?docum=${Documento}'>Volver</a></button>
                <button class='btn btn-primary'><a href='./ControlUsuario?accion=ModiDatosUsu&documento=${Documento}'>Modificar</a></button>
            </div>
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
