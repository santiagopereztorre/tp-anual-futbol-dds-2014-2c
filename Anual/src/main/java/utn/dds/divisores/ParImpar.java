package utn.dds.divisores;

import java.util.List;

import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.JugadorConCalificacion;

public class ParImpar implements Divisor {

	@Override
	public void armarEquipos(List<Inscripcion> equipo1,
			List<Inscripcion> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados) 
	{
		List<JugadorConCalificacion> jugadoresCalificadosOrdenados = (List<JugadorConCalificacion>) jugadoresCalificados.stream().sorted();
		for (int i = 0; i < jugadoresCalificadosOrdenados.size(); i ++)
		{
			if (esPar(i))
			{
				equipo1.add(jugadoresCalificadosOrdenados.get(i).getInscripcion());
			}
			else
			{
				equipo2.add(jugadoresCalificadosOrdenados.get(i).getInscripcion());
			}
		}

	}

	private boolean esPar(int numero) {
		if (numero%2==0) return true; else return false;
	}

}
