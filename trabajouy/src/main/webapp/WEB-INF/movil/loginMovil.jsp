<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Iniciar Sesión</title>
	<link rel="stylesheet" href="media/styles/loginMovilCss.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body style="background: lightgray">

	<div class="container d-flex justify-content-center align-items-center min-vh-100">
        <!--LOGIN-->
        <div class="border rounded-5 p-3 bg-white shadow box-area">

            <!-- CAJA IZQUIERDA--> 
            <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: lightblue;">
                <div class="featured-image mb-3">
                    <img src="media/images/trabajoUy.png" class="img-fluid" style="width: 250px;">
                </div>
            </div>

            <!-- CAJA DERECHA-->
            <div class="col-md-6 right-box">
                <div class="row align-items-center">
                    <div class="header-text mb-4">
                        <h1 style="font-family: monospace;color: gray;">BIENVENIDO!</h1>
                    </div>
                    <form action="loginMovil" method="POST" class="row login-form">
	                    <div class="input-group mb-3">
	                        <input type="text" class="form-control form-control-lg bg-light fs-6" placeholder="Nickname o Email" name="username">
	                    </div>
	                    <div class="input-group mb-1">
	                        <input type="password" class="form-control form-control-lg bg-light fs-6" placeholder="Contraseña" name="password">
	                    </div>
	                    <div class="input-group mb-5" style="margin-top: 20px;">         
	                        <input type="submit" value="Iniciar sesion" class="btn btn-lg btn-primary w-100 fs-6">
	                    </div>
                    </form>
                    
                </div>
            </div>


        </div>

    </div>

</body>
</html>