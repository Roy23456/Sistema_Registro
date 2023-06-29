
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Formulario CSS</title>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    </head>

    <body>
             
        <div class="contenedor-formulario contenedor">
            <div class="imagen-formulario">

            </div>

            <form name="form" class="formulario">
                <div class="texto-formulario">
                    <h2>Bienvenidos al sistema</h2>
                    <p>Inicia sesión con tu cuenta</p>
                </div>

                <div class="input">
                    <label for="usuario">Usuario</label>
                    <input placeholder="Ingresa tu nombre" type="text" name="usuario" id="usuario">
                </div>

                <div class="input">
                    <label for="contraseña">Contraseña</label>
                    <input placeholder="Ingresa tu contraseña" type="password" name="password" id="password">
                </div>

                <div class="password-olvidada">
                    <a href="Registro.jsp">Registrarse</a>
                </div>

                <div class="input">
                    <input id="ingresar" type="button" value="Ingresar">
                </div>
            </form>
        </div>
        
        <script src="js/login.js" type="text/javascript"></script>
    </body>
</html>


