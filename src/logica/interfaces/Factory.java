package logica.interfaces;

import logica.controladores.*;

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
}
