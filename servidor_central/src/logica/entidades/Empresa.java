package logica.entidades;

import java.util.ArrayList;
import java.util.List;

import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DataEmpresa;


public class Empresa extends Usuario{

	private String descripcion;
	private String linkWeb;
	private ArrayList<OfertaLaboral> ofertas;

	public Empresa(String nick, 
			String nombre, 
			String apellido, 
			String email,
			String password, 
			String imageUrl,
			String descripcion,
			String link) {
		super(nick, nombre, apellido, email, password, imageUrl);
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

	public ArrayList<OfertaLaboral> getOfertas() {
		return ofertas;
	}
	
	public void agregarOferta(OfertaLaboral ofer) {
		this.ofertas.add(ofer);
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public void setLink(String link) {
		this.linkWeb = link;
	}
	
	public ArrayList<DtOfertaLaboral> getDTOfertasLaborales(){
		ArrayList<DtOfertaLaboral> lista = new ArrayList<>();
		for (OfertaLaboral ofer: this.ofertas) {
			lista.add(ofer.getDataType());
		}
		return lista;
	}
	
	
	public DataEmpresa getDataEmpresa() {
		DataEmpresa dtempresa = new DataEmpresa(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.descripcion, this.linkWeb, this.getImage());
		dtempresa.setOfertas(this.getDTOfertasLaborales());
		dtempresa.setPassword(this.getPassword());
		return dtempresa;
	}
	
}


