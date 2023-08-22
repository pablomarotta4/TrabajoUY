package logica.manejadores;

import logica.entidades.Usuario;
import logica.interfaces.IManejadorUsuario;

import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario implements IManejadorUsuario{
	
	public static ManejadorUsuario instance = null;
	private Map<String, Usuario> usuarios;
	
	
	private ManejadorUsuario() {
        this.usuarios = new HashMap<String, Usuario>();
	}
	
	public static IManejadorUsuario getInstance() {
		if(instance == null) {
			instance = new ManejadorUsuario();
		}
		return instance;
	}
	

	public void agregarUsuario(Usuario u) {
		this.usuarios.put(u.getNickname(), u);
	}
	
	public Map<String, Usuario> getUsuarios(){
		return this.usuarios;
	}
		
}
