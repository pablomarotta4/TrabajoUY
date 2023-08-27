package logica.controladores;

import logica.entidades.Paquete;
import logica.entidades.TipoPublicacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IManejadorPaquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import excepciones.UsuarioRepetidoException;

public class ControladorCompraTipo implements IControladorCompraTipo{
	
	private IManejadorPaquetes manejadorPaquetes;
	
	public ControladorCompraTipo() {
		Factory f = Factory.getInstance();
		this.manejadorPaquetes = f.getManejadorPaquetes();
	}
	
	public void crearTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, LocalDate fecha) throws UsuarioRepetidoException {
		
		// ## Si ya existe el tipo con ese nombre THROW EXCEPTION
		if(manejadorPaquetes.getTiposPublicacion().containsKey(nombre)) {
			throw new UsuarioRepetidoException("Ya existe un Tipo de Publicacion con el mismo nombre. Intente de nuevo");
		}
		TipoPublicacion tipo = new TipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
		manejadorPaquetes.agregarTipo(tipo);
	}
	
	public List<String> listarTiposPublicacion(){
		List<String> listaTipos = new ArrayList<String>();
		Map<String, TipoPublicacion> tiposPublicacion = this.manejadorPaquetes.getTiposPublicacion();
		
		if(tiposPublicacion.size() > 0) {
			for(String nombre : tiposPublicacion.keySet()) {
				listaTipos.add(nombre);	
			}
		}

		return listaTipos;
	}
	
	 
	public void crearPaquete(String valorTextNombre, String valorTextDescripcion,  int validez, int descuento,LocalDate fecha) throws UsuarioRepetidoException{
		if(manejadorPaquetes.existePaquete(valorTextNombre)) {
			throw new UsuarioRepetidoException("Ya existe un paquete con el nombre ingresado.");
			
		}
		Paquete paq= new Paquete(valorTextNombre, valorTextDescripcion, validez, descuento, fecha); 
		manejadorPaquetes.agregarPaquete(paq);
	}
	
}
