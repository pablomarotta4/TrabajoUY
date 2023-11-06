<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="server.DataTipoPublicacion"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Consulta Tipo de Publicación</title>
    <link rel="stylesheet" href="media/styles/consultaTipo.css">
	<jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	
	<%
		DataTipoPublicacion tipo = (DataTipoPublicacion) request.getAttribute("tipo-seleccionado");
	%>
	<div class="principal">
		<div class="box" id="nombre">
        	<p><%= tipo.getNombre() %></p>
        </div>
        <div class="box" id="descripcion">
        	<p>Descripcion: <%= tipo.getDescripcion() %></p>
            <p>Exposicion: <%= tipo.getExposicion() %></p>
            <p>Duracion: <%= tipo.getDuracion() %></p>
            <p>Costo: <%= tipo.getCosto() %></p>
            <p>Fecha de Alta: <%= tipo.getFecha().toString() %></p>
         </div>
	</div>
</body>
</html>