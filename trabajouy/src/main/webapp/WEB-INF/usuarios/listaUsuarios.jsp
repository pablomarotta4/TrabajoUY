<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="server.DataUsuario"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html lang= "en">
<head>
	
	<title>Listado de Usuarios</title>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<link rel="stylesheet" href="media/styles/listaUsuarios.css">
	
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
    <div class="main-container" style="padding-top: 30px">

    <%
    	List<DataUsuario> listUsr= (List<DataUsuario>) request.getAttribute("lista_usuarios");
   
    	if(listUsr!=null){
    		for(DataUsuario usuario: listUsr){
    			
    			String nombreUsuario= usuario.getNombre()+" "+ usuario.getApellido();
    %>
    
  
    	<div class="caja">
			  <div class="cajaImagen">
			  		<img src="/trabajouy/imagenes?id=<%=usuario.getImageUrl()%>" title ="imagen-usuario" alt="img-usuario">
			  </div>
			  <div class="contenido"> 
			  		<h3><a href="consultausuario?usuario_consulta=<%= usuario.getNickname()%>"><%=nombreUsuario%></a></h3>
	                <h3 style="font-family:monospace" ><%= usuario.getNickname() %></h3>
	                
	                <!-- <a href="postularse.html">Consultar</a> -->
			  
			  </div>
   	 	</div>
    
   <%
    		}
   		if (listUsr.size()==0){
   %>
   		<h2>No hay usuarios registrados</h2>
  <%
   		}
   	}
  %>
    
    
	</div>
	
</body>
</html>
