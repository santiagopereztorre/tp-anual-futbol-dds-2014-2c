package utn.dds.sugerencias;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.admin.Admin;
import utn.dds.admin.Rechazo;
import utn.dds.admin.Sugerencia;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.excepciones.NoEsAmigoException;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Estandar;

public class SugerenciasTest {

	Jugador moriaCasan;
	Jugador mellizasGriegas;
	Jugador belenFranccese;
	
	Admin marceloTinelli;
	
	Partido semisDeCopa;
	
	
	@Before
	public void setUp() throws Exception {
		
		moriaCasan = new Jugador();
		mellizasGriegas = new Jugador();
		belenFranccese = new Jugador();
		
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
		
		moriaCasan.sugerirAmigo(belenFranccese, semisDeCopa, new Estandar());
		
	}
	
	@Test
	public void adminAceptaSugerencias(){
		
		Sugerencia nuevaSugerencia = new Sugerencia(moriaCasan, semisDeCopa, new Estandar());
		
		marceloTinelli.sugerir(nuevaSugerencia);
		
		marceloTinelli.aceptarSugerencia(nuevaSugerencia);
		
		Assert.assertEquals(1, semisDeCopa.cantidadDeInscriptos());
		
		
	}
	
	@Test
	public void adminRechazaSugerenciasYSeCarganAlPartido(){
		
		Sugerencia nuevaSugerencia = new Sugerencia(belenFranccese, semisDeCopa, new Estandar());
		
		marceloTinelli.sugerir(nuevaSugerencia);
		
		marceloTinelli.rechazarSugerencia(nuevaSugerencia, "Me estan haciendo Rowling");
		
		Assert.assertEquals(1, semisDeCopa.getRechazados().size());
		
		
	}
	
	@Test
	public void elContenidoDelRechazoEsCorrecto(){
		
		Estandar tipoDeInsc = new Estandar();
		String motivo = new String("Me estan haciendo Rowling");
		Sugerencia nuevaSugerencia = new Sugerencia(belenFranccese, semisDeCopa, tipoDeInsc);
		
		marceloTinelli.sugerir(nuevaSugerencia);
		
		marceloTinelli.rechazarSugerencia(nuevaSugerencia, motivo);
		
		Rechazo noMeQuieren = semisDeCopa.getRechazados().get(0);
		
		Assert.assertEquals(belenFranccese, noMeQuieren.getJugador());
		Assert.assertEquals(tipoDeInsc, noMeQuieren.getInscripcion());
		Assert.assertEquals(motivo, noMeQuieren.getMotivo());
		
	}

}
