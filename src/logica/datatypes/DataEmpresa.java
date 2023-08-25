package logica.datatypes;

public class DataEmpresa extends DataUsuario{
	
	private String descripcion;
	private String link;

	public DataEmpresa(String nick, 
			String nombre, 
			String apellido, 
			String email,
			String descripcion,
			String link) {
		super(nick, nombre, apellido, email);
		this.descripcion = descripcion;
		this.link = link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getLink() {
		return link;
	}
}
