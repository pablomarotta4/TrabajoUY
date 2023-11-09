package logica.entidades;

import java.util.List;

import logica.datatypes.DTPostulacion;
import logica.datatypes.DataPostulante;

import java.time.LocalDate;
import java.util.ArrayList;

public class Postulante extends Usuario{

	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private ArrayList<Postulacion> postulaciones;
	
	public Postulante(String nick, 
			String nombre, 
			String apellido, 
			String email,
			String password, 
			String imageUrl,
			LocalDate fechaNac,
			String nacionalidad) {
		super(nick, nombre, apellido, email, password, imageUrl);
		this.fechaNacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
		this.postulaciones = new ArrayList<>();
	}
	
	public LocalDate getNacimiento() {
		return fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}

	public ArrayList<Postulacion> getPostulaciones() {
		return postulaciones;
	}
	
	public void agregarPostulacion(Postulacion pos) {
		this.postulaciones.add(pos);
	}
	
	public void setFechaNacimiento(LocalDate fechaNac) {
		this.fechaNacimiento = fechaNac;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public ArrayList<DTPostulacion> getDTPostulaciones() {
		ArrayList<DTPostulacion> lista = new ArrayList<>();
		for (Postulacion post: this.postulaciones) {
			lista.add(post.getDatatype());
		}
		return lista;
	}
	
	public DataPostulante getDataPostulante() {
		DataPostulante dtpostulante = new DataPostulante(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.fechaNacimiento, this.nacionalidad, this.getImage());
		dtpostulante.setPostulaciones(this.getDTPostulaciones());
		dtpostulante.setPassword(this.getPassword());
		return dtpostulante;
	}
}
