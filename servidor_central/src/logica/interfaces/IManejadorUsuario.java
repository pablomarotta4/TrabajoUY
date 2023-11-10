package logica.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DataUsuario;
import logica.entidades.Usuario;

public interface IManejadorUsuario {
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String password, byte[] imageBytes, String nacionalidad, LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion;
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String password,  byte[] imageBytes, String descripcion, String link) throws UsuarioRepetidoException, CamposVaciosExcepcion;
	public Boolean existeUsuarioNick(String nickname);
	public Boolean existeUsuarioEmail(String email);
	public Usuario buscarUsuario(String nick);
	public void agregarUsuario(Usuario usr);
	public ArrayList<String> listarNickUsuarios();
	public Map<String, Usuario> getUsuarios();
	public ArrayList<DtOfertaLaboral> obtenerOfertasPostulaciones(String nick);
	public boolean evaluarCredenciales(String nickname, String password) throws ElementoInexistenteException;
	public void modificarUsuario(String nick, String nombre, String apellido, String email, String descripcion, String link, LocalDate fechaNac, String nacionalidad);
	public ArrayList<DataUsuario> listarDTUsuarios();
}
		