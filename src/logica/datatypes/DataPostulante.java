package logica.datatypes;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DataPostulante extends DataUsuario {

	private String nacionalidad;
	private LocalDate nacimiento;
	
	public  DataPostulante(String nick, 
			String nombre, 
			String apellido, 
			String email,
			LocalDate fechaNac,
			String nacionalidad) {
		super(nick, nombre, apellido, email);
		this.nacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	
	public String getNacimiento() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(nacimiento);
		return date;
	}

}
