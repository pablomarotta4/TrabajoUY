package logica.interfaces;

import java.util.Map;

import logica.entidades.Paquete;
import logica.entidades.TipoPublicacion;

public interface IManejadorPaquetes {
	
	public void agregarTipo(TipoPublicacion tipo);
	
	public Map<String, TipoPublicacion> getTiposPublicacion();
	
	

	public void agregarPaquete(Paquete paquete);
	
	public boolean existePaquete(String nombrePaquete);


	public TipoPublicacion getTipo(String nombre);
	
	public void agregarTipoAPaquete(String nombrePaquete, String nombreTipo, Integer cantidad);
	
	//public List<String> getNombresPaquetes();
	
	public  Map<String, Paquete> getPaquetes();
	
	public Map<String, Integer> getTiposYCantidades(String nombrePaquete);
	

}
