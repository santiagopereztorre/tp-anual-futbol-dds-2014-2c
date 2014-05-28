package utn.dds.admin;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class Sugerencia 
{

	private Jugador jugador;
	private Partido partido;
	private TipoInscripcion inscripcion;
	
	public Sugerencia(Jugador jugador, Partido partido,
			TipoInscripcion inscripcion)
	{
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
}
