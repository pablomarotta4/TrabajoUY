<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="server.DataTipoPublicacion"%>	
<%@page import="java.util.Map"%>
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
			Map<String, DataTipoPublicacion> tipos = (Map<String, DataTipoPublicacion>) request.getAttribute("map_tipos");
			if(tipos != null){
				for(String key : tipos.keySet()){
			%>
				<div class="list-element">  
                    <div class="user-info">
                        <a href="consultatipo?tipo=<%=java.net.URLEncoder.encode(key, "UTF-8") %>"><%= key %></a>
                        <p><%= tipos.get(key).getDescripcion() %></p>
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
