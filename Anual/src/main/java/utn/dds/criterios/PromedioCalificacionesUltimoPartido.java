package utn.dds.criterios;

import utn.dds.jugador.Jugador;

public class PromedioCalificacionesUltimoPartido implements Criterio{

	@Override
	public Integer calificar(Jugador unJugador) {
			    
		Integer sumPuntajes = unJugador.getCalificaciones().stream()
                 .mapToInt(c -> c.getPuntaje())
                 .sum();
			
		return sumPuntajes / unJugador.cantidadCalificaciones();
	}
	
}
