package utn.dds.divisores;

import java.util.Collections;
import java.util.List;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorConCalificacion;

public class ParImpar implements Divisor {

	@Override
	public void armarEquipos(List<Jugador> equipo1, List<Jugador> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados) {
		Collections.sort(jugadoresCalificados);
		
		equipo1.clear();
		equipo2.clear();
		
		for (int i = 0; i < jugadoresCalificados.size(); i ++)
		{
			if (esPar(i))
			{
				equipo1.add(jugadoresCalificados.get(i).getJugador());
			}
			else
			{
				equipo2.add(jugadoresCalificados.get(i).getJugador());
			}
		}
	}
	
	private boolean esPar(int numero) {
		if (numero%2==0) return true; else return false;
	}
	
	public String toString(){
		return "Par/impar";
	}
}
