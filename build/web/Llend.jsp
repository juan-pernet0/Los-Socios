<%-- 
    Document   : llen
    Created on : 26/10/2021, 11:55:51 AM
    Author     : SENA
--%>
<%@include file="Icono.jsp"%>
<%@page import="dto.DTOEmpresa"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Registrar Llenado</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="titulollend">
            <h1>Registrar Llenado De Cilindros</h1>
        </div>
    <head>
    <div class="container-select">
        <form>
                                    <select name="nit" id="select" class="form-select" onChange="location = './ControlLlenado?accion=nuevo&codigoem='+form.nit.options[form.nit.selectedIndex].value;">
                                        
                                        <%
                                            
                                            String empre = ""+request.getAttribute("empresa");
                                            if(empre.equals("null")){
                                                out.println("<option>Empresas</option>");
                                            }else{
                                                
                                                out.println("<option>"+empre+"</option>");
                                            }                                           
                List<DTOEmpresa> listaempresas = (List<DTOEmpresa>) request.getAttribute("listaEmpresas");
                for(DTOEmpresa i: listaempresas){
                    out.println("<option value='"+i.getNit()+"'>"+i.getNombre()+"</option>");
                }
                %>
            </select>
            </form>
            </div> 
    <div class="tablallend">
        <!--<div class="form">
         <form action="ControlLlenado" method="post">
            <input type="date" name="fechallenado" placeholder="Fecha Del Pedido">
            <select name="nitempresa"  class="form-select">
                <option>Empresas</option>
                <%/*
                List<DTOEmpresa> listaEmpresas = (List<DTOEmpresa>) request.getAttribute("listaEmpresas");
                for(DTOEmpresa i: listaEmpresas){
                    out.println("<option value='"+i.getNit()+"'>"+i.getNombre()+"</option>");
                }*/
                %>
            </select>
            <input type="submit" value="Registrar" name="button" class="btn btn-primary"> 
        </form>
            
        </div>-->
        <div class="mainlled">
            <table class="table table-striped">
                <thead>
                
                    <tr>
                        <th scope="col">EMPRESA</th>
                        <th scope="col">CAPACIDAD</th>
                        <th scope="col">CANTIDAD</th>
                        <th scope="col">PRECIO UNITARIO</th>
                        <th scope="col">ACCION</th>
                    </tr>
                </thead>
                <tbody>
                
                    
                <c:forEach var="c" items="${ListaCilindros}">
                    <form action="ControlLlenado" method="post">
                        <input type="hidden" value="${c.getCodigo()}" name="codigo"> 

                    <tr>
                        <%
                        out.println("<td>"+empre+"</td>");
                        %>
                        <td>${c.getCapacidad()}</td>
                        <td><input id="cantidad" type="number" name="cantidad"></td>
                        <td><input id="precio" type="number" name="precio"></td>
                        <td><input type="submit" value="Agregar" name="accion" ></td>
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
            <div>
            <form action="ControlLlenado" method="post" class="form1">
            <button type="submit" class="btn btn-success btn-block" value="confirmar" name="accion" >Confirmar Llenado (<label style="color: #FF7D21">${cont}</label>)</button>
        </form>
            <form action="ControlLlenado" method="post" class="form2">
            <button type="submit" class="btn btn-success btn-block">Salir</button>
            
        </form>
        </div>
            
        </form>
        </div>
    </div>
</head>
</body>
</html>