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
	}

}
