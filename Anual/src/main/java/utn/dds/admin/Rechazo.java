package utn.dds.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

import utn.dds.jugador.Jugador;
import utn.dds.persistentEntity.PersistentEntity;
import utn.dds.tipoInscripcion.TipoInscripcion;

@Entity
@Table(name="Rechazos")
public class Rechazo extends PersistentEntity{
	
	@ManyToOne
	@JoinColumn(name="id_jugador")
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name="id_partido")
	private TipoInscripcion inscripcion;
	
	@Column(name="motivo_rechazo")
	private String motivo;
	
	Rechazo(Jugador unJugador, TipoInscripcion inscripcion, String motivo)
	{
		setJugador(unJugador);
		this.setInscripcion(inscripcion);
		this.setMotivo(motivo);
	}
	
	/* Setters y Getters */
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public TipoInscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(TipoInscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
