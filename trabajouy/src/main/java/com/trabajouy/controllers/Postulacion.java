package com.trabajouy.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.trabajouy.enums.EstadoSesion;
import server.ElementoInexistenteException;
import server.DataEmpresa;
import server.DataPostulante;
import server.DataUsuario;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		EstadoSesion estadoSesion = (EstadoSesion) sesion.getAttribute("estado_sesion");
		if (estadoSesion.equals(EstadoSesion.LOGIN_CORRECTO)) {
				server.WebServer port = new server.WebServerService().getWebServerPort();
		    	if (port.consultarDatosUsuario((String) request.getSession().getAttribute("nickname")) instanceof DataPostulante) {
        			String nomOferta = request.getParameter("nombreOferta");
        			nomOferta = java.net.URLDecoder.decode(nomOferta, "UTF-8");
        			sesion.setAttribute("nombreOferta", nomOferta);
        			DataUsuario usuario = (DataUsuario) sesion.getAttribute("usuario_logeado-logeado");
        			if (usuario != null && port.listarDatosPostulacion(usuario.getNickname(), nomOferta) != null) {
        				response.sendRedirect("/trabajouy/consultaPostulacion");
        			} else {
                			LocalDate fechaActual = LocalDate.now();
                			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                			String fechaFormateada = fechaActual.format(formatoFecha);
                			request.setAttribute("fechaActual", fechaFormateada);
                			request.getRequestDispatcher("WEB-INF/ofertas/postularse.jsp").forward(request, response);
        			}
		    	} else if (port.consultarDatosUsuario((String) request.getSession().getAttribute("nickname")) instanceof DataEmpresa){
		    	    response.sendRedirect("/trabajouy/home");
		    	}
		} else {
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
		server.WebServer port = new server.WebServerService().getWebServerPort();
			port.altaPostulacion(nickname, nombreOferta, cvReducido, motivacion, LocalDate.now().toString());
		} catch (server.ElementoRepetidoException_Exception e) {
		    	response.sendRedirect("/trabajouy/consultaPostulacion");
			e.printStackTrace();
		} catch (server.NoExisteInstancia_Exception e) {
		    	response.sendRedirect("login");
			e.printStackTrace();
		} catch (server.ElementoInexistenteException_Exception e) {
			e.printStackTrace();
			response.sendRedirect("home");
		}
		
		response.sendRedirect("/trabajouy/consultaPostulacion");
	}
}