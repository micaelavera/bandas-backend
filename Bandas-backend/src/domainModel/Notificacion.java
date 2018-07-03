package domainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notificacion {

	private Long id;
	private Postulacion postulacion;
	private Busqueda busqueda;
	
	public Notificacion(){
		
	}
	
	public Notificacion(Postulacion postulacion,Busqueda busqueda){
		this.postulacion = postulacion;
		this.busqueda = busqueda;
	}
	
	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}
	
	@ManyToOne
	public Postulacion getPostulacion() {
		return postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}

	@ManyToOne
	public Busqueda getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}