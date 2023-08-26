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
        setTitle("Consulta Usuario");
        setBounds(10, 40, 1137, 658);
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
        gbl_CenterPanel.columnWidths = new int[]{30, 327, 0};
        gbl_CenterPanel.rowHeights = new int[]{30, 30, 30, 30, 30, 211, 25, 0};
        gbl_CenterPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_CenterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        CenterPanel.setLayout(gbl_CenterPanel);
        
        JPanel SouthPanel = new JPanel();
        getContentPane().add(SouthPanel, BorderLayout.SOUTH);
        
        JButton ConsultarOfertasButton = new JButton("Consultar ofertas");
        SouthPanel.add(ConsultarOfertasButton);
        
        JPanel EastPanel = new JPanel();
        getContentPane().add(EastPanel, BorderLayout.EAST);
        GridBagLayout gbl_EastPanel = new GridBagLayout();
        gbl_EastPanel.columnWidths = new int[]{0, 112, 112, 0};
        gbl_EastPanel.rowHeights = new int[]{35, 35, 35, 35, 0};
        gbl_EastPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_EastPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        EastPanel.setLayout(gbl_EastPanel);
        
        JLabel consultarOfertaPostulacion = new JLabel("OfertaPostulacion");
        GridBagConstraints gbc_consultarOfertaPostulacion = new GridBagConstraints();
        gbc_consultarOfertaPostulacion.fill = GridBagConstraints.BOTH;
        gbc_consultarOfertaPostulacion.insets = new Insets(0, 0, 5, 5);
        gbc_consultarOfertaPostulacion.gridx = 1;
        gbc_consultarOfertaPostulacion.gridy = 0;
        consultarOfertaPostulacion.setVisible(false);
        EastPanel.add(consultarOfertaPostulacion, gbc_consultarOfertaPostulacion);
        
        JComboBox<String> ofertaPostulacionComboBox = new JComboBox<String>();
        ofertaPostulacionComboBox.setMaximumRowCount(15);
        GridBagConstraints gbc_ofertaPostulacionComboBox = new GridBagConstraints();
        gbc_ofertaPostulacionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_ofertaPostulacionComboBox.fill = GridBagConstraints.BOTH;
        gbc_ofertaPostulacionComboBox.gridx = 2;
        gbc_ofertaPostulacionComboBox.gridy = 0;
        ofertaPostulacionComboBox.setVisible(false);
        EastPanel.add(ofertaPostulacionComboBox, gbc_ofertaPostulacionComboBox);
        
        JLabel nomLabelNoChange = new JLabel("Nombre:");
        GridBagConstraints gbc_nomLabelNoChange = new GridBagConstraints();
        gbc_nomLabelNoChange.anchor = GridBagConstraints.WEST;
        gbc_nomLabelNoChange.insets = new Insets(0, 0, 5, 5);
        gbc_nomLabelNoChange.gridx = 1;
        gbc_nomLabelNoChange.gridy = 1;
        EastPanel.add(nomLabelNoChange, gbc_nomLabelNoChange);
        nomLabelNoChange.setVisible(false);
        
        JTextArea mostrarNombre = new JTextArea("");
        GridBagConstraints gbc_mostrarNombre = new GridBagConstraints();
        gbc_mostrarNombre.insets = new Insets(0, 0, 5, 0);
        gbc_mostrarNombre.gridx = 2;
        gbc_mostrarNombre.gridy = 1;
        EastPanel.add(mostrarNombre, gbc_mostrarNombre);
        
        JLabel ciudadLabelNoChange = new JLabel("Ciudad:");
        GridBagConstraints gbc_ciudadLabelNoChange = new GridBagConstraints();
        gbc_ciudadLabelNoChange.anchor = GridBagConstraints.WEST;
        gbc_ciudadLabelNoChange.insets = new Insets(0, 0, 5, 5);
        gbc_ciudadLabelNoChange.gridx = 1;
        gbc_ciudadLabelNoChange.gridy = 2;
        EastPanel.add(ciudadLabelNoChange, gbc_ciudadLabelNoChange);
        ciudadLabelNoChange.setVisible(false);
        
        JTextArea mostrarCiudad = new JTextArea("");
        GridBagConstraints gbc_mostrarCiudad = new GridBagConstraints();
        gbc_mostrarCiudad.insets = new Insets(0, 0, 5, 0);
        gbc_mostrarCiudad.gridx = 2;
        gbc_mostrarCiudad.gridy = 2;
        EastPanel.add(mostrarCiudad, gbc_mostrarCiudad);
        
        JLabel fechaLabelNoChange = new JLabel("Fecha:");
        GridBagConstraints gbc_fechaLabelNoChange = new GridBagConstraints();
        gbc_fechaLabelNoChange.anchor = GridBagConstraints.WEST;
        gbc_fechaLabelNoChange.insets = new Insets(0, 0, 0, 5);
        gbc_fechaLabelNoChange.gridx = 1;
        gbc_fechaLabelNoChange.gridy = 3;
        EastPanel.add(fechaLabelNoChange, gbc_fechaLabelNoChange);
        fechaLabelNoChange.setVisible(false);
        
        JTextArea mostrarFecha = new JTextArea("");
        GridBagConstraints gbc_mostrarFecha = new GridBagConstraints();
        gbc_mostrarFecha.gridx = 2;
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
                    JLabel nombreL = new JLabel("Nombre: ");     
                    GridBagConstraints gbc_nombreL = new GridBagConstraints();
                    gbc_nombreL.anchor = GridBagConstraints.WEST;
                    gbc_nombreL.insets = new Insets(0, 0, 5, 5);
                    gbc_nombreL.gridx = 0;
                    gbc_nombreL.gridy = 1;
                    CenterPanel.add(nombreL, gbc_nombreL);
                    JTextArea nombreLabel = new JTextArea(us.getNombre());
                    GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
                    gbc_nombreLabel.anchor = GridBagConstraints.WEST;
                    gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
                    gbc_nombreLabel.gridx = 1;
                    gbc_nombreLabel.gridy = 1;
                    nombreLabel.setLineWrap(true);
                    nombreLabel.setWrapStyleWord(true);
                    gbc_nombreLabel.gridwidth = GridBagConstraints.REMAINDER;
                    gbc_nombreLabel.fill = GridBagConstraints.HORIZONTAL;
                    CenterPanel.add(nombreLabel, gbc_nombreLabel);
                    
                    JLabel apellidoL = new JLabel("Apellido: ");     
                    GridBagConstraints gbc_apellidoL = new GridBagConstraints();
                    gbc_apellidoL.anchor = GridBagConstraints.WEST;
                    gbc_apellidoL.insets = new Insets(0, 0, 5, 5);
                    gbc_apellidoL.gridx = 0;
                    gbc_apellidoL.gridy = 2;
                    CenterPanel.add(apellidoL, gbc_apellidoL);
                    JTextArea apellidoLabel = new JTextArea(us.getApellido());
                    GridBagConstraints gbc_apellidoLabel = new GridBagConstraints();
                    gbc_apellidoLabel.anchor = GridBagConstraints.WEST;
                    gbc_apellidoLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_apellidoLabel.gridx = 1;
                    gbc_apellidoLabel.gridy = 2;
                    apellidoLabel.setLineWrap(true);
                    apellidoLabel.setWrapStyleWord(true);
                    gbc_apellidoLabel.gridwidth = GridBagConstraints.REMAINDER;
                    gbc_apellidoLabel.fill = GridBagConstraints.HORIZONTAL;
                    CenterPanel.add(apellidoLabel, gbc_apellidoLabel);
                    
                    JLabel nicknameL = new JLabel("Nickname: ");     
                    GridBagConstraints gbc_nicknameL = new GridBagConstraints();
                    gbc_nicknameL.anchor = GridBagConstraints.WEST;
                    gbc_nicknameL.insets = new Insets(0, 0, 5, 5);
                    gbc_nicknameL.gridx = 0;
                    gbc_nicknameL.gridy = 3;
                    CenterPanel.add(nicknameL, gbc_nicknameL);
                    JTextArea nicknameLabel = new JTextArea(us.getNickname());
                    GridBagConstraints gbc_nicknameLabel = new GridBagConstraints();
                    gbc_nicknameLabel.anchor = GridBagConstraints.WEST;
                    gbc_nicknameLabel.insets = new Insets(0, 0, 5, 5);
                    gbc_nicknameLabel.gridx = 1;
                    gbc_nicknameLabel.gridy = 3;
                    CenterPanel.add(nicknameLabel, gbc_nicknameLabel);
                    
                    JLabel emailL = new JLabel("Email: ");     
                    GridBagConstraints gbc_emailL = new GridBagConstraints();
                    gbc_emailL.anchor = GridBagConstraints.WEST;
                    gbc_emailL.insets = new Insets(0, 0, 5, 5);
                    gbc_emailL.gridx = 0;
                    gbc_emailL.gridy = 4;
                    CenterPanel.add(emailL, gbc_emailL);
                    JTextArea emailLabel = new JTextArea(us.getEmail());
                    GridBagConstraints gbc_emailLabel = new GridBagConstraints();
                    gbc_emailLabel.anchor = GridBagConstraints.WEST;
                    gbc_emailLabel.insets = new Insets(0, 0, 0, 5);
                    gbc_emailLabel.gridx = 1;
                    gbc_emailLabel.gridy = 4;
                    emailLabel.setLineWrap(true);
                    emailLabel.setWrapStyleWord(true);
                	gbc_emailLabel.gridwidth = GridBagConstraints.REMAINDER;
                	gbc_emailLabel.fill = GridBagConstraints.HORIZONTAL; 
                    CenterPanel.add(emailLabel, gbc_emailLabel);     
                   
                   
                    if(us instanceof DataEmpresa) {
                    	DataEmpresa usE = (DataEmpresa) us;
                    	gbl_CenterPanel.rowHeights = new int[]{30, 30, 30, 30, 30, 211, 30, 0};
                    	JLabel descripcionL = new JLabel("Descripcion: ");     
                        GridBagConstraints gbc_descripcionL = new GridBagConstraints();
                        gbc_descripcionL.anchor = GridBagConstraints.WEST;
                        gbc_descripcionL.insets = new Insets(0, 0, 5, 5);
                        gbc_descripcionL.gridx = 0;
                        gbc_descripcionL.gridy = 5;
                        CenterPanel.add(descripcionL, gbc_descripcionL);
                        descripcionL.setVisible(true);
                    	JTextArea descripcionArea = new JTextArea(usE.getDescripcion());
                        descripcionArea.setLineWrap(true);
                        descripcionArea.setWrapStyleWord(true);
                        JScrollPane descripcionScroll = new JScrollPane(descripcionArea);
                        descripcionScroll.setPreferredSize(new Dimension(400, 100));
                        
                        GridBagConstraints gbc_descripcionScroll = new GridBagConstraints();
                        gbc_descripcionScroll.anchor = GridBagConstraints.WEST;
                        gbc_descripcionScroll.insets = new Insets(0, 0, 5, 5);
                        gbc_descripcionScroll.gridx = 1;
                        gbc_descripcionScroll.gridy = 5;
                        gbc_descripcionScroll.gridwidth = 2;
                        gbc_descripcionScroll.fill = GridBagConstraints.BOTH;
                        CenterPanel.add(descripcionScroll, gbc_descripcionScroll);
                    	
                        JLabel linkL = new JLabel("Link: ");     
                        GridBagConstraints gbc_linkL = new GridBagConstraints();
                        gbc_linkL.anchor = GridBagConstraints.WEST;
                        gbc_linkL.insets = new Insets(0, 0, 5, 5);
                        gbc_linkL.gridx = 0;
                        gbc_linkL.gridy = 6;
                        CenterPanel.add(linkL, gbc_linkL);
                    	JTextArea linkLabel = new JTextArea(usE.getLink());
                    	linkL.setVisible(true);
                    	GridBagConstraints gbc_linkLabel = new GridBagConstraints();
                    	linkLabel.setLineWrap(true);
                    	linkLabel.setWrapStyleWord(true);
                    	gbc_linkLabel.gridwidth = GridBagConstraints.REMAINDER;
                    	gbc_linkLabel.fill = GridBagConstraints.HORIZONTAL; 
                    	gbc_linkLabel.anchor = GridBagConstraints.WEST;
                    	gbc_linkLabel.insets = new Insets(0, 0, 0, 5);
                    	gbc_linkLabel.gridx = 1;
                    	gbc_linkLabel.gridy = 6;
                    	CenterPanel.add(descripcionScroll, gbc_descripcionScroll);
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
                    	gbl_CenterPanel.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 0};
                    	 JLabel nacionalidadL = new JLabel("Nacionalidad: ");     
                         GridBagConstraints gbc_nacionalidadL = new GridBagConstraints();
                         gbc_nacionalidadL.anchor = GridBagConstraints.WEST;
                         gbc_nacionalidadL.insets = new Insets(0, 0, 5, 5);
                         gbc_nacionalidadL.gridx = 0;
                         gbc_nacionalidadL.gridy = 5;
                         CenterPanel.add(nacionalidadL, gbc_nacionalidadL);
                    	JTextArea nacionalidadLabel = new JTextArea(usP.getNacionalidad());
                    	GridBagConstraints gbc_nacionalidadLabel = new GridBagConstraints();
                    	gbc_nacionalidadLabel.anchor = GridBagConstraints.WEST;
                    	gbc_nacionalidadLabel.insets = new Insets(0, 0, 5, 5);
                    	gbc_nacionalidadLabel.gridx = 1;
                    	gbc_nacionalidadLabel.gridy = 5;
                    	JLabel nacimientoL = new JLabel("Nacimiento: ");     
                        GridBagConstraints gbc_nacimientoL = new GridBagConstraints();
                        gbc_nacimientoL.anchor = GridBagConstraints.WEST;
                        gbc_nacimientoL.insets = new Insets(0, 0, 5, 5);
                        gbc_nacimientoL.gridx = 0;
                        gbc_nacimientoL.gridy = 6;
                        CenterPanel.add(nacimientoL, gbc_nacimientoL);
                    	JTextArea nacimientoLabel = new JTextArea(usP.getNacimiento());
                    	GridBagConstraints gbc_nacimientoLabel = new GridBagConstraints();
                    	gbc_nacimientoLabel.anchor = GridBagConstraints.WEST;
                    	gbc_nacimientoLabel.insets = new Insets(0, 0, 0, 5);
                    	gbc_nacimientoLabel.gridx = 1;
                    	gbc_nacimientoLabel.gridy = 6;
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
