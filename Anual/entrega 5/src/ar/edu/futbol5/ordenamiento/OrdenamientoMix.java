package ar.edu.futbol5.ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;

public class OrdenamientoMix implements CriterioOrdenamiento {
	
	List<CriterioOrdenamiento> criterios;
	
	public OrdenamientoMix() {
		criterios = new ArrayList<CriterioOrdenamiento>();
	}
	
	public List<Jugador> ordenar(Partido partido) {
		Collections.sort(
				partido.getInscriptos(), 
				(jugador1, jugador2) -> calcularValor(jugador1).compareTo(calcularValor(jugador2)));

		Collections.reverse(partido.getInscriptos());
		
		List<Jugador> jugadores=new ArrayList<Jugador>();
		jugadores.addAll(partido.getInscriptos());
		return jugadores;
	}
	
	public void addCriterio(CriterioOrdenamiento criterio) {
		criterios.add(criterio);
	}
	
	public Double calcularValor(Jugador jugador) {
		return criterios.stream().mapToDouble(criterio -> criterio.calcularValor(jugador)).sum();
	}
	
}
