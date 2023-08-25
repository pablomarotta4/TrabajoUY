package logica.datatypes;

import java.util.Date;
import java.util.List;

import logica.entidades.Postulacion;

public class DTPostulante extends DTUsuario{
	
	private Date fechaNacimiento;
	private String nacionalidad;
	private List<Postulacion> postulaciones;
	
	public DTPostulante(String nick, 
			String nombre, 
			String apellido, 
			String email,
			Date fechaNac,
			String nacionalidad) {
		super(nick, nombre, apellido, email);
		this.fechaNacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
	}
}
