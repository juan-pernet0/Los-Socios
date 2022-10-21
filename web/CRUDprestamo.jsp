<%@include file="Icono.jsp"%>
<%@page import="dto.DTOPrestamo"%>
<%@page import="dto.DTOUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    
<link rel="stylesheet" href="style.css">
    <title>Hello, world!</title>
  </head>
  <body>
      <div class="contenedor">
        <form action="ControlPrestamo" method="post">
         
           
            <%
           
           DTOPrestamo dtoPrestamo = (DTOPrestamo)request.getAttribute("dtoPrestamo");
           int Codigo = dtoPrestamo.getCodigo();
           
            out.print("<input name='Codigo' value='"+dtoPrestamo.getCodigo()+"' hidden>");
            
            out.print("<select name='doccliente' class='form-select'>");
                List<DTOUsuario> listaUsuarios =(List<DTOUsuario>) request.getAttribute("listaUsuarios");
            for(DTOUsuario i: listaUsuarios){
                if(!i.getRol().equals("Empleado") && !i.getRol().equals("Administrador")){
                out.println("<option value='"+i.getDocumento()+"'>"+i.getNombres()+" "+i.getApellidos()+"</option>");
                }
            }
            out.print("</select>");
            
            out.print("<select name='docempleado' class='form-select'>");
            
            for(DTOUsuario i: listaUsuarios){
                if(i.getRol().equals("Empleado")){
                out.println("<option value='"+i.getDocumento()+"'>"+i.getNombres()+" "+i.getApellidos()+"</option>");
                }
            }
            out.print("</select>");
            out.print("<input type='datetime-local' name='fechapedido' placeholder='Fecha Del Pedido'>");
            out.print("<input type='datetime-local' name='fechaentrega' placeholder='Fecha De La Entrega'>");
            out.print("<input type='text' name='nombredestinatario' placeholder='Nombre Del Destinatario'>");
            out.print("<input type='number' name='documentodestinatario' placeholder='Documento Del Destinatario'>");
            out.print("<input class='btn btn-primary' type='submit' value='Modificar' name='button'>");
            
            %>
        </form>
        </div>
        </div>
  </body>
</html>