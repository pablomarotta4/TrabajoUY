package presentacion;

import javax.swing.JInternalFrame;

import logica.interfaces.IControladorUsuario;

public class ConsultarUsuario  extends JInternalFrame{
	
	private IControladorUsuario icu;
	
	public ConsultarUsuario(IControladorUsuario cu) {
		icu = cu;	
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Crear Usuario");
        setBounds(10, 40, 360, 150);
	}
}
