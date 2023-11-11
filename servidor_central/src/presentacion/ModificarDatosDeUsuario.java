package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.datatypes.DataEmpresa;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataUsuario;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import excepciones.CamposVaciosExcepcion;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.FlowLayout;


public class ModificarDatosDeUsuario extends JInternalFrame{
	private JTextField tfNickname;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfNacionalidad;
	private JTextField tfLink;
	private JTextField tfDia;
	private JTextField tfMes;
	private JTextField tfAño;
	private JTextField tfPass;

	public ModificarDatosDeUsuario() {
		
		Factory f = Factory.getInstance();
		IControladorOferta ico = f.getControladorOferta();
		IControladorUsuario icu = f.getControladorUsuario();
		IControladorCompraTipo icc = f.getControladorCompraTipo();
		
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Datos De Usuario");
        
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{150, 300, 180, 0};
        gbl_panel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 10, 0, 0, 200, 50, 10, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JLabel lblUsuarios = new JLabel("Seleccione el Usuario:");
        GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
        gbc_lblUsuarios.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsuarios.gridx = 0;
        gbc_lblUsuarios.gridy = 1;
        panel.add(lblUsuarios, gbc_lblUsuarios);
        
        JComboBox <String> cbUsuarios = new JComboBox<String>();
        cbUsuarios.addItem("");
        cbUsuarios.setSelectedIndex(0);
        GridBagConstraints gbc_cbUsuarios = new GridBagConstraints();
        gbc_cbUsuarios.insets = new Insets(0, 0, 5, 5);
        gbc_cbUsuarios.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbUsuarios.gridx = 1;
        gbc_cbUsuarios.gridy = 1;
        panel.add(cbUsuarios, gbc_cbUsuarios);
        
        List<String> listaUsuarios = icu.listarUsuarios();
        for (String usuario : listaUsuarios) {
        	cbUsuarios.addItem(usuario);
        }
        
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 2;
        gbc_panel_2.gridy = 1;
        panel.add(panel_2, gbc_panel_2);
        
        JLabel lblNickname = new JLabel("Nickname:");
        GridBagConstraints gbc_lblNickname = new GridBagConstraints();
        gbc_lblNickname.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
        gbc_lblNickname.gridx = 0;
        gbc_lblNickname.gridy = 2;
        panel.add(lblNickname, gbc_lblNickname);
        
        tfNickname = new JTextField();
        tfNickname.setBackground(new Color(255, 255, 255));
        tfNickname.setEditable(false);
        GridBagConstraints gbc_tfNickname = new GridBagConstraints();
        gbc_tfNickname.insets = new Insets(0, 0, 5, 5);
        gbc_tfNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNickname.gridx = 1;
        gbc_tfNickname.gridy = 2;
        panel.add(tfNickname, gbc_tfNickname);
        tfNickname.setColumns(10);
        
        JLabel lblEmail = new JLabel("Email:");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.gridx = 0;
        gbc_lblEmail.gridy = 3;
        panel.add(lblEmail, gbc_lblEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBackground(new Color(255, 255, 255));
        tfEmail.setEditable(false);
        GridBagConstraints gbc_tfEmail = new GridBagConstraints();
        gbc_tfEmail.insets = new Insets(0, 0, 5, 5);
        gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfEmail.gridx = 1;
        gbc_tfEmail.gridy = 3;
        panel.add(tfEmail, gbc_tfEmail);
        tfEmail.setColumns(10);
        
        JLabel lblPass = new JLabel("Password:");
        GridBagConstraints gbc_lblPass = new GridBagConstraints();
        gbc_lblPass.anchor = GridBagConstraints.EAST;
        gbc_lblPass.insets = new Insets(0, 0, 5, 5);
        gbc_lblPass.gridx = 0;
        gbc_lblPass.gridy = 4;
        panel.add(lblPass, gbc_lblPass);
        
        tfPass = new JTextField();
        GridBagConstraints gbc_tfPass = new GridBagConstraints();
        gbc_tfPass.insets = new Insets(0, 0, 5, 5);
        gbc_tfPass.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfPass.gridx = 1;
        gbc_tfPass.gridy = 4;
        panel.add(tfPass, gbc_tfPass);
        tfPass.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 0;
        gbc_lblNombre.gridy = 5;
        panel.add(lblNombre, gbc_lblNombre);
        
        tfNombre = new JTextField();
        GridBagConstraints gbc_tfNombre = new GridBagConstraints();
        gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
        gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNombre.gridx = 1;
        gbc_tfNombre.gridy = 5;
        panel.add(tfNombre, gbc_tfNombre);
        tfNombre.setColumns(10);
        
        JLabel lblApellido = new JLabel("Apellido:");
        GridBagConstraints gbc_lblApellido = new GridBagConstraints();
        gbc_lblApellido.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblApellido.gridx = 0;
        gbc_lblApellido.gridy = 6;
        panel.add(lblApellido, gbc_lblApellido);
        
        tfApellido = new JTextField();
        GridBagConstraints gbc_tfApellido = new GridBagConstraints();
        gbc_tfApellido.insets = new Insets(0, 0, 5, 5);
        gbc_tfApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfApellido.gridx = 1;
        gbc_tfApellido.gridy = 6;
        panel.add(tfApellido, gbc_tfApellido);
        tfApellido.setColumns(10);
        
        JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
        gbc_lblNacionalidad.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_lblNacionalidad.gridx = 0;
        gbc_lblNacionalidad.gridy = 7;
        panel.add(lblNacionalidad, gbc_lblNacionalidad);
        
        tfNacionalidad = new JTextField();
        tfNacionalidad.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_tfNacionalidad = new GridBagConstraints();
        gbc_tfNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_tfNacionalidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNacionalidad.gridx = 1;
        gbc_tfNacionalidad.gridy = 7;
        panel.add(tfNacionalidad, gbc_tfNacionalidad);
        tfNacionalidad.setColumns(10);
        
        JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
        GridBagConstraints gbc_lblFecha = new GridBagConstraints();
        gbc_lblFecha.anchor = GridBagConstraints.EAST;
        gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblFecha.gridx = 0;
        gbc_lblFecha.gridy = 8;
        panel.add(lblFecha, gbc_lblFecha);
        
        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.insets = new Insets(0, 0, 5, 5);
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridx = 1;
        gbc_panel_4.gridy = 8;
        panel.add(panel_4, gbc_panel_4);
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblDia = new JLabel("Día: ");
        panel_4.add(lblDia);
        
        tfDia = new JTextField();
        tfDia.setBackground(new Color(255, 255, 255));
        panel_4.add(tfDia);
        tfDia.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Mes: ");
        panel_4.add(lblNewLabel);
        
        tfMes = new JTextField();
        tfMes.setBackground(new Color(255, 255, 255));
        panel_4.add(tfMes);
        tfMes.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Año: ");
        panel_4.add(lblNewLabel_1);
        
        tfAño = new JTextField();
        tfAño.setBackground(new Color(255, 255, 255));
        panel_4.add(tfAño);
        tfAño.setColumns(10);
        
        JLabel lblLink = new JLabel("Link:");
        GridBagConstraints gbc_lblLink = new GridBagConstraints();
        gbc_lblLink.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblLink.insets = new Insets(0, 0, 5, 5);
        gbc_lblLink.gridx = 0;
        gbc_lblLink.gridy = 9;
        panel.add(lblLink, gbc_lblLink);
        
        tfLink = new JTextField();
        tfLink.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_tfLink = new GridBagConstraints();
        gbc_tfLink.insets = new Insets(0, 0, 5, 5);
        gbc_tfLink.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfLink.gridx = 1;
        gbc_tfLink.gridy = 9;
        panel.add(tfLink, gbc_tfLink);
        tfLink.setColumns(10);
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
        gbc_lblDescripcion.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcion.gridx = 0;
        gbc_lblDescripcion.gridy = 10;
        panel.add(lblDescripcion, gbc_lblDescripcion);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 1;
        gbc_scrollPane_1.gridy = 10;
        panel.add(scrollPane_1, gbc_scrollPane_1);
        
        JTextArea taDescripcion = new JTextArea();
        taDescripcion.setLineWrap(true);
        scrollPane_1.setViewportView(taDescripcion);
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.anchor = GridBagConstraints.SOUTH;
        gbc_panel_3.insets = new Insets(0, 0, 5, 5);
        gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_3.gridx = 1;
        gbc_panel_3.gridy = 11;
        panel.add(panel_3, gbc_panel_3);
        
        JButton btnAceptar = new JButton("Aceptar");
        panel_3.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        panel_3.add(btnCancelar);
        
		tfNickname.setText("");
		tfEmail.setText("");
		tfNombre.setText("");
		tfApellido.setText("");
		tfPass.setText("");
		
		tfNacionalidad.setText("");
		tfDia.setText("");
		tfMes.setText("");
		tfAño.setText("");
		
		tfLink.setText("");
		taDescripcion.setText("");
        
        tfNacionalidad.setEditable(false);
        tfDia.setEditable(false);
        tfMes.setEditable(false);
        tfAño.setEditable(false);
        
        tfLink.setEditable(false);
        taDescripcion.setEditable(false);

		cbUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cbUsuarios.getSelectedItem() == "") {
					
					tfNickname.setText("");
					tfEmail.setText("");
					tfNombre.setText("");
					tfApellido.setText("");
					tfPass.setText("");
					
					tfNacionalidad.setText("");
					tfDia.setText("");
					tfMes.setText("");
					tfAño.setText("");
					
					tfLink.setText("");
					taDescripcion.setText("");
	
			        tfNacionalidad.setEditable(false);
			        tfDia.setEditable(false);
			        tfMes.setEditable(false);
			        tfAño.setEditable(false);
			        
			        tfLink.setEditable(false);
			        taDescripcion.setEditable(false);
					
				} else {
					
					String usuarioSelec = (String) cbUsuarios.getSelectedItem();
					DataUsuario us = icu.consultarDatosUsuario(usuarioSelec);
					
					tfNickname.setText(us.getNickname());
					tfEmail.setText(us.getEmail());
					tfNombre.setText(us.getNombre());
					tfApellido.setText(us.getApellido());
					tfPass.setText(us.getPassword());
					
					if(us instanceof DataEmpresa) {
						DataEmpresa usEmpresa = (DataEmpresa) us;
						
						tfNacionalidad.setText("");
						tfDia.setText("");
						tfMes.setText("");
						tfAño.setText("");
						
				        tfNacionalidad.setEditable(false);
				        tfDia.setEditable(false);
				        tfMes.setEditable(false);
				        tfAño.setEditable(false);
						
						tfLink.setText(usEmpresa.getLink());
						taDescripcion.setText(usEmpresa.getDescripcion());
						
				        tfLink.setEditable(true);
				        taDescripcion.setEditable(true);
						
					}
					else if(us instanceof DataPostulante) {
						DataPostulante usPostulante = (DataPostulante) us;
						
						int dia = usPostulante.getDiaNac();
						int mes = usPostulante.getMesNac();
						int anio = usPostulante.getAnioNac();
						
						tfLink.setText("");
						taDescripcion.setText("");
						
				        tfLink.setEditable(false);
				        taDescripcion.setEditable(false);
						
						tfNacionalidad.setText(usPostulante.getNacionalidad());
						tfDia.setText(Integer.toString(dia));
						tfMes.setText(Integer.toString(mes));
						tfAño.setText(Integer.toString(anio));
						
				        tfNacionalidad.setEditable(true);
				        tfDia.setEditable(true);
				        tfMes.setEditable(true);
				        tfAño.setEditable(true);
					}
				}	
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Popup");
				
				if (cbUsuarios.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(
							frame,
							"No se ha realizado ninguna modificacion",
							"Sistema",
							JOptionPane.INFORMATION_MESSAGE
							);
					dispose();
				} else {
					
					DataUsuario dtUser = icu.consultarDatosUsuario(tfNickname.getText());
					
					try {
						if(dtUser instanceof DataEmpresa) {
							
							if(taDescripcion.getText().isEmpty()) {
								throw new CamposVaciosExcepcion("Descripcion no puede ser vacia");
							}
							
							if(tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty() || tfPass.getText().isEmpty()) {
								throw new CamposVaciosExcepcion("Campos vacios");
							}
	
							icu.modificarUsuario(tfNickname.getText(),
										tfNombre.getText(),
										tfApellido.getText(),
										tfPass.getText(),
										taDescripcion.getText(),
										tfLink.getText(),
										null,
										null);
								
						}
						else if(dtUser instanceof DataPostulante) {
							
							if(tfDia.getText().isEmpty() || tfMes.getText().isEmpty() || tfAño.getText().isEmpty()) {
								throw new CamposVaciosExcepcion("Complete los campos de la fecha");
							}
							
							if(tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty() || tfPass.getText().isEmpty()) {
								throw new CamposVaciosExcepcion("Campos vacios");
							}
							
							if(tfNacionalidad.getText().isEmpty()) {
								throw new CamposVaciosExcepcion("Ingrese la nacionalidad");
							}
							
							int dia = Integer.parseInt(tfDia.getText());
							int mes = Integer.parseInt(tfMes.getText());
							int anio = Integer.parseInt(tfAño.getText());
							LocalDate fecha = LocalDate.of(anio, mes, dia);
							
							icu.modificarUsuario(tfNickname.getText(),
									tfNombre.getText(),
									tfApellido.getText(),
									tfPass.getText(),
									null,
									null,
									fecha,
									tfNacionalidad.getText());
						}
						JOptionPane.showMessageDialog(
								frame,
								"Usuario Modificado",
								"Éxito",
								JOptionPane.INFORMATION_MESSAGE
								);
						dispose();
					} catch (Exception exep) {
						JOptionPane.showMessageDialog(
								frame,
								exep.getMessage(),
								"Error",
								JOptionPane.ERROR_MESSAGE
								);
					}
				}
			}//end ACTIONPERFORMED
		});
		
		btnCancelar.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
		
		
		
	}


}
