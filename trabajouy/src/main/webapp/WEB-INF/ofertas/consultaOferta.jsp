<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="server.DtOfertaLaboral"%>
<%@page import="server.DataUsuario"%>
<%@page import="server.DataPostulante"%>
<%@page import="server.DtPostulacion" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Consulta de Oferta Basica</title>
    <link rel="stylesheet" href="media/styles/consultarOferta.css">
	<jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
   	<jsp:include page="/WEB-INF/template/header.jsp" />
	<%

		DtOfertaLaboral oferta = (DtOfertaLaboral) request.getAttribute("oferta-seleccionada");
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");

	%>
    <!--MAIN CONTAINER-->
    <section class="main">
        <div class="contenido">
            <div class="titulo">
                <div>
                    <img src="/trabajouy/imagenes?id=<%=oferta.getImagen()%>">
                </div>
                <div class="title">
                    <h1><%= oferta.getNombre() %></h1>
                </div>
            </div>

            <div class="descripcion">
                <p><strong>Descripción:</strong><%= oferta.getDescripcion() %></p>
                <p><strong>Remuneración: </strong>$<%=oferta.getRemuneracion() %></p>
                <p><strong>Horarios: </strong><%= oferta.getHorario()%></p>
                <p><strong>Fecha de alta: </strong><%=oferta.getDate()%></p>
                <p><strong>Keywords: </strong><%=oferta.getKeywords().toString() %></p>
            </div>
			
            <% 	if(usuario == null){ %>
            <a href="login"><input class="btn-postular" type="button" value="Postularse"></a>
            <% 
            	} else if(usuario instanceof DataPostulante){
            		server.WebServerService servicio = new server.WebServerService();
            		server.WebServer port = servicio.getWebServerPort();
                	
            		if (!port.estaPostulado(usuario.getNickname(),oferta.getNombre())){
     		%>	
     			<a href="/trabajouy/postulacion?nombreOferta=<%=java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8")%>"><input class="btn-postular" type="button" value="Postularse"></a>
     		<%  	}else { %>
     			<a href="/trabajouy/consultaPostulacion?nickname=<%=java.net.URLEncoder.encode(usuario.getNickname(), "UTF-8")%>&nombreOferta=<%= java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>"><input class="btn-postular" type="button" value="Consultar postulacion"></a>
     		<%}}%>
        </div>

        <!--CAJAS DE POSTULACIONES Y PAQUETES-->
        <div class="postulacionesYpaquetes">

            <% 
    		server.WebServerService servicio = new server.WebServerService();
    		server.WebServer port = servicio.getWebServerPort();
    		
            if(usuario != null){
            	
            	if(usuario.getNickname().equals(oferta.getNombreEmpresa())){
            		List<DtPostulacion> postulaciones = oferta.getPostulaciones();
            		if(postulaciones != null){
            %>
            <div class="postulaciones">
                <!--TITULO-->
                <div>
                    <h1>POSTULACIONES</h1>
                </div>
                	<%	
                		for(DtPostulacion postulacion: postulaciones){
                	%>
	                <div class="postulante">
	                    <!--FOTO-->
	                    <div class="foto-postulante"><img src=<%= port.getFotoUsuario(postulacion.getNickpostulante()) %> alt="foto-usuario"></div>
	                    <!--NOMBRE-->
	                    <div class="nombre-postulante"><a href="/trabajouy/consultaPostulacion?nombreOferta=<%=java.net.URLEncoder.encode(postulacion.getNombreOferta(), "UTF-8")%>&nickname=<%=postulacion.getNickpostulante() %>"><%= postulacion.getNickpostulante()%></a></div>
	                </div>
                	<%
                		}
                	%>
            </div>
            <%
            		}
           		} else if(port.estaPostulado(usuario.getNickname(), oferta.getNombre())){
   			%>
	   		  <div class="postulaciones">
                <!--TITULO-->
                <div>
                    <h1>POSTULACION</h1>
                </div>
                <div class="postulante">
                    <!--FOTO-->
                    <div class="foto-postulante"><img src=<%= port.getFotoUsuario(usuario.getNickname()) %> alt="foto-usuario"></div>
                    <!--NOMBRE-->
                    <div class="nombre-postulante"><a href="/trabajouy/consultaPostulacion?nickname=<%=java.net.URLEncoder.encode(usuario.getNickname(), "UTF-8")%>&nombreOferta=<%= java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>&nickname=<%=usuario.getNickname()%>"><%=usuario.getNickname() %></a></div>
                </div>
           </div>
           	<%		
           		}
            }
            %>
            <!--PAQUETES-->
<!--            <div class="paquetes">
                <div>
                    <h1>PAQUETES</h1>
                </div>
                <div class="paquete">
                
                    <div class="foto-paquete"><img src="https://shorturl.at/ceCD2"></div>
                    <div class="nombre-paquete"><a href="consultaPaquete.html">Básico</a></div>
                </div>
            </div>-->
        </div>
    </section>

</body>
</html> 