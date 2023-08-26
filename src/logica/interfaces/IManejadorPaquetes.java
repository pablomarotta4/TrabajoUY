package logica.interfaces;

import java.util.Map;

import logica.entidades.TipoPublicacion;

public interface IManejadorPaquetes {
	
	public void agregarTipo(TipoPublicacion tipo);
	
	public Map<String, TipoPublicacion> getTiposPublicacion();
	
	public void getNombresDeTipo();
	
	public TipoPublicacion getTipo(String nombre);
}
