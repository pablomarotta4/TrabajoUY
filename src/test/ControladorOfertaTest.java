package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import excepciones.UsuarioRepetidoException;
import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

@TestMethodOrder(OrderAnnotation.class)
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
	@Order(1)
	void altaKeyword() {
		System.out.println("altaKeyword");
		try {
			ctrlOferta.altaKeyword("keyword1");
			ctrlOferta.altaKeyword("keyword2");
			List<String> listaCreada = ctrlOferta.listarKeywords();
			List<String> listaEsperada = List.of("keyword1", "keyword2");
			System.out.println(listaCreada);
			assertEquals(listaEsperada, listaCreada);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test()
	@Order(2)
	void altaOfertaOK() {
		System.out.println("altaOfertaOK");
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
	@Order(3)
	void altaOfertaEmpresaNoExiste() {
		System.out.println("altaOfertaEmpresaNoExiste");
		// Funcion a testear
		try {
			ctrlOferta.altaOfertaLaboral(
					"nickempresa2", 
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
						"nickempresa2", 
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
	@Order(4)
	void altaPostulacionOk() {
		System.out.println("altaPostulacionOk");
		try {
			ctrlUsuario.crearPostulante(
					"nickpostulante", 
					"nombrepostulante", 
					"apellidopostulante", 
					"emailpostulante", 
					"nacionalidadpostulante", 
					LocalDate.of(2000, 10, 10)
			);

			ctrlOferta.altaPostulacion(
					"nickpostulante", 
					"nombreoferta",
					"cvUsuario", 
					"motivacion",
					LocalDate.of(1, 1, 1)
			);
			
			DTOfertaLaboral dtOf = ctrlOferta.listarDatosOferta("nombreoferta");
			DTPostulacion postulacionCreada = dtOf.getPostulaciones().get(0);
			DTPostulacion postulacionEsperada = new DTPostulacion(
					"cvUsuario",
					"motivacion",
					LocalDate.of(1, 1, 1),
					"nickpostulante",
					"nombreoferta"
			);
			boolean success = postulacionEsperada.equals(postulacionCreada);
			System.out.println(success);
			System.out.println(postulacionEsperada.toString());
			System.out.println(postulacionCreada.toString());
			assertTrue(success);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	@Order(5)
	void listarOfertasByEmpresaTest() {
		try {
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreoferta2", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad", 
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword1", "keyword2")
				);
			List<String> listaOfertasCreada = ctrlOferta.listarOfertasByEmpresa("nickempresa");
			List<String> listaOfertasEsperada = List.of("nombreoferta", "nombreoferta2");
			assertEquals(listaOfertasEsperada, listaOfertasCreada);
		} catch(Exception e) {
			
		}

	}
	
	@Test
	@Order(6)
	void altaOfertaLaboralNoExisteKeyword() {
		try {
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreOferta3", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword3", "keyword4")
			);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e.getMessage());
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
						List.of("keyword3", "keyword4")
					);
				}
		);	
	}
	
	@Test
	@Order(7)
	void altaOfertaYaExisteOfertaTest() {
		System.out.println("\naltaOfertaYaExisteOfertaTest:");
		try {
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreoferta", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword1", "keyword2")
			);
		} catch (ElementoRepetidoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(
				ElementoRepetidoException.class, 
				()->{ctrlOferta.altaOfertaLaboral(
						"nickempresa", 
						"nombretipo1", 
						"nombreoferta", 
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
	@Order(8)
	void altaOfertaNoExisteTipo() {
		System.out.println("\naltaOfertaNoExisteTipo:");
		try {
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo2", 
					"nombreoferta", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword1", "keyword2")
			);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ElementoInexistenteException e) {
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				ElementoInexistenteException.class, 
				()->{ctrlOferta.altaOfertaLaboral(
						"nickempresa", 
						"nombretipo2", 
						"nombreoferta", 
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
	@Order(9)
	void altaKeywordElementoRepetidoTest() {
		System.out.println("\naltaKeywordElementoRepetidoTest");
		try {
			ctrlOferta.altaKeyword("keyword1");
		} catch (ElementoRepetidoException e) {
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				ElementoRepetidoException.class, 
				()->{ctrlOferta.altaKeyword("keyword1");}
		);	
	}
	
	@Test
	@Order(10)
	void altaPostulacionNoExisteOfertaTest() {
		System.out.println("\naltaPostulacionNoExisteOfertaTest");
		try {
			ctrlOferta.altaPostulacion(
					"nickpostulante", 
					"ofertainexistente",
					"cvUsuario", 
					"motivacion",
					LocalDate.of(1, 1, 1)
			);
		} catch (ElementoRepetidoException e) {
			e.printStackTrace();
		} catch (NoExisteInstancia e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ElementoInexistenteException e) {
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				NoExisteInstancia.class, 
				()->{ctrlOferta.altaPostulacion(
						"nickpostulante", 
						"ofertainexistente",
						"cvUsuario", 
						"motivacion",
						LocalDate.of(1, 1, 1)
				);}
		);	
	}
	
	@Test
	@Order(11)
	void altaPostulacionNoExistePostulanteTest() {
		System.out.println("\naltaPostulacionNoExistePostulanteTest");
		try {
			ctrlOferta.altaPostulacion(
					"postulanteinexistente", 
					"nombreoferta",
					"cvUsuario", 
					"motivacion",
					LocalDate.of(1, 1, 1)
			);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoExisteInstancia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				ElementoInexistenteException.class, 
				()->{ctrlOferta.altaPostulacion(
						"postulanteinexistente", 
						"nombreoferta",
						"cvUsuario", 
						"motivacion",
						LocalDate.of(1, 1, 1)
				);}
		);	
	}
	
	@Test
	@Order(12)
	void altaPostulacionPostulacionRepetidaTest() {
		System.out.println("\naltaPostulacionPostulacionRepetidaTest");
		try {
			ctrlOferta.altaPostulacion(
					"nickpostulante", 
					"nombreoferta",
					"cvUsuario", 
					"motivacion",
					LocalDate.of(1, 1, 1)
			);
		} catch (ElementoRepetidoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (NoExisteInstancia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(
				ElementoRepetidoException.class, 
				()->{ctrlOferta.altaPostulacion(
						"nickpostulante", 
						"nombreoferta",
						"cvUsuario", 
						"motivacion",
						LocalDate.of(1, 1, 1)
				);}
		);	
	}
	
}
