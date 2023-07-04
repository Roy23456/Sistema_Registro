<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    
    <body>
        <jsp:include page="includes/navbar.jsp"></jsp:include>
        
        <div class="container-fluid">
            <div class="row py-3 justify-content-center">
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">TOTAL DE DESPACHOS</h6>
                        </div>
                        
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <diV class="col">
                                    <div class="container">
                                        <table class="table table-hover text-center">
                                            <thead>
                                                <tr>
                                                    <th>EQUIPO</th>
                                                    <th>MES</th>
                                                    <th>TOTAL</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="datos" items="${lista1}">
                                                    <tr>
                                                        <td>${datos.getDescripcion()}</td>
                                                        <td>${datos.getMes()}</td>
                                                        <td>${datos.getCantidadTotal()}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Pie Chart -->
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">TOTAL DE REGISTROS</h6>
                        </div>
                        
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <div class="container">
                                    <table class="table table-hover text-center">
                                        <thead>
                                            <tr>
                                                <th>EQUIPO</th>
                                                <th>MES</th>
                                                <th>TOTAL</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="datos" items="${lista2}">
                                                <tr>
                                                    <td>${datos.getDescripcion()}</td>
                                                    <td>${datos.getMes()}</td>
                                                    <td>${datos.getCantidadTotal()}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
