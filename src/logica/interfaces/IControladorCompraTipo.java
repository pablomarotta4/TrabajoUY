package logica.interfaces;
import java.time.LocalDate;
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
			LocalDate fecha
	) throws UsuarioRepetidoException;
	
	public List<String> listarTiposPublicacion();
	public void crearPaquete(String valorTextNombre, String valorTextDescripcion,  int validez, int descuento,LocalDate fecha) 
			throws UsuarioRepetidoException;
}

