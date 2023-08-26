package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DTOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
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
import javax.swing.ScrollPaneConstants;

public class ConsultarOferta extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	private IControladorUsuario ctrlUsuario;
	private JTextField textNombre;
	private JTextField textCiudad;
	private JTextField textDepartamento;
	private JTextField textHorario;
	private JTextField textRemuneracion;
	private JTextField textFechaAlta;
	private JTextField textEmpresa;
	
	public ConsultarOferta(IControladorOferta cop, IControladorUsuario icu) {
		ctrlOferta = cop;	
		ctrlUsuario = icu;
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Consultar Oferta Laboral");
        setBounds(10, 40, 764, 700);
        
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
        
      
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane_1, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        scrollPane_1.setViewportView(panel_1);
        
        JPanel panel_1_1 = new JPanel();
        panel_1.add(panel_1_1);
        GridBagLayout gbl_panel_1_1 = new GridBagLayout();
        gbl_panel_1_1.columnWidths = new int[]{200, 250, 200, 0};
        gbl_panel_1_1.rowHeights = new int[]{30, 30, 30, 30, 100, 30, 30, 30, 30, 30, 30, 30, 120, 0, 90, 0};
        gbl_panel_1_1.columnWeights = new double[]{4.9E-324, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1_1.rowWeights = new double[]{4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_1_1.setLayout(gbl_panel_1_1);
        
        JLabel label = new JLabel("Seleccione una empresa");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel_1_1.add(label, gbc_label);
        
        JComboBox<String> comboBoxEmpresa = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxEmpresa = new GridBagConstraints();
        gbc_comboBoxEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxEmpresa.gridx = 1;
        gbc_comboBoxEmpresa.gridy = 0;
        panel_1_1.add(comboBoxEmpresa, gbc_comboBoxEmpresa);
        List<String> listaEmpresas = ctrlUsuario.listarNickEmpresas();
        for(int i = 0; i <= listaEmpresas.size() - 1; i++) {
        	comboBoxEmpresa.addItem(listaEmpresas.get(i));
        }
        
        JComboBox<String> comboBoxOferta = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxOferta = new GridBagConstraints();
        gbc_comboBoxOferta.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxOferta.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxOferta.gridx = 1;
        gbc_comboBoxOferta.gridy = 1;
        panel_1_1.add(comboBoxOferta, gbc_comboBoxOferta);
        
        
        JButton btnSelectEmpresa = new JButton("seleccionar");
        GridBagConstraints gbc_btnSelectEmpresa = new GridBagConstraints();
        gbc_btnSelectEmpresa.insets = new Insets(0, 0, 5, 0);
        gbc_btnSelectEmpresa.gridx = 2;
        gbc_btnSelectEmpresa.gridy = 0;
        panel_1_1.add(btnSelectEmpresa, gbc_btnSelectEmpresa);
        btnSelectEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> listaOfertas = ctrlOferta.listarOfertasByEmpresa(comboBoxEmpresa.getSelectedItem().toString());
				for(int i = 0; i <= listaOfertas.size() - 1; i++) {
					comboBoxOferta.addItem(listaOfertas.get(i));
				}
			}
        });


        
        JLabel lblNewLabel = new JLabel("Seleccione una oferta");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        panel_1_1.add(lblNewLabel, gbc_lblNewLabel);
        
        JButton btnSelectOferta = new JButton("seleccionar");
        GridBagConstraints gbc_btnSelectOferta = new GridBagConstraints();
        gbc_btnSelectOferta.insets = new Insets(0, 0, 5, 0);
        gbc_btnSelectOferta.gridx = 2;
        gbc_btnSelectOferta.gridy = 1;
        panel_1_1.add(btnSelectOferta, gbc_btnSelectOferta);
        
        JLabel lblNewLabel_7 = new JLabel("Nombre: ");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 3;
        panel_1_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        textNombre = new JTextField();
        textNombre.setEditable(false);
        GridBagConstraints gbc_textNombre = new GridBagConstraints();
        gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNombre.insets = new Insets(5, 5, 5, 5);
        gbc_textNombre.gridx = 1;
        gbc_textNombre.gridy = 3;
        panel_1_1.add(textNombre, gbc_textNombre);
        
        JLabel lblNewLabel_3 = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 4;
        panel_1_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 4;
        panel_1_1.add(scrollPane, gbc_scrollPane);
        
        JTextArea textDescripcion = new JTextArea();
        textDescripcion.setLineWrap(true);
        textDescripcion.setEditable(false);
        scrollPane.setViewportView(textDescripcion);
        
        JLabel lblNewLabel_2 = new JLabel("Ciudad");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 5;
        panel_1_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textCiudad = new JTextField();
        textCiudad.setEditable(false);
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.insets = new Insets(5, 5, 5, 5);
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 5;
        panel_1_1.add(textCiudad, gbc_textField_1);
        
        JLabel lblNewLabel_1 = new JLabel("Departamento: ");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 6;
        panel_1_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textDepartamento = new JTextField();
        textDepartamento.setEditable(false);
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.insets = new Insets(5, 5, 5, 5);
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 6;
        panel_1_1.add(textDepartamento, gbc_textField_2);
        
        JLabel lblNewLabel_4 = new JLabel("Horario: ");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 7;
        panel_1_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textHorario = new JTextField();
        textHorario.setEditable(false);
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.insets = new Insets(5, 5, 5, 5);
        gbc_textField_3.gridx = 1;
        gbc_textField_3.gridy = 7;
        panel_1_1.add(textHorario, gbc_textField_3);
        
        JLabel lblNewLabel_5 = new JLabel("Remuneracion: ");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 8;
        panel_1_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textRemuneracion = new JTextField();
        textRemuneracion.setEditable(false);
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.insets = new Insets(5, 5, 5, 5);
        gbc_textField_4.gridx = 1;
        gbc_textField_4.gridy = 8;
        panel_1_1.add(textRemuneracion, gbc_textField_4);
        
        JLabel lblNewLabel_6 = new JLabel("Fecha de alta: ");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 9;
        panel_1_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFechaAlta = new JTextField();
        textFechaAlta.setEditable(false);
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.insets = new Insets(5, 5, 5, 5);
        gbc_textField_5.gridx = 1;
        gbc_textField_5.gridy = 9;
        panel_1_1.add(textFechaAlta, gbc_textField_5);
        
        JLabel lblNewLabel_9 = new JLabel("Empresa: ");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 10;
        panel_1_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
        
        textEmpresa = new JTextField();
        textEmpresa.setEditable(false);
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.insets = new Insets(5, 5, 5, 5);
        gbc_textField_6.gridx = 1;
        gbc_textField_6.gridy = 10;
        panel_1_1.add(textEmpresa, gbc_textField_6);
        
        JLabel lblNewLabel_10 = new JLabel("Keywords: ");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 11;
        panel_1_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
        
        JComboBox<String> comboBoxKeywords = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxKeywords = new GridBagConstraints();
        gbc_comboBoxKeywords.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxKeywords.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxKeywords.gridx = 1;
        gbc_comboBoxKeywords.gridy = 11;
        panel_1_1.add(comboBoxKeywords, gbc_comboBoxKeywords);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
        gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_2.gridx = 1;
        gbc_scrollPane_2.gridy = 12;
        panel_1_1.add(scrollPane_2, gbc_scrollPane_2);
        
        JTextArea textDataPostulacion = new JTextArea();
        textDataPostulacion.setEditable(false);
        textDataPostulacion.setLineWrap(true);
        scrollPane_2.setViewportView(textDataPostulacion);
        
        scrollPane_2.setViewportView(textDataPostulacion);
		GridBagConstraints gbc_scrollPaneCv = new GridBagConstraints();
		gbc_scrollPaneCv.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneCv.fill = GridBagConstraints.BOTH;
        
		
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
				for(int i = 0; i <= listaKeywords.size() - 1; i++) {
					comboBoxKeywords.addItem(listaKeywords.get(i));
				}
				List<DTPostulacion> listaPostulaciones = dtOf.getPostulaciones();
				String totalDataPostulaciones = "";
				for(int i = 0; i <= listaPostulaciones.size() - 1; i++) {
					totalDataPostulaciones += "Postulante " + Integer.toString(i + 1) + "\n";
					totalDataPostulaciones += listaPostulaciones.get(i).toString();
				}
				textDataPostulacion.setText(totalDataPostulaciones.toString());
			}
        });

        
	}

}
