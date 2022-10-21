<%-- 
    Document   : CRUDLlenado
    Created on : 3/08/2021, 09:14:57 AM
    Author     : USUARIO
--%>
<%@include file="Icono.jsp"%>
<%@page import="dto.DTOLlenado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="contenedor">
        <div class="form">
         <form action="ControlLlenado" method="post">
            <%
                
           DTOLlenado dtoLlenado = (DTOLlenado)request.getAttribute("dtoLlenado");
       
            out.print("<input class='form-control' type='text' name='codigo' value='"+dtoLlenado.getCodigo()+"'>");
            out.print("<input class='form-control' type='text' name='fechallenado' value='"+dtoLlenado.getFechallenado()+"'>");
            out.print("<input class='form-control' type='text' name='nitempresa' value='"+dtoLlenado.getNitEmpresa()+"'>");
            out.print("<input class='btn btn-primary' type='submit' value='Modificar' name='button'>");
            
            %>
        </form>
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