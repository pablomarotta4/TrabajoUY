package logica.interfaces;

import java.util.Map;

import logica.entidades.OfertaLaboral;

public interface IManejadorOferta {
	
	public void agregarOferta(OfertaLaboral of);
	public boolean existeOferta(String nombreOferta);
	public Map<String, OfertaLaboral> getOfertas();
}
