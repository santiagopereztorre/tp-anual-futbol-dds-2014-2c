package utn.dds.partido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utn.dds.tipoInscripcion.*;
import utn.dds.inscripcion.*;
import utn.dds.jugador.*;


public class Partido {
	
	private List<Inscripcion> inscripciones;
	private List<Inscripcion> equipo1;
	private List<Inscripcion> equipo2;
	
	public Partido(){
		inscripciones = new ArrayList<Inscripcion>();
	}
	
	public void inscribirJugador(Jugador jugador, TipoInscripcion tipoInscripcion)
	{		
		if (hayVacante()) 
			inscripciones.add(new Inscripcion(jugador, tipoInscripcion));
	}
	
	private boolean hayVacante()
	{
		return inscripciones.stream().filter( x -> x.esInstanciaDe(Estandar.class)).count() < 10;
	}
		
	/* Obtencion de tipos de inscripciones */
	/*public List<Inscripcion> getInscriptosEstandar() {
		return inscripciones.stream().filter( x -> x.esEstandar()).collect(Collectors.toList());
	}
	
	public List<Inscripcion> getInscriptosCondicionales() {
		return inscripciones.stream().filter( x -> x.esCondicional()).collect(Collectors.toList());
	}
	
	public List<Inscripcion> getInscriptosSolidarios() {
		return inscripciones.stream().filter( x -> x.esSolidaria()).collect(Collectors.toList());
	}*/
	
	public List<Inscripcion> getInscriptosDeTipo(Class clase) {
		return inscripciones.stream().filter( x -> x.esInstanciaDe(clase)).collect(Collectors.toList());
	}
}
