package utn.dds.admin;

import utn.dds.jugador.Jugador;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class Rechazo 
{
	private Jugador jugador;
	private TipoInscripcion inscripcion;
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
