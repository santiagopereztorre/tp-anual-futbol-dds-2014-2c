package utn.dds.criterios;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.excepciones.FaltaCargarHandicapJugadorException;


public class Handicap implements Criterio {

	public Integer calificar(Jugador unJugador) {
		
		if (unJugador.getHandicap() > 0)
			return unJugador.getHandicap();
		else
			throw new FaltaCargarHandicapJugadorException("El administrador a�n no carg� ning�n handicap para este jugador.");
	}
	
	public String toString(){
		return "Por handicap";
	}
}
