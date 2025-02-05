package logica.manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.OfertaLaboral;
import logica.interfaces.IManejadorOferta;

public class ManejadorOferta implements IManejadorOferta{
	
	private static ManejadorOferta instance = null;
	private HashMap<String, OfertaLaboral> ofertasLaborales;
	
	
	private ManejadorOferta() {
		this.ofertasLaborales = new HashMap<String, OfertaLaboral>();
	}
	
	public static IManejadorOferta getInstance() {
		if (instance == null) {
			instance = new ManejadorOferta();
		}
		return instance;
	}
	
	public void agregarOferta(OfertaLaboral ofer) {
		this.ofertasLaborales.put(ofer.getNombre(), ofer);
	}
	
	public boolean existeOferta(String nombreOferta) {
		return this.ofertasLaborales.containsKey(nombreOferta);
	}
	
	public HashMap<String, OfertaLaboral> getOfertas(){
		return this.ofertasLaborales;
	}


	public OfertaLaboral getOfertaDeNombre(String nombreOferta) {
		
		return ofertasLaborales.get(nombreOferta);
	}

}
