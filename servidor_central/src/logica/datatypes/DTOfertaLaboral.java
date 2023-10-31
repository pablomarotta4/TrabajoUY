package logica.datatypes;


import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTOfertaLaboral {
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private float remuneracion;
	private LocalDate fechaAlta;
	private String imageUrl;
	private float costo;
	private ArrayList<DTPostulacion> postulaciones;
	private ArrayList<String> keywords;
	private String nombreEmpresa;
	private int duracion;
	private EstadoOferta estado;
	
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
			String imageUrl,
			ArrayList<DTPostulacion> postulaciones,
			ArrayList<String> keywords,
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
		this.imageUrl = imageUrl;
	}	
	
	public DTOfertaLaboral(
			String nombre,
			String descripcion,
			String ciudad,
			String departamento,
			String horario,
			float remuneracion,
			LocalDate fechaAlta,
			String imageUrl,
			ArrayList<DTPostulacion> postulaciones,
			ArrayList<String> keywords,
			String nombreEmpresa,
			String tipoPublicacion,
			float costo,
			EstadoOferta estado
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
		this.estado = estado;
		this.imageUrl = imageUrl;
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
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public ArrayList<DTPostulacion> getPostulaciones() {
		return this.postulaciones;
	}
	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}
	public ArrayList<String> getKeywords() {
		return this.keywords;
	}
		
	public float getCosto() {
		return this.costo;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	
	public EstadoOferta getEstado( ) {
		return this.estado;
	}
	
	public boolean equals(DTOfertaLaboral ofer) {
		Float rem = this.remuneracion;
		return 
				this.nombre.equals(ofer.getNombre()) &&
				this.descripcion.equals(ofer.getDescripcion()) &&
				this.ciudad.equals(ofer.getCiudad()) &&
				this.departamento.equals(ofer.getDepartamento()) &&
				this.horario.equals(ofer.getHorario()) &&
				rem.equals(ofer.getRemuneracion()) &&
				this.fechaAlta.equals(ofer.getFechaAlta()) &&
				this.nombreEmpresa.equals(ofer.getNombreEmpresa()) &&
				this.keywords.equals(ofer.getKeywords()) &&
				this.costo == ofer.getCosto();
	}
	
	public DTPostulacion getPostulacionByNickname(String nickname) {
		DTPostulacion postulacion = null;
		boolean postulacionDeNick = false;
		int icont = 0;
		while (icont < postulaciones.size() && !postulacionDeNick) {
			postulacionDeNick = postulaciones.get(icont).getNickPostulante().equals(nickname);
			icont++;
		}
		return postulacion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public void setRemuneracion(Float remuneracion) {
		this.remuneracion = remuneracion;
	}
	
	public void setCosto(Float costo) {
		this.costo = costo;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fechaAlta = fecha;
	}
	
	public void setPostulaciones(ArrayList<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	
	public void setEstado(EstadoOferta estado) {
		this.estado = estado;
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
