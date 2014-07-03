package ar.edu.futbol5.distribucionEquipo;

import java.util.List;

import ar.edu.futbol5.Equipo;
import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.utilitarios.Lists;

public class Distribucion16 implements DistribucionEquipo {

	@Override
	public void distribuirJugadores(List<Jugador> jugadores, Equipo equipo1,
			Equipo equipo2)
	{
		equipo1.setJugadores(Lists.newArrayList(jugadores.get(0),jugadores.get(3),jugadores.get(4),jugadores.get(7),jugadores.get(8)));
		
		equipo2.setJugadores(Lists.newArrayList(jugadores.get(1),jugadores.get(2),jugadores.get(5),jugadores.get(6),jugadores.get(9)));
		
	}

}
