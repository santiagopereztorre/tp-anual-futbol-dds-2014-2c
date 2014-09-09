package utn.dds.criterios;

import utn.dds.jugador.Jugador;

public class PromedioUltimasNCalificaciones implements Criterio {

	public static final int TODAS = -1;
	private int cantCalificaciones;
	
	public PromedioUltimasNCalificaciones(int cantCalificaciones){
		this.cantCalificaciones = cantCalificaciones;
	}
	
	@Override
	public Integer calificar(Jugador unJugador) {
		// En caso de que se quieran todas las calificaciones
		if(cantCalificaciones == TODAS)
			cantCalificaciones = unJugador.getCalificaciones().size();
		
		Integer sumPuntajes = unJugador.getCalificaciones().stream()
				.limit(this.cantCalificaciones)
                .mapToInt(c -> c.getPuntaje())
                .sum();
			
		return sumPuntajes / unJugador.cantidadCalificaciones();
	}

}
