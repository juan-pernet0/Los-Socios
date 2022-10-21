<%-- 
    Document   : indexprincipal
    Created on : 31/08/2021, 10:27:36 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            
        <h1>Los Socios</h1>
        
        <!--<form action="ControlUsuario" method="post">
            <input type="submit" name="button" value="Usuarios"> 
        </form> -->
        <a class="nav-link active" href="./ControlUsuario">Usuarios</a>
        <form action="ControlCilindro" method="post">
            <input type="submit" value="Cilindros" name="button"> 
        </form>
        <form action="ControlPedido" method="post">
            <input type="submit" value="Pedidos" name="button"> 
        </form>
        <form action="ControlEmpresa" method="post">
            <input type="submit" value="Empresas" name="button"> 
        </form>
        <form action="ControlLlenado" method="post">
            <input type="submit" value="Llenados" name="button"> 
        </form>
        <form action="ControlEstadisticas" method="post">
            <input type="submit" value="Estadisticas" name="button"> 
        </form>
        </div>
        <style>
            .container{
               text-align: center;
               font-size: 40px;
            }
            a{
                text-decoration: none;
                color: black;
                font-family: sans-serif;
                border: solid;
                border-radius: 15px;
            }
            body{
                background-color: #EEB544;
            }
        </style>    
    </body>
</html>
