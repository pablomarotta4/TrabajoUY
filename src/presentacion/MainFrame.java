package presentacion;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.interfaces.Factory;
import logica.interfaces.IUsuario;

public class MainFrame {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem newMenuItem;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		newMenuItem = new JMenuItem("hola");
		fileMenu.add(newMenuItem);


		
		Factory f = new Factory();
		IUsuario ius = f.getUsuario();
		JMenuItem item1 = new JMenuItem(ius.prueba());
		fileMenu.add(item1);
		
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
	}

}
