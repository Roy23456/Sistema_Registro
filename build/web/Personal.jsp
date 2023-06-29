<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    <body>
        <jsp:include page="includes/navbar.jsp"></jsp:include>
        <h3 class="container mt-3">LISTA DE PERSONAL EN ALMACÉN</h3><hr>
        
        <div class="container mt-4">
            <div class="card border-dark">                
                <div class="card-body">
                    <table class="table table-hover text-center">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Cargo</th>
                                <th> </th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach var="lista" items="${lista}">
                                <tr>
                                    <td>${lista.getIdPersonal()}</td>
                                    <td>${lista.getNombre()}</td>
                                    <td>${lista.getCargo()}</td>
                                    <td>
                                        <a href="" class="btn btn-outline-warning">
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
    </body>
</html>
