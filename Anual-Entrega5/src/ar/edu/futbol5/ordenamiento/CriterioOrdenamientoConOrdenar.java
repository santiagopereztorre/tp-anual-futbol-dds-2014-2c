package ar.edu.futbol5.ordenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;

public abstract class CriterioOrdenamientoConOrdenar implements
		CriterioOrdenamiento {

	@Override
	public List<Jugador> ordenar(Partido partido) {
		Collections.sort(partido.getInscriptos(), 
				(jugador1, jugador2) -> calcularValor(jugador1).compareTo(calcularValor(jugador2)));

		Collections.reverse(partido.getInscriptos());
		
		List<Jugador> jugadores=new ArrayList<Jugador>();
		jugadores.addAll(partido.getInscriptos());
		return jugadores;
	}

	public abstract Double calcularValor(Jugador jugador);

}
