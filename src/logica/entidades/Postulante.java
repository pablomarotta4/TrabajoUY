package logica.entidades;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Postulante extends Usuario{

	private Date fechaNacimiento;
	private String nacionalidad;
	private List<Postulacion> postulaciones;
	
	public Postulante(String nick, 
			String nombre, 
			String apellido, 
			String email,
			Date fechaNac,
			String nacionalidad) {
		super(nick, nombre, apellido, email);
		this.fechaNacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
		this.postulaciones = new ArrayList<>();
	}
	
	public Date getNacimiento() {
		return fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}

	public List<Postulacion> getPostulaciones() {
		return postulaciones;
	}
}
