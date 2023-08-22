package logica.controladores;

import java.util.ArrayList;
import java.util.List;

import logica.entidades.Empresa;
import logica.entidades.Usuario;
import logica.interfaces.Factory;
import logica.interfaces.IControladorUsuario;
import logica.interfaces.IManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{
	
	private IManejadorUsuario manejadorUsuario;
	
	public ControladorUsuario() {
		Factory f = Factory.getInstance();
		this.manejadorUsuario = f.getManejadorUsuario();
	}

	public List<Empresa> listarEmpresas() {
		List<Empresa> list = new ArrayList<Empresa>();
		
		for(Usuario u : manejadorUsuario.getUsuarios().values()) {
			// Si usuario es instancia de Empresa, lo casteo a tipo Empresa, y lo meto en la lista que retorno
			if(u instanceof Empresa) {
				Empresa e = (Empresa) u;
				list.add(e);
			}
		}
		
		return list;
	}
	
}
