package utn.dds.equipos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.criterios.Handicap;
import utn.dds.divisores.ParImpar;
import utn.dds.divisores.UnoParaAcaDosParaAllaDosParaAca;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.excepciones.FaltaCargarHandicapJugadorException;
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
	public void ordenarPorHandicapParImpar() {
		juan.setHandicap(10);
		pepito.setHandicap(1);
		marcelo.setHandicap(4);
		leandro.setHandicap(5);
		martin.setHandicap(6);
		juancho.setHandicap(7);
		carlos.setHandicap(2);
		pato.setHandicap(8);
		lalo.setHandicap(3);
		lucas.setHandicap(9);
		
		Handicap handicap = new Handicap();
		ParImpar parImpar = new ParImpar();
		
		List<Jugador> primerEquipo = new ArrayList<Jugador>();
		List<Jugador> segundoEquipo = new ArrayList<Jugador>();
		
		primerEquipo.add(juan);
		primerEquipo.add(pato);
		primerEquipo.add(martin);
		primerEquipo.add(marcelo);
		primerEquipo.add(carlos);
		
		segundoEquipo.add(lucas);
		segundoEquipo.add(juancho);
		segundoEquipo.add(leandro);
		segundoEquipo.add(lalo);
		segundoEquipo.add(pepito);
	
		dopartiConLosPibes.armarEquipos(handicap, parImpar);
		
		Assert.assertEquals(dopartiConLosPibes.getEquipo1(), primerEquipo);
		Assert.assertEquals(dopartiConLosPibes.getEquipo2(), segundoEquipo);
	}
	
	@Test
	public void ordenarPorHandicapUnoParaAcaDosParaAllaDosParaAca() {
		juan.setHandicap(10);
		pepito.setHandicap(1);
		marcelo.setHandicap(4);
		leandro.setHandicap(5);
		martin.setHandicap(6);
		juancho.setHandicap(7);
		carlos.setHandicap(2);
		pato.setHandicap(8);
		lalo.setHandicap(3);
		lucas.setHandicap(9);
		
		Handicap handicap = new Handicap();
		UnoParaAcaDosParaAllaDosParaAca orden = new UnoParaAcaDosParaAllaDosParaAca();
		
		List<Jugador> primerEquipo = new ArrayList<Jugador>();
		List<Jugador> segundoEquipo = new ArrayList<Jugador>();
		
		primerEquipo.add(juan);
		primerEquipo.add(juancho);
		primerEquipo.add(martin);
		primerEquipo.add(lalo);
		primerEquipo.add(carlos);
		
		segundoEquipo.add(lucas);
		segundoEquipo.add(pato);
		segundoEquipo.add(leandro);
		segundoEquipo.add(marcelo);
		segundoEquipo.add(pepito);
	
		dopartiConLosPibes.armarEquipos(handicap, orden);
		
		Assert.assertEquals(dopartiConLosPibes.getEquipo1(), primerEquipo);
		Assert.assertEquals(dopartiConLosPibes.getEquipo2(), segundoEquipo);
	}
	
	@Test (expected = FaltaCargarHandicapJugadorException.class)
	public void ordenarPorHandicapSinSetearHandicap(){
		Handicap handicap = new Handicap();
		UnoParaAcaDosParaAllaDosParaAca orden = new UnoParaAcaDosParaAllaDosParaAca();
			
		List<Jugador> primerEquipo = new ArrayList<Jugador>();
		List<Jugador> segundoEquipo = new ArrayList<Jugador>();
		
		primerEquipo.add(juan);
		primerEquipo.add(juancho);
		primerEquipo.add(martin);
		primerEquipo.add(lalo);
		primerEquipo.add(carlos);
		
		segundoEquipo.add(lucas);
		segundoEquipo.add(pato);
		segundoEquipo.add(leandro);
		segundoEquipo.add(marcelo);
		segundoEquipo.add(pepito);
	
		dopartiConLosPibes.armarEquipos(handicap, orden);
		
		Assert.assertEquals(dopartiConLosPibes.getEquipo1(), primerEquipo);
		Assert.assertEquals(dopartiConLosPibes.getEquipo2(), segundoEquipo);
		
	}

}
