package logica.manejadores;

import java.util.Map;

import logica.entidades.TipoPublicacion;
import logica.interfaces.IManejadorPaquetes;

public class ManejadorPaquetes implements IManejadorPaquetes{
	
	public static ManejadorPaquetes instance = null;
	private Map<String, TipoPublicacion> tipos;
	
	public void agregarTipo(TipoPublicacion tipo) {
		this.tipos.put(tipo.getNombre(), tipo);
	}
}
