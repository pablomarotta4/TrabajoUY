package logica.interfaces;

import java.time.LocalDate;
import java.util.List;

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import logica.datatypes.DTOfertaLaboral;

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
			List<String> keywords
		) throws ElementoRepetidoException, ElementoInexistenteException;
	
	public void altaKeyword(String nombreKeyword) throws ElementoRepetidoException;
	public List<String> listarKeywords();
	public List<String> listarOfertasByEmpresa(String nombreEmpresa);
	public DTOfertaLaboral listarDatosOferta(String nombreOferta);
	public void altaPostulacion(
			String nickname,
			String oferta,
			String cvReducido,
			String motivacion,
			LocalDate fecha
	) throws ElementoRepetidoException, NoExisteInstancia;
}
