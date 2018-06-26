package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Banda {

	private Long id;
	
	private String nombre;
	private Busqueda busqueda;
	
	Banda(String nombre){
		this.nombre=nombre;
	}

	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
