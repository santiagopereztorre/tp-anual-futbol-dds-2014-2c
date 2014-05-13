package utn.disenio.bajaJugador;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.partido.exceptions.NoHayVacantesException;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.Solidaria;

public class BajaJugadorTest {
	
	Partido partido;
	Jugador juan = new Jugador();
	Jugador carlitos = new Jugador();
	Jugador pepe = new Jugador();
	Jugador jugadorNoInscripto = new Jugador();
	
	@Before
	public void setUp() throws Exception 
	{
		partido = new Partido();

		partido.inscribirJugador(pepe, new Condicional());
		partido.inscribirJugador(juan, new Estandar());
		partido.inscribirJugador(carlitos, new Estandar());
	}
	
	@Test
	public void bajaJugador(){
		long cantInscriptos = partido.cantidadDeInscriptos();
		
		partido.darseBaja(juan);		
		Assert.assertEquals(partido.cantidadDeInscriptos(),cantInscriptos-1);
	}
	
	@Test
	public void bajaJugadorNoInscripto(){
		long cantInscriptos = partido.cantidadDeInscriptos();
		
		partido.darseBaja(jugadorNoInscripto);		
		Assert.assertEquals(partido.cantidadDeInscriptos(),cantInscriptos);
	}
	
	// testear que el jugador que se dió de baja ya no esté en la lista de inscriptos.
}
