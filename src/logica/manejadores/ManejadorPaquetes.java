package logica.manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.TipoPublicacion;
import logica.interfaces.IManejadorPaquetes;
import logica.interfaces.IManejadorUsuario;

public class ManejadorPaquetes implements IManejadorPaquetes{
	
	private Map<String, TipoPublicacion> tipos;
	
	private ManejadorPaquetes() {
		this.tipos = new HashMap<String, TipoPublicacion>();
	}
	
	public static ManejadorPaquetes instance = null;
	
	public static IManejadorPaquetes getInstance() {
		if(instance == null) {
			instance = new ManejadorPaquetes();
		}
		return instance;
	}
	
	
	public void agregarTipo(TipoPublicacion tipo) {
		this.tipos.put(tipo.getNombre(), tipo);
	}
	
	
}
