package utn.dds.divisores;

import java.util.Collections;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorConCalificacion;

@Entity
@DiscriminatorValue("Mezclado")
public class UnoParaAcaDosParaAllaDosParaAca extends Divisor {

	@Override
	public void armarEquipos(List<Jugador> equipo1, List<Jugador> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados) {
		Collections.sort(jugadoresCalificados);
		
		equipo1.clear();
		equipo2.clear();
		
		equipo1.add(jugadoresCalificados.get(0).getJugador());
		equipo2.add(jugadoresCalificados.get(1).getJugador());
		equipo2.add(jugadoresCalificados.get(2).getJugador());
		equipo1.add(jugadoresCalificados.get(3).getJugador());
		equipo1.add(jugadoresCalificados.get(4).getJugador());
		equipo2.add(jugadoresCalificados.get(5).getJugador());
		equipo2.add(jugadoresCalificados.get(6).getJugador());
		equipo1.add(jugadoresCalificados.get(7).getJugador());
		equipo1.add(jugadoresCalificados.get(8).getJugador());
		equipo2.add(jugadoresCalificados.get(9).getJugador());
	}

	public String toString(){
		return "1,4,5,8,9";
	}

}
