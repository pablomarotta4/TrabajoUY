package test;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

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

@TestMethodOrder(OrderAnnotation.class)
class ControladorUsuarioTest {
	
	private static IControladorOferta co; 
	private static IControladorUsuario cu;
	private static IControladorCompraTipo ct;
	
	@BeforeAll
	public static void iniciar() {
		Factory f = Factory.getInstance();
		cu = f.getControladorUsuario();
		co = f.getControladorOferta();	
		ct = f.getControladorCompraTipo();
	}
	
	@Test
	@Order(5)
	void listarNickUsuariosVacia() {
		assertTrue(cu.listarUsuarios().size() == 0);
	}
	
	@Test
	@Order(10)
	void listarNickPostulantesVacia() {
		assertTrue(cu.listarNickPostulantes().size() == 0);
	}
	
	@Test
	@Order(15)
	void crearPostulanteValido() {
		
		try {
			cu.crearPostulante("Juan1", "A", "B", "Juan1Email", "Uruguay", LocalDate.of(2000, 1, 1));
			
		} catch(Exception e) {
			fail("error");
		}
		assertNotNull(cu.getPostulante("Juan1"));	
		
	}
	
	@Test
	@Order(20)
	void listarNickEmpresasVacia() {
		assertTrue(cu.listarNickEmpresas().size() == 0);
	}
	
	@Test
	@Order(25)
	void crearEmpresaValidaConLink() {
		
		try {
			cu.crearEmpresa("Empresa1", "A", "B", "Empresa1E", "Empresa1D", "Empresa1L");
			
		} catch(Exception e) {
			fail("error");
		}
		assertNotNull(cu.getEmpresa("Empresa1"));	
		
	}
	
	@Test
	@Order(30)
	void crearEmpresaValidaConLinkVacio() {
		
		try {
			cu.crearEmpresa("Empresa2", "A", "B", "Empresa2E", "Empresa2D", "");
			
		} catch(Exception e) {
			fail("error");
		}
		assertNotNull(cu.getEmpresa("Empresa2"));	
		
	}
	
	@Test
	@Order(35)
	void listarNickEmpresasNoVacia() {
		assertTrue(cu.listarNickEmpresas().size() != 0);
	}
	
	
	@Test
	@Order(40)
	void listarNickPostulantesNoVacia() {
		assertTrue(cu.listarNickPostulantes().size() != 0);
	}
	
	@Test
	@Order(45)
	void listarNickUsuariosNoVacia() {
		assertTrue(cu.listarUsuarios().size() != 0);
	}
	
	@Test
	@Order(50)
	void consultarDatosPostulanteExistente() {
		assertNotNull(cu.consultarDatosUsuario("Juan1"));
	}
	
	@Test
	@Order(55)
	void consultarDatosEmpresaExistente() {
		assertNotNull(cu.consultarDatosUsuario("Empresa1"));
	}
	
	@Test
	@Order(55)
	void consultarDatosUsuarioNoExistente() {
		assertNull(cu.consultarDatosUsuario("UsuarioFantasma"));
	}
	
	@Test
	@Order(60)
	void consultarPostulacionesUsuarioExistenteSinPostulaciones() {
		assertTrue(cu.consultarPostulaciones("Juan1").size() == 0);
		
	}
	
/*	@Test
	@Order(65)
	void consultarPostulacionesUsuarioExistenteCon1Postulacion() {
		
		assertTrue(cu.consultarPostulaciones("Juan1").size() == 0);
		
	} */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	@Order(200)
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
	@Order(205)
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
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}