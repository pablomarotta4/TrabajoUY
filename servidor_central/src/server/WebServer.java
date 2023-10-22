package server;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import jakarta.xml.ws.Endpoint;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
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
    		LocalDate nacimiento) throws UsuarioRepetidoException, CamposVaciosExcepcion {
    	
    	try {
    		ctrlUsuario = Factory.getInstance().getControladorUsuario();
    		ctrlUsuario.crearPostulante(
    				nick, 
    				nombre, 
    				apellido, 
    				email, 
    				pass, 
    				imageUrl, 
    				nacionalidad, 
    				nacimiento
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
			String link) throws UsuarioRepetidoException, CamposVaciosExcepcion{
		
	}
    
    @WebMethod
    public ArrayList<String> listarNickEmpresas(){
    	return new ArrayList<>();
    }
    @WebMethod
	public ArrayList<String> listarNickPostulantes(){
		return null;
	}
    @WebMethod
	public ArrayList<String> listarUsuarios(){
		ArrayList<String> listaUsuarios = null;
		return listaUsuarios;
	}
    @WebMethod
	public DataUsuario consultarDatosUsuario(String nick) {
    	ctrlUsuario = Factory.getInstance().getControladorUsuario();
		return ctrlUsuario.consultarDatosUsuario(nick);
	}
    @WebMethod
	public boolean evaluarCredenciales(String nickname, String password) throws ElementoInexistenteException{
		return false;
	}
    @WebMethod
	public boolean estaPostulado(String nickname, String nombreOferta) {
		return false;
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> consultarPostulaciones(String nick){
		ArrayList<DTOfertaLaboral> listaOfertas = null;
		return listaOfertas;
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> consultarOfertas(String nick){
		ArrayList<DTOfertaLaboral> listaOfertas = null;
		return listaOfertas;
	}
    @WebMethod
	public void modificarUsuario(String nick, String nombre, String apellido, String email, String descripcion, String link, LocalDate fechaNac, String nacionalidad) {
		
	}
    @WebMethod
	public String getFotoUsuario(String nickname) {
		return "";
	}
    @WebMethod
	public ArrayList<DataUsuario> listarDTUsuarios(){
		ArrayList<DataUsuario> listaUsuarios = null;
		return listaUsuarios;
	}
    @WebMethod
	public Empresa getEmpresa(String nickEmpresa) {
		return null;
	}
    @WebMethod
	public void altaOfertaLaboral(
			String empresa,
			String tipoPublicacion,
			String nombre,
			String descripcion,
			String horario,
			float remuneracion,
			String ciudad,
			String departamento,
			LocalDate fechaAlta,
			String imageUrl,
			ArrayList<String> keywords
		) throws ElementoRepetidoException, ElementoInexistenteException{
		
	}
    @WebMethod
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException{
		
	}
    @WebMethod
	public ArrayList<String> listarKeywords(){
		return null;
	}
    @WebMethod
	public ArrayList<String> listarOfertasByEmpresa(String nombreEmpresa){
		return null;
	}
    @WebMethod
	public ArrayList<String> listarOfertasAceptadasByEmpresa(String nombreEmpresa){
		return null;
	}
    @WebMethod
	public ArrayList<String> listarOfertasIngresadasByEmpresa(String nombreEmpresa){
		return null;
	}
    @WebMethod
	public ArrayList<String> listarNombreOfertas(){
		return null;
	}
    @WebMethod
	public DTOfertaLaboral listarDatosOferta(String nombreOferta) throws ElementoInexistenteException{
		return null;
	}
    @WebMethod
	public void altaPostulacion(
			String nickname,
			String oferta,
			String cvReducido,
			String motivacion,
			LocalDate fecha
	) throws ElementoRepetidoException, NoExisteInstancia, ElementoInexistenteException{

	}
    @WebMethod
	public DTOfertaLaboral obtenerEmpresaDeOferta(String nombreOferta) {
		return null;
	}
    @WebMethod
	public void confirmarOferta(String nombreOferta) {
		
	}
    @WebMethod
	public void rechazarOferta(String nombreOferta) {
		
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> listarDtOfertas(){
		return null;
	}
    @WebMethod
	public ArrayList<DTOfertaLaboral> listarDtOfertasByFilter(String filter){
		return null;
	}
    @WebMethod
	public DTPostulacion listarDatosPostulacion(String nick, String nombreOferta) {
		return null;
	}
    @WebMethod
	public void crearTipoPublicacion(
			String nombre, 
			String descripcion, 
			int exposicion, 
			int duracion, 
			float costo, 
			LocalDate fecha
	) throws UsuarioRepetidoException{
		
	}
    @WebMethod
	public ArrayList<String> listarTiposPublicacion(){
		return null;
	}
    @WebMethod
	public void crearPaquete(String valorTextNombre, String valorTextDescripcion,  int validez, int descuento, LocalDate fecha) throws UsuarioRepetidoException{
		
	}
    @WebMethod
	public void agregarTipoAPaquete(String nombrePaquete, String tipoPublicacion, int cantidad) {
		
	}
    @WebMethod
	public ArrayList<String> listarNombresPaquetes(){
		return null;
	}
    @WebMethod
	public HashMap<String, Integer> getTiposYCantidades(String nombrePaquete){
		return null;
	}
    @WebMethod
	public HashMap<String, DataTipoPublicacion> getDataTiposPublicacion(){
		return null;
	}
    @WebMethod
	public DataTipoPublicacion listarDatosTipoPubliacion(String nombretipo) {
		return null;
	}
}