package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import server.DataEmpresa;
import server.DataPostulante;
import server.DtPostulacion;

import java.io.IOException;

import com.trabajouy.enums.EstadoSesion;

@WebServlet("/consultaPostulacionMovil")
public class ConsultaPostulacionMovil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPostulacionMovil() {
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
			if (port.consultarDatosUsuario((String) request.getSession().getAttribute("nickname")) instanceof DataPostulante) {
				DtPostulacion postulacionInfo = port.listarDatosPostulacion(
				(String) request.getSession().getAttribute("nickname"),
				(String) request.getSession().getAttribute("nombreOferta"));
			request.getSession().setAttribute("datosPostulacion", (DtPostulacion) postulacionInfo);
			request.getRequestDispatcher("WEB-INF/movil/consultaPostulacionMovil.jsp").forward(request, response);
		    }
		} else {
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
