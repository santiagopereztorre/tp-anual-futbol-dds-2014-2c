package utn.disenio.observers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;

public class ObserversTest {
	
	Partido partido;
	
	List<ObsPartidoDescompleto> obsPartidoDescompleto = new ArrayList<ObsPartidoDescompleto>();
	List<ObsPartidoCompleto> obsPartidoCompleto = new ArrayList<ObsPartidoCompleto>();
	List<ObsPartidoInscripcion> obsPartidoInscripcion = new ArrayList<ObsPartidoInscripcion>();
	
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
	
	
	@BeforeClass
	public static void init()
	{	
		ObsAdm10Conf mockObsPartidoDescompleto = mock(ObsAdm10Conf.class);
		when(mockObsPartidoDescompleto.notificar()).thenReturn(true);
		obsPartidoDescompleto.add(mockObsPartidoDescompleto);
		
		ObsAdm10Conf mockObsPartidoCompleto = mock(ObsAdm10YaNoConf.class);
		when(mockObsPartidoCompleto.notificar()).thenReturn(true);
		obsPartidoCompleto.add(mockObsPartidoCompleto);
		
		ObsAdm10Conf mockObsInscripcion = mock(ObsAmigosInsc.class);
		when(mockObsInscripcion.notificar()).thenReturn(true);
		obsPartidoInscripcion.add(mockObsInscripcion);
	}
	
	@Before
	public void setUp() throws Exception 
	{
		partido = new Partido();
		partido.setObsPartidoDescompleto(obsPartidoDescompleto);
		partido.obsPartidoCompleto(obsPartidoCompleto);
		partido.obsPartidoInscripcion(obsPartidoInscripcion);
		
		partido.inscribirJugador(jugador1, new Condicional());
		partido.inscribirJugador(jugador2, new Estandar());
		partido.inscribirJugador(jugador3, new Estandar());
		partido.inscribirJugador(jugador4, new Condicional());
		partido.inscribirJugador(jugador5, new Estandar());
		partido.inscribirJugador(jugador6, new Estandar());
		partido.inscribirJugador(jugador7, new Condicional());
		partido.inscribirJugador(jugador8, new Estandar());
		partido.inscribirJugador(jugador9, new Estandar());
	}
	
	@Test
	public void seNotificaCuandoHay10Confirmados(){
		partido.inscribirJugador(jugador10, new Estandar());		
		Assert.assertTrue(mockObsPartidoCompleto.notificar());
	}
	
	@Test
	public void seNotificaCuandoYaNoHay10Confirmados(){
		partido.darseBaja(jugador1);		
		Assert.assertTrue(mockObsPartidoDescompleto.notificar());
	}
	
	@Test
	public void seNotificaAAmigosCuandoUnJugadorSeInscribeAUnPartido(){
		partido.inscribirJugador(jugador1, new Estandar());
		
		Assert.assertTrue(mockObsInscripcion.notificar());
	}
}
