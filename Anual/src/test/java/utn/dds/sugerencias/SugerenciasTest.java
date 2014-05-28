package utn.dds.sugerencias;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.admin.Admin;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.excepciones.NoEsAmigoException;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Estandar;

public class SugerenciasTest {

	Jugador moriaCasan;
	Jugador mellizasGriegas;
	Jugador belenFrnaccese;
	
	Admin marceloTinelli;
	
	Partido semisDeCopa;
	
	
	@Before
	public void setUp() throws Exception {
		
		moriaCasan = new Jugador();
		mellizasGriegas = new Jugador();
		belenFrnaccese = new Jugador();
		
		marceloTinelli = Admin.getInstancia();
		
		semisDeCopa = new Partido();
		
		moriaCasan.agregarAmigo(mellizasGriegas);
	}
	
	@Test
	public void jugadorSugiereAlAdmin(){
		
		
		moriaCasan.sugerirAmigo(mellizasGriegas, semisDeCopa, new Estandar());
		
		Assert.assertEquals(1, marceloTinelli.getSugerencias().size());
		
	}
	
	@Test (expected = NoEsAmigoException.class)
	public void jugadorNoPuedeAgregarNoAmigos(){
		
		moriaCasan.sugerirAmigo(belenFrnaccese, semisDeCopa, new Estandar());
		
	}
	
	@Test
	public void adminAceptaSugerencias(){
		
		moriaCasan.sugerirAmigo(mellizasGriegas, semisDeCopa, new Estandar());
		
		marceloTinelli.aceptarSugerencia(marceloTinelli.getSugerencias().get(0));
		
		Assert.assertEquals(1, semisDeCopa.cantidadDeInscriptos());
	}

}
