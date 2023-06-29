<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    
    <body>
        <jsp:include page="includes/navbar.jsp"></jsp:include>
        
        <h3 class="container mt-3">DESPACHO DE EQUIPOS</h3><hr>
        
        <div class="container">
            <div class="card border-primary h-100 py-2">
                <div class="card-body">
                    <div class="row">                      
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
        
        <div class="container py-5">
            <div class="row">
                <div class="col d-flex">
                    <div class="card border-dark">
                        <div class="card-header text-center">
                            <label class="col col-form-label fw-bold"> REGISTRO DE DESPACHO </label>
                        </div>
                        
                        <div class="card-body">
                            <input type="hidden" id="Usuario" name="Usuario" value="${usuario.getIdUsuario()}">
                        
                            <div class="form-group d-flex py-3">
                                <label class="col-sm-4 col-form-label">Equipo: </label>
                                
                                <div class="col-sm-7">
                                    <select name="Equipo" id="Equipo" class="form-control">
                                        <c:forEach var="lista1" items="${equipo}">
                                            <option value="${lista1.getIdEquipo()}"> ${lista1.getDescripcion()} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        
                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Personal: </label>
                                
                                <div class="col-sm-7">
                                    <select name="Personal" id="Personal" class="form-control">
                                        <c:forEach var="lista2" items="${personal}">
                                            <option value="${lista2.getIdPersonal()}"> ${lista2.getNombre()} - ${lista2.getCargo()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        
                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Cantidad: </label>

                                <div class="col-sm-7">
                                    <input type="number" class="form-control" id="Cantidad" name="Cantidad" placeholder="Cantidad..." min="1">
                                </div>
                            </div>
                        
                            <div class="card-footer text-center">
                                <a id="agregarDespacho" class="btn btn-primary">Agregar</a>
                                <a id="cancelarDespacho" class="btn btn-danger">Cancelar</a>
                            </div>
                        </div>
                    </div>
                </div>
            
                <div class="col-sm-8">
                    <div class="card border-dark">                
                        <div class="card-body">
                            <table class="table table-hover text-center">
                                <thead>
                                    <tr>
                                        <th>Codigo SAP</th>
                                        <th>Serie</th>
                                        <th>Descripcion</th>
                                        <th>Cantidad</th>
                                        <th>Fecha</th>
                                        <th> </th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="dato" items="${listar}">
                                        <tr>
                                            <td>${dato.getCodigo_SAP()}</td>
                                            <td>${dato.getSerie()}</td>
                                            <td>${dato.getDescripcion()}</td>
                                            <td>${dato.getCantidad()}</td>
                                            <td>${dato.getFechaDespacho()}</td>
                                            <td></td>
                                            <td>
                                                <a href="EquipoControlador?accion=editarDespacho&idDespacho=${dato.getIdDespacho()}" class="btn btn-outline-warning">
                                                    <span class="bi bi-pencil-square">Editar</span>
                                                </a>

                                                <a href="" class="btn btn-outline-danger">
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
            </div>
        </div>
        
        <script src="js/Equipos.js"></script>
    </body>
</html>
