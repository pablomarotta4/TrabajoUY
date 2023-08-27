package logica.entidades;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Postulante extends Usuario{

	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private List<Postulacion> postulaciones;
	
	public Postulante(String nick, 
			String nombre, 
			String apellido, 
			String email,
			LocalDate fechaNac,
			String nacionalidad) {
		super(nick, nombre, apellido, email);
		this.fechaNacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
		this.postulaciones = new ArrayList<>();
	}
	
	public LocalDate getNacimiento() {
		return fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}

	public List<Postulacion> getPostulaciones() {
		return postulaciones;
	}
	
	public void agregarPostulacion(Postulacion p) {
		this.postulaciones.add(p);
	}
}
