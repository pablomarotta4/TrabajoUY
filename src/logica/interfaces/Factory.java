package logica.interfaces;

import logica.controladores.*;

public class Factory {
	
	public IUsuario getUsuario() {
		return new ControladorUsuario();
	}
	
	
}
