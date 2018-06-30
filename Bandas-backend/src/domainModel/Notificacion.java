package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notificacion {

	private Long id;
	private Postulacion postulacion;
	private Busqueda busqueda;
	
	public Notificacion(Postulacion postulacion,Busqueda busqueda){
		this.postulacion=postulacion;
		this.busqueda=busqueda;
	}
	
	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Postulacion getPostulacion() {
		return postulacion;
	}
	
	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}
	
	public Busqueda getBusqueda() {
		return busqueda;
	}
	
	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}	
}