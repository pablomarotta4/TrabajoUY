package com.trabajouy.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import server.DataEmpresa;
import server.DataUsuario;
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
		
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
		
		if(usuario != null && usuario instanceof DataEmpresa) {
			
		} else {
			if (filter != null && !filter.equals("")) {
				listaOfertas = (ArrayList<DtOfertaLaboral>) port.listarDtOfertasByFilter(filter).getListaDtOfertas();
			} else {
				listaOfertas = (ArrayList<DtOfertaLaboral>) port.listarDtOfertasConfirmadasNoExpiradas().getListaDtOfertas();
			}
		}	
		request.setAttribute("lista_ofertas", listaOfertas);
		request.getRequestDispatcher("/WEB-INF/ofertas/listadoOfertas.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
