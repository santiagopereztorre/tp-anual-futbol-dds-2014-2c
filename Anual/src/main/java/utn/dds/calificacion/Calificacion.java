package utn.dds.calificacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.persistentEntity.PersistentEntity;

@Entity
@Table(name="Calificaciones")
public class Calificacion extends PersistentEntity{
	
	@ManyToOne
	@JoinColumn(name="id_calificador")
	private Jugador calificador;
	
	@ManyToOne
	@JoinColumn(name="id_calificado")
	private Jugador calificado;
	
	@ManyToOne
	@JoinColumn(name="id_partido")
	private Partido partido;
	
	@Column(name="critica_calificacion")
	private String critica;
	
	@Column(name="puntaje_calificacion")
	private Integer puntaje;
	
	public Calificacion(){
		
	}
	
	public Calificacion(Jugador calificador, Jugador calificado, Partido unPartido, Integer puntaje, String unTexto){
		this.setCalificador(calificador);
		this.setCalificado(calificado);
		this.setPartido(unPartido);
		this.setCritica(unTexto);
		this.setPuntaje(puntaje);
	}
	
	public Jugador getCalificado() {
		return calificado;
	}

	public void setCalificado(Jugador calificado) {
		this.calificado = calificado;
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