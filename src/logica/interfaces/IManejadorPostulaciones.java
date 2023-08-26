package logica.interfaces;

import java.util.List;

import logica.entidades.Postulacion;

public interface IManejadorPostulaciones {
	
	public void agregarPostulacion(Postulacion p);
	public List<Postulacion> getPostulaciones();
	public boolean existePostulacion(String nickPostulante, String oferta);
}
