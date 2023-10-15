package logica.manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.Paquete;
import logica.entidades.TipoPublicacion;
import logica.interfaces.IManejadorPaquetes;

public class ManejadorPaquetes implements IManejadorPaquetes{
	
	private Map<String, TipoPublicacion> tipos;
	private Map<String, Paquete> paquetes;
	
	private ManejadorPaquetes() {
		this.tipos = new HashMap<String, TipoPublicacion>();
		this.paquetes= new HashMap<String, Paquete>(); 
	}
	
	private static ManejadorPaquetes instance = null;
	
	public static IManejadorPaquetes getInstance() {
		if (instance == null) {
			instance = new ManejadorPaquetes();
		}
		return instance;
	}
	
	
	public void agregarTipo(TipoPublicacion tipo) {
		this.tipos.put(tipo.getNombre(), tipo);
	}
	
	public Map<String, TipoPublicacion> getTiposPublicacion(){
		return this.tipos;
	}
	
	
	public TipoPublicacion getTipo(String nombre) {
		return tipos.get(nombre);
	}
	
	public void agregarPaquete(Paquete paquete) {
		this.paquetes.put(paquete.getNombre(), paquete);
	}
	
	public boolean existePaquete(String nombrePaquete) {
		return this.paquetes.containsKey(nombrePaquete);	
	}
	
	
	
	
	public void agregarTipoAPaquete(String nombrePaquete, String nombreTipo, Integer cantidad) {
		Paquete paquete= this.paquetes.get(nombrePaquete); //paquete (lo tengo que modificar)
		paquete.agregarTipoAPaquete(nombreTipo, cantidad);
	};

	
	public  Map<String, Paquete> getPaquetes(){
		return this.paquetes; 
	}
	
	public Map<String, Integer> getTiposYCantidades(String nombrePaquete){
		Paquete paq= this.paquetes.get(nombrePaquete);
		return paq.getTiposYCantidades();
	}
	
	
	
	
}
