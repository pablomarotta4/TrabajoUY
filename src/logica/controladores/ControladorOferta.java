package logica.controladores;

import java.util.Date;
import java.util.List;

import logica.entidades.OfertaLaboral;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IManejadorOferta;

public class ControladorOferta implements IControladorOferta{
	
	private IManejadorOferta manejadorOferta;
	
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
	
}
