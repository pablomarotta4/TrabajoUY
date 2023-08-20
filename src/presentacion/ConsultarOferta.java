package presentacion;

import javax.swing.JInternalFrame;

import logica.interfaces.IControladorOferta;

public class ConsultarOferta extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	
	public ConsultarOferta(IControladorOferta cop) {
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
