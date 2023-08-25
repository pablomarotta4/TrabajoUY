package logica.datatypes;

import java.util.List;

import logica.entidades.OfertaLaboral;

public class DTEmpresa extends DTUsuario {

	private String nombreEmpresa;
	private String descripcion;
	private String linkWeb;
	private List<OfertaLaboral> ofertasPublicadas;
	
	public DTEmpresa(String nick, 
			String nombre, 
			String apellido, 
			String email,
			String descripcion,
			String link) {
		super(nick, nombre, apellido, email);
		this.descripcion = descripcion;
		this.linkWeb = link;
	}
}
