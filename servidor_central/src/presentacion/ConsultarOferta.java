package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DtOfertaLaboral;
import logica.datatypes.DTPostulacion;
import logica.datatypes.DataEmpresa;
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

import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import java.awt.Color;

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
	
	public ConsultarOferta(IControladorOferta cop, IControladorUsuario icu, String preSeleccion) {
		ctrlOferta = cop;	
		ctrlUsuario = icu;
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true); 
        setClosable(true);
        setTitle("Consulta de Oferta Laboral");
        setBounds(10, 40, 764, 709);
        
      
        
        JScrollPane scrollPane_1 = new JScrollPane();
        getContentPane().add(scrollPane_1, BorderLayout.CENTER);
        

        
        JPanel panel_1_1 = new JPanel();
        scrollPane_1.setViewportView(panel_1_1);
        GridBagLayout gbl_panel_1_1 = new GridBagLayout();
        gbl_panel_1_1.columnWidths = new int[]{50, 200, 250, 200, 0};
        gbl_panel_1_1.rowHeights = new int[]{50, 30, 30, 30, 100, 30, 30, 30, 30, 30, 30, 30, 120, 0, 0};
        gbl_panel_1_1.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_1_1.setLayout(gbl_panel_1_1);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 0;
        panel_1_1.add(panel_1, gbc_panel_1);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 3;
        gbc_panel.gridy = 0;
        panel_1_1.add(panel, gbc_panel);
        
        JLabel lblEmpresa = new JLabel("Empresa:");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
        gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpresa.gridx = 1;
        gbc_lblEmpresa.gridy = 1;
        panel_1_1.add(lblEmpresa, gbc_lblEmpresa);
        
        JComboBox<String> comboBoxEmpresa = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxEmpresa = new GridBagConstraints();
        gbc_comboBoxEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxEmpresa.gridx = 2;
        gbc_comboBoxEmpresa.gridy = 1;
        panel_1_1.add(comboBoxEmpresa, gbc_comboBoxEmpresa);
        List<String> listaEmpresas = ctrlUsuario.listarNickEmpresas();
        for(int i = 0; i <= listaEmpresas.size() - 1; i++) {
        	comboBoxEmpresa.addItem(listaEmpresas.get(i));
        }
        
        JComboBox<String> comboBoxOferta = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxOferta = new GridBagConstraints();
        gbc_comboBoxOferta.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxOferta.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxOferta.gridx = 2;
        gbc_comboBoxOferta.gridy = 2;
        panel_1_1.add(comboBoxOferta, gbc_comboBoxOferta);
        comboBoxEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxOferta.removeAllItems();
				
				List<String> listaOfertas = ctrlOferta.listarOfertasAceptadasByEmpresa(comboBoxEmpresa.getSelectedItem().toString());
				for(int i = 0; i <= listaOfertas.size() - 1; i++) {	
					comboBoxOferta.addItem(listaOfertas.get(i));
				}
			}
        });


        
        JLabel lblNewLabel = new JLabel("Oferta Laboral:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 2;
        panel_1_1.add(lblNewLabel, gbc_lblNewLabel);
        
        JLabel lblNewLabel_7 = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 1;
        gbc_lblNewLabel_7.gridy = 3;
        panel_1_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        textNombre = new JTextField();
        textNombre.setBackground(new Color(255, 255, 255));
        textNombre.setEditable(false);
        GridBagConstraints gbc_textNombre = new GridBagConstraints();
        gbc_textNombre.insets = new Insets(0, 0, 5, 5);
        gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNombre.gridx = 2;
        gbc_textNombre.gridy = 3;
        panel_1_1.add(textNombre, gbc_textNombre);
        textNombre.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 4;
        panel_1_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 4;
        panel_1_1.add(scrollPane, gbc_scrollPane);
        
        JTextArea textDescripcion = new JTextArea();
        textDescripcion.setLineWrap(true);
        textDescripcion.setEditable(false);
        scrollPane.setViewportView(textDescripcion);
        
        JLabel lblNewLabel_2 = new JLabel("Ciudad:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 5;
        panel_1_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textCiudad = new JTextField();
        textCiudad.setBackground(new Color(255, 255, 255));
        textCiudad.setEditable(false);
        GridBagConstraints gbc_textCiudad = new GridBagConstraints();
        gbc_textCiudad.insets = new Insets(0, 0, 5, 5);
        gbc_textCiudad.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCiudad.gridx = 2;
        gbc_textCiudad.gridy = 5;
        panel_1_1.add(textCiudad, gbc_textCiudad);
        textCiudad.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Departamento:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 6;
        panel_1_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textDepartamento = new JTextField();
        textDepartamento.setBackground(new Color(255, 255, 255));
        textDepartamento.setEditable(false);
        GridBagConstraints gbc_textDepartamento = new GridBagConstraints();
        gbc_textDepartamento.insets = new Insets(0, 0, 5, 5);
        gbc_textDepartamento.fill = GridBagConstraints.HORIZONTAL;
        gbc_textDepartamento.gridx = 2;
        gbc_textDepartamento.gridy = 6;
        panel_1_1.add(textDepartamento, gbc_textDepartamento);
        textDepartamento.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Horario:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 7;
        panel_1_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textHorario = new JTextField();
        textHorario.setBackground(new Color(255, 255, 255));
        textHorario.setEditable(false);
        GridBagConstraints gbc_textHorario = new GridBagConstraints();
        gbc_textHorario.insets = new Insets(0, 0, 5, 5);
        gbc_textHorario.fill = GridBagConstraints.HORIZONTAL;
        gbc_textHorario.gridx = 2;
        gbc_textHorario.gridy = 7;
        panel_1_1.add(textHorario, gbc_textHorario);
        textHorario.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Remuneracion:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 8;
        panel_1_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textRemuneracion = new JTextField();
        textRemuneracion.setBackground(new Color(255, 255, 255));
        textRemuneracion.setEditable(false);
        GridBagConstraints gbc_textRemuneracion = new GridBagConstraints();
        gbc_textRemuneracion.insets = new Insets(0, 0, 5, 5);
        gbc_textRemuneracion.fill = GridBagConstraints.HORIZONTAL;
        gbc_textRemuneracion.gridx = 2;
        gbc_textRemuneracion.gridy = 8;
        panel_1_1.add(textRemuneracion, gbc_textRemuneracion);
        textRemuneracion.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Fecha de alta:");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 9;
        panel_1_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFechaAlta = new JTextField();
        textFechaAlta.setBackground(new Color(255, 255, 255));
        textFechaAlta.setEditable(false);
        GridBagConstraints gbc_textFechaAlta = new GridBagConstraints();
        gbc_textFechaAlta.insets = new Insets(0, 0, 5, 5);
        gbc_textFechaAlta.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFechaAlta.gridx = 2;
        gbc_textFechaAlta.gridy = 9;
        panel_1_1.add(textFechaAlta, gbc_textFechaAlta);
        textFechaAlta.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("Empresa:");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 1;
        gbc_lblNewLabel_9.gridy = 10;
        panel_1_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
        
        textEmpresa = new JTextField();
        textEmpresa.setBackground(new Color(255, 255, 255));
        textEmpresa.setEditable(false);
        GridBagConstraints gbc_textEmpresa = new GridBagConstraints();
        gbc_textEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_textEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_textEmpresa.gridx = 2;
        gbc_textEmpresa.gridy = 10;
        panel_1_1.add(textEmpresa, gbc_textEmpresa);
        textEmpresa.setColumns(10);
        
        JLabel lblNewLabel_10 = new JLabel("Keywords:");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 1;
        gbc_lblNewLabel_10.gridy = 11;
        panel_1_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
        
        JComboBox<String> comboBoxKeywords = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxKeywords = new GridBagConstraints();
        gbc_comboBoxKeywords.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxKeywords.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxKeywords.gridx = 2;
        gbc_comboBoxKeywords.gridy = 11;
        panel_1_1.add(comboBoxKeywords, gbc_comboBoxKeywords);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
        gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_2.gridx = 2;
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
		
		if(preSeleccion != null) {
			try {
				DtOfertaLaboral dtOf  = ctrlOferta.listarDatosOferta(preSeleccion);
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
				
			}catch(ElementoInexistenteException ex) {
				
			}
		}
		else {
			comboBoxOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DtOfertaLaboral dtOf  = ctrlOferta.listarDatosOferta(comboBoxOferta.getSelectedItem().toString());
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
				} catch(ElementoInexistenteException ex) {
					
				}
				
			}
        });
        
		}
        
		
       

        
	}

}
