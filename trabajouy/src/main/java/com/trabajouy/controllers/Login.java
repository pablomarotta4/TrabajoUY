package com.trabajouy.controllers;

import java.io.IOException;

import com.trabajouy.model.enums.EstadoSesion;
import com.trabajouy.model.excepciones.ElementoInexistenteException;
import com.trabajouy.model.logica.datatypes.DataUsuario;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorUsuario;

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
			Factory factory = Factory.getInstance();
			IControladorUsuario ctrlUsuario = factory.getControladorUsuario();
			boolean credencialesValidas = ctrlUsuario.evaluarCredenciales(nickname, password);
			if (credencialesValidas) {
				 DataUsuario user = ctrlUsuario.consultarDatosUsuario(nickname);
				 req.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
				 req.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
				 req.getSession().setAttribute("usuario_logeado", user);
				 req.getSession().setAttribute("nickname", nickname);
				response.sendRedirect("/trabajouy/ofertas");
			} else {
				req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
				req.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(req, response);
			}
		} catch (ElementoInexistenteException ex) {
			req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
			req.getRequestDispatcher("/WEB-INF/usuarios/login.jsp").forward(req, response);
		}
	}

}
