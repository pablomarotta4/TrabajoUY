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
					1, 
					null
			);
			
			// Funcion a testear
			ctrlOferta.altaOfertaLaboral(
					"nickempresa", 
					"tipoPublicacion", 
					"nombre", 
					"descripcion", 
					"horario", 
					10, 
					"ciudad", 
					"departamento", 
					LocalDate.of(2000, 2, 2), 
					List.of("keyword1", "keyword2")
			);
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
		assertEquals("", "");
	}

}
