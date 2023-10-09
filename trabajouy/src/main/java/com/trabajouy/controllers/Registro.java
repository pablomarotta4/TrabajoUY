package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.trabajouy.model.excepciones.CamposVaciosExcepcion;
import com.trabajouy.model.excepciones.UsuarioRepetidoException;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorUsuario;


@MultipartConfig
@WebServlet("/registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registro() {
        super();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickname = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String password = request.getParameter("pass");
		String confirmPassword = request.getParameter("confirmPass");
		String email = request.getParameter("mail");
		
		try {
			if (password.equals(confirmPassword)) {
				Factory factory = Factory.getInstance();
				IControladorUsuario ctrlUser = factory.getControladorUsuario();
				if (request.getParameter("user-type").equals("empresa")) {
					String descripcion = request.getParameter("descripcion");
					String link = request.getParameter("link");
					ctrlUser.crearEmpresa(nickname, nombre, apellido, email, password, File.separator +  "images"  + File.separator + nickname + ".jpg", descripcion, link);
					Part image = request.getPart("imageFile");		
					String path = System.getProperty("user.home") + File.separator + "trabajouy" + File.separator + "img" + File.separator;
					File targetFile = new File(path + nickname + ".jpg");
					Files.copy(image.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					request.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(request, response);
				}
				else if (request.getParameter("user-type").equals("postulante")) {
					String nacionalidadString = request.getParameter("nacionalidad");
					
					String fechaString =  request.getParameter("fechaNac");
					if (!fechaString.equals("")) {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate fechaNac = LocalDate.parse(fechaString, formatter);
						ctrlUser.crearPostulante(nickname, nombre, apellido, email, password, File.separator +  "images"  + File.separator + nickname + ".jpg", nacionalidadString, fechaNac);
						Part image = request.getPart("imageFile");		
						String path = System.getProperty("user.home") + File.separator + "trabajouy" + File.separator + "img" + File.separator;
						File targetFile = new File(path + nickname + ".jpg");
						Files.copy(image.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
						request.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(request, response);
					}
					else {
						request.setAttribute("campos-vacios", true);
						request.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(request, response);
					}
				}
			}
			
			
			
		}
		catch (CamposVaciosExcepcion ex) {
			request.setAttribute("campos-vacios", true);
			request.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(request, response);
		}
		catch (UsuarioRepetidoException ex) {
			request.setAttribute("user-repetido", true);
			request.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(request, response);
		}
	}
		
	
}
