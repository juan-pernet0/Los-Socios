<%-- 
    Document   : newjsp
    Created on : 29/06/2021, 09:03:11 AM
    Author     : USUARIO
--%>
<%@include file="Icono.jsp"%>
<%@page import="dto.DTOEmpresa"%>
<%@page import="java.util.List"%>
<%@page import="dto.DTOCilindro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
    <title>Modificar Usuario</title>
  </head>
  <body>
      <div class="contenedor">
        <div class="form">
        <form action="ControlCilindro" method="post">

            <%
                DTOCilindro dtoCilindro = (DTOCilindro) request.getAttribute("dtoCilindro");       
                
                out.print("<input name='codigo' value='" + dtoCilindro.getCodigo() + "' hidden>");  
                out.print("<div class='form-group'>");
                out.print("<label>Empresa</label>");
                
                
                List<DTOEmpresa> Listaempresas = (List<DTOEmpresa>) request.getAttribute("Listaempresas");
                for (DTOEmpresa i : Listaempresas) {
                   if(dtoCilindro.getEmpresa().equals(i.getNit())){
                    out.print("<input class='form-control' type='text' name='nit' value='"+i.getNit()+"' hidden>");
                    out.print("<input class='form-control' type='text' value='"+i.getNombre()+"' readonly>");   
                       
                    }
                }
               
                
                out.print("</div>");
                
                out.print("<div class='form-group'>");
                out.print("<label>Capacidad</label>");
                out.print("<input class='form-control' type='number' name='capacidad' value='"+dtoCilindro.getCapacidad()+"'>");
                out.print("</div>");
                out.print("<div class='form-group'>");
                out.print("<label>Precio</label>");
                out.print("<input class='form-control' type='number' name='precio' value='"+dtoCilindro.getPrecio()+"'>");
                out.print("</div>");
                out.print("<input class='btn btn-primary' type='submit' value='Modificar' name='accion'>");
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