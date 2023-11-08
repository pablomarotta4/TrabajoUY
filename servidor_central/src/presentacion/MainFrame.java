package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoInexistenteException;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import excepciones.UsuarioRepetidoException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorUsuario;
import server.WebServer;
import logica.interfaces.IControladorOferta;
import java.awt.BorderLayout;

public class MainFrame {

	private JFrame frame;
	private IControladorOferta ico;
	private IControladorUsuario icu;
	private IControladorCompraTipo ict;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebServer webServer = new WebServer();
					webServer.publicar();
		
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		// Guardar los controladores como atributo
		Factory f = Factory.getInstance();
		ico = f.getControladorOferta();
		icu = f.getControladorUsuario();
		ict = f.getControladorCompraTipo();
		
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(500, 20, 800, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuRegistros = new JMenu("Registros");
		JMenu menuConsultas = new JMenu("Consultas");
		JMenu menuSistema = new JMenu("Sistema");
		JMenu menuAcciones = new JMenu("Acciones");
		frame.setJMenuBar(menuBar);
		menuBar.add(menuRegistros);
		menuBar.add(menuConsultas);
		menuBar.add(menuAcciones);
		menuBar.add(menuSistema);

		JMenuItem menuAltaUsuario = new JMenuItem("Alta de Usuario");
		menuAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearUsuario crearUsuarioInternalFrame = new CrearUsuario(icu);
				frame.getContentPane().add(crearUsuarioInternalFrame);
				crearUsuarioInternalFrame.setVisible(true);
			}
		});
		
		// Se agrega la accion para que al hacer click a la opcion del menu se cree la ventana del caso de uso
		JMenuItem menuCrearOferta = new JMenuItem("Alta de Oferta Laboral");
		menuCrearOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearOfertaLaboral crearOfertaInternalFrame = new CrearOfertaLaboral(ico, icu, ict);
				frame.getContentPane().add(crearOfertaInternalFrame);
				crearOfertaInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuCrearTipoPublicacion = new JMenuItem("Alta de Tipo de publicación de Oferta Laboral");
		menuCrearTipoPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearTipoPublicacion crearTipoPubliacionInternalFrame = new CrearTipoPublicacion(ict);
				frame.getContentPane().add(crearTipoPubliacionInternalFrame);
				crearTipoPubliacionInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuAltaKeyword = new JMenuItem("Alta de Keywords");
		menuAltaKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaKeyword altaKeywordInternalFrame = new AltaKeyword(ico);
				frame.getContentPane().add(altaKeywordInternalFrame);
				altaKeywordInternalFrame.setVisible(true);
			}
		});

		
		JMenuItem menuConsultarOferta = new JMenuItem("Consulta de Oferta Laboral");
		menuConsultarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarOferta consultarOfertaInternalFrame = new ConsultarOferta(ico, icu, null);
				frame.getContentPane().add(consultarOfertaInternalFrame);
				consultarOfertaInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuConsultarUsuario = new JMenuItem("Consulta de Usuario");
		menuConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarUsuario consultarUsuarioInternalFrame = new ConsultarUsuario(icu,ico);				
				frame.getContentPane().add(consultarUsuarioInternalFrame);
				consultarUsuarioInternalFrame.setVisible(true);
			}
		});
		

			
		
		JMenuItem menuCrearPaquete = new JMenuItem("Crear Paquete Ofertas");
		menuCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearPaqueteDeTiposDePublicacionDeOfertaLaboral crearPaqueteInternalFrame = new CrearPaqueteDeTiposDePublicacionDeOfertaLaboral(ict);
				frame.getContentPane().add(crearPaqueteInternalFrame);
				crearPaqueteInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuAgregarTipoaPaquete = new JMenuItem("Agregar Tipo de Publicacion a Paquete");
		menuAgregarTipoaPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarTipoDePublicacióndeOfertaLaboralaPaquete agregarTipoInternalFrame = new AgregarTipoDePublicacióndeOfertaLaboralaPaquete(ict);
				frame.getContentPane().add(agregarTipoInternalFrame);
				agregarTipoInternalFrame.setVisible(true);
			}
		});
		
		
		JMenuItem menuCargarDatos = new JMenuItem("Cargar Datos");
		menuCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cargarDatos();					
				} catch (Exception e) {
					//
				}
			}
		});
		


		
