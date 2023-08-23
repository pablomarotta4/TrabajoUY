package logica.controladores;

import logica.interfaces.IControladorUsuario;
import logica.interfaces.IManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{
	
	private IManejadorUsuario manejadorUsuario;
	
	public ControladorUsuario() {
		Factory f = Factory.getInstance();
		this.manejadorUsuario = f.getManejadorUsuario();
	}

	public List<String> listarNickEmpresas() {
		List<String> list = new ArrayList<String>();
		
		for(Usuario u : manejadorUsuario.getUsuarios().values()) {
			// Si usuario es instancia de Empresa guardo el nickname en la lista a retornar
			if(u instanceof Empresa) {
				list.add(u.getNickname());
			}
		}
		
		return list;
	}
	
}
