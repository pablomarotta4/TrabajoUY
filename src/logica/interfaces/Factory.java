package logica.interfaces;

import logica.controladores.*;
import logica.manejadores.ManejadorOferta;
import logica.manejadores.ManejadorPaquetes;
import logica.manejadores.ManejadorUsuario;

public class Factory {
	
	private static Factory instance;
	
	private Factory(){}
	
	public static Factory getInstance() {
        if (instance == null) {
        	instance = new Factory();
        }
        return instance;
	}
	
	public IControladorUsuario getControladorUsuario() {
		return new ControladorUsuario();
	}
	
	public IControladorOferta getControladorOferta() {
		return new ControladorOferta();
	}
	
	public IManejadorUsuario getManejadorUsuario() {
		return ManejadorUsuario.getInstance();
	}
	
	public IManejadorOferta getManejadorOferta() {
		return ManejadorOferta.getInstance();
	}
	
	public IManejadorPaquetes getManejadorPaquetes() {
		return ManejadorPaquetes.getInstance();
	}
	
	public IControladorCompraTipo getControladorCompraTipo() {
		return new ControladorCompraTipo();
	}
}