//		menuRegistros.add(menuCrearPaquete);
//		menuRegistros.add(menuAgregarTipoaPaquete);
//		menuConsultas.add(menuConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales);
//		menuAcciones.add(menuModificarDatosDeUsuario);	
		
		menuRegistros.add(menuAltaUsuario);
		menuRegistros.add(menuCrearOferta);
		menuRegistros.add(menuCrearTipoPublicacion);
		menuRegistros.add(menuAltaKeyword);
		menuConsultas.add(menuConsultarUsuario);
		menuConsultas.add(menuConsultarOferta);
		menuSistema.add(menuCargarDatos);


		
		
		JMenuItem menuPostulacionAOfertaLaboral = new JMenuItem("Postulación a Oferta Laboral");
		menuAcciones.add(menuPostulacionAOfertaLaboral);
		menuPostulacionAOfertaLaboral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostulacionAOfertaLaboral postulacionAOfertaLaboralInternalFrame = new PostulacionAOfertaLaboral();
				frame.getContentPane().add(postulacionAOfertaLaboralInternalFrame);
				postulacionAOfertaLaboralInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuModificarDatosDeUsuario = new JMenuItem("Modificar Datos de Usuario");
		menuModificarDatosDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatosDeUsuario modificarDatosDeUsuarioInternalFrame = new ModificarDatosDeUsuario();
				frame.getContentPane().add(modificarDatosDeUsuarioInternalFrame);
				modificarDatosDeUsuarioInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuConfirmarRechazarOfertaLaboral = new JMenuItem("Aceptar/Rechazar Oferta Laboral");
		menuAcciones.add(menuConfirmarRechazarOfertaLaboral);
		menuConfirmarRechazarOfertaLaboral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmarRechazarOfertaLaboral confirmarRechazarOfertaLaboralInternalFrame = new ConfirmarRechazarOfertaLaboral();
				frame.getContentPane().add(confirmarRechazarOfertaLaboralInternalFrame);
				confirmarRechazarOfertaLaboralInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales = new JMenuItem("Consulta De Paquete De Tipos De Publicación De Ofertas Laborales");
		menuConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales consultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales = new ConsultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales();
				frame.getContentPane().add(consultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales);
				consultaDePaqueteDeTiposDePublicaciónDeOfertasLaborales.setVisible(true);
			}
		});
		
	} 
	
	
	


	public void cargarDatos() {
		this.cargarUsuarios();
		this.cargarTiposPublicacion();
		this.cargarKeywords();
		this.cargarOfertas();
		this.cargarPostulaciones();
	}
	
	private void cargarUsuarios() {
		// CARGA DE POSTULANTES
		try {
			String imagePath = 
					File.separator + 
					"images" + File.separator;
			
			this.icu.crearPostulante(
			    "lgarcia",
			    "Lucía",
			    "García",
			    "lgarcia85@gmail.com",
			    "awdrg543",
			    imagePath + "lgarcia.jpg",
			    "Uruguaya",
			    LocalDate.of(1985, 3, 15)
			);
			this.icu.crearPostulante(
			    "matilo",
			    "Matías",
			    "López",
			    "matias.lopez90@hotmail.com",
			    "edrft543",
			    imagePath + "matilo.jpg",
			    "Argentina",
			    LocalDate.of(1990, 8, 21)
			);
			this.icu.crearPostulante(
			    "maro",
			    "María",
			    "Rodríguez",
			    "marrod@gmail.com",
			    "r5t6y7u8",
			    imagePath + "maro.jpg",
			    "Uruguaya",
			    LocalDate.of(1988, 11, 10)
			);
	
			this.icu.crearPostulante(
			    "javierf",
			    "Javier",
			    "Fernández",
			    "javierf93@yahoo.com",
			    "45idgaf67",
			    imagePath + "javierf.jpg",
			    "Mexicana",
			    LocalDate.of(1993, 6, 5)
			);
			this.icu.crearPostulante(
			    "valen25",
			    "Valentina",
			    "Martínez",
			    "vale87@gmail.com",
			    "poiuy987",
			    imagePath + "valen25.jpg",
			    "Uruguaya",
			    LocalDate.of(1987, 2, 25)
			);
			this.icu.crearPostulante(
			    "andpe12",
			    "Andrés",
			    "Pérez",
			    "anpe92@hotmail.com",
			    "xdrgb657",
			    imagePath + "andpe12.jpg",
			    "Chilena",
			    LocalDate.of(1992, 4, 12)
			);
			this.icu.crearPostulante(
			    "sicam",
			    "Camila",
			    "Silva",
			    "camilasilva89@gmail.com",
			    "mnjkiu89",
			    imagePath + "sicam.jpg",
			    "Uruguaya",
			    LocalDate.of(1989, 9, 30)
			);
			this.icu.crearPostulante(
			    "sebgon",
			    "Sebastián",
			    "González",
			    "gonza95@yahoo.com",
			    "ytrewq10",
			    imagePath + "sebgon.jpg",
			    "Colombiana",
			    LocalDate.of(1995, 1, 18)
			);
			this.icu.crearPostulante(
			    "isabel",
			    "Isabella",
			    "López",
			    "loisa@gmail.com",
			    "sbsplol1",
			    imagePath + "isabel.jpg",
			    "Uruguaya",
			    LocalDate.of(1991, 7, 7)
			);
			this.icu.crearPostulante(
			    "marram02",
			    "Martín",
			    "Ramírez",
			    "marram@hotmail.com",
			    "okmnji98",
			    imagePath + "marram02.jpg",
			    "Argentina",
			    LocalDate.of(1986, 12, 2)
			);
	
			// CARGA DE EMPRESAS
			String desc = 
			        "EcoTech Innovations es una empresa líder en soluciones tecnológicas sostenibles. "
			        + "Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que "
			        + "aborden los desafíos ambientales más apremiantes de nuestro tiempo.\n"
			        + "Desde sistemas de energía renovable y dispositivos de monitorización ambiental hasta "
			        + "soluciones de gestión de residuos inteligentes, nuestra misión es proporcionar herramientas "
			        + "que permitan a las empresas y comunidades adoptar prácticas más ecológicas sin comprometer la eficiencia.\n"
			        + "Creemos en la convergencia armoniosa entre la tecnología y la naturaleza, y trabajamos "
			        + "incansablemente para impulsar un futuro más limpio y sostenible.";
			this.icu.crearEmpresa(
			        "EcoTech", 
			        "Sophia", 
			        "Johnson", 
			        "info@EcoTech.com", 
				    "qsxcdw43",
				    imagePath + "EcoTech.jpg",
			        desc, 
			        "http://www.EcoTechInnovations.com"
			);
	
			desc = 
			    "FusionTech Dynamics es una empresa pionera en el ámbito de la inteligencia artificial y la "
			    + "automatización avanzada.\n"
			    + "Nuestro equipo multidisciplinario de ingenieros, científicos de datos y desarrolladores crea "
			    + "soluciones innovadoras que aprovechan la potencia de la IA para transformar industrias. "
			    + "Desde la optimización de procesos industriales hasta la creación de asistentes virtuales "
			    + "altamente personalizados, nuestro objetivo es revolucionar la forma en que las empresas operan y "
			    + "se conectan con sus clientes.\n"
			    + "Creemos en la sinergia entre la mente humana y las capacidades de la IA, y trabajamos para "
			    + "construir un mundo donde la tecnología mejore y amplíe nuestras capacidades innatas.";
			this.icu.crearEmpresa(
			        "FusionTech", 
			        "William", 
			        "Smith", 
			        "contacto@FusionTech.net", 
				    "qpwoei586",
				    imagePath + "FusionTech.jpg",
			        desc, 
			        "http://www.FusionTechDynamics.net"
			);
			desc = 
			    "GlobalHealth Dynamics es una empresa comprometida con el avance de la atención médica a nivel mundial. "
			    + "Como líderes en el campo de la salud digital, desarrollamos plataformas y herramientas que permiten a los "
			    + "profesionales de la salud ofrecer diagnósticos más precisos, tratamientos personalizados y seguimiento continuo de los pacientes.\n"
			    + "Nuestra visión es crear un ecosistema de salud conectado en el que los datos médicos se utilicen de "
			    + "manera ética y segura para mejorar la calidad de vida de las personas. A través de la innovación constante "
			    + "y la colaboración con expertos médicos, estamos dando forma al futuro de la atención médica, donde la tecnología "
			    + "y la compasión se unen para salvar vidas y mejorar el bienestar en todo el mundo.";
			this.icu.crearEmpresa(
			        "GlobalHealth", 
			        "Isabella", 
			        "Brown", 
			        "jobs@GlobalHealth.uy", 
				    "asdfg654",
				    imagePath + "GlobalHealth.jpg",
			        desc, 
			        "http://www.GlobalHealthDynamics.uy/info"
			);
			desc = 
			    "En Antel te brindamos servicios de vanguardia en tecnología de comunicación en Telefonía Móvil, Fija, Banda Ancha y Datos.";
			this.icu.crearEmpresa(
			        "ANTEL", 
			        "Washington", 
			        "Rocha", 
			        "jarrington@ANTEL.com.uy", 
				    "2nru096",
				    imagePath + "ANTEL.jpg",
			        desc, 
			        "ANTEL.com.uy"
			);
			desc = 
			    "Balance Energético Nacional (BEN). La Dirección Nacional de Energía (DNE) del Ministerio de Industria, Energía y Minería (MIEM) "
			    + "presenta anualmente el BEN.";
			this.icu.crearEmpresa(
			        "MIEM", 
			        "Pablo", 
			        "Bengoechea", 
			        "eldiez@MIEM.org.uy", 
				    "ibii4xo",
				    imagePath + "MIEM.jpg",
			        desc, 
			        "http://www.EcoTechInnovations.com"
			);
			desc = 
			    "\"TechSolutions Inc.\" es una empresa líder en el sector de tecnología de la información y el software."
			    + " Se especializa en el desarrollo de soluciones de software personalizadas para empresas de diversos tamaños y sectores. "
			    + "Su enfoque se centra en la creación de aplicaciones empresariales innovadoras que optimizan procesos, mejoran la eficiencia "
			    + "y brindan una ventaja competitiva a sus clientes.";
			this.icu.crearEmpresa(
			        "TechSolutions", 
			        "Mercedes", 
			        "Venn", 
			        "Mercedes@TechSolutions.com.uy", 
				    "1ngs03p",
				    imagePath + "TechSolutions.jpg",
			        desc, 
			        "TechSolutions.com"
			);
		} catch (UsuarioRepetidoException ex) {
			JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );

		} catch (CamposVaciosExcepcion ex) {
			JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );

		}
	}
	
	private void cargarTiposPublicacion() {
		try {
			// TIPOS DE PUBLICACION
			this.ict.crearTipoPublicacion(
					"Premium",
					"Obtén máxima visibilidad", 
					1, 
					30, 
					4000, 
					LocalDate.of(2023, 8, 10)
			);
			
			this.ict.crearTipoPublicacion(
					"Destacada",
					"Destaca tu anuncio", 
					2, 
					15, 
					500, 
					LocalDate.of(2023, 8, 5)
			);
			
			this.ict.crearTipoPublicacion(
					"Estándar",
					"Mejora la posición de tu anuncio", 
					3, 
					20, 
					150, 
					LocalDate.of(2023, 8, 15)
			);
			
			this.ict.crearTipoPublicacion(
					"Básica",
					"Publica de forma sencilla en la lista de ofertas", 
					4, 
					7, 
					50, 
					LocalDate.of(2023, 8, 7)
			);
		} catch(UsuarioRepetidoException ex){
			JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );

		}
	}
	
	private void cargarKeywords() {
		try {
			this.ico.altaKeyword("Tiempo completo");
			this.ico.altaKeyword("Medio tiempo");
			this.ico.altaKeyword("Remoto");
			this.ico.altaKeyword("Freelance");
			this.ico.altaKeyword("Temporal");
			this.ico.altaKeyword("Permanente");
			this.ico.altaKeyword("Computación");
			this.ico.altaKeyword("Administración");
			this.ico.altaKeyword("Logística");
			this.ico.altaKeyword("Contabilidad");
		} catch(ElementoRepetidoException ex) {
			JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );

		}
	}
	
	private void cargarOfertas() {
		try {
			String desc = 
					"Unete a nuestro equipo de desarrollo frontend y crea ´\r\n"
					+ "experiencias de usuario excepcionales.";
			String imagePath = 
					File.separator + 
					"images" + File.separator;
			ArrayList<String> keywords = new ArrayList<>();
			keywords.add("Tiempo completo");
			keywords.add("Medio tiempo");
			keywords.add("Remoto");
			keywords.add("Freelance");
			keywords.add("Temporal");
			keywords.add("Permanente");
			this.ico.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"Desarrollador Frontend", 
					desc, 
					"09:00 - 18:00", 
					90000, 
					"Montevideo", 
					"Montevideo",
					LocalDate.of(2023, 9, 30),
					imagePath + "desarrollador_frontend.jpg",
					keywords
			);
			this.ico.confirmarOferta("Desarrollador Frontend");
			desc = 
				"Forma parte de nuestro equipo de estrategia y "
				+ "contribuye al crecimiento de las empresas cliente";
			keywords.clear();
			keywords.add("Temporal");
			this.ico.altaOfertaLaboral(
					"GlobalHealth", 
					"Estándar", 
					"Estratega de Negocios", 
					desc, 
					"08:00 - 17:00", 
					80000, 
					"Punta del Este", 
					"Maldonado", 
					LocalDate.of(2023, 9, 29),
					imagePath + "estratega_de_negocios.jpg",
					keywords
			);
			this.ico.confirmarOferta("Estratega de Negocios");
			desc = 
				"Trabaja en colaboración con nuestro talentoso  "
				+ "equipo de diseno para crear soluciones impactantes.";
			keywords.clear();
			keywords.add("Medio tiempo");
			keywords.add("Remoto");
			keywords.add("Permanente");
			this.ico.altaOfertaLaboral(
					"FusionTech", 
					"Estándar", 
					"Disenador UX/UI", 
					desc, 
					"14:00 - 18:00", 
					65000, 
					"Rosario", 
					"Colonia", 
					LocalDate.of(2023, 10, 29),
					imagePath + "diseñador_ux_ui.jpg",
					keywords
			);
			this.ico.confirmarOferta("Disenador UX/UI");
			
			desc = 
				"Ayuda a nuestros clientes a tomar decisiones "
				+ "informadas basadas en an´alisis y visualizaciones de dat";
			keywords.clear();
			keywords.add("Medio tiempo");
			this.ico.altaOfertaLaboral(
					"ANTEL", 
					"Premium", 
					"Analista de Datos", 
					desc, 
					"09:00 - 13:00", 
					40000, 
					"Maldonado", 
					"Maldonado", 
					LocalDate.of(2023, 10, 19),
					imagePath + "analista_de_datos.jpg",
					keywords
			);
			
			desc = 
				"Gestiona y crea contenido persuasivo y relevante\r\n"
				+ "para impulsar la presencia en l´ınea de nuestros\r\n"
				+ "clientes.\r\n"
				+ "";
			keywords.clear();
			keywords.add("Freelance");
			this.ico.altaOfertaLaboral(
					"MIEM", 
					"Destacada", 
					"Content Manager", 
					desc, 
					"18:00 - 22:00", 
					10000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(2023, 10, 20),
					imagePath + "content_manager.jpg",
					keywords
			);
			
			desc = 
				"Ofrece un excelente servicio de soporte t´ecnico a\r\n"
				+ "nuestros clientes, resolviendo problemas y brindando\r\n"
				+ "soluciones.";
			keywords.clear();
			keywords.add("Tiempo completo");
			this.ico.altaOfertaLaboral(
					"TechSolutions", 
					"Básica", 
					"Soporte Técnico", 
					desc, 
					"09:00 - 18:00", 
					30000, 
					"Minas", 
					"Lavalleja",
					LocalDate.of(2023, 11, 2),
					imagePath + "soporte_tecnico.jpg",
					keywords
			);
			this.ico.confirmarOferta("Soporte Técnico");
			desc = 
				"Unete a nuestro equipo de marketing y trabaja en ´\r\n"
				+ "estrategias digitales innovadoras.";
			this.ico.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"A. de Marketing Digital", 
					desc, 
					"10:00 - 19:00", 
					80000, 
					"Flores", 
					"Flores", 
					LocalDate.of(2023, 11, 2),
					imagePath + "analista_de_marketing_digital.jpg",
					new ArrayList<String>()
			);
			this.ico.confirmarOferta("A. de Marketing Digital");
			desc = 
				"Únete a nuestro equipo contable y ayuda en la ´\r\n"
				+ "gestión financiera de la empresa";
			this.ico.altaOfertaLaboral(
					"GlobalHealth", 
					"Destacada", 
					"Contador Senior", 
					desc, 
					"08:30 - 17:30 ", 
					100000, 
					"Colonia Suiza", 
					"Colonia", 
					LocalDate.of(2023, 11, 4),
					imagePath + "contador_senior.jpg",
					new ArrayList<String>()
			);
			this.ico.rechazarOferta("Contador Senior");
			desc = 
					"RÉGIMEN DE CONTRATO EN FUNCION PUB-\r\n"
					+ "LICA EN UN TODO DE ACUERDO A LA\r\n"
					+ "NORMATIVA VIGENTE (LEY 16.127, DE 7 DE\r\n"
					+ "AGOSTO DE 1990, ART. 1°, LITERAL A) Y B)\r\n"
					+ "CON LA MODIFICACI ´ON INTRODUCIDA POR\r\n"
					+ "EL ART. 11 DE LA LEY 17.930 DE 19 DE DICIEM-\r\n"
					+ "BRE DE 2005).";
			keywords.clear();
			keywords.add("Temporal");
			this.ico.altaOfertaLaboral(
					"ANTEL", 
					"Premium", 
					"Técnico/a Básico Red", 
					desc, 
					"09:00 - 17:00", 
					40000, 
					"Paysandú", 
					"Paysandú", 
					LocalDate.of(2023, 10, 29),
					imagePath + "tecnico_de_red.jpg",
					keywords
			);
			this.ico.confirmarOferta("Técnico/a Básico Red");
				
			desc = 
					"Unete a nuestro equipo y lidera proyectos de desar-\r\n"
					+ "rollo de software sostenible y ecol´ogico. Impulsa la\r\n"
					+ "innovación y contribuye a un futuro m´as verde.";
			keywords.clear();
			keywords.add("Tiempo completo");
			keywords.add("Permanente");
			keywords.add("Logística");
			this.ico.altaOfertaLaboral(
					"EcoTech", 
					"Destacada", 
					"Desarrollador de Software Senior", 
					desc, 
					"09:00 - 16:00", 
					123000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(2023, 11, 4),
					imagePath + "desarrollador_de_software_senior.jpg",
					keywords
			);
					
			desc = 
					"Unete a nuestro equipo para crear soluciones de soft-\r\n"
					+ "ware personalizadas de extremo a extremo. Colabora\r\n"
					+ "en proyectos emocionantes y desafiantes.";
			keywords.clear();
			keywords.add("Remoto");
			this.ico.altaOfertaLaboral(
					"TechSolutions", 
					"Premium", 
					"Desarrollador de Software Full Stack", 
					desc, 
					"04:00 - 13:00", 
					135000, 
					"Río Negro", 
					"Fray Bentos", 
					LocalDate.of(2023, 10, 25),
					imagePath + "desarrollador_de_software_full_stack.jpg",
					keywords
			);
			
			desc = 
					"Unete a nuestro equipo de gesti´on de proyectos y lid-\r\n"
					+ "era la entrega exitosa de soluciones de software per-\r\n"
					+ "sonalizadas. Colabora con equipos multidisciplinar-\r\n"
					+ "ios y clientes exigentes.";
			keywords.clear();
			keywords.add("Remoto");
			keywords.add("Permanente");
			this.ico.altaOfertaLaboral(
					"TechSolutions", 
					"Destacada", 
					"Gerente de Proyecto", 
					desc, 
					"04:00 - 12:00", 
					230000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(2023, 11, 5),
					imagePath + "gerente_de_proyectos.jpg",
					keywords
			);
			this.ico.confirmarOferta("Gerente de Proyecto");
			desc = 
					"Asegura la calidad de nuestros productos de software\r\n"
					+ "sostenibles. ´Unete a nosotros para garantizar un im-\r\n"
					+ "pacto positivo en el medio ambiente.";
			keywords.clear();
			keywords.add("Tiempo completo");
			keywords.add("Contabilidad");
			this.ico.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"Ingeniero de Calidad de Software", 
					desc, 
					"14:00 - 18:00", 
					60000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(2023, 11, 1),
					imagePath + "ingeniero_de_calidad_de_software.jpg",
					keywords
			);
		} catch (ElementoRepetidoException e) {
			System.out.println(e.getMessage());
		} catch (ElementoInexistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void cargarPostulaciones() {
		try {
			String cvv = 
			"Licenciada en Administración, \n"
			+ "experiencia en gestión de equipos \n"
			+ "y proyectos. Conocimientos en \n"
			+ "Microsoft Office";
					
			String motivacion = 
			"Estoy emocionada por la oportunidad de formar parte de un \n"
			+ "equipo dinámico y contribuir con \n"
			+ "mis habilidades de liderazgo.\r\n"
			+ "";
			this.ico.altaPostulacion(
					"lgarcia", 
					"Desarrollador Frontend", 
					cvv, 
					motivacion, 
					LocalDate.of(2023, 10, 1)
			);
			
			cvv = 
			"Estudiante de Comunicación, habilidades en redacción y manejo \n"
			+ "de redes sociales. Experiencia en \n"
			+ "prácticas en medios locales";
					
			motivacion = 
			"Me encantaría formar parte de \n"
			+ "un equipo que me permita desarorollar mis habilidades en comunicación "
			+ "y marketing.";
			this.ico.altaPostulacion(
					"matilo", 
					"Estratega de Negocios", 
					cvv, 
					motivacion, 
					LocalDate.of(2023, 9, 30)
			);
			
			cvv = 
			"Ingeniero en Sistemas, experiencia en desarrollo web "
			+ "y aplicaciones móviles. Conocimientos\r\n"
			+ "en JavaScript y React.";
					
			motivacion = 
			"Me entusiasma la posibilidad de\r\n"
			+ "trabajar en proyectos desafiantes\r\n"
			+ "y seguir creciendo "
			+ "como profesional en el campo de la tecnología.";
			this.ico.altaPostulacion(
					"maro", 
					"Desarrollador Frontend", 
					cvv, 
					motivacion, 
					LocalDate.of(2023, 10, 2)
			);
			
			cvv = 
			"Técnico en Electricidad, "
			+ "experiencia en mantenimiento industrial. Conocimientos en lectura\r\n"
			+ "de planos eléctricos.";
					
			motivacion = 
			"Estoy interesado en formar parte \n"
			+ "de un equipo que me permita \n"
			+ "aplicar mis habilidades t´ecnicas y \n"
			+ "contribuir al mantenimiento eficiente";
			this.ico.altaPostulacion(
					"javierf", 
					"Disenador UX/UI", 
					cvv, 
					motivacion, 
					LocalDate.of(2023, 9, 30)
			);
			
			cvv = 
			"Músico profesional, experiencia\r\n"
			+ "en espectáculos en vivo. Habilidades en canto y guitarra. \n"
			+ "";
					
			motivacion = 
			"Me gustar´ıa combinar mi pasión \n"
			+ "por la música con una oportunidad laboral que me permita \n"
			+ "seguir creciendo como artista.\r\n"
			+ "";
			this.ico.altaPostulacion(
					"valen25", 
					"Estratega de Negocios", 
					cvv, 
					motivacion, 
					LocalDate.of(2023, 9, 30)
			);
			
			cvv = 
			"Licenciada en Administración,\r\n"
			+ "me considero genia, experiencia\r\n"
			+ "en gestión de equipos y proyectos. Conocimientos en Microsoft\r\n"
			+ "Office";
					
			motivacion = 
			"Estoy emocionada por la oportunidad de formar parte de un\r\n"
			+ "equipo dinámico y contribuir con\r\n"
			+ "mis habilidades de liderazgo.\r\n"
			+ ""
			+ "";
			this.ico.altaPostulacion(
					"lgarcia", 
					"Estratega de Negocios", 
					cvv, 
					motivacion, 
					LocalDate.of(2023, 10, 2)
			);
			JOptionPane.showMessageDialog(
					frame,
					"La operación se ha realizado con éxito",
					"Éxito",
					JOptionPane.INFORMATION_MESSAGE
					);

		} catch (ElementoRepetidoException e) {
			JOptionPane.showMessageDialog(
                    frame,
                    e.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );

		} catch (NoExisteInstancia e) {
			System.out.println(e.getMessage());
		} catch (ElementoInexistenteException e) {
			System.out.println(e.getMessage());
		}
	}
}