package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import excepciones.UsuarioRepetidoException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.datatypes.DataUsuario;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;
import logica.interfaces.IManejadorUsuario;
import logica.manejadores.ManejadorUsuario;

@TestMethodOrder(OrderAnnotation.class)
class Tests {
	
	private static IControladorOferta co; 
	private static IControladorUsuario cu;
	private static IControladorCompraTipo ct;
	private static IManejadorUsuario mu;
	
	@BeforeAll
	public static void iniciar() {
		Factory f = Factory.getInstance();
		co = f.getControladorOferta();
		cu = f.getControladorUsuario();	
		ct = f.getControladorCompraTipo();
		mu = f.getManejadorUsuario();
	}
	
	
	@Test
	@Order(1)
	void crearTipoPublicacionOK() {
		try {
			int exposicion = 1;
			int duracion = 1;
			float costo = 1;
			ct.crearTipoPublicacion(
					"nombreTipo1", 
					"descripcionTipo1", 
					exposicion, 
					duracion, 
					costo, 
					LocalDate.of(2000, 1, 1)
			);
			List<String> listaTiposEsperada = List.of("nombreTipo1");
			List<String> listaTiposCreada = ct.listarTiposPublicacion();
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
			ct.crearTipoPublicacion(
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
					ct.crearTipoPublicacion(
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
			ct.crearPaquete(
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
		assertTrue(cu.listarUsuarios().size() == 0);
	}
	
	@Test
	@Order(5)
	void listarNickPostulantesVacia() {
		assertTrue(cu.listarNickPostulantes().size() == 0);
	}
	
	@Test
	@Order(6)
	void crearPostulanteValido() {
		try {
			cu.crearPostulante(
					"Juan1", 
					"A", 
					"B", 
					"Juan1Email", 
					"Uruguay", 
					LocalDate.of(2000, 1, 1)
			);
		} catch(Exception e) {
			fail("error");
		}
		DataUsuario u = cu.consultarDatosUsuario("Juan1");
		assertEquals(u.getNickname(), "Juan1");
		assertEquals(u.getNombre(), "A");
		assertEquals(u.getApellido(), "B");
		assertEquals(u.getEmail(), "Juan1Email");
	}
	
	@Test
	@Order(7)
	void listarNickEmpresasVacia() {
		assertTrue(cu.listarNickEmpresas().size() == 0);
	}
	
	@Test
	@Order(8)
	void crearEmpresaValidaConLink() {
		try {
			cu.crearEmpresa("Empresa1", "A", "B", "Empresa1E", "Empresa1D", "Empresa1L");
			DataUsuario u = cu.consultarDatosUsuario("Empresa1");
			assertEquals(u.getNickname(), "Empresa1");
			assertEquals(u.getNombre(), "A");
			assertEquals(u.getApellido(), "B");
			assertEquals(u.getEmail(), "Empresa1E");
		} catch(Exception e) {
			fail("error");
		}		
	}
	
	@Test
	@Order(9)
	void crearEmpresaValidaConLinkVacio() {
		try {
			cu.crearEmpresa("Empresa2", "A", "B", "Empresa2E", "Empresa2D", "");
			DataUsuario u = cu.consultarDatosUsuario("Empresa2");
			assertEquals(u.getNickname(), "Empresa2");
			assertEquals(u.getNombre(), "A");
			assertEquals(u.getApellido(), "B");
			assertEquals(u.getEmail(), "Empresa2E");
		} catch(Exception e) {
			fail("error");
		}
//		assertNotNull(cu.getEmpresa("Empresa2"));		
	}
	
	@Test
	@Order(10)
	void listarNickEmpresasNoVacia() {
		assertTrue(cu.listarNickEmpresas().size() != 0);
	}
	
	@Test
	@Order(11)
	void listarNickPostulantesNoVacia() {
		assertTrue(cu.listarNickPostulantes().size() != 0);
	}
	
	@Test
	@Order(12)
	void listarNickUsuariosNoVacia() {
		assertTrue(cu.listarUsuarios().size() != 0);
	}
	
	@Test
	@Order(13)
	void consultarDatosPostulanteExistente() {
		assertNotNull(cu.consultarDatosUsuario("Juan1"));
	}
	
	@Test
	@Order(14)
	void consultarDatosEmpresaExistente() {
		assertNotNull(cu.consultarDatosUsuario("Empresa1"));
	}
	
	@Test
	@Order(15)
	void consultarDatosUsuarioNoExistente() {
		assertNull(cu.consultarDatosUsuario("UsuarioFantasma"));
	}
	
	@Test
	@Order(16)
	void consultarPostulacionesUsuarioExistenteSinPostulaciones() {
		assertTrue(cu.consultarPostulaciones("Juan1").size() == 0);
		
	}
	
	@Test
	@Order(17)
	void consultarPostulacionesUsuarioExistenteConPostulacionesExistentes() {
		try {
			co.altaKeyword("key1");
			List<String> keys = co.listarKeywords();
			co.altaOfertaLaboral(
					"Empresa1", 
					"nombreTipo1", 
					"Oferta1", 
					"Descr", 
					"L-V 09:00 - 17:00", 
					1000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(1980, 6, 3), 
					keys);
			co.altaPostulacion("Juan1", "Oferta1", "cvR", "motivado", LocalDate.of(2005, 4, 12));
		} catch (Exception e) {
			e.printStackTrace();
			fail("error");
		}
		assertTrue(cu.consultarPostulaciones("Juan1").size() != 0);
	}
	
	@Test
	@Order(18)
	void consultarOfertasExistentesDeEmpresaExistente() {
		assertTrue(cu.consultarOfertas("Empresa1").size() != 0);
	}
	
	@Test
	@Order(19)
	void crearPostulanteSinString(){
		try {
			cu.crearPostulante("", "a", "a", "a", "a", LocalDate.of(1, 1, 1));
		} catch(CamposVaciosExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(CamposVaciosExcepcion.class, ()->{cu.crearPostulante("", "a", "a", "a", "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(20)
	void crearPostulanteSinStrings(){
		try {
			cu.crearPostulante("", "", "", "", "", LocalDate.of(1, 1, 1));
		} catch(CamposVaciosExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(CamposVaciosExcepcion.class, ()->{cu.crearPostulante("", "a", "a", "a", "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(21)
	void altaKeyword() {
		System.out.println("altaKeyword");
		try {
			co.altaKeyword("keyword1");
			co.altaKeyword("keyword2");
			List<String> listaCreada = co.listarKeywords();
			List<String> listaEsperada = List.of("key1", "keyword1", "keyword2");
			System.out.println(listaCreada);
			assertEquals(listaEsperada, listaCreada);
		} catch (ElementoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test()
	@Order(22)
	void altaOfertaOK() {
		System.out.println("altaOfertaOK");
		String nombreOferta = "nombreoferta";
		try {
			// Datos que necesita la funcion
			cu.crearEmpresa(
					"nickempresa", 
					"nombreempresa", 
					"apellidoempresa", 
					"emailempresa", 
					"descripcionempresa", 
					"linkempresa"
			);
			
			ct.crearTipoPublicacion(
					"nombretipo1", 
					"descripciontipo", 
					1, 
					1, 
					10, 
					LocalDate.of(2000, 1, 1)
			);
			
			// Funcion a testear
			co.altaOfertaLaboral(
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

			DTOfertaLaboral ofertaCreada  = co.listarDatosOferta(nombreOferta);
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
	@Order(23)
	void altaOfertaEmpresaNoExiste() {
		System.out.println("altaOfertaEmpresaNoExiste");
		// Funcion a testear
		try {
			co.altaOfertaLaboral(
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
				()->{co.altaOfertaLaboral(
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
	@Order(24)
	void altaPostulacionOk() {
		System.out.println("altaPostulacionOk");
		try {
			cu.crearPostulante(
					"nickpostulante", 
					"nombrepostulante", 
					"apellidopostulante", 
					"emailpostulante", 
					"nacionalidadpostulante", 
					LocalDate.of(2000, 10, 10)
			);

			co.altaPostulacion(
					"nickpostulante", 
					"nombreoferta",
					"cvUsuario", 
					"motivacion",
					LocalDate.of(1, 1, 1)
			);
			
			DTOfertaLaboral dtOf = co.listarDatosOferta("nombreoferta");
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
		try {
			co.altaOfertaLaboral(
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
			List<String> listaOfertasCreada = co.listarOfertasByEmpresa("nickempresa");
			List<String> listaOfertasEsperada = List.of("nombreoferta", "nombreoferta2");
			assertEquals(listaOfertasEsperada, listaOfertasCreada);
		} catch(Exception e) {
			
		}

	}
	
	@Test
	@Order(26)
	void altaOfertaLaboralNoExisteKeyword() {
		try {
			co.altaOfertaLaboral(
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
				()->{co.altaOfertaLaboral(
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
	@Order(27)
	void altaOfertaYaExisteOfertaTest() {
		System.out.println("\naltaOfertaYaExisteOfertaTest:");
		try {
			co.altaOfertaLaboral(
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
				()->{co.altaOfertaLaboral(
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
	@Order(28)
	void altaOfertaNoExisteTipo() {
		System.out.println("\naltaOfertaNoExisteTipo:");
		try {
			co.altaOfertaLaboral(
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
				()->{co.altaOfertaLaboral(
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
	@Order(29)
	void altaKeywordElementoRepetidoTest() {
		System.out.println("\naltaKeywordElementoRepetidoTest");
		try {
			co.altaKeyword("keyword1");
		} catch (ElementoRepetidoException e) {
			System.out.println("Error: " + e.getMessage());
		}
		assertThrows(
				ElementoRepetidoException.class, 
				()->{co.altaKeyword("keyword1");}
		);	
	}
	
	@Test
	@Order(30)
	void altaPostulacionNoExisteOfertaTest() {
		System.out.println("\naltaPostulacionNoExisteOfertaTest");
		try {
			co.altaPostulacion(
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
				()->{co.altaPostulacion(
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
			co.altaPostulacion(
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
				()->{co.altaPostulacion(
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
			co.altaPostulacion(
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
				()->{co.altaPostulacion(
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
			cu.crearPostulante("65472341", "a", "a", "", "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(CamposVaciosExcepcion.class, () -> { cu.crearPostulante("65472341", "a", "a", "", "a", LocalDate.of(1, 1, 1));});
	}

	@Test
	@Order(34)
	void crearPostulanteSinNombreNiApellido() {
		try {
			cu.crearPostulante("65472341", "", "", "57232423", "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(CamposVaciosExcepcion.class, () -> { cu.crearPostulante("65472341", "", "", "57232423", "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(35)
	void crearPostulanteSinNacionalidad() {
		try {
			cu.crearPostulante("65472341", "a", "a", "6723234234", "", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(CamposVaciosExcepcion.class, () -> { cu.crearPostulante("65472341", "a", "a", "6723234234", "", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(36)
	void crearPostulanteConNicknameYEmailExistente() {
		try {
			cu.crearPostulante("Juan1", "a", "a", "Juan1Email", "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(UsuarioRepetidoException.class, () -> { cu.crearPostulante("Juan1", "a", "a", "Juan1Email", "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(37)
	void crearPostulanteConEmailExistente() {
		try {
			cu.crearPostulante("73425245", "a", "a", "Juan1Email", "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(UsuarioRepetidoException.class, () -> { cu.crearPostulante("73425245", "a", "a", "Juan1Email", "a", LocalDate.of(1, 1, 1));});
	}
	
	@Test
	@Order(37)
	void crearPostulanteConNicknameExistente() {
		try {
			cu.crearPostulante("Juan1", "a", "a", "62643f45", "a", LocalDate.of(1, 1, 1));
		} catch(Exception e) {
			
		}
		assertThrows(UsuarioRepetidoException.class, () -> { cu.crearPostulante("Juan1", "a", "a", "62643f45", "a", LocalDate.of(1, 1, 1));});
	}
}
