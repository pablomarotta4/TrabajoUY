<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mis Postulaciones</title>
	<link rel="stylesheet" href="media/styles/loginMovilCss.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<%@page import="server.CollectionBean"%>
	<%@page import="server.DataUsuario"%>	
	<%@page import="server.DtOfertaLaboral"%>	
	<%@page import="server.DataEmpresa"%>
	<%@page import="server.DataPostulante"%>
	<%@page import="java.util.ArrayList"%>	
</head>
<body style="background: lightgray;">
	<%
	DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
	%>
	<nav class="navbar navbar-expand-lg " style="background-color: #296073;">
	        <div class="container-fluid">
	          <a href="homeMovil"><img src="media/images/trabajoUy.png" class="img-fluid" style="width: 100px;"></a>
	          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	          </button>
	          <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	              <form action="/trabajouy/homeMovil" method="GET">
		              <li class="nav-item dropdown">
		                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: white;">
		                  Empresas
		                </a>
		                <ul class="dropdown-menu">
		                <%
		                server.WebServerService servicio = new server.WebServerService();
		        		server.WebServer port = servicio.getWebServerPort();
						CollectionBean empresas = port.listarNickEmpresas();
		        		
		        		for(String empresa : empresas.getListaStrings()){
		        		%>
		        			<li><a class="dropdown-item" href="homeMovil?filter=<%=empresa %>&nickname=<%= usuario.getNickname()%>"><%=empresa %></a></li>
		        		<%	
		        		}
		                %>
	
		                </ul>
	              	</li>
	              </form>
	              <li class="nav-item">
	                <a class="nav-link active" href="listaPostulaciones?nickname=<%= usuario.getNickname()%>" style="color: white;">Postulaciones</a>
	              </li>
	              <form action="/trabajouy/homeMovil" method="GET">
		              <li class="nav-item dropdown">
		                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: white;">
		                  Keywords
		                </a>
		                <ul class="dropdown-menu">
		                <%
		        		CollectionBean keywords = port.listarKeywords();
		        		
		        		for(String keyword : keywords.getListaStrings()){
		        		%>
		        			<li><a class="dropdown-item" href="homeMovil?filter=<%=keyword %>&nickname=<%= usuario.getNickname()%>"><%=keyword %></a></li>
		        		<%	
		        		}
		                %>
	
		                </ul>
	              	</li>
	              </form>
	              
	            </ul>
	            <div class="d-flex perfil" role="search">
	              <img src="media/images/trabajoUy.png" class="img-fluid" style="width: 100px; padding-right: 20px;">
	              <%
						
						if(usuario != null){
				  %>
	              <h2 class="navbar-brand d-flex align-items-center justify-content-center m-3"  style="color: white;"><%= usuario.getNombre()%> <%=usuario.getApellido() %></h2>
				  <span class="navbar-brand d-flex align-items-center justify-content-center"  style="color: white; margin: 0;"> | </span>
				  <a href="/trabajouy/logoutMovil">
				  	<h2 class="navbar-brand d-flex align-items-center justify-content-center m-3"  style="color: white;">Cerrar Sesión</h2>
				  </a>
	              <%
	              	}						
				   %>
	            </div>
	          </div>
	        </div>
	      </nav>
	     <div class="d-flex justify-content-center align-items-center">
	     	<div class="d-flex justify-content-center align-items-center border rounded-5 p-3 bg-white shadow box-area" style="margin-top: 30px; width:50%;">
	     		<h1 >Mis Postulaciones</h1>	 	
	       	</div>
	     </div>

	      
	      <div class="container d-flex justify-content-center align-items-center min-vh-100">
		      <%
		     	 String user = (String) request.getSession().getAttribute("nickname");
		      	 CollectionBean postulaciones = port.consultarPostulaciones(user);
		      	 
		      	 for(DtOfertaLaboral oferta : postulaciones.getListaDtOfertas()){
		      %>
		      <!--CUADRO DE OFERTA-->
	        <div class="border rounded-5 p-3 bg-white shadow box-area" style="width: 85%;margin: 15px;">	
	            <!-- NOMBRE Y DESCRIPCION-->
	            <div class="col-md-6 right-box">
	                <div class="row align-items-center">
	                    <div class="header-text mb-4">
	                        <a href="consultaPostulacionMovil?nombreOferta=<%=java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8")%>&nickname=<%= usuario.getNickname() %>"><h1><strong><%=oferta.getNombre() %></strong></h1></a>
	                    </div>
	                </div>
	            </div>
	
	
	        </div>
		      <%
		      	 }
		      %>
	      
	      
	      
	      
	      	
	      
	      
	      </div>
</body>
</html>