$(document).ready(function () {
    const caracteres = '[a-zA-Z1-9]*';
    
    /*Agregar Cliente*/
    $("#NuevoUsuario").click(function () {
        var nombre = document.getElementById('nombre').value;
        var apellido = document.getElementById('apellido').value;
        var dni = document.getElementById('dni').value;
        var correo = document.getElementById('correo').value;
        var usuario = document.getElementById('usuario').value;
        var password = document.getElementById('password').value;

        if (nombre.length === 0 || apellido === 0 || dni.length === 0 || correo === 0 || usuario === 0 || password === 0) {
            alert("!Todos los campos deben estar llenos!");
        
        /*} else if (nombre.prototype.match(caracteres) || apellido.prototype.match(caracteres) || correo.prototype.match(caracteres) || usuario.prototype.match(caracteres) || password.prototype.match(caracteres)) {
            alert('No se permiten caracteres especiales');*/
            
        } else {
            document.form.action = "Controlador?accion=NuevoUsuario";
            document.form.method = "POST";
            document.form.submit();
        }
    });
});