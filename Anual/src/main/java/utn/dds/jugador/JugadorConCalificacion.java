package utn.dds.jugador;

import java.util.Comparator;

import utn.dds.inscripcion.Inscripcion;

public class JugadorConCalificacion implements Comparator {
	
	private Jugador jugador;
	private Integer calificacion;
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Integer getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		JugadorConCalificacion jugador1 = (JugadorConCalificacion) o1;
		JugadorConCalificacion jugador2 = (JugadorConCalificacion) o2;
		if (jugador1.getCalificacion() > jugador2.getCalificacion())
		{
			return 1;
		} 
		else if (jugador1.getCalificacion() == jugador2.getCalificacion()) 
		{
			return 0;
		} 
		else
		{
			return -1;
		}
	}
	

}
