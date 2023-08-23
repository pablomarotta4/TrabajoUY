package logica.interfaces;
import java.util.Date;

import excepciones.UsuarioRepetidoException;

public interface IControladorCompraTipo {
	
	public void crearTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, Date fecha) throws UsuarioRepetidoException;
	
}
