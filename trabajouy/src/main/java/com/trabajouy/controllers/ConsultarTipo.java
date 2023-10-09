package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.trabajouy.model.logica.datatypes.DataTipoPublicacion;
import com.trabajouy.model.logica.interfaces.Factory;
import com.trabajouy.model.logica.interfaces.IControladorCompraTipo;



@WebServlet ("/consultatipo")
public class ConsultarTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConsultarTipo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		IControladorCompraTipo ctrlCompraTipo = Factory.getInstance().getControladorCompraTipo();
		
		DataTipoPublicacion tipoSeleccionado = ctrlCompraTipo.listarDatosTipoPubliacion(tipo);
		request.setAttribute("tipo-seleccionado", tipoSeleccionado);
		request.getRequestDispatcher("/WEB-INF/tipos/consultaTipo.jsp").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
