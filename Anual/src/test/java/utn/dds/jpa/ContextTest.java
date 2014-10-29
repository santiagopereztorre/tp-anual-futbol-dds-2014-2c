package utn.dds.jpa;



import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utn.dds.db.EntityManagerHelper;
import utn.dds.jugador.Jugador;
import utn.dds.persistentEntity.PersistentEntity;

public class ContextTest {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		EntityManagerHelper.withTransaction(() -> {});
	}
	
	@Before
   public void begin() throws Exception {
		EntityManagerHelper.beginTransaction();
   }
	
	@After
   public void tearDown() throws Exception {
		EntityManagerHelper.rollback();
   }
	
	@Test
	public void testName() throws Exception {
		Jugador jugador = new Jugador();
		EntityManagerHelper.persist(jugador);
	}

}
