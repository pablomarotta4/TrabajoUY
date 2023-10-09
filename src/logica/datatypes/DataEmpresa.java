package logica.datatypes;

import java.util.List;


public class DataEmpresa extends DataUsuario{
	
	private String descripcion;
	private String link;
	private List<DTOfertaLaboral> ofertas;

	public DataEmpresa(String nick, 
			String nombre, 
			String apellido, 
			String email,
			String descripcion,
			String link,
			String imageUrl) {
		super(nick, nombre, apellido, email, imageUrl);
		this.descripcion = descripcion;
		this.link = link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getLink() {
		return link;
	}
	public void setOfertas(List<DTOfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}
	
	public List<DTOfertaLaboral> getOfertasLaborales() {
		return this.ofertas;
	}
}
