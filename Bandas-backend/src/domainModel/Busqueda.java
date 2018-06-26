package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Busqueda {

	private Long id;

	private String instrumento;
	private String experiencia;
//	private Date sugerencia; la sugerencia es de tipo date ?
	
	Busqueda(String instrumento,String experiencia){
		this.instrumento=instrumento;
		this.experiencia=experiencia;
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
