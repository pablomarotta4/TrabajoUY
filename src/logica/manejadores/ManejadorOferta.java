package logica.manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.OfertaLaboral;
import logica.interfaces.IManejadorOferta;

public class ManejadorOferta implements IManejadorOferta{
	
	public static ManejadorOferta instance = null;
	private Map<String, OfertaLaboral> ofertasLaborales;
	
	
	private ManejadorOferta() {
		this.ofertasLaborales = new HashMap<String, OfertaLaboral>();
	}
	
	public static IManejadorOferta getInstance() {
		if(instance == null) {
			instance = new ManejadorOferta();
		}
		return instance;
	}
	
	public void agregarOferta(OfertaLaboral of) {
		this.ofertasLaborales.put(of.getNombre(), of);
	}

}
