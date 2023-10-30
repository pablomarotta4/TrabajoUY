package com.trabajouy.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.trabajouy.model.logica.datatypes.DTOfertaLaboral;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorOferta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import server.DtOfertaLaboral;


@WebServlet("/ofertas")
public class ListarOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListarOfertas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter = (String) request.getParameter("filter");
		server.WebServerService servicio = new server.WebServerService();
		server.WebServer port = servicio.getWebServerPort();
		ArrayList<DtOfertaLaboral> listaOfertas = null;
		if (filter != null && !filter.equals("")) {
			listaOfertas = port.listarDtOfertasByFilter(filter);
		} else {
			listaOfertas = port.listarDtOfertas();
		}
		
		request.setAttribute("lista_ofertas", listaOfertas);
		request.getRequestDispatcher("/WEB-INF/ofertas/listadoOfertas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
