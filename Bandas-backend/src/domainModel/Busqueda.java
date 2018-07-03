package domainModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Busqueda {

	private Long id;
	private String instrumento;
	private String experiencia;
	private String fechaSugerencia;
	private List <Notificacion> notificaciones;
	
	
	public Busqueda(){
		
	}
	
	public Busqueda(String instrumento,String experiencia,String fechaSugerencia){
		this.instrumento = instrumento;
		this.experiencia = experiencia;
		this.fechaSugerencia = fechaSugerencia;
		this.notificaciones=new ArrayList<Notificacion>();
	}
	
	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}
	@OneToMany(mappedBy = "busqueda", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addNotificacion(Notificacion notificacion){
		notificaciones.add(notificacion);
		notificacion.setBusqueda(this);
	}
	
	public void removeNotificacion(Notificacion notificacion){
		notificaciones.remove(notificacion);
		notificacion.setBusqueda(null);
	}
	
	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getFechaSugerencia() {
		return fechaSugerencia;
	}

	public void setFechaSugerencia(String fechaSugerencia) {
		this.fechaSugerencia = fechaSugerencia;
	}
}