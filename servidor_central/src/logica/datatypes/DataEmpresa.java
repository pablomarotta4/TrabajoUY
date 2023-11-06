package logica.datatypes;

import java.util.ArrayList;
import logica.datatypes.DtOfertaLaboral;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataEmpresa extends DataUsuario{
	
	private String descripcion;
	private String link;
	private ArrayList<DtOfertaLaboral> ofertas;
	

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

	public void setOfertas(ArrayList<DtOfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}

	
	public ArrayList<DtOfertaLaboral> getOfertas() {
		return this.ofertas;
	}
	
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}

	public void setLink(String link) {
		this.link = link;
	}
	

	
}
