<%-- 
    Document   : newjsp
    Created on : 8/09/2021, 04:21:22 PM
    Author     : user
--%>
<%@include file="Icono.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">

    <title>Login</title>
  </head>
  <body>
      <h1>Ingreso Usuarios</h1>
      <div class="contenedor">
          <div class="form">
              <form action="ControlLogin" method="post">
                  <label>Documento:</label>
                  <input class="form-control" type="number" name="Documento" placeholder="Documento De Identidad" required minlength="8">
                  
                  <label>Contraseña:</label>
                  <input class="form-control" type="password" name="password" placeholder="Contraseña" required >
                  <input type="submit" value="Ingresar" name="accion" class="btn btn-primary"> 

              </form>
                  <a href="RegistrarUsuario.jsp">No tengo cuenta</a>
                  <%
                  try {
                          int caso;  
                  caso = (int) request.getAttribute("caso");
                  if (caso == 1) {
                        out.print("<script type='text/javascript'>");
                        out.print("alert('La contraseña es incorrecta');");
                        out.print("</script>");
                      }else{
                      if (caso == 2) {
                        out.print("<script type='text/javascript'>");
                        out.print("alert('no esta registarado el documento');");
                        out.print("</script>");
                          }else{
                          if (caso == 3) {
                                out.print("<script type='text/javascript'>");
                        out.print("alert('Ingrese a la aplicacion por medio del login');");
                        out.print("</script>");  
                              }
                      }
                  }
                    caso = 0;  
                      } catch (Exception ex) {
                      }
                      

              %>
          </div>
      </div>
      
      
   
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/prueba.js" type="text/javascript"></script>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    -->
  </body>
</html>
