<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta Postulacion</title>
    <link rel="stylesheet" href="media/styles/consultarPostulacion.css">
    <link rel="stylesheet" href="media/styles/basic.css">
    <%@page import="server.DtPostulacion"%>
    <%@page import="server.DataUsuario"%>
    <%@page import="server.DtOfertaLaboral"%>
<body>

	<%
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
	%>
	<nav class="navbar navbar-expand-lg " style="background-color: #296073;">
	        <div class="container-fluid">
	          <img src="media/images/trabajoUy.png" class="img-fluid" style="width: 100px;">
	          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	          </button>
	          <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	              <li class="nav-item">
	                <a class="nav-link active" aria-current="page" href="./listadoEmpresasMovil.html" style="color: white;">Empresas</a>
	              </li>
	              <li class="nav-item">
	                <a class="nav-link active" href="#" style="color: white;">Postulaciones</a>
	              </li>
	              <li class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: white;">
	                  Keywords
	                </a>
	                <ul class="dropdown-menu">
	                  <li><a class="dropdown-item" href="#">Keyword 1</a></li>
	                  <li><a class="dropdown-item" href="#">Keyword 2</a></li>
	                  <li><a class="dropdown-item" href="#">Keyword 3</a></li>
	                </ul>
	              </li>
	            </ul>
	            <div class="d-flex perfil" role="search">
	              <img src="media/images/trabajoUy.png" class="img-fluid" style="width: 100px; padding-right: 20px;">
	              <%
				  	if(usuario != null){
				  %>
	              <h2 class="navbar-brand d-flex align-items-center justify-content-center"  style="color: white;"><%= usuario.getNickname()%></h2>
	              <%
	              	}						
				   %>
	            </div>
	          </div>
	        </div>
	      </nav>

</body>
</html>