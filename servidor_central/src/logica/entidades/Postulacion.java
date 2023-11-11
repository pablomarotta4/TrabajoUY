package logica.entidades;

import java.time.LocalDate;

import logica.datatypes.DTPostulacion;

public class Postulacion {

	private String cvReducido;
	private String motivacion;
	private LocalDate fechaPostulacion;
	private OfertaLaboral ofertaLaboral;
	private Postulante postulante;
	private int orden;
	
	public Postulacion(String cvReducido, String motivacion, LocalDate fechaPostulacion, Postulante postulante, OfertaLaboral ofer) {
		this.cvReducido = cvReducido;
		this.motivacion = motivacion;
		this.fechaPostulacion = fechaPostulacion;
		this.postulante = postulante;
		this.ofertaLaboral = ofer;
		this.orden = -1;
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
	public LocalDate getFechaPostulacion() {
		return fechaPostulacion;
	}
	public void setFechaPostulacion(LocalDate fechaPostulacion) {
		this.fechaPostulacion = fechaPostulacion;
	}
	public OfertaLaboral getOfertaLaboral() {
		return ofertaLaboral;
	}
	public void setOfertaLaboral(OfertaLaboral ofertaLaboral) {
		this.ofertaLaboral = ofertaLaboral;
	}
	public DTPostulacion getDatatype() {
		DTPostulacion post =new DTPostulacion(
				this.cvReducido,
				this.motivacion,
				this.fechaPostulacion,
				this.postulante.getNickname(),
				this.ofertaLaboral.getNombre()
		);
		post.setOrden(this.orden);
		return post;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
}
