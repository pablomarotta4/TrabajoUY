package presentacion;

import javax.swing.JInternalFrame;

import logica.interfaces.IControladorOferta;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoRepetidoException;

import java.awt.Insets;

public class AltaKeyword extends JInternalFrame {

	private JTextField textNombreKeyword;


	public AltaKeyword(IControladorOferta ico) {
		
		setTitle("Alta de Keywords");
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setBounds(10, 40, 500, 354);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{180, 300, 150, 0};
        gbl_panel_1.rowHeights = new int[]{50, 0, 50, 0, 0};
        gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblNewLabel = new JLabel("Ingrese la Keyword:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        panel_1.add(lblNewLabel, gbc_lblNewLabel);
        
        textNombreKeyword = new JTextField();
        textNombreKeyword.setText("");
        
        
        GridBagConstraints gbc_textNombreKeyword = new GridBagConstraints();
        gbc_textNombreKeyword.insets = new Insets(0, 0, 5, 5);
        gbc_textNombreKeyword.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNombreKeyword.gridx = 1;
        gbc_textNombreKeyword.gridy = 1;
        panel_1.add(textNombreKeyword, gbc_textNombreKeyword);
        textNombreKeyword.setColumns(10);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 1;
        gbc_panel_2.gridy = 3;
        panel_1.add(panel_2, gbc_panel_2);
        
        JPanel panel = new JPanel();
        panel_2.add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frame = new JFrame("Ejemplo de Popup");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                try {
                	String valorTextNombreKeyword = textNombreKeyword.getText().toString();
                	if (valorTextNombreKeyword.equals("")) {
                		throw new CamposVaciosExcepcion("Campo Vacio");
                	}
                	ico.altaKeyword(valorTextNombreKeyword);
                	JOptionPane.showMessageDialog(
    						frame,
    						"La operación se ha realizado con éxito",
    						"Éxito",
    						JOptionPane.INFORMATION_MESSAGE
    						);
                	setVisible(false);
                } catch (ElementoRepetidoException ex){
                	JOptionPane.showMessageDialog(
                            frame,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                	
                } catch (CamposVaciosExcepcion ex) {
                	JOptionPane.showMessageDialog(
                            frame,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                }
        	}
        });
        panel.add(botonAceptar);
        
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        panel.add(botonCancelar);
        
	}

}
