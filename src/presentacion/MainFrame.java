package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import excepciones.CamposVaciosExcepcion;
import excepciones.ElementoRepetidoException;
import excepciones.NoExisteInstancia;
import excepciones.UsuarioRepetidoException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorUsuario;
import logica.interfaces.IControladorOferta;

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
		frame.setBounds(100, 100, 750, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuRegistros = new JMenu("Registros");
		JMenu menuConsultas = new JMenu("Consultas");
		JMenu menuSistema = new JMenu("Sistema");
		frame.setJMenuBar(menuBar);
		menuBar.add(menuRegistros);
		menuBar.add(menuConsultas);
		menuBar.add(menuSistema);
		
		// Se agrega la accion para que al hacer click a la opcion del menu se cree la ventana del caso de uso
		JMenuItem menuCrearOferta = new JMenuItem("Crear Oferta Laboral");
		menuCrearOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearOfertaLaboral crearOfertaInternalFrame = new CrearOfertaLaboral(ico, icu, ict);
				frame.getContentPane().add(crearOfertaInternalFrame);
				crearOfertaInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuCrearTipoPublicacion = new JMenuItem("Crear Tipo de Publicacion");
		menuCrearTipoPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearTipoPublicacion crearTipoPubliacionInternalFrame = new CrearTipoPublicacion(ict);
				frame.getContentPane().add(crearTipoPubliacionInternalFrame);
				crearTipoPubliacionInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuAltaUsuario = new JMenuItem("Crear Usuario");
		menuAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearUsuario crearUsuarioInternalFrame = new CrearUsuario(icu);
				frame.getContentPane().add(crearUsuarioInternalFrame);
				crearUsuarioInternalFrame.setVisible(true);
			}
		});
		
		
		JMenuItem menuConsultarOferta = new JMenuItem("Consultar Oferta Laboral");
		menuConsultarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarOferta consultarOfertaInternalFrame = new ConsultarOferta(ico, icu);
				frame.getContentPane().add(consultarOfertaInternalFrame);
				consultarOfertaInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuConsultarUsuario = new JMenuItem("Consultar Usuario");
		menuConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarUsuario consultarUsuarioInternalFrame = new ConsultarUsuario(icu);
				frame.getContentPane().add(consultarUsuarioInternalFrame);
				consultarUsuarioInternalFrame.setVisible(true);
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
			
		
		JMenuItem menuCargarDatos = new JMenuItem("Cargar datos de prueba");
		menuCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cargarDatos();					
				} catch (Exception e) {
					//
				}
			}
		});
		
		menuRegistros.add(menuCrearOferta);
		menuRegistros.add(menuAltaUsuario);
		menuRegistros.add(menuCrearTipoPublicacion);
		menuRegistros.add(menuAltaKeyword);
		menuConsultas.add(menuConsultarOferta);
		menuConsultas.add(menuConsultarUsuario);
		menuSistema.add(menuCargarDatos);
		
		JMenu menuAcciones = new JMenu("Acciones");
		menuBar.add(menuAcciones);
		
		JMenuItem menuModificarDatosDeUsuario = new JMenuItem("Modificar Datos de Usuario");
		menuAcciones.add(menuModificarDatosDeUsuario);
		menuModificarDatosDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatosDeUsuario modificarDatosDeUsuarioInternalFrame = new ModificarDatosDeUsuario(icu);
				frame.getContentPane().add(modificarDatosDeUsuarioInternalFrame);
				modificarDatosDeUsuarioInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem menuPostulacionAOfertaLaboral = new JMenuItem("Postulacion a Oferta Laboral");
		menuAcciones.add(menuPostulacionAOfertaLaboral);
		menuPostulacionAOfertaLaboral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostulacionAOfertaLaboral postulacionAOfertaLaboralInternalFrame = new PostulacionAOfertaLaboral();
				frame.getContentPane().add(postulacionAOfertaLaboralInternalFrame);
				postulacionAOfertaLaboralInternalFrame.setVisible(true);
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
	
	public void cargarPostulaciones() {
		try {
			String cv = 
			"Licenciada en Administraci´on,\r\n"
			+ "experiencia en gesti´on de equipos\r\n"
			+ "y proyectos. Conocimientos en\r\n"
			+ "Microsoft Office";
					
			String motivacion = 
			"Estoy emocionada por la oportunidad de formar parte de un\r\n"
			+ "equipo din´amico y contribuir con\r\n"
			+ "mis habilidades de liderazgo.\r\n"
			+ "";
			this.ico.altaPostulacion(
					"lgarcia", 
					"Desarrollador Frontend", 
					cv, 
					motivacion, 
					LocalDate.of(2023, 8, 16)
			);
			
			cv = 
			"Estudiante de Comunicaci´on, habilidades en redacci´on y manejo\r\n"
			+ "de redes sociales. Experiencia en\r\n"
			+ "pr´acticas en medios locales";
					
			motivacion = 
			"Me encantar´ıa formar parte de\r\n"
			+ "un equipo que me permita desarrollar mis habilidades en comunicaci´on "
			+ "y marketing.";
			this.ico.altaPostulacion(
					"matilo", 
					"Estratega de Negocios", 
					cv, 
					motivacion, 
					LocalDate.of(2023, 8, 15)
			);
			
			cv = 
			"Ingeniero en Sistemas, experiencia en desarrollo web "
			+ "y aplicaciones m´oviles. Conocimientos\r\n"
			+ "en JavaScript y React.";
					
			motivacion = 
			"Me entusiasma la posibilidad de\r\n"
			+ "trabajar en proyectos desafiantes\r\n"
			+ "y seguir creciendo "
			+ "como profesional en el campo de la tecnolog´ıa.";
			this.ico.altaPostulacion(
					"maro", 
					"Desarrollador Frontend", 
					cv, 
					motivacion, 
					LocalDate.of(2023, 8, 16)
			);
			
			cv = 
			"T´ecnico en Electricidad, "
			+ "experiencia en mantenimiento industrial. Conocimientos en lectura\r\n"
			+ "de planos el´ectricos.";
					
			motivacion = 
			"Estoy interesado en formar parte\r\n"
			+ "de un equipo que me permita\r\n"
			+ "aplicar mis habilidades t´ecnicas y\r\n"
			+ "contribuir al mantenimiento eficiente";
			this.ico.altaPostulacion(
					"javierf", 
					"Dise˜nador UX/UI", 
					cv, 
					motivacion, 
					LocalDate.of(2023, 8, 13)
			);
			
			cv = 
			"M´usico profesional, experiencia\r\n"
			+ "en espect´aculos en vivo. Habilidades en canto y guitarra.\r\n"
			+ "";
					
			motivacion = 
			"Me gustar´ıa combinar mi pasi´on\r\n"
			+ "por la m´usica con una oportunidad laboral que me permita\r\n"
			+ "seguir creciendo como artista.\r\n"
			+ "";
			this.ico.altaPostulacion(
					"valen25", 
					"Estratega de Negocios", 
					cv, 
					motivacion, 
					LocalDate.of(2023, 8, 12)
			);
			
			cv = 
			"Licenciada en Administraci´on,\r\n"
			+ "me considero genia, experiencia\r\n"
			+ "en gesti´on de equipos y proyectos. Conocimientos en Microsoft\r\n"
			+ "Office";
					
			motivacion = 
			"Estoy emocionada por la oportunidad de formar parte de un\r\n"
			+ "equipo din´amico y contribuir con\r\n"
			+ "mis habilidades de liderazgo.\r\n"
			+ ""
			+ "";
			this.ico.altaPostulacion(
					"lgarcia", 
					"Estratega de Negocios ", 
					cv, 
					motivacion, 
					LocalDate.of(2023, 8, 16)
			);
		} catch (ElementoRepetidoException | NoExisteInstancia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cargarOfertas() {
		try {
			String desc = 
					"Unete a nuestro equipo de desarrollo frontend y crea ´\r\n"
					+ "experiencias de usuario excepcionales.";
			this.ico.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"Desarrollador Frontend", 
					desc, 
					"09:00 - 18:00", 
					90000, 
					"Montevideo", 
					"Montevideo",
					LocalDate.of(2023, 8, 14),
					List.of(
							"Tiempo completo",
							"Medio tiempo",
							"Remoto",
							"Freelance",
							"Temporal",
							"Permanente"
					)
			);
			desc = 
				"Forma parte de nuestro equipo de estrategia y "
				+ "contribuye al crecimiento de las empresas cliente";
			this.ico.altaOfertaLaboral(
					"GlobalHealth", 
					"Estándar", 
					"Estratega de Negocios", 
					desc, 
					"08:00 - 17:00", 
					80000, 
					"Punta del Este", 
					"Maldonado", 
					LocalDate.of(2023, 8, 14),
					List.of("Temporal")
			);
			desc = 
				"Trabaja en colaboraci´on con nuestro talentoso\r\n"
				+ "equipo de dise˜no para crear soluciones impactantes.";
			this.ico.altaOfertaLaboral(
					"FusionTech", 
					"Estándar", 
					"Diseñador UX/UI", 
					desc, 
					"14:00 - 18:00", 
					65000, 
					"Rosario", 
					"Colonia", 
					LocalDate.of(2023, 8, 13),
					List.of("Medio tiempo", "Remoto", "Permanente")
			);
			
			desc = 
				"Ayuda a nuestros clientes a tomar decisiones "
				+ "informadas basadas en an´alisis y visualizaciones de dat";
			this.ico.altaOfertaLaboral(
					"ANTEL", 
					"Premium", 
					"Analista de Datos", 
					desc, 
					"09:00 - 13:00", 
					40000, 
					"Maldonado", 
					"Maldonado", 
					LocalDate.of(2023, 8, 11),
					List.of("Medio tiempo")
			);
			
			desc = 
				"Gestiona y crea contenido persuasivo y relevante\r\n"
				+ "para impulsar la presencia en l´ınea de nuestros\r\n"
				+ "clientes.\r\n"
				+ "";
			this.ico.altaOfertaLaboral(
					"MIEM", 
					"Destacada", 
					"Content Manager", 
					desc, 
					"18:00 - 22:00", 
					10000, 
					"Montevideo", 
					"Montevideo", 
					LocalDate.of(2023, 8, 20),
					List.of("Freelance")
			);
			
			desc = 
				"Ofrece un excelente servicio de soporte t´ecnico a\r\n"
				+ "nuestros clientes, resolviendo problemas y brindando\r\n"
				+ "soluciones.";
			this.ico.altaOfertaLaboral(
					"TechSolutions", 
					"Básica", 
					"Soporte Técnico", 
					desc, 
					"09:00 - 18:00", 
					30000, 
					"Minas", 
					"Lavalleja",
					LocalDate.of(2023, 8, 15),
					List.of("Tiempo completo")
			);
			desc = 
				"Unete a nuestro equipo de marketing y trabaja en ´\r\n"
				+ "estrategias digitales innovadoras.";
			this.ico.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"A. de Marketing Digital ", 
					desc, 
					"10:00 - 19:00", 
					80000, 
					"Flores", 
					"Flores", 
					LocalDate.of(2023, 8, 15),
					new ArrayList<String>()
			);
			desc = 
				"Únete a nuestro equipo contable y ayuda en la ´\r\n"
				+ "gesti´on financiera de la empresa";
			this.ico.altaOfertaLaboral(
					"GlobalHealth", 
					"Destacada", 
					"Contador Senior", 
					desc, 
					"08:30 - 17:30 ", 
					100000, 
					"Colonia Suiza", 
					"Colonia", 
					LocalDate.of(2023, 8, 16),
					new ArrayList<String>()
			);
		} catch(Exception e) {
			
		}
	}
	
	public void cargarKeywords() {
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
	
	public void cargarTiposPublicacion() {
		try {
			// TIPOS DE PUBLICACION
			this.ict.crearTipoPublicacion(
					"Premium",
					"Obtén máxima visibilidad", 
					1, 
					30, 
					4000, 
					new SimpleDateFormat("yyyy/MM/dd").parse("10/08/2023")
			);
			
			this.ict.crearTipoPublicacion(
					"Destacada",
					"Destaca tu anuncio", 
					2, 
					15, 
					500, 
					new SimpleDateFormat("yyyy/MM/dd").parse("05/08/2023")
			);
			
			this.ict.crearTipoPublicacion(
					"Estándar",
					"Mejora la posición de tu anuncio", 
					3, 
					20, 
					150, 
					new SimpleDateFormat("yyyy/MM/dd").parse("15/08/2023")
			);
			
			this.ict.crearTipoPublicacion(
					"Básica",
					"Publica de forma sencilla en la\r\n"
					+ "lista de ofertas", 
					4, 
					7, 
					50, 
					new SimpleDateFormat("yyyy/MM/dd").parse("07/08/2023")
			);
		} catch(UsuarioRepetidoException ex){
			JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarUsuarios() {
		try {
			// CARGA DE POSTULANTES
			this.icu.crearPostulante(
					"lgarcia", 
					"Lucía", 
					"García", 
					"lgarcia85@gmail.com", 
					"Uruguaya", 
					new SimpleDateFormat("yyyy/MM/dd").parse("15/03/1985")
			);	
			this.icu.crearPostulante(
					"matilo", 
					"Matías", 
					"López", 
					"matias.lopez90@hotmail.com", 
					"Argentina", 
					new SimpleDateFormat("yyyy/MM/dd").parse("21/08/1990")
			);	
			this.icu.crearPostulante(
					"maro", 
					"María", 
					"Rodríguez", 
					"marrod@gmail.com", 
					"Uruguaya", 
					new SimpleDateFormat("yyyy/MM/dd").parse("10/11/1988")
			);	
			
			this.icu.crearPostulante(
					"javierf", 
					"Javier", 
					"Fernández", 
					"javierf93@yahoo.com", 
					"Mexicana", 
					new SimpleDateFormat("yyyy/MM/dd").parse("05/06/1993")
			);	
			this.icu.crearPostulante(
					"valen25", 
					"Valentina", 
					"Martínez", 
					"vale87@gmail.com", 
					"Uruguaya", 
					new SimpleDateFormat("yyyy/MM/dd").parse("25/02/1987")
			);	
			this.icu.crearPostulante(
					"andpe12", 
					"Andrés", 
					"Pérez", 
					"anpe92@hotmail.com", 
					"Chilena", 
					new SimpleDateFormat("yyyy/MM/dd").parse("12/04/1992")
			);	
			this.icu.crearPostulante(
					"sicam", 
					"Camila", 
					"Silva", 
					"camilasilva89@gmail.com", 
					"Uruguaya", 
					new SimpleDateFormat("yyyy/MM/dd").parse("30/09/1989")
			);	
			this.icu.crearPostulante(
					"sebgon", 
					"Sebastián", 
					"González", 
					"gonza95@yahoo.com", 
					"Colombiana", 
					new SimpleDateFormat("yyyy/MM/dd").parse("18/01/1995")
			);	
			this.icu.crearPostulante(
					"isabel", 
					"Isabella", 
					"López", 
					"loisa@gmail.com", 
					"Uruguaya", 
					new SimpleDateFormat("yyyy/MM/dd").parse("07/07/1991")
			);	
			this.icu.crearPostulante(
					"marram02", 
					"Martín", 
					"Ramírez", 
					"marram@hotmail.com", 
					"Argentina", 
					new SimpleDateFormat("yyyy/MM/dd").parse("02/12/1986")
			);	
			// CARGA DE EMPRESAS
			String desc = 
					"EcoTech Innovations es una empresa l´ıder en soluciones tec-\r\n"
					+ "nol´ogicas sostenibles. Nuestro enfoque se centra en desar-\r\n"
					+ "rollar y comercializar productos y servicios que aborden los\r\n"
					+ "desaf´ıos ambientales m´as apremiantes de nuestro tiempo.\r\n"
					+ "Desde sistemas de energ´ıa renovable y dispositivos de mon-\r\n"
					+ "itorizaci´on ambiental hasta soluciones de gesti´on de resid-\r\n"
					+ "uos inteligentes, nuestra misi´on es proporcionar herramien-\r\n"
					+ "tas que permitan a las empresas y comunidades adop-\r\n"
					+ "tar pr´acticas m´as ecol´ogicas sin comprometer la eficiencia.\r\n"
					+ "Creemos en la convergencia armoniosa entre la tecnolog´ıa y\r\n"
					+ "la naturaleza, y trabajamos incansablemente para impulsar\r\n"
					+ "un futuro m´as limpio y sostenible.";
			this.icu.crearEmpresa(
					"EcoTech", 
					"Sophia", 
					"Johnson", 
					"info@EcoTech.com", 
					desc, 
					"http://www.EcoTechInnovations.com"
			);
			
			
			desc = 
				"FusionTech Dynamics es una empresa pionera en el ´ambito\r\n"
				+ "de la inteligencia artificial y la automatizaci´on avanzada.\r\n"
				+ "Nuestro equipo multidisciplinario de ingenieros, cient´ıficos\r\n"
				+ "de datos y desarrolladores crea soluciones innovadoras que\r\n"
				+ "aprovechan la potencia de la IA para transformar indus-\r\n"
				+ "trias. Desde la optimizaci´on de procesos industriales hasta\r\n"
				+ "la creaci´on de asistentes virtuales altamente personalizados,\r\n"
				+ "nuestro objetivo es revolucionar la forma en que las empre-\r\n"
				+ "sas operan y se conectan con sus clientes. Creemos en la\r\n"
				+ "sinergia entre la mente humana y las capacidades de la IA,\r\n"
				+ "y trabajamos para construir un mundo donde la tecnolog´ıa\r\n"
				+ "mejore y ampl´ıe nuestras capacidades innatas." ;
			this.icu.crearEmpresa(
					"FusionTech", 
					"William", 
					"Smith", 
					"contacto@FusionTech.net", 
					desc, 
					"http://www.FusionTechDynamics.net"
			);
			desc = 
				"GlobalHealth Dynamics es una empresa comprometida con\r\n"
				+ "el avance de la atenci´on m´edica a nivel mundial. Como\r\n"
				+ "l´ıderes en el campo de la salud digital, desarrollamos\r\n"
				+ "plataformas y herramientas que permiten a los profesionales\r\n"
				+ "de la salud ofrecer diagn´osticos m´as precisos, tratamien-\r\n"
				+ "tos personalizados y seguimiento continuo de los pacientes.\r\n"
				+ "Nuestra visi´on es crear un ecosistema de salud conectado en\r\n"
				+ "el que los datos m´edicos se utilicen de manera ´etica y segura\r\n"
				+ "para mejorar la calidad de vida de las personas. A trav´es\r\n"
				+ "de la innovaci´on constante y la colaboraci´on con exper-\r\n"
				+ "tos m´edicos, estamos dando forma al futuro de la atenci´on\r\n"
				+ "m´edica, donde la tecnolog´ıa y la compasi´on se unen para\r\n"
				+ "salvar vidas y mejorar el bienestar en todo el mundo.";
			this.icu.crearEmpresa(
					"GlobalHealth", 
					"Isabella", 
					"Brown", 
					"jobs@GlobalHealth.uy", 
					desc, 
					"http://www.GlobalHealthDynamics.uy/info"
			);
			desc = 
				"En Antel te brindamos servicios de vanguardia en tec-\r\n"
				+ "nolog´ıa de comunicaci´on en Telefon´ıa M´ovil, Fija, Banda\r\n"
				+ "Ancha y Datos";
			this.icu.crearEmpresa(
					"ANTEL", 
					"Washington", 
					"Rocha", 
					"jarrington@ANTEL.com.uy", 
					desc, 
					"ANTEL.com.uy"
			);
			desc = 
				"Balance Energ´etico Nacional (BEN). La Direcci´on Nacional\r\n"
				+ "de Energ´ıa (DNE) del Ministerio de Industria, Energ´ıa y\r\n"
				+ "Miner´ıa (MIEM) presenta anualmente el BEN.";
			this.icu.crearEmpresa(
					"MIEM", 
					"Pablo", 
					"Bengoechea", 
					"eldiez@MIEM.org.uy", 
					desc, 
					"http://www.EcoTechInnovations.com"
			);
			desc = 
				"”TechSolutions Inc.” es una empresa l´ıder en el sector de\r\n"
				+ "tecnolog´ıa de la informaci´on y el software. Se especializa\r\n"
				+ "en el desarrollo de soluciones de software personalizadas\r\n"
				+ "para empresas de diversos tama˜nos y sectores. Su enfoque\r\n"
				+ "se centra en la creaci´on de aplicaciones empresariales in-\r\n"
				+ "novadoras que optimizan procesos, mejoran la eficiencia y\r\n"
				+ "brindan una ventaja competitiva a sus clientes.";
			this.icu.crearEmpresa(
					"TechSolutions", 
					"Mercedes", 
					"Venn", 
					"Mercedes@TechSolutions.com.uy", 
					desc, 
					"TechSolutions.com"
			);
			
			
			JOptionPane.showMessageDialog(
					frame,
					"La operación se ha realizado con éxito",
					"Éxito",
					JOptionPane.INFORMATION_MESSAGE
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
			
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE
                );
			
		}
	}
	
}
