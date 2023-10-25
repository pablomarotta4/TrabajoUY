package logica.entidades;

public class Usuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String imageUrl;

	
	public Usuario(String nick, String nombre, String apellido, String email, String password, String imageUrl) {
		this.nickname = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;

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
	
	public String getPassword() {
		return password;
	}
	
	public String getImage() {
		return this.imageUrl;
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
	
	public void setImage(String image) {
		this.imageUrl = image;
	}
	
	public boolean evaluarCredenciales(String nick, String pass) {
		return (this.nickname.equals(nick)) && (this.password.equals(pass));
	}
}
