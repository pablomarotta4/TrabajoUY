package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.trabajouy.enums.EstadoSesion;

@WebServlet("/listaPostulaciones")
public class ListaPostulaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPostulaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		EstadoSesion estadoSesion = (EstadoSesion) sesion.getAttribute("estado_sesion");
		if (estadoSesion.equals(EstadoSesion.LOGIN_CORRECTO)) {
			server.WebServer port = new server.WebServerService().getWebServerPort();
			String nickname = (String) request.getParameter("nickname");
			request.getSession().setAttribute("nickname", nickname);
			request.getRequestDispatcher("/WEB-INF/movil/listaPostulaciones.jsp").forward(request,response);
		}else {
		    response.sendRedirect("loginMovil");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
