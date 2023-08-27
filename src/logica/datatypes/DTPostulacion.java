package logica.datatypes;

import java.time.LocalDate;
import java.util.Date;

import logica.entidades.OfertaLaboral;
import logica.entidades.Postulante;

public class DTPostulacion {
	private String cvReducido;
	private String motivacion;
	private LocalDate fechaPostulacion;
	private String nombreOferta ;
	private String nickpostulante;

	public DTPostulacion() {
		
	}
	
	public DTPostulacion(
			String cvReducido, 
			String motivacion, 
			LocalDate fechaPostulacion, 
			String nickPostulante, 
			String nombreOferta) {
		this.cvReducido = cvReducido;
		this.motivacion = motivacion;
		this.fechaPostulacion = fechaPostulacion;
		this.nickpostulante = nickPostulante;
		this.nombreOferta = nombreOferta;
	}
	
	public String getNickPostulante() {
		return this.nickpostulante;
	}
	
	public String toString() {
		return 
			"NICKNAME: " + this.nickpostulante + "\n" +
			"FECHA DE POSTULACION: " + this.fechaPostulacion.toString() + "\n" +
			"CV: " + this.cvReducido + "\n" +
			"MOTIVACION: " + this.motivacion + "\n" +
			"OFERTA: " + this.nombreOferta + "\n";
	}
	
	public String getCvReducido() {
		return this.cvReducido;
	}
	
	public String getMotivacion() {
		return this.motivacion;
	}
	public LocalDate getFecha() {
		return this.fechaPostulacion;
	}
	public String getNombreOferta() {
		return this.nombreOferta;
	}
	
	public boolean equals(DTPostulacion p) {
		return
			cvReducido.equals(p.getCvReducido()) &&
			motivacion.equals(p.getMotivacion()) &&
			fechaPostulacion.equals(p.getFecha()) &&
			nickpostulante.equals(p. getNickPostulante()) &&
			nombreOferta.equals(p.getNombreOferta());
	}
	
}
