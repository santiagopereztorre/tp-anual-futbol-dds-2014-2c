package utn.dds.admin;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.persistentEntity.PersistentEntity;
import utn.dds.tipoInscripcion.TipoInscripcion;

@Entity
@Table(name="Sugerencias")
public class Sugerencia extends PersistentEntity{

	@ManyToOne
	@JoinColumn(name="id_jugador")
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name="id_partido")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_inscripcion")
	private TipoInscripcion inscripcion;
	
	public Sugerencia(){
		
	}
	
	public Sugerencia(Jugador jugador, Partido partido,
			TipoInscripcion inscripcion){
		super();
		this.jugador = jugador;
		this.partido = partido;
		this.inscripcion = inscripcion;
	}

	public Jugador getJugador()
	{
		return jugador;
	}

	public Partido getPartido()
	{
		return partido;
	}

	public TipoInscripcion getInscripcion()
	{
		return inscripcion;
	}
	
	public void aceptar()
	{
		partido.inscribirJugador(jugador, inscripcion);
	}
	
	public void rechazar(String motivo)
	{
		partido.agregarRechazoSugerencia(new Rechazo(jugador, inscripcion, motivo));
	}
}
