<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    
    <body>
        <div class="container-fluid">

            <!-- Content Row -->

            <div class="row py-3 justify-content-center">

                <!-- Area Chart -->
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">TOTAL DE DESPACHOS</h6>
                        </div>
                        
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <div id="chartIngresos" style="height: 300px; width: 100%;">
                                    <diV class="col-sm-3">
                                        <div class="container">
                                            <table class="table table-hover text-center">
                                                <thead>
                                                    <tr>
                                                        <th>Mercaderia</th>
                                                        <th>Margen</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                <c:forEach var="lista" items="${listado}">
                                                    <tr>
                                                        <td>${lista.getNombre()}</td>
                                                        <td></td>
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
                
                <!-- Pie Chart -->
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">TOTAL DE REGISTROS</h6>
                        </div>
                        
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <div id="chartCostos" style="height: 300px; width: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
    </body>
</html>
