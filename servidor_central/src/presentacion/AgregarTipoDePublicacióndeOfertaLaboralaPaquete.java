package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.UsuarioRepetidoException;

import javax.swing.JInternalFrame;

import logica.interfaces.IControladorCompraTipo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;


import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;




public class AgregarTipoDePublicacióndeOfertaLaboralaPaquete extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarTipoDePublicacióndeOfertaLaboralaPaquete frame = new AgregarTipoDePublicacióndeOfertaLaboralaPaquete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AgregarTipoDePublicacióndeOfertaLaboralaPaquete(IControladorCompraTipo ict) {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
        setTitle("Agregar Tipo a Paquete");
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
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 282, 0};
		gbl_panel_2.rowHeights = new int[]{0, 52, 15, 4, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel labelPaquetes = new JLabel("Aniadir en paquete:");
		GridBagConstraints gbc_labelPaquetes = new GridBagConstraints();
		gbc_labelPaquetes.anchor = GridBagConstraints.EAST;
		gbc_labelPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_labelPaquetes.gridx = 0;
		gbc_labelPaquetes.gridy = 1;
		panel_2.add(labelPaquetes, gbc_labelPaquetes);
		
		JComboBox cmbPaquetes = new JComboBox();
		GridBagConstraints gbc_cmbPaquetes = new GridBagConstraints();
		gbc_cmbPaquetes.insets = new Insets(0, 0, 5, 0);
		gbc_cmbPaquetes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPaquetes.gridx = 2;
		gbc_cmbPaquetes.gridy = 1;
		panel_2.add(cmbPaquetes, gbc_cmbPaquetes);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de pubicacion a agregar:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox cmbTipos = new JComboBox();
		GridBagConstraints gbc_cmbTipos = new GridBagConstraints();
		gbc_cmbTipos.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipos.anchor = GridBagConstraints.NORTH;
		gbc_cmbTipos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipos.gridx = 2;
		gbc_cmbTipos.gridy = 2;
		panel_2.add(cmbTipos, gbc_cmbTipos);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtCantidad = new JTextField();
		GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
		gbc_txtCantidad.anchor = GridBagConstraints.NORTH;
		gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidad.gridx = 2;
		gbc_txtCantidad.gridy = 3;
		panel_2.add(txtCantidad, gbc_txtCantidad);
		txtCantidad.setColumns(10);
		
		
		List<String> listaPaquetes = ict.listarNombresPaquetes();

		cmbPaquetes.removeAllItems();
       
		/* for (int i = 0; i < listaPaquetes.size(); i++) {
	            System.out.println(listaPaquetes.get(i));
	        }*/
		
        for (String paq : listaPaquetes) {
        	cmbPaquetes.addItem(paq);
        }

       
        List<String> listaTipos = ict.listarTiposPublicacion();

        cmbTipos.removeAllItems();
		  for (String tip : listaTipos) {
			  cmbTipos.addItem(tip);
	        }
		  
		  
		  
		  
		 
		  
		  
		  
		  
		  
		  
		  
		  

        
		
		btnAceptar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		JFrame frame = new JFrame("Ejemplo de Popup");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		
                try {
	    			String valorPaquete = (String) cmbPaquetes.getSelectedItem();
	    			String valorTipo = (String) cmbTipos.getSelectedItem();
	    		
	    			String valorCantTipo = txtCantidad.getText();
	    			int cantTipo = Integer.parseInt(valorCantTipo);
		    		
    			
		    	boolean hayCampoVacio= valorPaquete.isEmpty()|| valorTipo.isEmpty()	||valorCantTipo.isEmpty();
		    		
		    	if(cantTipo<0) {
		    		throw new ElementoInexistenteException("La cantidad de paquetes tiene que ser positiva");
		    	}
    			if(hayCampoVacio) {
    				throw new CamposVaciosExcepcion("Ingrese todos los campos");
    			}
    			
    			
    			
    			ict.agregarTipoAPaquete(valorPaquete,valorTipo,cantTipo);       
	    		JOptionPane.showMessageDialog(
						frame,
						"La operación se ha realizado con éxito",
						"Éxito",
						JOptionPane.INFORMATION_MESSAGE
						);
    			
    				setVisible(false);
    				
                }catch(ElementoInexistenteException ex) {
      				JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
					);

                }catch(CamposVaciosExcepcion ex) {
                	JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
                	
                	);
                }
                
                
                
                
                
                
    				//excepciones de los tipos
	    		/*}catch(UsuarioRepetidoException ex) {
                	JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
    						);
                }*/
        		
        		
	    	
	    		
	    	
	    	}
		});
		
		
	//////////////////////////////////////////////////////////////////////////////////////////	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*btnAceptar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String valorPaquete = cmbPaquetes.getText();
    			String valorTipo = cmbTipos.getText();
    		
    			String valorCantTipo = txtValidez.getText();
    			int cantTipo = Integer.parseInt(valorCantTipo);
	    		compTip.crearPaquete(valorPaquete,valorTipo,cantTipo);        
	    	}
		*/
		/*btnAceptar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JFrame frame = new JFrame("Ejemplo de Popup");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		try {
    			String valorPaquete = cmbPaquetes.getText();
    			String valorTipo = cmbTipos.getText();
    		
    			String valorCantTipo = txtValidez.getText();
    			int cantTipo = Integer.parseInt(valorCantTipo);
    			
    	
    			
    			try {
    				compTip.crearPaquete(valorPaquete,valorTipo,cantTipo);        				
    				JOptionPane.showMessageDialog(
    						frame,
    						"La operación se ha realizado con éxito",
    						"Éxito",
    						JOptionPane.INFORMATION_MESSAGE
    						);
    				
    				
    				setVisible(false);
    			} catch NombreRepetidoException ex) {// limite en cantidad(? 
    				JOptionPane.showMessageDialog(
                            frame,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                        );
    			}
    			
    			

                
                
                
    		} catch (NumberFormatException ex) {numero positivo- entero
    			JOptionPane.showMessageDialog(
                        frame,
                        "No se ingreso un numero valido. Intente de nuevo",
                        "Error",
                        JOptionPane.INFORMATION_MESSAGE
                    );
    		}
    		
    		
    	}
    });*/
		
		
	}

}
