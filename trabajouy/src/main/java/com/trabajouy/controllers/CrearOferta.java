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
import java.util.ArrayList;
import java.util.List;

import server.ElementoInexistenteException;
import server.CollectionBean;
import server.DataUsuario;


@MultipartConfig
@WebServlet("/crearOferta")
public class CrearOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrearOferta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		server.WebServer port = new server.WebServerService().getWebServerPort();
		CollectionBean collection = port.listarTiposPublicacion();
		List<String> listaTipos = collection.getListaStrings();
		collection = port.listarKeywords();
		List<String> listaKeywords = collection.getListaStrings();
		if (listaTipos.isEmpty()) {
			request.setAttribute("error_mesage", "No existen tipos de publicacion validos.");
			request.getRequestDispatcher("/WEB-INF/ofertas/crearOferta.jsp").forward(request, response);
		} else {
			request.setAttribute("lista_tipos_publicacion", listaTipos);
			request.setAttribute("lista_keywords", listaKeywords);
			request.getRequestDispatcher("/WEB-INF/ofertas/crearOferta.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		server.WebServer port = new server.WebServerService().getWebServerPort();
		CollectionBean collection = port.listarTiposPublicacion();
		List<String> listaTipos = collection.getListaStrings();
		collection = port.listarKeywords();
		List<String> keywordsEnSistema = collection.getListaStrings();		
		
		String nombreOferta = (String) request.getParameter("nombre-oferta");
		String descripcion = (String) request.getParameter("descripcion");
		String horaEntrada = (String) request.getParameter("hora-entrada");
		String horaSalida = (String) request.getParameter("hora-salida");
		String remuneracion = (String) request.getParameter("remuneracion");
		String departamento = (String) request.getParameter("departamento");
		String ciudad = (String) request.getParameter("ciudad");
		String tipoPublicacion = (String) request.getParameter("tipo-publicacion");
		
        boolean alMenosUnParametroNoNulo = !validarParametros(
                nombreOferta, descripcion, horaEntrada, horaSalida,
                remuneracion, departamento, ciudad, tipoPublicacion
        );

        if (alMenosUnParametroNoNulo) {
    		request.setAttribute("lista_tipos_publicacion", listaTipos);
    		request.setAttribute("lista_keywords", keywordsEnSistema);
			request.setAttribute("error_mesage", "Complete todos los campos marcados con *");
			request.getRequestDispatcher("/WEB-INF/ofertas/crearOferta.jsp").forward(request, response);
        }

        if(Float.parseFloat(remuneracion) < 0) {
    		request.setAttribute("lista_tipos_publicacion", listaTipos);
    		request.setAttribute("lista_keywords", keywordsEnSistema);
			request.setAttribute("error_mesage", "La remuneracion no puede ser negativa.");
			request.getRequestDispatcher("/WEB-INF/ofertas/crearOferta.jsp").forward(request, response);
        }
        
		Part image = request.getPart("imageFile");		
		if(image != null) {
			String path = System.getProperty("user.home") + File.separator + "trabajouy" + File.separator + "img" + File.separator;
			File targetFile = new File(path + nombreOferta + ".jpg");
			if(targetFile.exists()) {
				Files.copy(image.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);	
			}			
		}
		ArrayList<String> listaKeywords = new ArrayList<>();
		
		for (String keyword : keywordsEnSistema) {
			String keySeleccionada = (String) request.getParameter(keyword.replaceAll("\\s", ""));
			if (keySeleccionada != null) {
				listaKeywords.add(keyword);
			}
		}
		collection.getListaStrings().clear();
		for(String keyword : listaKeywords) {
			collection.getListaStrings().add(keyword);
		}

		try {
			DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
			if (usuario != null) {
				port.altaOfertaLaboral(
						usuario.getNickname(),
						tipoPublicacion, 
						nombreOferta, 
						descripcion, 
						horaEntrada + "-" + horaSalida, 
						Float.parseFloat(remuneracion),
						ciudad, 
						departamento, 
						LocalDate.now().toString(), 
						File.separator +  "images"  + File.separator + nombreOferta + ".jpg", 
						collection
					);
			}
			response.sendRedirect("/trabajouy/ofertas");
		} catch (server.ElementoInexistenteException_Exception | server.ElementoRepetidoException_Exception ex) {
    		request.setAttribute("lista_tipos_publicacion", listaTipos);
    		request.setAttribute("lista_keywords", keywordsEnSistema);
			request.setAttribute("error_mesage", ex.getMessage());
			request.getRequestDispatcher("/WEB-INF/ofertas/crearOferta.jsp").forward(request, response);
		} catch (NumberFormatException ex) {
    		request.setAttribute("lista_tipos_publicacion", listaTipos);
    		request.setAttribute("lista_keywords", keywordsEnSistema);
			request.setAttribute("error_mesage", "Remuneracion invalida");
			request.getRequestDispatcher("/WEB-INF/ofertas/crearOferta.jsp").forward(request, response);
		}
	}
	
	public boolean validarParametros(String nombreOferta, String descripcion, String horaEntrada, String horaSalida, String remuneracion, String departamento, String ciudad, String tipoPublicacion) {
	    return nombreOferta != null && !nombreOferta.equals("") &&
	           descripcion != null && !descripcion.equals("") &&
	           horaEntrada != null && !horaEntrada.equals("") &&
	           horaSalida != null && !horaSalida.equals("") &&
	           remuneracion != null && !remuneracion.equals("") &&
	           departamento != null && !departamento.equals("") &&
	           ciudad != null && !ciudad.equals("") &&
	           tipoPublicacion != null && !tipoPublicacion.equals("");
	}

}
