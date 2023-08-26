package logica.datatypes;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DataOfertaLaboral {
	private String nombre;
	private String ciudad;
	private LocalDate fechaAlta;
	
	public DataOfertaLaboral(String nombre,String ciudad, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.ciudad= ciudad;
		this.fechaAlta = fechaAlta;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCuidad() {
		return ciudad;
	}
	public String getFechaAlta() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(fechaAlta);
		return date;
	}
}
