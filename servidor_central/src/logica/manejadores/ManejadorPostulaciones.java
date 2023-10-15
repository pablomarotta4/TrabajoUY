package logica.manejadores;

import java.util.ArrayList;
import java.util.List;

import logica.entidades.OfertaLaboral;
import logica.entidades.Postulacion;
import logica.entidades.Postulante;
import logica.interfaces.IManejadorPostulaciones;

public class ManejadorPostulaciones implements IManejadorPostulaciones{
	private static ManejadorPostulaciones instance = null;
	private List<Postulacion> postulaciones;
	
	private  ManejadorPostulaciones() {
		this.postulaciones = new ArrayList<Postulacion>();
	}
	
	public static IManejadorPostulaciones getInstance() {
		if (instance == null) {
			instance = new ManejadorPostulaciones();
		}
		return instance;
	}

	public List<Postulacion> getPostulaciones() {
		return postulaciones;
	}

	@Override
	public void agregarPostulacion(Postulacion post) {
		postulaciones.add(post);
		
	}

	@Override
	public boolean existePostulacion(String nickPostulante, String oferta) {
		for (Postulacion post : postulaciones) {
			Postulante postulante = post.getPostulante();
			OfertaLaboral ofer = post.getOfertaLaboral();
			if (postulante.getNickname().equals(nickPostulante) && (ofer.getNombre().equals(oferta))) {
				return true;
			}
		}
		return false;
	}
	
	
}

