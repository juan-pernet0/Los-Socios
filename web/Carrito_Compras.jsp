<%-- 
    Document   : Carrito_Compras
    Created on : 6/10/2021, 11:24:14 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Navbar.jsp"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Carro compras</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>
        <div class="titulo">
            <h1>Carro Compras</h1>
        </div>
    <head>
    <div class="tabla">
        <div class="main">
            <table class="table table-striped">
                <thead>
                
                    <tr>
                        <th scope="col">Empresa</th>
                        <th scope="col">Codigo Lote</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Capacidad</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Cilindros llenos</th>
                        <th scope="col">Cilindros vacios</th>
                        <th scope="col">Cilindros Prestados</th>
                        <th scope="col">Accion</th>
                    </tr>
                </thead>
                <tbody>
                
                    
                <c:forEach var="c" items="${ListaCilindros}">
                    <form action="ControlCilindro" method="post">
                        <input type="hidden" value="${c.getCodigo()}" name="codigo"> 

                    <tr>
                        <td>${c.getEmpresa()}</td>
                        <td>${c.getCodigo()}</td>
                        <td>${c.getPrecio()}</td>
                        <td>${c.getCapacidad()}</td>
                        <td><input id="cantidad" type="number" name="cantidad" max="${c.getCilindros_llenos()}" min="1"></td>
                        <td>${c.getCilindros_llenos()}</td>
                        <td>${c.getCilindros_Vacios()}</td>
                        <td>${c.getCilindros_Prestados()}</td>
                        <td><input type="submit" value="Agregar" name="accion"></td>
                    </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <!--<div class="confirmar">
                <div class="tabla-confirmar">					
                    <table>
                        <tr>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                            <th>Borrar</th>
                        </tr>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><button type="button" class="btn btn-danger">X</button></td>

                            </tr>
                        </tbody>
                    </table>

                </div>
                <div class="Total">
                    <p>Total:</p>
                    <p></p>
                </div>
                <div class="botones">
                    <button type="button" class="btn btn-success">Success</button>
                    <button type="button" class="btn btn-danger">Danger</button>
                </div>
            </div>-->
        </div>
    </div>
</head>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</body>
</html>
