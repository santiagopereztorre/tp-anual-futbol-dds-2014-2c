package utn.dds.jugador;

import java.util.ArrayList;
import java.util.List;

import utn.dds.infraccion.Infraccion;
import utn.dds.inscripcion.Inscripcion;
import utn.dds.partido.*;
import utn.dds.tipoInscripcion.*;


public class Jugador {
	
	private List<Infraccion> infracciones;
	
	public Jugador(){
		infracciones = new ArrayList<Infraccion>();
	}
	
	public void inscribirseAPartidoConTipoInscripcion(Partido partido, TipoInscripcion tipoInscripcion){
		partido.inscribirJugador(this, tipoInscripcion);
	}

	public void recibirInfraccion(Infraccion infraccion) {

		infracciones.add(infraccion);
	}
	
	public int cantidadInfracciones() {
		return infracciones.size();
	}
	
	
}
