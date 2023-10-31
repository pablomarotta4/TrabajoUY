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

	
	public boolean equals(DTPostulacion pos) {
		return
			cvReducido.equals(pos.getCvReducido()) &&
			motivacion.equals(pos.getMotivacion()) &&
			fechaPostulacion.equals(pos.getFecha()) &&
			nickpostulante.equals(pos. getNickPostulante()) &&
			nombreOferta.equals(pos.getNombreOferta());
	}
	
	public void setCv(String cv) {
		this.cvReducido = cv;
	}
	
	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fechaPostulacion = fecha;
	}
	
	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}
	
	public void setNickPostulante(String nickpostulante) {
		this.nickpostulante = nickpostulante;
	}
	
}
