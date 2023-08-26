package presentacion;


import excepciones.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
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
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.DropMode;

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
		
	
	public PostulacionAOfertaLaboral(IControladorUsuario icu, IControladorOferta ico) {
		
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
        gbl_panel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0, 150, 150, 80, 0, 150, 150, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
        
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        
        if(listanickempresas.size() == 0) {
        	comboBox_0.addItem("");
        } else {
            for(int i = 0; i < listanickempresas.size(); i++)
            	comboBox_0.addItem(listanickempresas.get(i));
        }

        comboBox_0.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (comboBox_0.getSelectedItem() == "") {
        			// nada
        		} else {
        			String empresadelcombo = comboBox_0.getSelectedItem().toString();
        	        List<String> listanombreofertas = ico.listarOfertasByEmpresa(empresadelcombo);
        		}	
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
        
        textField_5 = new JTextField();
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
        
        textField_6 = new JTextField();
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
        
        textField_7 = new JTextField();
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
        
        textField_8 = new JTextField();
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
        
        textField_9 = new JTextField();
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
        
        textField_11 = new JTextField();
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
        
        JTextArea textArea = new JTextArea();
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
        
        JTextArea textArea_3 = new JTextArea();
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
        
        textField_10 = new JTextField();
        panel_1.add(textField_10);
        textField_10.setColumns(10);
        
        JLabel lblNewLabel_13 = new JLabel("Mes:");
        panel_1.add(lblNewLabel_13);
        
        textField_12 = new JTextField();
        panel_1.add(textField_12);
        textField_12.setColumns(10);
        
        JLabel lblNewLabel_14 = new JLabel("Año:");
        panel_1.add(lblNewLabel_14);
        
        textField_13 = new JTextField();
        panel_1.add(textField_13);
        textField_13.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Postulante:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 12;
        panel.add(lblNewLabel, gbc_lblNewLabel);
        
        JComboBox comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 12;
        panel.add(comboBox, gbc_comboBox);
        
        JLabel lblNewLabel_8 = new JLabel("CV Reducido:");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 13;
        panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
        gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_2.gridx = 1;
        gbc_scrollPane_2.gridy = 13;
        panel.add(scrollPane_2, gbc_scrollPane_2);
        
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        scrollPane_2.setViewportView(textArea_1);
        
        JLabel lblNewLabel_11 = new JLabel("Motivacion:");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 14;
        panel.add(lblNewLabel_11, gbc_lblNewLabel_11);
        
        JScrollPane scrollPane_3 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
        gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_3.gridx = 1;
        gbc_scrollPane_3.gridy = 14;
        panel.add(scrollPane_3, gbc_scrollPane_3);
        
        JTextArea textArea_2 = new JTextArea();
        textArea_2.setLineWrap(true);
        scrollPane_3.setViewportView(textArea_2);
        
        JLabel lblNewLabel_15 = new JLabel("Fecha de Postulacion:");
        GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
        gbc_lblNewLabel_15.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_15.gridx = 0;
        gbc_lblNewLabel_15.gridy = 15;
        panel.add(lblNewLabel_15, gbc_lblNewLabel_15);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.gridx = 1;
        gbc_panel_2.gridy = 15;
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
        gbc_panel_3.gridy = 16;
        panel.add(panel_3, gbc_panel_3);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
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
