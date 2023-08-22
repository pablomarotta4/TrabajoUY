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
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class CrearOfertaLaboral extends JInternalFrame{
	
	private IControladorOferta ctrlOferta;
	private IControladorUsuario ctrlUsuario;
	
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
        gridBagLayout.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        // ####### Fila 1 #########
        JLabel lblEmpresa = new JLabel("Seleccionar empresa");
        GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
        gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmpresa.fill = GridBagConstraints.VERTICAL;
        gbc_lblEmpresa.gridx = 0;
        gbc_lblEmpresa.gridy = 0;
        getContentPane().add(lblEmpresa, gbc_lblEmpresa);
        
        JComboBox<String> comboBox = new JComboBox<String>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.VERTICAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        getContentPane().add(comboBox, gbc_comboBox);
        
      
        // Datos de prueba
        comboBox.addItem("nickempresa1");
        comboBox.addItem("nickempresa2");
        //################################################################
        
        // Fila 2
        JLabel lblTipoPublicacion = new JLabel("Seleccionar tipo de publicacion");
        GridBagConstraints gbc_lblTipoPublicacion = new GridBagConstraints();
        gbc_lblTipoPublicacion.fill = GridBagConstraints.VERTICAL;
        gbc_lblTipoPublicacion.insets = new Insets(0, 0, 5, 5);
        gbc_lblTipoPublicacion.gridx = 0;
        gbc_lblTipoPublicacion.gridy = 1;
        getContentPane().add(lblTipoPublicacion, gbc_lblTipoPublicacion);
        // ####
     

	}
	
}
