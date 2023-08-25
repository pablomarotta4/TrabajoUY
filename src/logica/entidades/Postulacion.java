package logica.entidades;

import java.util.Date;

public class Postulacion {

	private String cvReducido;
	private String motivacion;
	private Date fechaPostulacion;
	private OfertaLaboral ofertaLaboral;
	private Postulante postulante;

	public Postulacion(String cvReducido, String motivacion,Date fechaPostulacion, Postulante postulante) {
		this.cvReducido = cvReducido;
		this.motivacion = motivacion;
		this.setFechaPostulacion(fechaPostulacion);
		this.setPostulante(postulante);
		//this.ofertaLaboral = ofertaLaboral;
	}
	public String getMotivacion() {
		return motivacion;
	}
	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
	public String getCvReducido() {
		return cvReducido;
	}
	public void setCvReducido(String cvReducido) {
		this.cvReducido = cvReducido;
	}
	public Postulante getPostulante() {
		return postulante;
	}
	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}
	public Date getFechaPostulacion() {
		return fechaPostulacion;
	}
	public void setFechaPostulacion(Date fechaPostulacion) {
		this.fechaPostulacion = fechaPostulacion;
	}
	public OfertaLaboral getOfertaLaboral() {
		return ofertaLaboral;
	}
	public void setOfertaLaboral(OfertaLaboral ofertaLaboral) {
		this.ofertaLaboral = ofertaLaboral;
	}
	
}
