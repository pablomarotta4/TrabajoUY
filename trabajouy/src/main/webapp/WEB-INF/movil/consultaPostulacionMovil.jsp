<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta Postulacion</title>
    <link rel="stylesheet" href="media/styles/homeMovilCss.css">
    <link rel="stylesheet" href="media/styles/loginMovilCss.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <%@page import="server.CollectionBean"%>
    <%@page import="server.DtPostulacion"%>
    <%@page import="server.DataUsuario"%>
    <%@page import="server.DtOfertaLaboral"%>
<body style="background: lightgray">

	<%
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
    	DtPostulacion datosPostulacion = (DtPostulacion) request.getSession().getAttribute("datosPostulacion");
		server.WebServerService servicio = new server.WebServerService();
		server.WebServer port = servicio.getWebServerPort();
    	DtOfertaLaboral oferta = port.listarDatosOferta(datosPostulacion.getNombreOferta());
    	DataUsuario datosPostulante = port.consultarDatosUsuario(datosPostulacion.getNickpostulante());
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
	      
	      <div class="container d-flex justify-content-center align-items-center min-vh-100">

          	<!--CUADRO DE EMPRESA-->
        	<div class="border rounded-5 p-3 bg-white shadow box-area" style="width: 100%;margin: 15px;">

            	<!-- NOMBRE Y DESCRIPCION-->
            	<div class="col-md-6 right-box">
                	<div class="row align-items-center">
                    	<div class="header-text mb-4">
                        	<h1 style="font-family: monospace;color: gray;">Postulación a <%=oferta.getNombre() %></h1>
                    	</div>
                    	<div class="mb-3">
		                    <p><strong>Nombre: </strong><%= datosPostulante.getNombre() %> <%= datosPostulante.getApellido() %> </p>
				            <p><strong>CV Reducido: </strong><%= datosPostulacion.getCvReducido() %></p>
				            <p><strong>Motivación: </strong><%= datosPostulacion.getMotivacion() %></p>
				            <p><strong>Fecha de Postulación: </strong><%= datosPostulacion.getFechaPostulacion().toString() %></p>
                    	</div>
                	</div>
            	</div>


       	  	</div>
       	  </div>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>