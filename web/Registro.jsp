<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    <script language="javascript">
        function atras(){history.back();}
    </script>
    
    <body style="background-color: #6DD5FA;">
    <center>
        <div class="container">
            <h1>Registre sus Datos</h1>

            <hr>
            
            <form name="form" class="form-control" style=" width: 500px; height: auto">
            <br/>
                <div align="left">
                    Nombre:
                    <input type="text" name="nombre" id="nombre" class="form-control"/>

                    <br/>

                    Apellido:
                    <input type="text" name="apellido" id="apellido" class="form-control"/>

                    <br/>

                    DNI:
                    <input type="number" name="dni" id="dni" class="form-control" min="1" max="99999999"/>

                    <br/>
                    Correo:
                    <input type="email" name="correo" id="correo" class="form-control"/>

                    <br/>

                    Usuario:
                    <input type="text" name="usuario" id="usuario" class="form-control"/>
                    
                    <br/>

                    Contraseña:
                    <input type="text" name="password" id="password" class="form-control"/>

                    <br>
                </div>
                <br/>

                <input type="button" id="NuevoUsuario" value="Guardar" class=" btn btn-primary btn-lg"/>
                <button type="button" onclick="atras();" class="btn btn-warning btn-lg">Regresar</button>
            </form>
        </div>
        <br>
    </center>

    <script src="js/funciones.js"></script>
    </body>
</html>