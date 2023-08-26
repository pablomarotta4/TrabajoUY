package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DTOfertaLaboral;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

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
        setBounds(10, 40, 700, 700);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton btnCerrar = new JButton("Cerrar");
        panel.add(btnCerrar);
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				dispose();
        	}
        });
		
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{200, 300, 200};
        gbl_panel_1.rowHeights = new int[]{30, 30, 30, 30, 100, 30, 30, 30, 30, 30, 30, 30, 30, 90};
        gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0};
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
        
        JLabel lblNewLabel_7 = new JLabel("Nombre: ");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 3;
        panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        JTextField textNombre = new JTextField();
        GridBagConstraints gbc_textNombre = new GridBagConstraints();
        gbc_textNombre.insets = new Insets(5, 5, 5, 5);
        gbc_textNombre.gridx = 1;
        gbc_textNombre.gridy = 3;
        gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
        textNombre.setEditable(false);
        panel_1.add(textNombre, gbc_textNombre);
        
        JLabel lblNewLabel_3 = new JLabel("Descripcion");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 4;
        panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		panel_1.add(scrollPane, gbc_scrollPane);
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textDescripcion);
		textDescripcion.setEditable(false);
        
        
        
        JLabel lblNewLabel_2 = new JLabel("Ciudad");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 5;
        panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        JTextField textCiudad = new JTextField();
        GridBagConstraints gbc_textCiudad = new GridBagConstraints();
        gbc_textCiudad.insets = new Insets(5, 5, 5, 5);
        gbc_textCiudad.gridx = 1;
        gbc_textCiudad.gridy = 5;
        gbc_textCiudad.fill = GridBagConstraints.HORIZONTAL;
        textCiudad.setEditable(false);
        panel_1.add(textCiudad, gbc_textCiudad);
        
        
        JLabel lblNewLabel_1 = new JLabel("Departamento: ");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 6;
        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        JTextField textDepartamento = new JTextField();
        GridBagConstraints gbc_textDepartamento = new GridBagConstraints();
        gbc_textDepartamento.insets = new Insets(5, 5, 5, 5);
        gbc_textDepartamento.gridx = 1;
        gbc_textDepartamento.gridy = 6;
        gbc_textDepartamento.fill = GridBagConstraints.HORIZONTAL;
        textDepartamento.setEditable(false);
        panel_1.add(textDepartamento, gbc_textDepartamento);
        
        
        
        
        JLabel lblNewLabel_4 = new JLabel("Horario: ");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 7;
        panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
        JTextField textHorario = new JTextField();
        GridBagConstraints gbc_textHorario = new GridBagConstraints();
        gbc_textHorario.insets = new Insets(5, 5, 5, 5);
        gbc_textHorario.gridx = 1;
        gbc_textHorario.gridy = 7;
        gbc_textHorario.fill = GridBagConstraints.HORIZONTAL;
        textHorario.setEditable(false);
        panel_1.add(textHorario, gbc_textHorario);
        
        
        
        JLabel lblNewLabel_5 = new JLabel("Remuneracion: ");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 8;
        panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
        JTextField textRemuneracion = new JTextField();
        GridBagConstraints gbc_textRemuneracion = new GridBagConstraints();
        gbc_textRemuneracion.insets = new Insets(5, 5, 5, 5);
        gbc_textRemuneracion.gridx = 1;
        gbc_textRemuneracion.gridy = 8;
        gbc_textRemuneracion.fill = GridBagConstraints.HORIZONTAL;
        textRemuneracion.setEditable(false);
        panel_1.add(textRemuneracion, gbc_textRemuneracion);
        
        
        JLabel lblNewLabel_6 = new JLabel("Fecha de alta: ");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 9;
        panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
        JTextField textFechaAlta = new JTextField();
        GridBagConstraints gbc_textFechaAlta = new GridBagConstraints();
        gbc_textFechaAlta.insets = new Insets(5, 5, 5, 5);
        gbc_textFechaAlta.gridx = 1;
        gbc_textFechaAlta.gridy = 9;
        gbc_textFechaAlta.fill = GridBagConstraints.HORIZONTAL;
        textFechaAlta.setEditable(false);
        panel_1.add(textFechaAlta, gbc_textFechaAlta);
        
        
        JLabel lblNewLabel_8 = new JLabel("Postulaciones: ");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 10;
        panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Empresa: ");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 11;
        panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
        JTextField textEmpresa = new JTextField();
        GridBagConstraints gbc_textEmpresa = new GridBagConstraints();
        gbc_textEmpresa.insets = new Insets(5, 5, 5, 5);
        gbc_textEmpresa.gridx = 1;
        gbc_textEmpresa.gridy = 11;
        gbc_textEmpresa.fill = GridBagConstraints.HORIZONTAL;
        textEmpresa.setEditable(false);
        panel_1.add(textEmpresa, gbc_textEmpresa);
        

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
        
        JLabel lblNewLabel_10 = new JLabel("Keywords: ");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 12;
        panel_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
        JComboBox<String> comboBoxKeywords = new JComboBox<String>();
        GridBagConstraints gbc_comboKeywords = new GridBagConstraints();
        gbc_comboKeywords.insets = new Insets(0, 0, 5, 5);
        gbc_comboKeywords.gridx = 1;
        gbc_comboKeywords.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboKeywords.gridy = 12;
        panel_1.add(comboBoxKeywords, gbc_comboKeywords);

        
        
        btnSelectOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTOfertaLaboral dtOf  = ctrlOferta.listarDatosOferta(comboBoxOferta.getSelectedItem().toString());
				textNombre.setText(dtOf.getNombre());
				textDescripcion.setText(dtOf.getDescripcion());
				textCiudad.setText(dtOf.getCiudad());
				textDepartamento.setText(dtOf.getDepartamento());
				textHorario.setText(dtOf.getHorario());
				textRemuneracion.setText(dtOf.getRemuneracion().toString());
				textFechaAlta.setText(dtOf.getFechaAlta().toString());
				textEmpresa.setText(dtOf.getNombreEmpresa());
				List<String> listaKeywords = dtOf.getKeywords();
				System.out.println(listaKeywords);
				for(int i = 0; i <= listaKeywords.size() - 1; i++) {
					comboBoxKeywords.addItem(listaKeywords.get(i));
				}
			}
        });
        

        
	}

}
