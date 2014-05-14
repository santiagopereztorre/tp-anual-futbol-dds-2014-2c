package utn.dds.partido;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import utn.dds.observers.ObsPartidoCompleto;
import utn.dds.observers.ObsPartidoDescompleto;
import utn.dds.observers.ObsPartidoInscripcion;
import utn.dds.partido.exceptions.NoHayVacantesException;
import utn.dds.tipoInscripcion.*;
import utn.dds.infraccion.Infraccion;
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

	public void darDeBaja(Jugador jugador) 
	{
		try{
			Inscripcion inscripcion = this.getInscripcionDe(jugador);	
			inscripciones.remove(inscripcion);
			this.infraccionarPorDarseDeBajaSinReemplazo(jugador);
		}catch (NoSuchElementException e){
			
		}
	}

	public void infraccionarPorDarseDeBajaSinReemplazo(Jugador jugador)
	{
		jugador.recibirInfraccion(new Infraccion("Darse de baja sin reemplazo"));
	}
	
	public boolean jugadorInscripto(Jugador jugador) 
	{
		try
		{
			this.getInscripcionDe(jugador);
		}
		catch (NoSuchElementException e)
		{// Jugador no existe
			return false;
		}
		
		return true;
	}
	
	private Inscripcion getInscripcionDe(Jugador unJugador) throws NoSuchElementException
	{
		return inscripciones
			.stream()
			.filter(insc -> insc.getJugador().equals(unJugador))
			.findFirst()
			.get();		
	}

	public void darDeBajaConReemplazo(Jugador jugadorQueSale, Jugador jugadorQueEntra) 
	{
		try{
			Inscripcion inscripcion = this.getInscripcionDe(jugadorQueSale);
			inscripciones.remove(inscripcion);
			this.inscribirJugador(jugadorQueEntra, inscripcion.getTipoInscripcion());
		}catch (NoSuchElementException e){
			
		}
			
	}

	public void setObsPartidoDescompleto(List<ObsPartidoDescompleto> obsPartidoDescompleto) {
		// TODO Auto-generated method stub
		
	}

	public void setObsPartidoCompleto(List<ObsPartidoCompleto> obsPartidoCompleto) {
		// TODO Auto-generated method stub
		
	}

	public void setObsPartidoInscripcion(List<ObsPartidoInscripcion> obsPartidoInscripcion) {
		// TODO Auto-generated method stub
		
	}
}
