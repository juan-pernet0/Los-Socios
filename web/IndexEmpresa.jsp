<%@page import="dto.DTOEmpresa"%>
<%@page import="java.util.List"%>
<%@include file="Navbar.jsp"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
    <title>Empresas</title>
  </head>
  <body>
        <div class="buscar">
            <form action="ControlEmpresa" method="post">
                <div class="form-group col">
                    <input autofocus class="form-control" type="text" name="buscar" placeholder="Empresa">
                    <button type="submit" name="boton1" class="btn btn-dark">Buscar</button>
                </div>
            </form>
        </div>
      
      
    <div class="container">
        <div class="form">
         <form action="ControlEmpresa" method="post">
            <input class="form-control" type="text" name="nit" placeholder="NIT">
            <input class="form-control" type="text" name="nombre" placeholder="Nombre">
            <input type="submit" value="Registrar" name="accion" class="btn btn-primary">        
        </form>
        </div>
        
        <div class="lista">
            
         <%
            List<DTOEmpresa> ListaEmpresas = (List<DTOEmpresa>) request.getAttribute("ListaEmpresas");
            if(ListaEmpresas.size()>=1){
                %>
                <table class='table table-bordered'>
                    <tr>
                        <th scope="col">NIT</th>
                        <th scope="col">Nombre</th>
                        <th scope="col" colspan="2">Acciones</th>  
                        
                    </tr>
        <%
            for(int i = 0; i < ListaEmpresas.size(); i++){
                out.print("<tr>");
                out.print("<td>"+ListaEmpresas.get(i).getNit()+" "+"</td>");
                out.print("<td>"+ListaEmpresas.get(i).getNombre()+" "+"</td>");
                out.print("<td><button class='btn btn-warning'><a href='./ControlEmpresa?accion=Seleccionar&nitEm=" + ListaEmpresas.get(i).getNit()+"'>Modificar</a></button></td>");
                out.print("</tr>");                       
            }
            %>
            </table>
            <%
            }else{
               out.print("<p>NO HAY REGISTROS PARA ESTA BUSQUEDA</p>");
            }
            %>
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