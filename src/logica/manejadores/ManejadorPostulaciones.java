package logica.manejadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.entidades.Postulacion;
import logica.interfaces.IManejadorPostulaciones;

public class ManejadorPostulaciones implements IManejadorPostulaciones{
	public static ManejadorPostulaciones instance = null;
	private List<Postulacion> postulaciones;
	
	private  ManejadorPostulaciones() {
		this.postulaciones = new ArrayList<Postulacion>();
	}
	
	public static IManejadorPostulaciones getInstance() {
		if(instance == null) {
			instance = new ManejadorPostulaciones();
		}
		return instance;
	}

	public List<Postulacion> getPostulaciones() {
		return postulaciones;
	}

	@Override
	public void agregarPostulacion(Postulacion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existePostulacion(String nickPostulante, String oferta) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

