package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notificacion {

	private Long id;
//private Postulacion postulacion;
	//private Busqueda busqueda;
	
	public Notificacion(){
		
	}
	
//	public Notificacion(Postulacion postulacion,Busqueda busqueda){
////		this.postulacion = postulacion;
////		this.busqueda = busqueda;
//	}
	
	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}