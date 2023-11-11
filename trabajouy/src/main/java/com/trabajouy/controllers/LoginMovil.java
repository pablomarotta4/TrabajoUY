package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import server.DataEmpresa;
import server.DataUsuario;
import server.ElementoInexistenteException_Exception;

import java.io.IOException;

import com.trabajouy.enums.EstadoSesion;

@WebServlet ("/loginMovil")
public class LoginMovil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMovil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}

 // Muestra la vista del login
 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		initSession(req);
 		HttpSession sesion = req.getSession();
 		EstadoSesion estadoSesion = (EstadoSesion) sesion.getAttribute("estado_sesion");
 		if (estadoSesion != null) {
 			if (estadoSesion.equals(EstadoSesion.NO_LOGIN)) {
 				req.getRequestDispatcher("/WEB-INF/movil/loginMovil.jsp").forward(req, resp);
 			} else {
 				resp.sendRedirect("/trabajouy/loginMovil");
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
 			DataUsuario usuario = port.consultarDatosUsuario(nickname);
 			if(usuario instanceof DataEmpresa) {
 				req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
 				req.getRequestDispatcher("/WEB-INF/movil/loginMovil.jsp").forward(req, response);
 			}
 			boolean credencialesValidas = port.evaluarCredenciales(nickname, password);
 			if (credencialesValidas) {
 				 DataUsuario user = port.consultarDatosUsuario(nickname);
 				 req.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
 				 req.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
 				 req.getSession().setAttribute("usuario_logeado", user);
 				 req.getSession().setAttribute("nickname", nickname);
 				 response.sendRedirect("/trabajouy/homeMovil");
 			} else {
 				req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
 				req.getRequestDispatcher("/WEB-INF/movil/loginMovil.jsp").forward(req, response);
 			}
 		} catch (ElementoInexistenteException_Exception ex) {
 			req.setAttribute("estado_sesion", EstadoSesion.LOGIN_INCORRECTO);
 			req.getRequestDispatcher("/WEB-INF/movil/loginMovil.jsp").forward(req, response);
 		}
 	}

}
