package logica.controladores;

import java.util.Date;
import java.util.List;

import excepciones.ElementoRepetidoException;
import logica.entidades.Keyword;
import logica.entidades.OfertaLaboral;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IManejadorKeywords;
import logica.interfaces.IManejadorOferta;

public class ControladorOferta implements IControladorOferta{
	
	private IManejadorOferta manejadorOferta;
	private IManejadorKeywords manejadorKeys;
	
	public void altaOfertaLaboral() {
		//
	}
	
	public void altaOfertaLaboral(
			String empresa,
			String tipoPublicacion,
			String nombre,
			String descripcion,
			String horario,
			float remuneracion,
			String ciudad,
			String departamento,
			Date fechaAlta,
			List<String> keywords
	) {
		OfertaLaboral nuevaOferta = new OfertaLaboral(
				nombre,
				descripcion,
				ciudad,
				departamento,
				horario,
				remuneracion,
				fechaAlta,
				keywords
			);
		this.manejadorOferta.agregarOferta(nuevaOferta);
	}
	
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException {
		if(manejadorKeys.existeKeyword(nombreKeyword)) {
			throw new ElementoRepetidoException("Ya existe una Keyword con el mismo nombre");
		}
		Keyword key = new Keyword(nombreKeyword);
		this.manejadorKeys.agregarKeyword(key);
	}
	
}
