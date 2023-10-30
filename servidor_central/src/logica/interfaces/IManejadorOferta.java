package logica.interfaces;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.OfertaLaboral;

public interface IManejadorOferta {
	
	public void agregarOferta(OfertaLaboral ofer);
	public boolean existeOferta(String nombreOferta);
	public HashMap<String, OfertaLaboral> getOfertas();
	public OfertaLaboral getOfertaDeNombre(String nombreOferta);
}
