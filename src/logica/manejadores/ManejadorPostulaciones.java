package logica.manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.Postulacion;
import logica.interfaces.IManejadorPostulaciones;

public class ManejadorPostulaciones implements IManejadorPostulaciones{
	public static ManejadorPostulaciones instance = null;
	private Map<String, Postulacion> postulaciones;
	
	private  ManejadorPostulaciones() {
		this.postulaciones = new HashMap<String,Postulacion>();
	}
	
	public static IManejadorPostulaciones getInstance() {
		if(instance == null) {
			instance = new ManejadorPostulaciones();
		}
		return instance;
	}

	public Map<String, Postulacion> getPostulaciones() {
		return postulaciones;
	}
	
	
}

