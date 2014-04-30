package utn.disenio.partido;

import static org.junit.Assert.*;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.Solidaria;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class PartidoTest {

	
	Partido solterosVsCasados;
	
	@Before
	public void setUp() throws Exception 
	{
		solterosVsCasados = new Partido();
	}
	
	@Test
	public void inscriptosSegunSuTipoDeInscripcion() {
		
		Jugador juan = new Jugador();
		Jugador pepe = new Jugador();
		Jugador moncho = new Jugador();
		Jugador carlitos = new Jugador();
		Jugador lalo = new Jugador();
				
		juan.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Estandar());
		pepe.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Condicional());
		moncho.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Condicional());
		carlitos.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Estandar());
		lalo.inscribirseAPartidoConTipoInscripcion(solterosVsCasados, new Solidaria());
		
		List<Inscripcion> listaInscriptosEstandar = solterosVsCasados.getInscriptosDeTipo(Estandar.class);
				
		Assert.assertEquals(listaInscriptosEstandar.size(), 2);
		
	}

}
