package utn.disenio.observers;

import java.util.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.observers.*;

import static org.mockito.Mockito.validateMockitoUsage;

public class ObserversTest {
	
	Partido partido;
	
	
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
	Jugador jugador11 = new Jugador();
	
	ObsAdmBaja10Jugadores mockObsPartidoDescompleto = mock(ObsAdmBaja10Jugadores.class);
	ObsAdm10Conf mockObsPartidoCompleto = mock(ObsAdm10Conf.class);
	ObsInscripcionJugador mockObsInscripcion = mock(ObsInscripcionJugador.class);
	
	@Before
	public void setUp() throws Exception 
	{
		partido = new Partido();
		
		partido.inscribirJugador(jugador1, new Condicional());
		partido.inscribirJugador(jugador2, new Estandar());
		partido.inscribirJugador(jugador3, new Estandar());
		partido.inscribirJugador(jugador4, new Condicional());
		partido.inscribirJugador(jugador5, new Estandar());
		partido.inscribirJugador(jugador6, new Estandar());
		partido.inscribirJugador(jugador7, new Condicional());
		partido.inscribirJugador(jugador8, new Estandar());
		partido.inscribirJugador(jugador9, new Estandar());
		
		partido.agregarObservadorIncompleto(mockObsPartidoDescompleto);
		partido.agregarObservadorCompleto(mockObsPartidoCompleto);
		partido.agregarObservadorInscripcion(mockObsInscripcion);
	}
	
	@Test
	public void seNotificaCuandoHay10Confirmados(){
		partido.inscribirJugador(jugador10, new Estandar());
		
		Mockito.verify(mockObsPartidoCompleto).completo();
		
					//Assert.assertTrue(Mockito.verify(mockObsPartidoCompleto).notificar()); // aparentemente anda bien así
					//Assert.assertTrue(Mockito.verify(mockObsPartidoCompleto, notificar.times(1)));
	//	partido.darDeBaja(jugador10);
	
	}
	
	@Test
	public void seNotificaCuandoYaNoHay10Confirmados(){
		partido.inscribirJugador(jugador11, new Estandar());
		partido.darDeBaja(jugador1);
		
		Mockito.verify(mockObsPartidoDescompleto).descompleto();
		
					//Assert.assertTrue(Mockito.verify(mockObsPartidoDescompleto).notificar());
					//Assert.assertTrue(Mockito.verify(mockObsPartidoDescompleto, Mockito.times(1))); // probar si testea lo que queremos. 
	}
	
	@Test
	public void seNotificaAAmigosCuandoUnJugadorSeInscribeAUnPartido(){
		partido.inscribirJugador(jugador1, new Estandar());
		
		Class<ArrayList<Jugador>> listClass = (Class<ArrayList<Jugador>>)(Class)ArrayList.class;
		ArgumentCaptor<ArrayList<Jugador>> argument = ArgumentCaptor.forClass(listClass);
		
		Mockito.verify(mockObsInscripcion).notificar(argument.capture(), null);
		
		
				//Assert.assertTrue(Mockito.verify(mockObsInscripcion).notificar(argument.capture())); 
				//Mockito.verify(mockObsInscripcion, Mockito.times(1));
	}
	
	@After
	public void validate() {
		validateMockitoUsage();
	}
}
