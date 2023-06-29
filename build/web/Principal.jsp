
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/header.jsp"></jsp:include>
    
    <body style="background-color: #6DD5FA; background-image: url(imagen/logistica.gif); background-size: cover">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <h1 class="text-center py-4">BIENVENIDO ${usuario.getNombre()}</h1>
    </body>
</html>
