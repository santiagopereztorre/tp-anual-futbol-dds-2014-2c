package utn.dds.divisores;

import java.util.List;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.JugadorConCalificacion;

public interface Divisor {


	void armarEquipos(List<Inscripcion> equipo1, List<Inscripcion> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados);
	
}
