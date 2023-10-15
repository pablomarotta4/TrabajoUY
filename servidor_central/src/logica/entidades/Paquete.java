package logica.entidades;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Paquete {
	private String nombre; 
	private String descripcion; 
	private int periodoValidez; 
	private int descuento; 
	private LocalDate fechaAlta; 
	private Map<String, Integer> cantsTiposPub;
	//private coleccion de tipos de publicacion con sus cantidades 
	
	

	public Paquete(String nombre,
			String descripcion, 
			int periodoValidez, 
			int descuento, 
			LocalDate fechaAlta) {
		
		this.cantsTiposPub = new HashMap<String, Integer>();
		this.nombre= nombre; 
		this.descripcion= descripcion;
		this.periodoValidez= periodoValidez; 
		this.descuento= descuento; 
		this.fechaAlta=fechaAlta;
	
		//this.tiposYCants = new ArrayList<>();
	}
	//hacer los getters

//hacer los getters
public String  getNombre() {
	return this.nombre; 
}

public String getDesripcion() {
	return this.descripcion;
}

public int getPeriodo() {
	return this.periodoValidez;
}

public LocalDate getFecha() {
	return this.fechaAlta;
}

public int getDescuento() {
	return this.descuento;
}

public void agregarTipoAPaquete(String nombreTipoPublicacion, Integer cantidad) {
	this.cantsTiposPub.put(nombreTipoPublicacion, cantidad);
}
	
public Map<String, Integer> getTiposYCantidades() {
	return this.cantsTiposPub;
}
}
