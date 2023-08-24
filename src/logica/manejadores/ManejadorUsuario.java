package logica.manejadores;

import logica.entidades.Usuario;
import logica.entidades.Postulante;
import logica.entidades.Empresa;
import logica.interfaces.IManejadorUsuario;
import excepciones.UsuarioRepetidoException;

import java.util.Date;
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
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String nacionalidad, Date nacimiento) throws UsuarioRepetidoException {
		if(!existeUsuarioNick(nickname) && !existeUsuarioEmail(email)) {
			Postulante user = new Postulante(nickname, nombre, apellido, email, nacimiento, nacionalidad);
			agregarUsuario(user);
		}
		else{
			if(existeUsuarioNick(nickname)&& existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname y email.");
			else if(existeUsuarioNick(nickname))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname.");
			else if(existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo email.");			
		}
	}
	
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,String link) throws UsuarioRepetidoException {	
		if(!existeUsuarioNick(nickname) && !existeUsuarioEmail(email)) {
			Empresa user = new Empresa(nickname, nombre, apellido, email, descripcion, link);
			agregarUsuario(user);
		}
		else{
			if(existeUsuarioNick(nickname)&& existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname y email.");
			else if(existeUsuarioNick(nickname))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname.");
			else if(existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo email.");			
		}
	}
	
	public Boolean existeUsuarioNick(String nickname) {
		return usuarios.containsKey(nickname);
	}
	
	public Boolean existeUsuarioEmail(String email) {
		for(Usuario user : usuarios.values()) {
			if(user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public Usuario buscarUsuario(String nick) {
		return usuarios.get(nick);
	}
	
	public void agregarUsuario(Usuario u) {
		this.usuarios.put(u.getNickname(), u);
	}
	
	public Map<String, Usuario> getUsuarios(){
		return this.usuarios;
	}
	
}


