package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ConfirmarRechazarOfertaLaboral extends JInternalFrame {

	public ConfirmarRechazarOfertaLaboral() {
		
		Factory f = Factory.getInstance();
		IControladorOferta ico = f.getControladorOferta();
		IControladorUsuario icu = f.getControladorUsuario();
		IControladorCompraTipo icc = f.getControladorCompraTipo();

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Confirmar/Rechazar Oferta Laboral");
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{10, 85, 300, 10, 0};
        gridBagLayout.rowHeights = new int[]{10, 0, 0, 10, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        JLabel lblEmpresa = new JLabel("Empresa:");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
        gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpresa.gridx = 1;
        gbc_lblEmpresa.gridy = 1;
        getContentPane().add(lblEmpresa, gbc_lblEmpresa);
        
        JComboBox<String> cbEmpresas = new JComboBox<String>();
        List<String> listanickempresas = icu.listarNickEmpresas();
        
        JComboBox<String> cbOfertas = new JComboBox<String>();
        cbOfertas.addItem("");
        
        cbEmpresas.addItem("");
        for(int i = 0; i < listanickempresas.size(); i++) {
            	cbEmpresas.addItem(listanickempresas.get(i));
        }
        
        cbEmpresas.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (cbEmpresas.getSelectedItem() == "") {
                	cbOfertas.removeAllItems();
                	cbOfertas.addItem("");
                	cbOfertas.setSelectedIndex(0);
                	
        		} else {
                	cbOfertas.removeAllItems();
                	cbOfertas.addItem("");
        			String empresadelcombo = cbEmpresas.getSelectedItem().toString();
        	        List<String> listanombreofertas = ico.listarOfertasIngresadasByEmpresa(empresadelcombo);
        	        for(int i = 0; i < listanombreofertas.size(); i++)
                    	cbOfertas.addItem(listanombreofertas.get(i));
        	        }
        		}	
        	
        });
        cbEmpresas.setSelectedIndex(0);
        
        GridBagConstraints gbc_cbEmpresas = new GridBagConstraints();
        gbc_cbEmpresas.insets = new Insets(0, 0, 5, 5);
        gbc_cbEmpresas.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbEmpresas.gridx = 2;
        gbc_cbEmpresas.gridy = 1;
        getContentPane().add(cbEmpresas, gbc_cbEmpresas);
        
        JLabel lblOferta = new JLabel("Oferta Laboral:");
        GridBagConstraints gbc_lblOferta = new GridBagConstraints();
        gbc_lblOferta.anchor = GridBagConstraints.EAST;
        gbc_lblOferta.insets = new Insets(0, 0, 5, 5);
        gbc_lblOferta.gridx = 1;
        gbc_lblOferta.gridy = 2;
        getContentPane().add(lblOferta, gbc_lblOferta);
        
        GridBagConstraints gbc_cbOfertas = new GridBagConstraints();
        gbc_cbOfertas.insets = new Insets(0, 0, 5, 5);
        gbc_cbOfertas.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbOfertas.gridx = 2;
        gbc_cbOfertas.gridy = 2;
        getContentPane().add(cbOfertas, gbc_cbOfertas);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.gridwidth = 2;
        gbc_panel_2.insets = new Insets(0, 0, 0, 5);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 1;
        gbc_panel_2.gridy = 4;
        getContentPane().add(panel_2, gbc_panel_2);
        
		JFrame frame = new JFrame("PopUp");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnConfirmar = new JButton("Confirmar");
        panel_2.add(btnConfirmar);
        btnConfirmar.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			String ofertaLaboral = cbOfertas.getSelectedItem().toString();
        			ico.confirmarOferta(ofertaLaboral);	
        			JOptionPane.showMessageDialog(frame, "Oferta laboral confirmada", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        			dispose();
        		} catch(Exception e) {
        			JOptionPane.showMessageDialog(frame, "Seleccione una oferta laboral", "Error", JOptionPane.ERROR_MESSAGE);
        		}		
        	}
        });
        
        JButton btnRechazar = new JButton("Rechazar");
        panel_2.add(btnRechazar);
        btnRechazar.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			String ofertaLaboral = cbOfertas.getSelectedItem().toString();
        			ico.rechazarOferta(ofertaLaboral);	
        			JOptionPane.showMessageDialog(frame, "Oferta laboral rechazada", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        			dispose();
        		} catch(Exception e) {
        			JOptionPane.showMessageDialog(frame, "Seleccione una oferta laboral", "Error", JOptionPane.ERROR_MESSAGE);
        		}		
        	}
        });
        
	}
}
