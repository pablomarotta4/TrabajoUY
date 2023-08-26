package logica.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;

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
	
	public DTOfertaLaboral getDataType(){
		List<DTPostulacion> listaDtPostulacion = new ArrayList<DTPostulacion>();
		List<String> listaKeywords = new ArrayList<String>();
		
		for(int i = 0; i <= this.keywords.size() - 1; i++) {
			listaKeywords.add(this.keywords.get(i).getKeyword());
		}
		for(int i = 0; i <= this.postulaciones.size() - 1; i++) {
			listaDtPostulacion.add(postulaciones.get(i).getDatatype());
		}
		
		return new DTOfertaLaboral(
			this.nombre,
			this.descripcion,
			this.ciudad,
			this.departamento,
			this.horario,
			this.remuneracion,
			this.fechaAlta,
			listaDtPostulacion,
			listaKeywords,
			this.empresa.getNickname()
		);
	}
}
