<%-- 
    Document   : Precios
    Created on : 18/11/2021, 06:50:28 PM
    Author     : DUVAN
--%>

<%@page import="dto.DTOCilindro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
        <title>Precios</title>
    </head>
    <body class="body-precios">
        <h1 class="title-preci">Precios</h1>
        <div class="listaprecios">
            <table class='table table-bordered'>
            <%
                List<DTOCilindro> ListaCilindros = (List<DTOCilindro>) request.getAttribute("ListaCilindros");
                for(int i = 0; i < ListaCilindros.size(); i++){
                    out.print("<tr>");
                    out.print("<td class='td1'>"+ListaCilindros.get(i).getEmpresa()+" "+"</td>");
                    out.print("<td class='td2'>"+ListaCilindros.get(i).getCapacidad()+" Libras </td>");
                    out.print("<td class='td3'><hr></td>");
                    out.print("<td class='td4'> $"+ListaCilindros.get(i).getPrecio()+"</td>");
                    out.print("</tr>");    
                }
                %>
                </table>
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
