package presentacion;

import javax.swing.JInternalFrame;

import logica.interfaces.IControladorUsuario;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import com.toedter.calendar.JCalendar;

import excepciones.CamposVaciosExcepcion;
import excepciones.UsuarioRepetidoException;
import javax.swing.JButton;
import java.util.Date;

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
	
	public CrearUsuario(IControladorUsuario cu) {
		icu = cu;	
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Crear Usuario");
        setBounds(10, 40, 1082, 609);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel NorthPanel = new JPanel();
        getContentPane().add(NorthPanel, BorderLayout.NORTH);
        GridBagLayout gbl_NorthPanel = new GridBagLayout();
        gbl_NorthPanel.columnWidths = new int[] {30, 71, 90, 90, 90, 29, 35, 4};
        gbl_NorthPanel.rowHeights = new int[]{40, 36, 36, 36, 0};
        gbl_NorthPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_NorthPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        NorthPanel.setLayout(gbl_NorthPanel);
        
        JLabel TipoUsuarioText = new JLabel("Seleccione tipo de usuario: ");
        TipoUsuarioText.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_TipoUsuarioText = new GridBagConstraints();
        gbc_TipoUsuarioText.anchor = GridBagConstraints.WEST;
        gbc_TipoUsuarioText.gridwidth = 2;
        gbc_TipoUsuarioText.insets = new Insets(0, 0, 5, 5);
        gbc_TipoUsuarioText.gridx = 1;
        gbc_TipoUsuarioText.gridy = 0;
        NorthPanel.add(TipoUsuarioText, gbc_TipoUsuarioText);
        
        JRadioButton EmpresaButton = new JRadioButton("Empresa");
        GridBagConstraints gbc_EmpresaButton = new GridBagConstraints();
        gbc_EmpresaButton.insets = new Insets(0, 0, 5, 5);
        gbc_EmpresaButton.gridx = 3;
        gbc_EmpresaButton.gridy = 0;
        NorthPanel.add(EmpresaButton, gbc_EmpresaButton);
        
        JRadioButton PostulanteButton = new JRadioButton("Postulante");
        GridBagConstraints gbc_PostulanteButton = new GridBagConstraints();
        gbc_PostulanteButton.insets = new Insets(0, 0, 5, 5);
        gbc_PostulanteButton.gridx = 4;
        gbc_PostulanteButton.gridy = 0;
        NorthPanel.add(PostulanteButton, gbc_PostulanteButton);
        
        JLabel nickText = new JLabel("Nickname:");
        nickText.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_nickText = new GridBagConstraints();
        gbc_nickText.anchor = GridBagConstraints.WEST;
        gbc_nickText.insets = new Insets(0, 0, 5, 5);
        gbc_nickText.gridx = 1;
        gbc_nickText.gridy = 1;
        NorthPanel.add(nickText, gbc_nickText);
        
        nicknameField = new JTextField();
        GridBagConstraints gbc_nicknameField = new GridBagConstraints();
        gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
        gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nicknameField.gridx = 2;
        gbc_nicknameField.gridy = 1;
        NorthPanel.add(nicknameField, gbc_nicknameField);
        nicknameField.setColumns(10);
        
        JLabel nombreText = new JLabel("Nombre:");
        GridBagConstraints gbc_nombreText = new GridBagConstraints();
        gbc_nombreText.anchor = GridBagConstraints.WEST;
        gbc_nombreText.insets = new Insets(0, 0, 5, 5);
        gbc_nombreText.gridx = 1;
        gbc_nombreText.gridy = 2;
        NorthPanel.add(nombreText, gbc_nombreText);
        
        nombreField = new JTextField();
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 2;
        gbc_nombreField.gridy = 2;
        NorthPanel.add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);
        
        JLabel apellidoText = new JLabel("Apellido:");
        GridBagConstraints gbc_apellidoText = new GridBagConstraints();
        gbc_apellidoText.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoText.gridx = 3;
        gbc_apellidoText.gridy = 2;
        NorthPanel.add(apellidoText, gbc_apellidoText);
        
        apellidoField = new JTextField();
        GridBagConstraints gbc_apellidoField = new GridBagConstraints();
        gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidoField.gridx = 4;
        gbc_apellidoField.gridy = 2;
        NorthPanel.add(apellidoField, gbc_apellidoField);
        apellidoField.setColumns(10);
        
        JLabel emailText = new JLabel("Email:");
        GridBagConstraints gbc_emailText = new GridBagConstraints();
        gbc_emailText.anchor = GridBagConstraints.WEST;
        gbc_emailText.insets = new Insets(0, 0, 0, 5);
        gbc_emailText.gridx = 1;
        gbc_emailText.gridy = 3;
        NorthPanel.add(emailText, gbc_emailText);
        
        emailField = new JTextField();
        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.gridwidth = 2;
        gbc_emailField.insets = new Insets(0, 0, 0, 5);
        gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailField.gridx = 2;
        gbc_emailField.gridy = 3;
        NorthPanel.add(emailField, gbc_emailField);
        emailField.setColumns(10);
        
        JPanel CenterPanel = new JPanel();
        getContentPane().add(CenterPanel, BorderLayout.CENTER);
        CenterPanel.setLayout(new BorderLayout(0, 0));
        JPanel postulantePanel = new JPanel();
        CenterPanel.add(postulantePanel, BorderLayout.NORTH);
        GridBagLayout gbl_postulantePanel = new GridBagLayout();
        gbl_postulantePanel.columnWidths = new int[]{30, 70, 61, 110, 62, 0};
        gbl_postulantePanel.rowHeights = new int[]{59, 180, 64, 0};
        gbl_postulantePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_postulantePanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        postulantePanel.setLayout(gbl_postulantePanel);
        
        JLabel lblNewLabel = new JLabel("Nacionalidad:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        postulantePanel.add(lblNewLabel, gbc_lblNewLabel);
        
        nacionalidadField = new JTextField();
        GridBagConstraints gbc_nacionalidadField = new GridBagConstraints();
        gbc_nacionalidadField.gridwidth = 2;
        gbc_nacionalidadField.insets = new Insets(0, 0, 5, 5);
        gbc_nacionalidadField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nacionalidadField.gridx = 2;
        gbc_nacionalidadField.gridy = 0;
        postulantePanel.add(nacionalidadField, gbc_nacionalidadField);
        nacionalidadField.setColumns(10);
        
        
        JPanel empresaPanel = new JPanel();
        getContentPane().add(empresaPanel, BorderLayout.WEST);
        GridBagLayout gdbEmpresa = new GridBagLayout();
        gdbEmpresa.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0};
        gdbEmpresa.rowWeights = new double[]{1.0, 0.0};
        gdbEmpresa.columnWidths = new int[] {30, 71, 59, 155, 124};
        gdbEmpresa.rowHeights = new int[]{35, 28};
        empresaPanel.setLayout(gdbEmpresa);
        
        JLabel descripcionText = new JLabel("Descripcion:");
        descripcionText.setFont(new Font("Tahoma", Font.PLAIN, 11));
        descripcionText.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_descripcionText = new GridBagConstraints();
        gbc_descripcionText.anchor = GridBagConstraints.WEST;
        gbc_descripcionText.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionText.gridx = 1;
        gbc_descripcionText.gridy = 0;
        empresaPanel.add(descripcionText, gbc_descripcionText);
        
        JTextPane descripcionField = new JTextPane();
        GridBagConstraints gbc_descripcionField = new GridBagConstraints();
        gbc_descripcionField.gridwidth = 2;
        gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionField.fill = GridBagConstraints.BOTH;
        gbc_descripcionField.gridx = 2;
        gbc_descripcionField.gridy = 0;
        empresaPanel.add(descripcionField, gbc_descripcionField);
        
        JLabel linkText = new JLabel("Link:");
        GridBagConstraints gbc_linkText = new GridBagConstraints();
        gbc_linkText.anchor = GridBagConstraints.WEST;
        gbc_linkText.insets = new Insets(0, 0, 0, 5);
        gbc_linkText.gridx = 1;
        gbc_linkText.gridy = 1;
        empresaPanel.add(linkText, gbc_linkText);
        
        linkField = new JTextField();
        GridBagConstraints gbc_linkField = new GridBagConstraints();
        gbc_linkField.insets = new Insets(0, 0, 0, 5);
        gbc_linkField.gridwidth = 2;
        gbc_linkField.fill = GridBagConstraints.HORIZONTAL;
        gbc_linkField.gridx = 2;
        gbc_linkField.gridy = 1;
        empresaPanel.add(linkField, gbc_linkField);
        linkField.setColumns(10);
        
        empresaPanel.setVisible(false);
        postulantePanel.setVisible(false);
        
        
        
        EmpresaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	TipoUsuario = "Empresa";
                empresaPanel.setVisible(true);
                postulantePanel.setVisible(false);
                PostulanteButton.setSelected(false);  
                empresaPanel.setSize(225,225);
            }
        });
        
        PostulanteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TipoUsuario = "Postulante";
            	postulantePanel.setVisible(true);
            	empresaPanel.setVisible(false);
                EmpresaButton.setSelected(false);
            }
        });
        
        postulantePanel.setBounds(3, 3, 450, 250);
        empresaPanel.setBounds(3, 3, 450, 250);
        JLabel nacimientoText = new JLabel("Fecha de nacimiento:");
        GridBagConstraints gbc_nacimientoText = new GridBagConstraints();
        gbc_nacimientoText.anchor = GridBagConstraints.WEST;
        gbc_nacimientoText.gridwidth = 2;
        gbc_nacimientoText.insets = new Insets(0, 0, 5, 5);
        gbc_nacimientoText.gridx = 1;
        gbc_nacimientoText.gridy = 1;
        postulantePanel.add(nacimientoText, gbc_nacimientoText);
        
        JCalendar calendar = new JCalendar();
        GridBagConstraints gbc_calendar = new GridBagConstraints();
        gbc_calendar.insets = new Insets(0, 0, 5, 5);
        gbc_calendar.fill = GridBagConstraints.BOTH;
        gbc_calendar.gridx = 3;
        gbc_calendar.gridy = 1;
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
                    if (TipoUsuario.equals("Empresa")) {
                        icu.crearEmpresa(nicknameField.getText(), nombreField.getText(), apellidoField.getText(), emailField.getText(), descripcionField.getText(), linkField.getText());
                    } else if (TipoUsuario.equals("Postulante")) {
                        icu.crearPostulante(nicknameField.getText(), nombreField.getText(), apellidoField.getText(), emailField.getText(), nacionalidadField.getText(), calendar.getDate());
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
