package logica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paquete {
	private String nombre; 
	private String descripcion; 
	private int periodoValidez; 
	private int descuento; 
	private LocalDate fechaAlta; 
	//private coleccion de tipos de publicacion con sus cantidades 
	
	
	public Paquete(String nombre,
			String descripcion, 
			int periodoValidez, 
			int descuento, 
			LocalDate fechaAlta) {
		//super(nick, nombre, apellido, email);
		this.nombre= nombre; 
		this.descripcion= descripcion;
		this.periodoValidez= periodoValidez; 
		this.descuento= descuento; 
		this.fechaAlta=fechaAlta;
		//this.tiposYCants = new ArrayList<>();
	}
	//hacer los getters
	public String  getNombre() {
		return this.nombre; 
	}

}
