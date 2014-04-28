package utn.dds.jugador;

import utn.dds.partido.*;
import utn.dds.tipoInscripcion.*;


public class Jugador {
	
	public void InscribirJugador(Partido partido, TipoInscripcion tipoInscripcion){
		partido.InscribirJugador(this, tipoInscripcion);
	}
	
}
