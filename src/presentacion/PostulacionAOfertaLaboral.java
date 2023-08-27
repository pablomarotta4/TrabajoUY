package presentacion;


import excepciones.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.datatypes.DTOfertaLaboral;
import logica.entidades.OfertaLaboral;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;

public class PostulacionAOfertaLaboral extends JInternalFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

	
	public PostulacionAOfertaLaboral() {
		
		Factory f = Factory.getInstance();
		IControladorOferta ico = f.getControladorOferta();
		IControladorUsuario icu = f.getControladorUsuario();
		
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Postulacion a Oferta Laboral");
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{150, 300, 150, 0};
        gbl_panel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0, 150, 150, 80, 0, 20, 0, 150, 150, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.insets = new Insets(0, 0, 5, 0);
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridx = 2;
        gbc_panel_4.gridy = 0;
        panel.add(panel_4, gbc_panel_4);
        
        JLabel lblNewLabel_0 = new JLabel("Empresa:");
        GridBagConstraints gbc_lblNewLabel_0 = new GridBagConstraints();
        gbc_lblNewLabel_0.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_0.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_0.gridx = 0;
        gbc_lblNewLabel_0.gridy = 1;
        panel.add(lblNewLabel_0, gbc_lblNewLabel_0);
        

        
        JComboBox<String> comboBox_0 = new JComboBox<String>();
        List<String> listanickempresas = icu.listarNickEmpresas();
        
        JComboBox<String> comboBox = new JComboBox<String>();
        List<String> listanickpostulantes = icu.listarNickPostulantes();
        
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.addItem("");
        
        comboBox_0.addItem("");
        for(int i = 0; i < listanickempresas.size(); i++) {
            	comboBox_0.addItem(listanickempresas.get(i));

        }
        
        comboBox.addItem("");
        for(int i = 0; i < listanickpostulantes.size(); i++) {
            	comboBox.addItem(listanickpostulantes.get(i));

        }
        
        comboBox_0.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (comboBox_0.getSelectedItem() == "") {
                	comboBox_1.removeAllItems();
                	comboBox_1.addItem("");
                	comboBox_1.setSelectedIndex(0);
                	
        		} else {
                	comboBox_1.removeAllItems();
                	comboBox_1.addItem("");
        			String empresadelcombo = comboBox_0.getSelectedItem().toString();
        	        List<String> listanombreofertas = ico.listarOfertasByEmpresa(empresadelcombo);
        	        for(int i = 0; i < listanombreofertas.size(); i++)
                    	comboBox_1.addItem(listanombreofertas.get(i));
        	        }
        		// se limpian los campos solos idkw xd mas abajo en el combobox1
        		}	
        	
        });
        comboBox_0.setSelectedIndex(0);
        
        GridBagConstraints gbc_comboBox_0 = new GridBagConstraints();
        gbc_comboBox_0.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox_0.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_0.gridx = 1;
        gbc_comboBox_0.gridy = 1;
        panel.add(comboBox_0, gbc_comboBox_0);
        
        JLabel lblNewLabel_1 = new JLabel("Oferta Laboral:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 2;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        // campos
        textField_5 = new JTextField();
        textField_6 = new JTextField();
        textField_7 = new JTextField();
        textField_8 = new JTextField();
        textField_9 = new JTextField();
        textField_11 = new JTextField();
        
        JTextArea textArea = new JTextArea();
        JTextArea textArea_3 = new JTextArea();
        
        // fecha
        textField_10 = new JTextField();
        textField_12 = new JTextField();
        textField_13 = new JTextField();

        textField_17 = new JTextField();
        
        
        comboBox_1.addActionListener((ActionListener) new ActionListener() {
        	
			public void actionPerformed(ActionEvent arg0) {
		
        		if (comboBox_1.getSelectedItem() == "" || comboBox_1.getSelectedItem() == null) {
        			// vaciar campos
        			textField_5.setText("");
        			textField_6.setText("");
        			textField_7.setText("");
        			textField_8.setText("");
        			textField_9.setText("");
        			textField_11.setText("");
        			
        			textArea.setText("");
        			textArea_3.setText("");
        			
        			textField_10.setText("");
        			textField_12.setText("");
        			textField_13.setText("");
        			
        			textField_17.setText("");
        			
        		} else {
        			try {
        				String ofertaName = (String) comboBox_1.getSelectedItem();
        				DTOfertaLaboral datosOferta = ico.listarDatosOferta(ofertaName);
        				
        				List<String> keys = datosOferta.getKeywords();
        				
        				
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
        				
        				
        				textField_5.setText(datosOferta.getNombre());
        				textField_6.setText(datosOferta.getDepartamento());
        				textField_7.setText(datosOferta.getCiudad());
        				textField_8.setText(datosOferta.getRemuneracion().toString());
        				textField_9.setText(datosOferta.getHorario());
        				textField_11.setText(Float.toString(datosOferta.getCosto()));
        				
        				textArea.setText(datosOferta.getDescripcion());
        				textArea_3.setText(keysText);
        				
        				LocalDate fecha = datosOferta.getFechaAlta();
        				Integer dia = fecha.getDayOfMonth();
        				Integer mes = fecha.getMonth().getValue();
        				Integer anio = fecha.getYear();
        				
        				textField_10.setText(dia.toString());
        				textField_12.setText(mes.toString());
        				textField_13.setText(anio.toString());
        				
        				textField_17.setText(Integer.toString(datosOferta.getDuracion()));
        				
        			}catch (ElementoInexistenteException ex) {
        				
        			}
        				
        			}
        	}
        });  
        comboBox_1.setSelectedIndex(0);
        
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox_1.gridx = 1;
        gbc_comboBox_1.gridy = 2;
        panel.add(comboBox_1, gbc_comboBox_1);
        
        JLabel lblNewLabel_2 = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 3;
        panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textField_5.setBackground(new Color(255, 255, 255));
        textField_5.setEditable(false);
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.gridx = 1;
        gbc_textField_5.gridy = 3;
        panel.add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Departamento:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 4;
        panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        

        textField_6.setBackground(new Color(255, 255, 255));
        textField_6.setEditable(false);
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.gridx = 1;
        gbc_textField_6.gridy = 4;
        panel.add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Ciudad:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 5;
        panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        

        textField_7.setBackground(new Color(255, 255, 255));
        textField_7.setEditable(false);
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.insets = new Insets(0, 0, 5, 5);
        gbc_textField_7.gridx = 1;
        gbc_textField_7.gridy = 5;
        panel.add(textField_7, gbc_textField_7);
        textField_7.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Remuneracion:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 6;
        panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
        

        textField_8.setBackground(new Color(255, 255, 255));
        textField_8.setEditable(false);
        GridBagConstraints gbc_textField_8 = new GridBagConstraints();
        gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_8.insets = new Insets(0, 0, 5, 5);
        gbc_textField_8.gridx = 1;
        gbc_textField_8.gridy = 6;
        panel.add(textField_8, gbc_textField_8);
        textField_8.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Horario:");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 7;
        panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
        

        textField_9.setBackground(new Color(255, 255, 255));
        textField_9.setEditable(false);
        GridBagConstraints gbc_textField_9 = new GridBagConstraints();
        gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_9.insets = new Insets(0, 0, 5, 5);
        gbc_textField_9.gridx = 1;
        gbc_textField_9.gridy = 7;
        panel.add(textField_9, gbc_textField_9);
        textField_9.setColumns(10);
        
        JLabel lblNewLabel_10 = new JLabel("Costo:");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 8;
        panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
        

        textField_11.setBackground(new Color(255, 255, 255));
        textField_11.setEditable(false);
        GridBagConstraints gbc_textField_11 = new GridBagConstraints();
        gbc_textField_11.insets = new Insets(0, 0, 5, 5);
        gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_11.gridx = 1;
        gbc_textField_11.gridy = 8;
        panel.add(textField_11, gbc_textField_11);
        textField_11.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 9;
        panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 1;
        gbc_scrollPane_1.gridy = 9;
        panel.add(scrollPane_1, gbc_scrollPane_1);
        

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        scrollPane_1.setViewportView(textArea);
        
        JLabel lblNewLabel_19 = new JLabel("Keywords:");
        GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
        gbc_lblNewLabel_19.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_19.gridx = 0;
        gbc_lblNewLabel_19.gridy = 10;
        panel.add(lblNewLabel_19, gbc_lblNewLabel_19);
        
        JScrollPane scrollPane_4 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
        gbc_scrollPane_4.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_4.gridx = 1;
        gbc_scrollPane_4.gridy = 10;
        panel.add(scrollPane_4, gbc_scrollPane_4);
        

        textArea_3.setEditable(false);
        textArea_3.setLineWrap(true);
        scrollPane_4.setViewportView(textArea_3);
        
        JLabel lblNewLabel_9 = new JLabel("Fecha de Alta:");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 11;
        panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.gridx = 1;
        gbc_panel_1.gridy = 11;
        panel.add(panel_1, gbc_panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblNewLabel_12 = new JLabel("Dia:");
        panel_1.add(lblNewLabel_12);
        
        textField_10.setBackground(new Color(255, 255, 255));
        textField_10.setEditable(false);
        panel_1.add(textField_10);
        textField_10.setColumns(10);
        
        JLabel lblNewLabel_13 = new JLabel("Mes:");
        panel_1.add(lblNewLabel_13);
        
        textField_12.setBackground(new Color(255, 255, 255));
        textField_12.setEditable(false);
        panel_1.add(textField_12);
        textField_12.setColumns(10);
        
        JLabel lblNewLabel_14 = new JLabel("Año:");
        panel_1.add(lblNewLabel_14);
        
        textField_13.setBackground(new Color(255, 255, 255));
        textField_13.setEditable(false);
        panel_1.add(textField_13);
        textField_13.setColumns(10);
        
        JLabel lblNewLabel_20 = new JLabel("Duracion:");
        GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
        gbc_lblNewLabel_20.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_20.gridx = 0;
        gbc_lblNewLabel_20.gridy = 12;
        panel.add(lblNewLabel_20, gbc_lblNewLabel_20);
        
        textField_17.setBackground(new Color(255, 255, 255));
        textField_17.setEditable(false);
        GridBagConstraints gbc_textField_17 = new GridBagConstraints();
        gbc_textField_17.insets = new Insets(0, 0, 5, 5);
        gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_17.gridx = 1;
        gbc_textField_17.gridy = 12;
        panel.add(textField_17, gbc_textField_17);
        textField_17.setColumns(10);
        
        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.insets = new Insets(0, 0, 5, 5);
        gbc_panel_5.fill = GridBagConstraints.BOTH;
        gbc_panel_5.gridx = 1;
        gbc_panel_5.gridy = 13;
        panel.add(panel_5, gbc_panel_5);
        
        JLabel lblNewLabel = new JLabel("Postulante:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 14;
        panel.add(lblNewLabel, gbc_lblNewLabel);
        
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 14;
        panel.add(comboBox, gbc_comboBox);
        
        JLabel lblNewLabel_8 = new JLabel("CV Reducido:");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 15;
        panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
        gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_2.gridx = 1;
        gbc_scrollPane_2.gridy = 15;
        panel.add(scrollPane_2, gbc_scrollPane_2);
        
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        scrollPane_2.setViewportView(textArea_1);
        
        JLabel lblNewLabel_11 = new JLabel("Motivacion:");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 16;
        panel.add(lblNewLabel_11, gbc_lblNewLabel_11);
        
        JScrollPane scrollPane_3 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
        gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_3.gridx = 1;
        gbc_scrollPane_3.gridy = 16;
        panel.add(scrollPane_3, gbc_scrollPane_3);
        
        JTextArea textArea_2 = new JTextArea();
        textArea_2.setLineWrap(true);
        scrollPane_3.setViewportView(textArea_2);
        
        JLabel lblNewLabel_15 = new JLabel("Fecha de Postulacion:");
        GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
        gbc_lblNewLabel_15.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_15.gridx = 0;
        gbc_lblNewLabel_15.gridy = 17;
        panel.add(lblNewLabel_15, gbc_lblNewLabel_15);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.gridx = 1;
        gbc_panel_2.gridy = 17;
        panel.add(panel_2, gbc_panel_2);
        
        JLabel lblNewLabel_16 = new JLabel("Dia:");
        panel_2.add(lblNewLabel_16);
        
        textField_14 = new JTextField();
        panel_2.add(textField_14);
        textField_14.setColumns(10);
        
        JLabel lblNewLabel_17 = new JLabel("Mes:");
        panel_2.add(lblNewLabel_17);
        
        textField_15 = new JTextField();
        panel_2.add(textField_15);
        textField_15.setColumns(10);
        
        JLabel lblNewLabel_18 = new JLabel("Año:");
        panel_2.add(lblNewLabel_18);
        
        textField_16 = new JTextField();
        panel_2.add(textField_16);
        textField_16.setColumns(10);
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.gridwidth = 3;
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 0;
        gbc_panel_3.gridy = 18;
        panel.add(panel_3, gbc_panel_3);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JFrame frame = new JFrame("Ejemplo de Popup");
                frame.setSize(300, 150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		
    			try {
        			String ofertaFinal = comboBox_1.getSelectedItem().toString();
        			String postulanteFinal = comboBox.getSelectedItem().toString();
        			String motivacionFinal = textArea_1.getText();
        			String cvReducidoFinal = textArea_2.getText();
        			
        			
        		//	LocalDate fechaAlta = LocalDate.of(Integer.parseInt(textField_10.getText()),Integer.parseInt(textField_12.getText()), Integer.parseInt(textField_13.getText()));
        		//	LocalDate fechaVencimiento = fechaAlta.plusDays(Integer.parseInt(textField_17.getText()));
        			LocalDate fecha = LocalDate.of(Integer.parseInt(textField_16.getText()),Integer.parseInt(textField_15.getText()), Integer.parseInt(textField_14.getText())); // año mes dia
        			
        		//	if(fecha.isBefore(fechaVencimiento) || fecha.isAfter(fechaAlta)) {
        			//	throw new Exception("Fecha Invalida");
        		//	}

        			ico.altaPostulacion(postulanteFinal, ofertaFinal, cvReducidoFinal, motivacionFinal, fecha);
        			JOptionPane.showMessageDialog(frame, "La operacion se ah realizado con exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        			dispose();
        		} catch(ElementoRepetidoException e) {
        			JOptionPane.showMessageDialog(frame, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
        		} catch(NoExisteInstancia e) {
        			JOptionPane.showMessageDialog(frame, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
        		} catch(NullPointerException e) {
        			JOptionPane.showMessageDialog(frame, "Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        		} catch(NumberFormatException e) {
        			JOptionPane.showMessageDialog(frame, "Fecha Invalida", "Error", JOptionPane.ERROR_MESSAGE);
        		} catch(Exception e) {
        			if (e.getMessage() == "Fecha Invalida")
        				JOptionPane.showMessageDialog(frame, "Fecha Invalida", "Error", JOptionPane.ERROR_MESSAGE);
        			else
        				JOptionPane.showMessageDialog(frame, "Algo salio mal", "Error", JOptionPane.ERROR_MESSAGE);
        		}

        	}
        });
        panel_3.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cancelar");
        btnNewButton_1.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        panel_3.add(btnNewButton_1);
        
	} // termina constructor
	
	protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {

	}

}
