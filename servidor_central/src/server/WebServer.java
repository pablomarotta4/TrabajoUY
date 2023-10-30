package server;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;


import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import excepciones.UsuarioRepetidoException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.ws.Endpoint;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.datatypes.DataEmpresa;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataTipoPublicacion;
import logica.datatypes.DataUsuario;
import logica.entidades.Empresa;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServer {

	private IControladorUsuario ctrlUsuario;
	private IControladorOferta ctrlOferta;
	private IControladorCompraTipo ctrlCompraTipo;
	private Endpoint endpoint = null;
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://localhost:8085/webService", this);
	}
	
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public void crearPostulante(
    		String nick, 
    		String nombre, 
    		String apellido, 
    		String email,
    		String pass, 
    		String imageUrl, 
    		String nacionalidad, 
    		String nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion {
    	
    	try {
    		ctrlUsuario = Factory.getInstance().getControladorUsuario();
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    		LocalDate fechaNac = LocalDate.parse(nacimiento, formatter);
    		ctrlUsuario.crearPostulante(
    				nick, 
    				nombre, 
    				apellido, 
    				email, 
    				pass, 
    				imageUrl, 
    				nacionalidad, 
    				fechaNac
				);
    	} catch (UsuarioRepetidoException | CamposVaciosExcepcion ex) {
    		throw ex;
    	}
    }
    
    @WebMethod
	public void crearEmpresa(
			String nickname, 
			String nombre, 
			String apellido, 
			String email, 
			String password, 
			String imageUrl, 
			String descripcion, 
			String link) throws UsuarioRepetidoException, CamposVaciosExcepcion {
		    	
		    	try {
		    		ctrlUsuario = Factory.getInstance().getControladorUsuario();
		    		ctrlUsuario.crearEmpresa(nickname, nombre, apellido, email, password, imageUrl, descripcion, link);
		    	} catch (UsuarioRepetidoException | CamposVaciosExcepcion ex) {
		    		throw ex;
		    	}
		    }
    
    @WebMethod
    public ArrayList<String> listarNickEmpresas(){
    	return ctrlUsuario.listarNickEmpresas();
    }
    @WebMethod
	public ArrayList<String> listarNickPostulantes(){
		return ctrlUsuario.listarNickPostulantes();
	}
    @WebMethod
	public ArrayList<String> listarUsuarios(){
		return ctrlUsuario.listarUsuarios();
	}
    @WebMethod
	public DataUsuario consultarDatosUsuario(String nick) {
		return ctrlUsuario.consultarDatosUsuario(nick);
	}
    @WebMethod
	public boolean evaluarCredenciales(String nickname, String password) throws ElementoInexistenteException{
		return ctrlUsuario.evaluarCredenciales(nickname, password);
	}
    @WebMethod
	public boolean estaPostulado(String nickname, String nombreOferta) {
		return ctrlUsuario.estaPostulado(nickname, nombreOferta);
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> consultarPostulaciones(String nick){
		ArrayList<DTOfertaLaboral> listaOfertas = ctrlUsuario.consultarPostulaciones(nick);
		return listaOfertas;
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> consultarOfertas(String nick){
		ArrayList<DTOfertaLaboral> listaOfertas = ctrlUsuario.consultarOfertas(nick);
		return listaOfertas;
	}
    @WebMethod
	public void modificarUsuario(String nick, String nombre, String apellido, String email, String descripcion, String link, LocalDate fechaNac, String nacionalidad) {
    	ctrlUsuario.modificarUsuario(nick, nombre, apellido, email, descripcion, link, fechaNac, nacionalidad);
	}
    @WebMethod
	public String getFotoUsuario(String nickname) {
		return "";
	}
    @WebMethod
	public ArrayList<DataUsuario> listarDTUsuarios(){
		ArrayList<DataUsuario> listaUsuarios = ctrlUsuario.listarDTUsuarios();
		return listaUsuarios;
	}
    @WebMethod
	public Empresa getEmpresa(String nickEmpresa) {
		return ctrlUsuario.getEmpresa(nickEmpresa);
	}
//    @WebMethod
//	public void altaOfertaLaboral(
//			String empresa,
//			String tipoPublicacion,
//			String nombre,
//			String descripcion,
//			String horario,
//			float remuneracion,
//			String ciudad,
//			String departamento,
//			LocalDate fechaAlta,
//			String imageUrl,
//			ArrayList<String> keywords
//		) throws ElementoRepetidoException, ElementoInexistenteException{
//		
//	}
//    @WebMethod
//	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException{
//    	ctrlOferta.altaKeyword(nombreKeyword);
//	}
//    @WebMethod
//	public List<String> listarKeywords(){
//		return ctrlOferta.listarKeywords();
//	}
//    @WebMethod
//	public List<String> listarOfertasByEmpresa(String nombreEmpresa){
//		return ctrlOferta.listarOfertasByEmpresa(nombreEmpresa);
//	}
//    @WebMethod
//	public List<String> listarOfertasAceptadasByEmpresa(String nombreEmpresa){
//		return ctrlOferta.listarOfertasAceptadasByEmpresa(nombreEmpresa);
//	}
//    @WebMethod
//	public List<String> listarOfertasIngresadasByEmpresa(String nombreEmpresa){
//		return ctrlOferta.listarOfertasIngresadasByEmpresa(nombreEmpresa);
//	}
//    @WebMethod
//	public List<String> listarNombreOfertas(){
//		return ctrlOferta.listarNombreOfertas();
//	}
//    @WebMethod
//	public DTOfertaLaboral listarDatosOferta(String nombreOferta) throws ElementoInexistenteException{
//		return ctrlOferta.listarDatosOferta(nombreOferta);
//	}
//    @WebMethod
//	public void altaPostulacion(
//			String nickname,
//			String oferta,
//			String cvReducido,
//			String motivacion,
//			LocalDate fecha
//	) throws ElementoRepetidoException, NoExisteInstancia, ElementoInexistenteException{
//    	ctrlOferta.altaPostulacion(nickname, oferta, cvReducido, motivacion, fecha);
//	}
    @WebMethod
	public DTOfertaLaboral obtenerEmpresaDeOferta(String nombreOferta) {
		return ctrlOferta.obtenerEmpresaDeOferta(nombreOferta);
    }
//    @WebMethod
//	public void confirmarOferta(String nombreOferta) {
//    	ctrlOferta.confirmarOferta(nombreOferta);
//	}
//    @WebMethod
//	public void rechazarOferta(String nombreOferta) {
//    	ctrlOferta.rechazarOferta(nombreOferta);
//	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> listarDtOfertas(){
		return ctrlOferta.listarDtOfertas();
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> listarDtOfertasByFilter(String filter){
		return ctrlOferta.listarDtOfertasByFilter(filter);
	}
    @WebMethod
	public DTPostulacion listarDatosPostulacion(String nick, String nombreOferta) {
		return ctrlOferta.listarDatosPostulacion(nick, nombreOferta);
	}
//    @WebMethod
//	public void crearTipoPublicacion(
//			String nombre, 
//			String descripcion, 
//			int exposicion, 
//			int duracion, 
//			float costo, 
//			LocalDate fecha
//	) throws UsuarioRepetidoException{
//    	ctrlCompraTipo.crearTipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
//	}
//    @WebMethod
//	public List<String> listarTiposPublicacion(){
//		return ctrlCompraTipo.listarTiposPublicacion();
//	}
//    @WebMethod
//	public void crearPaquete(String valorTextNombre, String valorTextDescripcion,  int validez, int descuento, LocalDate fecha) throws UsuarioRepetidoException{
//    	ctrlCompraTipo.crearPaquete(valorTextNombre, valorTextDescripcion, validez, descuento, fecha);
//	}
    @WebMethod
	public void agregarTipoAPaquete(String nombrePaquete, String tipoPublicacion, int cantidad) {
    	ctrlCompraTipo.agregarTipoAPaquete(nombrePaquete, tipoPublicacion, cantidad);
	}
//    @WebMethod
//	public List<String> listarNombresPaquetes(){
//		return ctrlCompraTipo.listarNombresPaquetes();
//	}
//    @WebMethod
//	public Map<String, Integer> getTiposYCantidades(String nombrePaquete){
//		return ctrlCompraTipo.getTiposYCantidades(nombrePaquete);
//	}
//    @WebMethod
//	public Map<String, DataTipoPublicacion> getDataTiposPublicacion(){
//		return ctrlCompraTipo.getDataTiposPublicacion();
//	}
    @WebMethod
	public DataTipoPublicacion listarDatosTipoPubliacion(String nombretipo) {
		return ctrlCompraTipo.listarDatosTipoPubliacion(nombretipo);
	}
    @WebMethod
	public DataEmpresa getDTEmpresa(String nick) {
    	return ctrlUsuario.getDTEmpresa(nick);
    }
	public DataPostulante getDTPostulante(String nick) {
		return ctrlUsuario.getDTPostulante(nick);
	}
}