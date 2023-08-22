package logica.interfaces;

import java.util.Map;

import logica.entidades.Usuario;

public interface IManejadorUsuario {

	public void agregarUsuario(Usuario u);
	
	public Map<String, Usuario> getUsuarios();
}
		