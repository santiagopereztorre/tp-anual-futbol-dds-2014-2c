package ar.edu.futbol5.distribucionEquipo;

import java.util.List;
import ar.edu.futbol5.Equipo;

import ar.edu.futbol5.Jugador;

public interface DistribucionEquipo {
	public void distribuirJugadores(List<Jugador> jugadores, Equipo equipo1, Equipo equipo2);
}
