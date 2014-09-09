package utn.dds.jugador;

public class JugadorConCalificacion implements Comparable<JugadorConCalificacion> {
	
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
	public int compareTo(JugadorConCalificacion o) {
		if (this.getCalificacion() > o.getCalificacion())
		{
			return 1;
		} 
		else if (this.getCalificacion() == o.getCalificacion()) 
		{
			return 0;
		} 
		else
		{
			return -1;
		}
	}
	

}
