package logica.manejadores;

import logica.entidades.Usuario;
import logica.interfaces.IManejadorUsuario;

import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario implements IManejadorUsuario{
	
	public static ManejadorUsuario instance = null;
	private Map<String, Usuario> usuariosCi;
	
	
	private ManejadorUsuario() {
        this.usuariosCi = new HashMap<String, Usuario>();
	}
	
	public static ManejadorUsuario getInstance() {
		if(instance == null) {
			instance = new ManejadorUsuario();
		}
		return instance;
	}
	
	public void agregarUsuario() {
		//
	}
	
	
}
