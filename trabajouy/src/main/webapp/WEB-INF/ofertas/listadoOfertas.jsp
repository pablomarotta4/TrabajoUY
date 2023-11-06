<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="server.DtOfertaLaboral"%>
<%@page import="server.DataUsuario"%>
<%@page import="server.DataEmpresa"%>
<%@page import="server.DataPostulante"%>

<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<link rel="stylesheet" href="media/styles/listadoOfertas.css">
    <title>Ofertas laborales</title>
</head>
<body>
	<!--HEADER-->
	<jsp:include page="/WEB-INF/template/header.jsp" />

    <div class="main-container" style="padding-top: 30px">
    	<%
    		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
    		if(usuario != null){
    			if(usuario instanceof DataEmpresa){
    	%>
		        <div class="crear-oferta">
		            <a href="/trabajouy/crearOferta"><input type="button" value="Crear oferta"></a>
		        </div>
        <%	
    			}
   			}
        	ArrayList<DtOfertaLaboral> ofertas = (ArrayList<DtOfertaLaboral>) request.getAttribute("lista_ofertas");
       		if(ofertas != null){
        		for(DtOfertaLaboral oferta : ofertas){	
        %>
        	<div id="ContenedorCajas">
	         <div class="caja">
	            <div class="cajaImagen">
	                <img src=<%= oferta.getImageUrl() %> title="imagen-oferta" alt="imagen-oferta" style="max-height: 100%">
	            </div>
	            <div class="contenido">
	                <h3><a href="consultarOferta?oferta=<%=java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>"><%= oferta.getNombre() %></a></h3>
	                <h3 style="font-family:monospace" ><%= oferta.getNombreEmpresa() %></h3>
	                <p><%= oferta.getDescripcion() %></p>
	                <% if (usuario instanceof DataPostulante){ 
	            		server.WebServerService servicio = new server.WebServerService();
	            		server.WebServer port = servicio.getWebServerPort();
	                	
	                	if (!port.estaPostulado(usuario.getNickname(),oferta.getNombre())){
	                	    %>
					<a href="/trabajouy/postulacion?nombreOferta=<%= java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>">Postularme</a>
						<% } 
						else {%>
					<a href="/trabajouy/postulacion?nombreOferta=<%= java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>">Consultar postulación</a>
						<% }
					}%>
	        	</div>
	        </div>
        <%
        		}
				if (ofertas.size() == 0) {       		
        %>
        		<h2>La búsqueda no obtuvo ninguna oferta como resultado.</h2>
        <%
				} 
        		
       		}
        %>
    		</div>
    </div>
</body>
</html>