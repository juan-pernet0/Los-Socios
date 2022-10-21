<%-- 
    Document   : RegistrarUsuario
    Created on : 31/10/2021, 01:27:36 PM
    Author     : user
--%>
<%@include file="Icono.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Registrar Usuarios</title>
    </head>
    <body>
        <h1 class="TRU">Registrarse</h1>
        <form action="ControlUsuario"  method="POST">
            <div class="container-registrar">
                <div class="PPFR">
                    <div class="form-group">
                        <label>Documento de Identidad:</label>
                        <input type="number" class="form-control" name="docidentidad"  placeholder="Documento" min="999999999" max="9999999999" required="" title="Ingresa Solo numeros">
                    </div>
                    <div class="form-group">
                        <label>Nombres:</label>
                        <input type="text" class="form-control" name="nombres" placeholder="Nombres" maxlength="45" required="">
                    </div>
                    <div class="form-group">
                        <label>Apellidos:</label>
                        <input type="text" class="form-control" name="apellidos" placeholder="Apellidos" maxlength="45" required="">
                    </div>
                    <div class="form-group">
                        <label>Dirección:</label>
                        <input type="text" class="form-control" name="direccion" placeholder="Dirección" maxlength="100" minlength="20"required="" >
                    </div>
                </div> 
                <div class="SPFR">
                    <div class="form-group">
                        <label>Telofono:</label>
                        <input type="number" class="form-control" name="telefono" placeholder="Telefono" max="9999999999" min="999999999" required="">
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" class="form-control" placeholder="Email" name="email" maxlength="80" required="">
                    </div>
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" class="form-control" placeholder="Password" name="password" minlength="8" required="" id="Password_Registrar">
                    </div>
                    <div class="form-group">
                        <label>Confirmar Password:</label>
                        <input type="password" class="form-control" placeholder="Confirmar Password" required="" id="Confirm_Password_Registrar">
                    </div>
                </div>
                <div class="boton">
                    <input type="hidden" name="rol" value="3">
                    <a href="login.jsp">Ya tengo cuenta</a>
                    <button type="submit" id="Registrarse_Usuarios" class="btn btn-primary" value="Registrarse" name="accion">Registrarme</button>                    
                </div>
            </div>            
        </form>
    </body>
    
        <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/funciones.js" type="text/javascript"></script>
</html>
