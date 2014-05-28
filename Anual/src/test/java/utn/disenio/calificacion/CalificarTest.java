package utn.disenio.calificacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class CalificarTest {
	
	Partido partido;
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugador3;
	TipoInscripcion inscripcionEstandar;
	
	@Before
	public void setUp() throws Exception {
		partido = new Partido();
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		jugador3 = new Jugador();
		inscripcionEstandar = new Estandar();
	}

	@Test
	public void unJugadorJugoConOtroUnPartido() {
		partido.inscribirJugador(jugador1, inscripcionEstandar);
		partido.inscribirJugador(jugador2, inscripcionEstandar);
		assertTrue("No jugaron el mismo partido", jugador1.jugueCon(jugador2, partido));
	}
	
	@Test
	public void unJugadorNoJugoConOtroUnPartido() {
		partido.inscribirJugador(jugador1, inscripcionEstandar);
		partido.inscribirJugador(jugador2, inscripcionEstandar);
		assertTrue("Jugaron el mismo partido", jugador1.jugueCon(jugador3, partido));
	}

	@Test
	public void testCalificar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarCalificacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testFuiCalificado() {
		fail("Not yet implemented");
	}

}
