package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import server.CollectionBean;
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
		server.WebServer port = new server.WebServerService().getWebServerPort();
		CollectionBean collection = port.getDataTiposPublicacion();
		List<DataTipoPublicacion> listaTipos = collection.getListaDataTipoPublicacion();
		System.out.println(listaTipos);
		request.setAttribute("map_tipos", listaTipos);
		request.getRequestDispatcher("/WEB-INF/tipos/listadoTipos.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
