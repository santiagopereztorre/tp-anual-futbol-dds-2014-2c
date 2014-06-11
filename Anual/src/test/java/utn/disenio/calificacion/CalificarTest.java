package utn.disenio.calificacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.excepciones.JugadorNoJugoElPartidoException;
import utn.dds.jugador.excepciones.NoPodesCalificarteAVosMismoException;
import utn.dds.jugador.excepciones.YaFueCalificadoException;
import utn.dds.jugador.excepciones.NoJugaronJuntosException;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class CalificarTest {
	
	Partido partido1;
	Partido partido2;
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugador3;
	TipoInscripcion inscripcionEstandar;
	
	@Before
	public void setUp() throws Exception {
		partido1 = new Partido();
		partido2 = new Partido();
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		jugador3 = new Jugador();
		inscripcionEstandar = new Estandar();
	}

	@Test
	public void unJugadorJugoConOtroUnPartido() {
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		partido1.inscribirJugador(jugador2, inscripcionEstandar);
		assertTrue("No jugaron el mismo partido", jugador1.jugueCon(jugador2, partido1));
	}
	
	@Test
	public void unJugadorNoJugoConOtroUnPartido() {
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		partido1.inscribirJugador(jugador2, inscripcionEstandar);
		assertFalse("Jugaron el mismo partido", jugador1.jugueCon(jugador3, partido1));
	}
	
	@Test
	public void unJugadorCalificaAOtro()
	{
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		partido1.inscribirJugador(jugador2, inscripcionEstandar);
		Integer cantidadCalificaciones = jugador2.cantidadCalificaciones();
		jugador1.calificar(jugador2, partido1, 7, "Me gusto");
		assertEquals(cantidadCalificaciones + 1, jugador2.cantidadCalificaciones());
	}
	
	@Test (expected = YaFueCalificadoException.class)
	public void unJugadorNoPuedeCalificarAOtroSiYaLoCalifico()
	{
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		partido1.inscribirJugador(jugador2, inscripcionEstandar);
		jugador1.calificar(jugador2, partido1, 8, "Me gusto");
		jugador1.calificar(jugador2, partido1, 10, "Me gusto mucho");
	}
	
	@Test (expected = NoJugaronJuntosException.class)
	public void unJugadorNoPuedeCalificarSiNoJugoElMismoPartido()
	{
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		partido2.inscribirJugador(jugador2, inscripcionEstandar);
		jugador1.calificar(jugador2, partido1, 6, "Me gusto");
	}
	
	@Test (expected = NoJugaronJuntosException.class)
	public void unJugadorNoPuedeCalificarSiNoJugoElPartido()
	{
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		jugador1.calificar(jugador2, partido1, 5, "Me gusto");
	}
	
	@Test (expected = NoPodesCalificarteAVosMismoException.class)
	public void unJugadorNoPuedeCalificarseASiMismo()
	{
		partido1.inscribirJugador(jugador1, inscripcionEstandar);
		jugador1.calificar(jugador1, partido1, 7, "Me gusto");
	}

	@Test (expected = JugadorNoJugoElPartidoException.class)
	public void unJugadorNoPuedeCalificarSinoJugoElPartido()
	{
		partido1.inscribirJugador(jugador2, inscripcionEstandar);
		int cantidadCalificaciones = jugador2.cantidadCalificaciones();
		jugador1.calificar(jugador2, partido1, 9, "Me gusto");
		assertEquals(cantidadCalificaciones, jugador2.cantidadCalificaciones());
	}

}
