package utn.disenio.observers;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.observers.*;

public class ObserversTest {
	
	Partido partido;
	
	List<ObsPartidoDescompleto> obsPartidoDescompleto = new ArrayList<ObsPartidoDescompleto>();
	List<ObsPartidoCompleto> obsPartidoCompleto = new ArrayList<ObsPartidoCompleto>();
	List<ObsPartidoInscripcion> obsPartidoInscripcion = new ArrayList<ObsPartidoInscripcion>();
	List<Jugador> listaAmigos = new ArrayList<Jugador>();
	
	Jugador jugador1 = new Jugador();
	Jugador jugador2 = new Jugador();
	Jugador jugador3 = new Jugador();
	Jugador jugador4 = new Jugador();
	Jugador jugador5 = new Jugador();
	Jugador jugador6 = new Jugador();
	Jugador jugador7 = new Jugador();
	Jugador jugador8 = new Jugador();
	Jugador jugador9 = new Jugador();
	Jugador jugador10 = new Jugador();
	
	ObsAdmBaja10Jugadores mockObsPartidoDescompleto = mock(ObsAdmBaja10Jugadores.class);
	ObsAdm10Conf mockObsPartidoCompleto = mock(ObsAdm10Conf.class);
	ObsInscripcionJugador mockObsInscripcion = mock(ObsInscripcionJugador.class);
	
	@Before
	public void setUp() throws Exception 
	{
		partido = new Partido();
		partido.setObsPartidoDescompleto(obsPartidoDescompleto);
		partido.setObsPartidoCompleto(obsPartidoCompleto);
		partido.setObsPartidoInscripcion(obsPartidoInscripcion);
		
		partido.inscribirJugador(jugador1, new Condicional());
		partido.inscribirJugador(jugador2, new Estandar());
		partido.inscribirJugador(jugador3, new Estandar());
		partido.inscribirJugador(jugador4, new Condicional());
		partido.inscribirJugador(jugador5, new Estandar());
		partido.inscribirJugador(jugador6, new Estandar());
		partido.inscribirJugador(jugador7, new Condicional());
		partido.inscribirJugador(jugador8, new Estandar());
		partido.inscribirJugador(jugador9, new Estandar());
		
		obsPartidoDescompleto.add(mockObsPartidoDescompleto);
		obsPartidoCompleto.add(mockObsPartidoCompleto);
		obsPartidoInscripcion.add(mockObsInscripcion);
	}
	
	@Test
	public void seNotificaCuandoHay10Confirmados(){
		partido.inscribirJugador(jugador10, new Estandar());
		//Assert.assertTrue(Mockito.verify(mockObsPartidoCompleto).notificar()); // aparentemente anda bien así
		Mockito.verify(mockObsPartidoCompleto).notificar(); // probar si anda
		
					//Assert.assertTrue(Mockito.verify(mockObsPartidoCompleto, notificar.times(1)));
	}
	
	@Test
	public void seNotificaCuandoYaNoHay10Confirmados(){
		partido.darDeBaja(jugador1);
		//Assert.assertTrue(Mockito.verify(mockObsPartidoDescompleto).notificar());
		Mockito.verify(mockObsPartidoDescompleto, Mockito.times(1)); // probar si testea lo que queremos. probar si hace assert o no.
		
		//Assert.assertTrue(Mockito.verify(mockObsPartidoDescompleto, Mockito.times(1))); // probar si testea lo que queremos. 
	}
	
	@Test
	public void seNotificaAAmigosCuandoUnJugadorSeInscribeAUnPartido(){
		partido.inscribirJugador(jugador1, new Estandar());
		
		
		Class<ArrayList<Jugador>> listClass = (Class<ArrayList<Jugador>>)(Class)ArrayList.class;
		ArgumentCaptor<ArrayList<Jugador>> argument = ArgumentCaptor.forClass(listClass);
		
		Assert.assertTrue(Mockito.verify(mockObsInscripcion).notificar(argument.capture())); 
		
		//Mockito.verify(mockObsInscripcion, Mockito.times(1));
	}
}
