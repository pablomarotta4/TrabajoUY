package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.UsuarioRepetidoException;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CrearPaqueteDeTiposDePublicacionDeOfertaLaboral extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtValidez;
	private JTextField txtDescuento;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAnio;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPaqueteDeTiposDePublicacionDeOfertaLaboral frame = new CrearPaqueteDeTiposDePublicacionDeOfertaLaboral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public CrearPaqueteDeTiposDePublicacionDeOfertaLaboral(IControladorCompraTipo cct) {
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
        setTitle("Crear Paquete Ofertas");
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        
        
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gridBagLO = new GridBagLayout();
		gridBagLO.columnWidths = new int[]{207, 0, 0};
		gridBagLO.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0};
		gridBagLO.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLO.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLO);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.WEST;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextArea txtDesc = new JTextArea();
		txtDesc.setWrapStyleWord(true);
		txtDesc.setLineWrap(true);
		GridBagConstraints gbc_txtDesc = new GridBagConstraints();
		gbc_txtDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesc.fill = GridBagConstraints.BOTH;
		gbc_txtDesc.gridx = 1;
		gbc_txtDesc.gridy = 2;
		panel.add(txtDesc, gbc_txtDesc);
		
		JLabel lblNewLabel_2 = new JLabel("Periodo de validez (dias):");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtValidez = new JTextField();
		GridBagConstraints gbc_txtValidez = new GridBagConstraints();
		gbc_txtValidez.anchor = GridBagConstraints.WEST;
		gbc_txtValidez.insets = new Insets(0, 0, 5, 5);
		gbc_txtValidez.gridx = 1;
		gbc_txtValidez.gridy = 3;
		panel.add(txtValidez, gbc_txtValidez);
		txtValidez.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descuento (%):");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtDescuento = new JTextField();
		GridBagConstraints gbc_txtDescuento = new GridBagConstraints();
		gbc_txtDescuento.anchor = GridBagConstraints.WEST;
		gbc_txtDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescuento.gridx = 1;
		gbc_txtDescuento.gridy = 4;
		panel.add(txtDescuento, gbc_txtDescuento);
		txtDescuento.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		gbc_panel_2.gridwidth = 6;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelFechaDeAlta = new JLabel("Fecha de alta: ");
		panel_2.add(labelFechaDeAlta);
		
		JLabel labelDia = new JLabel("Dia: ");
		panel_2.add(labelDia);
		
		textDia = new JTextField();
		panel_2.add(textDia);
		textDia.setColumns(5);
		
		JLabel labelMes = new JLabel("Mes: ");
		panel_2.add(labelMes);
		
		textMes = new JTextField();
		panel_2.add(textMes);
		textMes.setColumns(5);
		
		JLabel labelAnio = new JLabel("Anio: ");
		panel_2.add(labelAnio);
		
		textAnio = new JTextField();
		panel_2.add(textAnio);
		textAnio.setColumns(5);
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		panel_sur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_sur.add(btnAceptar);
		
		
		
		btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		JFrame frame = new JFrame("Ejemplo de Popup");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                try {
                	String valorTextNombre = txtNombre.getText();
            		String valorTextDescripcion = txtDesc.getText();
            		
            		String valorPeriodoValidez = txtValidez.getText();
            		int numPeriodoValidez = Integer.parseInt(valorPeriodoValidez);
            		
            		String valorTextDescuento= txtDescuento.getText();
            		int numDescuento = Integer.parseInt(valorTextDescuento);
            		
            		String valorDia = textDia.getText();
            		int numDia = Integer.parseInt(valorDia);
            		
            		String valorMes = textMes.getText();
            		int numMes = Integer.parseInt(valorMes);
            		
            		String valorAnio = textAnio.getText();
            		int numAnio = Integer.parseInt(valorAnio);
            		
            		LocalDate fecha = LocalDate.of(numAnio, numMes, numDia);
            				
            		cct.crearPaquete(valorTextNombre, valorTextDescripcion, numPeriodoValidez, numDescuento, fecha);
            		JOptionPane.showMessageDialog(
    						frame,
    						"La operación se ha realizado con éxito",
    						"Éxito",
    						JOptionPane.INFORMATION_MESSAGE
    						);
    				
    				
    				setVisible(false);
                } catch(UsuarioRepetidoException ex) {
                	JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
    						);
                }
        		
        	}
		
		
		
		
		/*btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frame = new JFrame("Ejemplo de Popup");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		try {
        			String valorTextNombre = txtNombre.getText();
        			String valorTextDescripcion = txtDesc.getText();
        			
        			String valorTextExposicion = txtValidez.getText();
        			int numTextExposicion = Integer.parseInt(valorTextExposicion);
        			
        			String valorTextDuracion = txtDescuento.getText();
        			int numTextDuracion = Integer.parseInt(valorTextDuracion);
        			
        			String valorTextCosto = txtFecha.getText();
        			
        			Date fecha = new Date();
        			
        			try {
        				compTip.crearPaquete(valorTextNombre, valorTextDescripcion, numTextExposicion, numTextDuracion, numTextCosto, fecha);        				
        				JOptionPane.showMessageDialog(
        						frame,
        						"La operación se ha realizado con éxito",
        						"Éxito",
        						JOptionPane.INFORMATION_MESSAGE
        						);
        				
        				
        				setVisible(false);
        			} catch NombreRepetidoException ex) {
        				JOptionPane.showMessageDialog(
                                frame,
                                ex.getMessage(),
                                "Error",
                                JOptionPane.INFORMATION_MESSAGE
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
		
		*/
		JButton btnCancelar = new JButton("Cancelar");
		//panel_sur.add(btnCancelar);
	});
	}
}

