<%@page import="com.trabajouy.model.logica.datatypes.DataUsuario" %>
<%@page import="com.trabajouy.model.logica.datatypes.DataEmpresa" %>
<%@page import="com.trabajouy.model.logica.datatypes.DataPostulante" %>
<%@page import="com.trabajouy.model.logica.datatypes.DTPostulacion" %>
<%@page import="com.trabajouy.model.logica.datatypes.DTOfertaLaboral" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/template/head.jsp"/>
		<title>Perfil de Usuario</title>
		<link rel="stylesheet" href="media/styles/consultaUsuario.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/template/header.jsp"/>
		
		<% 	DataUsuario usuarioL = (DataUsuario) request.getSession().getAttribute("usuario_logeado"); 
			DataUsuario usuarioC = (DataUsuario) request.getAttribute("usuario_consulta");
			boolean mismo;
			if ((usuarioL != null) && (usuarioL.getNickname() == usuarioC.getNickname())) {
				mismo = true;
			} else {
				mismo = false;
			}
		%>
	 	<div class="main-container">
	        <div class="datosPresentacion">
	            <div class="cajaImagen">
	                <img src=<%= usuarioC.getImage() %> alt="imagen">
	            </div>
	            <div class="datosBasicos">
	                <h2><%= usuarioC.getNickname() %></h2>
	                <h3>Nombre: <%= usuarioC.getNombre() %></h3>
	                <h3>Apellido: <%= usuarioC.getApellido() %></h3>
	                <h3>Email: <%= usuarioC.getEmail() %></h3>
	                <% if(usuarioC instanceof DataEmpresa) { 
	                		DataEmpresa empresa = (DataEmpresa) usuarioC;
	                %>
	                <h3>Link: <%= empresa.getLink() %></h3>
	                <h3>Descripcion: <%= empresa.getDescripcion() %></h3>
<!----------------  listar solo ofertas confirmadas --------------------------------------->
	                <% } else { 
	                		DataPostulante postulante = (DataPostulante) usuarioC;
	                %>
	                <h3>Nacionalidad: <%= postulante.getNacionalidad() %></h3>
	                <h3>Fecha de Nacimiento: <%= postulante.getNacimiento() %></h3>
	                <% } 
	                if (mismo) {
	                %>
	                <a href="modificarDatosEmpresa.html">Editar datos</a>
	                <% } %>
	            </div>
	        </div>
	        
	        <div class="boxes">
            	

            	<% if (mismo && usuarioC instanceof DataPostulante) {
	            		DataPostulante postulante = (DataPostulante) usuarioC;
	            		List<DTPostulacion> postulaciones = postulante.getPostulaciones();
	            		if (postulaciones != null) {
	            		%>
	                    	
		            	<% for(DTPostulacion pos: postulaciones) { %>
		            		<div class="boxPerfil">
		                        <h2>Postulacion a Oferta: <a href="/trabajouy/consultarOferta?oferta=<%=pos.getNombreOferta()%>"> <%= pos.getNombreOferta() %></a></h2>
		                        <h3><a href="/trabajouy/postulacion?nombreOferta=<%= java.net.URLEncoder.encode(pos.getNombreOferta(), "UTF-8")%>"> Ver detalles </a></h3>
		                    </div>
		            	<% }
						}
               		}
            		if (usuarioC instanceof DataEmpresa) {
	            		DataEmpresa empresa = (DataEmpresa) usuarioC;
	            		List<DTOfertaLaboral> ofertas = empresa.getOfertasLaborales();
	            		
	            		if (ofertas != null) {
		            		%>
<!----------------  listar todas las ofertas aunque no deberia luego en la tarea3 --------------------------------------->		                    	
			            	<% for(DTOfertaLaboral ofer: ofertas) { %>
			            		<div class="boxPerfil">
			                        <h2>Oferta Laboral: <a href="/trabajouy/consultarOferta?oferta=<%=ofer.getNombre()%>"> <%= ofer.getNombre() %></a> (<%= ofer.getEstado() %>)</h2>
			                    </div>
			            	<% }
							}

            		} 
/*aca deberian ir los paquetes 		
            		if (mismo && usuarioC instanceof DataEmpresa) { 
            			DataEmpresa empresa = (DataEmpresa) usuarioC;
            			
            		} */
            		%>


            	
       	 </div>
		</div>
		

		
		
		
		
		
		

		
		
		
		

		
	</body>
</html>