$(document).ready(function () {
    $("#ingresar").click(function () {
        var usuario = document.getElementById('usuario').value;
        var password = document.getElementById('password').value;

        if (usuario.length === 0) {
            alert("!Ingresar el Usuario por favor!");

        } else {

            if (password.length === 0) {
                alert("!Ingresar Clave por favor¡");

            } else {
                document.form.action = "Controlador?accion=Ingresar";
                document.form.method = "POST";
                document.form.submit();
            }
        }
    });
});