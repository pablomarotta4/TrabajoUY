<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trabajo UY</title>
    <link rel="stylesheet" href="media/styles/home.css">
    <link rel="stylesheet" href="media/styles/basic.css">
   	<link rel="icon" type="image/x-icon" href="media/images/favicon.ico">
    <%@page import="com.trabajouy.controllers.Login"%>
	<%@page import="com.trabajouy.model.logica.datatypes.DataUsuario"%>
</head>
<body>
    <!--HEADER-->
    <header class="header">
        <div class="menu">
            <button id="menu-btn"><img src="media/images/menu-icon.png" style="height: 100%"/></button>
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
    
    <!--MAIN CONTAINER-->
    <div class="main-container">
        <div id="menu-sidebar" class="menu-sidebar">
            <div class="menu-item"><a href="listaUsuarios">Usuarios</a></div>

            <div class="menu-item"><a href="ofertas">Ofertas</a></div>

            <div class="menu-item"><a href="listadoTipos">Tipos</a></div>
            <div class="menu-item"><a href="/trabajouy/datosDePrueba">Cargar datos</a></div>
       </div>
        <div class="main">
            <div class="logo-container">
                <div class="logo">
                    <img src="media/images/trabajoUy.png" alt="">
                </div>
            </div>
            <div class="empresas-container">
               <!--   <div class="empresas-title">
                    <h3>Principales empresas</h3>
                </div>
                <div class="empresas-scroll">
                    <div class="button-left scroll-button">
                        <input type="button" value="<">
                    </div>
                    <div class="empresas">
                        <div class="empresa">
                            <div class="empresa-logo">
                                <a href="listadoOfertas.html"><img src="https://tinyurl.com/mr2hcufa" alt=""></a>
                            </div>
                        </div>
                    </div>
                    <div class="button-right scroll-button">
                        <input type="button" value=">">
                    </div>
                </div>-->
            </div>
        </div>
    </div>
<script>
    const menuBtn = document.getElementById('menu-btn');
    const menuSidebar = document.getElementById('menu-sidebar');
    menuBtn.addEventListener("click", () => {
        if(menuSidebar.style.display == "block"){
            menuSidebar.style.display = "none";
        } else {
            menuSidebar.style.display = "block";
        }
    });
</script>
</body>
</html>