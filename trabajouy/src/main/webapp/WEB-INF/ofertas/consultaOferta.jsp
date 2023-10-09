<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.model.logica.datatypes.DTOfertaLaboral"%>
<%@page import="com.trabajouy.model.logica.datatypes.DataUsuario"%>
<%@page import="com.trabajouy.model.logica.datatypes.DataPostulante"%>
<%@page import="com.trabajouy.model.logica.datatypes.DTPostulacion" %>
<%@page import="com.trabajouy.model.logica.interfaces.Factory" %>
<%@page import="com.trabajouy.model.logica.interfaces.IControladorUsuario" %>
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
		DTOfertaLaboral oferta = (DTOfertaLaboral) request.getAttribute("oferta-seleccionada");
	 	DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
	%>
    <!--MAIN CONTAINER-->
    <section class="main">
        <div class="contenido">
            <div class="titulo">
                <div>
                    <img src=<%= oferta.getImageUrl() %>>
                </div>
                <div class="title">
                    <h1><%= oferta.getNombre() %></h1>
                </div>
            </div>

            <div class="descripcion">
                <p><strong>Descripción:</strong><%= oferta.getDescripcion() %></p>
                <p><strong>Remuneración: </strong>$<%=oferta.getRemuneracion().toString()%></p>
                <p><strong>Horarios: </strong><%= oferta.getHorario()%></p>
                <p><strong>Fecha de alta: </strong><%=oferta.getFechaAlta()%></p>
                <p><strong>Keywords: </strong><%=oferta.getKeywords().toString() %></p>
            </div>
			
            <% 	if(usuario == null){ %>
            <a href="login"><input class="btn-postular" type="button" value="Postularse"></a>
            <% 
            	} else if(usuario instanceof DataPostulante){
     		%>	
     			<a href="/trabajouy/postulacion?nombreOferta=<%=java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8")%>"><input class="btn-postular" type="button" value="Postularse"></a>
     		<% } %>
        </div>

        <!--CAJAS DE POSTULACIONES Y PAQUETES-->
        <div class="postulacionesYpaquetes">

            <% 
           
            if(usuario != null){
            	IControladorUsuario ctrlUsuario = Factory.getInstance().getControladorUsuario();
            	if(usuario.getNickname().equals(oferta.getNombreEmpresa())){
            		List<DTPostulacion> postulaciones = oferta.getPostulaciones();
            		if(postulaciones != null){
            %>
            <div class="postulaciones">
                <!--TITULO-->
                <div>
                    <h1>POSTULACIONES</h1>
                </div>
                	<%	
                		for(DTPostulacion postulacion: postulaciones){
                	%>
	                <div class="postulante">
	                    <!--FOTO-->
	                    <div class="foto-postulante"><img src=<%= ctrlUsuario.getFotoUsuario(postulacion.getNickPostulante()) %> alt="foto-usuario"></div>
	                    <!--NOMBRE-->
	                    <div class="nombre-postulante"><a href="/trabajouy/consultaPostulacion?nombreOferta=<%=java.net.URLEncoder.encode(postulacion.getNombreOferta(), "UTF-8")%>&nickname=<%=postulacion.getNickPostulante()%>"><%= postulacion.getNickPostulante() %></a></div>
	                </div>
                	<%
                		}
                	%>
            </div>
            <%
            		}
           		} else if(ctrlUsuario.estaPostulado(usuario.getNickname(), oferta.getNombre())){
   			%>
	   		  <div class="postulaciones">
                <!--TITULO-->
                <div>
                    <h1>POSTULACION</h1>
                </div>
                <div class="postulante">
                    <!--FOTO-->
                    <div class="foto-postulante"><img src=<%= ctrlUsuario.getFotoUsuario(usuario.getNickname()) %> alt="foto-usuario"></div>
                    <!--NOMBRE-->
                    <div class="nombre-postulante"><a href="/trabajouy/postulacion?nombreOferta=<%= java.net.URLEncoder.encode(oferta.getNombre(), "UTF-8") %>&nickname=<%=usuario.getNickname()%>"><%=usuario.getNickname() %></a></div>
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