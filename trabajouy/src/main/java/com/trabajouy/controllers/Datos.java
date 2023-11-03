package com.trabajouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import server.CamposVaciosExcepcion;
import server.DataPostulante;
import server.ElementoInexistenteException;
import server.UsuarioRepetidoException;


/**
 * Servlet implementation class Datos
 */
@WebServlet("/datosDePrueba")
public class Datos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private server.WebServer port;
    
    public Datos() {    	
        super();
        
        this.port = new server.WebServerService().getWebServerPort();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarDatos();
		response.sendRedirect("/trabajouy/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void cargarDatos() {
		/////////////////////////////////////////////////////////////////
		// prueba collections
		ArrayList<String> list;
		this.port.pruebaCollection(list);
		
		
		
		/////////////////////////////////////////////////////////////////
		cargarUsuarios();
		cargarTiposPublicacion();
		cargarKeywords();
		cargarOfertas();
		cargarPostulaciones();
	}
	
	private void cargarUsuarios() {
		// CARGA DE POSTULANTES
		try {
			String imagePath = 
					File.separator + 
					"images" + File.separator;
			
			this.port.crearPostulante(
			    "lgarcia",
			    "Lucía",
			    "García",
			    "lgarcia85@gmail.com",
			    "awdrg543",
			    imagePath + "lgarcia.jpg",
			    "Uruguaya",
			    "1985-03-15");
			this.port.crearPostulante(
			    "matilo",
			    "Matías",
			    "López",
			    "matias.lopez90@hotmail.com",
			    "edrft543",
			    imagePath + "matilo.jpg",
			    "Argentina",
			    "1990-08-21");
			this.port.crearPostulante(
			    "maro",
			    "María",
			    "Rodríguez",
			    "marrod@gmail.com",
			    "r5t6y7u8",
			    imagePath + "maro.jpg",
			    "Uruguaya",
			    "1988-11-10");
	
			this.port.crearPostulante(
			    "javierf",
			    "Javier",
			    "Fernández",
			    "javierf93@yahoo.com",
			    "45idgaf67",
			    imagePath + "javierf.jpg",
			    "Mexicana",
			    "1993-06-05");
			this.port.crearPostulante(
			    "valen25",
			    "Valentina",
			    "Martínez",
			    "vale87@gmail.com",
			    "poiuy987",
			    imagePath + "valen25.jpg",
			    "Uruguaya",
			    "1987-02-25");
			this.port.crearPostulante(
			    "andpe12",
			    "Andrés",
			    "Pérez",
			    "anpe92@hotmail.com",
			    "xdrgb657",
			    imagePath + "andpe12.jpg",
			    "Chilena",
			    "1992-04-12");
			this.port.crearPostulante(
			    "sicam",
			    "Camila",
			    "Silva",
			    "camilasilva89@gmail.com",
			    "mnjkiu89",
			    imagePath + "sicam.jpg",
			    "Uruguaya",
			    "1989-09-30");
			this.port.crearPostulante(
			    "sebgon",
			    "Sebastián",
			    "González",
			    "gonza95@yahoo.com",
			    "ytrewq10",
			    imagePath + "sebgon.jpg",
			    "Colombiana",
			    "1995-01-18");
			this.port.crearPostulante(
			    "isabel",
			    "Isabella",
			    "López",
			    "loisa@gmail.com",
			    "sbsplol1",
			    imagePath + "isabel.jpg",
			    "Uruguaya",
			    "1991-07-07");
			this.port.crearPostulante(
			    "marram02",
			    "Martín",
			    "Ramírez",
			    "marram@hotmail.com",
			    "okmnji98",
			    imagePath + "marram02.jpg",
			    "Argentina",
			    "1986-12-02)");
	
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
			this.port.crearEmpresa(
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
			    + "Nuestro equipo multidisciplinario de ingenieros, científports de datos y desarrolladores crea "
			    + "soluciones innovadoras que aprovechan la potencia de la IA para transformar industrias. "
			    + "Desde la optimización de procesos industriales hasta la creación de asistentes virtuales "
			    + "altamente personalizados, nuestro objetivo es revolucionar la forma en que las empresas operan y "
			    + "se conectan con sus clientes.\n"
			    + "Creemos en la sinergia entre la mente humana y las capacidades de la IA, y trabajamos para "
			    + "construir un mundo donde la tecnología mejore y amplíe nuestras capacidades innatas.";
			this.port.crearEmpresa(
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
			    + "profesionales de la salud ofrecer diagnóstports más precisos, tratamientos personalizados y seguimiento continuo de los pacientes.\n"
			    + "Nuestra visión es crear un ecosistema de salud conectado en el que los datos médports se utilicen de "
			    + "manera ética y segura para mejorar la calidad de vida de las personas. A través de la innovación constante "
			    + "y la colaboración con expertos médports, estamos dando forma al futuro de la atención médica, donde la tecnología "
			    + "y la compasión se unen para salvar vidas y mejorar el bienestar en todo el mundo.";
			this.port.crearEmpresa(
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
			this.port.crearEmpresa(
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
			    "Balance Energétport Nacional (BEN). La Dirección Nacional de Energía (DNE) del Ministerio de Industria, Energía y Minería (MIEM) "
			    + "presenta anualmente el BEN.";
			this.port.crearEmpresa(
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
			this.port.crearEmpresa(
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
			System.out.println(ex.getMessage());
		} catch (CamposVaciosExcepcion ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void cargarTiposPublicacion() {
		try {
			// TIPOS DE PUBLICACION
			this.port.crearTipoPublicacion(
					"Premium",
					"Obtén máxima visibilidad", 
					1, 
					30, 
					4000, 
					"2023-08-10");
			
			this.port.crearTipoPublicacion(
					"Destacada",
					"Destaca tu anuncio", 
					2, 
					15, 
					500, 
					"2023-08-05");
			
			this.port.crearTipoPublicacion(
					"Estándar",
					"Mejora la posición de tu anuncio", 
					3, 
					20, 
					150, 
					"2023-08-15");
			
			this.port.crearTipoPublicacion(
					"Básica",
					"Publica de forma sencilla en la lista de ofertas", 
					4, 
					7, 
					50, 
					"2023-08-07");
		} catch (UsuarioRepetidoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void cargarKeywords() {
		try {
			this.port.altaKeyword("Tiempo completo");
			this.port.altaKeyword("Medio tiempo");
			this.port.altaKeyword("Remoto");
			this.port.altaKeyword("Freelance");
			this.port.altaKeyword("Temporal");
			this.port.altaKeyword("Permanente");
			this.port.altaKeyword("Computación");
			this.port.altaKeyword("Administración");
			this.port.altaKeyword("Logística");
			this.port.altaKeyword("Contabilidad");
		} catch (ElementoRepetidoException e) {
			System.out.println(e.getMessage());
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
			ArrayList<String> keywords;
			keywords.add("Tiempo completo");
			keywords.add("Medio tiempo");
			keywords.add("Remoto");
			keywords.add("Freelance");
			keywords.add("Temporal");
			keywords.add("Permanente");
			this.port.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"Desarrollador Frontend", 
					desc, 
					"09:00 - 18:00", 
					90000, 
					"Montevideo", 
					"Montevideo",
					"2023-09-30",
					imagePath + "desarrollador_frontend.jpg",
					keywords
			);
			desc = 
				"Forma parte de nuestro equipo de estrategia y "
				+ "contribuye al crecimiento de las empresas cliente";
			this.port.altaOfertaLaboral(
					"GlobalHealth", 
					"Estándar", 
					"Estratega de Negocios", 
					desc, 
					"08:00 - 17:00", 
					80000, 
					"Punta del Este", 
					"Maldonado", 
					"2023-09-29",
					imagePath + "estratega_de_negocios.jpg",
					List.of("Temporal")
			);
			desc = 
				"Trabaja en colaboraci´on con nuestro talentoso\r\n"
				+ "equipo de dise˜no para crear soluciones impactantes.";
			this.port.altaOfertaLaboral(
					"FusionTech", 
					"Estándar", 
					"Diseñador UX/UI", 
					desc, 
					"14:00 - 18:00", 
					65000, 
					"Rosario", 
					"Colonia", 
					"2023-09-29",
					imagePath + "diseñador_ux_ui.jpg",
					List.of("Medio tiempo", "Remoto", "Permanente")
			);
			
			desc = 
				"Ayuda a nuestros clientes a tomar decisiones "
				+ "informadas basadas en an´alisis y visualizaciones de dat";
			this.port.altaOfertaLaboral(
					"ANTEL", 
					"Premium", 
					"Analista de Datos", 
					desc, 
					"09:00 - 13:00", 
					40000, 
					"Maldonado", 
					"Maldonado", 
					"2023-09-19",
					imagePath + "analista_de_datos.jpg",
					List.of("Medio tiempo")
			);
			
			desc = 
				"Gestiona y crea contenido persuasivo y relevante\r\n"
				+ "para impulsar la presencia en l´ınea de nuestros\r\n"
				+ "clientes.\r\n"
				+ "";
			this.port.altaOfertaLaboral(
					"MIEM", 
					"Destacada", 
					"Content Manager", 
					desc, 
					"18:00 - 22:00", 
					10000, 
					"Montevideo", 
					"Montevideo", 
					"2023-10-02",
					imagePath + "content_manager.jpg",
					List.of("Freelance")
			);
			
			desc = 
				"Ofrece un excelente servicio de soporte t´ecnport a\r\n"
				+ "nuestros clientes, resolviendo problemas y brindando\r\n"
				+ "soluciones.";
			this.port.altaOfertaLaboral(
					"TechSolutions", 
					"Básica", 
					"Soporte Técnico", 
					desc, 
					"09:00 - 18:00", 
					30000, 
					"Minas", 
					"Lavalleja",
					"2023-09-10",
					imagePath + "soporte_tecnico.jpg",
					List.of("Tiempo completo")
			);
			desc = 
				"Unete a nuestro equipo de marketing y trabaja en ´\r\n"
				+ "estrategias digitales innovadoras.";
			this.port.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"A. de Marketing Digital", 
					desc, 
					"10:00 - 19:00", 
					80000, 
					"Flores", 
					"Flores", 
					"2023-09-21",
					imagePath + "analista_de_marketing_digital.jpg",
					new ArrayList<String>()
			);
			desc = 
				"Únete a nuestro equipo contable y ayuda en la ´\r\n"
				+ "gestión financiera de la empresa";
			this.port.altaOfertaLaboral(
					"GlobalHealth", 
					"Destacada", 
					"Contador Senior", 
					desc, 
					"08:30 - 17:30 ", 
					100000, 
					"Colonia Suiza", 
					"Colonia", 
					"2023-10-02",
					imagePath + "contador_senior.jpg",
					new ArrayList<String>()
			);
			
			desc = 
					"RÉGIMEN DE CONTRATO EN FUNCION PUB-\r\n"
					+ "LICA EN UN TODO DE ACUERDO A LA\r\n"
					+ "NORMATIVA VIGENTE (LEY 16.127, DE 7 DE\r\n"
					+ "AGOSTO DE 1990, ART. 1°, LITERAL A) Y B)\r\n"
					+ "CON LA MODIFICACI ´ON INTRODUCIDA POR\r\n"
					+ "EL ART. 11 DE LA LEY 17.930 DE 19 DE DICIEM-\r\n"
					+ "BRE DE 2005).";
			this.port.altaOfertaLaboral(
					"ANTEL", 
					"Premium", 
					"Técnico/a Básico Red", 
					desc, 
					"09:00 - 17:00", 
					40000, 
					"Paysandú", 
					"Paysandú", 
					"2023-09-29",
					imagePath + "tecnico_de_red.jpg",
					List.of("Temporal")
			);
				
			desc = 
					"Unete a nuestro equipo y lidera proyectos de desar-\r\n"
					+ "rollo de software sostenible y ecol´ogico. Impulsa la\r\n"
					+ "innovación y contribuye a un futuro m´as verde.";
			this.port.altaOfertaLaboral(
					"EcoTech", 
					"Destacada", 
					"Desarrollador de Software Senior", 
					desc, 
					"09:00 - 16:00", 
					123000, 
					"Montevideo", 
					"Montevideo", 
					"2023-10-02",
					imagePath + "desarrollador_de_software_senior.jpg",
					List.of("Tiempo completo", "Permanente", "Logística")
			);
					
			desc = 
					"Unete a nuestro equipo para crear soluciones de soft-\r\n"
					+ "ware personalizadas de extremo a extremo. Colabora\r\n"
					+ "en proyectos emocionantes y desafiantes.";
			this.port.altaOfertaLaboral(
					"TechSolutions", 
					"Premium", 
					"Desarrollador de Software Full Stack", 
					desc, 
					"04:00 - 13:00", 
					135000, 
					"Río Negro", 
					"Fray Bentos", 
					"2023-09-25",
					imagePath + "desarrollador_de_software_full_stack.jpg",
					List.of("Remoto")
			);
			
			desc = 
					"Unete a nuestro equipo de gesti´on de proyectos y lid-\r\n"
					+ "era la entrega exitosa de soluciones de software per-\r\n"
					+ "sonalizadas. Colabora con equipos multidisciplinar-\r\n"
					+ "ios y clientes exigentes.";
			this.port.altaOfertaLaboral(
					"TechSolutions", 
					"Destacada", 
					"Gerente de Proyecto", 
					desc, 
					"04:00 - 12:00", 
					230000, 
					"Montevideo", 
					"Montevideo", 
					"2023-10-02",
					imagePath + "gerente_de_proyectos.jpg",
					List.of("Remoto", "Permanente")
			);
			
			desc = 
					"Asegura la calidad de nuestros productos de software\r\n"
					+ "sostenibles. ´Unete a nosotros para garantizar un im-\r\n"
					+ "pacto positivo en el medio ambiente.";
			this.port.altaOfertaLaboral(
					"EcoTech", 
					"Premium", 
					"Ingeniero de Calidad de Software", 
					desc, 
					"14:00 - 18:00", 
					60000, 
					"Montevideo", 
					"Montevideo", 
					"2023-10-01",
					imagePath + "ingeniero_de_calidad_de_software.jpg",
					List.of("Tiempo completo", "Contabilidad")
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
			+ "equipo dinámport y contribuir con \n"
			+ "mis habilidades de liderazgo.\r\n"
			+ "";
			this.port.altaPostulacion(
					"lgarcia", 
					"Desarrollador Frontend", 
					cvv, 
					motivacion, 
					"2023-10-01");
						
			cvv = 
			"Estudiante de Comunicación, habilidades en redacción y manejo \n"
			+ "de redes sociales. Experiencia en \n"
			+ "prácticas en medios locales";
					
			motivacion = 
			"Me encantaría formar parte de \n"
			+ "un equipo que me permita desarorollar mis habilidades en comunicación "
			+ "y marketing.";
			this.port.altaPostulacion(
					"matilo", 
					"Estratega de Negocios", 
					cvv, 
					motivacion, 
					"2023-09-30");
			
			cvv = 
			"Ingeniero en Sistemas, experiencia en desarrollo web "
			+ "y aplicaciones móviles. Conocimientos\r\n"
			+ "en JavaScript y React.";
					
			motivacion = 
			"Me entusiasma la posibilidad de\r\n"
			+ "trabajar en proyectos desafiantes\r\n"
			+ "y seguir creciendo "
			+ "como profesional en el campo de la tecnología.";
			this.port.altaPostulacion(
					"maro", 
					"Desarrollador Frontend", 
					cvv, 
					motivacion, 
					"2023-10-02");
			
			cvv = 
			"Técnico en Electricidad, "
			+ "experiencia en mantenimiento industrial. Conocimientos en lectura\r\n"
			+ "de planos eléctrports.";
					
			motivacion = 
			"Estoy interesado en formar parte \n"
			+ "de un equipo que me permita \n"
			+ "aplicar mis habilidades t´ecnicas y \n"
			+ "contribuir al mantenimiento eficiente";
			this.port.altaPostulacion(
					"javierf", 
					"Diseñador UX/UI", 
					cvv, 
					motivacion, 
					"2023-09-30");
			
			cvv = 
			"Músport profesional, experiencia\r\n"
			+ "en espectáculos en vivo. Habilidades en canto y guitarra. \n"
			+ "";
					
			motivacion = 
			"Me gustar´ıa combinar mi pasión \n"
			+ "por la música con una oportunidad laboral que me permita \n"
			+ "seguir creciendo como artista.\r\n"
			+ "";
			this.port.altaPostulacion(
					"valen25", 
					"Estratega de Negocios", 
					cvv, 
					motivacion, 
					"2023-09-30");
			
			cvv = 
			"Licenciada en Administración,\r\n"
			+ "me considero genia, experiencia\r\n"
			+ "en gestión de equipos y proyectos. Conocimientos en Microsoft\r\n"
			+ "Office";
					
			motivacion = 
			"Estoy emocionada por la oportunidad de formar parte de un\r\n"
			+ "equipo dinámport y contribuir con\r\n"
			+ "mis habilidades de liderazgo.\r\n"
			+ ""
			+ "";
			this.port.altaPostulacion(
					"lgarcia", 
					"Estratega de Negocios", 
					cvv, 
					motivacion, 
					"2023-10-02");
		} catch (ElementoRepetidoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteInstancia e) {
			System.out.println(e.getMessage());
		} catch (ElementoInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
