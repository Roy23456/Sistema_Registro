<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    <script language="javascript">
        function atras(){history.back();}
    </script>
    
    <body>
        <div class="container text-center">
            <h1>Edite los datos por favor</h1><hr>

            <form name="form" class="form-control" style=" width: 500px; height: auto">
                <div align="left">
                    
                    Descripcion:
                    <input type="text" name="descripcion" id="descripcion" class="form-control" min="1" value="${listado[0].getDescripcion()}"/>
                    <br>

                    Cantidad:
                    <input type="number" name="cantidad" id="cantidad" class="form-control" min="1" value="${listado[0].getCantidad()}"/>
                    <br>
                    
                    Precio:
                    <input type="number" name="precio" id="precio" class="form-control" min="1" value="${listado[0].getPrecio()}"/>
                    <br>
                </div>
                <br/>
               
                <input type="hidden" name="fecha" id="fecha" value="">
                
                <input type="button" id="editarDespacho" value="Actualizar" class="btn btn-primary btn-lg"/>
                <button type="button" onclick="atras()" class="btn btn-warning btn-lg">Regresar</button>
            </form>
        </div>
        <br>
        
        <script src="js/Equipos.js"></script>
    </body>
</html>
