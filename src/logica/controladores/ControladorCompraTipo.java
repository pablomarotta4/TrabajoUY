package logica.controladores;

import logica.entidades.TipoPublicacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IManejadorPaquetes;

import java.util.Date;

public class ControladorCompraTipo implements IControladorCompraTipo{
	
	private IManejadorPaquetes manejadorPaquetes;
	
	public ControladorCompraTipo() {
		Factory f = Factory.getInstance();
		this.manejadorPaquetes = f.getManejadorPaquetes();
	}
	
	public void crearTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, Date fecha) {
		TipoPublicacion tipo = new TipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
		manejadorPaquetes.agregarTipo(tipo);
	}
}
