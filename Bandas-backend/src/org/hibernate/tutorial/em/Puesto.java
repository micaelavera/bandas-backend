package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Puesto {
	
	private Long id;	
	private String nombre;
	private String descripcion;
	private List<Empleado> empleados;
	

	Puesto(String nombre,String descripcion){
		this.nombre=nombre;
		this.descripcion=descripcion;
		empleados=new ArrayList<Empleado>();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(mappedBy = "puesto", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
}
