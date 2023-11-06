package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import server.DataUsuario;


/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/listaUsuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Usuarios() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		server.WebServer port = new server.WebServerService().getWebServerPort();
		
		List<DataUsuario> listaUsuarios= port.listarDTUsuarios().getListaDataUsuarios();
		
		request.setAttribute("lista_usuarios", listaUsuarios);
		request.getRequestDispatcher("/WEB-INF/usuarios/listaUsuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
