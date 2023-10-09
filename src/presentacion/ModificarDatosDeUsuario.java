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
        gbl_panel.columnWidths = new int[]{10, 120, 200, 100, 0};
        gbl_panel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 10, 0, 0, 150, 10, 10, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 1;
        panel.add(panel_1, gbc_panel_1);
        
        JLabel lblUsuarios = new JLabel("Usuarios:");
        GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
        gbc_lblUsuarios.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsuarios.gridx = 1;
        gbc_lblUsuarios.gridy = 1;
        panel.add(lblUsuarios, gbc_lblUsuarios);
        
        JComboBox <String> cbUsuarios = new JComboBox<String>();
        GridBagConstraints gbc_cbUsuarios = new GridBagConstraints();
        gbc_cbUsuarios.insets = new Insets(0, 0, 5, 5);
        gbc_cbUsuarios.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbUsuarios.gridx = 2;
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
        gbc_panel_2.gridx = 3;
        gbc_panel_2.gridy = 1;
        panel.add(panel_2, gbc_panel_2);
        
        JLabel lblNickname = new JLabel("Nickname:");
        GridBagConstraints gbc_lblNickname = new GridBagConstraints();
        gbc_lblNickname.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
        gbc_lblNickname.gridx = 1;
        gbc_lblNickname.gridy = 2;
        panel.add(lblNickname, gbc_lblNickname);
        
        tfNickname = new JTextField();
        tfNickname.setBackground(new Color(255, 255, 255));
        tfNickname.setEditable(false);
        GridBagConstraints gbc_tfNickname = new GridBagConstraints();
        gbc_tfNickname.insets = new Insets(0, 0, 5, 5);
        gbc_tfNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNickname.gridx = 2;
        gbc_tfNickname.gridy = 2;
        panel.add(tfNickname, gbc_tfNickname);
        tfNickname.setColumns(10);
        
        JLabel lblEmail = new JLabel("Email:");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.gridx = 1;
        gbc_lblEmail.gridy = 3;
        panel.add(lblEmail, gbc_lblEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBackground(new Color(255, 255, 255));
        tfEmail.setEditable(false);
        GridBagConstraints gbc_tfEmail = new GridBagConstraints();
        gbc_tfEmail.insets = new Insets(0, 0, 5, 5);
        gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfEmail.gridx = 2;
        gbc_tfEmail.gridy = 3;
        panel.add(tfEmail, gbc_tfEmail);
        tfEmail.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 4;
        panel.add(lblNombre, gbc_lblNombre);
        
        tfNombre = new JTextField();
        GridBagConstraints gbc_tfNombre = new GridBagConstraints();
        gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
        gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNombre.gridx = 2;
        gbc_tfNombre.gridy = 4;
        panel.add(tfNombre, gbc_tfNombre);
        tfNombre.setColumns(10);
        
        JLabel lblApellido = new JLabel("Apellido:");
        GridBagConstraints gbc_lblApellido = new GridBagConstraints();
        gbc_lblApellido.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblApellido.gridx = 1;
        gbc_lblApellido.gridy = 5;
        panel.add(lblApellido, gbc_lblApellido);
        
        tfApellido = new JTextField();
        GridBagConstraints gbc_tfApellido = new GridBagConstraints();
        gbc_tfApellido.insets = new Insets(0, 0, 5, 5);
        gbc_tfApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfApellido.gridx = 2;
        gbc_tfApellido.gridy = 5;
        panel.add(tfApellido, gbc_tfApellido);
        tfApellido.setColumns(10);
        
        JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
        gbc_lblNacionalidad.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_lblNacionalidad.gridx = 1;
        gbc_lblNacionalidad.gridy = 6;
        panel.add(lblNacionalidad, gbc_lblNacionalidad);
        
        tfNacionalidad = new JTextField();
        GridBagConstraints gbc_tfNacionalidad = new GridBagConstraints();
        gbc_tfNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_tfNacionalidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNacionalidad.gridx = 2;
        gbc_tfNacionalidad.gridy = 6;
        panel.add(tfNacionalidad, gbc_tfNacionalidad);
        tfNacionalidad.setColumns(10);
        
        JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
        GridBagConstraints gbc_lblFecha = new GridBagConstraints();
        gbc_lblFecha.anchor = GridBagConstraints.EAST;
        gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblFecha.gridx = 1;
        gbc_lblFecha.gridy = 7;
        panel.add(lblFecha, gbc_lblFecha);
        
        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.insets = new Insets(0, 0, 5, 5);
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridx = 2;
        gbc_panel_4.gridy = 7;
        panel.add(panel_4, gbc_panel_4);
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblDia = new JLabel("Día: ");
        panel_4.add(lblDia);
        
        tfDia = new JTextField();
        panel_4.add(tfDia);
        tfDia.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Mes: ");
        panel_4.add(lblNewLabel);
        
        tfMes = new JTextField();
        panel_4.add(tfMes);
        tfMes.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Año: ");
        panel_4.add(lblNewLabel_1);
        
        tfAño = new JTextField();
        panel_4.add(tfAño);
        tfAño.setColumns(10);
        
        JLabel lblLink = new JLabel("Link:");
        GridBagConstraints gbc_lblLink = new GridBagConstraints();
        gbc_lblLink.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblLink.insets = new Insets(0, 0, 5, 5);
        gbc_lblLink.gridx = 1;
        gbc_lblLink.gridy = 8;
        panel.add(lblLink, gbc_lblLink);
        
        tfLink = new JTextField();
        GridBagConstraints gbc_tfLink = new GridBagConstraints();
        gbc_tfLink.insets = new Insets(0, 0, 5, 5);
        gbc_tfLink.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfLink.gridx = 2;
        gbc_tfLink.gridy = 8;
        panel.add(tfLink, gbc_tfLink);
        tfLink.setColumns(10);
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
        gbc_lblDescripcion.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcion.gridx = 1;
        gbc_lblDescripcion.gridy = 9;
        panel.add(lblDescripcion, gbc_lblDescripcion);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 2;
        gbc_scrollPane_1.gridy = 9;
        panel.add(scrollPane_1, gbc_scrollPane_1);
        
        JTextArea taDescripcion = new JTextArea();
        taDescripcion.setLineWrap(true);
        scrollPane_1.setViewportView(taDescripcion);
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.insets = new Insets(0, 0, 5, 5);
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 2;
        gbc_panel_3.gridy = 10;
        panel.add(panel_3, gbc_panel_3);
        
        JButton btnAceptar = new JButton("Aceptar");
        panel_3.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        panel_3.add(btnCancelar);

		cbUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioSelec = (String) cbUsuarios.getSelectedItem();
				DataUsuario us = icu.consultarDatosUsuario(usuarioSelec);
				tfNickname.setText(us.getNickname());
				tfEmail.setText(us.getEmail());
				tfNombre.setText(us.getNombre());
				tfApellido.setText(us.getApellido());
				if(us instanceof DataEmpresa) {
					DataEmpresa usEmpresa = (DataEmpresa) us;
					
					tfNacionalidad.setText(null);
					tfDia.setText(null);
					tfMes.setText(null);
					tfAño.setText(null);
					tfLink.setText(usEmpresa.getLink());
					taDescripcion.setText(usEmpresa.getDescripcion());
					
				}
				else if(us instanceof DataPostulante) {
					DataPostulante usPostulante = (DataPostulante) us;
					int dia = usPostulante.getDiaNac();
					int mes = usPostulante.getMesNac();
					int anio = usPostulante.getAnioNac();
					
					tfLink.setText(null);
					taDescripcion.setText(null);
					
					tfNacionalidad.setText(usPostulante.getNacionalidad());
					tfDia.setText(Integer.toString(dia));
					tfMes.setText(Integer.toString(mes));
					tfAño.setText(Integer.toString(anio));
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Popup");
				DataUsuario dtUser = icu.consultarDatosUsuario(tfNickname.getText());
				try {
					if(dtUser instanceof DataEmpresa) {
						String desc = taDescripcion.getText();
						String link = tfLink.getText();
						
						if(desc.isEmpty() || link.isEmpty()) {
							throw new CamposVaciosExcepcion("Ingrese todos los campos");
						}
						
						icu.modificarUsuario(tfNickname.getText(),
								tfNombre.getText(),
								tfApellido.getText(),
								tfEmail.getText(),
								taDescripcion.getText(),
								tfLink.getText(),
								null,
								null);
						
					}
					else if(dtUser instanceof DataPostulante) {
						String stringDia = tfDia.getText();
						String stringMes = tfMes.getText();
						String stringAnio = tfAño.getText();
						
						if(stringDia.isEmpty() || stringMes.isEmpty() || stringAnio.isEmpty()) {
							throw new CamposVaciosExcepcion("Complete los campos de la fecha.");
						}
						
						int dia = Integer.parseInt(tfDia.getText());
						int mes = Integer.parseInt(tfMes.getText());
						int anio = Integer.parseInt(tfAño.getText());
						LocalDate fecha = LocalDate.of(anio, mes, dia);
						
						icu.modificarUsuario(tfNickname.getText(),
								tfNombre.getText(),
								tfApellido.getText(),
								tfEmail.getText(),
								null,
								null,
								fecha,
								tfNacionalidad.getText());
					}
					JOptionPane.showMessageDialog(
							frame,
							"La operación se ha realizado con éxito",
							"Éxito",
							JOptionPane.INFORMATION_MESSAGE
							);
					dispose();
				}
				catch(DateTimeException ex) {
                	JOptionPane.showMessageDialog(
                			frame, 
                			"Formato de fecha incorrecto.",
                			"Error", 
                			JOptionPane.ERROR_MESSAGE
                			);
                }
				catch(CamposVaciosExcepcion ex) {
                	JOptionPane.showMessageDialog(
    						frame,
    						ex.getMessage(),
    						"Error",
    						JOptionPane.ERROR_MESSAGE
                	
                	);
                }	
			}//end ACTIONPERFORMED
		});
		
		
		
	}


}
