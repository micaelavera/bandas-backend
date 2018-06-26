package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Postulacion {

	@GeneratedValue
	@Id
	private Long id;
	
	private String generoMusical;
	private String instrumento;



}
