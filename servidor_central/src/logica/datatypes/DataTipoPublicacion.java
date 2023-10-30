package logica.datatypes;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataTipoPublicacion {
	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	
	public DataTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, LocalDate fecha) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.exposicion = exposicion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getExposicion() {
		return exposicion;
	}

	public int getDuracion() {
		return duracion;
	}

	public float getCosto() {
		return costo;
	}

	public LocalDate getFecha() {
		return fecha;
	}
}
