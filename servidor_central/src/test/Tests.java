package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.ArrayList;
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
import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataUsuario;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

@TestMethodOrder(OrderAnnotation.class)
class Tests {
	
	private static IControladorOferta ico; 
	private static IControladorUsuario icu;
	private static IControladorCompraTipo ict;
	
	@BeforeAll
	public static void iniciar() {
		Factory fact = Factory.getInstance();
		ico = fact.getControladorOferta();
		icu = fact.getControladorUsuario();	
		ict = fact.getControladorCompraTipo();
	}
	
	
	@Test
	@Order(1)
	void crearTipoPublicacionOK() {
		try {
			int exposicion = 1;
			int duracion = 1;
			float costo = 1;
			ict.crearTipoPublicacion(
					"nombreTipo1", 
					"descripcionTipo1", 
					exposicion, 
					duracion, 
					costo, 
					LocalDate.of(2000, 1, 1)
			);
			List<String> listaTiposEsperada = List.of("nombreTipo1");
			List<String> listaTiposCreada = ict.listarTiposPublicacion();
			assertEquals(listaTiposEsperada, listaTiposCreada);
		} catch (UsuarioRepetidoException e) {
			fail("Failed");
		}
	}
	
	@Test
	@Order(2)
	void crearTipoPublicacionYaExisteTipo() {
		int exposicion = 1;
		int duracion = 1;
		float costo = 1;
		try {
			ict.crearTipoPublicacion(
					"nombreTipo1", 
					"descripcionTipo1", 
					exposicion, 
					duracion, 
					costo, 
					LocalDate.of(2000, 1, 1)
			);
		} catch (UsuarioRepetidoException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		assertThrows(
				UsuarioRepetidoException.class,
				() -> {			
					ict.crearTipoPublicacion(
						"nombreTipo1", 
						"descripcionTipo1", 
						exposicion, 
						duracion, 
						costo, 
						LocalDate.of(2000, 1, 1)
				);
		});
	}
	 
	@Test
	@Order(3)
	void crearPaqueteOK() {
		try {
			ict.crearPaquete(
					"nombrePaquete", 
					"descripcionPaquete", 
					0, 
					0, 
					LocalDate.of(2000, 1, 1)
			);
		} catch (UsuarioRepetidoException e) {
			fail("Failed");
		}
	}
	
	@Test
	@Order(4)
	void listarNickUsuariosVacia() {
		assertTrue(icu.listarUsuarios().size() == 0);
	}
	
	@Test
	@Order(5)
	void listarNickPostulantesVacia() {
		assertTrue(icu.listarNickPostulantes().size() == 0);
	}
	
	@Test
	@Order(6)
	void crearPostulanteValido() {
		try {
			icu.crearPostulante(
					"Juan1", 
					"A", 
					"B", 
					"Juan1Email",
				    "pass123",
				    null,
					"Uruguay", 
					LocalDate.of(2000, 1, 1)
			);
		} catch (Exception e) {
			fail("error");
		}
		DataUsuario usr = icu.consultarDatosUsuario("Juan1");
		assertEquals(usr.getNickname(), "Juan1");
		assertEquals(usr.getNombre(), "A");
		assertEquals(usr.getApellido(), "B");
		assertEquals(usr.getEmail(), "Juan1Email");
	}
	
	@Test
	void crearPostulanteAModificar() {
		try {
			icu.crearPostulante(
					"postulanteModificar", 
					"A", 
					"B", 
					"postulanteModificarEmail",
				    "pass123",
				    null,
					"Uruguay", 
					LocalDate.of(2000, 1, 1)
			);
			
			icu.modificarUsuario(
					"postulanteModificar",
					"nombreModificado", 
					"apellidoModificado", 
					"postulanteModificarEmail", 
					null, 
					null, 
					LocalDate.of(2000, 2, 2), 
					"UruguayModificado");
		} catch (Exception e) {
			fail("error");
		}
		DataUsuario usr = icu.consultarDatosUsuario("postulanteModificar");
		assertNotNull(usr);
		assertEquals(usr.getNombre(), "nombreModificado");	
	}
	
	@Test
	void evaluarCredencialesValidas() {
		try {
			assertTrue(icu.evaluarCredenciales("Juan1", "pass123"));
		} catch (Exception e) {
			fail("error");
		}
	}
	
	@Test
	void evaluarCredencialesInvalidas() {
		try {
			assertFalse(icu.evaluarCredenciales("Juan1", "123"));
		} catch (Exception e) {
			fail("error");
		}
	}
	
	@Test
	void pruebaFotoUsuario() {
		assertNotNull(icu.getFotoUsuario("Juan1"));
	}
	
	@Test
	void listarDTUsuariosExistentes() {
		assertNotNull(icu.listarDTUsuarios());
	}
	
	@Test
	void estaPostuladoOfertaInexistenteUsuarioExistente() {
		assertFalse(icu.estaPostulado("Juan1", "OfertaDeMentira"));
	}
	
	@Test
	void estaPostuladoOfertaInexistenteUsuarioInexistente() {
		assertFalse(icu.estaPostulado("UsuarioQueNoExiste", "OfertaDeMentira"));
	}
	
	@Test
	void getDataTiposPublicacionNoVacios() {
		try {
			assertNotNull(ict.getDataTiposPublicacion());	
		} catch (Exception e) {
			fail("error");
		}
	}
	
	@Test
	void listarNombresDePaquetesNoVacio() {
		try {
			assertNotNull(ict.listarNombresPaquetes());
		} catch (Exception e) {
			fail("error");
		}
		
	}
	
	@Test
	void crearPaqueteExistente() {
		try {
			ict.crearPaquete("PaqueteNuevo", "D", 12, 10, LocalDate.of(2000, 1, 1));
			ict.crearPaquete("PaqueteNuevo", "D", 12, 10, LocalDate.of(2000, 1, 1));
		} catch (Exception e) {
			assertThrows(UsuarioRepetidoException.class, () -> {ict.crearPaquete("PaqueteNuevo", "D", 12, 10, LocalDate.of(2000, 1, 1));});
		}
		
	}
	
	@Test
	void listarDatosTiposPublicacionTipoExistente() {
		try { 
			ict.crearTipoPublicacion("TipoRandom1", "a", 5324, 16, 234, LocalDate.of(2000, 1, 1));
			
		} catch (Exception e) {
			fail("error");
		}
		assertNotNull(ict.listarDatosTipoPubliacion("TipoRandom1"));
	}
	
	@Test
	@Order(7)
	void listarNickEmpresasVacia() {
		assertTrue(icu.listarNickEmpresas().size() == 0);
	}
	
	@Test
	@Order(8)
	void crearEmpresaValidaConLink() {
		try {
			icu.crearEmpresa("Empresa1", "A", "B", "Empresa1E", "pass123", null, "Empresa1D", "Empresa1L");
			DataUsuario usr = icu.consultarDatosUsuario("Empresa1");
			assertEquals(usr.getNickname(), "Empresa1");
			assertEquals(usr.getNombre(), "A");
			assertEquals(usr.getApellido(), "B");
			assertEquals(usr.getEmail(), "Empresa1E");
		} catch(Exception e) {
			fail("error");
		}		
	}
	
	@Test
	@Order(9)
	void crearEmpresaValidaConLinkVacio() {
		try {
			icu.crearEmpresa("Empresa2", "A", "B", "Empresa2E", "pass123", null, "Empresa2D", null);
			DataUsuario usr = icu.consultarDatosUsuario("Empresa2");
			assertEquals(usr.getNickname(), "Empresa2");
			assertEquals(usr.getNombre(), "A");
			assertEquals(usr.getApellido(), "B");
			assertEquals(usr.getEmail(), "Empresa2E");
		} catch(Exception e) {
			fail("error");
		}
//		assertNotNull(cu.getEmpresa("Empresa2"));		
	}
	
	@Test
	@Order(10)
	void listarNickEmpresasNoVacia() {
		assertTrue(icu.listarNickEmpresas().size() != 0);
	}
	
	@Test
	@Order(11)
	void listarNickPostulantesNoVacia() {
		assertTrue(icu.listarNickPostulantes().size() != 0);
	}
	
	@Test
	@Order(12)
	void listarNickUsuariosNoVacia() {
		assertTrue(icu.listarUsuarios().size() != 0);
	}
	
	@Test
	@Order(13)
	void consultarDatosPostulanteExistente() {
		assertNotNull(icu.consultarDatosUsuario("Juan1"));
	}
	
	@Test
	@Order(14)
	void consultarDatosEmpresaExistente() {
		assertNotNull(icu.consultarDatosUsuario("Empresa1"));
	}
	
	@Test
	@Order(15)
	void consultarDatosUsuarioNoExistente() {
		assertNull(icu.consultarDatosUsuario("UsuarioFantasma"));
	}
	
	@Test
	@Order(16)
	void consultarPostulacionesUsuarioExistenteSinPostulaciones() {
		assertTrue(icu.consultarPostulaciones("Juan1").size() == 0);
		
	}
	
	@Test
	@Order(17)
	void consultarPostulacionesUsuarioExistenteConPostulacionesExistentes() {
		try {
			ico.altaKeyword("key1");
			ArrayList<String> keys = (ArrayList<String>) ico.listarKeywords();
			ico.altaOfertaLaboral(
					"Empresa1", 
					"nombreTipo1", 
					"Oferta1", 
					"Descr", 
					"L-V 09:00 - 17:00", 
					1000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(1980, 6, 3), 
					null,
					keys);
			ico.altaPostulacion("Juan1", "Oferta1", "cvR", "motivado", LocalDate.of(2005, 4, 12));
		} catch (Exception e) {
			e.printStackTrace();
			fail("error");
		}
		assertTrue(icu.consultarPostulaciones("Juan1").size() != 0);
	}
	
	@Test
	@Order(18)
	void consultarOfertasExistentesDeEmpresaExistente() {
		assertTrue(icu.consultarOfertas("Empresa1").size() != 0);
	}
	
	@Test
	@Order(19)
	void crearPostulanteSinString(){
		try {
			icu.crearPostulante(null, "a", "a", "pass123", null, null, "a", LocalDate.of(1, 1, 1));
		} catch(CamposVaciosExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(CamposVaciosExcepcion.class, ()->{icu.crearPostulante(null, "a", "a", "pass123", null, null, "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(20)
	void crearPostulanteSinStrings(){
		try {
			icu.crearPostulante(null, null, null, null, null, null , null, LocalDate.of(1, 1, 1));
		} catch(CamposVaciosExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(CamposVaciosExcepcion.class, ()->{icu.crearPostulante(null, "a", "a", null, null,null, "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(21)
	void altaKeyword() {
		System.out.println("altaKeyword");
		try {
			ico.altaKeyword("keyword1");
			ico.altaKeyword("keyword2");
			List<String> listaCreada = ico.listarKeywords();
			List<String> listaEsperada = List.of("key1", "keyword1", "keyword2");
			System.out.println(listaCreada);
			assertEquals(listaEsperada, listaCreada);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test()
//	@Order(22)
//	void altaOfertaOK() {
//		System.out.println("altaOfertaOK");
//		String nombreOferta = "nombreoferta";
//		try {
//			// Datos que necesita la funcion
//			icu.crearEmpresa(
//					"nickempresa", 
//					"nombreempresa", 
//					"apellidoempresa", 
//					"emailempresa", 
//					"pass123", 
//					null,
//					"descripcionempresa", 
//					"linkempresa"
//			);
//			
//			ict.crearTipoPublicacion(
//					"nombretipo1", 
//					"descripciontipo", 
//					1, 
//					1, 
//					10, 
//					LocalDate.of(2000, 1, 1)
//			);
//			
//			// Funcion a testear
//			ico.altaOfertaLaboral(
//					"nickempresa", 
//					"nombretipo1", 
//					nombreOferta, 
//					"descripcion", 
//					"horario", 
//					10, 
//					"ciudad", 
//					"departamento", 
//					LocalDate.of(2000, 2, 2), 
//					null,
//					List.of("keyword1", "keyword2")
//			);
//
//			DtOfertaLaboral ofertaCreada  = ico.listarDatosOferta(nombreOferta);
//			DtOfertaLaboral ofertaEsperada = new DtOfertaLaboral(
//					nombreOferta, 
//					"descripcion", 
//					"ciudad",
//					"departamento",
//					"horario", 
//					10, 
//					LocalDate.of(2000, 2, 2), 
//					null,
//					List.of(new DTPostulacion()),
//					List.of("keyword1", "keyword2"),
//					"nickempresa",
//					"nombretipo1", 
//					10
//			); 
//			boolean equals = ofertaEsperada.equals(ofertaCreada);
//			assertTrue(equals);
//		} catch (ElementoRepetidoException | ElementoInexistenteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UsuarioRepetidoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CamposVaciosExcepcion e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	 
	@Test
	@Order(23)
	void altaOfertaEmpresaNoExiste() {
		System.out.println("altaOfertaEmpresaNoExiste");
		ArrayList<String> keys = new ArrayList<>();
		keys.add("keyword1");
		keys.add("keyword2");
		// Funcion a testear
		try {
			ico.altaOfertaLaboral(
					"nickempresa2", 
					"nombretipo1", 
					"nombreOferta", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					null,
					keys
			);
		} catch (ElementoRepetidoException ex) {

		} catch (ElementoInexistenteException ex) {
			
		}
		assertThrows(
				ElementoInexistenteException.class, 
				()->{ico.altaOfertaLaboral(
						"nickempresa2", 
						"nombretipo1", 
						"nombreOferta", 
						"descripcion", 
						"horario", 
						10, 
						"ciudad", 
						"departamento", 
						LocalDate.of(2000, 2, 2), 
						null,
						keys
					);
				}
		);	

	}
	
	@Test
	@Order(24)
	void altaPostulacionOk() {
		System.out.println("altaPostulacionOk");
		try {
			icu.crearPostulante(
					"nickpostulante", 
					"nombrepostulante", 
					"apellidopostulante", 
					"emailpostulante", 
					"pass123", 
					null,
					"nacionalidadpostulante", 
					LocalDate.of(2000, 10, 10)
			);

			ico.altaPostulacion(
					"nickpostulante", 
					"nombreoferta",
					"cvUsuario", 
					"motivacion",
					LocalDate.of(1, 1, 1)
			);
			
			DtOfertaLaboral dtOf = ico.listarDatosOferta("nombreoferta");
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
	@Order(25)
	void listarOfertasByEmpresaTest() {
		ArrayList<String> keys = new ArrayList<>();
		keys.add("keyword1");
		keys.add("keyword2");
		try {
			ico.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreoferta2", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad", 
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					null,
					keys
				);
			List<String> listaOfertasCreada = ico.listarOfertasByEmpresa("nickempresa");
			List<String> listaOfertasEsperada = List.of("nombreoferta", "nombreoferta2");
			assertEquals(listaOfertasEsperada, listaOfertasCreada);
		} catch(Exception e) {
			
		}

	}
	
	@Test
	@Order(26)
	void altaOfertaLaboralNoExisteKeyword() {
		ArrayList<String> keys = new ArrayList<>();
		keys.add("keyword3");
		keys.add("keyword4");
		try {
			ico.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreOferta3", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					null,
					keys
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
				()->{ico.altaOfertaLaboral(
						"nickempresa", 
						"nombretipo1", 
						"nombreOferta", 
						"descripcion", 
						"horario", 
						10, 
						"ciudad", 
						"departamento", 
						LocalDate.of(2000, 2, 2), 
						null,
						keys
					);
				}
		);	
	}
	
	@Test
	@Order(27)
	void altaOfertaYaExisteOfertaTest() {
		System.out.println("\naltaOfertaYaExisteOfertaTest:");
		ArrayList<String> keys = new ArrayList<>();
		keys.add("keyword1");
		keys.add("keyword2");
		try {
			ico.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo1", 
					"nombreoferta", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					null,
					keys
			);
		} catch (ElementoRepetidoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(
				ElementoRepetidoException.class, 
				()->{ico.altaOfertaLaboral(
						"nickempresa", 
						"nombretipo1", 
						"nombreoferta", 
						"descripcion", 
						"horario", 
						10, 
						"ciudad",
						"departamento", 
						LocalDate.of(2000, 2, 2), 
						null,
						keys
						);
				}
		);	
	}
	
	@Test
	@Order(28)
	void altaOfertaNoExisteTipo() {
		System.out.println("\naltaOfertaNoExisteTipo:");
		ArrayList<String> keys = new ArrayList<>();
		keys.add("keyword1");
		keys.add("keyword2");
		try {
			ico.altaOfertaLaboral(
					"nickempresa", 
					"nombretipo2", 
					"nombreoferta", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad",
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					null,
					keys
			);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ElementoInexistenteException e) {
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				ElementoInexistenteException.class, 
				()->{ico.altaOfertaLaboral(
						"nickempresa", 
						"nombretipo2", 
						"nombreoferta", 
						"descripcion", 
						"horario", 
						10, 
						"ciudad",
						"departamento", 
						LocalDate.of(2000, 2, 2), 
						null,
						keys
					);
				}
		);	
	}
	
	@Test
	@Order(29)
	void altaKeywordElementoRepetidoTest() {
		System.out.println("\naltaKeywordElementoRepetidoTest");
		try {
			ico.altaKeyword("keyword1");
		} catch (ElementoRepetidoException e) {
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				ElementoRepetidoException.class, 
				()->{ico.altaKeyword("keyword1");}
		);	
	}
	
	@Test
	@Order(30)
	void altaPostulacionNoExisteOfertaTest() {
		System.out.println("\naltaPostulacionNoExisteOfertaTest");
		try {
			ico.altaPostulacion(
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
				()->{ico.altaPostulacion(
						"nickpostulante", 
						"ofertainexistente",
						"cvUsuario", 
						"motivacion",
						LocalDate.of(1, 1, 1)
				);}
		);	
	}
	
	@Test
	@Order(31)
	void altaPostulacionNoExistePostulanteTest() {
		System.out.println("\naltaPostulacionNoExistePostulanteTest");
		try {
			ico.altaPostulacion(
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
				()->{ico.altaPostulacion(
						"postulanteinexistente", 
						"nombreoferta",
						"cvUsuario", 
						"motivacion",
						LocalDate.of(1, 1, 1)
				);}
		);	
	}
	
	@Test
	@Order(32)
	void altaPostulacionPostulacionRepetidaTest() {
		System.out.println("\naltaPostulacionPostulacionRepetidaTest");
		try {
			ico.altaPostulacion(
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
				()->{ico.altaPostulacion(
						"nickpostulante", 
						"nombreoferta",
						"cvUsuario", 
						"motivacion",
						LocalDate.of(1, 1, 1)
				);}
		);	
	}

	@Test
	@Order(33)
	void crearPostulanteSinEmail() {
		try {
			icu.crearPostulante("65472341", "a", "a",  null, null, null, "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(CamposVaciosExcepcion.class, () -> { icu.crearPostulante("65472341", "a", "a", null, null, null, "a", LocalDate.of(1, 1, 1));});
	}

	@Test
	@Order(34)
	void crearPostulanteSinNombreNiApellido() {
		try {
			icu.crearPostulante("65472341", null, null, "57232423", null, null, "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(CamposVaciosExcepcion.class, () -> { icu.crearPostulante("65472341", null, null, "57232423", "pass123", null,"a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(35)
	void crearPostulanteSinNacionalidad() {
		try {
			icu.crearPostulante("65472341", "a", "a", "6723234234", null, null,null, LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(CamposVaciosExcepcion.class, () -> { icu.crearPostulante("65472341", "a", "a", "6723234234", "pass123", null, null, LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(36)
	void crearPostulanteConNicknameYEmailExistente() {
		try {
			icu.crearPostulante("Juan1", "a", "a", "Juan1Email","pass123", null, "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(UsuarioRepetidoException.class, () -> { icu.crearPostulante("Juan1", "a", "a", "Juan1Email","pass123", null, "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(37)
	void crearPostulanteConEmailExistente() {
		try {
			icu.crearPostulante("73425245", "a", "a", "Juan1Email", "pass123", null,"a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(UsuarioRepetidoException.class, () -> { icu.crearPostulante("73425245", "a", "a", "Juan1Email", "pass123", null,"a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(37)
	void crearPostulanteConNicknameExistente() {
		try {
			icu.crearPostulante("Juan1", "a", "a", "62643f45", "pass123", null, "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(UsuarioRepetidoException.class, () -> { icu.crearPostulante("Juan1", "a", "a", "62643f45", "pass123", null,"a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	void listarNombreOfertasExistentes() {
		assertNotNull(ico.listarNombreOfertas());
	}
	
	@Test
	void listarDTOfertasExistentes() {
		assertNotNull(ico.listarDtOfertas());
	}
	
	@Test
	void listarDatosPostulacionInexistente() {
		assertNull(ico.listarDatosPostulacion("Juan1", "OfertaFake"));
	}
	
	@Test
	void listarDatosPostulacionExistente() {
		
		try {
			icu.crearEmpresa("empresa1313", "a", "n", "empresa1313Email", "pass123", null, "d", "l");
			ict.crearTipoPublicacion("tipo131356", "d", 34512, 11, 32, LocalDate.of(1, 1, 1));
			System.out.print(icu.getEmpresa("empresa1313").getNickname());
			ico.altaOfertaLaboral("empresa1313", "tipo131356", "oferta1313", "d", "si", 345, "a", "a", LocalDate.of(1, 1, 1), null, new ArrayList<String>());
			ico.altaPostulacion("Juan1", "oferta1313", "cb", "no", LocalDate.of(1, 1, 1));
		
		} catch (Exception e) {
			fail("error");
		}
		
		assertNotNull(ico.listarDatosPostulacion("Juan1", "oferta1313"));
	}
	
	@Test
	void estaPostuladoOfertaExistente() {
		DataPostulante postulante = (DataPostulante) icu.consultarDatosUsuario("Juan1");
		assertTrue(postulante.estaPostulado("oferta1313"));
	}
	
}
