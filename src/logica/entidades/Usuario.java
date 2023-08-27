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
	
	//Getters
	public String getNickname() {
		return this.nickname;
	}
	public String getEmail() {
		return this.email;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
	//Setters
	public void setNickname(String nick) {
		this.nickname = nick;
	}
	public void setNombre(String nombre ){
		this.nombre = nombre;
	}
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	public void setEmail(String email){
		this.email = email;
	}
}
