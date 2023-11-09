<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta Postulacion</title>
    <meta name="viewport" content="width=, initial-scale=1.0">
    <link rel="stylesheet" href="media/styles/consultarPostulacion.css">
    <link rel="stylesheet" href="media/styles/basic.css">
    <%@page import="server.DtPostulacion"%>
    <%@page import="server.DataUsuario"%>
     <%@page import="server.DtOfertaLaboral"%>
    <%@page import="com.trabajouy.controllers.Postulacion"%>
   	<jsp:include page="/WEB-INF/template/head.jsp"/>
    
</head>
<body>
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <div class="mainContainer">
        <div id="tituloContainer">
            <h1 id="titulo">Postulacion a oferta laboral</h1>
        </div>
        <div id="cardContainer">
        <div class="card">
            <div id="datosContainer">
            <%
            DtPostulacion datosPostulacion = (DtPostulacion) request.getSession().getAttribute("datosPostulacion");
	    			server.WebServerService servicio = new server.WebServerService();
    				server.WebServer port = servicio.getWebServerPort();
            		DtOfertaLaboral oferta = port.listarDatosOferta(datosPostulacion.getNombreOferta());
            		DataUsuario datosPostulante = port.consultarDatosUsuario(datosPostulacion.getNickpostulante());
            %>
                <div id="nombreContainer">
                    <label id="nombreLabel" for="nombre">Nombre: </label>
                    <p id="nombre"><%= datosPostulante.getNombre() %> <%= datosPostulante.getApellido() %> </p>
                </div>
                <div id="cvContainer">
                    <label id="cvLabel" for="cv">CV reducido </label>
                    <div id="cv"> <%= datosPostulacion.getCvReducido() %> </div>
                </div>
                <div id="motivacionContainer">
                    <label id="motivacionLabel" for="motivacion">Motivacion </label>
                    <div id="motivacion"><%= datosPostulacion.getMotivacion() %>		</div>
                </div>
                <div id="fechaContainer">
                    <label id="fechaLabel" for="fecha">Fecha de postulacion: </label>
                    <div id="fecha"><%= datosPostulacion.getDate() %>		 </div>
                </div>
            </div>
        </div>
        <div id="subcardOfer">
            <div id="ofertaContainer">
                <img id="imagenOferta" src="<%= oferta.getImageUrl() %>"  alt="oferta">
                <div id="ofertaNombre">	<%= datosPostulacion.getNombreOferta() %> </div>
            </div>
        </div>
        </div>
    </div>
</body>
</html>