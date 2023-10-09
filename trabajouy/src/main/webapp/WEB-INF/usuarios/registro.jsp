<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="media/styles/basic.css">
    <link rel="stylesheet" href="media/styles/registro.css">
</head>
<body>
<div class="container">
    <div class="main-card">
        <div class="card-header">
            <div class="img-title">
                <img src="media/images/trabajoUy.png" alt="">
            </div>
            <div class="title">
                <h1>Registro</h1>
                <p>Ingrese sus datos</p>
            </div>
        </div>
        <div class="input-form">
            <form action="registro" method="POST" enctype="multipart/form-data">
                <div class="basic-input">
                    <div class="input-element">
                        <label for="">Nickname</label>
                        <input type="text" name="nickname" required>
                    </div>
                    <div class="input-element">
                        <label for="">Nombre</label>
                        <input type="text" name="nombre" required>
                    </div>
                    <div class="input-element">
                        <label for="">Apellido</label>
                        <input type="text" name="apellido" required>
                    </div>
                    <div class="input-element">
                        <label for="">Contraseña</label>
                        <input type="password" name="pass" minlength="6" required>
                    </div>
                    <div class="input-element">
                        <label for="">Confirmar contraseña</label>
                        <input type="password" name="confirmPass" required>
                    </div>
                    <div class="input-element">
                        <label for="">Email</label>
                        <input type="email" name="mail" required>
                    </div>
                    <div class="input-element">
                        <label for="">Imagen</label>
                        <input type="file" accept="image/png, image/jpeg, image/jpg" name="imageFile" id="imageFile">
                    </div>
                    <div class="input-element user-type">
                        <div>
                            <label style="color: white;" for="">Tipo de usuario:</label>
                        </div>
                        <div class="usertype-inputs">
                            <label for="">Postulante</label>
                            <input id="btn-postulante" type="radio" name="user-type" checked="checked" value="postulante">
                            <label for="">  Empresa</label>
                            <input id="btn-empresa" type="radio" name="user-type" value="empresa">
                        </div>
                    </div>
                </div>
                <div id="input-postulante" class="input-postulante">
                    <div class="input-element">
                        <label for="">Fecha de nacimiento</label>
                        <input type="date" name="fechaNac">
                    </div>
                    <div class="input-element">
                        <label for="">Nacionalidad</label>
                        <input type="text" name="nacionalidad">
                    </div>
                </div>
                <div id="input-empresa" class="input-empresa">
                    <div class="input-element">
                        <label for="">Descripcion general</label>
                        <textarea name="descripcion" id="" cols="30" rows="10"></textarea>
                    </div>
                    <div class="input-element">
                        <label for="">link</label>
                        <input type="text" name="link">
                    </div>
                </div>
                <%
                	Boolean vacio = (Boolean) request.getAttribute("campos-vacios");
                    Boolean userRepetido = (Boolean) request.getAttribute("user-repetido");		
                    
                    if(vacio != null){
                    	if(vacio.equals(true)){
                %>    		
                <div class="error">
	                <p>Rellene todos los campos</p>
                </div>
                
                <%
                    	}
                    }
                    
                    if(userRepetido != null){
                    	if(userRepetido.equals(true)){
                %>
                <div class="error" >
	                <p>Ya existe un usuario con el mismo Nickname</p>
                </div>
                
                <%
                    	}
                    }
                        		
                %>
                
                
                <div class="buttons">
                    <button id="botonCrear" type="submit"> Crear Usuario</button>  
                    <a href="/trabajouy/home"><input type="button" value="Cancelar"></a>
                </div>
            </form>
        </div>
        <div class="card-footer">
            <p>Ya tenes una cuenta? <span><a href="/trabajouy/login"> Iniciar sesion</a></span></p>
        </div>
    </div>
</div>
<script>
    const inputPostulante = document.getElementById("input-postulante");
    const inputEmpresa = document.getElementById("input-empresa");
    const btnPostulante = document.getElementById('btn-postulante');
    const btnEmpresa = document.getElementById('btn-empresa');

    btnEmpresa.addEventListener("click", () => {
        inputPostulante.style.display = "none";
        inputEmpresa.style.display = "flex";
    });
    btnPostulante.addEventListener("click", () => {
        inputEmpresa.style.display = "none";
        inputPostulante.style.display = "flex";
    });
</script>
</body>
</html>