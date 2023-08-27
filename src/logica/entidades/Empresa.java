package logica.entidades;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends Usuario{

	private String descripcion;
	private String linkWeb;
	private List<OfertaLaboral> ofertas;

	public Empresa(String nick, 
			String nombre, 
			String apellido, 
			String email,
			String descripcion,
			String link) {
		super(nick, nombre, apellido, email);
		this.descripcion = descripcion;
		this.linkWeb = link;
		this.ofertas = new ArrayList<>();
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getLink() {
		return linkWeb;
	}

	public List<OfertaLaboral> getOfertas() {
		return ofertas;
	}
	
	public void agregarOferta(OfertaLaboral of) {
		this.ofertas.add(of);
	}
}
