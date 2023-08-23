package logica.interfaces;
import java.util.Date;

public interface IControladorCompraTipo {
	
	public void crearTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, Date fecha);
	
}
