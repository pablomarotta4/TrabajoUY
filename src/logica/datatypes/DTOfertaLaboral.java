package logica.datatypes;

import java.util.Date;
import java.util.List;
import logica.entidades.Empresa;

public class DTOfertaLaboral {
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private float remuneracion;
	private Date fechaAlta;
	private float costo;
	private List<DTPostulacion> postulaciones;
	private List<String> keywords;
	private String nombreEmpresa;
	
	public DTOfertaLaboral(
			String nombre,
			String descripcion,
			String ciudad,
			String departamento,
			String horario,
			float remuneracion,
			Date fechaAlta,
			List<DTPostulacion> postulaciones,
			List<String> keywords,
			String nombreEmpresa
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
	}	
}
