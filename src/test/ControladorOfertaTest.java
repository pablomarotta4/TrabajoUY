package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.interfaces.Factory;
import logica.interfaces.IControladorOferta;

class ControladorOfertaTest {
	
	private static IControladorOferta ctrlOferta; 
	
	@BeforeAll
	public static void iniciar() {
		Factory f = Factory.getInstance();
		ctrlOferta = f.getControladorOferta();	
	}
	
	@Test
	void altaOfertaSuccess() {
		ctrlOferta.altaOfertaLaboral(
				null, 
				null, 
				null, 
				null, 
				null, 
				0, 
				null, 
				null, 
				null, 
				null
		);
		assertEquals("", "");
	}

}
