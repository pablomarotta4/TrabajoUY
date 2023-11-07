package logica.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import logica.datatypes.DtOfertaLaboral;
import logica.beans.CollectionBean;
import logica.datatypes.DTPostulacion;

public interface IControladorOferta {

	public void altaOfertaLaboral(
			String empresa,
			String tipoPublicacion,
			String nombre,
			String descripcion,
			String horario,
			float remuneracion,
			String ciudad,
			String departamento,
			LocalDate fechaAlta,
			String imageUrl,
			ArrayList<String> keywords
		) throws ElementoRepetidoException, ElementoInexistenteException;
	
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException;
	public List<String> listarKeywords();
	public List<String> listarOfertasByEmpresa(String nombreEmpresa);
	public List<String> listarOfertasAceptadasByEmpresa(String nombreEmpresa);
	public List<String> listarOfertasIngresadasByEmpresa(String nombreEmpresa);
	public List<String> listarNombreOfertas();
	public DtOfertaLaboral listarDatosOferta(String nombreOferta) throws ElementoInexistenteException;
	public void altaPostulacion(
			String nickname,
			String oferta,
			String cvReducido,
			String motivacion,
			LocalDate fecha
	) throws ElementoRepetidoException, NoExisteInstancia, ElementoInexistenteException;
	public DtOfertaLaboral obtenerEmpresaDeOferta(String nombreOferta);
	public void confirmarOferta(String nombreOferta);
	public void rechazarOferta(String nombreOferta);
	public CollectionBean listarDtOfertas();
	public CollectionBean listarDtOfertasConfirmadasNoExpiradas();
	public ArrayList<DtOfertaLaboral> listarDtOfertasByFilter(String filter);
	public DTPostulacion listarDatosPostulacion(String nick, String nombreOferta);
	public boolean estaPostulado(String nick, String nombreOferta);
	public ArrayList<DtOfertaLaboral> listarOfertasAceptadas();
}
