package ar.edu.futbol5.estadoPartido;

import java.util.List;

import ar.edu.futbol5.Jugador;

public interface EstadoDelPartido {
	
	public boolean validarInscripcion(List<Jugador> inscriptos);
	
}
