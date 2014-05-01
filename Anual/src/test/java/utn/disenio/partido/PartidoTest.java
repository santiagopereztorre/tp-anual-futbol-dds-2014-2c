package utn.disenio.partido;

import static org.junit.Assert.*;

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
	public void inscribirEstandar() {
		Jugador juan = new Jugador();
		Jugador carlitos = new Jugador();
		
		juan.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Estandar());
		carlitos.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Estandar());
		
		List<Inscripcion> listaInscriptosEstandar = solterosVsCasados.getInscriptosDeTipo(Estandar.class);
		Assert.assertEquals(listaInscriptosEstandar.size(), 2);
	}
	
	@Test
	public void inscribirSolidarios(){
		Jugador lalo = new Jugador();
		
		lalo.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Solidaria());
		
		List<Inscripcion> listaInscriptosEstandar = solterosVsCasados.getInscriptosDeTipo(Solidaria.class);
		Assert.assertEquals(listaInscriptosEstandar.size(), 1);
	}
	
	@Test
	public void inscribirCondicionales(){
		Jugador pepe = new Jugador();
		Jugador moncho = new Jugador();
		
		pepe.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Condicional());
		moncho.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Condicional());
		
		List<Inscripcion> listaInscriptosEstandar = solterosVsCasados.getInscriptosDeTipo(Condicional.class);
		Assert.assertEquals(listaInscriptosEstandar.size(), 2);
	}
	
	@Test (expected = NoHayVacantesException.class)
	public void inscribirMasDeDiezEstandar(){
		
		for (int i = 0; i < 11; i++){
			solterosVsCasados.inscribirJugador(new Jugador(), new Estandar());
		}
		
		Assert.assertEquals(solterosVsCasados.cantidadDeInscriptos(), 10);
		
	}
	

}
