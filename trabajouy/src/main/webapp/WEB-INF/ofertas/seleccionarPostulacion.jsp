<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="server.DtPostulacion" %>
<%@page import="server.DataUsuario" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="media/styles/basic.css">
    <link rel="stylesheet" href="media/styles/registro.css">
</head>
<style>
	.input-element{
		display: flex;
		flex-direction: row;
		height: 120px;
	}
	.title{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		text-align: center;
		margin-bottom: 30px;
	}
</style>
<body>
	<div class="container">
    <div class="main-card">
        <div class="card-header">
            <div class="title">
                <h1>Seleccionar postulaciones</h1>
                <p>Ingrese el orden para cada postulacion</p>
            </div>
        </div>
        <div class="input-form">
            <form action="seleccionarPostulacion" method="POST">
                <%
        		server.WebServer port = new server.WebServerService().getWebServerPort();
                List<DtPostulacion> listaPostulaciones = (List<DtPostulacion>) request.getAttribute("lista_postulaciones");
               	String nombreOferta = (String) request.getAttribute("nombre_oferta");
                %>
                <div class="basic-input">
                	<div class="input-element">
                		<label style="margin-right: 10px;" for="">Oferta</label>
                		<input style="color: grey;" type="text" name="nombre-oferta" value="<%=nombreOferta%>" required readonly/>
                	</div>
				<%
                if(listaPostulaciones != null){
                	for(DtPostulacion postulacion : listaPostulaciones){
                		DataUsuario usuarioPost = port.consultarDatosUsuario(postulacion.getNickpostulante());
                %>
                <div class="input-element">
                	<img style="max-width: 80px;" src="/trabajouy/imagenes?id=<%=usuarioPost.getImageUrl()%>" alt="foto-usuario">
                	<label for=""><%=postulacion.getNickpostulante()%></label>
                	<input style="width: 40px;" type="number" name="<%=postulacion.getNickpostulante()%>-orden" required>
                </div>
               	<%		
                	}
                }
                %>
                </div>
                <div class="buttons">
                    <button id="botonCrear" type="submit">Enviar orden</button>  
                    <a href="/trabajouy/home"><input type="button" value="Cancelar"></a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>