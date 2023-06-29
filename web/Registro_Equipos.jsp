<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    
    <body>
        <jsp:include page="includes/navbar.jsp"></jsp:include>
        
        <h3 class="container mt-3">REGISTRO DE EQUIPOS</h3><hr>
        
        <div class="container">
            <div class="card border-primary h-100 py-2">
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.getIdUsuario()}">
                            <a id="agregarEquipos" class="btn btn-outline-success">Agregar Equipo</a>
                        </div>  
                        
                        <div class="col" align="right">
                            <form class="form-inline my-2 my-lg-0">
                            <a>Buscar: </a>
                            <input class="form-control-sm" type="search" placeholder="Search" aria-label="Search">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container mt-4">
            <div class="card border-dark">                
                <div class="card-body">
                    <table class="table table-hover text-center">
                        <thead>
                            <tr>
                                <th>Codigo SAP</th>
                                <th>Serie</th>
                                <th>Descripcion</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Fecha</th>
                                <th> </th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach var="e" items="${lista}">
                                <tr>
                                    <td>${e.getCodigo_SAP()}</td>
                                    <td>${e.getSerie()}</td>
                                    <td>${e.getDescripcion()}</td>
                                    <td>${e.getCantidad()}</td>
                                    <td>S/ ${e.getPrecio()}</td>
                                    <td>${e.getFecha()}</td>
                                    <td>
                                        <a href="" class="btn btn-outline-warning">
                                            <span class="bi bi-pencil-square">Editar</span>
                                        </a>
                                            
                                        <a id="eliminarEquipo" class="btn btn-outline-danger">
                                            <input type="hidden" id="idEquipo" name="idEquipo" value="${e.getIdEquipo()}">
                                            <span class="bi bi-trash">Eliminar</span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="js/Equipos.js"></script>
    </body>
</html>
