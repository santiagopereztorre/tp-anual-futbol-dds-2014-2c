package utn.dds.partido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utn.dds.partido.exceptions.NoHayVacantesException;
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
		else
			throw new NoHayVacantesException("Ya no hay mas lugar para inscribir jugadores");
	}
	
	private boolean hayVacante()
	{
		return getInscriptosDeTipo(Estandar.class).size() < 10;
	}
	
	
	public List<Inscripcion> getInscriptosDeTipo(Class clase) {
		return inscripciones.stream().filter( x -> x.esInstanciaDe(clase)).collect(Collectors.toList());
	}
	
	public long cantidadDeInscriptos(){
		return inscripciones.stream().count();
	}

	public void darseBaja(Jugador jugador) {
		int i;
		
		for(i=0; i<inscripciones.size(); ++i){
			
			if(jugador.equals(inscripciones.get(i).getJugador())){
				inscripciones.remove(i);
			}
			
		} 
		
	}

	public boolean jugadorInscripto(Jugador jugador) {
		int i;
		
		for(i=0; i<inscripciones.size(); ++i){
			
			if(jugador.equals(inscripciones.get(i).getJugador())){
				return true;
			}
			
		}
		return false;
	}

	public void darseBajaConReemplazo(Jugador jugadorQueSale, Jugador jugadorQueEntra) {
		int i;
		TipoInscripcion tipo;
		for(i=0; i<inscripciones.size(); ++i){
			
			if(jugadorQueSale.equals(inscripciones.get(i).getJugador())){		
				tipo = inscripciones.get(i).getTipoInscripcion();
				inscripciones.remove(i);
				this.inscribirJugador(jugadorQueEntra, tipo);
			}
		} 
		
		
		
	}
}
