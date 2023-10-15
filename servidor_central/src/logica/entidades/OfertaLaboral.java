package logica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.datatypes.EstadoOferta;

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
	private String imageUrl;
	private List<Keyword> keywords;
	private Empresa empresa;
	private TipoPublicacion tipo;
	private EstadoOferta estado;
	
	public OfertaLaboral(
			String nombre,
			String descripcion,
			String ciudad,
			String departamento,
			String horario,
			float remuneracion,
			LocalDate fechaAlta,
			String imageUrl,
			List<Keyword> keywords,
			Empresa emp,
			TipoPublicacion tipo
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
		this.tipo = tipo;
		this.imageUrl = imageUrl;
		this.costo = tipo.getCosto();
		this.estado = EstadoOferta.INGRESADA;
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
		
		if (this.postulaciones.size() > 0) {
			for (int i = 0; i <= this.postulaciones.size() - 1; i++) {
				listaDtPostulacion.add(postulaciones.get(i).getDatatype());
			}
		}
		if (this.keywords.size() > 0) {
			for (int i = 0; i <= this.keywords.size() - 1; i++) {
				listaKeywords.add(this.keywords.get(i).getKeyword());
			}
		}
		return new DTOfertaLaboral(
			this.nombre,
			this.descripcion,
			this.ciudad,
			this.departamento,
			this.horario,
			this.remuneracion,
			this.fechaAlta,
			this.imageUrl,
			listaDtPostulacion,
			listaKeywords,
			this.empresa.getNickname(),
			this.tipo.getNombre(),
			this.costo,
			this.estado
		);
	}
	
//	public boolean estaPostulado(String nickname) {
//		int i = 0;
//		boolean b = false;
//		while((i < postulaciones.size()) && !b) {
//			if(postulaciones.get(i).getPostulante().getNickname() == nickname) {
//				b = true;
//			}
//			i++;
//		}
//		return b;
//	}
	
	public boolean estaPostulado(String nickname) {
	    for (Postulacion postulacion : postulaciones) {
	        if (postulacion.getPostulante().getNickname().equals(nickname)) {
	            return true; // Si se encuentra una coincidencia, retorna true
	        }
	    }
	    return false; // Si no se encontraron coincidencias, retorna false
	}
	
	public void agregarPostulacion(Postulacion pos) {
		this.postulaciones.add(pos);
	}
	
	public int getDuracion() {
		return this.tipo.getDuracion();
	}
	
	public void setEstadoConfirmada() {
		this.estado = EstadoOferta.CONFIRMADA;
	}
	
	public void setEstadoRechazada() {
		this.estado = EstadoOferta.RECHAZADA;
	}
	
	public EstadoOferta getEstado() {
		return this.estado;
	}
	
	public List<Keyword> getKeywords(){
		return this.keywords;
	}
}


