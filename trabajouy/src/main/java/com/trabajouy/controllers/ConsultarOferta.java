package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import server.ElementoInexistenteException;
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
			request.setAttribute("oferta-seleccionada", ofertaSeleccionada);				
			request.getRequestDispatcher("/WEB-INF/ofertas/consultaOferta.jsp").include(request, response);
		} catch (server.ElementoInexistenteException_Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
