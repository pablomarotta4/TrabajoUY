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
	private JTextField txtCosto;
	private JTextField txtEstado;
	private JTextField txtfDuracion;
	private DtOfertaLaboral dtOf;
	private Float costofinal;
	private Integer duracionFinal;
	
	public ConsultarOferta(IControladorOferta cop, IControladorUsuario icu, String preSeleccion) {
		ctrlOferta = cop;	
		ctrlUsuario = icu;
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true); 
        setClosable(true);
        setTitle("Consulta de Oferta Laboral");
        setBounds(10, 40, 764, 1132);
        
      
        
        JScrollPane scrollPane_1 = new JScrollPane();
        getContentPane().add(scrollPane_1, BorderLayout.CENTER);
        

        
        JPanel panel_1_1 = new JPanel();
        scrollPane_1.setViewportView(panel_1_1);
        GridBagLayout gbl_panel_1_1 = new GridBagLayout();
        gbl_panel_1_1.columnWidths = new int[]{150, 300, 180, 0};
        gbl_panel_1_1.rowHeights = new int[]{50, 30, 30, 30, 0, 0, 150, 30, 30, 30, 30, 30, 0, 30, 150, 150, 0, 0};
        gbl_panel_1_1.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_1_1.setLayout(gbl_panel_1_1);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 2;
        gbc_panel.gridy = 0;
        panel_1_1.add(panel, gbc_panel);
        
        JLabel lblEmpresa = new JLabel("Empresa:");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
        gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpresa.gridx = 0;
        gbc_lblEmpresa.gridy = 1;
        panel_1_1.add(lblEmpresa, gbc_lblEmpresa);
        
        JComboBox<String> comboBoxEmpresa = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxEmpresa = new GridBagConstraints();
        gbc_comboBoxEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxEmpresa.gridx = 1;
        gbc_comboBoxEmpresa.gridy = 1;
        panel_1_1.add(comboBoxEmpresa, gbc_comboBoxEmpresa);
        comboBoxEmpresa.addItem("");
        List<String> listaEmpresas = ctrlUsuario.listarNickEmpresas();
        for(int i = 0; i <= listaEmpresas.size() - 1; i++) {
        	comboBoxEmpresa.addItem(listaEmpresas.get(i));
        }
        
        JComboBox<String> comboBoxOferta = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxOferta = new GridBagConstraints();
        gbc_comboBoxOferta.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxOferta.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxOferta.gridx = 1;
        gbc_comboBoxOferta.gridy = 2;
        panel_1_1.add(comboBoxOferta, gbc_comboBoxOferta);
        comboBoxOferta.addItem("");
        comboBoxOferta.setSelectedIndex(0);



        
        JLabel lblNewLabel = new JLabel("Oferta Laboral:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 2;
        panel_1_1.add(lblNewLabel, gbc_lblNewLabel);
        
        JLabel lblNewLabel_7 = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 3;
        panel_1_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        textNombre = new JTextField();
        textNombre.setBackground(new Color(255, 255, 255));
        textNombre.setEditable(false);
        GridBagConstraints gbc_textNombre = new GridBagConstraints();
        gbc_textNombre.insets = new Insets(0, 0, 5, 5);
        gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNombre.gridx = 1;
        gbc_textNombre.gridy = 3;
        panel_1_1.add(textNombre, gbc_textNombre);
        textNombre.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("Empresa:");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 4;
        panel_1_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
        
        textEmpresa = new JTextField();
        textEmpresa.setBackground(new Color(255, 255, 255));
        textEmpresa.setEditable(false);
        GridBagConstraints gbc_textEmpresa = new GridBagConstraints();
        gbc_textEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_textEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_textEmpresa.gridx = 1;
        gbc_textEmpresa.gridy = 4;
        panel_1_1.add(textEmpresa, gbc_textEmpresa);
        textEmpresa.setColumns(10);
        
        JLabel lblEstado = new JLabel("Estado:");
        GridBagConstraints gbc_lblEstado = new GridBagConstraints();
        gbc_lblEstado.anchor = GridBagConstraints.EAST;
        gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
        gbc_lblEstado.gridx = 0;
        gbc_lblEstado.gridy = 5;
        panel_1_1.add(lblEstado, gbc_lblEstado);
        
        txtEstado = new JTextField();
        txtEstado.setBackground(new Color(255, 255, 255));
        txtEstado.setEditable(false);
        GridBagConstraints gbc_txtEstado = new GridBagConstraints();
        gbc_txtEstado.insets = new Insets(0, 0, 5, 5);
        gbc_txtEstado.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEstado.gridx = 1;
        gbc_txtEstado.gridy = 5;
        panel_1_1.add(txtEstado, gbc_txtEstado);
        txtEstado.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 6;
        panel_1_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 6;
        panel_1_1.add(scrollPane, gbc_scrollPane);
        
        JTextArea textDescripcion = new JTextArea();
        textDescripcion.setLineWrap(true);
        textDescripcion.setEditable(false);
        scrollPane.setViewportView(textDescripcion);
        
        JLabel lblNewLabel_2 = new JLabel("Ciudad:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 7;
        panel_1_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textCiudad = new JTextField();
        textCiudad.setBackground(new Color(255, 255, 255));
        textCiudad.setEditable(false);
        GridBagConstraints gbc_textCiudad = new GridBagConstraints();
        gbc_textCiudad.insets = new Insets(0, 0, 5, 5);
        gbc_textCiudad.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCiudad.gridx = 1;
        gbc_textCiudad.gridy = 7;
        panel_1_1.add(textCiudad, gbc_textCiudad);
        textCiudad.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Departamento:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 8;
        panel_1_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textDepartamento = new JTextField();
        textDepartamento.setBackground(new Color(255, 255, 255));
        textDepartamento.setEditable(false);
        GridBagConstraints gbc_textDepartamento = new GridBagConstraints();
        gbc_textDepartamento.insets = new Insets(0, 0, 5, 5);
        gbc_textDepartamento.fill = GridBagConstraints.HORIZONTAL;
        gbc_textDepartamento.gridx = 1;
        gbc_textDepartamento.gridy = 8;
        panel_1_1.add(textDepartamento, gbc_textDepartamento);
        textDepartamento.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Horario:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 9;
        panel_1_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textHorario = new JTextField();
        textHorario.setBackground(new Color(255, 255, 255));
        textHorario.setEditable(false);
        GridBagConstraints gbc_textHorario = new GridBagConstraints();
        gbc_textHorario.insets = new Insets(0, 0, 5, 5);
        gbc_textHorario.fill = GridBagConstraints.HORIZONTAL;
        gbc_textHorario.gridx = 1;
        gbc_textHorario.gridy = 9;
        panel_1_1.add(textHorario, gbc_textHorario);
        textHorario.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Remuneracion:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 10;
        panel_1_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textRemuneracion = new JTextField();
        textRemuneracion.setBackground(new Color(255, 255, 255));
        textRemuneracion.setEditable(false);
        GridBagConstraints gbc_textRemuneracion = new GridBagConstraints();
        gbc_textRemuneracion.insets = new Insets(0, 0, 5, 5);
        gbc_textRemuneracion.fill = GridBagConstraints.HORIZONTAL;
        gbc_textRemuneracion.gridx = 1;
        gbc_textRemuneracion.gridy = 10;
        panel_1_1.add(textRemuneracion, gbc_textRemuneracion);
        textRemuneracion.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Fecha de Alta:");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 11;
        panel_1_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFechaAlta = new JTextField();
        textFechaAlta.setBackground(new Color(255, 255, 255));
        textFechaAlta.setEditable(false);
        GridBagConstraints gbc_textFechaAlta = new GridBagConstraints();
        gbc_textFechaAlta.insets = new Insets(0, 0, 5, 5);
        gbc_textFechaAlta.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFechaAlta.gridx = 1;
        gbc_textFechaAlta.gridy = 11;
        panel_1_1.add(textFechaAlta, gbc_textFechaAlta);
        textFechaAlta.setColumns(10);
        
        JLabel lblDuracion = new JLabel("Duracion:");
        GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
        gbc_lblDuracion.anchor = GridBagConstraints.EAST;
        gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDuracion.gridx = 0;
        gbc_lblDuracion.gridy = 12;
        panel_1_1.add(lblDuracion, gbc_lblDuracion);
        
        txtfDuracion = new JTextField();
        txtfDuracion.setBackground(new Color(255, 255, 255));
        txtfDuracion.setEditable(false);
        GridBagConstraints gbc_txtfDuracion = new GridBagConstraints();
        gbc_txtfDuracion.insets = new Insets(0, 0, 5, 5);
        gbc_txtfDuracion.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtfDuracion.gridx = 1;
        gbc_txtfDuracion.gridy = 12;
        panel_1_1.add(txtfDuracion, gbc_txtfDuracion);
        txtfDuracion.setColumns(10);
        
        JLabel lblCosto = new JLabel("Costo:");
        GridBagConstraints gbc_lblCosto = new GridBagConstraints();
        gbc_lblCosto.anchor = GridBagConstraints.EAST;
        gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
        gbc_lblCosto.gridx = 0;
        gbc_lblCosto.gridy = 13;
        panel_1_1.add(lblCosto, gbc_lblCosto);
        
        txtCosto = new JTextField();
        txtCosto.setBackground(new Color(255, 255, 255));
        txtCosto.setEditable(false);
        GridBagConstraints gbc_txtCosto = new GridBagConstraints();
        gbc_txtCosto.insets = new Insets(0, 0, 5, 5);
        gbc_txtCosto.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCosto.gridx = 1;
        gbc_txtCosto.gridy = 13;
        panel_1_1.add(txtCosto, gbc_txtCosto);
        txtCosto.setColumns(10);
        
        JLabel lblNewLabel_10 = new JLabel("Keywords:");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 14;
        panel_1_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
        
        JScrollPane scrollPane_3 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
        gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_3.gridx = 1;
        gbc_scrollPane_3.gridy = 14;
        panel_1_1.add(scrollPane_3, gbc_scrollPane_3);
        
        JTextArea textArea_3 = new JTextArea();
        textArea_3.setLineWrap(true);
        textArea_3.setEditable(false);
        scrollPane_3.setViewportView(textArea_3);
        
        JLabel lblPostulaciones = new JLabel("Postulaciones:");
        GridBagConstraints gbc_lblPostulaciones = new GridBagConstraints();
        gbc_lblPostulaciones.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblPostulaciones.insets = new Insets(0, 0, 5, 5);
        gbc_lblPostulaciones.gridx = 0;
        gbc_lblPostulaciones.gridy = 15;
        panel_1_1.add(lblPostulaciones, gbc_lblPostulaciones);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
        gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_2.gridx = 1;
        gbc_scrollPane_2.gridy = 15;
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
				
				dtOf  = ctrlOferta.listarDatosOferta(comboBoxOferta.getSelectedItem().toString());
				textNombre.setText(dtOf.getNombre());
				costofinal = (Float) dtOf.getCosto();
				txtCosto.setText(costofinal.toString() + " $");
				duracionFinal = (Integer) dtOf.getDuracion();
				txtfDuracion.setText(duracionFinal.toString() + " dias");
				txtEstado.setText(dtOf.getEstado().toString());
				textDescripcion.setText(dtOf.getDescripcion());
				textCiudad.setText(dtOf.getCiudad());
				textDepartamento.setText(dtOf.getDepartamento());
				textHorario.setText(dtOf.getHorario());
				textRemuneracion.setText(dtOf.getRemuneracion().toString() + " $");
				textFechaAlta.setText(dtOf.getFechaAlta().toString());
				textEmpresa.setText(dtOf.getNombreEmpresa());
			
				List<String> keys = dtOf.getKeywords();
				String keysText = "";
				if (keys.size() != 0) {
					for(int i = 0; i < keys.size(); i++) {
						if (keysText != "") {
							keysText = keysText + "\n" + keys.get(i);
						} else {
							keysText = keys.get(i);
						}
					}
				} else {
					keysText = "";
				}
				textArea_3.setText(keysText);
				
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
		else {
	        comboBoxEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBoxEmpresa.getSelectedItem() == "") {
						System.out.println(comboBoxEmpresa.getSelectedItem().toString());
						comboBoxOferta.removeAllItems();
						comboBoxOferta.addItem("");
						comboBoxOferta.setSelectedIndex(0);
					} else {
						System.out.println(comboBoxEmpresa.getSelectedItem());
	                	comboBoxOferta.removeAllItems();
	                	comboBoxOferta.addItem("");
	                	String empresadelcombo = comboBoxEmpresa.getSelectedItem().toString();
	                	List<String> listanombreofertas = ctrlOferta.listarOfertasByEmpresa(empresadelcombo);
	        	        for(int i = 0; i < listanombreofertas.size(); i++) {
	                    	comboBoxOferta.addItem(listanombreofertas.get(i));
	        	        }
					}

				}
	        });
	        comboBoxEmpresa.setSelectedIndex(0);
	        
	        
	        
			comboBoxOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if (comboBoxOferta.getSelectedItem() == "" || comboBoxOferta.getSelectedItem() == null) {
						
						
	        			textArea_3.setText("");
						textDescripcion.setText("");
						
						textNombre.setText("");
						txtCosto.setText("");
						txtfDuracion.setText("");
						txtEstado.setText("");
						textCiudad.setText("");
						textDepartamento.setText("");
						textHorario.setText("");
						textRemuneracion.setText("");
						textFechaAlta.setText("");
						textEmpresa.setText("");
						
					} else {
						try {
							
							dtOf  = ctrlOferta.listarDatosOferta(comboBoxOferta.getSelectedItem().toString());
							textNombre.setText(dtOf.getNombre());
							costofinal = (Float) dtOf.getCosto();
							txtCosto.setText(costofinal.toString() + " $");
							duracionFinal = (Integer) dtOf.getDuracion();
							txtfDuracion.setText(duracionFinal.toString() + " dias");
							txtEstado.setText(dtOf.getEstado().toString());
							textDescripcion.setText(dtOf.getDescripcion());
							textCiudad.setText(dtOf.getCiudad());
							textDepartamento.setText(dtOf.getDepartamento());
							textHorario.setText(dtOf.getHorario());
							textRemuneracion.setText(dtOf.getRemuneracion().toString() + " $");
							textFechaAlta.setText(dtOf.getFechaAlta().toString());
							textEmpresa.setText(dtOf.getNombreEmpresa());
						
							List<String> keys = dtOf.getKeywords();
	        				String keysText = "";
	        				if (keys.size() != 0) {
	        					for(int i = 0; i < keys.size(); i++) {
	        						if (keysText != "") {
	        							keysText = keysText + "\n" + keys.get(i);
	        						} else {
	        							keysText = keys.get(i);
	        						}
	        					}
	        				} else {
	        					keysText = "";
	        				}
	        				textArea_3.setText(keysText);
	        				
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
				
				
				}
			});
        
		}
        
		
       

        
	}

}
