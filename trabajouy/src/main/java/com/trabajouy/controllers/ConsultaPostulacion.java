package com.trabajouy.controllers;

import java.io.IOException;
import com.trabajouy.enums.EstadoSesion;
import server.DtPostulacion;
import server.DataEmpresa;
import server.DataPostulante;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/consultaPostulacion")
public class ConsultaPostulacion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConsultaPostulacion() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession sesion = request.getSession();
	EstadoSesion estadoSesion = (EstadoSesion) sesion.getAttribute("estado_sesion");
	if (estadoSesion.equals(EstadoSesion.LOGIN_CORRECTO)) {
		server.WebServer port = new server.WebServerService().getWebServerPort();
	    if (port.consultarDatosUsuario(
		    (String) request.getSession().getAttribute("nickname")) instanceof DataEmpresa) {
		DtPostulacion postulacionInfo = port.listarDatosPostulacion(
			(String) request.getParameter("nickname"), (String) request.getParameter("nombreOferta"));
		request.getSession().setAttribute("datosPostulacion", (DtPostulacion) postulacionInfo);
		request.getRequestDispatcher("WEB-INF/ofertas/consultarPostulacion.jsp").forward(request, response);
	    } else if (port.consultarDatosUsuario(
		    (String) request.getSession().getAttribute("nickname")) instanceof DataPostulante) {
		DtPostulacion postulacionInfo = port.listarDatosPostulacion(
			(String) request.getSession().getAttribute("nickname"),
			(String) request.getSession().getAttribute("nombreOferta"));
		request.getSession().setAttribute("datosPostulacion", (DtPostulacion) postulacionInfo);
		request.getRequestDispatcher("WEB-INF/ofertas/consultarPostulacion.jsp").forward(request, response);
	    }
	} else {
	    response.sendRedirect("login");
	}
    }

}