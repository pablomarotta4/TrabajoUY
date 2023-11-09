<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="media/styles/homeMovilCss.css">
	<link rel="stylesheet" href="media/styles/loginMovilCss.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <%@page import="com.trabajouy.controllers.LoginMovil"%>
	<%@page import="server.DataUsuario"%>	
	<%@page import="server.DtOfertaLaboral"%>	
	<%@page import="server.DataEmpresa"%>
	<%@page import="server.DataPostulante"%>
	<%@page import="java.util.ArrayList"%>
</head>
<body style="background: lightgray">

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
	      
	      <div class="container d-flex justify-content-center align-items-center min-vh-100">
	      <%	
    			
   			
        	ArrayList<DtOfertaLaboral> ofertas = (ArrayList<DtOfertaLaboral>) request.getAttribute("lista_ofertas");
       		if(ofertas != null){
        		for(DtOfertaLaboral oferta : ofertas){	
       	  %>
	      <!-- OFERTAS -->

	        <!--CUADRO DE OFERTA-->
	        <div class="border rounded-5 p-3 bg-white shadow box-area" style="width: 85%;margin: 15px;">
	
	            <!-- FOTO --> 
	            <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: lightblue;">
	                <div class="featured-image mb-3">
	                    <img src=<%= oferta.getImageUrl() %>" class="img-fluid" style="width: 250px;">
	                </div>
	            </div>
	
	            <!-- NOMBRE Y DESCRIPCION-->
	            <div class="col-md-6 right-box">
	                <div class="row align-items-center">
	                    <div class="header-text mb-4">
	                        <a href="consultaOfertaMovil?oferta=<%=java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>"><h2 style="font-family: monospace;color: gray;"><%= oferta.getNombre() %></h2></a>
	                    </div>
	                    <div class="input-group mb-3">
	                    	<p><%=oferta.getDescripcion() %></p>
	                    </div>
	                </div>
	            </div>
	
	
	        </div>
	        <%
        		}
       		}
	        %>
	        </div>
	  
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>