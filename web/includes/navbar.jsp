<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;"> 
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="<%=request.getContextPath()%>/imagen/logo.jpeg" style="height: 50px">REDYCOM SOLUTIONS
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=Principal">Inicio</a>  
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="EquipoControlador?accion=ListarEquipos">Registro</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="DespachoControlador?accion=listarDespachos">Despacho</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="EquipoControlador?accion=listarPersonal">Personal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Controlador?accion=Dashboard">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Controlador?accion=logout">Salir
                        <i class="bi bi-box-arrow-left"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>