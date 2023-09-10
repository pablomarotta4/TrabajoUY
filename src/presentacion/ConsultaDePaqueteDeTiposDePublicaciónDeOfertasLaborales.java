package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.ScrollPaneConstants;

import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JList;

public class ConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales extends JInternalFrame{
	private JTextField tfNombre;
	private JTextField tfCosto;
	private JTextField tfDescuento;
	private JTextField tfPeriodoDeValidez;
	private JTextField tfDiaCompra;
	private JTextField tfMesCompra;
	private JTextField tfAñoCompra;
	private JTextField tfDiaVencimiento;
	private JTextField tfMesVencimiento;
	private JTextField tfAñoVencimiento;
	private JTextField tfNombreTipo;
	private JTextField tfCostoTipo;
	private JTextField tfExposicionTipo;
	private JTextField tfDuracionTipo;
	private JTextField tfDiaTipo;
	private JTextField tfMesTipo;
	private JTextField tfAñoTipo;
	
	public ConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales() {
		
		Factory f = Factory.getInstance();
		IControladorOferta ico = f.getControladorOferta();
		IControladorUsuario icu = f.getControladorUsuario();
		IControladorCompraTipo icc = f.getControladorCompraTipo();
		
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta De Paquete De Tipos De Publicación De Ofertas Laborales");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{12, 120, 200, 30, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 150, 150, 0, 0, 0, 0, 0, 150, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		GridBagConstraints gbc_lblPaquetes = new GridBagConstraints();
		gbc_lblPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaquetes.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPaquetes.gridx = 1;
		gbc_lblPaquetes.gridy = 1;
		panel.add(lblPaquetes, gbc_lblPaquetes);
		
		JComboBox cbPaquetes = new JComboBox();
		GridBagConstraints gbc_cbPaquetes = new GridBagConstraints();
		gbc_cbPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_cbPaquetes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPaquetes.gridx = 2;
		gbc_cbPaquetes.gridy = 1;
		panel.add(cbPaquetes, gbc_cbPaquetes);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBackground(new Color(255, 255, 255));
		tfNombre.setForeground(new Color(0, 0, 0));
		tfNombre.setEditable(false);
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 2;
		gbc_tfNombre.gridy = 2;
		panel.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo:");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 1;
		gbc_lblCosto.gridy = 3;
		panel.add(lblCosto, gbc_lblCosto);
		
		tfCosto = new JTextField();
		tfCosto.setBackground(new Color(255, 255, 255));
		tfCosto.setEditable(false);
		GridBagConstraints gbc_tfCosto = new GridBagConstraints();
		gbc_tfCosto.insets = new Insets(0, 0, 5, 5);
		gbc_tfCosto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCosto.gridx = 2;
		gbc_tfCosto.gridy = 3;
		panel.add(tfCosto, gbc_tfCosto);
		tfCosto.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 4;
		panel.add(lblDescuento, gbc_lblDescuento);
		
		tfDescuento = new JTextField();
		tfDescuento.setBackground(new Color(255, 255, 255));
		tfDescuento.setEditable(false);
		GridBagConstraints gbc_tfDescuento = new GridBagConstraints();
		gbc_tfDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_tfDescuento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDescuento.gridx = 2;
		gbc_tfDescuento.gridy = 4;
		panel.add(tfDescuento, gbc_tfDescuento);
		tfDescuento.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Periodo de Validez:");
		GridBagConstraints gbc_lblPeriodo = new GridBagConstraints();
		gbc_lblPeriodo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPeriodo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeriodo.gridx = 1;
		gbc_lblPeriodo.gridy = 5;
		panel.add(lblPeriodo, gbc_lblPeriodo);
		
		tfPeriodoDeValidez = new JTextField();
		tfPeriodoDeValidez.setBackground(new Color(255, 255, 255));
		tfPeriodoDeValidez.setEditable(false);
		GridBagConstraints gbc_tfPeriodoDeValidez = new GridBagConstraints();
		gbc_tfPeriodoDeValidez.insets = new Insets(0, 0, 5, 5);
		gbc_tfPeriodoDeValidez.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPeriodoDeValidez.gridx = 2;
		gbc_tfPeriodoDeValidez.gridy = 5;
		panel.add(tfPeriodoDeValidez, gbc_tfPeriodoDeValidez);
		tfPeriodoDeValidez.setColumns(10);
		
		JLabel lblFechaCompra = new JLabel("Fecha de Compra:");
		GridBagConstraints gbc_lblFechaCompra = new GridBagConstraints();
		gbc_lblFechaCompra.anchor = GridBagConstraints.EAST;
		gbc_lblFechaCompra.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaCompra.gridx = 1;
		gbc_lblFechaCompra.gridy = 6;
		panel.add(lblFechaCompra, gbc_lblFechaCompra);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 6;
		panel.add(panel_3, gbc_panel_3);
		
		JLabel lblDiaCompra = new JLabel("Dia:");
		panel_3.add(lblDiaCompra);
		
		tfDiaCompra = new JTextField();
		tfDiaCompra.setBackground(new Color(255, 255, 255));
		tfDiaCompra.setEditable(false);
		panel_3.add(tfDiaCompra);
		tfDiaCompra.setColumns(10);
		
		JLabel lblMesCompra = new JLabel("Mes:");
		panel_3.add(lblMesCompra);
		
		tfMesCompra = new JTextField();
		tfMesCompra.setBackground(new Color(255, 255, 255));
		tfMesCompra.setEditable(false);
		panel_3.add(tfMesCompra);
		tfMesCompra.setColumns(10);
		
		JLabel lblAñoCompra = new JLabel("Año:");
		panel_3.add(lblAñoCompra);
		
		tfAñoCompra = new JTextField();
		tfAñoCompra.setBackground(new Color(255, 255, 255));
		tfAñoCompra.setEditable(false);
		panel_3.add(tfAñoCompra);
		tfAñoCompra.setColumns(10);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha de Vencimiento:");
		GridBagConstraints gbc_lblFechaVencimiento = new GridBagConstraints();
		gbc_lblFechaVencimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaVencimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaVencimiento.gridx = 1;
		gbc_lblFechaVencimiento.gridy = 7;
		panel.add(lblFechaVencimiento, gbc_lblFechaVencimiento);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 7;
		panel.add(panel_4, gbc_panel_4);
		
		JLabel lblDiaVencimiento = new JLabel("Dia:");
		panel_4.add(lblDiaVencimiento);
		
		tfDiaVencimiento = new JTextField();
		tfDiaVencimiento.setBackground(new Color(255, 255, 255));
		tfDiaVencimiento.setEditable(false);
		panel_4.add(tfDiaVencimiento);
		tfDiaVencimiento.setColumns(10);
		
		JLabel lblMesVencimiento = new JLabel("Mes:");
		panel_4.add(lblMesVencimiento);
		
		tfMesVencimiento = new JTextField();
		tfMesVencimiento.setBackground(new Color(255, 255, 255));
		tfMesVencimiento.setEditable(false);
		panel_4.add(tfMesVencimiento);
		tfMesVencimiento.setColumns(10);
		
		JLabel lblAñoVencimiento = new JLabel("Año:");
		panel_4.add(lblAñoVencimiento);
		
		tfAñoVencimiento = new JTextField();
		tfAñoVencimiento.setBackground(new Color(255, 255, 255));
		tfAñoVencimiento.setEditable(false);
		panel_4.add(tfAñoVencimiento);
		tfAñoVencimiento.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 8;
		panel.add(lblDescripcion, gbc_lblDescripcion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 8;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea taDescripcion = new JTextArea();
		taDescripcion.setBackground(new Color(255, 255, 255));
		taDescripcion.setEditable(false);
		taDescripcion.setLineWrap(true);
		scrollPane_1.setViewportView(taDescripcion);
		
		JLabel lblTipos = new JLabel("Tipos de Publicacion:");
		GridBagConstraints gbc_lblTipos = new GridBagConstraints();
		gbc_lblTipos.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTipos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipos.gridx = 1;
		gbc_lblTipos.gridy = 9;
		panel.add(lblTipos, gbc_lblTipos);
		
		JList listTipos = new JList();
		GridBagConstraints gbc_listTipos = new GridBagConstraints();
		gbc_listTipos.insets = new Insets(0, 0, 5, 5);
		gbc_listTipos.fill = GridBagConstraints.BOTH;
		gbc_listTipos.gridx = 2;
		gbc_listTipos.gridy = 9;
		panel.add(listTipos, gbc_listTipos);
		
		JLabel lblNombreTipo = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombreTipo = new GridBagConstraints();
		gbc_lblNombreTipo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombreTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreTipo.gridx = 1;
		gbc_lblNombreTipo.gridy = 10;
		panel.add(lblNombreTipo, gbc_lblNombreTipo);
		
		tfNombreTipo = new JTextField();
		tfNombreTipo.setBackground(new Color(255, 255, 255));
		tfNombreTipo.setEditable(false);
		GridBagConstraints gbc_tfNombreTipo = new GridBagConstraints();
		gbc_tfNombreTipo.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombreTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombreTipo.gridx = 2;
		gbc_tfNombreTipo.gridy = 10;
		panel.add(tfNombreTipo, gbc_tfNombreTipo);
		tfNombreTipo.setColumns(10);
		
		JLabel lblCostoTipo = new JLabel("Costo:");
		GridBagConstraints gbc_lblCostoTipo = new GridBagConstraints();
		gbc_lblCostoTipo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblCostoTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostoTipo.gridx = 1;
		gbc_lblCostoTipo.gridy = 11;
		panel.add(lblCostoTipo, gbc_lblCostoTipo);
		
		tfCostoTipo = new JTextField();
		tfCostoTipo.setBackground(new Color(255, 255, 255));
		tfCostoTipo.setEditable(false);
		GridBagConstraints gbc_tfCostoTipo = new GridBagConstraints();
		gbc_tfCostoTipo.insets = new Insets(0, 0, 5, 5);
		gbc_tfCostoTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCostoTipo.gridx = 2;
		gbc_tfCostoTipo.gridy = 11;
		panel.add(tfCostoTipo, gbc_tfCostoTipo);
		tfCostoTipo.setColumns(10);
		
		JLabel lblExposicionTipo = new JLabel("Exposicion:");
		GridBagConstraints gbc_lblExposicionTipo = new GridBagConstraints();
		gbc_lblExposicionTipo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblExposicionTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblExposicionTipo.gridx = 1;
		gbc_lblExposicionTipo.gridy = 12;
		panel.add(lblExposicionTipo, gbc_lblExposicionTipo);
		
		tfExposicionTipo = new JTextField();
		tfExposicionTipo.setBackground(new Color(255, 255, 255));
		tfExposicionTipo.setEditable(false);
		GridBagConstraints gbc_tfExposicionTipo = new GridBagConstraints();
		gbc_tfExposicionTipo.insets = new Insets(0, 0, 5, 5);
		gbc_tfExposicionTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfExposicionTipo.gridx = 2;
		gbc_tfExposicionTipo.gridy = 12;
		panel.add(tfExposicionTipo, gbc_tfExposicionTipo);
		tfExposicionTipo.setColumns(10);
		
		JLabel lblDuracionTipo = new JLabel("Duracion:");
		GridBagConstraints gbc_lblDuracionTipo = new GridBagConstraints();
		gbc_lblDuracionTipo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDuracionTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracionTipo.gridx = 1;
		gbc_lblDuracionTipo.gridy = 13;
		panel.add(lblDuracionTipo, gbc_lblDuracionTipo);
		
		tfDuracionTipo = new JTextField();
		tfDuracionTipo.setBackground(new Color(255, 255, 255));
		tfDuracionTipo.setEditable(false);
		GridBagConstraints gbc_tfDuracionTipo = new GridBagConstraints();
		gbc_tfDuracionTipo.insets = new Insets(0, 0, 5, 5);
		gbc_tfDuracionTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDuracionTipo.gridx = 2;
		gbc_tfDuracionTipo.gridy = 13;
		panel.add(tfDuracionTipo, gbc_tfDuracionTipo);
		tfDuracionTipo.setColumns(10);
		
		JLabel lblFechaAltaTipo = new JLabel("Fecha de Alta:");
		GridBagConstraints gbc_lblFechaAltaTipo = new GridBagConstraints();
		gbc_lblFechaAltaTipo.anchor = GridBagConstraints.EAST;
		gbc_lblFechaAltaTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaAltaTipo.gridx = 1;
		gbc_lblFechaAltaTipo.gridy = 14;
		panel.add(lblFechaAltaTipo, gbc_lblFechaAltaTipo);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 14;
		panel.add(panel_5, gbc_panel_5);
		
		JLabel lblDiaTipo = new JLabel("Dia:");
		panel_5.add(lblDiaTipo);
		
		tfDiaTipo = new JTextField();
		tfDiaTipo.setBackground(new Color(255, 255, 255));
		tfDiaTipo.setEditable(false);
		panel_5.add(tfDiaTipo);
		tfDiaTipo.setColumns(10);
		
		JLabel lblMesTipo = new JLabel("Mes:");
		panel_5.add(lblMesTipo);
		
		tfMesTipo = new JTextField();
		tfMesTipo.setBackground(new Color(255, 255, 255));
		tfMesTipo.setEditable(false);
		panel_5.add(tfMesTipo);
		tfMesTipo.setColumns(10);
		
		JLabel lblAñoTipo = new JLabel("Año:");
		panel_5.add(lblAñoTipo);
		
		tfAñoTipo = new JTextField();
		tfAñoTipo.setBackground(new Color(255, 255, 255));
		tfAñoTipo.setEditable(false);
		panel_5.add(tfAñoTipo);
		tfAñoTipo.setColumns(10);
		
		JLabel lblDescripcionTipo = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcionTipo = new GridBagConstraints();
		gbc_lblDescripcionTipo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcionTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionTipo.gridx = 1;
		gbc_lblDescripcionTipo.gridy = 15;
		panel.add(lblDescripcionTipo, gbc_lblDescripcionTipo);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 15;
		panel.add(scrollPane_2, gbc_scrollPane_2);
		
		JTextArea taDescripcionTipo = new JTextArea();
		taDescripcionTipo.setEditable(false);
		taDescripcionTipo.setLineWrap(true);
		taDescripcionTipo.setBackground(new Color(255, 255, 255));
		scrollPane_2.setViewportView(taDescripcionTipo);
		
		
		
		
		
		
		
	}

}
