package logica.datatypes;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataEmpresa extends DataUsuario{
	
	private String descripcion;
	private String link;
	private List<DTOfertaLaboral> ofertas;

	public DataEmpresa() {
		
	}
	
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
	
	public List<DTOfertaLaboral> getOfertasLaborales() {
		return this.ofertas;
	}
	
	public void setOfertas(List<DTOfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
}
