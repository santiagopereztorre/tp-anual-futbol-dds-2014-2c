package utn.dds.divisores;

import java.util.List;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorConCalificacion;

public class ParImpar implements Divisor {

	@Override
	public void armarEquipos(List<Jugador> equipo1,
			List<Jugador> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados) 
	{
		List<JugadorConCalificacion> jugadoresCalificadosOrdenados = (List<JugadorConCalificacion>) jugadoresCalificados.stream().sorted();
		for (int i = 0; i < jugadoresCalificadosOrdenados.size(); i ++)
		{
			if (esPar(i))
			{
				equipo1.add(jugadoresCalificadosOrdenados.get(i).getJugador());
			}
			else
			{
				equipo2.add(jugadoresCalificadosOrdenados.get(i).getJugador());
			}
		}

	}

	private boolean esPar(int numero) {
		if (numero%2==0) return true; else return false;
	}

}
