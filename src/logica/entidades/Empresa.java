package logica.entidades;

import java.util.Date;

public class Empresa extends Usuario{

	private String nombreEmpresa;
	private String descripcion;
	private String linkWeb;
	
	public Empresa(String nick, 
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
