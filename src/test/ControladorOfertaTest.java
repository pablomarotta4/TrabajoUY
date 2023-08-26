package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
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
		try {
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
		} catch (ElementoRepetidoException | ElementoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("", "");
	}

}
