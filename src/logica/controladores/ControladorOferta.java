package logica.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.ElementoRepetidoException;
import logica.entidades.Empresa;
import logica.entidades.Keyword;
import logica.entidades.OfertaLaboral;
import logica.interfaces.Factory;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IManejadorKeywords;
import logica.interfaces.IManejadorOferta;

public class ControladorOferta implements IControladorOferta{
	
	private IManejadorOferta manejadorOferta;
	private IManejadorKeywords manejadorKeys;
	private ControladorUsuario ctrlUsuario;
	
	public ControladorOferta() {
		Factory f = Factory.getInstance();
		this.manejadorOferta = f.getManejadorOferta();
		this.manejadorKeys = f.getManejadorKeywords();
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
			Date fechaAlta,
			List<String> keywords
	) {
		Empresa empresa = this.ctrlUsuario.getEmpresa(nickEmpresa);
		this.manejadorOferta.agregarOferta( 
				new OfertaLaboral(
						nombre,
						descripcion,
						ciudad,
						departamento,
						horario,
						remuneracion,
						fechaAlta,
						keywords,
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
}
