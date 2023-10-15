package excepciones;

public class CamposVaciosExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public CamposVaciosExcepcion(String message) {
        super(message);
    }
}