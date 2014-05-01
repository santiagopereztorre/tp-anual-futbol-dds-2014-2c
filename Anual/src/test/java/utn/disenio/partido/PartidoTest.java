package utn.disenio.partido;


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


public class PartidoTest {

	
	Partido solterosVsCasados;
	
	@Before
	public void setUp() throws Exception 
	{
		solterosVsCasados = new Partido();
	}
		
	@Test
	public void inscribirJugadores() {
		Jugador juan = new Jugador();
		Jugador carlitos = new Jugador();
		Jugador pepe = new Jugador();
		Jugador moncho = new Jugador();
		Jugador lalo = new Jugador();
		
		lalo.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Solidaria());
		pepe.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Condicional());
		moncho.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Condicional());
		juan.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Estandar());
		carlitos.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Estandar());
		
		List<Inscripcion> listaInscriptosEstandar = solterosVsCasados.getInscriptosDeTipo(Estandar.class);
		List<Inscripcion> listaInscriptosSolidarios = solterosVsCasados.getInscriptosDeTipo(Solidaria.class);
		List<Inscripcion> listaInscriptosCondicionales = solterosVsCasados.getInscriptosDeTipo(Condicional.class);
		
		Assert.assertEquals(listaInscriptosEstandar.size(), 2);
		Assert.assertEquals(listaInscriptosSolidarios.size(), 1);
		Assert.assertEquals(listaInscriptosCondicionales.size(), 2);
	}
	
		
	@Test (expected = NoHayVacantesException.class)
	public void inscribirMasDeDiezEstandar(){
		
		for (int i = 0; i < 11; i++){
			solterosVsCasados.inscribirJugador(new Jugador(), new Estandar());
		}
		
		Assert.assertEquals(solterosVsCasados.cantidadDeInscriptos(), 10);
		
	}
	
	@Test
	public void incribirCondicionalEspecial(){
		/* Solo se anota si no hay mas de 6 jugadores previamente inscriptos */
		solterosVsCasados.inscribirJugador(new Jugador(), new Condicional(( x -> x.cantidadDeInscriptos() < 6)));
		
		List<Inscripcion> condicionales = solterosVsCasados.getInscriptosDeTipo(Condicional.class);
		
		Assert.assertTrue(condicionales.stream().allMatch(( x -> x.cumpleCondicion(solterosVsCasados))));
	}

}
