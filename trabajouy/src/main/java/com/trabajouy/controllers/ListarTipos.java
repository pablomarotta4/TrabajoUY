package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.trabajouy.model.logica.datatypes.DataTipoPublicacion;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorCompraTipo;

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
		IControladorCompraTipo ctrlCompraTipo = Factory.getInstance().getControladorCompraTipo();
		Map<String, DataTipoPublicacion> mapTipos = ctrlCompraTipo.getDataTiposPublicacion();
		request.setAttribute("map_tipos", mapTipos);
		request.getRequestDispatcher("/WEB-INF/tipos/listadoTipos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
