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
	void a() {

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}