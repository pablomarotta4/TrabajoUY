package logica.controladores;

import logica.entidades.TipoPublicacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IManejadorPaquetes;

import java.util.Date;

import excepciones.UsuarioRepetidoException;

public class ControladorCompraTipo implements IControladorCompraTipo{
	
	private IManejadorPaquetes manejadorPaquetes;
	
	public ControladorCompraTipo() {
		Factory f = Factory.getInstance();
		this.manejadorPaquetes = f.getManejadorPaquetes();
	}
	
	public void crearTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, Date fecha) throws UsuarioRepetidoException {
		
		// ## Si ya existe el tipo con ese nombre THROW EXCEPTION
		if(manejadorPaquetes.getTiposPublicacion().containsKey(nombre)) {
			throw new UsuarioRepetidoException("Usuario ya existe");
		}
		TipoPublicacion tipo = new TipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
		manejadorPaquetes.agregarTipo(tipo);
	}
	
	
}
