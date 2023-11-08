<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="media/styles/homeMovilCss.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <%@page import="com.trabajouy.controllers.LoginMovil"%>
	<%@page import="server.DataUsuario"%>	
</head>
<body>

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
						DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
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
	  
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>