package presentacion;

import javax.swing.JInternalFrame;

import logica.entidades.Empresa;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearOfertaLaboral extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	private IControladorUsuario ctrlUsuario;
	private JTextField textNombreOferta;
	private JTextField textDescripcion;
	private JTextField textHorario;
	private JTextField textRemuneracion;
	private JTextField textCiudad;
	private JTextField textDepartamento;
	private JTextField textFecha;
	
	public CrearOfertaLaboral(IControladorOferta cop, IControladorUsuario cus) {
		ctrlOferta = cop;	
		ctrlUsuario = cus;
		
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Crear Oferta Laboral");
        setBounds(10, 40, 700, 700);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{300, 300};
        gridBagLayout.rowHeights = new int[]{35, 35, 35, 35, 35, 30, 35, 35, 35, 35, 35, 35};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        // ####################### Fila 1 ###############################
        JLabel lblEmpresa = new JLabel("Seleccionar empresa");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpresa.fill = GridBagConstraints.VERTICAL;
        gbc_lblEmpresa.gridx = 0;
        gbc_lblEmpresa.gridy = 0;
        getContentPane().add(lblEmpresa, gbc_lblEmpresa);
        
        JComboBox<String> comboBoxEmpresa = new JComboBox<String>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.VERTICAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        getContentPane().add(comboBoxEmpresa, gbc_comboBox);
        
        // Datos de prueba
        List<String> list = ctrlUsuario.listarNickEmpresas();
        list.add("empresa1");
        list.add("empresa2");
        for(int i = 0; i <= list.size() - 1; i++) {
        	comboBoxEmpresa.addItem(list.get(i));
        }
        //################################################################
        
        //######################### Fila 2 #############################
        
        JLabel lblTipoPublicacion = new JLabel("Seleccionar tipo de publicacion");
        GridBagConstraints gbc_lblTipoPublicacion = new GridBagConstraints();
        gbc_lblTipoPublicacion.anchor = GridBagConstraints.EAST;
        gbc_lblTipoPublicacion.fill = GridBagConstraints.VERTICAL;
        gbc_lblTipoPublicacion.insets = new Insets(0, 0, 5, 5);
        gbc_lblTipoPublicacion.gridx = 0;
        gbc_lblTipoPublicacion.gridy = 1;
        getContentPane().add(lblTipoPublicacion, gbc_lblTipoPublicacion);
        
        JComboBox comboBoxTipoPublicacion = new JComboBox();
        GridBagConstraints gbc_comboBoxTipoPublicacion = new GridBagConstraints();
        gbc_comboBoxTipoPublicacion.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxTipoPublicacion.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxTipoPublicacion.gridx = 1;
        gbc_comboBoxTipoPublicacion.gridy = 1;
        getContentPane().add(comboBoxTipoPublicacion , gbc_comboBoxTipoPublicacion);
        comboBoxTipoPublicacion.addItem("tipo1");
        comboBoxTipoPublicacion.addItem("tipo2");
        
        
      //######################### Fila 3 #############################
        JLabel lblNewLabel = new JLabel("Nombre de la oferta");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 2;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        textNombreOferta = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 2;
        getContentPane().add(textNombreOferta, gbc_textField);
        textNombreOferta.setColumns(10);
        
      //######################### Fila 4 #############################
        JLabel lblNewLabel_1 = new JLabel("Descripcion");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 3;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        
        textDescripcion = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 3;
        getContentPane().add(textDescripcion, gbc_textField_1);
        textDescripcion.setColumns(10);
        
      //######################### Fila 5 #############################
        JLabel lblNewLabel_2 = new JLabel("Horario");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 4;
        getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textHorario = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 4;
        getContentPane().add(textHorario, gbc_textField_2);
        textHorario.setColumns(10);
        
      //######################### Fila 6 #############################
        JLabel lblNewLabel_3 = new JLabel("Remunieracion");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 5;
        getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textRemuneracion = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 1;
        gbc_textField_3.gridy = 5;
        getContentPane().add(textRemuneracion, gbc_textField_3);
        textRemuneracion.setColumns(10);
        
      //######################### Fila 7 #############################
        JLabel lblNewLabel_4 = new JLabel("Ciudad");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 6;
        getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textCiudad = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 0);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 1;
        gbc_textField_4.gridy = 6;
        getContentPane().add(textCiudad, gbc_textField_4);
        textCiudad.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Departamento");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 7;
        getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textDepartamento = new JTextField();
        GridBagConstraints gbc_textField1 = new GridBagConstraints();
        gbc_textField1.insets = new Insets(0, 0, 5, 0);
        gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField1.gridx = 1;
        gbc_textField1.gridy = 7;
        getContentPane().add(textDepartamento, gbc_textField1);
        textDepartamento.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Fecha");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 8;
        getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFecha = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 0, 5, 0);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 1;
        gbc_textField_5.gridy = 8;
        getContentPane().add(textFecha, gbc_textField_5);
        textFecha.setColumns(10);
        
        List<String> listKeywords = List.of("");
        JLabel lblNewLabel_7 = new JLabel("Keywords");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 9;
        getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        JComboBox comboBox_1 = new JComboBox();
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 1;
        gbc_comboBox_1.gridy = 9;
        getContentPane().add(comboBox_1, gbc_comboBox_1);
        
        JButton btnAceptar = new JButton("Aceptar");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 10;
        getContentPane().add(btnAceptar, gbc_btnNewButton_1);
        
        JButton btnNewButton = new JButton("Cancelar");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 10;
        getContentPane().add(btnNewButton, gbc_btnNewButton);    
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
					Date fecha = new Date();
					
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
					
				}  catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
        });
        
	}
	
}
