<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta Postulacion</title>
    <meta name="viewport" content="width=, initial-scale=1.0">
    <link rel="stylesheet" href="media/styles/consultarPostulacion.css">
    <link rel="stylesheet" href="media/styles/basic.css">
    <%@page import="com.trabajouy.model.logica.datatypes.DTPostulacion"%>
    <%@page import="com.trabajouy.model.logica.datatypes.DataUsuario"%>
     <%@page import="com.trabajouy.model.logica.datatypes.DTOfertaLaboral"%>
    <%@page import="com.trabajouy.controllers.Postulacion"%>
    <%@page import="com.trabajouy.model.logica.interfaces.Factory" %>
	<%@page import="com.trabajouy.model.logica.interfaces.IControladorUsuario" %>
	<%@page import="com.trabajouy.model.logica.interfaces.IControladorOferta" %>
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
            <%	DTPostulacion datosPostulacion = (DTPostulacion) request.getSession().getAttribute("datosPostulacion");
				IControladorUsuario userController = Factory.getInstance().getControladorUsuario();
				IControladorOferta oferController = Factory.getInstance().getControladorOferta();
				DTOfertaLaboral oferta = oferController.listarDatosOferta(datosPostulacion.getNombreOferta());
				DataUsuario datosPostulante = userController.consultarDatosUsuario(datosPostulacion.getNickPostulante());
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
                    <div id="fecha"><%= datosPostulacion.getFecha().toString() %>		 </div>
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