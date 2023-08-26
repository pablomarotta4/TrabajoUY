package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DataUsuario;
import logica.datatypes.DataPostulante;
import logica.datatypes.DataEmpresa;
import logica.datatypes.DataOfertaLaboral;
import logica.interfaces.IControladorUsuario;
import java.awt.BorderLayout;
import javax.swing.JPanel;
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

public class ConsultarUsuario  extends JInternalFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorUsuario icu;
	private List<DataOfertaLaboral> dtofertas2= new ArrayList<>();
	
	public ConsultarUsuario(IControladorUsuario cu) {
		icu = cu;	
		setResizable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Crear Usuario");
        setBounds(10, 40, 450, 400);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel NorthPanel = new JPanel();
        getContentPane().add(NorthPanel, BorderLayout.NORTH);
        NorthPanel.setLayout(new GridLayout(3, 0, 0, 0));
        
        JLabel SeleccionarText = new JLabel("Seleccione un usuario:");
        SeleccionarText.setHorizontalAlignment(SwingConstants.CENTER);
        NorthPanel.add(SeleccionarText);
        
        JComboBox<String> UsuariosComboBox = new JComboBox<String>();
        NorthPanel.add(UsuariosComboBox);
        
        List<String> usuariosDisponibles = icu.listarUsuarios();

        UsuariosComboBox.removeAllItems();
       
        for (String usuario : usuariosDisponibles) {
            UsuariosComboBox.addItem(usuario);
        }

        JButton ConsultarButton = new JButton("Consultar datos de usuario");
        NorthPanel.add(ConsultarButton);
        
        JPanel CenterPanel = new JPanel();
        getContentPane().add(CenterPanel, BorderLayout.CENTER);
        GridBagLayout gbl_CenterPanel = new GridBagLayout();
        gbl_CenterPanel.columnWidths = new int[]{30, 100, 0, 0, 0, 0, 100, 0};
        gbl_CenterPanel.rowHeights = new int[]{0, 30, 30, 30, 30, 30, 0};
        gbl_CenterPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_CenterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        CenterPanel.setLayout(gbl_CenterPanel);
        
        JPanel SouthPanel = new JPanel();
        getContentPane().add(SouthPanel, BorderLayout.SOUTH);
        
        JButton ConsultarOfertasButton = new JButton("Consultar ofertas");
        SouthPanel.add(ConsultarOfertasButton);
        
        JPanel EastPanel = new JPanel();
        getContentPane().add(EastPanel, BorderLayout.EAST);
        GridBagLayout gbl_EastPanel = new GridBagLayout();
        gbl_EastPanel.columnWidths = new int[]{112, 112, 0};
        gbl_EastPanel.rowHeights = new int[]{66, 35, 35, 35, 0};
        gbl_EastPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_EastPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        EastPanel.setLayout(gbl_EastPanel);
        
        JLabel consultarOfertaPostulacion = new JLabel("OfertaPostulacion");
        GridBagConstraints gbc_consultarOfertaPostulacion = new GridBagConstraints();
        gbc_consultarOfertaPostulacion.fill = GridBagConstraints.BOTH;
        gbc_consultarOfertaPostulacion.insets = new Insets(0, 0, 5, 5);
        gbc_consultarOfertaPostulacion.gridx = 0;
        gbc_consultarOfertaPostulacion.gridy = 0;
        consultarOfertaPostulacion.setVisible(false);
        EastPanel.add(consultarOfertaPostulacion, gbc_consultarOfertaPostulacion);
        
        JComboBox<String> ofertaPostulacionComboBox = new JComboBox<String>();
        ofertaPostulacionComboBox.setMaximumRowCount(15);
        GridBagConstraints gbc_ofertaPostulacionComboBox = new GridBagConstraints();
        gbc_ofertaPostulacionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_ofertaPostulacionComboBox.fill = GridBagConstraints.BOTH;
        gbc_ofertaPostulacionComboBox.gridx = 1;
        gbc_ofertaPostulacionComboBox.gridy = 0;
        ofertaPostulacionComboBox.setVisible(false);
        EastPanel.add(ofertaPostulacionComboBox, gbc_ofertaPostulacionComboBox);
        
        JLabel nomLabelNoChange = new JLabel("Nombre:");
        GridBagConstraints gbc_nomLabelNoChange = new GridBagConstraints();
        gbc_nomLabelNoChange.insets = new Insets(0, 0, 5, 5);
        gbc_nomLabelNoChange.gridx = 0;
        gbc_nomLabelNoChange.gridy = 1;
        EastPanel.add(nomLabelNoChange, gbc_nomLabelNoChange);
        nomLabelNoChange.setVisible(false);
        
        JLabel mostrarNombre = new JLabel("");
        GridBagConstraints gbc_mostrarNombre = new GridBagConstraints();
        gbc_mostrarNombre.insets = new Insets(0, 0, 5, 0);
        gbc_mostrarNombre.gridx = 1;
        gbc_mostrarNombre.gridy = 1;
        EastPanel.add(mostrarNombre, gbc_mostrarNombre);
        
        JLabel ciudadLabelNoChange = new JLabel("Ciudad:");
        GridBagConstraints gbc_ciudadLabelNoChange = new GridBagConstraints();
        gbc_ciudadLabelNoChange.insets = new Insets(0, 0, 5, 5);
        gbc_ciudadLabelNoChange.gridx = 0;
        gbc_ciudadLabelNoChange.gridy = 2;
        EastPanel.add(ciudadLabelNoChange, gbc_ciudadLabelNoChange);
        ciudadLabelNoChange.setVisible(false);
        
        JLabel mostrarCiudad = new JLabel("");
        GridBagConstraints gbc_mostrarCiudad = new GridBagConstraints();
        gbc_mostrarCiudad.insets = new Insets(0, 0, 5, 0);
        gbc_mostrarCiudad.gridx = 1;
        gbc_mostrarCiudad.gridy = 2;
        EastPanel.add(mostrarCiudad, gbc_mostrarCiudad);
        
        JLabel fechaLabelNoChange = new JLabel("Fecha:");
        GridBagConstraints gbc_fechaLabelNoChange = new GridBagConstraints();
        gbc_fechaLabelNoChange.insets = new Insets(0, 0, 0, 5);
        gbc_fechaLabelNoChange.gridx = 0;
        gbc_fechaLabelNoChange.gridy = 3;
        EastPanel.add(fechaLabelNoChange, gbc_fechaLabelNoChange);
        fechaLabelNoChange.setVisible(false);
        
        JLabel mostrarFecha = new JLabel("");
        GridBagConstraints gbc_mostrarFecha = new GridBagConstraints();
        gbc_mostrarFecha.gridx = 1;
        gbc_mostrarFecha.gridy = 3;
        EastPanel.add(mostrarFecha, gbc_mostrarFecha);
        
        mostrarNombre.setVisible(false);
		mostrarCiudad.setVisible(false);
		mostrarFecha.setVisible(false);
        
        
        ConsultarButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		String seleccionado = (String) UsuariosComboBox.getSelectedItem();
        		if(!seleccionado.isEmpty()) {
        			DataUsuario us = icu.consultarDatosUsuario(seleccionado);
        			List<DataOfertaLaboral> dtofertas = new ArrayList<>();
                    CenterPanel.removeAll();
                    
                    JLabel nombreLabel = new JLabel("Nombre: " + us.getNombre());
                    GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
                    gbc_nombreLabel.anchor = GridBagConstraints.WEST;
                    gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
                    gbc_nombreLabel.gridx = 1;
                    gbc_nombreLabel.gridy = 1;
                    CenterPanel.add(nombreLabel, gbc_nombreLabel);
                    
                    JLabel apellidoLabel = new JLabel("Apellido: " + us.getApellido());
                    GridBagConstraints gbc_apellidoLabel = new GridBagConstraints();
                    gbc_apellidoLabel.anchor = GridBagConstraints.WEST;
                    gbc_apellidoLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_apellidoLabel.gridx = 6;
                    gbc_apellidoLabel.gridy = 1;
                    CenterPanel.add(apellidoLabel, gbc_apellidoLabel);
                    
                    JLabel nicknameLabel = new JLabel("Nickname: " + us.getNickname());
                    GridBagConstraints gbc_nicknameLabel = new GridBagConstraints();
                    gbc_nicknameLabel.anchor = GridBagConstraints.WEST;
                    gbc_nicknameLabel.insets = new Insets(0, 0, 5, 5);
                    gbc_nicknameLabel.gridx = 1;
                    gbc_nicknameLabel.gridy = 2;
                    CenterPanel.add(nicknameLabel, gbc_nicknameLabel);
                    
                    JLabel emailLabel = new JLabel("Email: " + us.getEmail());
                    GridBagConstraints gbc_emailLabel = new GridBagConstraints();
                    gbc_emailLabel.anchor = GridBagConstraints.WEST;
                    gbc_emailLabel.insets = new Insets(0, 0, 0, 5);
                    gbc_emailLabel.gridx = 1;
                    gbc_emailLabel.gridy = 3;
                    CenterPanel.add(emailLabel, gbc_emailLabel);     
                   
                   
                    if(us instanceof DataEmpresa) {
                    	DataEmpresa usE = (DataEmpresa) us;
                    	JLabel descripcionLabel = new JLabel("Descripcion: " + usE.getDescripcion());
                    	GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
                    	gbc_descripcionLabel.anchor = GridBagConstraints.WEST;
                    	gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
                    	gbc_descripcionLabel.gridx = 1;
                    	gbc_descripcionLabel.gridy = 4;
                    	JLabel linkLabel = new JLabel("Link: " + usE.getLink());
                    	GridBagConstraints gbc_linkLabel = new GridBagConstraints();
                    	gbc_linkLabel.anchor = GridBagConstraints.WEST;
                    	gbc_linkLabel.insets = new Insets(0, 0, 0, 5);
                    	gbc_linkLabel.gridx = 1;
                    	gbc_linkLabel.gridy = 5;
                    	CenterPanel.add(descripcionLabel, gbc_descripcionLabel);
                    	CenterPanel.add(linkLabel,gbc_linkLabel);
                    	consultarOfertaPostulacion.setText("Ofertas de la empresa: ");
                    	dtofertas = icu.consultarOfertas(us.getNickname());
                    	for(DataOfertaLaboral dtof: dtofertas) {
                    		ofertaPostulacionComboBox.addItem(dtof.getNombre());
                    	}
                    	consultarOfertaPostulacion.setVisible(true);
                    	ofertaPostulacionComboBox.setVisible(true);
                    	nomLabelNoChange.setVisible(false);
                    	ciudadLabelNoChange.setVisible(false);
                    	fechaLabelNoChange.setVisible(false);
                        

                    }
                    else if(us instanceof DataPostulante) {
                    	DataPostulante usP = (DataPostulante) us;
                    	JLabel nacionalidadLabel = new JLabel("Nacionalidad: " + usP.getNacionalidad());
                    	GridBagConstraints gbc_nacionalidadLabel = new GridBagConstraints();
                    	gbc_nacionalidadLabel.anchor = GridBagConstraints.WEST;
                    	gbc_nacionalidadLabel.insets = new Insets(0, 0, 5, 5);
                    	gbc_nacionalidadLabel.gridx = 1;
                    	gbc_nacionalidadLabel.gridy = 4;
                    	JLabel nacimientoLabel = new JLabel("Fecha de nacimiento: " + usP.getNacimiento());
                    	GridBagConstraints gbc_nacimientoLabel = new GridBagConstraints();
                    	gbc_nacimientoLabel.anchor = GridBagConstraints.WEST;
                    	gbc_nacimientoLabel.insets = new Insets(0, 0, 0, 5);
                    	gbc_nacimientoLabel.gridx = 1;
                    	gbc_nacimientoLabel.gridy = 5;
                    	CenterPanel.add(nacionalidadLabel, gbc_nacionalidadLabel);
                    	CenterPanel.add(nacimientoLabel,gbc_nacimientoLabel);
                    	consultarOfertaPostulacion.setVisible(true);
                    	consultarOfertaPostulacion.setText("Postulacion");
                    	dtofertas = icu.consultarPostulaciones(us.getNickname());
                    	for(DataOfertaLaboral dtof: dtofertas) {
                    		ofertaPostulacionComboBox.addItem(dtof.getNombre());
                    	}
                    	ofertaPostulacionComboBox.setVisible(true);
                    	consultarOfertaPostulacion.setText("Postulaciones: ");
                    	nomLabelNoChange.setVisible(false);
                    	ciudadLabelNoChange.setVisible(false);
                    	fechaLabelNoChange.setVisible(false);
                        
                    }
                    dtofertas2 = dtofertas;
                    ofertaPostulacionComboBox.addActionListener(new ActionListener() {
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
                    });

                   
                    CenterPanel.revalidate();
                    CenterPanel.repaint();
                }
            }
        });

	}
}