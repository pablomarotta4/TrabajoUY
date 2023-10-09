package com.trabajouy.controllers;

import java.io.IOException;
import com.trabajouy.model.enums.EstadoSesion;
import com.trabajouy.model.logica.datatypes.DTPostulacion;
import com.trabajouy.model.logica.datatypes.DataEmpresa;
import com.trabajouy.model.logica.datatypes.DataPostulante;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorOferta;
import com.trabajouy.model.logica.interfaces.IControladorUsuario;
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
	    IControladorOferta oferController = Factory.getInstance().getControladorOferta();
	    IControladorUsuario userController = Factory.getInstance().getControladorUsuario();
	    if (userController.consultarDatosUsuario(
		    (String) request.getSession().getAttribute("nickname")) instanceof DataEmpresa) {
		DTPostulacion postulacionInfo = oferController.listarDatosPostulacion(
			(String) request.getParameter("nickname"), (String) request.getParameter("nombreOferta"));
		request.getSession().setAttribute("datosPostulacion", (DTPostulacion) postulacionInfo);
		request.getRequestDispatcher("WEB-INF/ofertas/consultarPostulacion.jsp").forward(request, response);
	    } else if (userController.consultarDatosUsuario(
		    (String) request.getSession().getAttribute("nickname")) instanceof DataPostulante) {
		DTPostulacion postulacionInfo = oferController.listarDatosPostulacion(
			(String) request.getSession().getAttribute("nickname"),
			(String) request.getSession().getAttribute("nombreOferta"));
		request.getSession().setAttribute("datosPostulacion", (DTPostulacion) postulacionInfo);
		request.getRequestDispatcher("WEB-INF/ofertas/consultarPostulacion.jsp").forward(request, response);
	    }
	} else {
	    response.sendRedirect("login");
	}
    }

}