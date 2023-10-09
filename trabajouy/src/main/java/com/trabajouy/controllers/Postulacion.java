package com.trabajouy.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.trabajouy.model.enums.EstadoSesion;
import com.trabajouy.model.excepciones.ElementoInexistenteException;
import com.trabajouy.model.excepciones.ElementoRepetidoException;
import com.trabajouy.model.excepciones.NoExisteInstancia;
import com.trabajouy.model.logica.datatypes.DataEmpresa;
import com.trabajouy.model.logica.datatypes.DataPostulante;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorOferta;
import com.trabajouy.model.logica.interfaces.IControladorUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/postulacion")
public class Postulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Postulacion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		EstadoSesion estadoSesion = (EstadoSesion) sesion.getAttribute("estado_sesion");
		if (estadoSesion.equals(EstadoSesion.LOGIN_CORRECTO)) {
		    	IControladorUsuario userController = Factory.getInstance().getControladorUsuario();
		    	if (userController.consultarDatosUsuario((String) request.getSession().getAttribute("nickname")) instanceof DataPostulante) {
        			String nomOferta = request.getParameter("nombreOferta");
        			nomOferta = java.net.URLDecoder.decode(nomOferta, "UTF-8");
        			request.getSession().setAttribute("nombreOferta", nomOferta);
        			IControladorOferta ofertaController = Factory.getInstance().getControladorOferta();
        			if (ofertaController.listarDatosPostulacion((String) request.getSession().getAttribute("nickname"), nomOferta) != null) {
        				response.sendRedirect("/trabajouy/consultaPostulacion");
        			}
        			else {
                			LocalDate fechaActual = LocalDate.now();
                			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                			String fechaFormateada = fechaActual.format(formatoFecha);
                			request.setAttribute("fechaActual", fechaFormateada);
                	        	
                			request.getRequestDispatcher("WEB-INF/ofertas/postularse.jsp").forward(request, response);
        			}
        		  }
		    	else if (userController.consultarDatosUsuario((String) request.getSession().getAttribute("nickname")) instanceof DataEmpresa){
		    	    response.sendRedirect("/trabajouy/home");
		    	}
		}
		else {
			response.sendRedirect("login");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
		String nickname = (String) request.getSession().getAttribute("nickname");
		String cvReducido = (String) request.getParameter("cvReducido");
		String motivacion = (String) request.getParameter("motivacion");
		String nombreOferta = (String) request.getSession().getAttribute("nombreOferta");
		IControladorOferta ofertaController = Factory.getInstance().getControladorOferta();
			ofertaController.altaPostulacion(nickname, nombreOferta, cvReducido, motivacion, LocalDate.now());
		} catch (ElementoRepetidoException e) {
		    	response.sendRedirect("/trabajouy/consultaPostulacion");
			e.printStackTrace();
		} catch (NoExisteInstancia e) {
		    	response.sendRedirect("login");
			e.printStackTrace();
		} catch (ElementoInexistenteException e) {
			e.printStackTrace();
			response.sendRedirect("home");
		}
		
		response.sendRedirect("/trabajouy/consultaPostulacion");
	}
}