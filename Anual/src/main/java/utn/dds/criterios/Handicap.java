package utn.dds.criterios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.excepciones.FaltaCargarHandicapJugadorException;


@Entity
@DiscriminatorValue("Handicap")
public class Handicap extends Criterio {

	@Override
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
