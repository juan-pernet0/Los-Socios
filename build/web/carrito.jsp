<%-- 
    Document   : carrito
    Created on : 12/10/2021, 03:58:02 PM
    Author     : user
--%>

<%@page import="dto.DTOUsuario"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Compra</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>           
        <div class="titulo">
            <h3>Confirmar cilindros</h3>
        </div>  
        <div class="main-estadisticas">
            <div class="main-confirmar-pedido">
                <div class="tabla-confirmar-Pedido">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>CODIGO</th>
                                <th>CAPACIDAD</th>
                                <th>PRECIO</th>
                                <th>EMPRESA</th>
                                <th>CANTIDAD</th>
                                <th>SUBTOTAL</th>
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getCodigo()}</td>
                                    <td>${car.getCapacidad()}</td>
                                    <td>${car.getPrecio()}</td>
                                    <td>${car.getEmpresa()}</td>
                                    <td>
                                        <input type="hidden" id="idl" value="${car.getCodigo()}">
                                        <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                                    </td> 
                                    <td>${car.getSubTotal()}</td>
                                    <td>
                                        <input type="hidden" id="idl" value="${car.getCodigo()}">
                                        <a class="nav-link" href="#" id="btnDelete"><i class="fas fa-trash-alt" style="color: black"></i></a>
                                    </td>          
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="Formulario-Confirmar">
                    <form action="ControlCilindro" method="POST">
                        <div class="card-header">
                            <h3>Generar Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Total a Pagar:</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                            <br>
                            <label>Lista de Usuarios Registrados:</label>
                            <select name="doccliente" class="form-select">
                                <%
                                    List<DTOUsuario> listaUsuarios = (List<DTOUsuario>) request.getAttribute("ListaUsuarios");
                                    for (DTOUsuario i : listaUsuarios) {
                                        if (!i.getRol().equals("Empleado") && !i.getRol().equals("Administrador")) {
                                            out.println("<option value='" + i.getDocumento() + "'>" + i.getNombres() + " " + i.getApellidos() + "</option>");
                                        }

                                    }
                                %>
                            </select>
                            <label>Lista de Empleados Registrados:</label>
                            <select name="docempleado" class="form-select">
                                <%
                                    for (DTOUsuario i : listaUsuarios) {
                                        if (i.getRol().equals("Empleado")) {
                                            out.println("<option value='" + i.getDocumento() + "'>" + i.getNombres() + " " + i.getApellidos() + "</option>");
                                        }
                                    }
                                %>
                            </select>
                            <br>
                            <input class="form-control" type="text" name="nombredestinatario" placeholder="Nombre Del Destinatario">
                            <br>
                            <input class="form-control" type="number" name="documentodestinatario" placeholder="Documento Del Destinatario">
                            <br>
                            <input class="form-control" type="number" name="ValorDomicilio" placeholder="Valor del domicilio" required="">
                        </div> 
                        <div class="card-footer">
                            <button type="submit" class="btn btn-success btn-block" value="HacerPrestamo" name="accion">Hacer Prestamo</button>
                            <button type="submit" class="btn btn-success btn-block" value="HacerPedido" name="accion">Hacer Pedido</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </body>
</html>
