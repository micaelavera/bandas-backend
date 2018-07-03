package domainModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Postulacion {

	private Long id;
	private String generoMusical;
	private String instrumento;
	private List <Notificacion> notificaciones;
	
	public Postulacion(){
	}
	
	public Postulacion (String generoMusical, String instrumento){
		this.generoMusical = generoMusical;
		this.instrumento = instrumento;
		this.notificaciones=new ArrayList<Notificacion>();
	}
	
	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "postulacion", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public void addNotificacion(Notificacion notificacion){
		notificaciones.add(notificacion);
		notificacion.setPostulacion(this);
	}
	
	public void removeNotificacion(Notificacion notificacion){
		notificaciones.remove(notificacion);
		notificacion.setPostulacion(null);
	}
	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
}