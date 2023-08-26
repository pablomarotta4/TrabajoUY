package logica.interfaces;
import java.util.Date;
import java.util.List;

import excepciones.UsuarioRepetidoException;

public interface IControladorCompraTipo {
	
	public void crearTipoPublicacion(
			String nombre, 
			String descripcion, 
			int exposicion, 
			int duracion, 
			float costo, 
			Date fecha
	) throws UsuarioRepetidoException;
	
	public List<String> listarTiposPublicacion();
}
