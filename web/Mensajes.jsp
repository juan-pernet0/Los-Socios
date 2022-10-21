<%-- 
    Document   : Mensajes
    Created on : 1/11/2021, 11:15:17 AM
    Author     : user
--%>
<%@include file="Icono.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Mensajes</title>
    </head>
    <body>
        <div class="contenerdor"></div>
        <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <%
            String caso = (String) request.getAttribute("caso");
            switch (caso) {
                case "1":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Usuario Registrado Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "2":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los datos no se registraron, probablemente el documento ya este registrado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "3":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Correctamente eliminado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "4":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los datos NO fueron correctamente eliminados, probablemente debido a que este usuario tiene pedidos a su nombre',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "5":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Datos Correctamente Modificados.',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "6":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los Datos No pudieron ser modificados correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "7":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Registrado Correctamente, Ingrese sus datos al login e ingrese al sistema',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'login.jsp';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "8":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'No se Pudieron Registrar los datos, Probablemente porque ya hay en el sistema alguien con el documento insertado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'RegistrarUsuario.jsp';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "9":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Lote registrado correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlCilindro';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "10":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los datos No pudieron ser registrados',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlCilindro';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "11":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'El lote selecionado para registrar una devolucion ya habia sido seleccionado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPrestamo?accion=regresarmensaje';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "12":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'No has iniciado sesion, dirijase al login y entre a su cuenta',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlLogin';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "13":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'La devolucion no pudo ser Registrada Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPrestamo';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "14":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Devolucion registrada Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPrestamo';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "15":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Añada cilindros para devolver',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPrestamo?accion=regresarmensaje2';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "16":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'La lista de cilinros esta Vacia',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPrestamo?accion=regresarmensaje2';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "17":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Pedido Actualizado correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPedido';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "18":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'El pedido no pudo ser actualizado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlPedido';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "19":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Pedido hecho correctamente, Verifique la unidad de descargas para verificar Su Factura',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlCilindro?accion=regresarmensaje';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "20":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Prestamo hecho correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlCilindro?accion=regresarmensaje';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "21":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'El Registro Se Inserto Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlLlenado?';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "22":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Empresa Registrada Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlEmpresa';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "23":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los datos no se registraron, probablemente el NIT ya este registrado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlEmpresa';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "24":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Datos Correctamente Modificados.',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlEmpresa';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "25":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los Datos No pudieron ser modificados correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlEmpresa';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "26":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Rol Registrado Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlRol';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "27":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los datos no se registraron, probablemente el Rol ya este registrado',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlRol';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "28":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Datos Correctamente Modificados.',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlRol';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "29":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Datos Correctamente Modificados.',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = './ControlUsuario?accion=DatosUsu&Doc=" + request.getAttribute("doc") + "';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "30":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'ERROR',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Los Datos No pudieron ser modificados correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = './ControlUsuario?accion=DatosUsu&Doc=" + request.getAttribute("doc") + "';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "31":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Copia De Seguridad Creada Correctamente',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlUsuario';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "32":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("icon: 'error',");
                    out.print("title: 'Ocurrio un error',");
                    out.print("text: 'Agregue un producto Para Poder Confirmar',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = 'ControlLlenado?accion=llend';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
                case "33":
                    out.print("<script type='text/javascript'>");
                    out.print("Swal.fire({");
                    out.print("position: 'top-center',");
                    out.print("icon: 'success',");
                    out.print("title: 'Datos Correctamente Modificados.',");
                    out.print("showConfirmButton: true");
                    out.print("}).then((result) => {");
                    out.print("if (result.isConfirmed) {");
                    out.print("parent.location.href = './ControlCilindro';");
                    out.print("}");
                    out.print("});");
                    out.print("</script>");
                    break;
            }
        %>
    </body>

</html>
