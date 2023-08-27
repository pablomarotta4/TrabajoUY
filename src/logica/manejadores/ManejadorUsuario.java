package logica.manejadores;

import logica.entidades.Usuario;

import logica.entidades.Postulante;
import logica.datatypes.DTOfertaLaboral;
import logica.entidades.Empresa;
import logica.entidades.OfertaLaboral;
import logica.entidades.Postulacion;
import logica.interfaces.IManejadorUsuario;
import excepciones.UsuarioRepetidoException;
import excepciones.CamposVaciosExcepcion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;

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
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String nacionalidad, LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion {
		if(!existeUsuarioNick(nickname) && !existeUsuarioEmail(email)) {
			if(nickname.isEmpty()) 
				throw new CamposVaciosExcepcion("Debe ingresar un nickname.");
			else if(email.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un email.");
			else if(nombre.isEmpty() || apellido.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un nombre y un apellido.");
			else if(nacionalidad.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar una descripcion.");
			else {
			Postulante user = new Postulante(nickname, nombre, apellido, email, nacimiento, nacionalidad);
			agregarUsuario(user);
			}
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
	
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,String link) throws UsuarioRepetidoException, CamposVaciosExcepcion {	
		if(!existeUsuarioNick(nickname) && !existeUsuarioEmail(email)) {
			if(nickname.isEmpty()) 
				throw new CamposVaciosExcepcion("Debe ingresar un nickname.");
			else if(email.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un email.");
			else if(nombre.isEmpty() || apellido.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un nombre y un apellido.");
			else if(descripcion.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar una descripcion.");
			else {
			Empresa user = new Empresa(nickname, nombre, apellido, email, descripcion, link);
			agregarUsuario(user);
			}
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
	
	public List<String> listarNickUsuarios(){
		List<String> listaNick = new ArrayList<>(usuarios.keySet());
		return listaNick;
	}

	public List<DTOfertaLaboral> obtenerOfertasPostulaciones(String nick) {
		Usuario user = buscarUsuario(nick);
		List<DTOfertaLaboral> dtofertas= new ArrayList<>();
		if(user instanceof Empresa) {
			Empresa emp = (Empresa) user;
			List<OfertaLaboral> ofertas = emp.getOfertas();
			for(OfertaLaboral of : ofertas) {
				dtofertas.add(of.getDataType());
			}
		}
		else if(user instanceof Postulante) {
			Postulante pos = (Postulante) user;
			List<Postulacion> postulaciones = pos.getPostulaciones();
			for(Postulacion po: postulaciones) {
				OfertaLaboral of = po.getOfertaLaboral();
				dtofertas.add(of.getDataType());
			}
		}
		return dtofertas;
	}
	
	
}


