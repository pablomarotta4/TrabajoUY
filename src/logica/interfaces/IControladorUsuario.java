package logica.interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import excepciones.CamposVaciosExcepcion;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DataUsuario;
import logica.entidades.Empresa;
import logica.entidades.Postulante;
import logica.entidades.Usuario;

public interface IControladorUsuario {
	
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String nacionalidad, LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion;
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String descripcion, String link) throws UsuarioRepetidoException, CamposVaciosExcepcion;
	public List<String> listarNickEmpresas();
	public List<String> listarNickPostulantes();
	public List<String>listarUsuarios();
	public DataUsuario consultarDatosUsuario(String nick);
//	public Empresa getEmpresa(String nickEmpresa);
//	public Postulante getPostulante(String nickPostulante);
	public List<DTOfertaLaboral> consultarPostulaciones(String nick);
	public List<DTOfertaLaboral> consultarOfertas(String nick);
}

