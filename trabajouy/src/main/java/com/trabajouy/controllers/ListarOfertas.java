package com.trabajouy.controllers;

import java.io.IOException;
import java.util.List;

import com.trabajouy.model.logica.datatypes.DTOfertaLaboral;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorOferta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ofertas")
public class ListarOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListarOfertas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter = (String) request.getParameter("filter");
		IControladorOferta ctrlOferta = Factory.getInstance().getControladorOferta();
		List<DTOfertaLaboral> listaOfertas = null;
		if (filter != null && !filter.equals("")) {
			listaOfertas = ctrlOferta.listarDtOfertasByFilter(filter);
		} else {
			listaOfertas = ctrlOferta.listarDtOfertas();
		}
		
		request.setAttribute("lista_ofertas", listaOfertas);
		request.getRequestDispatcher("/WEB-INF/ofertas/listadoOfertas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
