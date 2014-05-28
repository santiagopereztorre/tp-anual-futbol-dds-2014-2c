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
		jugador = unJugador;
		this.inscripcion = inscripcion;
		this.motivo = motivo;
	}
}
