package logica.beans;


import java.util.ArrayList;
import java.util.HashMap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DataTipoPublicacion;
import logica.datatypes.DataUsuario;
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionBean {
	
	private ArrayList<DtOfertaLaboral> listaDtOfertas = new ArrayList<>();
	private ArrayList<String> listaStrings = new ArrayList<>();
	private ArrayList<DataTipoPublicacion> listaDataTipoPublicacion = new ArrayList<>();
	private ArrayList<DataUsuario> listaDataUsuarios = new ArrayList<>();
	
	public CollectionBean() {
		
	}
	
	// Lista DtOfertaLaboral
	public ArrayList<DtOfertaLaboral> getListaDtOfertas() {
		return this.listaDtOfertas;
	}
	
	public void setListaDtOfertas(ArrayList<DtOfertaLaboral> lista) {
		this.listaDtOfertas = lista;
	}
	
	// Lista Strings
	public ArrayList<String> getListaStrings(){
		return this.listaStrings;
	}
	public void setListaStrings(ArrayList<String> lista) {
		this.listaStrings = lista;
	}
	
	// Lista DataTipoPublicacion
	public ArrayList<DataTipoPublicacion> getListaDataTipoPublicacion(){
		return this.listaDataTipoPublicacion;
	}
	public void setListaDataTipoPublicacion(ArrayList<DataTipoPublicacion> list) {
		this.listaDataTipoPublicacion = list;
	}

	// Lista DataUsuario
	public ArrayList<DataUsuario> getListaDataUsuarios() {
		return listaDataUsuarios;
	}
	public void setListaDataUsuarios(ArrayList<DataUsuario> listaDtUsuarios) {
		this.listaDataUsuarios = listaDtUsuarios;
	}

}
