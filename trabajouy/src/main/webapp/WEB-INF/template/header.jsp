<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.controllers.Login"%>
<%@page import="com.trabajouy.model.logica.datatypes.DataUsuario"%>
<header class="header">
	<div class="home">
	    <a href="home"><img src="media/images/trabajoUy.png" alt=""></a>
	</div>
	<div class="navbar">
       	<form action="ofertas" method="POST">
       		<input type="text" placeholder="Empresas, ofertas, keywords..." name="filter">
           	<button class="btn" type="submit" style="width: 150px; background-color:white; color: black;">Buscar</button>
      	</form>
	</div>
	<div class="login-option">	
		<%
			DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
			if(usuario != null){
				
		%>
	    <a href="/trabajouy/consultausuario?usuario_consulta=<%= usuario.getNickname() %>"><%= usuario.getNickname() %></a><span> | </span>
	    <a href="/trabajouy/logout">Cerrar sesion</a>
	    <%
			} else {
	    %>
	    <a href="/trabajouy/login">Iniciar sesion</a><span> | </span>
	    <a href="/trabajouy/registro">Registrarse</a>
   	    <%
			}
	    %>
	</div>
</header>