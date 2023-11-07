package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import server.DataTipoPublicacion;


/**
 * Servlet implementation class ListaTipos
 */
@WebServlet("/listadoTipos")
public class ListarTipos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListarTipos() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		server.WebServer port = new server.WebServerService().getWebServerPort();
//		Map<String, DataTipoPublicacion> mapTipos = port.getDataTiposPublicacion().get;
//		request.setAttribute("map_tipos", mapTipos);
//		request.getRequestDispatcher("/WEB-INF/tipos/listadoTipos.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
