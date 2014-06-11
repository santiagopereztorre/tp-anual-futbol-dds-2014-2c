package utn.dds.criterios;

import utn.dds.jugador.Jugador;

public class PromedioUltimasNCalificaciones implements Criterio {

	private int cantCalificaciones;
	
	public PromedioUltimasNCalificaciones(int cantCalificaciones){
		this.cantCalificaciones = cantCalificaciones;
	}
	
	@Override
	public Integer calificar(Jugador unJugador) {
		Integer sumPuntajes = unJugador.getCalificaciones().stream()
				.limit(this.cantCalificaciones)
                .mapToInt(c -> c.getPuntaje())
                .sum();
			
		return sumPuntajes / unJugador.cantidadCalificaciones();
	}

}
