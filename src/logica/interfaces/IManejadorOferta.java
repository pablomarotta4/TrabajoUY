package logica.interfaces;

import logica.entidades.OfertaLaboral;

public interface IManejadorOferta {
	
	public void agregarOferta(OfertaLaboral of);
	
	public boolean existeOferta(String nombreOferta);
}
