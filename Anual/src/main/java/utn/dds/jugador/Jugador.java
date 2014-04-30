package utn.dds.jugador;

import utn.dds.partido.*;
import utn.dds.tipoInscripcion.*;


public class Jugador {
	
	public void inscribirseAPartidoConTipoInscripcion(Partido partido, TipoInscripcion tipoInscripcion){
		partido.inscribirJugador(this, tipoInscripcion);
	}
	
	
}
