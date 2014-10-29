package utn.dds.jpa;



import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utn.dds.db.EntityManagerHelper;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.persistentEntity.PersistentEntity;
import utn.dds.tipoInscripcion.Estandar;

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
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Partido partido = new Partido(new Date());
		
		partido.inscribirJugador(jugador1, new Estandar());
		partido.inscribirJugador(jugador2, new Estandar());
		
		EntityManagerHelper.persist(jugador1);
		EntityManagerHelper.persist(jugador2);
		EntityManagerHelper.persist(partido);
		jugador1.calificar(jugador2, partido, 5, "Es un trolo");
		jugador1.setApodo("sarasa");
	}

}
