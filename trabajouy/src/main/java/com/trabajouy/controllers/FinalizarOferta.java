package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import server.DataUsuario;

import java.io.IOException;

@WebServlet("/finalizarOferta")
public class FinalizarOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FinalizarOferta() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOferta = (String) request.getParameter("nombreOferta");
		
		System.out.println(nombreOferta);
		if(nombreOferta != null) {
			server.WebServer port = new server.WebServerService().getWebServerPort();
			port.finalizarOferta(nombreOferta);
		}
		DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
		response.sendRedirect("/trabajouy/consultausuario?usuario_consulta=" + user.getNickname());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
