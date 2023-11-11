package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import server.DataEmpresa;
import server.DataUsuario;
import server.DtOfertaLaboral;
import server.DtPostulacion;
import server.ElementoInexistenteException_Exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/seleccionarPostulacion")
public class SeleccionarPostulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeleccionarPostulacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataUsuario usuario = (DataUsuario)	request.getSession().getAttribute("usuario_logeado");
		
		if(usuario == null || !(usuario instanceof DataEmpresa)) {
			response.sendRedirect("/trabajouy/ofertas");
		}
			
		String nombreOferta = (String) request.getParameter("nombreOferta");
		server.WebServer port = new server.WebServerService().getWebServerPort();
		DtOfertaLaboral oferta = null;
		try {
			oferta = port.listarDatosOferta(nombreOferta);
		} catch (ElementoInexistenteException_Exception e) {
			e.printStackTrace();
		}
		
		if(!oferta.getNombreEmpresa().equals(usuario.getNickname())) {
			response.sendRedirect("/trabajouy/ofertas");
		}
		List<DtPostulacion> postulaciones = oferta.getPostulaciones();
		request.setAttribute("lista_postulaciones", postulaciones);
		request.setAttribute("nombre_oferta", nombreOferta);
		request.getRequestDispatcher("WEB-INF/ofertas/seleccionarPostulacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOferta = request.getParameter("nombre-oferta");
		
		server.WebServer port = new server.WebServerService().getWebServerPort();
		DtOfertaLaboral oferta = null;
		try {
			oferta = port.listarDatosOferta(nombreOferta);
		} catch (ElementoInexistenteException_Exception e) {
			e.printStackTrace();
		}
		
		List<DtPostulacion> postulaciones = oferta.getPostulaciones();
		ArrayList<Integer> arrayOrdenes = new ArrayList<>();
		for(int i: arrayOrdenes) {
			arrayOrdenes.set(i, -1);
		}
		for(DtPostulacion post: postulaciones) {
			String orden = request.getParameter(post.getNickpostulante() + "-orden");
			int ordenNum = Integer.parseInt(orden);
			boolean found = false;
			int i = 0;
			while(i <= arrayOrdenes.size() - 1 && !found) {
				found = arrayOrdenes.get(i).equals(ordenNum);
				i++;
			}  

			if(ordenNum < 1 || ordenNum > postulaciones.size() || found) {
				request.setAttribute("lista_postulaciones", postulaciones);
				request.setAttribute("nombre_oferta", nombreOferta);
				request.setAttribute("error", "Valores de orden incorrectos.");
				request.getRequestDispatcher("WEB-INF/ofertas/seleccionarPostulacion.jsp").forward(request, response);
			} else {
				port.setOrdenPostulacion(post.getNickpostulante(), nombreOferta, ordenNum);
				arrayOrdenes.add(ordenNum);
			}
		}
		response.sendRedirect("/trabajouy/consultarOferta?oferta=" + oferta.getNombre());
	}

}
