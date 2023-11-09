package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import excepciones.UsuarioRepetidoException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.ws.Endpoint;
import logica.datatypes.DtOfertaLaboral;
import logica.beans.CollectionBean;
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
		this.ctrlUsuario = Factory.getInstance().getControladorUsuario();
		this.ctrlOferta = Factory.getInstance().getControladorOferta();
		this.ctrlCompraTipo = Factory.getInstance().getControladorCompraTipo();

		endpoint = Endpoint.publish("http://localhost:8085/webService", this);
	}
	
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    ////////////////////////////////////////////////////////////////
    // prueba de collections
    // comentario ArrayList<String> me aparece en el WebServer como ArrayList
    
    @WebMethod 
    public void pruebaCollection(ArrayList<String> list) {
    	System.out.println("hola");
    }
    
    ////////////////////////////////////////////////////////////////
    
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
    	} catch (UsuarioRepetidoException | CamposVaciosExcepcion exep) {
    		throw exep;
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
		    		ctrlUsuario.crearEmpresa(nickname, nombre, apellido, email, password, imageUrl, descripcion, link);
		    	} catch (UsuarioRepetidoException | CamposVaciosExcepcion exep) {
		    		throw exep;
		    	}
		    }
    
    @WebMethod
    public void crearTipoPublicacion(String nombre,
    								 String descripcion,
    								 int exposicion,
    								 int duracion,
    								 float costo,
    								 String fecha) throws UsuarioRepetidoException {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaLD = LocalDate.parse(fecha, formatter);
		try {
			ctrlCompraTipo.crearTipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fechaLD);
		} catch (UsuarioRepetidoException exep) {
			throw exep;
		}
    }
    
    @WebMethod
    public void altaKeyword(String nombre) throws ElementoRepetidoException {
    	try {
    		ctrlOferta.altaKeyword(nombre);
    	} catch (ElementoRepetidoException exep) {
    		throw exep;
    	}
    }
    
    
    @WebMethod
    public void altaOfertaLaboral(String empresa,
    							  String tipoPublicacion,
    							  String nombre,
    							  String descripcion,
    							  String horario,
    							  float remuneracion,
    							  String ciudad,
    							  String departamento,
    							  String fechaAlta,
    							  String imageUrl,
    							  CollectionBean keywords) throws ElementoRepetidoException, ElementoInexistenteException {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaLD = LocalDate.parse(fechaAlta, formatter);
		ArrayList<String> listaKeywords = keywords.getListaStrings();
		try {
			ctrlOferta.altaOfertaLaboral(empresa, tipoPublicacion, nombre, descripcion, horario, remuneracion, ciudad, departamento, fechaLD, imageUrl, listaKeywords);
		} catch (ElementoRepetidoException | ElementoInexistenteException exep) {
			throw exep;
		}
		
	}
    
    @WebMethod
    public void altaPostulacion(String nickname,
    							String oferta,
    							String cvReducido,
    							String motivacion,
    							String fecha) throws NoExisteInstancia, ElementoRepetidoException, ElementoInexistenteException {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaLD = LocalDate.parse(fecha, formatter);
		try {
			ctrlOferta.altaPostulacion(nickname, oferta, cvReducido, motivacion, fechaLD);
		} catch (ElementoRepetidoException | NoExisteInstancia exep) {
			throw exep;
		}
		
	}
    
    @WebMethod
    public ArrayList<String> listarNickEmpresas(){

    	return (ArrayList<String>) ctrlUsuario.listarNickEmpresas();
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
	public ArrayList<DtOfertaLaboral> consultarPostulaciones(String nick){
		ArrayList<DtOfertaLaboral> listaOfertas = ctrlUsuario.consultarPostulaciones(nick);
		return listaOfertas;
	}
    @WebMethod
	public ArrayList<DtOfertaLaboral> consultarOfertas(String nick){
		ArrayList<DtOfertaLaboral> listaOfertas = ctrlUsuario.consultarOfertas(nick);
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
	public CollectionBean listarDTUsuarios(){
		CollectionBean collection = new CollectionBean();
		collection.setListaDataUsuarios(ctrlUsuario.listarDTUsuarios());
		return collection;
	}
    @WebMethod
	public Empresa getEmpresa(String nickEmpresa) {
		return ctrlUsuario.getEmpresa(nickEmpresa);
	}

    @WebMethod
	public DtOfertaLaboral obtenerEmpresaDeOferta(String nombreOferta) {
		return ctrlOferta.obtenerEmpresaDeOferta(nombreOferta);
    }

    @WebMethod
	public CollectionBean listarDtOfertas(){
		return ctrlOferta.listarDtOfertas();
	}
    @WebMethod
    public CollectionBean listarDtOfertasConfirmadasNoExpiradas(String nickUsuario) {
    	return ctrlOferta.listarDtOfertasConfirmadasNoExpiradas(nickUsuario);
    }
    @WebMethod
	public CollectionBean listarDtOfertasByFilter(String filter, String nickUsuario){
    	CollectionBean collection = new CollectionBean();
    	collection.setListaDtOfertas(ctrlOferta.listarDtOfertasByFilter(filter, nickUsuario));
		return collection;
	}
    @WebMethod
	public DTPostulacion listarDatosPostulacion(String nick, String nombreOferta) {
		return ctrlOferta.listarDatosPostulacion(nick, nombreOferta);
	}

    @WebMethod
	public void agregarTipoAPaquete(String nombrePaquete, String tipoPublicacion, int cantidad) {
    	ctrlCompraTipo.agregarTipoAPaquete(nombrePaquete, tipoPublicacion, cantidad);
	}

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
	@WebMethod
	public DtOfertaLaboral listarDatosOferta(String nombreOferta) throws ElementoInexistenteException {
		return ctrlOferta.listarDatosOferta(nombreOferta);
	}
	@WebMethod
	public CollectionBean listarTiposPublicacion(){
		CollectionBean collection = new CollectionBean();
		collection.setListaStrings((ArrayList<String>) ctrlCompraTipo.listarTiposPublicacion());
		return collection;
	}
	@WebMethod
	public CollectionBean listarKeywords(){
		CollectionBean collection = new CollectionBean();
		collection.setListaStrings((ArrayList<String>) ctrlOferta.listarKeywords());
		return collection;
	}
	@WebMethod
	public CollectionBean getDataTiposPublicacion(){
		Map<String, DataTipoPublicacion> map = ctrlCompraTipo.getDataTiposPublicacion();
		ArrayList<DataTipoPublicacion> listaTipos = new ArrayList<>();
		
		for(String nombreTipo: map.keySet()) {
			listaTipos.add(map.get(nombreTipo));
		}
		
		CollectionBean collection = new CollectionBean();
		collection.setListaDataTipoPublicacion(listaTipos);
		return collection;
	}
    @WebMethod
    public byte[] getFile(@WebParam(name = "fileName") String name)
                    throws  IOException {
        byte[] byteArray = null;
        try {
                File f = new File("files/" + name);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
    }
}