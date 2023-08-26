package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DTOfertaLaboral;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ConsultarOferta extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	private IControladorUsuario ctrlUsuario;
	
	public ConsultarOferta(IControladorOferta cop, IControladorUsuario icu) {
		ctrlOferta = cop;	
		ctrlUsuario = icu;
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Consultar Oferta Laboral");
        setBounds(10, 40, 700, 800);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton btnNewButton = new JButton("New button");
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        panel.add(btnNewButton_1);
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{250, 200, 250};
        gbl_panel_1.rowHeights = new int[]{100, 100, 100, 100, 100};
        gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE, 0.0};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel label = new JLabel("Seleccione una empresa");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel_1.add(label, gbc_label);

        JComboBox<String> comboBoxEmpresa = new JComboBox<String>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        panel_1.add(comboBoxEmpresa, gbc_comboBox);
        
        JComboBox<String> comboBoxOferta = new JComboBox<String>();
        GridBagConstraints gbc_comboOferta = new GridBagConstraints();
        gbc_comboOferta.insets = new Insets(0, 0, 5, 5);
        gbc_comboOferta.gridx = 1;
        gbc_comboOferta.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboOferta.gridy = 1;
        panel_1.add(comboBoxOferta, gbc_comboOferta);
        
        JButton btnSelectEmpresa = new JButton("seleccionar");
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 2;
        gbc_button.gridy = 0;
        panel_1.add(btnSelectEmpresa, gbc_button);
        btnSelectEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> listaOfertas = ctrlOferta.listarOfertasByEmpresa(comboBoxEmpresa.getSelectedItem().toString());
				for(int i = 0; i <= listaOfertas.size() - 1; i++) {
					comboBoxOferta.addItem(listaOfertas.get(i));
				}
			}
        });
        
        List<String> listaEmpresas = ctrlUsuario.listarNickEmpresas();
        for(int i = 0; i <= listaEmpresas.size() - 1; i++) {
        	comboBoxEmpresa.addItem(listaEmpresas.get(i));
        }
        
        JLabel lblNewLabel = new JLabel("Seleccione una oferta");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        panel_1.add(lblNewLabel, gbc_lblNewLabel);
        
        JButton btnSelectOferta = new JButton("seleccionar");
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2.gridx = 2;
        gbc_btnNewButton_2.gridy = 1;
        panel_1.add(btnSelectOferta, gbc_btnNewButton_2);
        btnSelectOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTOfertaLaboral dtOf = ctrlOferta.listarDatosOferta(comboBoxOferta.getSelectedItem().toString());
				System.out.println(dtOf);
			}
        });
        
	}

}
