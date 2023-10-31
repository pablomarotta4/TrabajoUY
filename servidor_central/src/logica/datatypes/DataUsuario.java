package logica.datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String imageUrl;
	
	public DataUsuario() {
		
	}
	
	public DataUsuario(String nickname, String nombre, String apellido, String email, String imageUrl) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.imageUrl = imageUrl;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setNickname(String nick) {
		this.nickname = nick;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
