<%-- 
    Document   : IndexLlenado
    Created on : 2/08/2021, 08:43:59 PM
    Author     : USUARIO
--%>

<%@page import="dto.DTOLlenado_Cilindros"%>
<%@page import="dto.DTOLlenado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Llenado</title>
    </head>
    <body>
        <div class="buscar">
                 <form action="ControlLlenado" method="post">
			<div class="form-group col">
				<input autofocus class="form-control" type="text" name="buscar" placeholder="Codigo, Empresa, Capacidad">
				<button type="submit" name="boton1" class="btn btn-dark">Buscar</button>
			</div>
	</form>
            </div>
        <div class="containerllenado">
            <div class="listallenado">
                <%
                    List<DTOLlenado_Cilindros> listaLlenadoCilindros = (List<DTOLlenado_Cilindros>) request.getAttribute("listallenadoscilindros");
                List<DTOLlenado> listaLlenados = (List<DTOLlenado>) request.getAttribute("listallenados");
            if(listaLlenadoCilindros.size()>=1){
                %>
                <table class='table table-bordered'>
                    <tr>
                        <th scope="col" >Codigo</th>
                        <th scope="col">Fecha De Llenado</th>
                        <th scope="col">Empresa</th>
                        <th scope="col">Capacidad</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Precio</th>
                        
                        <!--<th scope="col" colspan="2">Acciones</th>-->
                        
                    </tr>
        <%
            
            for(int i = 0; i < listaLlenadoCilindros.size(); i++){
                out.print("<tr>");
                for(int l = 0; l < listaLlenados.size(); l++){
                    if(listaLlenadoCilindros.get(i).getCodigoLlenado()==listaLlenados.get(l).getCodigo()){
                    out.print("<td>"+listaLlenados.get(l).getCodigo()+" "+"</td>");
                    out.print("<td>"+listaLlenados.get(l).getFechallenado()+" "+"</td>");
                    out.print("<td>"+listaLlenados.get(l).getNitEmpresa()+" "+"</td>");
                    }
                    /*out.print("<td><button class='btn btn-danger'><a href='./ControlLlenado?accion=eliminar&id="+listaLlenados.get(i).getCodigo()+"'>Eliminar</a></button></td>");
                    out.print("<td><button class='btn btn-warning'><a href='./ControlLlenado?accion=Modifi&id"+listaLlenados.get(i).getCodigo()+"'>Modificar</a></button></td>");*/                     
                }
                out.print("<td>"+listaLlenadoCilindros.get(i).getCodCilindro()+" "+"</td>");
                out.print("<td>"+listaLlenadoCilindros.get(i).getCantidad()+" "+"</td>");
                out.print("<td>"+listaLlenadoCilindros.get(i).getPrecio()+" "+"</td>");
                /*out.print("<td><button class='btn btn-danger'><a href='./ControlLlenado?accion=eliminar&id="+listaLlenados.get(i).getCodigo()+"'>Eliminar</a></button></td>");
                out.print("<td><button class='btn btn-warning'><a href='./ControlLlenado?accion=Modifi&id"+listaLlenados.get(i).getCodigo()+"'>Modificar</a></button></td>");*/
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
            <div class="btn-regiter">
            <form action="ControlLlenado" method="POST">
                                <button type="submit" class="btn btn-primary" value="llend" name="accion">Hacer Llenado</button>
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