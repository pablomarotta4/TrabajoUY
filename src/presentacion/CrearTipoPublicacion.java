package presentacion;

import logica.interfaces.IControladorOferta;
import excepciones.UsuarioRepetidoException;
import logica.interfaces.IControladorCompraTipo;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class CrearTipoPublicacion extends JInternalFrame {
	
	private IControladorCompraTipo ctrlCompraTipo;
	private JTextField textNombre;
	private JTextField textExposicion;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JTextField textFecha;
	private JTextArea textDescripcion;
	

	public CrearTipoPublicacion(IControladorCompraTipo compTip) {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Crear Tipo de Publicacion");
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setBounds(10, 40, 500, 354);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 122, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.anchor = GridBagConstraints.WEST;
		gbc_textNombre.gridx = 3;
		gbc_textNombre.gridy = 1;
		panel_1.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textDescripcion);
		
		JLabel lblNewLabel_2 = new JLabel("Exposicion");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textExposicion = new JTextField();
		GridBagConstraints gbc_textExposicion = new GridBagConstraints();
		gbc_textExposicion.anchor = GridBagConstraints.WEST;
		gbc_textExposicion.insets = new Insets(0, 0, 5, 0);
		gbc_textExposicion.gridx = 3;
		gbc_textExposicion.gridy = 3;
		panel_1.add(textExposicion, gbc_textExposicion);
		textExposicion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Duracion (dias)");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textDuracion = new JTextField();
		GridBagConstraints gbc_textDuracion = new GridBagConstraints();
		gbc_textDuracion.anchor = GridBagConstraints.WEST;
		gbc_textDuracion.insets = new Insets(0, 0, 5, 0);
		gbc_textDuracion.gridx = 3;
		gbc_textDuracion.gridy = 4;
		panel_1.add(textDuracion, gbc_textDuracion);
		textDuracion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Costo");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textCosto = new JTextField();
		GridBagConstraints gbc_textCosto = new GridBagConstraints();
		gbc_textCosto.anchor = GridBagConstraints.WEST;
		gbc_textCosto.insets = new Insets(0, 0, 5, 0);
		gbc_textCosto.gridx = 3;
		gbc_textCosto.gridy = 5;
		panel_1.add(textCosto, gbc_textCosto);
		textCosto.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Alta");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textFecha = new JTextField();
		GridBagConstraints gbc_textFecha = new GridBagConstraints();
		gbc_textFecha.anchor = GridBagConstraints.WEST;
		gbc_textFecha.gridx = 3;
		gbc_textFecha.gridy = 6;
		panel_1.add(textFecha, gbc_textFecha);
		textFecha.setColumns(10);
		
		
		JButton botonAceptar = new JButton("Aceptar");
		
		// ### Agrego la del boton Aceptar
		botonAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frame = new JFrame("Ejemplo de Popup");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		try {
        			String valorTextNombre = textNombre.getText();
        			String valorTextDescripcion = textDescripcion.getText();
        			
        			String valorTextExposicion = textExposicion.getText();
        			int numTextExposicion = Integer.parseInt(valorTextExposicion);
        			
        			String valorTextDuracion = textDuracion.getText();
        			int numTextDuracion = Integer.parseInt(valorTextDuracion);
        			
        			String valorTextCosto = textCosto.getText();
        			int numTextCosto = Integer.parseInt(valorTextCosto);

        			
        			
        			Date fecha = new Date();
        			
        			try {
        				compTip.crearTipoPublicacion(valorTextNombre, valorTextDescripcion, numTextExposicion, numTextDuracion, numTextCosto, fecha);        				
        				JOptionPane.showMessageDialog(
        						frame,
        						"La operación se ha realizado con éxito",
        						"Éxito",
        						JOptionPane.INFORMATION_MESSAGE
        						);
        				
        				
        				setVisible(false);
        			} catch (UsuarioRepetidoException ex) {
        				JOptionPane.showMessageDialog(
                                frame,
                                ex.getMessage(),
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                            );
        			}
        			
        			

                    
                    
                    
        		} catch (NumberFormatException ex) {
        			JOptionPane.showMessageDialog(
                            frame,
                            "No se ingreso un numero valido. Intente de nuevo",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                        );
        		}
        		
        		
        	}
        });
		botonAceptar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(botonAceptar);
		
		// ## BOTON CANCELAR
		JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
		panel.add(botonCancelar);

	}
}
