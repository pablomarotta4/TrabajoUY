package logica.interfaces;

import java.time.LocalDate;
import java.util.List;

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import logica.datatypes.DTOfertaLaboral;
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
			List<String> keywords
		) throws ElementoRepetidoException, ElementoInexistenteException;
	
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException;
	public List<String> listarKeywords();
	public List<String> listarOfertasByEmpresa(String nombreEmpresa);
	public List<String> listarOfertasAceptadasByEmpresa(String nombreEmpresa);
	public List<String> listarOfertasIngresadasByEmpresa(String nombreEmpresa);
	public List<String> listarNombreOfertas();
	public DTOfertaLaboral listarDatosOferta(String nombreOferta) throws ElementoInexistenteException;
	public void altaPostulacion(
			String nickname,
			String oferta,
			String cvReducido,
			String motivacion,
			LocalDate fecha
	) throws ElementoRepetidoException, NoExisteInstancia, ElementoInexistenteException;
	public DTOfertaLaboral obtenerEmpresaDeOferta(String nombreOferta);
	public void confirmarOferta(String nombreOferta);
	public void rechazarOferta(String nombreOferta);
	public List<DTOfertaLaboral> listarDtOfertas();
	public List<DTOfertaLaboral> listarDtOfertasByFilter(String filter);
	public DTPostulacion listarDatosPostulacion(String nick, String nombreOferta);
	public boolean estaPostulado(String nick, String nombreOferta);
	public List<DTOfertaLaboral> listarOfertasAceptadas();
}
