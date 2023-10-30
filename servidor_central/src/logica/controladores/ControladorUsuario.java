package logica.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DataEmpresa;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataUsuario;
import logica.entidades.Empresa;
import logica.entidades.Postulacion;
import logica.entidades.Postulante;
import logica.entidades.Usuario;
import logica.interfaces.Factory;
import logica.interfaces.IControladorUsuario;
import logica.interfaces.IManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{
	
	private IManejadorUsuario manejadorUsuario;
	
	public ControladorUsuario() {
		Factory fact = Factory.getInstance();
		this.manejadorUsuario = fact.getManejadorUsuario();
	}
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String password, String imageUrl, String nacionalidad, LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion {
		manejadorUsuario.crearPostulante(nickname, nombre, apellido, email, password, imageUrl, nacionalidad, nacimiento);
	}
	
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String password, String imageUrl, String descripcion, String link) throws UsuarioRepetidoException, CamposVaciosExcepcion {
		manejadorUsuario.crearEmpresa(nickname, nombre, apellido, email, password, imageUrl, descripcion, link);
		System.out.println("Empresa" + nickname);
	}
	
	public ArrayList<String> listarNickEmpresas() {
		ArrayList<String> list = new ArrayList<String>();
		for (Usuario u : manejadorUsuario.getUsuarios().values()) {
			// Si usuario es instancia de Empresa guardo el nickname en la lista a retornar
			if (u instanceof Empresa) {
				list.add(u.getNickname());
			}
		}
		return list;
	}	
	
	public ArrayList<String> listarNickPostulantes() {
		ArrayList<String> list = new ArrayList<String>();
		for (Usuario u : manejadorUsuario.getUsuarios().values()) {
			// Si usuario es instancia de Postulante guardo el nickname en la lista a retornar
			if (u instanceof Postulante) {
				list.add(u.getNickname());
			}
		}
		return list;
	}
	
	public ArrayList<String> listarUsuarios(){
		return manejadorUsuario.listarNickUsuarios();
	}

	public DataUsuario consultarDatosUsuario(String nick) {
		Usuario usr = manejadorUsuario.buscarUsuario(nick);
	    if (usr instanceof Postulante) {
	        Postulante postulante = (Postulante) usr;
	        return postulante.getDataPostulante();
	    } else if (usr instanceof Empresa) {
	        Empresa empresa = (Empresa) usr;
	        return empresa.getDataEmpresa();
	    }
		return null;
	}

	public Empresa getEmpresa(String nickEmpresa) {
		return (Empresa) manejadorUsuario.buscarUsuario(nickEmpresa);
	}
	
	public Postulante getPostulante(String nickPostulante) {
		return (Postulante) manejadorUsuario.buscarUsuario(nickPostulante);
	}

	public ArrayList<DTOfertaLaboral> consultarPostulaciones(String nick) {
		return manejadorUsuario.obtenerOfertasPostulaciones(nick);
	}

	public ArrayList<DTOfertaLaboral> consultarOfertas(String nick) {
		return manejadorUsuario.obtenerOfertasPostulaciones(nick);
	}
	
	
	public void modificarUsuario(String nick, String nombre, String apellido, String email, String descripcion, String link, LocalDate fechaNac, String nacionalidad) {
		manejadorUsuario.modificarUsuario(nick, nombre, apellido, email, descripcion, link, fechaNac, nacionalidad);
	}

//	@Override
//	public List<String> listarNickPostulantes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public boolean evaluarCredenciales(String nickname, String password) throws ElementoInexistenteException{		
		return manejadorUsuario.evaluarCredenciales(nickname, password);
	}
	
	public boolean estaPostulado(String nickname, String nombreOferta) {
		boolean estaPostulado = false;
		Usuario user = this.manejadorUsuario.buscarUsuario(nickname);
		if (user instanceof Postulante) {
			Postulante postulante = (Postulante) user;
			List<Postulacion> postulaciones = postulante.getPostulaciones();
			int icont = 0;
			while (icont < postulaciones.size() && !estaPostulado) {
				estaPostulado = postulaciones.get(icont).getOfertaLaboral().getNombre().equals(nombreOferta);
				icont++;
			}
		}
		return estaPostulado;
	}
	
	public String getFotoUsuario(String nickname) {
		Map<String, Usuario> usuarios = this.manejadorUsuario.getUsuarios();
		String fotoUsuario = usuarios.get(nickname).getImage();
		return fotoUsuario;
	}

	@Override
	public ArrayList<DataUsuario> listarDTUsuarios() {
		// TODO Auto-generated method stub
		return manejadorUsuario.listarDTUsuarios();
	}

	@Override
	public DataEmpresa getDTEmpresa(String nick) {
		return this.getEmpresa(nick).getDataEmpresa();
	}

	@Override
	public DataPostulante getDTPostulante(String nick) {
		return this.getPostulante(nick).getDataPostulante();
	}
}
