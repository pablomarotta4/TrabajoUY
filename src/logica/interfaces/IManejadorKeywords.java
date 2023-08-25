package logica.interfaces;

import java.util.Map;

import logica.entidades.Keyword;

public interface IManejadorKeywords {
	
	public void agregarKeyword(Keyword key);
	public boolean existeKeyword(String nombreKeyword);
	public Map<String, Keyword> getKeywords();
}
