package logica.entidades;

public class Usuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	
	public Usuario(String nick,String nombre, String apellido, String email) {
		this.nickname = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
}
