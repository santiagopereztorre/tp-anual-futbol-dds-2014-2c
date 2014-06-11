package utn.dds.equipos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.criterios.Handicap;
import utn.dds.divisores.ParImpar;
import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.Solidaria;

public class GenerarEquipos {

	Partido dopartiConLosPibes;
	
	Jugador juan = new Jugador();
	Jugador lalo = new Jugador();
	Jugador juancho = new Jugador();
	Jugador carlos = new Jugador();
	Jugador pepito = new Jugador();
	Jugador martin = new Jugador();
	Jugador lucas = new Jugador();
	Jugador pato = new Jugador();
	Jugador marcelo = new Jugador();
	Jugador leandro = new Jugador();
	
	@Before
	public void setUp()
	{
		dopartiConLosPibes = new Partido();
		dopartiConLosPibes.inscribirJugador(lalo, new Solidaria());
		dopartiConLosPibes.inscribirJugador(juan, new Estandar());
		dopartiConLosPibes.inscribirJugador(lucas, new Solidaria());
		dopartiConLosPibes.inscribirJugador(pepito, new Condicional());
		dopartiConLosPibes.inscribirJugador(martin, new Condicional());
		dopartiConLosPibes.inscribirJugador(juancho, new Estandar());
		dopartiConLosPibes.inscribirJugador(carlos, new Estandar());
		dopartiConLosPibes.inscribirJugador(marcelo, new Condicional());
		dopartiConLosPibes.inscribirJugador(leandro, new Estandar());
		dopartiConLosPibes.inscribirJugador(pato, new Estandar());		
	}
	
	@Test
	public void ordenarPorHandicap() {
		juan.setHandicap(10);
		pepito.setHandicap(1);
		marcelo.setHandicap(4);
		leandro.setHandicap(5);
		martin.setHandicap(9);
		juancho.setHandicap(3);
		carlos.setHandicap(10);
		pato.setHandicap(8);
		lalo.setHandicap(10);
		lucas.setHandicap(5);
		
		Handicap handicap = new Handicap();
		ParImpar parImpar = new ParImpar();
		
		List<Jugador> primerEquipo = new ArrayList<Jugador>();
		
		//primerEquipo.add()
		
		dopartiConLosPibes.armarEquipos(handicap, parImpar);
		//Assert.assertEquals(dopartiConLosPibes.getEquipo1(), );
	}

}
