package logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPostulante extends DataUsuario {

	private String nacionalidad;
	private LocalDate nacimiento;
	private ArrayList<DTPostulacion> postulaciones;
	
	public  DataPostulante(String nick, 
			String nombre, 
			String apellido, 
			String email,
			LocalDate fechaNac,
			String nacionalidad,
			String imageUrl) {
		super(nick, nombre, apellido, email, imageUrl);
		this.nacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
		this.postulaciones = new ArrayList<>();
	}
	
	public void setPostulaciones(ArrayList<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getNacimiento() {
		return nacimiento.toString();
	}
	
	public int getDiaNac() {
		return nacimiento.getDayOfMonth();
	}
	public int getMesNac() {
		return nacimiento.getMonthValue();
	}
	public int getAnioNac() {
		return nacimiento.getYear();
	}
	
	public ArrayList<DTPostulacion> getPostulaciones() {
		return this.postulaciones;
	}
	
	 public boolean estaPostulado(String nombreOferta) {
		 boolean estaPostulado = false;
		 int icont = 0;
		 while (icont < postulaciones.size() && !estaPostulado) {
			estaPostulado = postulaciones.get(icont).getNombreOferta().equals(nombreOferta);
			icont++;
		 }
		 return estaPostulado;
	 }
}
