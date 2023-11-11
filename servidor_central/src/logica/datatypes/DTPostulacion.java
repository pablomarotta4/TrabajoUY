package logica.datatypes;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTPostulacion {
	private String cvReducido;
	private String motivacion;
	private LocalDate fechaPostulacion;
	private String nombreOferta ;
	private String nickpostulante;
	private String date;
	private int orden;
	
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
		this.date = fechaPostulacion.toString();
	}
	
	public String getNickpostulante() {
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
	public LocalDate getFechaPostulacion() {
		return this.fechaPostulacion;
	}
	public String getNombreOferta() {
		return this.nombreOferta;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean equals(DTPostulacion pos) {
		return
			cvReducido.equals(pos.getCvReducido()) &&
			motivacion.equals(pos.getMotivacion()) &&
			fechaPostulacion.equals(pos.getFechaPostulacion()) &&
			nickpostulante.equals(pos. getNickpostulante()) &&
			nombreOferta.equals(pos.getNombreOferta());
	}
	
	public void setCvReducido(String cvReducido) {
		this.cvReducido = cvReducido;
	}
	
	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
	
	public void setFechaPostulacion(LocalDate fechaPostulacion) {
		this.fechaPostulacion = fechaPostulacion;
	}
	
	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}
	
	public void setNickpostulante(String nickpostulante) {
		this.nickpostulante = nickpostulante;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
	
}
