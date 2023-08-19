package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.interfaces.Factory;
import logica.interfaces.IControladorUsuario;
import logica.interfaces.IControladorOferta;

public class MainFrame {

	private JFrame frame;
	private IControladorOferta ico;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
		
		// Guardar el controlador como atributo
		Factory f = Factory.getInstance();
		ico = f.getControladorOferta();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuRegistros = new JMenu("Registros");
		JMenu menuConsultas = new JMenu("Consultas");
		frame.setJMenuBar(menuBar);
		menuBar.add(menuRegistros);
		menuBar.add(menuConsultas);
		
		JMenuItem menuCrearOferta = new JMenuItem("Crear Oferta Laboral");
		menuCrearOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearOfertaLaboral crearOfertaInternalFrame = new CrearOfertaLaboral(ico);
				frame.getContentPane().add(crearOfertaInternalFrame);
				crearOfertaInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuAltaUsuario = new JMenuItem("Crear Usuario");
		JMenuItem menuConsultarOferta = new JMenuItem("Consultar Oferta Laboral");
		JMenuItem menuCrearUsuario = new JMenuItem("Consultar Usuario");
		menuRegistros.add(menuCrearOferta);
		menuRegistros.add(menuAltaUsuario);
		menuConsultas.add(menuConsultarOferta);
		menuConsultas.add(menuCrearUsuario);
		
		
		
	}

}
