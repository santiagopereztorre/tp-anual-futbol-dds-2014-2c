package utn.dds.divisores;

import java.util.List;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorConCalificacion;

public interface Divisor {


	void armarEquipos(List<Jugador> equipo1, List<Jugador> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados);
	
}
