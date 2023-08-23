package logica.interfaces;

import logica.entidades.Keyword;

public interface IManejadorKeywords {
	
	public void agregarKeyword(Keyword key);
	
	public boolean existeKeyword(String nombreKeyword);
}
