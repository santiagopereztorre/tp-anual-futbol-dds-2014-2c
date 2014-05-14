package utn.dds.jugador;

import java.util.List;

import utn.dds.infraccion.Infraccion;
import utn.dds.partido.*;
import utn.dds.tipoInscripcion.*;


public class Jugador {
	
	private List<Infraccion> infracciones;
	
	public void inscribirseAPartidoConTipoInscripcion(Partido partido, TipoInscripcion tipoInscripcion){
		partido.inscribirJugador(this, tipoInscripcion);
	}

	public int cantidadInfracciones() {
		return infracciones.size();
	}
	
	
}
