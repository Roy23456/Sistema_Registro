/* global Swal */
const date = new Date();
const fecha = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');

$(document).ready(function () {
    $("#agregarEquipos").click(function () {
        var idUsuario = document.getElementById('idUsuario').value;
        
        Swal.fire({
            title: "REGISTRO DE EQUIPOS NUEVOS",
            html: ` <form name="form">
                        <input type="hidden" name="fecha"     id="fecha"        value="${fecha}">
                        <input type="hidden" name="idUsuario" id="idUsuario"    value="${idUsuario}">
                        
                        <div class="form-group row">
                            <label class="col-sm-4">Codigo SAP: </label>
                            <div class="col-sm-7">
                                <input type="number" name="codigoSAP" id="codigoSAP" class="form-control-lg" placeholder="Codigo equipo...">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Serie: </label>
                            <div class="col-sm-7">
                                <input type="text"  name="serie" id="serie"    class="form-control-lg" placeholder="Serie...">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Descripcion: </label>
                            <div class="col-sm-7">
                                <input type="text"  name="descripcion" id="descripcion" class="form-control-lg"    placeholder="Descripción...">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Cantidad: </label>
                            <div class="col-sm-7">
                                <input type="number" name="cantidad" id="cantidad" class="form-control-lg" >
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Precio: </label>
                            <div class="col-sm-7">
                                <input type="number" name="precio" id="precio" class="form-control-lg" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Monto: </label>
                            <div class="col-sm-7">
                                <input type="number"  name="monto" id="monto" class="form-control-lg" placeholder="Monto..." readonly="">
                            </div>
                        </div>
                    </form>`,
            didOpen: () => {
                const cantidad = Swal.getHtmlContainer().querySelector("#cantidad");
                const precio = Swal.getHtmlContainer().querySelector("#precio");
                const monto = Swal.getHtmlContainer().querySelector("#monto");
                precio.oninput = () => {
                    monto.value = "";
                    const total = parseFloat(cantidad.value)*parseFloat(precio.value);
                    if (total > 0) {
                        monto.value = `${total.toFixed(2)}`;
                    }
                };
            },
            showCancelButton: true,
            confirmButtonText: "Agregar",
            cancelButtonText: "Cancelar",
               preConfirm: () => {
                const codigoSAP = Swal.getPopup().querySelector("#codigoSAP").value;
                const serie = Swal.getPopup().querySelector("#serie").value;
                const descripcion = Swal.getPopup().querySelector("#descripcion").value;
                const cantidad = Swal.getPopup().querySelector("#cantidad").value;
                const precio = Swal.getPopup().querySelector("#precio").value;
                const monto = Swal.getPopup().querySelector("#monto").value;
                
                if (!codigoSAP || !serie || !descripcion || !cantidad || !precio || !monto) {
                    Swal.showValidationMessage(`!Llene todos los campos¡`); 
                }
            }
        }).then((result) => {
            if (result.isConfirmed) {
                var idUsuario = Swal.getPopup().querySelector("#idUsuario").value;
                var codigoSAP = Swal.getPopup().querySelector("#codigoSAP").value;
                var serie = Swal.getPopup().querySelector("#serie").value;
                var descripcion = Swal.getPopup().querySelector("#descripcion").value;
                var cantidad = Swal.getPopup().querySelector("#cantidad").value;
                var precio = Swal.getPopup().querySelector("#precio").value;
                var fecha = Swal.getPopup().querySelector("#fecha").value;
                
                $.ajax({
                    type: 'POST',
                    url: 'EquipoControlador?accion=AgregarEquipo',
                    data: {
                        'idUsuario': idUsuario,
                        'codigoSAP': codigoSAP,
                        'serie': serie,
                        'descripcion': descripcion,
                        'cantidad': cantidad,
                        'precio': precio,
                        'fecha': fecha
                    },
                    success: function () {
                        Swal.fire(
                                '¡Registro exitoso!',
                                '¡Se guardaron los datos correctamente!'
                                ).then((result) => {
                            if (result.isConfirmed) {
                                parent.location.href = "EquipoControlador?accion=ListarEquipos";
                            }
                        });
                    }
                });
            }
        });
    });
    
    $("tr #eliminarEquipo").click(function () {
        var idEquipo = $(this).parent().find("#idEquipo").val();;

        Swal.fire({
            title: "¿Está Seguro de Eliminar?",
            text: "¡Una vez eliminado, Ud. puede agregar de nuevo!",
            icon: "warning",
            allowOutsideClick: false,
            showCancelButton: true,
            confirmButtonText: "Eliminar",
            cancelButtonText: "Cancelar",
            dangerMode: true

        }).then((result) => {

            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: 'EquipoControlador?accion=eliminarEquipo',
                    
                    data: {
                        'idEquipo': idEquipo
                    },
                    
                    success: function () {
                        Swal.fire(
                                '¡Se eliminaron los datos correctamente!'
                                ).then((result) => {
                                    
                            if (result.isConfirmed) {
                                parent.location.href = "EquipoControlador?accion=ListarEquipos";
                            }
                        });
                    }
                });
                
            } else {
                Swal.fire("¡Registro no eliminado!");
            }
        });
    });
    
    //DESPACHO  
    $("#agregarDespacho").click(function () {
        var idUsuario = document.getElementById('Usuario').value;
        var idEquipo = document.getElementById('Equipo').value;
        var idPersonal = document.getElementById('Personal').value;
        var Cantidad = document.getElementById('Cantidad').value;
        
        if (!idEquipo || !idPersonal || !Cantidad) {
            Swal.fire({
                title: '¡Por favor, llene los todos los campos!',
                allowOutsideClick: false
            });
            
        } else if (!idUsuario) {
            Swal.fire({
                title: '¡Vuelva a iniciar sesión, por favor!',
                allowOutsideClick: false
            });
            
        } else {
            
            $.ajax({
                type: 'POST',
                url: 'EquipoControlador?accion=agregarDespacho',
                data: {
                    'idEquipo': idEquipo,
                    'idPersonal': idPersonal,
                    'idUsuario': idUsuario,
                    'Cantidad': Cantidad,
                    'fecha': fecha
                },
                success: function () {
                    Swal.fire(
                            '¡Registro exitoso!',
                            '¡Se guardaron los datos correctamente!'
                            ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "EquipoControlador?accion=listarDespachos";
                        }
                    });
                }
            });
        }
    });
    
    //EditarDespacho
    $("#editarDespacho").click(function () {
        var idEquipo = document.getElementById('equipo').value;
        document.getElementById('fecha').value = fecha;
        
        if (idEquipo === 0) {
            Swal.fire({
                title: '¡Por favor, Seleccione una opción valida!',
                allowOutsideClick: false
            });
            
        } else {
            document.form.action = "EquipoControlador?accion=actualizarDespacho";
            document.form.method = "POST";
            document.form.submit();
        }
    });
    
    //Eliminar Despacho
    //EditarDespacho
    $("#eliminarDespacho").click(function () {
        var idDespacho = document.getElementById('idDespacho').value;
        
        Swal.fire({
            title: "¿Está Seguro de Eliminar?",
            text: "¡Una vez eliminado, Ud. puede agregar de nuevo!",
            icon: "warning",
            allowOutsideClick: false,
            showCancelButton: true,
            confirmButtonText: "Eliminar",
            cancelButtonText: "Cancelar",
            dangerMode: true

        }).then((result) => {

            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: 'EquipoControlador?accion=eliminarDespacho',
                    
                    data: {
                        'idDespacho': idDespacho
                    },
                    
                    success: function () {
                        Swal.fire(
                                '¡Se eliminaron los datos correctamente!'
                                ).then((result) => {
                                    
                            if (result.isConfirmed) {
                                parent.location.href = "EquipoControlador?accion=listarDespachos";
                            }
                        });
                    }
                });
                
            } else {
                Swal.fire("¡Registro no eliminado!");
            }
        });
    });
});

