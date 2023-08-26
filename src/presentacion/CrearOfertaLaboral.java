package presentacion;

import javax.swing.JInternalFrame;

import logica.entidades.Empresa;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.awt.TextArea;

public class CrearOfertaLaboral extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	private IControladorUsuario ctrlUsuario;
	private IControladorCompraTipo ctrlTipo;
	private JTextField textNombreOferta;
	private JTextField textHorario;
	private JTextField textRemuneracion;
	private JTextField textCiudad;
	private JTextField textDepartamento;
	private JTextField textFecha;
	
	public CrearOfertaLaboral(IControladorOferta cop, IControladorUsuario cus, IControladorCompraTipo cct) {
		ctrlOferta = cop;	
		ctrlUsuario = cus;
		ctrlTipo = cct;
        List<String> listaEmpresas = ctrlUsuario.listarNickEmpresas();
        List<String> listaTipos = ctrlTipo.listarTiposPublicacion();
        
        if(listaEmpresas.size() == 0) {
        	// error
        }
        
        if(listaEmpresas.size() == 0) {
        	// error
        }

		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Crear Oferta Laboral");
        setBounds(10, 40, 750, 600);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{140, 210, 200, 150};
        gridBagLayout.rowHeights = new int[]{30, 30, 30, 90, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        // ####################### Fila 1 ###############################
        JLabel lblEmpresa = new JLabel("Seleccionar empresa");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.anchor = GridBagConstraints.WEST;
        gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpresa.fill = GridBagConstraints.VERTICAL;
        gbc_lblEmpresa.gridx = 1;
        gbc_lblEmpresa.gridy = 0;
        getContentPane().add(lblEmpresa, gbc_lblEmpresa);
        
        JComboBox<String> comboBoxEmpresa = new JComboBox<String>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 30, 5, 30);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 0;
        getContentPane().add(comboBoxEmpresa, gbc_comboBox);
        
        if(listaEmpresas.size() > 0) {
            for(int i = 0; i <= listaEmpresas.size() - 1; i++) {
            	comboBoxEmpresa.addItem(listaEmpresas.get(i));
            }
        }

        
        //################################################################
        
        //######################### Fila 2 #############################
        JLabel lblTipoPublicacion = new JLabel("Seleccionar tipo de publicacion");
        GridBagConstraints gbc_lblTipoPublicacion = new GridBagConstraints();
        gbc_lblTipoPublicacion.anchor = GridBagConstraints.WEST;
        gbc_lblTipoPublicacion.fill = GridBagConstraints.VERTICAL;
        gbc_lblTipoPublicacion.insets = new Insets(0, 0, 5, 5);
        gbc_lblTipoPublicacion.gridx = 1;
        gbc_lblTipoPublicacion.gridy = 1;
        getContentPane().add(lblTipoPublicacion, gbc_lblTipoPublicacion);
        
        JComboBox<String> comboBoxTipoPublicacion = new JComboBox<String>();
        GridBagConstraints gbc_comboBoxTipoPublicacion = new GridBagConstraints();
        gbc_comboBoxTipoPublicacion.insets = new Insets(0, 30, 5, 30);
        gbc_comboBoxTipoPublicacion.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxTipoPublicacion.gridx = 2;
        gbc_comboBoxTipoPublicacion.gridy = 1;
        getContentPane().add(comboBoxTipoPublicacion , gbc_comboBoxTipoPublicacion);
        if (listaTipos.size() > 0) {
            for(int i = 0; i <= listaTipos.size() - 1; i++) {
            	comboBoxTipoPublicacion.addItem(listaTipos.get(i));
            }
        } else {

        }

      //######################### Fila 3 #############################
        JLabel lblNewLabel = new JLabel("Nombre de la oferta");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 2;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        textNombreOferta = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 30, 5, 30);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 2;
        getContentPane().add(textNombreOferta, gbc_textField);
        textNombreOferta.setColumns(10);
		
      //######################### Fila 4 #############################
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
        
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textDescripcion);
		
		
      //######################### Fila 5 #############################
        JLabel lblNewLabel_2 = new JLabel("Horario");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 4;
        getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textHorario = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 30, 5, 30);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 4;
        getContentPane().add(textHorario, gbc_textField_2);
        textHorario.setColumns(10);

        

      //######################### Fila 6 #############################
        JLabel lblNewLabel_3 = new JLabel("Remuneracion");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 5;
        getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textRemuneracion = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 30, 5, 30);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 5;
        getContentPane().add(textRemuneracion, gbc_textField_3);
        textRemuneracion.setColumns(10);
        
      //######################### Fila 7 #############################
        JLabel lblNewLabel_4 = new JLabel("Ciudad");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 6;
        getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textCiudad = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 30, 5, 30);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 2;
        gbc_textField_4.gridy = 6;
        getContentPane().add(textCiudad, gbc_textField_4);
        textCiudad.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Departamento");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 7;
        getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textDepartamento = new JTextField();
        GridBagConstraints gbc_textField1 = new GridBagConstraints();
        gbc_textField1.insets = new Insets(0, 30, 5, 30);
        gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField1.gridx = 2;
        gbc_textField1.gridy = 7;
        getContentPane().add(textDepartamento, gbc_textField1);
        textDepartamento.setColumns(10);
        
        
        JLabel lblNewLabel_6 = new JLabel("Fecha");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 8;
        getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFecha = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 30, 5, 30);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 2;
        gbc_textField_5.gridy = 8;
        getContentPane().add(textFecha, gbc_textField_5);
        textFecha.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Keywords");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 1;
        gbc_lblNewLabel_7.gridy = 9;
        getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        
        // Keywords
        List<String> listKeywords = ctrlOferta.listarKeywords();
        JComboBox<String> comboKeywords = new JComboBox();
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.insets = new Insets(0, 30, 5, 30);
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 2;
        gbc_comboBox_1.gridy = 9;
        getContentPane().add(comboKeywords, gbc_comboBox_1);
        if(listKeywords.size() > 0) {
        	for(int i = 0; i <= listKeywords.size()-1; i++) {
        		comboKeywords.addItem(listKeywords.get(i));
        	}
        }
        
        JButton btnAgregarKeyword = new JButton("Agregar");
        GridBagConstraints gbc_btnAgregarKeyword = new GridBagConstraints();
        gbc_btnAgregarKeyword.insets = new Insets(10, 10, 10, 10);
        gbc_btnAgregarKeyword.gridx = 2;
        gbc_btnAgregarKeyword.gridy = 10;
        getContentPane().add(btnAgregarKeyword, gbc_btnAgregarKeyword);
        gbc_btnAgregarKeyword.insets = new Insets(0, 0, 5, 5);
        gbc_btnAgregarKeyword.anchor = GridBagConstraints.WEST;
        gbc_btnAgregarKeyword.gridx = 1;
        gbc_btnAgregarKeyword.gridy = 11;
        btnAgregarKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listKeywords.add(comboKeywords.getSelectedItem().toString()); 				
				System.out.println(comboKeywords.getSelectedItem().toString() + "agregada");
			}
        });
        
        
        
        JButton btnAceptar = new JButton("Aceptar");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 11;
        getContentPane().add(btnAceptar, gbc_btnNewButton_1);
        // ###############################################################
        
        
        // Se crea la oferta a darle aceptar
        btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombreOferta = textNombreOferta.getText();
					String descripcion = textDescripcion.getText();
					String horario = textHorario.getText();
				
					float remuneracion = Float.parseFloat(textRemuneracion.getText());
					
					String ciudad = textCiudad.getText();
					String departamento = textDepartamento.getText();
					LocalDate fecha = LocalDate.of(2000, 1 , 1);
					
					ctrlOferta.altaOfertaLaboral(
							comboBoxEmpresa.getSelectedItem().toString(), 
							comboBoxTipoPublicacion.getSelectedItem().toString(), 
							nombreOferta,
							descripcion,
							horario,
							remuneracion,
							ciudad,
							departamento,
							fecha,
							listKeywords
					);
					
					System.out.println("oferta creada");
					
					dispose();
				}  catch(NumberFormatException ex) {

				}
			}
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 11;
        getContentPane().add(btnCancelar, gbc_btnCancelar);    
        
		btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				dispose();
        	}
        });
    }
		
}
