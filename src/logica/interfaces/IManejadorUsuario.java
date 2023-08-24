package logica.interfaces;

import java.util.Date;
import java.util.Map;

import excepciones.UsuarioRepetidoException;
import logica.entidades.Usuario;

public interface IManejadorUsuario {
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String nacionalidad, Date nacimiento) throws UsuarioRepetidoException;
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String descripcion, String link) throws UsuarioRepetidoException;
	public Boolean existeUsuarioNick(String nickname);
	public Boolean existeUsuarioEmail(String email);
	public Usuario buscarUsuario(String nick);
	public void agregarUsuario(Usuario u);
	
	public Map<String, Usuario> getUsuarios();
}
		