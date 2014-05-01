package utn.dds.inscripcion;

import utn.dds.jugador.*;
import utn.dds.tipoInscripcion.*;
import utn.dds.partido.*;

public class Inscripcion {
	
	private Jugador jugador;
	private TipoInscripcion tipoInscripcion;
	
	public Inscripcion(Jugador nuevoJugador, TipoInscripcion nuevoTipoInscripcion){
		setJugador(nuevoJugador);
		setTipoInscripcion(nuevoTipoInscripcion);
	}

	/* Setters y getters */
	public TipoInscripcion getTipoInscripcion() {
		return tipoInscripcion;
	}

	public void setTipoInscripcion(TipoInscripcion tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	/* Chequeo de instancia de clase */
	public boolean esInstanciaDe(Class clase){
		return this.getTipoInscripcion().getClass().isAssignableFrom(clase);
	}
	
	/* Se fija si el partido cumple las condiciones */
	public boolean cumpleCondicion(Partido partido){
		
		return tipoInscripcion.cumpleCondicion(partido);
		
	}

}
