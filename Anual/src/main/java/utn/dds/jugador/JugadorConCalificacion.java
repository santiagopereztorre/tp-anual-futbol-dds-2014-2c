package utn.dds.jugador;

import java.util.Comparator;

import utn.dds.inscripcion.Inscripcion;

public class JugadorConCalificacion implements Comparator {
	
	private Inscripcion inscripcion;
	private Integer calificacion;
	
	public Inscripcion getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(Inscripcion jugador) {
		this.inscripcion = jugador;
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
