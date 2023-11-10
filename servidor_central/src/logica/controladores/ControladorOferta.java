package logica.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.junit.platform.commons.util.StringUtils;

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import logica.datatypes.DtOfertaLaboral;
import logica.beans.CollectionBean;
import logica.datatypes.DTPostulacion;
import logica.datatypes.EstadoOferta;
import logica.entidades.Empresa;
import logica.entidades.Keyword;
import logica.entidades.OfertaLaboral;
import logica.entidades.Postulacion;
import logica.entidades.Postulante;
import logica.entidades.TipoPublicacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IManejadorKeywords;
import logica.interfaces.IManejadorOferta;
import logica.interfaces.IManejadorPaquetes;
import logica.interfaces.IManejadorPostulaciones;


public class ControladorOferta implements IControladorOferta{
	
	private IManejadorPaquetes manejadorPaquetes;
	private IManejadorOferta manejadorOferta;
	private IManejadorKeywords manejadorKeys;
	private IManejadorPostulaciones manejadorPostulacion;
	private ControladorUsuario ctrlUsuario;
	
	public ControladorOferta() {
		Factory fact = Factory.getInstance();
		this.manejadorOferta = fact.getManejadorOferta();
		this.manejadorKeys = fact.getManejadorKeywords();
		this.manejadorPostulacion = fact.getManejadorPostulaciones();
		this.ctrlUsuario = new ControladorUsuario();
		this.manejadorPaquetes = fact.getManejadorPaquetes();
	}
	
