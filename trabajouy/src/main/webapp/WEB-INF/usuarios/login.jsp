<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.trabajouy.controllers.Login"%>
<%@page import="com.trabajouy.model.enums.EstadoSesion"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous"
    >
    <link rel="stylesheet" href="media/styles/login.css">
    <link rel="stylesheet" href="media/styles/basic.css">
</head>
<body>
    <div class="main-container container">
        <div class="login-card container">
            <div class="row card-header">
                <div class="col-4 web-logo-col">
                    <a href="/trabajouy/home"><img src="media/images/trabajoUy.png" alt=""></a>
                </div>
                <div class="col-8 title-col">
                    <h1>Iniciar sesion</h1>
                </div>
            </div>
            <form action="login" method="POST" class="row login-form">
                <div class="row inputs">
                    <div class="row">
                        <label>Nickname o email</label>
                        <input type="text" name="username">
                    </div>
                    <div class="row">
                        <label>Contraseña</label>
                        <input type="password" name="password">
                    </div>
                </div>
               	<%
             		EstadoSesion state = (EstadoSesion) request.getAttribute("estado_sesion");

					if(state != null){
	               		if(state.equals(EstadoSesion.LOGIN_INCORRECTO)){	
				%>	
				<p style="text-align:center; color:black;">Datos de inicio de sesion invalidos.</p>	
				<% 	
						}
               		} 
             	%>
                <div class="buttons">
                    <input type="submit" value="Iniciar sesion">
                    <a href="/trabajouy/home"><input type="button" value="Cancelar"></a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>