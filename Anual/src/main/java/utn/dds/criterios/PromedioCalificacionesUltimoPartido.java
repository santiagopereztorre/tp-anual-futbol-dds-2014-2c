package utn.dds.criterios;

import java.util.Comparator;
import java.util.Date;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

public class PromedioCalificacionesUltimoPartido implements Criterio{

	@Override
	public Integer calificar(Jugador unJugador) {
			    
		Comparator<Partido> comparator = (p, o) -> p.getFecha().compareTo(o.getFecha());
	 
		Date ultimoPartido = (unJugador.getCalificaciones().stream().map(x -> x.getPartido()).sorted(comparator).findFirst().get()).getFecha();
				
		Integer sumPuntajes = unJugador.getCalificaciones().stream()
				 .filter(x -> x.getPartido().getFecha() == ultimoPartido)
                 .mapToInt(c -> c.getPuntaje())
                 .sum();
			
		return sumPuntajes / unJugador.cantidadCalificaciones();
	}
	
}
