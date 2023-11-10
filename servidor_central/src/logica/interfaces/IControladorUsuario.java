package logica.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DataEmpresa;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataUsuario;
import logica.entidades.Empresa;

public interface IControladorUsuario {
	
	
	public void crearPostulante(String nickname, String nombre, String apellido, String email, String password, byte[] imageBytes, String nacionalidad, LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion;
	public void crearEmpresa(String nickname, String nombre, String apellido, String email, String password, String imageUrl, String descripcion, String link) throws UsuarioRepetidoException, CamposVaciosExcepcion;
	public ArrayList<String> listarNickEmpresas();
	public ArrayList<String> listarNickPostulantes();
	public ArrayList<String> listarUsuarios();
	public DataUsuario consultarDatosUsuario(String nick);
	public boolean evaluarCredenciales(String nickname, String password) throws ElementoInexistenteException;
	public boolean estaPostulado(String nickname, String nombreOferta);
//	public Empresa getEmpresa(String nickEmpresa);
//	public Postulante getPostulante(String nickPostulante);
	public ArrayList<DtOfertaLaboral> consultarPostulaciones(String nick);
	public ArrayList<DtOfertaLaboral> consultarOfertas(String nick);
	public void modificarUsuario(String nick, String nombre, String apellido, String email, String descripcion, String link, LocalDate fechaNac, String nacionalidad);
	public String getFotoUsuario(String nickname);
	public ArrayList<DataUsuario> listarDTUsuarios();
	public Empresa getEmpresa(String nickEmpresa);
	public DataEmpresa getDTEmpresa(String nick);
	public DataPostulante getDTPostulante(String nick);
}

