package logica.datatypes;

import java.util.Date;

import logica.entidades.OfertaLaboral;
import logica.entidades.Postulante;

public class DTPostulacion {
	private String cvReducido;
	private String motivacion;
	private Date fechaPostulacion;
	private String nombreOferta ;
	private String nickpostulante;

	public DTPostulacion(
			String cvReducido, 
			String motivacion, 
			Date fechaPostulacion, 
			String nickPostulante, 
			String nombreOferta) {
		this.cvReducido = cvReducido;
		this.motivacion = motivacion;
		this.fechaPostulacion = fechaPostulacion;
		this.nickpostulante = nickPostulante;
		this.nombreOferta = nombreOferta;
	}
}
