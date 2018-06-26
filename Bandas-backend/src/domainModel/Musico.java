package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Musico {

	private Long id;
	
	private String nombre;
	private Postulacion postulacion;

	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	// ¿Un musico crea una o muchas postulaciones?
	public Postulacion getPostulacion() {
		return postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}
	

	
}
