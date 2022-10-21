$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var idl = $(this).parent().find("#idl").val();
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                EliminarLista(idl);
                Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                        ).then((result) => {
                    if (result.isConfirmed) {
                        parent.location.href = "ControlCilindro?accion=Carrito";
                    }
                });
            } else {
                Swal.fire(
                        'Accion Cancelada',
                        'Registro no eliminado',
                        'error'
                        )
            }
        })
    });
    function EliminarLista(idl){
        var url = "ControlCilindro?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idl=" + idl,
            success: function (data, textStatus, jqXHR) {
            }
        });
    }

    $("tr #Cantidad").click(function () {
        var idl = $(this).parent().find("#idl").val();
        var cantidad = $(this).parent().find("#Cantidad").val();
        var url = "ControlCilindro?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idl=" + idl + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "ControlCilindro?accion=Carrito"
            }
        });
    });
    $("#salir").click(function () {
        Swal.fire({
            title: 'Seguro que quieres salir?',
            text: "Si aceptas saldras de la aplicación",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si, Salir'
        }).then((result) => {
            if (result.isConfirmed) {
                parent.location.href = "ControlLogin?accion=Eliminar";
            } else {
                Swal.fire(
                        'Accion Cancelada',
                        'No cerraras la session',
                        'error'
                        )
            }
        })
    });

    $("tr #CantidadDevolucion").click(function () {
        var CodigoCilindro = $(this).parent().find("#CodCilindro").val();
        var cantidad = $(this).parent().find("#CantidadDevolucion").val();
        var url = "ControlPrestamo?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "CodCilindro=" + CodigoCilindro + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "ControlPrestamo?accion=confirmar"
            }
        });
    });



    $("tr #btnDeleteConfirmar").click(function () {
        var CodigoCilindro = $(this).parent().find("#CodCilindro").val();
        Swal.fire({
            title: 'Eliminar cilindro de la lista',
            text: "Esta Seguro de querer eliminar el cilindro de la lista",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si, elimarlo!'
        }).then((result) => {
            if (result.isConfirmed) {
                eliminar(CodigoCilindro);
                Swal.fire(
                        'Eliminado!',
                        'El Cilindro fue elimnado correctamente.',
                        'success'
                        ).then((result) => {
                    if (result.isConfirmed) {
                        parent.location.href = "ControlPrestamo?accion=confirmarlista";
                    }
                });
            } else {
                Swal.fire(
                        'Accion Cancelada',
                        'Registro no eliminado',
                        'error'
                        )
            }
        })
    });

    function eliminar(CodigoCilindro) {
        var url = "ControlPrestamo?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "CodigoCilindro=" + CodigoCilindro,
            success: function (data, textStatus, jqXHR) {
            }
        });
    }
    $("tr #btnDelete1").click(function () {
        var cod = $(this).parent().find("#id1").val();
        Swal.fire({
            title: 'Deseas Eliminar Este Registro?',
            text: "¡No podrás revertir esto!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar',
            confirmButtonText: 'Eliminar'
        }).then((result) => {
            if (result.isConfirmed) {
                eliminar1(cod);
                Swal.fire(
                        'Eliminado!',
                        'Registro Eliminado Correctamente.',
                        'success'
                        ).then((result) => {
                    if (result.isConfirmed) {
                        parent.location.href = "ControlLlenado?accion=ProcesoConfirmar";
                    }
                });
            } else {
                Swal.fire(
                        'Accion Cancelada',
                        'Registro no eliminado',
                        'error'
                        )
            }
        })
    });
    function eliminar1(cod) {
        var url = "ControlLlenado?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "id1=" + cod,
            success: function (data, textStatus, jqXHR) {
            }
        });
    }
    $("tr #Cantidadllenado").click(function () {
        var idl = $(this).parent().find("#idl").val();
        var cantidad = $(this).parent().find("#Cantidadllenado").val();
        var precio = $(this).parent().find("#Precio").val();
        var url = "ControlLlenado?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idl=" + idl + "&Cantidadllenado=" + cantidad + "&Precio=" + precio,
            success: function (data, textStatus, jqXHR) {
                location.href = "ControlLlenado?accion=ProcesoConfirmar"
            }
        });
    });
    $("tr #Precio").click(function () {
        var idl = $(this).parent().find("#idl").val();
        var precio = $(this).parent().find("#Precio").val();
        var cantidad = $(this).parent().find("#Cantidadllenado").val();
        var url = "ControlLlenado?accion=ActualizarPrecio";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idl=" + idl + "&Precio=" + precio + "&Cantidadllenado=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "ControlLlenado?accion=ProcesoConfirmar"
            }
        });
    });
//    $("#Registrarse_Usuarios").click(function () {
//        var ConfirmacionPassword = document.getElementById('Confirm_Password_Registrar');
//        var Password = $(this).parent().find("#Password_Registrar");
//        if (ConfirmacionPassword.value !== Password.value) {
//            Swal.fire({
//                position: 'top-center',
//                icon: 'warning',
//                title: 'Contraseñas Diferentes',
//                showConfirmButton: false,
//                timer: 1500
//            },willClose: () => {
//    clearInterval(timerInterval)
//  })
//        }
//    });

//
//
//    $("#empresa").change(function () {
//        var Empresa = $(this).parent().find("#empresa").val();
//        var url = "ControlPedido?accion=CambiarEmpresa";
//        $.ajax({
//            type: 'POST',
//            url: url,
//            data: "Empresa=" + Empresa,
//            success: function (data, textStatus, jqXHR) {
//                location.href = "ControlPedido?accion=regresar"
//            }
//        });
//    });
//
//    $("#CodigoCilindro").change(function () {
//        var CodCilindro = $(this).parent().find("#CodigoCilindro").val();
//        var url = "ControlPedido?accion=CambiarCilindro";
//        $.ajax({
//            type: 'POST',
//            url: url,
//            data: "CodCilindro=" + CodCilindro,
//            success: function (data, textStatus, jqXHR) {
//                location.href = "ControlPedido?accion=regresar"
//            }
//        });
//    });

});
