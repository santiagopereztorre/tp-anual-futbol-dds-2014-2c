package utn.dds.observers;

import java.util.List;

import utn.dds.jugador.Jugador;

public class ObsInscripcionJugador implements ObsPartidoInscripcion {

	@Override
	public Boolean notificar(List<Jugador> jugadores) {
		// ...
		return true;
	}

}
