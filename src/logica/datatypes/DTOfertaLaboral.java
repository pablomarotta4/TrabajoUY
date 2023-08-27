package logica.datatypes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import logica.controladores.ControladorUsuario;
import logica.entidades.Empresa;
import logica.interfaces.Factory;
import logica.interfaces.IManejadorPaquetes;
import logica.manejadores.ManejadorPaquetes;

public class DTOfertaLaboral {
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private float remuneracion;
	private LocalDate fechaAlta;
	private float costo;
	private List<DTPostulacion> postulaciones;
	private List<String> keywords;
	private String nombreEmpresa;
	
	public DTOfertaLaboral() {
		
	}
	
	public DTOfertaLaboral(
			String nombre,
			String descripcion,
			String ciudad,
			String departamento,
			String horario,
			float remuneracion,
			LocalDate fechaAlta,
			List<DTPostulacion> postulaciones,
			List<String> keywords,
			String nombreEmpresa,
			String tipoPublicacion,
			float costo
	){
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.horario = horario;
		this.remuneracion = remuneracion;
		this.fechaAlta = fechaAlta;
		this.postulaciones = postulaciones;
		this.nombreEmpresa = nombreEmpresa;
		this.keywords = keywords;
		this.costo = costo;
	}	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	public String getCiudad() {
		return this.ciudad;
	}
	public String getDepartamento() {
		return this.departamento;
	}
	public String getHorario() {
		return this.horario;
	}
	public Float getRemuneracion() {
		return this.remuneracion;
	}
	public LocalDate getFechaAlta() {
		return this.fechaAlta;
	}
	public List<DTPostulacion> getPostulaciones() {
		return this.postulaciones;
	}
	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}
	public List<String> getKeywords() {
		return this.keywords;
	}
	
	public float getCosto() {
		return this.costo;
	}
	
	public boolean equals(DTOfertaLaboral of) {
		Float rem = this.remuneracion;
		return 
				this.nombre.equals(of.getNombre()) &&
				this.descripcion.equals(of.getDescripcion()) &&
				this.ciudad.equals(of.getCiudad()) &&
				this.departamento.equals(of.getDepartamento()) &&
				this.horario.equals(of.getHorario()) &&
				rem.equals(of.getRemuneracion()) &&
				this.fechaAlta.equals(of.getFechaAlta()) &&
				this.nombreEmpresa.equals(of.getNombreEmpresa()) &&
				this.keywords.equals(of.getKeywords()) &&
				this.costo == of.getCosto();
	}
	
//	@Override
//	public String toString() {
//	    return "DTOfertaLaboral{" +
//	            "nombre='" + nombre + '\'' +
//	            ", descripcion='" + descripcion + '\'' +
//	            ", ciudad='" + ciudad + '\'' +
//	            ", departamento='" + departamento + '\'' +
//	            ", horario='" + horario + '\'' +
//	            ", remuneracion=" + remuneracion +
//	            ", fechaAlta=" + fechaAlta +
//	            ", costo=" + costo +
//	            ", keywords=" + keywords +
//	            ", nombreEmpresa='" + nombreEmpresa + '\'' +
//	            '}';
//	}

}
