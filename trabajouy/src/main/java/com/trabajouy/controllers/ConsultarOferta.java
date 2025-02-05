package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import server.ElementoInexistenteException;
import server.EstadoOferta;
import server.DataUsuario;
import server.DtOfertaLaboral;



@WebServlet("/consultarOferta")
public class ConsultarOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultarOferta() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOferta = request.getParameter("oferta");
		server.WebServer port = new server.WebServerService().getWebServerPort();
		try {
			DtOfertaLaboral ofertaSeleccionada = port.listarDatosOferta(nombreOferta);
						
			LocalDate fechaAlta = LocalDate.parse(ofertaSeleccionada.getDate());
			int duracion = ofertaSeleccionada.getDuracion();
			boolean estaConfirmada = ofertaSeleccionada.getEstado().equals(EstadoOferta.CONFIRMADA);
			boolean estaVigente = fechaAlta.plusDays(duracion).isAfter(LocalDate.now());
			request.setAttribute("empresa_creadora", true);
			request.setAttribute("esta_vigente", estaVigente);
			request.setAttribute("esta_confirmada", estaConfirmada);
			request.setAttribute("oferta-seleccionada", ofertaSeleccionada);
			if (!estaConfirmada || !estaVigente) {
				DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
				if(usuario != null && ofertaSeleccionada.getNombreEmpresa().equals(usuario.getNickname())) {
					request.getRequestDispatcher("/WEB-INF/ofertas/consultaOferta.jsp").include(request, response);
				} else {
					response.sendRedirect("/trabajouy/ofertas");
				}				
			} else {
				request.setAttribute("oferta-seleccionada", ofertaSeleccionada);				
				request.getRequestDispatcher("/WEB-INF/ofertas/consultaOferta.jsp").include(request, response);
			}
		} catch (server.ElementoInexistenteException_Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
