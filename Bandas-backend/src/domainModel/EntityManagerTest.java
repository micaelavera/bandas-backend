package domainModel;

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
		// Creamos un musico con su postulacion
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Postulacion p1=new Postulacion("Rock","guitarra");
		
		entityManager.persist(p1);
		entityManager.getTransaction().begin();
		entityManager.close();
	}	
		
	@Test
	public void creandoPostulacion(){
		Musico musico=new Musico();
		musico.setPostulacion(new Postulacion("Rock","guitarra"));
		
		//MusicoDAO musico_dao=new MusicoDAO();
		//musico.saveMusico(musico);
	}
}