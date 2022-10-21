<%-- 
    Document   : Navbar
    Created on : 19/10/2021, 08:28:07 PM
    Author     : user
--%>
<%@include file="Icono.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
         <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar navbar-light" style="background-color: #e3f2fd;">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <img src="https://cdn.icon-icons.com/icons2/1410/PNG/128/5_97257.png" width="40px" height="40px" style="margin-right: 10px;margin-left: 10px;">
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./ControlUsuario?docum=${user}">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="./ControlCilindro">Cilindros</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./ControlPedido">Pedidos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./ControlLlenado">Llenado</a>
                    </li>
                    <li class="nav-item">
                        
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./ControlPrestamo">Prestamos</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="./ControlCilindro?accion=comprar">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./ControlCilindro?accion=Carrito"><i class="fas fa-cart-plus">(<label style="color: orange">${contador}</label>)</i>Carrito</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active Documento">${nombres}</a>
                    </li>
                    <div class="div-menu-bootstrap" >
                        <li class="nav-item dropdown">
                            <div class="boton-menu-bootstrap"  role="button" data-bs-toggle="dropdown">
                                <i class="fas fa-ellipsis-v"></i>
                            </div>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="./ControlUsuario?accion=DatosUsu&Doc=${user}">Usuario</a></li>
                                <li><a class="dropdown-item" href="./ControlRol">Roles</a></li>
                                <li><a class="dropdown-item" href="./ControlEmpresa">Empresas</a></li>
                                <li><a class="dropdown-item" href="./ControlEstadisticas">Estadisticas</a></li>
                                <li><a class="dropdown-item" href="./ControlBackup?accion=Descargar">Respaldar Datos</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" id="salir">Cerrar Sesion</a></li>
                            </ul>
                        </li>                  
                    </div>
                </ul>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
