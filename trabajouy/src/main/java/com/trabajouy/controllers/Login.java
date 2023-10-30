package com.trabajouy.controllers;

import java.io.IOException;

import com.trabajouy.model.enums.EstadoSesion;
import server.ElementoInexistenteException_Exception;
import server.DataUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
    
    // Muestra la vista del login
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesion = req.getSession();
		EstadoSesion estadoSesion = (EstadoSesion) sesion.getAttribute("estado_sesion");
		if (estadoSesion != null) {
			if (estadoSesion.equals(EstadoSesion.NO_LOGIN)) {
				req.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("/trabajouy/ofertas");
			}
		}
	}
	
	// Comprueba la autenticacion del usuario
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String nickname = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			server.WebServerService servicio = new server.WebServerService();
			server.WebServer port = servicio.getWebServerPort();
			boolean credencialesValidas = port.evaluarCredenciales(nickname, password);
			if (credencialesValidas) {
				 DataUsuario user = port.consultarDatosUsuario(nickname);
				 req.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
				 req.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
				 req.getSession().setAttribute("usuario_logeado", user);
				 req.getSession().setAttribute("nickname", nickname);
				response.sendRedirect("/trabajouy/home");
			} else {
				req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
				req.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(req, response);
			}
		} catch (ElementoInexistenteException_Exception ex) {
			req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
			req.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(req, response);
		}
	}

}
