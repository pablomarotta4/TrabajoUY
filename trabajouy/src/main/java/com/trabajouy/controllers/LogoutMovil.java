package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import server.DataUsuario;

import java.io.IOException;

import com.trabajouy.enums.EstadoSesion;

@WebServlet("/logoutMovil")
public class LogoutMovil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutMovil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
		if (user != null) {
			request.getSession().setAttribute("usuario_logeado", null);
			request.getSession().setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
		response.sendRedirect("/trabajouy/loginMovil");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
