package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;

import java.util.List;

public interface CriterioOrdenamiento {
	
	public List<Jugador> ordenar(Partido partido);

	public Double calcularValor(Jugador jugador);
		 
}
