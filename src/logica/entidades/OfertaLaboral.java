package logica.entidades;

import java.time.LocalDate;
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
	private LocalDate fechaAlta;
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
			LocalDate fechaAlta,
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
		this.keywords = keywords;
		System.out.println(nombre);
		System.out.println(this.keywords);
		System.out.println("-------");
	}	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	public LocalDate getFecha() {
		return fechaAlta;
	}
	
	public String getNickEmpresa() {
		return this.empresa.getNickname();
	}
	
	public DTOfertaLaboral getDataType(){
		List<DTPostulacion> listaDtPostulacion = new ArrayList<DTPostulacion>();
		List<String> listaKeywords = new ArrayList<String>();
		
		if(listaDtPostulacion.size() > 0) {
			for(int i = 0; i <= this.postulaciones.size() - 1; i++) {
				listaDtPostulacion.add(postulaciones.get(i).getDatatype());
			}
		}
		if(this.keywords.size() > 0) {
			System.out.println("hola1");
			for(int i = 0; i <= this.keywords.size() - 1; i++) {
				listaKeywords.add(this.keywords.get(i).getKeyword());
			}
		}
		System.out.println("hola2");
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
