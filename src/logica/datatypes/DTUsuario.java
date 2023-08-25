package logica.datatypes;

public class DTUsuario {
	
		private String nickname;
		private String nombre;
		private String apellido;
		private String email;

		public DTUsuario(String nick, String nombre, String apellido, String email) {
			this.nickname = nick;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
		}
}
