<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@page import="java.util.List"%>
<head>
<meta charset="UTF-8">
<title>Title</title>
<jsp:include page="/WEB-INF/template/head.jsp" />
<link rel="stylesheet" href="media/styles/crearOferta.css">
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<main>
		<div class="form-box">
			<form action="crearOferta" method="POST" enctype="multipart/form-data">
					<%
						String errorMessage = (String) request.getAttribute("error_mesage");
						if(errorMessage != null){
					%>
						<p style="color: red; font-size: 20px;"><%= errorMessage %></p>
					<%
						}
					%>
				<div class="form-element">
					<label for="tipo-publicacion">Tipo de publicacion*</label> 
					<select name="tipo-publicacion" id="tipo-publicacion">
						<%
						List<String> listaTipos = (List<String>) request.getAttribute("lista_tipos_publicacion");
						if (listaTipos != null) {

							for (String tipoPublicacion : listaTipos) {
						%>
						<option value=<%=tipoPublicacion%> id=<%= tipoPublicacion %>> <%= tipoPublicacion %></option>
						<%
							}
						}
						%>
					</select>
				</div>
				<div class="form-element">
					<label for="nombre-oferta">Nombre*</label> 
					<input type="text" name="nombre-oferta" id="nombre-oferta">
				</div>
				<div class="form-element">
					<label for="descripcion">Descripcion*</label>
					<textarea name="descripcion" id="descripcion" cols="30" rows="5"></textarea>
				</div>
				<div class="form-element">
					<label for="">Horario*</label>
					<div>
						<label for="hora-entrada">Entrada</label> 
						<input type="time" name="hora-entrada" id="hora-entrada">
						<label for="hora-salida">Salida</label>
						<input type="time" name="hora-salida" id="hora-salida">
					</div>
				</div>
				<div class="form-element">
					<label for="remuneracion">Remuneracion*</label> 
					<input type="text" name="remuneracion" id="remuneracion" pattern="^\d+$">
				</div>
				<div class="form-element">
					<label for="departamento">Departamento*</label> 
					<input type="text" name="departamento" id="departamento">
				</div>
				<div class="form-element">
					<label for="ciudad">Ciudad*</label> 
					<input type="text" name="ciudad" id="ciudad">
				</div>
				<div class="form-element">
					<label for="imageFile">Imagen</label> 
					<input type="file" accept="image/png, image/jpeg, image/jpg" name="imageFile" id="imageFile">
				</div>

				<div class="form-element checkbox">
					<div class="checkbox-element">
					<%
					List<String> listaKeywords = (List<String>) request.getAttribute("lista_keywords");
					if(listaKeywords != null){
						int i = 0;
						for(i = 0; i <= listaKeywords.size()/2 - 1; i++){					
							String keyword = listaKeywords.get(i);
							String keywordAtt = keyword.replaceAll("\\s","");
					%>
						<div>
							<input type="checkbox" name=<%=keywordAtt%> id=<%=keywordAtt%> value=<%=keywordAtt%>> 
							<label for=<%=keywordAtt%>><%=keyword%></label>
						</div>
					<% 
							}
						}
					%>
					</div>		
					<div class="checkbox-element">
					<%
						int i;
						if(listaKeywords != null){		
							for(i = listaKeywords.size() / 2; i <= listaKeywords.size() - 1; i++){
								String keyword = listaKeywords.get(i);
								String keywordAtt = keyword.replaceAll("\\s","");
					%>	
						<div>
							<input type="checkbox" name=<%=keywordAtt%> id=<%=keywordAtt%> value=<%=keywordAtt%>> 
							<label for=<%=keywordAtt%>><%=keyword%></label>
						</div>
					<%
							}
						}
					%>
					</div>		
				</div>
				<div class="form-element">
					<div>
						<label>Forma de pago</label>
					</div>
					<div>
						<label for="">General</label> <input type="radio" name="pay"
							checked="checked">
					</div>
					<div>
						<label for="">Con paquete</label> <input type="radio" name="pay">
					</div>
				</div>
				<div class="pago-paquete"></div>
				<div class="buttons">
					<button type="submit">Crear</button>
						<a href="ofertas"><input
						type="button" value="Cancelar"></a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>