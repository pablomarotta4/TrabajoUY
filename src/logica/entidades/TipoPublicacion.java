package logica.entidades;

import java.time.LocalDate;
import java.util.Date;

public class TipoPublicacion {

	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	
	
	public TipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, LocalDate fecha) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.exposicion = exposicion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public float getCosto() {
		return this.costo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
}


