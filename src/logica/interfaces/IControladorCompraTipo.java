package logica.interfaces;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import excepciones.UsuarioRepetidoException;
import logica.datatypes.DataTipoPublicacion;


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
	
	

public void crearPaquete(String valorTextNombre, String valorTextDescripcion,  int validez, int descuento, LocalDate fecha) throws UsuarioRepetidoException;

public void agregarTipoAPaquete(String nombrePaquete, String tipoPublicacion, int cantidad);


public List<String> listarNombresPaquetes();

public Map<String, Integer> getTiposYCantidades(String nombrePaquete);

public Map<String, DataTipoPublicacion> getDataTiposPublicacion();

public DataTipoPublicacion listarDatosTipoPubliacion(String nombretipo);

}

