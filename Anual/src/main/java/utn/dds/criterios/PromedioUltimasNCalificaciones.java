package utn.dds.criterios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utn.dds.jugador.Jugador;

@Entity
@DiscriminatorValue("UltNCalif")
public class PromedioUltimasNCalificaciones extends Criterio {

	public static final int TODAS = -1;
	
	private int cantCalificaciones;
	
	public PromedioUltimasNCalificaciones(){
	}
	
	public PromedioUltimasNCalificaciones(int cantCalificaciones){
		this.cantCalificaciones = cantCalificaciones;
	}
	
	public int getCantCalificaciones() {
		return cantCalificaciones;
	}

	public void setCantCalificaciones(int cantCalificaciones) {
		this.cantCalificaciones = cantCalificaciones;
	}
	
	@Override
	public Integer calificar(Jugador unJugador) {
		// Si no se tienen calificaciones
		if(unJugador.getCalificaciones().size() == 0)
			return 0;
		
		// En caso de que se quieran todas las calificaciones
		if(cantCalificaciones == TODAS)
			cantCalificaciones = unJugador.getCalificaciones().size();
		
		Integer sumPuntajes = unJugador.getCalificaciones().stream()
				.limit(this.cantCalificaciones)
                .mapToInt(c -> c.getPuntaje())
                .sum();
			
		return sumPuntajes / unJugador.cantidadCalificaciones();
	}
	
	public String toString(){
		return "Por promedio de notas de los últimos n partidos";
	}

}
