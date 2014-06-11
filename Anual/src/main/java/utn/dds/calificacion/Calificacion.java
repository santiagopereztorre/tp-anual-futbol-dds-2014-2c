package utn.dds.calificacion;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

public class Calificacion {
	private Jugador calificador;
	private Partido partido;
	private String critica;
	private Integer puntaje;
	
	public Calificacion(Jugador otroJugador, Partido unPartido, Integer puntaje, String unTexto){
		this.setCalificador(otroJugador);
		this.setPartido(unPartido);
		this.setCritica(unTexto);
		this.setPuntaje(puntaje);
	}
	
	public void setPuntaje(int unPuntaje) {
		this.puntaje = unPuntaje;
	}
	
	public Integer getPuntaje() {
		return this.puntaje;
	}
	
	public void setCalificador(Jugador otroJugador) {
		calificador = otroJugador;
	}
	
	public void setPartido(Partido unPartido) {
		partido = unPartido;
	}
	
	public void setCritica(String unTexto) {
		critica = unTexto;
	}
	
	public Jugador getCalificador() {
		return this.calificador;
	}
	
	public Partido getPartido() {
		return this.partido;
	}
	
	public String getCritica() {
		return this.critica;
	}
	
}