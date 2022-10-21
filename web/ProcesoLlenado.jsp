<%-- 
    Document   : procesollenado
    Created on : 21/10/2021, 10:26:00 AM
    Author     : SENA
--%>
<%@include file="Icono.jsp"%>
<%@page import="dto.DTOCilindro"%>
<%@page import="dto.DTOEmpresa"%>
<%@page import="java.util.List"%>
<%@page import="dto.DTOUsuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Llenado</title>
                <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    </head>
    <body>
            <div class="titulollend">
            <h1>Confirmar Llenado De Cilindros</h1>
            </div>
            <div class="tablaprollen">
                <div class="mainprollen">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>CODIGO</th>
                                <th>EMPRESA</th>
                                <th>CAPACIDAD</th>
                                <th>CANTIDAD</th>
                                <th>PRECIO UNITARIO</th>
                                <th>SUBTOTAL</th>
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                            <tr>
                                <td>${car.getItem()}</td>
                                <td>${car.getCodigo()}</td>
                                <%
                                   out.println("<td>"+request.getAttribute("empre")+"</td>");
                                %>
                                <td>${car.getCapacidad()}</td>
                                <td>
                                    <input type="hidden" id="idl" value="${car.getCodigo()}">
                                    <input type="hidden" id="Precio" value="${car.getPrecio()}">
                                    <input type="number" id="Cantidadllenado" value="${car.getCantidad()}" class="form-control text-center"></td>
                                <td>
                                    <input type="hidden" id="idl" value="${car.getCodigo()}">
                                    <input type="hidden" id="Cantidadllenado" value="${car.getCantidad()}">
                                    <input type="number" id="Precio" value="${car.getPrecio()}" class="form-control text-center"></td>
                                <td>${car.getSubTotal()}</td>
                                <td>
                                    <input type="hidden" id="id1" value="${car.getCodigo()}">
                                    <a class="nav-link" href="#" id="btnDelete1"><i class="fas fa-trash-alt" style="color: black"></i></a>
                                </td>          
                            </tr>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <th style="text-align: right;">TOTAL:</th>
                                <th>${totalPagar}</th>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="op-llen">
            <form action="ControlLlenado" method="POST">
                                <button type="submit" class="btn btn-success btn-block" value="volver" name="accion">Volver</button>
                                <button type="submit" class="btn btn-success btn-block" value="HacerLlenado" name="accion">Confirmar</button>
                            </form> 
        </div>
                </div>
                
            </div>
        
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <script src="js/funciones.js" type="text/javascript"></script>

    </body>
</html>