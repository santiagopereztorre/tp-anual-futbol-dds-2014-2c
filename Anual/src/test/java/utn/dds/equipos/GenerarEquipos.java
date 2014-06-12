package utn.dds.equipos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.criterios.Handicap;
import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.criterios.PromedioUltimasNCalificaciones;
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
		dopartiConLosPibes = new Partido(new Date());
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
		
		dopartiConLosPibes.armarEquipos(new Handicap(), new ParImpar());
		
		List<Jugador> primerEquipo = dopartiConLosPibes.getEquipo1();
		List<Jugador> segundoEquipo = dopartiConLosPibes.getEquipo2();
		
		
		Assert.assertTrue(segundoEquipo.contains(juan));
		Assert.assertTrue(segundoEquipo.contains(pato));
		Assert.assertTrue(segundoEquipo.contains(martin));
		Assert.assertTrue(segundoEquipo.contains(marcelo));
		Assert.assertTrue(segundoEquipo.contains(carlos));
		
		Assert.assertTrue(primerEquipo.contains(lucas));
		Assert.assertTrue(primerEquipo.contains(juancho));
		Assert.assertTrue(primerEquipo.contains(leandro));
		Assert.assertTrue(primerEquipo.contains(lalo));
		Assert.assertTrue(primerEquipo.contains(pepito));
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
		
		dopartiConLosPibes.armarEquipos(new Handicap(), new UnoParaAcaDosParaAllaDosParaAca());
		
		List<Jugador> primerEquipo = dopartiConLosPibes.getEquipo1();
		List<Jugador> segundoEquipo = dopartiConLosPibes.getEquipo2();
		
		Assert.assertTrue(segundoEquipo.contains(juan));
		Assert.assertTrue(segundoEquipo.contains(juancho));
		Assert.assertTrue(segundoEquipo.contains(martin));
		Assert.assertTrue(segundoEquipo.contains(lalo));
		Assert.assertTrue(segundoEquipo.contains(carlos));
		
		Assert.assertTrue(primerEquipo.contains(lucas));
		Assert.assertTrue(primerEquipo.contains(pato));
		Assert.assertTrue(primerEquipo.contains(leandro));
		Assert.assertTrue(primerEquipo.contains(marcelo));
		Assert.assertTrue(primerEquipo.contains(pepito));
	}
	
	@Test (expected = FaltaCargarHandicapJugadorException.class)
	public void ordenarPorHandicapSinSetearHandicap(){			
		dopartiConLosPibes.armarEquipos(new Handicap(), new UnoParaAcaDosParaAllaDosParaAca());
	}

	@Test
	public void ordenarPorPromedioCalificacionesUltimoPartido(){
		Partido riverboca = new Partido(new Date());
		riverboca.inscribirJugador(carlos, new Estandar());
		riverboca.inscribirJugador(juancho, new Estandar());
		riverboca.inscribirJugador(juan, new Estandar());
		riverboca.inscribirJugador(lucas, new Estandar());
		riverboca.inscribirJugador(pato, new Estandar());
		riverboca.inscribirJugador(martin, new Estandar());
		riverboca.inscribirJugador(leandro, new Estandar());
		riverboca.inscribirJugador(marcelo, new Estandar());
		riverboca.inscribirJugador(lalo, new Estandar());
		riverboca.inscribirJugador(pepito, new Estandar());
		
		carlos.calificar(juancho, riverboca, 2, "Es horrible");
		carlos.calificar(juan, riverboca, 3, "Arquero manco");
		carlos.calificar(pato, riverboca, 1, "Es ma malo que el cigarro");
		carlos.calificar(lucas, riverboca, 6, "Jugo bien");
		carlos.calificar(martin, riverboca, 10, "La estrella");
		carlos.calificar(marcelo, riverboca, 9, "Sabella marcelito es argentino");
		carlos.calificar(lalo, riverboca, 5, "Regular");
		carlos.calificar(pepito, riverboca, 7, "Lateral con proyeccion");
		carlos.calificar(leandro, riverboca, 4, "Defensor rustico");
		martin.calificar(carlos, riverboca, 8, "Un volante con magia");
		
		dopartiConLosPibes.armarEquipos(new PromedioCalificacionesUltimoPartido(), new ParImpar());
		
		List<Jugador> equipoImpar = dopartiConLosPibes.getEquipo1();
		List<Jugador> equipoPar = dopartiConLosPibes.getEquipo2();
		
		Assert.assertTrue(equipoPar.contains(martin));
		Assert.assertTrue(equipoPar.contains(carlos));
		Assert.assertTrue(equipoPar.contains(lucas));
		Assert.assertTrue(equipoPar.contains(leandro));
		Assert.assertTrue(equipoPar.contains(juancho));
		
		Assert.assertTrue(equipoImpar.contains(marcelo));
		Assert.assertTrue(equipoImpar.contains(pepito));
		Assert.assertTrue(equipoImpar.contains(lalo));
		Assert.assertTrue(equipoImpar.contains(juan));
		Assert.assertTrue(equipoImpar.contains(pato));
		
	
		dopartiConLosPibes.armarEquipos(new PromedioCalificacionesUltimoPartido(), new UnoParaAcaDosParaAllaDosParaAca());
		
		List<Jugador> primerEquipo = dopartiConLosPibes.getEquipo1();
		List<Jugador> segundoEquipo = dopartiConLosPibes.getEquipo2();
		
		Assert.assertTrue(segundoEquipo.contains(martin));
		Assert.assertTrue(segundoEquipo.contains(pepito));
		Assert.assertTrue(segundoEquipo.contains(lucas));
		Assert.assertTrue(segundoEquipo.contains(juan));
		Assert.assertTrue(segundoEquipo.contains(juancho));
		
		Assert.assertTrue(primerEquipo.contains(marcelo));
		Assert.assertTrue(primerEquipo.contains(carlos));
		Assert.assertTrue(primerEquipo.contains(lalo));
		Assert.assertTrue(primerEquipo.contains(leandro));
		Assert.assertTrue(primerEquipo.contains(pato));
	}
	
	@Test
	public void ordenarPorUltimasNCalificaciones(){
		Partido riverboca = new Partido();
		
		riverboca.inscribirJugador(carlos, new Estandar());
		riverboca.inscribirJugador(juancho, new Estandar());
		riverboca.inscribirJugador(juan, new Estandar());
		riverboca.inscribirJugador(lucas, new Estandar());
		riverboca.inscribirJugador(pato, new Estandar());
		riverboca.inscribirJugador(martin, new Estandar());
		riverboca.inscribirJugador(leandro, new Estandar());
		riverboca.inscribirJugador(marcelo, new Estandar());
		riverboca.inscribirJugador(lalo, new Estandar());
		riverboca.inscribirJugador(pepito, new Estandar());
		
		leandro.calificar(juancho, riverboca, 2, "Es horrible");
		carlos.calificar(juan, riverboca, 3, "Arquero manco");
		carlos.calificar(pato, riverboca, 1, "Es ma malo que el cigarro");
		martin.calificar(lucas, riverboca, 6, "Jugo bien");
		carlos.calificar(martin, riverboca, 10, "La estrella");
		lalo.calificar(marcelo, riverboca, 9, "Sabella marcelito es argentino");
		pato.calificar(lalo, riverboca, 5, "Regular");
		carlos.calificar(pepito, riverboca, 7, "Lateral con proyeccion");
		carlos.calificar(leandro, riverboca, 4, "Defensor rustico");
		martin.calificar(carlos, riverboca, 8, "Un volante con magia");
		carlos.calificar(juancho, riverboca, 4, "Medio malo");
		pepito.calificar(juan, riverboca, 1, "Peor no puede jugar");
		pepito.calificar(pato, riverboca, 1, "Horrible");
		lalo.calificar(lucas, riverboca, 2, "Tuvo un mal dia");
		lalo.calificar(martin, riverboca, 10, "La rompio");
		
		Partido partiditoDeLosLunes = new Partido();
		
		partiditoDeLosLunes.inscribirJugador(carlos, new Estandar());
		partiditoDeLosLunes.inscribirJugador(juancho, new Estandar());
		partiditoDeLosLunes.inscribirJugador(juan, new Estandar());
		partiditoDeLosLunes.inscribirJugador(lucas, new Estandar());
		partiditoDeLosLunes.inscribirJugador(pato, new Estandar());
		partiditoDeLosLunes.inscribirJugador(martin, new Estandar());
		partiditoDeLosLunes.inscribirJugador(leandro, new Estandar());
		partiditoDeLosLunes.inscribirJugador(marcelo, new Estandar());
		partiditoDeLosLunes.inscribirJugador(lalo, new Estandar());
		partiditoDeLosLunes.inscribirJugador(pepito, new Estandar());
		
		carlos.calificar(marcelo, partiditoDeLosLunes, 9, "Bien de goleador pescador");
		carlos.calificar(lalo, partiditoDeLosLunes, 7, "Jugo muy bien de defensor");
		carlos.calificar(pepito, partiditoDeLosLunes, 3, "Ya esta para colgar los botines");
		carlos.calificar(leandro, partiditoDeLosLunes, 10, "Gran partido");
		martin.calificar(carlos, partiditoDeLosLunes, 8, "Un volante con magia");
		
		dopartiConLosPibes.armarEquipos(new PromedioUltimasNCalificaciones(2), new ParImpar());
		
		List<Jugador> equipoImpar = dopartiConLosPibes.getEquipo1();
		List<Jugador> equipoPar = dopartiConLosPibes.getEquipo2();
		
		Assert.assertTrue(equipoPar.contains(martin));
		Assert.assertTrue(equipoPar.contains(carlos));
		Assert.assertTrue(equipoPar.contains(lalo));
		Assert.assertTrue(equipoPar.contains(lucas));
		Assert.assertTrue(equipoPar.contains(juan));
		
		Assert.assertTrue(equipoImpar.contains(marcelo));
		Assert.assertTrue(equipoImpar.contains(leandro));
		Assert.assertTrue(equipoImpar.contains(pepito));
		Assert.assertTrue(equipoImpar.contains(juancho));
		Assert.assertTrue(equipoImpar.contains(pato));
		
	
		dopartiConLosPibes.armarEquipos(new PromedioUltimasNCalificaciones(2), new UnoParaAcaDosParaAllaDosParaAca());
		
		List<Jugador> primerEquipo = dopartiConLosPibes.getEquipo1();
		List<Jugador> segundoEquipo = dopartiConLosPibes.getEquipo2();
		
		Assert.assertTrue(segundoEquipo.contains(martin));
		Assert.assertTrue(segundoEquipo.contains(leandro));
		Assert.assertTrue(segundoEquipo.contains(lalo));
		Assert.assertTrue(segundoEquipo.contains(juancho));
		Assert.assertTrue(segundoEquipo.contains(juan));
		
		Assert.assertTrue(primerEquipo.contains(marcelo));
		Assert.assertTrue(primerEquipo.contains(carlos));
		Assert.assertTrue(primerEquipo.contains(pepito));
		Assert.assertTrue(primerEquipo.contains(lucas));
		Assert.assertTrue(primerEquipo.contains(pato));
	}
	
	
}
