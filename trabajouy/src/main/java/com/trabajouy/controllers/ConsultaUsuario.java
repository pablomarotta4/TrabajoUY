package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.trabajouy.enums.EstadoSesion;
import server.DataUsuario;


/**
 * Servlet implementation class ConsultaUsuario
 */

@WebServlet ("/consultausuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DataUsuario usrL = (DataUsuario) request.getSession().getAttribute("usuario_logeado");
    	String nombreUsuarioConsulta = request.getParameter("usuario_consulta");
    	server.WebServerService servicio = new server.WebServerService();
		server.WebServer port = servicio.getWebServerPort();
    	DataUsuario usuarioC = port.consultarDatosUsuario(nombreUsuarioConsulta);
    	request.setAttribute("usuario_consulta", usuarioC);
		if (usrL == null) {
			// no existe el usuario, se trata como deslogueado
			request.getSession().setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		} else {
			request.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
		}
		request.getRequestDispatcher("/WEB-INF/usuarios/consulta.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
