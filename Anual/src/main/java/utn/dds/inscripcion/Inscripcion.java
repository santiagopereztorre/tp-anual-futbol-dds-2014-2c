package utn.dds.inscripcion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import utn.dds.jugador.*;
import utn.dds.tipoInscripcion.*;
import utn.dds.partido.*;
import utn.dds.persistentEntity.PersistentEntity;

@Entity
@Table(name="Inscripciones")
public class Inscripcion extends PersistentEntity{
	
	@ManyToOne
	@JoinColumn(name="id_jugador")
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name="id_tipos_inscripcion")
	private TipoInscripcion tipoInscripcion;
	
	@ManyToOne
	@JoinColumn(name="id_partido")
	private Partido partido;

	public Inscripcion(){
		
	}
	
	public Inscripcion(Jugador nuevoJugador, Partido unPartido, TipoInscripcion nuevoTipoInscripcion){
		setJugador(nuevoJugador);
		setTipoInscripcion(nuevoTipoInscripcion);
		setPartido(unPartido);
	}

	/* Setters y getters */
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido unpartido) {
		this.partido = unpartido;
	}
	
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
	public boolean esInstanciaDe(Class<?> clase){
		return this.getTipoInscripcion().getClass().isAssignableFrom(clase);
	}
	
	/* Se fija si el partido cumple las condiciones */
	public boolean cumpleCondicion(Partido partido){
		
		return tipoInscripcion.cumpleCondicion(partido);
		
	}

}
