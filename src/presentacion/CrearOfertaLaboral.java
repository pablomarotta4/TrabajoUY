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
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;

import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.awt.TextArea;

public class CrearOfertaLaboral extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	private IControladorUsuario ctrlUsuario;
	private IControladorCompraTipo ctrlTipo;
	private JTextField textNombreOferta;
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
        gridBagLayout.columnWidths = new int[]{50, 170, 200, 50};
        gridBagLayout.rowHeights = new int[]{30, 30, 30, 90, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 0;
        getContentPane().add(panel_2, gbc_panel_2);
        
        // ####################### Fila 1 ###############################
        JLabel lblEmpresa = new JLabel("Seleccionar empresa");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
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
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 0);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 3;
        gbc_panel_1.gridy = 0;
        getContentPane().add(panel_1, gbc_panel_1);

        
        //################################################################
        
        //######################### Fila 2 #############################
        JLabel lblTipoPublicacion = new JLabel("Seleccionar tipo de publicacion");
        GridBagConstraints gbc_lblTipoPublicacion = new GridBagConstraints();
        gbc_lblTipoPublicacion.anchor = GridBagConstraints.EAST;
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
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 2;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        textNombreOferta = new JTextField();
        textNombreOferta.setText("");
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
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
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
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 4;
        getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        JPanel panelHorario = new JPanel();
        GridBagConstraints gbc_panelHorario = new GridBagConstraints();
        gbc_panelHorario.anchor = GridBagConstraints.WEST;
        gbc_panelHorario.insets = new Insets(0, 0, 5, 5);
        gbc_panelHorario.gridx = 2;
        gbc_panelHorario.gridy = 4;
        gbc_panelHorario.fill = GridBagConstraints.HORIZONTAL;
        panelHorario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel entrada = new JLabel("Entrada");
        JTextField textEntrada = new JTextField();
        textEntrada.setColumns(3);
        JLabel salida = new JLabel("Salida");
        JTextField textSalida = new JTextField();
        textSalida.setColumns(3);
        panelHorario.add(entrada);
        panelHorario.add(textEntrada);
        panelHorario.add(salida);
        panelHorario.add(textSalida);
        getContentPane().add(panelHorario, gbc_panelHorario);


      //######################### Fila 6 #############################
        JLabel lblNewLabel_3 = new JLabel("Remuneracion");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
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
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
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
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
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
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 8;
        getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        JPanel panelFecha = new JPanel();
        GridBagConstraints gbc_panelFecha = new GridBagConstraints();
        gbc_panelFecha.anchor = GridBagConstraints.WEST;
        gbc_panelFecha.insets = new Insets(0, 0, 5, 5);
        gbc_panelFecha.gridx = 2;
        gbc_panelFecha.gridy = 8;
        gbc_panelFecha.fill = GridBagConstraints.HORIZONTAL;
        
        panelFecha.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel dia = new JLabel("Dia");
        JTextField textDia =new JTextField();
        textDia.setColumns(3);
        JLabel mes = new JLabel("Mes");
        JTextField textMes = new JTextField();
        textMes.setColumns(3);
        JLabel year = new JLabel("Año");
        JTextField textYear = new JTextField();
        textYear.setColumns(3);
        panelFecha.add(dia);
        panelFecha.add(textDia);
        panelFecha.add(mes);
        panelFecha.add(textMes);
        panelFecha.add(year);
        panelFecha.add(textYear);
        getContentPane().add(panelFecha, gbc_panelFecha);
        
        JLabel lblNewLabel_7 = new JLabel("Keywords");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
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
        List<String> selectedKeywords = new ArrayList<String>();
        btnAgregarKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Popup");
				try {
					if(comboBoxEmpresa.getSelectedItem() == null || comboBoxTipoPublicacion.getSelectedItem() == null ||
							comboBoxEmpresa.getSelectedItem().toString() == "" || comboBoxTipoPublicacion.getSelectedItem().toString() == "") {
						throw new Exception("noEmpNoTipo");
					} else if (textNombreOferta.getText().equals("")) {
						throw new Exception("noOferta");
						
					} else {
						selectedKeywords.add(comboKeywords.getSelectedItem().toString()); 
					
						JOptionPane.showMessageDialog(
								frame,
								"Keyword añadida con éxito!",
								"Éxito",
								JOptionPane.INFORMATION_MESSAGE
								);
					}
				
				} catch(Exception ex) {
					if (ex.getMessage() == "noEmpNoTipo") {
						JOptionPane.showMessageDialog(
								frame,
								"Seleccione Empresa y Tipo de Publicacion",
								"Error",
								JOptionPane.ERROR_MESSAGE );
					} else if(ex.getMessage() == "noOferta") {
						JOptionPane.showMessageDialog(
								frame,
								"No existe oferta a la cual agregarle la keyword",
								"Error",
								JOptionPane.ERROR_MESSAGE
								);
					}
				}
			}
        });
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 2;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.VERTICAL;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 11;
        getContentPane().add(panel, gbc_panel);
        
        
        
        JButton btnAceptar = new JButton("Aceptar");
        panel.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar);
        
		btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				dispose();
        	}
        });
        // ###############################################################
        
        
        // Se crea la oferta a darle aceptar
        btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		JFrame frame = new JFrame("Popup");
				try {

					String nombreOferta = textNombreOferta.getText();
					String descripcion = textDescripcion.getText();
					
					String horaEntrada = textEntrada.getText();
					String horaSalida = textSalida.getText();
					String horario = horaEntrada + " - " + horaSalida;
					
					float remuneracion = Float.parseFloat(textRemuneracion.getText());
					String ciudad = textCiudad.getText();
					String departamento = textDepartamento.getText();
					
					Integer dia = Integer.parseInt(textDia.getText());
					Integer mes = Integer.parseInt(textMes.getText());
					Integer year = Integer.parseInt(textYear.getText());
					LocalDate fecha = LocalDate.of(year, mes , dia);
					
					boolean algunCampoVacio = nombreOferta.isEmpty() || descripcion.isEmpty() || horaEntrada.isEmpty() || horaSalida.isEmpty() ||
							textRemuneracion.getText().isEmpty() || ciudad.isEmpty() || departamento.isEmpty() ||
							textDia.getText().isEmpty() || textMes.getText().isEmpty() || textYear.getText().isEmpty() ;
					
					if(algunCampoVacio) {
						throw new CamposVaciosExcepcion("Complete todos los campos");
					}
					
					if(remuneracion < 0) {
						throw new ElementoInexistenteException("RemuneracionInvalida");
						
					}
					
					if(comboBoxEmpresa.getSelectedItem() == null || comboBoxTipoPublicacion.getSelectedItem() == null ||
						comboBoxEmpresa.getSelectedItem().toString() == "" || comboBoxTipoPublicacion.getSelectedItem().toString() == "") {
						throw new ElementoInexistenteException("noEmpNoTipo");
					}
 							
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
							"",
							selectedKeywords
					);
					
      				JOptionPane.showMessageDialog(
    						frame,
    						"Oferta creada con éxito!",
    						"Éxito",
    						JOptionPane.INFORMATION_MESSAGE
						);
					dispose();
				} catch(ElementoRepetidoException ex) {
      				JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
					);
				} catch(ElementoInexistenteException ex) {
					if (ex.getMessage() == "RemuneracionInvalida") {
						JOptionPane.showMessageDialog(
								frame,
	    						"Remuneracion invalida",
	    						"Error",
	    						JOptionPane.ERROR_MESSAGE );
					} else if (ex.getMessage() == "noEmpNoTipo") {
						JOptionPane.showMessageDialog(
								frame,
	    						"Seleccione Empresa y Tipo de Publicacion",
	    						"Error",
	    						JOptionPane.ERROR_MESSAGE );
						
					} else

      				JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
					);
				} catch(CamposVaciosExcepcion ex) {
      				JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
					);
				} catch(NumberFormatException ex) {
      				JOptionPane.showMessageDialog(
    						frame,
    						"Formato incorrecto",
    						"Error",
    						JOptionPane.ERROR_MESSAGE
					);
				} catch(DateTimeException ex) {
					JOptionPane.showMessageDialog(
    						frame,
    						"Fecha invalida. Ingrese denuevo.",
    						"Error",
    						JOptionPane.ERROR_MESSAGE
					);
				}
				
			}
        });
    }
		
}
