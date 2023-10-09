<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Postulacion</title>
    <meta name="viewport" content="width=, initial-scale=1.0">
    <link rel="stylesheet" href="media/styles/postularse.css">
    <link rel="stylesheet" href="media/styles/basic.css">
    <%@page import="com.trabajouy.controllers.Postulacion"%>
    <jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
    <jsp:include page="/WEB-INF/template/header.jsp" />
    
    <div class = "mainContainer">
        <form action="/trabajouy/postulacion" method="post">
        <div id="card1" >
            <div id="tituloContainer">
                <h1 id="titulo">Postulacion</h1>
            </div>
            <div id="fechaContainer">
                <label id="fechaLabel" for="fecha">Fecha: </label>
				<input id="fecha" type="date" name="fecha" value="<%= request.getAttribute("fechaActual") %>">            </div>
            <div id="cvContainer">
                <label id="cvReducidoLabel" for="cv">CV reducido: </label>
                <textarea id="cvReducido" name="cvReducido" rows="7" cols="10"></textarea>
            </div>
            <div id="motivacionContainer">
                <label id="motivacionLabel" for="motivacion">Motivacion: </label>
                <textarea id="motivacion" name="motivacion" rows="7" cols="10"></textarea>
            </div>
            <div id="botonContainer">
                <input type="submit" value="Postularse"></input>
            </div>
        </div>
        </form>
      </div>
</body>
</html>