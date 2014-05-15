package utn.disenio.bajaJugador;

import java.util.List;
import java.util.NoSuchElementException;

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
		
		partido.darDeBaja(juan);		
		Assert.assertEquals(partido.cantidadDeInscriptos(),cantInscriptos-1);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void bajaJugadorNoInscriptoDebeFallar(){
		long cantInscriptos = partido.cantidadDeInscriptos();
		
		partido.darDeBaja(jugadorNoInscripto);
	}
	
	@Test
	public void jugadorDadoDeBajaYaNoEstaInscripto(){
		Jugador juanDomingo = new Jugador();
		partido.inscribirJugador(juanDomingo, new Condicional());
		
		partido.darDeBaja(juanDomingo);		
		Assert.assertFalse(partido.jugadorInscripto(juanDomingo));
	}

	@Test
	public void inscribirReemplazo(){
		Jugador juanDomingo = new Jugador();
		partido.inscribirJugador(juanDomingo, new Condicional());
		
		Jugador evita = new Jugador();
		
		partido.darDeBajaConReemplazo(juanDomingo, evita);		
		Assert.assertTrue(partido.jugadorInscripto(evita));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void noInscribirReemplazoSiElQueSeDaDeBajaNoEstabaInscripto(){
		Jugador josefa = new Jugador();
		
		partido.darDeBajaConReemplazo(jugadorNoInscripto, josefa);
	}
	
	@Test
	public void jugadorRecibeInfraccionSiDaDeBajaSinReemplazo(){
		Jugador juanDomingo = new Jugador();
		partido.inscribirJugador(juanDomingo, new Condicional());
		
		int cantInfracciones = juanDomingo.cantidadInfracciones();
		
		partido.darDeBaja(juanDomingo);		
		Assert.assertEquals(juanDomingo.cantidadInfracciones(), cantInfracciones + 1);
	}
}
