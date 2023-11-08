<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="server.DataTipoPublicacion"%>	
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tipos de Publicacin</title>
<jsp:include page="/WEB-INF/template/head.jsp" />
<link rel="stylesheet" href="media/styles/listaTipos.css">
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<main>
		<div class="list-container">
			<%
			List<DataTipoPublicacion> listaTipos = (List<DataTipoPublicacion>) request.getAttribute("map_tipos");
			if(listaTipos != null){
				for(DataTipoPublicacion tipo : listaTipos){
			%>
				<div class="list-element">  
                    <div class="user-info">
                        <a href="consultatipo?tipo=<%=java.net.URLEncoder.encode(tipo.getNombre(), "UTF-8") %>"><%= tipo.getNombre() %></a>
                        <p><%= tipo.getDescripcion() %></p>
                    </div>
           		</div>		
			<%	
				}
			}
			%>
	
		</div>
	</main>

</body>
</html>
