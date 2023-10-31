package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.trabajouy.enums.EstadoSesion;
import server.DataUsuario;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
		if (user != null) {
			request.getSession().setAttribute("usuario_logeado", null);
			request.getSession().setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
		response.sendRedirect("/trabajouy/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
