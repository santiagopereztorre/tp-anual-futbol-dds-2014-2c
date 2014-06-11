package utn.dds.criterios;

import java.util.List;
import java.util.stream.IntStream;

import utn.dds.jugador.Jugador;

public class Mix implements Criterio{

	private List<Criterio> criterios;
	
	public Mix (List<Criterio> criterios){
		this.criterios = criterios;
	}
	
	@Override
	public Integer calificar(Jugador unJugador) {
		Integer sumPuntajesCriterios = this.criterios.stream().mapToInt(x -> x.calificar(unJugador)).sum();
			
		return sumPuntajesCriterios / unJugador.cantidadCalificaciones();
	}

}
