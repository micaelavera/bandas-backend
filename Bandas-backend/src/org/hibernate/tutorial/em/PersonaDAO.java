package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersonaDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	
	public PersonaDAO(){
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}

	public void saveEmpleado(Empleado e){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
//	public List<Empleado> getEmpleados(){
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		List<Empleado> result = entityManager.createQuery( "from Empleado", Empleado.class).getResultList();
//		for ( Empleado empleado:result) {
//			System.out.println( empleado.getLegajo()+ " " + empleado.getNombre());
//		}
//        entityManager.getTransaction().commit();
//        entityManager.close();
//		return result;
//	}
	
	public void removeEmpleado(Empleado e){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(e);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//	
//		entityManager.persist(e);
//		
//		entityManager.getTransaction().commit();
//		entityManager.close();	
//	}
	
//	public Empleado getEmpleado(){
//		return new Empleado();
//	}
	
	
}
