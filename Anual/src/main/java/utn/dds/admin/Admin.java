package utn.dds.admin;

import java.util.ArrayList;
import java.util.List;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class Admin 
{
	private List<Sugerencia> sugerencias;
	
	Admin()
	{
		sugerencias = new ArrayList<Sugerencia>();
	}
	
	public void sugerir(Jugador unJugador, Partido unPartido, TipoInscripcion inscripcion)
	{
		sugerencias.add(new Sugerencia(unJugador, unPartido, inscripcion));
	}
}