	public void altaOfertaLaboral(
			String nickEmpresa,
			String tipoPublicacion,
			String nombre,
			String descripcion,
			String horario,
			float remuneracion,
			String ciudad,
			String departamento,
			LocalDate fechaAlta,
			byte[] imageBytes,
			ArrayList<String> keywordsSeleccionadas
	) throws ElementoRepetidoException, ElementoInexistenteException {
		
		Empresa empresa = this.ctrlUsuario.getEmpresa(nickEmpresa);
		
		if (empresa == null) {
			throw new ElementoInexistenteException("No existe una empresa con nickname " + nickEmpresa);
		}
		//empresa.agregarOferta(null);
		
		// Obtengo las instancias de Keyword
		List<Keyword> listaKeywords = new ArrayList<Keyword>();
		for (int i = 0; i <= keywordsSeleccionadas.size() - 1; i++) {
			Keyword keyword = this.manejadorKeys.getKeyword(keywordsSeleccionadas.get(i));
			if (keyword != null) {
				listaKeywords.add(keyword);
			} else {
				throw new ElementoInexistenteException("No existe la keyword " + keywordsSeleccionadas.get(i));
			}
		}

		TipoPublicacion tipo = manejadorPaquetes.getTipo(tipoPublicacion);
		
		if (tipo == null) {
			throw new ElementoInexistenteException("No existe el tipo de publicacion " + tipoPublicacion);
		}
		
		if (this.manejadorOferta.existeOferta(nombre)) {
			throw new ElementoRepetidoException("Ya existe una oferta con ese nombre.");
		}


//		try {
//			BufferedImage image = ImageIO.read(new File(imageUrl));
//			if(image == null) {
//				String path = System.getProperty("user.home") + File.separator + 
//						"trabajouy" + File.separator + 
//						"ofertas" + File.separator + 
//						"images" + File.separator;
//				
//				ImageIO.write(image , "jpg", new File(path + File.separator + nombre + ".jpg"));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		String nombreImagen = nombre.replace(" ", "_");
		nombreImagen = nombreImagen.replace("/", "_");
		nombreImagen = nombreImagen.toLowerCase();
		nombreImagen = nombreImagen.replace("á", "a");
		nombreImagen = nombreImagen.replace("é", "e");
		nombreImagen = nombreImagen.replace("í", "i");
		nombreImagen = nombreImagen.replace("ó", "o");
		nombreImagen = nombreImagen.replace("ú", "u");
		nombreImagen += ".jpg";
		
		String path = "files/";
		File targetFile = new File(path + nombreImagen);
		if(!targetFile.exists() && imageBytes != null) {
			InputStream imageStream = new ByteArrayInputStream(imageBytes);
			try {
				Files.copy(imageStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}	
		
		OfertaLaboral nuevaOferta = 				
				new OfertaLaboral(
				nombre,
				descripcion,
				ciudad,
				departamento,
				horario,
				remuneracion,
				fechaAlta,
				nombreImagen,
				listaKeywords,
				empresa,
				tipo
		);
		
		this.manejadorOferta.agregarOferta(nuevaOferta);
		empresa.agregarOferta(nuevaOferta);

	}
	
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException {
		if (manejadorKeys.existeKeyword(nombreKeyword)) {
			throw new ElementoRepetidoException("Ya existe una Keyword con el mismo nombre");
		}
		Keyword keyword = new Keyword(nombreKeyword);
		this.manejadorKeys.agregarKeyword(keyword);
	}

	public List<String> listarKeywords(){
		List<String> listaKeywords = new ArrayList<String>();
		
		for (Keyword keyword : manejadorKeys.getKeywords().values()) {
			listaKeywords.add(keyword.getKeyword());
		}
		
		return listaKeywords;
	}
	
	public List<String> listarOfertasByEmpresa(String nombreEmpresa){
		List<String> listaOfertas = new ArrayList<String>();
		
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		for (OfertaLaboral ofer : ofertas.values()) {
			if (ofer.getNickEmpresa().equals(nombreEmpresa)) {
				listaOfertas.add(ofer.getNombre());
			}
		}
		
		return listaOfertas;
	}
	
	public List<String> listarOfertasAceptadasByEmpresa(String nombreEmpresa){
		List<String> listaOfertas = new ArrayList<String>();
		
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		for (OfertaLaboral ofer : ofertas.values()) {
			if (ofer.getNickEmpresa().equals(nombreEmpresa) && ofer.getEstado().equals(EstadoOferta.CONFIRMADA)) {
				listaOfertas.add(ofer.getNombre());
			}
		}
		
		return listaOfertas;
	}
	
	public List<String> listarOfertasIngresadasByEmpresa(String nombreEmpresa){
		List<String> listaOfertas = new ArrayList<String>();
		
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		for (OfertaLaboral ofer : ofertas.values()) {
			if (ofer.getNickEmpresa().equals(nombreEmpresa) && ofer.getEstado().equals(EstadoOferta.INGRESADA)) {
				listaOfertas.add(ofer.getNombre());
			}
		}
		
		return listaOfertas;
	}
	
	public DtOfertaLaboral listarDatosOferta(String nombreOferta) throws ElementoInexistenteException{
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		if (!ofertas.containsKey(nombreOferta)) {
			throw new ElementoInexistenteException("No existe esa oferta" + nombreOferta);
		}
		DtOfertaLaboral ofer = ofertas.get(nombreOferta).getDataType();
		ofer.setDuracion(ofertas.get(nombreOferta).getDuracion());
		return ofer;
	}
	
	public void altaPostulacion(String nickname, String oferta, String cvReducido, String motivacion, LocalDate fecha) throws NoExisteInstancia, ElementoInexistenteException, ElementoRepetidoException {
		Map<String, OfertaLaboral> lista = manejadorOferta.getOfertas();
		Postulacion publi;
		OfertaLaboral ofer = lista.get(oferta);
		Postulante postulante = ctrlUsuario.getPostulante(nickname);
	
		if (ofer == null) {
			throw new NoExisteInstancia("No existe una Oferta con nombre " + oferta);	
		}
		
		if (postulante == null) {
			throw new ElementoInexistenteException("No existe postulante con nickname " + nickname);
		} 
		if (ofer.estaPostulado(nickname)) {
			throw new ElementoRepetidoException("Ya se encuentra postulado a esta oferta");
		}
		if (manejadorOferta.existeOferta(oferta)) {
			publi = new Postulacion(cvReducido, motivacion, fecha, postulante, ofer);
			ofer.agregarPostulacion(publi);
			postulante.agregarPostulacion(publi);
			manejadorPostulacion.agregarPostulacion(publi);
		}
	}
	
	public DtOfertaLaboral obtenerEmpresaDeOferta(String nombreOferta) {
		
		return this.manejadorOferta.getOfertaDeNombre(nombreOferta).getDataType();
	}
	 
	public void confirmarOferta(String nombreOferta) {
		this.manejadorOferta.getOfertaDeNombre(nombreOferta).setEstadoConfirmada();
	}
	
	public void rechazarOferta(String nombreOferta) {
		this.manejadorOferta.getOfertaDeNombre(nombreOferta).setEstadoRechazada();
	}
	
	public List<String> listarNombreOfertas() {
		List<String> listaOfertas = new ArrayList<String>();
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		for (OfertaLaboral oferta : ofertas.values()) {
			listaOfertas.add(oferta.getNombre());
		}
		return listaOfertas;
	}
	
	// Trae los DtOfertas que no hayan expirado y esten confirmadas
	public CollectionBean listarDtOfertasConfirmadasNoExpiradas(String nickUsuario) {
		ArrayList<DtOfertaLaboral> listaOfertas = new ArrayList<>();
		HashMap<String, OfertaLaboral> ofertasExistentes = this.manejadorOferta.getOfertas();
		for (OfertaLaboral oferta : ofertasExistentes.values()) {
			if(nickUsuario != null && oferta.getNickEmpresa().equals(nickUsuario)) {
				listaOfertas.add(oferta.getDataType());
			} else if(oferta.estaVigente() && oferta.getEstado().equals(EstadoOferta.CONFIRMADA)) {
				listaOfertas.add(oferta.getDataType());							
			}	
		}
		CollectionBean ret = new CollectionBean();
		ret.setListaDtOfertas(listaOfertas);
		return ret;
	}
	
	public CollectionBean listarDtOfertasForEmpresa(String nickEmpresa) {
		CollectionBean ret = new CollectionBean();
		ArrayList<DtOfertaLaboral> listaOfertas = new ArrayList<>();
		HashMap<String, OfertaLaboral> ofertasExistentes = this.manejadorOferta.getOfertas();
		for (OfertaLaboral oferta : ofertasExistentes.values()) {
			if(oferta.getNickEmpresa().equals(nickEmpresa)) {
				listaOfertas.add(oferta.getDataType());
			} else if(oferta.estaVigente() && oferta.getEstado().equals(EstadoOferta.CONFIRMADA)) {
				listaOfertas.add(oferta.getDataType());							
			}	
		}
		ret.setListaDtOfertas(listaOfertas);
		return ret;
	}
	
	public CollectionBean listarDtOfertas(){
		ArrayList<DtOfertaLaboral> listaOfertas = new ArrayList<>();
		HashMap<String, OfertaLaboral> ofertasExistentes = this.manejadorOferta.getOfertas();
		for (OfertaLaboral oferta : ofertasExistentes.values()) {
			listaOfertas.add(oferta.getDataType());
		}
		CollectionBean ret = new CollectionBean();
		ret.setListaDtOfertas(listaOfertas);
		return ret;
	}
	
	public DTPostulacion listarDatosPostulacion(String nick, String nombreOferta) {
		if (manejadorPostulacion.existePostulacion(nick, nombreOferta)) {
			List<Postulacion> postulaciones = manejadorPostulacion.getPostulaciones();
			for (Postulacion post : postulaciones) {
				if (post.getPostulante().getNickname().equals(nick) && post.getOfertaLaboral().getNombre().equals(nombreOferta)) {
					return post.getDatatype();
				}
			}
		}
		return null;
	}
	

	public boolean estaPostulado(String nick, String nombreOferta) {
	    return manejadorPostulacion.existePostulacion(nick, nombreOferta);
	}

	public ArrayList<DtOfertaLaboral> listarDtOfertasByFilter(String filter, String nickUsuario){
		ArrayList<DtOfertaLaboral> listaOfertas = new ArrayList<>();
		HashMap<String, OfertaLaboral> ofertas = manejadorOferta.getOfertas();
		
		if (isKeyword(filter)) {
			for (OfertaLaboral oferta: ofertas.values()) {
				List<Keyword> keywordsOferta = oferta.getKeywords();
				boolean ofertaHasKeyword = false;
				int icont = 0;
				while (icont < keywordsOferta.size() && !ofertaHasKeyword) {
					ofertaHasKeyword = keywordsOferta.get(icont).getKeyword().equals(filter);
					icont++;
				}
				if(nickUsuario != null && oferta.getNickEmpresa().equals(nickUsuario)) {
					listaOfertas.add(oferta.getDataType());
				} else if (ofertaHasKeyword && oferta.estaConfirmada() && oferta.estaVigente()) {
					listaOfertas.add(oferta.getDataType());
				}
			}
		} else if (isNickEmpresa(filter)) {
			for (OfertaLaboral oferta: ofertas.values()) {
				if(nickUsuario != null && oferta.getNickEmpresa().equals(nickUsuario)) {
					listaOfertas.add(oferta.getDataType());
				} else if (oferta.getNickEmpresa().equals(filter) && oferta.estaConfirmada() && oferta.estaVigente()) {
					listaOfertas.add(oferta.getDataType());
				}
			}	
		} else if (isNombreOferta(filter)) {
			for (OfertaLaboral oferta: ofertas.values()) {
				if(nickUsuario != null && oferta.getNickEmpresa().equals(nickUsuario)) {
					listaOfertas.add(oferta.getDataType());
				} else if (oferta.getNombre().equals(filter) && oferta.estaConfirmada() && oferta.estaVigente()) {
					listaOfertas.add(oferta.getDataType());
				}
			}
		}
		return listaOfertas;
	}
	
	public boolean isKeyword(String element) {
		return this.manejadorKeys.getKeyword(element) != null;
	}
	
	public boolean isNickEmpresa(String element) {
		return ctrlUsuario.getEmpresa(element) != null;
	}
	
	public boolean isNombreOferta(String element) {
		return manejadorOferta.getOfertaDeNombre(element) != null;

	}

	public ArrayList<DtOfertaLaboral> listarOfertasAceptadas() {
	    HashMap<String, OfertaLaboral> ofertas = manejadorOferta.getOfertas();
	    ArrayList<DtOfertaLaboral> ofertasConfirmadas = new ArrayList<DtOfertaLaboral>();
	    for(OfertaLaboral offer : ofertas.values()) {
		if(offer.getEstado().equals(EstadoOferta.CONFIRMADA)) {
		    ofertasConfirmadas.add(offer.getDataType());
		}
	    }
	    return ofertasConfirmadas;
	}

}
