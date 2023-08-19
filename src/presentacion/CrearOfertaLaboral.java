package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.interfaces.IControladorOferta;

public class CrearOfertaLaboral extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	
	public CrearOfertaLaboral(IControladorOferta cop) {
		ctrlOferta = cop;	
		
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Crear Oferta Laboral");
        setBounds(10, 40, 360, 150);
	}
	
}
