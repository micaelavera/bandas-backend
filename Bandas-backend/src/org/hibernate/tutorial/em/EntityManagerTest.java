package org.hibernate.tutorial.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class EntityManagerTest {
	private static EntityManagerFactory entityManagerFactory;

	@BeforeClass
	public static void setUp() throws Exception {
			entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}

	@AfterClass
	public static void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testHibernate() {
		// Creamos un cliente con su dirección
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		A a1=new A ("a1_1");
		A a2=new A ("a1_2");
		A a3=new A ("a1_3");
		A a4=new A ("a1_4");
		entityManager.getTransaction().begin();
	
		entityManager.persist(a1);
		entityManager.persist(a2);
		entityManager.persist(a3);
		entityManager.persist(a4);

		

		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        List <A> result = entityManager.createQuery( "from A", A.class ).getResultList();
		for ( A a : result ) {
			System.out.println( a.getA1());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
//
//		//y los recuperamos.
//		entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//        List<Cliente> result = entityManager.createQuery( "from Cliente", Cliente.class ).getResultList();
//		for ( Cliente cliente : result ) {
//			System.out.println( cliente.getRazonSocial() + " " + cliente.getDir().getDomicilio());
//		}
		
}
//	
//	@Test
//	public void testCreandoEmpleado(){
//		//Creamos empleado
//		Empleado empleado = new Empleado("Pepe", "Rodriguez");
//		empleado.setPuesto(new Puesto("Tecnico","Cableado"));
//		Empleado empleado2 = new Empleado("Jorge", "Morales");
//		empleado2.setPuesto(new Puesto("Mantenimiento","Limpieza"));
//
//		PersonaDAO persona= new PersonaDAO();
//		persona.saveEmpleado(empleado);
//
//	}
	
//	@Test
//	public void testGetEmpleados(){
//		Empleado empleado = new Empleado("Pepe", "Rodriguez");
//		empleado.setPuesto(new Puesto("Tecnico","Cableado"));
//		Empleado empleado2 = new Empleado("Jorge", "Morales");
//		empleado2.setPuesto(new Puesto("Mantenimiento","Limpieza"));
//
//		PersonaDAO persona= new PersonaDAO();
//		persona.saveEmpleado(empleado);
//		
//	}

//	@Test
//	public void testBorrandoEmpleado(){
//		//Creamos empleado
//		Empleado empleado = new Empleado("Pepe", "Rodriguez");
//		empleado.setPuesto(new Puesto("Tecnico","Cableado"));
//
//		PersonaDAO persona= new PersonaDAO();
//		persona.saveEmpleado(empleado);
//		
//		persona.removeEmpleado(empleado);
//
//	}
//	
}
