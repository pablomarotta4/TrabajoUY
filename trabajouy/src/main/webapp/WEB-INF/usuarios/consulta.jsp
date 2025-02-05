<%@page import="server.DataUsuario" %>
<%@page import="server.DataEmpresa" %>
<%@page import="server.DataPostulante" %>
<%@page import="server.DtPostulacion" %>
<%@page import="server.DtOfertaLaboral" %>
<%@page import="server.EstadoOferta" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/template/head.jsp"/>
		<title>Perfil de Usuario</title>
		<link rel="stylesheet" href="media/styles/consultaUsuario.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/template/header.jsp"/>
		
		<% 	
			DataUsuario usuarioL = (DataUsuario) request.getSession().getAttribute("usuario_logeado"); 
			DataUsuario usuarioC = (DataUsuario) request.getAttribute("usuario_consulta");
			boolean mismo;
			if ((usuarioL != null) && (usuarioL.getNickname().equals(usuarioC.getNickname()))) {
				mismo = true;
			} else {
				mismo = false;
			}
		%>
		 	<div class="main-container">
		        <div class="datosPresentacion">
		            <div class="cajaImagen">
		                <img src="/trabajouy/imagenes?id=<%=usuarioC.getImageUrl()%>" alt="imagen">
		            </div>
		            <div class="datosBasicos">
		                <h2><%= usuarioC.getNickname() %></h2>
		                <h3>Nombre: <%= usuarioC.getNombre() %></h3>
		                <h3>Apellido: <%= usuarioC.getApellido() %></h3>
		                <h3>Email: <%= usuarioC.getEmail() %></h3>
		                <% 
		                	if(usuarioC instanceof DataEmpresa) { 
		                		DataEmpresa empresa = (DataEmpresa) usuarioC;
		                %>
		                <h3>Link: <%= empresa.getLink() %></h3>
		                <h3>Descripcion: <%= empresa.getDescripcion() %></h3>
		                <% 
		                	} else { 
		                		DataPostulante postulante = (DataPostulante) usuarioC;
		                %>
		                <h3>Nacionalidad: <%= postulante.getNacionalidad() %></h3>
		                <h3>Fecha de Nacimiento: <%= postulante.getDate() %></h3>
		                <%  
		                	} 
		                %>
		            </div>
		        </div>

				<% 
					if (mismo && usuarioC instanceof DataPostulante) {
	            		DataPostulante postulante = (DataPostulante) usuarioC;
	            		ArrayList<DtPostulacion> postulaciones = (ArrayList<DtPostulacion>) postulante.getPostulaciones();
	            %>
	            		<div class="boxes" style="overflow:auto;">
	            <%
	            		if (postulaciones != null) {
	            			for(DtPostulacion pos: postulaciones) { 
	            %>
	            				<div class="boxPerfil">
			                        <h2>Postulacion a Oferta: <a href="/trabajouy/consultarOferta?oferta=<%=pos.getNombreOferta()%>"> <%= pos.getNombreOferta() %></a></h2>
			                        <h3><a href="/trabajouy/consultaPostulacion?nickname=<%=pos.getNickpostulante()%>&nombreOferta=<%= java.net.URLEncoder.encode(pos.getNombreOferta(), "UTF-8")%>"> Ver detalles </a></h3>
			                    </div>
			    <% 			}
               			}
               	%>
	            		</div>
	            <%
           		 	}
					if (usuarioC instanceof DataEmpresa) {
						DataEmpresa empresa = (DataEmpresa) usuarioC;
            			ArrayList<DtOfertaLaboral> ofertas = (ArrayList<DtOfertaLaboral>) empresa.getOfertas();
            			
            			boolean confirmadas = false;
            			for(DtOfertaLaboral ofer: ofertas) {
            				if (ofer.getEstado() == EstadoOferta.CONFIRMADA) {
            					confirmadas = true;
            				}			
            			}
	            
	            		if (confirmadas && ofertas != null) {
	            %>
		            	<div class="boxes" style="overflow:auto;">
		        <%
	            			for(DtOfertaLaboral ofer: ofertas) { 
	            				if (ofer.getEstado() == EstadoOferta.CONFIRMADA) {
	            %>
	            					<div class="boxPerfil">
					                	<h2>Oferta Laboral: <a href="/trabajouy/consultarOferta?oferta=<%=ofer.getNombre()%>"> <%= ofer.getNombre() %></a> (<%= ofer.getEstado() %>)</h2>
					                </div>
			    <% 				}
			    			}
               			}
               	%>
	            		</div>
	            <%
					}
					if (mismo && usuarioC instanceof DataEmpresa) {
						DataEmpresa empresa = (DataEmpresa) usuarioC;
            			ArrayList<DtOfertaLaboral> ofertas = (ArrayList<DtOfertaLaboral>) empresa.getOfertas();
	            
	            		if (ofertas != null) {
	            %>
		            	<div class="boxes" style="overflow:auto;">
		        <%
	            			for(DtOfertaLaboral ofer: ofertas) { 
	            				if (ofer.getEstado() != EstadoOferta.CONFIRMADA) {
	            %>
	            					<div class="boxPerfil">
					                	<h2>Oferta Laboral: <a href="/trabajouy/consultarOferta?oferta=<%=ofer.getNombre()%>"> <%= ofer.getNombre() %></a> (<%= ofer.getEstado() %>)</h2>
					                </div>
			    <% 				}
			    			}
               			}
               	%>
	            		</div>
	            <%
           		 	}
				%>		
			</div> <!-- div de container -->
	</body>
</html>