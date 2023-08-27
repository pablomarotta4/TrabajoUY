package logica.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.CamposVaciosExcepcion;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DataEmpresa;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataUsuario;
import logica.entidades.Empresa;
import logica.entidades.Postulante;
import logica.entidades.Usuario;
import logica.interfaces.Factory;
import logica.interfaces.IControladorUsuario;
import logica.interfaces.IManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{
	
	private IManejadorUsuario manejadorUsuario;
	
	public ControladorUsuario() {
		Factory f = Factory.getInstance();
		this.manejadorUsuario = f.getManejadorUsuario();
	}
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String nacionalidad, LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion {
		manejadorUsuario.crearPostulante(nickname, nombre, apellido, email, nacionalidad, nacimiento);
	}
	
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String descripcion, String link) throws UsuarioRepetidoException, CamposVaciosExcepcion {
		manejadorUsuario.crearEmpresa(nickname, nombre, apellido, email, descripcion, link);
	}
	
	public List<String> listarNickEmpresas() {
		List<String> list = new ArrayList<String>();
		for(Usuario u : manejadorUsuario.getUsuarios().values()) {
			// Si usuario es instancia de Empresa guardo el nickname en la lista a retornar
			if(u instanceof Empresa) {
				list.add(u.getNickname());
			}
		}
		return list;
	}	
	
	public List<String> listarNickPostulantes() {
		List<String> list = new ArrayList<String>();
		for(Usuario u : manejadorUsuario.getUsuarios().values()) {
			// Si usuario es instancia de Postulante guardo el nickname en la lista a retornar
			if(u instanceof Postulante) {
				list.add(u.getNickname());
			}
		}
		return list;
	}
	
	public List<String>listarUsuarios(){
		return manejadorUsuario.listarNickUsuarios();
	}

	public DataUsuario consultarDatosUsuario(String nick) {
		Usuario us = manejadorUsuario.buscarUsuario(nick);
	    if (us instanceof Postulante) {
	        Postulante postulante = (Postulante) us;
	        return new DataPostulante(postulante.getNickname(), postulante.getNombre(), postulante.getApellido(), postulante.getEmail(), postulante.getNacimiento(), postulante.getNacionalidad());
	    } else if (us instanceof Empresa) {
	        Empresa empresa = (Empresa) us;
	        return new DataEmpresa(empresa.getNickname(), empresa.getNombre(), empresa.getApellido(), empresa.getEmail(), empresa.getDescripcion(), empresa.getLink());
	    }
		return null;
	}

	public Empresa getEmpresa(String nickEmpresa) {
		return (Empresa) manejadorUsuario.buscarUsuario(nickEmpresa);
	}
	
	public Postulante getPostulante(String nickPostulante) {
		return (Postulante) manejadorUsuario.buscarUsuario(nickPostulante);
	}

	public List<DTOfertaLaboral> consultarPostulaciones(String nick) {
		return manejadorUsuario.obtenerOfertasPostulaciones(nick);
	}

	public List<DTOfertaLaboral> consultarOfertas(String nick) {
		return manejadorUsuario.obtenerOfertasPostulaciones(nick);
	}

//	@Override
//	public List<String> listarNickPostulantes() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
