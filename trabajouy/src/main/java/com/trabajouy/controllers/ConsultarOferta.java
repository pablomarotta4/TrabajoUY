package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.trabajouy.model.excepciones.ElementoInexistenteException;
import com.trabajouy.model.logica.datatypes.DTOfertaLaboral;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorOferta;


@WebServlet("/consultarOferta")
public class ConsultarOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultarOferta() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOferta = request.getParameter("oferta");
		IControladorOferta ctrlOferta = Factory.getInstance().getControladorOferta();
		try {
			DTOfertaLaboral ofertaSeleccionada = ctrlOferta.listarDatosOferta(nombreOferta);
			request.setAttribute("oferta-seleccionada", ofertaSeleccionada);				
			request.getRequestDispatcher("/WEB-INF/ofertas/consultaOferta.jsp").include(request, response);
		} catch (ElementoInexistenteException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
