package utn.dds.admin;

import java.util.ArrayList;
import java.util.List;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.TipoInscripcion;

public class Admin 
{
	private List<Sugerencia> sugerencias;
	
	private Admin instancia = null;
	
	public Admin()

	{
		sugerencias = new ArrayList<Sugerencia>();
	}
	
	public Admin getInstancia()
	{
		if(instancia == null)
			instancia = new Admin();
		
		return instancia;
	}
	
	
	public void sugerir(Jugador unJugador, Partido unPartido, TipoInscripcion inscripcion)
	{
		sugerencias.add(new Sugerencia(unJugador, unPartido, inscripcion));
	}
	
	public void aceptarSugerencia(Sugerencia unaSugerencia)
	{
		unaSugerencia.aceptar();
		sugerencias.remove(unaSugerencia);
	}
	
	public void rechazarSugerencia(Sugerencia unaSugerencia, String motivo)
	{
		unaSugerencia.rechazar(motivo);
		sugerencias.remove(unaSugerencia);
	}
}
