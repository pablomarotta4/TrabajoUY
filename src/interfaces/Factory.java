package interfaces;

import controladores.ControladorUsuario;

public class Factory {
	
	public IUsuario getUsuario() {
		return new ControladorUsuario();
	}
	
	
}
