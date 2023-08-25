package logica.manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.entidades.Keyword;
import logica.interfaces.IManejadorKeywords;

public class ManejadorKeywords implements IManejadorKeywords {
	
	private static ManejadorKeywords instance = null;
	
	private Map<String, Keyword> keywords;
	
	private ManejadorKeywords() {
		this.keywords = new HashMap<String, Keyword>();
	}
	
	public static IManejadorKeywords getInstance() {
		if(instance == null) {
			instance = new ManejadorKeywords();
		}
		return instance;
	}
	
	public void agregarKeyword(Keyword key) {
		this.keywords.put(key.getKeyword(), key);
	}
	
	public boolean existeKeyword(String nombreKeyword) {
		return this.keywords.containsKey(nombreKeyword);
	}
	
	public Map<String, Keyword> getKeywords(){
		return this.keywords;
	}
}
