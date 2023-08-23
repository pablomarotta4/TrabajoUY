package logica.interfaces;

import java.util.Date;
import java.util.List;

public interface IControladorOferta {

	public void altaOfertaLaboral(
			String empresa,
			String tipoPublicacion,
			String nombre,
			String descripcion,
			String horario,
			float remuneracion,
			String ciudad,
			String departamento,
			Date fechaAlta,
			List<String> keywords
		);
}
