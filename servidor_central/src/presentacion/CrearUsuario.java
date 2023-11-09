package presentacion;

import javax.swing.JInternalFrame;

import logica.interfaces.IControladorUsuario;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import com.toedter.calendar.JCalendar;

import excepciones.CamposVaciosExcepcion;
import excepciones.UsuarioRepetidoException;
import javax.swing.JButton;
import javax.swing.JTextArea;
public class CrearUsuario extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorUsuario icu;
	private JTextField nicknameField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField emailField;
	private JTextField linkField;
	private JTextField nacionalidadField;
	String TipoUsuario = "";
	private JTextField contraseñaField;
	
	public CrearUsuario(IControladorUsuario cu) {
		icu = cu;	
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Alta de Usuario");
        setBounds(10, 40, 1082, 609);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel NorthPanel = new JPanel();
        getContentPane().add(NorthPanel, BorderLayout.NORTH);
        GridBagLayout gbl_NorthPanel = new GridBagLayout();
        gbl_NorthPanel.columnWidths = new int[] {100, 150, 250, 150, 4};
        gbl_NorthPanel.rowHeights = new int[]{50, 0, 0, 0, 0, 0, 0, 0};
        gbl_NorthPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_NorthPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        NorthPanel.setLayout(gbl_NorthPanel);
        
        JLabel TipoUsuarioText = new JLabel("Seleccione el Tipo de Usuario:");
        TipoUsuarioText.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_TipoUsuarioText = new GridBagConstraints();
        gbc_TipoUsuarioText.anchor = GridBagConstraints.EAST;
        gbc_TipoUsuarioText.insets = new Insets(0, 0, 5, 5);
        gbc_TipoUsuarioText.gridx = 1;
        gbc_TipoUsuarioText.gridy = 1;
        NorthPanel.add(TipoUsuarioText, gbc_TipoUsuarioText);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 2;
        gbc_panel.gridy = 1;
        NorthPanel.add(panel, gbc_panel);
        
        JRadioButton EmpresaButton = new JRadioButton("Empresa");
        panel.add(EmpresaButton);
        
        JRadioButton PostulanteButton = new JRadioButton("Postulante");
        panel.add(PostulanteButton);
        

        
        JLabel nickText = new JLabel("Nickname:");
        nickText.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_nickText = new GridBagConstraints();
        gbc_nickText.anchor = GridBagConstraints.EAST;
        gbc_nickText.insets = new Insets(0, 0, 5, 5);
        gbc_nickText.gridx = 1;
        gbc_nickText.gridy = 2;
        NorthPanel.add(nickText, gbc_nickText);
        
        nicknameField = new JTextField();
        GridBagConstraints gbc_nicknameField = new GridBagConstraints();
        gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
        gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nicknameField.gridx = 2;
        gbc_nicknameField.gridy = 2;
        NorthPanel.add(nicknameField, gbc_nicknameField);
        nicknameField.setColumns(10);
        
        JLabel nombreText = new JLabel("Nombre:");
        GridBagConstraints gbc_nombreText = new GridBagConstraints();
        gbc_nombreText.anchor = GridBagConstraints.EAST;
        gbc_nombreText.insets = new Insets(0, 0, 5, 5);
        gbc_nombreText.gridx = 1;
        gbc_nombreText.gridy = 3;
        NorthPanel.add(nombreText, gbc_nombreText);
        
        nombreField = new JTextField();
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 2;
        gbc_nombreField.gridy = 3;
        NorthPanel.add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);
        
        JLabel apellidoText = new JLabel("Apellido:");
        GridBagConstraints gbc_apellidoText = new GridBagConstraints();
        gbc_apellidoText.anchor = GridBagConstraints.EAST;
        gbc_apellidoText.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoText.gridx = 1;
        gbc_apellidoText.gridy = 4;
        NorthPanel.add(apellidoText, gbc_apellidoText);
        
        apellidoField = new JTextField();
        GridBagConstraints gbc_apellidoField = new GridBagConstraints();
        gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidoField.gridx = 2;
        gbc_apellidoField.gridy = 4;
        NorthPanel.add(apellidoField, gbc_apellidoField);
        apellidoField.setColumns(10);
        
        JLabel contraseniaText = new JLabel("Password:");
        GridBagConstraints gbc_contraseniaText = new GridBagConstraints();
        gbc_contraseniaText.anchor = GridBagConstraints.EAST;
        gbc_contraseniaText.insets = new Insets(0, 0, 5, 5);
        gbc_contraseniaText.gridx = 1;
        gbc_contraseniaText.gridy = 5;
        contraseniaText.setVisible(true);
        NorthPanel.add(contraseniaText, gbc_contraseniaText);
        
        contraseñaField = new JTextField();
        contraseñaField.setColumns(10);
        GridBagConstraints gbc_contraseñaField = new GridBagConstraints();
        gbc_contraseñaField.insets = new Insets(0, 0, 5, 5);
        gbc_contraseñaField.fill = GridBagConstraints.HORIZONTAL;
        gbc_contraseñaField.gridx = 2;
        gbc_contraseñaField.gridy = 5;
        contraseñaField.setVisible(true);
        NorthPanel.add(contraseñaField, gbc_contraseñaField);
        
        JLabel emailText = new JLabel("Email:");
        GridBagConstraints gbc_emailText = new GridBagConstraints();
        gbc_emailText.anchor = GridBagConstraints.EAST;
        gbc_emailText.insets = new Insets(0, 0, 0, 5);
        gbc_emailText.gridx = 1;
        gbc_emailText.gridy = 6;
        NorthPanel.add(emailText, gbc_emailText);
        
        emailField = new JTextField();
        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.insets = new Insets(0, 0, 0, 5);
        gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailField.gridx = 2;
        gbc_emailField.gridy = 6;
        NorthPanel.add(emailField, gbc_emailField);
        emailField.setColumns(10);
        
        JPanel CenterPanel = new JPanel();
        getContentPane().add(CenterPanel, BorderLayout.CENTER);
        CenterPanel.setLayout(new BorderLayout(0, 0));
        JPanel postulantePanel = new JPanel();
        CenterPanel.add(postulantePanel, BorderLayout.NORTH);
        GridBagLayout gbl_postulantePanel = new GridBagLayout();
        gbl_postulantePanel.columnWidths = new int[]{100, 150, 250, 130, 0};
        gbl_postulantePanel.rowHeights = new int[]{5, 0, 170, 0, 0};
        gbl_postulantePanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_postulantePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        postulantePanel.setLayout(gbl_postulantePanel);
        
        
        JPanel empresaPanel = new JPanel();
        getContentPane().add(empresaPanel, BorderLayout.WEST);
        GridBagLayout gdbEmpresa = new GridBagLayout();
        gdbEmpresa.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
        gdbEmpresa.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
        gdbEmpresa.columnWidths = new int[] {220, 150, 250, 100};
        gdbEmpresa.rowHeights = new int[]{5, 0, 170, 0};
        empresaPanel.setLayout(gdbEmpresa);
        
        empresaPanel.setVisible(false);
        postulantePanel.setVisible(false);



                PostulanteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	TipoUsuario = "Postulante";
                    	postulantePanel.setVisible(true);
                    	empresaPanel.setVisible(false);
                        EmpresaButton.setSelected(false);
                    }
                });
        
        
        
                EmpresaButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                    	TipoUsuario = "Empresa";
                        empresaPanel.setVisible(true);
                        postulantePanel.setVisible(false);
                        PostulanteButton.setSelected(false);  
                        //empresaPanel.setSize(225,225);
                    }
                });
        
        postulantePanel.setBounds(3, 3, 450, 250);
        empresaPanel.setBounds(3, 3, 450, 250);
        
        JLabel linkText = new JLabel("Link:");
        GridBagConstraints gbc_linkText = new GridBagConstraints();
        gbc_linkText.anchor = GridBagConstraints.EAST;
        gbc_linkText.insets = new Insets(0, 0, 5, 5);
        gbc_linkText.gridx = 1;
        gbc_linkText.gridy = 1;
        empresaPanel.add(linkText, gbc_linkText);
        
        linkField = new JTextField();
        GridBagConstraints gbc_linkField = new GridBagConstraints();
        gbc_linkField.insets = new Insets(0, 0, 5, 5);
        gbc_linkField.fill = GridBagConstraints.HORIZONTAL;
        gbc_linkField.gridx = 2;
        gbc_linkField.gridy = 1;
        empresaPanel.add(linkField, gbc_linkField);
        linkField.setColumns(10);
        
        JLabel descripcionText = new JLabel("Descripcion:");
        descripcionText.setFont(new Font("Tahoma", Font.PLAIN, 11));
        descripcionText.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_descripcionText = new GridBagConstraints();
        gbc_descripcionText.anchor = GridBagConstraints.NORTHEAST;
        gbc_descripcionText.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionText.gridx = 1;
        gbc_descripcionText.gridy = 2;
        empresaPanel.add(descripcionText, gbc_descripcionText);
        GridBagConstraints gbc_descripcionArea_1_1 = new GridBagConstraints();
        gbc_descripcionArea_1_1.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionArea_1_1.fill = GridBagConstraints.BOTH;
        gbc_descripcionArea_1_1.gridx = 2;
        gbc_descripcionArea_1_1.gridy = 2;
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(250, 150));
        empresaPanel.add(scrollPane, gbc_descripcionArea_1_1);
        
        JTextArea descripcionArea = new JTextArea();
        scrollPane.setViewportView(descripcionArea);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        
        JLabel lblNewLabel = new JLabel("Nacionalidad:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        postulantePanel.add(lblNewLabel, gbc_lblNewLabel);
        
        nacionalidadField = new JTextField();
        GridBagConstraints gbc_nacionalidadField = new GridBagConstraints();
        gbc_nacionalidadField.insets = new Insets(0, 0, 5, 5);
        gbc_nacionalidadField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nacionalidadField.gridx = 2;
        gbc_nacionalidadField.gridy = 1;
        postulantePanel.add(nacionalidadField, gbc_nacionalidadField);
        nacionalidadField.setColumns(10);
        JLabel nacimientoText = new JLabel("Fecha de Nacimiento:");
        GridBagConstraints gbc_nacimientoText = new GridBagConstraints();
        gbc_nacimientoText.anchor = GridBagConstraints.NORTHEAST;
        gbc_nacimientoText.insets = new Insets(0, 0, 5, 5);
        gbc_nacimientoText.gridx = 1;
        gbc_nacimientoText.gridy = 2;
        postulantePanel.add(nacimientoText, gbc_nacimientoText);
        
        JCalendar calendar = new JCalendar();
        GridBagConstraints gbc_calendar = new GridBagConstraints();
        gbc_calendar.insets = new Insets(0, 0, 5, 5);
        gbc_calendar.fill = GridBagConstraints.BOTH;
        gbc_calendar.gridx = 2;
        gbc_calendar.gridy = 2;
        postulantePanel.add(calendar, gbc_calendar);
        
        JPanel SouthPanel1 = new JPanel();
        getContentPane().add(SouthPanel1, BorderLayout.SOUTH);
        
        JPanel CancelConfirmPanel = new JPanel();
        SouthPanel1.add(CancelConfirmPanel);
        
        JButton ConfirmarButton = new JButton("Confirmar");
        CancelConfirmPanel.add(ConfirmarButton);
        
        JButton CancelarButton = new JButton("Cancelar");
        CancelConfirmPanel.add(CancelarButton);
        
        CancelarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        
        ConfirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		if (contraseñaField.getText().isEmpty()) {
                       	throw new CamposVaciosExcepcion("Ingrese una contraseña");
            		}
            		if (TipoUsuario.equals("Postulante") && nacionalidadField.getText().isEmpty()) {
                       	throw new CamposVaciosExcepcion("Ingrese la nacionalidad");
            		}
                    if (TipoUsuario.equals("Empresa")) {
                        icu.crearEmpresa(nicknameField.getText(), nombreField.getText(), apellidoField.getText(), emailField.getText(),contraseñaField.getText(),"", descripcionArea.getText(), linkField.getText());
                    } else if (TipoUsuario.equals("Postulante")) {
                    	Date fechaInput = calendar.getDate();
                    	LocalDate fecha = fechaInput.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        icu.crearPostulante(nicknameField.getText(), nombreField.getText(), apellidoField.getText(), emailField.getText(),contraseñaField.getText(),"", nacionalidadField.getText(), fecha );
                    }
                    
                    if (TipoUsuario.isEmpty()) {
                    	throw new CamposVaciosExcepcion("Seleccione tipo de usuario");
                    }
                    JOptionPane.showMessageDialog(CrearUsuario.this, "Usuario creado exitosamente");
                    
                   
                    dispose();
                } catch (UsuarioRepetidoException ex) {
                    JOptionPane.showMessageDialog(CrearUsuario.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            	catch (CamposVaciosExcepcion ex) {
                    JOptionPane.showMessageDialog(CrearUsuario.this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
	}


 }
