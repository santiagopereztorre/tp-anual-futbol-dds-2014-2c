package utn.dds.divisores;

import java.util.Hashtable;
import java.util.List;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.Jugador;

public interface Divisor {

	void armarEquipos(List<Jugador> equipo1, List<Jugador> equipo2,
			Hashtable<Jugador, Integer> inscriptosCalificados);

	
}
