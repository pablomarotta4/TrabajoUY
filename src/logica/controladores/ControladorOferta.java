package logica.controladores;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import logica.datatypes.DTOfertaLaboral;
import logica.entidades.Empresa;
import logica.entidades.Keyword;
import logica.entidades.OfertaLaboral;
import logica.entidades.Postulacion;
import logica.entidades.Postulante;
import logica.interfaces.Factory;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IManejadorKeywords;
import logica.interfaces.IManejadorOferta;
import logica.interfaces.IManejadorPostulaciones;

public class ControladorOferta implements IControladorOferta{
	
	private IManejadorOferta manejadorOferta;
	private IManejadorKeywords manejadorKeys;
	private IManejadorPostulaciones manejadorPostulacion;
	private ControladorUsuario ctrlUsuario;
	
	public ControladorOferta() {
		Factory f = Factory.getInstance();
		this.manejadorOferta = f.getManejadorOferta();
		this.manejadorKeys = f.getManejadorKeywords();
		this.manejadorPostulacion = f.getManejadorPostulaciones();
		this.ctrlUsuario = new ControladorUsuario();
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
			List<String> keywordsSeleccionadas
	) throws ElementoRepetidoException, ElementoInexistenteException {
		
		System.out.println(keywordsSeleccionadas);
		Empresa empresa = this.ctrlUsuario.getEmpresa(nickEmpresa);	
		if(empresa == null) {
			throw new ElementoInexistenteException("No existe una empresa con nickname " + nickEmpresa);
		}

		// Obtengo las instancias de Keyword
		List<Keyword> listaKeywords = new ArrayList<Keyword>();
		for(int i = 0; i <= keywordsSeleccionadas.size() - 1; i++) {
			Keyword key = this.manejadorKeys.getKeyword(keywordsSeleccionadas.get(i));
			if(key != null) {
				listaKeywords.add(key);
			} else {
				throw new ElementoInexistenteException("No existe la keyword " + keywordsSeleccionadas.get(i));
			}
		}
		
		if(this.manejadorOferta.existeOferta(nombre)) {
			throw new ElementoRepetidoException("Ya existe una oferta con ese nombre.");
		}
		
		this.manejadorOferta.agregarOferta( 
				new OfertaLaboral(
						nombre,
						descripcion,
						ciudad,
						departamento,
						horario,
						remuneracion,
						fechaAlta,
						listaKeywords,
						empresa
				)
		);
	}
	
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException {
		if(manejadorKeys.existeKeyword(nombreKeyword)) {
			throw new ElementoRepetidoException("Ya existe una Keyword con el mismo nombre");
		}
		Keyword key = new Keyword(nombreKeyword);
		this.manejadorKeys.agregarKeyword(key);
	}

	public List<String> listarKeywords(){
		List<String> listaKeywords = new ArrayList<String>();
		
		for(Keyword k : manejadorKeys.getKeywords().values()) {
			listaKeywords.add(k.getKeyword());
		}
		
		return listaKeywords;
	}
	
	public List<String> listarOfertasByEmpresa(String nombreEmpresa){
		List<String> listaOfertas = new ArrayList<String>();
		
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		for(OfertaLaboral o : ofertas.values()) {
			if(o.getNickEmpresa().equals(nombreEmpresa)) {
				listaOfertas.add(o.getNombre());
			}
		}
		
		return listaOfertas;
	}
	
	public DTOfertaLaboral listarDatosOferta(String nombreOferta) {
		Map<String, OfertaLaboral> ofertas = this.manejadorOferta.getOfertas();
		System.out.println(ofertas.get(nombreOferta));
		return ofertas.get(nombreOferta).getDataType();
	}
	
	public void altaPostulacion(String nickname, String oferta, String cvReducido, String motivacion, LocalDate fecha) throws ElementoRepetidoException, NoExisteInstancia {
		
		Map<String, OfertaLaboral> lista = manejadorOferta.getOfertas();
		Postulacion pub;
		OfertaLaboral of = lista.get(oferta);
		Postulante postulante = ctrlUsuario.getPostulante(nickname);
		
		if (of.estaPostulado(nickname)) {
			throw new ElementoRepetidoException("Ya se encuentra postulado a esta oferta");
		}
		if (manejadorOferta.existeOferta(oferta)) {
			pub = new Postulacion(cvReducido, motivacion, fecha, postulante, of);
			of.agregarPostulacion(pub);
			postulante.agregarPostulacion(pub);
			manejadorPostulacion.agregarPostulacion(pub);
		} else {
			throw new NoExisteInstancia("No existe una Oferta con ese nombre");
		}
	}
	
}
