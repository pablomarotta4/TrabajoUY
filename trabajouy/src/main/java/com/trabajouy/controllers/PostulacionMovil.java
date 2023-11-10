package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import server.DataEmpresa;
import server.DataPostulante;
import server.DataUsuario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.trabajouy.enums.EstadoSesion;

@WebServlet("/postulacionMovil")
public class PostulacionMovil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostulacionMovil() {
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
        			String nomOferta = request.getParameter("nombreOferta");
        			nomOferta = java.net.URLDecoder.decode(nomOferta, "UTF-8");
        			sesion.setAttribute("nombreOferta", nomOferta);
        			DataUsuario usuario = (DataUsuario) sesion.getAttribute("usuario_logeado-logeado");
        			if (usuario != null && port.listarDatosPostulacion(usuario.getNickname(), nomOferta) != null) {
        				response.sendRedirect("/trabajouy/consultaPostulacionMovil");
        			} else {
                			LocalDate fechaActual = LocalDate.now();
                			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                			String fechaFormateada = fechaActual.format(formatoFecha);
                			request.setAttribute("fechaActual", fechaFormateada);
                			request.getRequestDispatcher("WEB-INF/movil/postulacionMovil.jsp").forward(request, response);
        			}
		    	}
		} else {
			response.sendRedirect("loginMovil");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname = (String) request.getSession().getAttribute("nickname");
		String nombreOferta = (String) request.getSession().getAttribute("nombreOferta");
				try {
				String cvReducido = (String) request.getParameter("cvReducido");
				String motivacion = (String) request.getParameter("motivacion");
				server.WebServer port = new server.WebServerService().getWebServerPort();
					port.altaPostulacion(nickname, nombreOferta, cvReducido, motivacion, LocalDate.now().toString());
				} catch (server.ElementoRepetidoException_Exception e) {
				    	response.sendRedirect("/trabajouy/consultaPostulacionMovil");
					e.printStackTrace();
				} catch (server.NoExisteInstancia_Exception e) {
				    	response.sendRedirect("loginMovil");
					e.printStackTrace();
				} catch (server.ElementoInexistenteException_Exception e) {
					e.printStackTrace();
					response.sendRedirect("homeMovil");
				}
				
				response.sendRedirect("/trabajouy/consultaPostulacionMovil?nombreOferta=" + nombreOferta + "&nickname=" + nickname);
			}
		}

