package logica.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.UsuarioRepetidoException;
import logica.datatypes.DataTipoPublicacion;
import logica.entidades.Paquete;
import logica.entidades.TipoPublicacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IManejadorPaquetes;

public class ControladorCompraTipo implements IControladorCompraTipo{
	
	private IManejadorPaquetes manejadorPaquetes;
	
	public ControladorCompraTipo() {
		Factory fact = Factory.getInstance();
		this.manejadorPaquetes = fact.getManejadorPaquetes();
	}
	
	public void crearTipoPublicacion(String nombre, String descripcion, int exposicion, int duracion, float costo, LocalDate fecha) throws UsuarioRepetidoException {
		
		// ## Si ya existe el tipo con ese nombre THROW EXCEPTION
		if (manejadorPaquetes.getTiposPublicacion().containsKey(nombre)) {
			throw new UsuarioRepetidoException("Ya existe un Tipo de Publicacion con el mismo nombre. Intente de nuevo");
		}
		TipoPublicacion tipo = new TipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
		manejadorPaquetes.agregarTipo(tipo);
	}
	
	public List<String> listarTiposPublicacion(){
		List<String> listaTipos = new ArrayList<String>();
		Map<String, TipoPublicacion> tiposPublicacion = this.manejadorPaquetes.getTiposPublicacion();
		
		if (tiposPublicacion.size() > 0) {
			for (String nombre : tiposPublicacion.keySet()) {
				listaTipos.add(nombre);	
			}
		}

		return listaTipos;
	}
	
	 
	public void crearPaquete(String valorTextNombre, String valorTextDescripcion,  int validez, int descuento, LocalDate fecha) throws UsuarioRepetidoException{
		if (manejadorPaquetes.existePaquete(valorTextNombre)) {
			throw new UsuarioRepetidoException("Ya existe un paquete con el nombre ingresado.");
			
		}
		Paquete paq= new Paquete(valorTextNombre, valorTextDescripcion, validez, descuento, fecha); 
		manejadorPaquetes.agregarPaquete(paq);
	}
	

	
	public void agregarTipoAPaquete(String nombrePaquete, String tipoPublicacion, int cantidad) {
		this.manejadorPaquetes.agregarTipoAPaquete(nombrePaquete, tipoPublicacion, cantidad);
	}
	
	public List<String> listarNombresPaquetes(){
		List<String> nombresPaquetes = new ArrayList<String>();
		Map<String, Paquete> paquets = this.manejadorPaquetes.getPaquetes();
		
		if (paquets.size() > 0) {
			for (String nombre : paquets.keySet()) {
				nombresPaquetes.add(nombre);	
			}
		}

		return nombresPaquetes;
	} 

	
	public Map<String, Integer> getTiposYCantidades(String nombrePaquete){
		return manejadorPaquetes.getTiposYCantidades(nombrePaquete);
	}
	
	public Map<String, DataTipoPublicacion> getDataTiposPublicacion(){
		Map<String, TipoPublicacion> tipos = this.manejadorPaquetes.getTiposPublicacion();
		Map<String, DataTipoPublicacion> dataTipos = new HashMap<String, DataTipoPublicacion>();
		for (String key : tipos.keySet()) {
			DataTipoPublicacion nuevoDataTipo = new DataTipoPublicacion(tipos.get(key).getNombre(), tipos.get(key).getDescripcion(),
					tipos.get(key).getExposicion(), tipos.get(key).getDuracion(), tipos.get(key).getCosto(), tipos.get(key).getFecha());
			dataTipos.put(key, nuevoDataTipo);
		}
		return dataTipos;
	}
	
	public DataTipoPublicacion listarDatosTipoPubliacion(String nombretipo) {
		TipoPublicacion tipo = this.manejadorPaquetes.getTipo(nombretipo);
		DataTipoPublicacion dataTipo = new DataTipoPublicacion(tipo.getNombre(), tipo.getDescripcion(),
				tipo.getExposicion(), tipo.getDuracion(), tipo.getCosto(), tipo.getFecha());
		return dataTipo;
	}
	

}
