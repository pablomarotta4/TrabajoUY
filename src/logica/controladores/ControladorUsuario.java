package logica.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.CamposVaciosExcepcion;
import excepciones.UsuarioRepetidoException;
import logica.entidades.Empresa;
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
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String nacionalidad, Date nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion {
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
	
	public Empresa getEmpresa(String nickname) {
		Empresa e = (Empresa) this.manejadorUsuario.getUsuarios().get(nickname);
		return e;
	}
}
