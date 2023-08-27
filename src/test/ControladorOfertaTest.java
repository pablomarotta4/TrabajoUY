package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

class ControladorOfertaTest {
	
	private static IControladorOferta ctrlOferta; 
	private static IControladorUsuario ctrlUsuario;
	private static IControladorCompraTipo ctrlTipo;
	
	@BeforeAll
	public static void iniciar() {
		Factory f = Factory.getInstance();
		ctrlUsuario = f.getControladorUsuario();
		ctrlOferta = f.getControladorOferta();	
		ctrlTipo = f.getControladorCompraTipo();
	}
	
	@Test
	void altaOfertaOK() {
		String nombreOferta = "nombreoferta";
		try {
			// Datos que necesita la funcion
			ctrlUsuario.crearEmpresa(
					"nickempresa", 
					"nombreempresa", 
					"apellidoempresa", 
					"emailempresa", 
					"descripcionempresa", 
					"linkempresa"
			);
			
			ctrlOferta.altaKeyword("keyword1");
			ctrlOferta.altaKeyword("keyword2");
			
			ctrlTipo.crearTipoPublicacion(
					"nombretipo1", 
					"descripciontipo", 
					1, 
					1, 
					10, 
					LocalDate.of(2000, 1, 1)
			);
			
			// Funcion a testear
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					nombreOferta, 
					"descripcion", 
					"horario", 
					10, 
					"ciudad", 
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword1", "keyword2")
			);

			DTOfertaLaboral ofertaCreada  = ctrlOferta.listarDatosOferta(nombreOferta);
			DTOfertaLaboral ofertaEsperada = new DTOfertaLaboral(
					nombreOferta, 
					"descripcion", 
					"ciudad",
					"departamento",
					"horario", 
					10, 
					LocalDate.of(2000, 2, 2), 
					List.of(new DTPostulacion()),
					List.of("keyword1", "keyword2"),
					"nickempresa",
					"nombretipo1", 
					10
			); 
			boolean equals = ofertaEsperada.equals(ofertaCreada);
			assertTrue(equals);
		} catch (ElementoRepetidoException | ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CamposVaciosExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void altaOfertaEmpresaNoExiste() {
		// Funcion a testear
		try {
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreOferta", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad", 
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword1", "keyword2")
			);
		} catch (ElementoRepetidoException ex) {

		} catch (ElementoInexistenteException ex) {
			
		}
		assertThrows(
				ElementoInexistenteException.class, 
				()->{ctrlOferta.altaOfertaLaboral(
						"nickempresa", 
						"nombretipo1", 
						"nombreOferta", 
						"descripcion", 
						"horario", 
						10, 
						"ciudad", 
						"departamento", 
						LocalDate.of(2000, 2, 2), 
						List.of("keyword1", "keyword2")
					);
				}
		);	

	}
	
	@Test
	void altaKeyword() {
		try {
			ctrlOferta.altaKeyword("keywordprueba1");
			ctrlOferta.altaKeyword("keywordprueba2");
			
			List<String> listaCreada = ctrlOferta.listarKeywords();
			List<String> listaEsperada = List.of("keywordprueba1", "keywordprueba2");
			System.out.println(listaCreada);
			assertEquals(listaCreada, listaEsperada);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void altaPostulacionOk() {
		try {
			ctrlUsuario.crearEmpresa(
					"nickempresa", 
					"nombreempresa", 
					"apellidoempresa",
					"emailempresa", 
					"descripcionempresa", 
					"linkempresa"
			);
			ctrlUsuario.crearPostulante(
					"nickpostulante", 
					"nombrepostulante", 
					"apellidopostulante", 
					"emailpostulante", 
					"nacionalidadpostulante", 
					LocalDate.of(2000, 10, 10)
			);
			ctrlOferta.altaKeyword("keyword1");
			ctrlOferta.altaKeyword("keyword2");
			
			ctrlTipo.crearTipoPublicacion(
					"nombretipo1", 
					"descripciontipo", 
					1, 
					1, 
					10, 
					LocalDate.of(2000, 1, 1)
			);
			
			ctrlOferta.altaOfertaLaboral(null, null, null, null, null, 0, null, null, null, null);
			
			
			ctrlOferta.altaPostulacion(
					null, 
					null, 
					null, 
					null, 
					null
			);
		} catch(Exception ex) {
			
		}
	}
}
