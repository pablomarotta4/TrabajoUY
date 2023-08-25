package logica.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfertaLaboral {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private float remuneracion;
	private Date fechaAlta;
	private float costo;
	private List<Postulacion> postulaciones;
	private List<Keyword> keywords;
	private Empresa empresa;
	
	public OfertaLaboral(
			String nombre,
			String descripcion,
			String ciudad,
			String departamento,
			String horario,
			float remuneracion,
			Date fechaAlta,
			List<Keyword> keywords,
			Empresa emp
	){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.horario = horario;
		this.remuneracion = remuneracion;
		this.fechaAlta = fechaAlta;
		this.postulaciones = new ArrayList<Postulacion>();
		this.empresa = emp;
	}	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	public Date getFecha() {
		return fechaAlta;
	}
}
