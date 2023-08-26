package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DataUsuario;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataEmpresa;
import logica.datatypes.DataOfertaLaboral;
import logica.interfaces.IControladorUsuario;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsultarUsuario  extends JInternalFrame{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private IControladorUsuario icu;
	private List<DataOfertaLaboral> dtofertas2= new ArrayList<>();
	
	public ConsultarUsuario(IControladorUsuario cu) {
		icu = cu;	
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Consulta Usuario");
        setBounds(100, 100, 750, 700);
        
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWeights = new double[]{0.0, 1.0, 0.0};
        GridBagConstraints gcon = new GridBagConstraints();
        gcon.weightx = 0;
        gcon.weighty = 0;
        getContentPane().setLayout(gbl);
        
        /*JPanel NorthPanel = new JPanel();
        getContentPane().add(NorthPanel, BorderLayout.NORTH);
        NorthPanel.setLayout(new GridLayout(3, 0, 0, 0));*/
        
        JLabel SeleccionarText = new JLabel("Seleccione un usuario:");
        gcon.gridx = 0;
        gcon.gridy = 0;
        gcon.gridheight = 1;
        gcon.gridwidth = 1;
        gbl.setConstraints(SeleccionarText, gcon);
        GridBagConstraints gbc_SeleccionarText = new GridBagConstraints();
        gbc_SeleccionarText.fill = GridBagConstraints.HORIZONTAL;
        gbc_SeleccionarText.insets = new Insets(0, 0, 5, 5);
        gbc_SeleccionarText.gridx = 0;
        gbc_SeleccionarText.gridy = 0;
        getContentPane().add(SeleccionarText, gbc_SeleccionarText);
        SeleccionarText.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JComboBox<String> UsuariosComboBox = new JComboBox<String>();
        gcon.gridx = 1;
        gbl.setConstraints(UsuariosComboBox, gcon);
        GridBagConstraints gbc_UsuariosComboBox = new GridBagConstraints();
        gbc_UsuariosComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_UsuariosComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_UsuariosComboBox.gridx = 1;
        gbc_UsuariosComboBox.gridy = 0;
        getContentPane().add(UsuariosComboBox, gbc_UsuariosComboBox);
        
        List<String> usuariosDisponibles = icu.listarUsuarios();

        UsuariosComboBox.removeAllItems();
       
        for (String usuario : usuariosDisponibles) {
            UsuariosComboBox.addItem(usuario);
        }

        JButton ConsultarButton = new JButton("Consultar datos de usuario");
        gcon.gridx = 2;
        gbl.setConstraints(ConsultarButton, gcon);
        GridBagConstraints gbc_ConsultarButton = new GridBagConstraints();
        gbc_ConsultarButton.insets = new Insets(0, 0, 5, 0);
        gbc_ConsultarButton.gridx = 2;
        gbc_ConsultarButton.gridy = 0;
        gbc_ConsultarButton.anchor = GridBagConstraints.WEST;
        getContentPane().add(ConsultarButton, gbc_ConsultarButton);
        
        /*JPanel CenterPanel = new JPanel();
        getContentPane().add(CenterPanel, BorderLayout.CENTER);
        GridBagLayout gbl_CenterPanel = new GridBagLayout();
        gbl_CenterPanel.columnWidths = new int[]{30, 327, 0};
        gbl_CenterPanel.rowHeights = new int[]{30, 30, 30, 30, 30, 211, 25, 0};
        gbl_CenterPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_CenterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        CenterPanel.setLayout(gbl_CenterPanel);*/
        
        /*JPanel SouthPanel = new JPanel();
        getContentPane().add(SouthPanel, BorderLayout.SOUTH);*/
        
       /* JButton ConsultarOfertasButton = new JButton("Consultar ofertas");
        add(ConsultarOfertasButton);*/
        
        /*JPanel EastPanel = new JPanel();
        getContentPane().add(EastPanel, BorderLayout.EAST);
        GridBagLayout gbl_EastPanel = new GridBagLayout();
        gbl_EastPanel.columnWidths = new int[]{0, 112, 112, 0};
        gbl_EastPanel.rowHeights = new int[]{35, 35, 35, 35, 0};
        gbl_EastPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_EastPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        EastPanel.setLayout(gbl_EastPanel);*/
        
      /*  JLabel consultarOfertaPostulacion = new JLabel("OfertaPostulacion");
        GridBagConstraints gbc_consultarOfertaPostulacion = new GridBagConstraints();
        gbc_consultarOfertaPostulacion.fill = GridBagConstraints.BOTH;
        gbc_consultarOfertaPostulacion.insets = new Insets(0, 0, 5, 5);
        gbc_consultarOfertaPostulacion.gridx = 1;
        gbc_consultarOfertaPostulacion.gridy = 0;
        consultarOfertaPostulacion.setVisible(false);
        EastPanel.add(consultarOfertaPostulacion, gbc_consultarOfertaPostulacion);*/
        
       /* JComboBox<String> ofertaPostulacionComboBox = new JComboBox<String>();
        ofertaPostulacionComboBox.setMaximumRowCount(15);
        GridBagConstraints gbc_ofertaPostulacionComboBox = new GridBagConstraints();
        gbc_ofertaPostulacionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_ofertaPostulacionComboBox.fill = GridBagConstraints.BOTH;
        gbc_ofertaPostulacionComboBox.gridx = 2;
        gbc_ofertaPostulacionComboBox.gridy = 0;
        ofertaPostulacionComboBox.setVisible(false);
        EastPanel.add(ofertaPostulacionComboBox, gbc_ofertaPostulacionComboBox);*/
        gcon.gridx = 0;
        gcon.gridy = 1;
        gcon.gridx = 1;
        gcon.gridx = -1;
        gcon.gridy = 2;
        gcon.gridx = 1;
        gcon.gridx = 0;
        gcon.gridy = 3;
        gcon.gridx = 1;
        gcon.gridx = 0;
        gcon.gridy = 4;
        gcon.gridx = 1;
        gcon.gridx = 0;
        gcon.gridy = 5;
        gcon.gridx = 1;
        gcon.gridx = 0;
        gcon.gridy = 6;
        gcon.gridx = 1;
        gcon.gridx = 0;
        gcon.gridy = 5;
        gcon.gridx = 1;
        gcon.gridx = 0;
        gcon.gridy = 6;
        gcon.gridx = 1;
        
        
        
        // #### NOMBRE ####
        JLabel labelNombre = new JLabel("Nombre: ");
        gbl.setConstraints(labelNombre, gcon);
        GridBagConstraints gbc_labelNombre = new GridBagConstraints();
        gbc_labelNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
        gbc_labelNombre.gridx = 0;
        gbc_labelNombre.gridy = 1;
        getContentPane().add(labelNombre, gbc_labelNombre);
        labelNombre.setVisible(true);
        labelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField mostrarNombre = new JTextField();
        gbl.setConstraints(mostrarNombre, gcon);
        GridBagConstraints gbc_mostrarNombre = new GridBagConstraints();
        gbc_mostrarNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarNombre.gridx = 1;
        gbc_mostrarNombre.gridy = 1;
        getContentPane().add(mostrarNombre, gbc_mostrarNombre);
        mostrarNombre.setEditable(false);
        mostrarNombre.setVisible(true);
        
        JLabel labelApellido = new JLabel("Apellido: ");
        GridBagConstraints gbc_labelApellido = new GridBagConstraints();
        gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
        gbc_labelApellido.anchor = GridBagConstraints.EAST;
        gbc_labelApellido.gridx = 0;
        gbc_labelApellido.gridy = 2;
        getContentPane().add(labelApellido, gbc_labelApellido);
        
        JTextField mostrarApellido = new JTextField();
        GridBagConstraints gbc_mostrarApellido = new GridBagConstraints();
        gbc_mostrarApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarApellido.gridx = 1;
        gbc_mostrarApellido.gridy = 2;
        getContentPane().add(mostrarApellido, gbc_mostrarApellido);
        mostrarApellido.setEditable(false);
        mostrarApellido.setVisible(true);
        
        
        // #### NICKNAME ####
        JLabel labelNickname = new JLabel("Nickname: ");
        gbl.setConstraints(labelNickname, gcon);
        GridBagConstraints gbc_labelNickname = new GridBagConstraints();
        gbc_labelNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_labelNickname.insets = new Insets(0, 0, 5, 5);
        gbc_labelNickname.gridx = 0;
        gbc_labelNickname.gridy = 3;
        getContentPane().add(labelNickname, gbc_labelNickname);
        labelNickname.setVisible(true);
        labelNickname.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField mostrarNickname = new JTextField();
        gbl.setConstraints(mostrarNickname, gcon);
        GridBagConstraints gbc_mostrarNickname = new GridBagConstraints();
        gbc_mostrarNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarNickname.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarNickname.gridx = 1;
        gbc_mostrarNickname.gridy = 3;
        getContentPane().add(mostrarNickname, gbc_mostrarNickname);
        mostrarNickname.setEditable(false);
        mostrarNickname.setVisible(true);
        
        
     // #### EMAIL ####
        JLabel labelEmail = new JLabel("Email: ");
        gbl.setConstraints(labelEmail, gcon);
        GridBagConstraints gbc_labelEmail = new GridBagConstraints();
        gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
        gbc_labelEmail.gridx = 0;
        gbc_labelEmail.gridy = 4;
        getContentPane().add(labelEmail, gbc_labelEmail);
        labelEmail.setVisible(true);
        labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField mostrarEmail = new JTextField();
        gbl.setConstraints(mostrarEmail, gcon);
        GridBagConstraints gbc_mostrarEmail = new GridBagConstraints();
        gbc_mostrarEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarEmail.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarEmail.gridx = 1;
        gbc_mostrarEmail.gridy = 4;
        getContentPane().add(mostrarEmail, gbc_mostrarEmail);
        mostrarEmail.setEditable(false);
        
     // #### POSTULANTE ####
     // #### FECHA DE NACIMIENTO ####
        JLabel labelFechaNac = new JLabel("Fecha de Nacimiento: ");
        gbl.setConstraints(labelFechaNac, gcon);
        GridBagConstraints gbc_labelFechaNac = new GridBagConstraints();
        gbc_labelFechaNac.fill = GridBagConstraints.HORIZONTAL;
        gbc_labelFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_labelFechaNac.gridx = 0;
        gbc_labelFechaNac.gridy = 5;
        getContentPane().add(labelFechaNac, gbc_labelFechaNac);
        labelFechaNac.setVisible(false);
        labelFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField mostrarFechaNac = new JTextField();
        gbl.setConstraints(mostrarFechaNac, gcon);
        GridBagConstraints gbc_mostrarFechaNac = new GridBagConstraints();
        gbc_mostrarFechaNac.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarFechaNac.gridx = 1;
        gbc_mostrarFechaNac.gridy = 5;
        getContentPane().add(mostrarFechaNac, gbc_mostrarFechaNac);
        mostrarFechaNac.setEditable(false);
        mostrarFechaNac.setVisible(false);
        
        
     // #### POSTULANTE ####
     // #### NACIONALIDAD ####
        JLabel labelNacionalidad = new JLabel("Nacionalidad: ");
        gbl.setConstraints(labelNacionalidad, gcon);
        GridBagConstraints gbc_labelNacionalidad = new GridBagConstraints();
        gbc_labelNacionalidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_labelNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_labelNacionalidad.gridx = 0;
        gbc_labelNacionalidad.gridy = 6;
        getContentPane().add(labelNacionalidad, gbc_labelNacionalidad);
        labelNacionalidad.setVisible(false);
        labelNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField mostrarNacionalidad = new JTextField();
        gbl.setConstraints(mostrarNacionalidad, gcon);
        GridBagConstraints gbc_mostrarNacionalidad = new GridBagConstraints();
        gbc_mostrarNacionalidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarNacionalidad.gridx = 1;
        gbc_mostrarNacionalidad.gridy = 6;
        getContentPane().add(mostrarNacionalidad, gbc_mostrarNacionalidad);
        mostrarNacionalidad.setEditable(false);
        mostrarNacionalidad.setVisible(false);
        
        
     // #### EMPRESA ####
     // #### DESCRIPCION ####
        JLabel labelDescripcion = new JLabel("Descripcion: ");
        gbl.setConstraints(labelDescripcion, gcon);
        GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
        gbc_labelDescripcion.anchor = GridBagConstraints.EAST;
        gbc_labelDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_labelDescripcion.gridx = 0;
        gbc_labelDescripcion.gridy = 7;
        getContentPane().add(labelDescripcion, gbc_labelDescripcion);
        labelDescripcion.setVisible(false);
        labelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextArea mostrarDescripcion = new JTextArea();
        mostrarDescripcion.setLineWrap(true);
        gbl.setConstraints(mostrarDescripcion, gcon);
        GridBagConstraints gbc_mostrarDescripcion = new GridBagConstraints();
        gbc_mostrarDescripcion.fill = GridBagConstraints.HORIZONTAL;
        gbc_mostrarDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarDescripcion.gridx = 1;
        gbc_mostrarDescripcion.gridy = 7;
        getContentPane().add(mostrarDescripcion, gbc_mostrarDescripcion);
        mostrarDescripcion.setEditable(false);
        mostrarDescripcion.setVisible(false);
        
     // #### EMPRESA ####
     // #### LINK ####   
        JLabel labelLink = new JLabel("Link: ");
        gbl.setConstraints(labelLink, gcon);
        GridBagConstraints gbc_labelLink = new GridBagConstraints();
        gbc_labelLink.anchor = GridBagConstraints.EAST;
        gbc_labelLink.fill = GridBagConstraints.VERTICAL;
        gbc_labelLink.insets = new Insets(0, 0, 5, 5);
        gbc_labelLink.gridx = 0;
        gbc_labelLink.gridy = 8;
        getContentPane().add(labelLink, gbc_labelLink);
        labelLink.setVisible(false);
        labelLink.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField mostrarLink = new JTextField();
        gbl.setConstraints(mostrarLink, gcon);
        GridBagConstraints gbc_mostrarLink = new GridBagConstraints();
        gbc_mostrarLink.fill = GridBagConstraints.BOTH;
        gbc_mostrarLink.insets = new Insets(0, 0, 5, 5);
        gbc_mostrarLink.gridx = 1;
        gbc_mostrarLink.gridy = 8;
        getContentPane().add(mostrarLink, gbc_mostrarLink);
        mostrarLink.setEditable(false);
        
        JLabel labelOfertas = new JLabel("Ofertas Laborales: ");
        GridBagConstraints gbc_labelOfertas = new GridBagConstraints();
        gbc_labelOfertas.insets = new Insets(0, 0, 5, 5);
        gbc_labelOfertas.anchor = GridBagConstraints.EAST;
        gbc_labelOfertas.gridx = 0;
        gbc_labelOfertas.gridy = 9;
        getContentPane().add(labelOfertas, gbc_labelOfertas);
        labelOfertas.setVisible(false);
        
        JComboBox comboOfertas = new JComboBox();
        GridBagConstraints gbc_comboOfertas = new GridBagConstraints();
        gbc_comboOfertas.insets = new Insets(0, 0, 5, 5);
        gbc_comboOfertas.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboOfertas.gridx = 1;
        gbc_comboOfertas.gridy = 9;
        getContentPane().add(comboOfertas, gbc_comboOfertas);
        
        JLabel labelPostulaciones = new JLabel("Postulaciones: ");
        GridBagConstraints gbc_labelPostulaciones = new GridBagConstraints();
        gbc_labelPostulaciones.insets = new Insets(0, 0, 0, 5);
        gbc_labelPostulaciones.anchor = GridBagConstraints.EAST;
        gbc_labelPostulaciones.gridx = 0;
        gbc_labelPostulaciones.gridy = 10;
        getContentPane().add(labelPostulaciones, gbc_labelPostulaciones);
        labelPostulaciones.setVisible(false);
        
        JComboBox comboPostulaciones = new JComboBox();
        GridBagConstraints gbc_comboPostulaciones = new GridBagConstraints();
        gbc_comboPostulaciones.insets = new Insets(0, 0, 0, 5);
        gbc_comboPostulaciones.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboPostulaciones.gridx = 1;
        gbc_comboPostulaciones.gridy = 10;
        getContentPane().add(comboPostulaciones, gbc_comboPostulaciones);
        comboPostulaciones.setVisible(false);
        comboOfertas.setVisible(false);
        mostrarLink.setVisible(false);
        mostrarEmail.setVisible(true);
        
        
        /*JLabel labelCiudad = new JLabel("Ciudad: ");
        gcon.gridx = 0;
        gcon.gridy = 2;
        gbl.setConstraints(labelCiudad, gcon);
        add(labelCiudad);
        labelCiudad.setVisible(false);*/
        
        
        /*JTextField mostrarCiudad = new JTextField();
        gcon.gridx = 1;
        gbl.setConstraints(mostrarCiudad, gcon);
        add(mostrarCiudad);
        mostrarCiudad.setVisible(false);
        EastPanel.add(mostrarCiudad, gbc_mostrarCiudad);*/
        
        /*JLabel fechaLabelNoChange = new JLabel("Fecha:");
        GridBagConstraints gbc_fechaLabelNoChange = new GridBagConstraints();
        gbc_fechaLabelNoChange.anchor = GridBagConstraints.WEST;
        gbc_fechaLabelNoChange.insets = new Insets(0, 0, 0, 5);
        gbc_fechaLabelNoChange.gridx = 1;
        gbc_fechaLabelNoChange.gridy = 3;
        EastPanel.add(fechaLabelNoChange, gbc_fechaLabelNoChange);
        fechaLabelNoChange.setVisible(false);*/
        
        /*JTextArea mostrarFecha = new JTextArea("");
        GridBagConstraints gbc_mostrarFecha = new GridBagConstraints();
        gbc_mostrarFecha.gridx = 2;
        gbc_mostrarFecha.gridy = 3;
        EastPanel.add(mostrarFecha, gbc_mostrarFecha);*/
        
        /*mostrarNombre.setVisible(false);
		mostrarCiudad.setVisible(false);
		mostrarFecha.setVisible(false);*/
        
        
        ConsultarButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		String seleccionado = (String) UsuariosComboBox.getSelectedItem();
        		if(!seleccionado.isEmpty()) {
        			DataUsuario us = icu.consultarDatosUsuario(seleccionado);
        			List<DataOfertaLaboral> dtofertas = new ArrayList<>();
        			// NOMBRE
                    labelNombre.setVisible(true);
                    mostrarNombre.setText(us.getNombre());
                    mostrarNombre.setVisible(true);
                    
                    // APELLIDO
                    labelApellido.setVisible(true);
                    mostrarApellido.setText(us.getApellido());
                    mostrarApellido.setVisible(true);
                    
                    // NICKNAME
                    labelNickname.setVisible(true);
                    mostrarNickname.setText(us.getNickname());
                    mostrarNickname.setVisible(true);
                    
                    // EMAIL
                    labelEmail.setVisible(true);
                    mostrarEmail.setText(us.getEmail());
                    mostrarEmail.setVisible(true);
                       
                   
                   
                    if(us instanceof DataEmpresa) {
                    	DataEmpresa use = (DataEmpresa) us;
                    	
                    	labelFechaNac.setVisible(false);
                    	labelNacionalidad.setVisible(false);
                    	mostrarFechaNac.setVisible(false);
                    	mostrarNacionalidad.setVisible(false);
                    	labelPostulaciones.setVisible(false);
                    	comboPostulaciones.setVisible(false);
                    	
                    	// DESCRIPCION
                        labelDescripcion.setVisible(true);
                        mostrarDescripcion.setText(use.getDescripcion());
                        mostrarDescripcion.setVisible(true);
                        
                        // LINK
                        labelLink.setVisible(true);
                        mostrarLink.setText(use.getLink());
                        mostrarLink.setVisible(true);
                    	
                        // OFERTAS
                        labelOfertas.setVisible(true);
                        comboOfertas.setVisible(true);
                        

                    }
                    else if(us instanceof DataPostulante) {
                    	DataPostulante usp = (DataPostulante) us;
                    	
                    	labelOfertas.setVisible(false);
                    	comboOfertas.setVisible(false);
                    	labelDescripcion.setVisible(false);
                    	labelLink.setVisible(false);
                    	mostrarDescripcion.setVisible(false);
                    	mostrarLink.setVisible(false);
                    	
                    	// FECHA NACIMIENTO
                        labelFechaNac.setVisible(true);
                        mostrarFechaNac.setText(usp.getNacimiento());
                        mostrarFechaNac.setVisible(true);
                        
                        // NACIONALIDAD
                        labelNacionalidad.setVisible(true);
                        mostrarNacionalidad.setText(usp.getNacionalidad());
                        mostrarNacionalidad.setVisible(true);
                        
                    	// POSTULACIONES
                        labelPostulaciones.setVisible(true);
                        comboPostulaciones.setVisible(true);
                    	/*consultarOfertaPostulacion.setVisible(true);
                    	consultarOfertaPostulacion.setText("Postulacion");
                    	dtofertas = icu.consultarPostulaciones(us.getNickname());
                    	for(DataOfertaLaboral dtof: dtofertas) {
                    		ofertaPostulacionComboBox.addItem(dtof.getNombre());
                    	}
                    	ofertaPostulacionComboBox.setVisible(true);
                    	consultarOfertaPostulacion.setText("Postulaciones: ");
                    	nomLabelNoChange.setVisible(false);
                    	ciudadLabelNoChange.setVisible(false);
                    	fechaLabelNoChange.setVisible(false);*/
                        
                    }
                    dtofertas2 = dtofertas;
                   /* ofertaPostulacionComboBox.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		String seleccion = (String) ofertaPostulacionComboBox.getSelectedItem();
                    		for(DataOfertaLaboral oferta : dtofertas2) {
                    			if(!dtofertas2.isEmpty())
                    			if(oferta.getNombre().equals(seleccion)) {
                    				mostrarNombre.setText(oferta.getNombre());
                    				mostrarCiudad.setText(oferta.getCuidad());
                    				mostrarFecha.setText(oferta.getFechaAlta());
                    				mostrarNombre.setVisible(true);
                    				mostrarCiudad.setVisible(true);
                    				mostrarFecha.setVisible(true);
                    			}
                    		}
                    	}
                    });*/

                }
            }
        });

	}
}
