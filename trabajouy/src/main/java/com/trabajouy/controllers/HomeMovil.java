package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import server.DataUsuario;
import server.DtOfertaLaboral;

import java.io.IOException;
import java.util.ArrayList;

import com.trabajouy.enums.EstadoSesion;

@WebServlet ("/homeMovil")
public class HomeMovil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeMovil() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}
    
    public static EstadoSesion getEstado(HttpServletRequest request){
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		initSession(req);
		String filter = (String) req.getParameter("filter");
		server.WebServerService servicio = new server.WebServerService();
		server.WebServer port = servicio.getWebServerPort();
		ArrayList<DtOfertaLaboral> listaOfertas = null;
		
		DataUsuario usuario = (DataUsuario) req.getSession().getAttribute("usuario_logeado");
		
		String nicknameFilter = "";
		if(usuario != null) {
			nicknameFilter = usuario.getNickname();
		}
		if (filter != null && !filter.equals("")) {
			listaOfertas = (ArrayList<DtOfertaLaboral>) port.listarDtOfertasByFilter(filter, nicknameFilter).getListaDtOfertas();
		} else {
			listaOfertas = (ArrayList<DtOfertaLaboral>) port.listarDtOfertasConfirmadasNoExpiradas(nicknameFilter).getListaDtOfertas();
		}

		req.setAttribute("lista_ofertas", listaOfertas);
		req.getRequestDispatcher("/WEB-INF/movil/homeMovil.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
