package logica.entidades;

import java.util.Date;

public class TipoPublicacion {

	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	private Date fecha;
	
	
	public TipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, Date fecha) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.exposicion = exposicion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
	}
}
