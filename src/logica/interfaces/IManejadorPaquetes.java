package logica.interfaces;

import java.util.Map;

import logica.entidades.Paquete;
import logica.entidades.TipoPublicacion;

public interface IManejadorPaquetes {
	
	public void agregarTipo(TipoPublicacion tipo);
	
	public Map<String, TipoPublicacion> getTiposPublicacion();
	
	public void getNombresDeTipo();
	

	public void agregarPaquete(Paquete paquete);
	
	public boolean existePaquete(String nombrePaquete);


	public TipoPublicacion getTipo(String nombre);

}
