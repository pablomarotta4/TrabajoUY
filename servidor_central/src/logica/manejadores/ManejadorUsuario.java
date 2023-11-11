package logica.manejadores;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DataUsuario;
import logica.entidades.Empresa;
import logica.entidades.OfertaLaboral;
import logica.entidades.Postulacion;
import logica.entidades.Postulante;
import logica.entidades.Usuario;
import logica.interfaces.IManejadorUsuario;

public class ManejadorUsuario implements IManejadorUsuario{
	
	private static ManejadorUsuario instance = null;
	private Map<String, Usuario> usuarios;
	
	private ManejadorUsuario() {
        this.usuarios = new HashMap<String, Usuario>();
	}
	
	public static IManejadorUsuario getInstance() {
		if (instance == null) {
			instance = new ManejadorUsuario();
		}
		return instance;
	}
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String password, byte[] imageBytes, String nacionalidad, LocalDate nacimiento) 
			throws UsuarioRepetidoException, CamposVaciosExcepcion {
		if (!existeUsuarioNick(nickname) && !existeUsuarioEmail(email)) {
		   if (nickname.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un nickname.");
			else if (email.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un email.");
			else if (nombre.isEmpty() || apellido.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un nombre y un apellido.");
			else if (nacionalidad.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar una descripcion.");
			else {
				String nombreImagen = nickname + ".jpg";
				nombreImagen = nombreImagen.toLowerCase();
				String path = System.getProperty("user.home") + File.separator + "trabajouy" + File.separator + "img" + File.separator;
				File targetFile = new File(path + nombreImagen);
				if(!targetFile.exists() && imageBytes != null) {
					InputStream imageStream = new ByteArrayInputStream(imageBytes);
					try {
						Files.copy(imageStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}	
				Postulante user = new Postulante(nickname, nombre, apellido, email, password, nombreImagen, nacimiento, nacionalidad);
				agregarUsuario(user);
			}
		}
		else {
			if (existeUsuarioNick(nickname)&& existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname y email.");
			else if (existeUsuarioNick(nickname))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname.");
			else if (existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo email.");			
		}
	}
	
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String password, byte[] imageBytes, String descripcion, String link) throws UsuarioRepetidoException, CamposVaciosExcepcion {	
		if (!existeUsuarioNick(nickname) && !existeUsuarioEmail(email)) {
			if (nickname.isEmpty()) 
				throw new CamposVaciosExcepcion("Debe ingresar un nickname.");
			else if (email.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un email.");
			else if (nombre.isEmpty() || apellido.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar un nombre y un apellido.");
			else if (descripcion.isEmpty())
				throw new CamposVaciosExcepcion("Debe ingresar una descripcion.");
			else {
				String nombreImagen = nickname + ".jpg";
				nombreImagen = nombreImagen.toLowerCase();
				String path = System.getProperty("user.home") + File.separator + "trabajouy" + File.separator + "img" + File.separator;
				File targetFile = new File(path + nombreImagen);
				if(!targetFile.exists() && imageBytes != null) {
					InputStream imageStream = new ByteArrayInputStream(imageBytes);
					try {
						Files.copy(imageStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}	
				Empresa user = new Empresa(nickname, nombre, apellido, email, password, nombreImagen, descripcion, link);
				agregarUsuario(user);
			}
		}
		else {
			if (existeUsuarioNick(nickname)&& existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname y email.");
			else if (existeUsuarioNick(nickname))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo nickname.");
			else if (existeUsuarioEmail(email))
				throw new UsuarioRepetidoException("Ya existe un usuario con el mismo email.");			
		}
	}
	
	public Boolean existeUsuarioNick(String nickname) {
		return usuarios.containsKey(nickname);
	}
	
	public Boolean existeUsuarioEmail(String email) {
		for (Usuario user : usuarios.values()) {
			if (user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public Usuario buscarUsuario(String nick) {
		return usuarios.get(nick);
	}
	
	public void agregarUsuario(Usuario usr) {
		this.usuarios.put(usr.getNickname(), usr);
	}
	
	public Map<String, Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public ArrayList<String> listarNickUsuarios(){
		ArrayList<String> listaNick = new ArrayList<>(usuarios.keySet());
		return listaNick;
	}

	public ArrayList<DtOfertaLaboral> obtenerOfertasPostulaciones(String nick) {
		Usuario user = buscarUsuario(nick);
		ArrayList<DtOfertaLaboral> dtofertas= new ArrayList<>();
		if (user instanceof Empresa) {
			Empresa emp = (Empresa) user;
			ArrayList<OfertaLaboral> ofertas = emp.getOfertas();
			for (OfertaLaboral of : ofertas) {
				dtofertas.add(of.getDataType());
			}
		}
		else if (user instanceof Postulante) {
			Postulante pos = (Postulante) user;
			ArrayList<Postulacion> postulaciones = pos.getPostulaciones();
			for (Postulacion post: postulaciones) {
				OfertaLaboral ofer = post.getOfertaLaboral();
				dtofertas.add(ofer.getDataType());
			}
		}
		return dtofertas;
	}
	

	
	public void modificarUsuario(String nick, String nombre, String apellido, String password, String descripcion, String link, LocalDate fechaNac, String nacionalidad) {
		
		Usuario user = this.usuarios.get(nick);
		
		if (user != null) {
			
			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setPassword(password);
			
			if (user instanceof Postulante) {
				Postulante userPost = (Postulante) user;
				userPost.setFechaNacimiento(fechaNac);
				userPost.setNacionalidad(nacionalidad);
			}
			else if (user instanceof Empresa) {
				Empresa userEmp = (Empresa) user;
				userEmp.setLink(link);
				userEmp.setDescripcion(descripcion);
			}
		}
	}
	
	public boolean evaluarCredenciales(String input, String password) throws ElementoInexistenteException {
		Usuario user = usuarios.get(input);
		
		if (user == null && existeUsuarioEmail(input)) {
			for(Usuario usuario : usuarios.values()) {
				if (usuario.getEmail().equals(input)) {
					user = usuario;
				}
			}	
		} else if (user == null && !existeUsuarioEmail(input)) {
			throw new ElementoInexistenteException("No existe el usuario en el sistema.");
		}
		return user.evaluarCredenciales(input, password);
	}
	
	
	public ArrayList<DataUsuario> listarDTUsuarios(){
		Map<String, Usuario> mapaUsr= this.usuarios;
		ArrayList<DataUsuario> listaDTusr= new ArrayList<>();
		for (Usuario usuario: mapaUsr.values()) {	
			DataUsuario dataUsr= new DataUsuario(usuario.getNickname(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getImage());
			dataUsr.setPassword(usuario.getPassword());
			listaDTusr.add(dataUsr);
		}
		
		return listaDTusr;
		
	}

}


