package ar.edu.futbol5.estadoPartido;

import java.util.List;

import ar.edu.futbol5.Jugador;

public class PartidoGenerado implements EstadoDelPartido {

	@Override
	public boolean validarInscripcion(List<Jugador> inscriptos) {
		return true;
	}

}
