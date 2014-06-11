package utn.dds.partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import utn.dds.observers.ObsPartidoCompleto;
import utn.dds.observers.ObsPartidoDescompleto;
import utn.dds.observers.ObsPartidoInscripcion;
import utn.dds.partido.exceptions.NoHayVacantesException;
import utn.dds.tipoInscripcion.*;
import utn.dds.admin.Rechazo;
import utn.dds.criterios.Criterio;
import utn.dds.infraccion.Infraccion;
import utn.dds.inscripcion.*;
import utn.dds.jugador.*;


public class Partido {
	
	private List<Inscripcion> inscripciones;
	private List<Inscripcion> equipo1;
	private List<Inscripcion> equipo2;
	private Hashtable<Jugador, Integer> inscriptosCalificados;
	
	private List<ObsPartidoCompleto> observadoresCompleto;
	private List<ObsPartidoDescompleto> observadoresDescompleto;
	private List<ObsPartidoInscripcion> observadoresInscripcion;
	
	private List<Rechazo> rechazosSugerencias;
	private Date fecha;
	
	public Partido(Date fecha){
		this();
		this.fecha = fecha;
	}
	
	public Partido(){
		inscripciones = new ArrayList<Inscripcion>();
		observadoresDescompleto = new ArrayList<ObsPartidoDescompleto>();
		observadoresCompleto = new ArrayList<ObsPartidoCompleto>();
		observadoresInscripcion = new ArrayList<ObsPartidoInscripcion>();
		
		inscriptosCalificados = new Hashtable<Jugador, Integer>();
		rechazosSugerencias = new ArrayList<Rechazo>();
	}
	// Inscripcion de jugadores
	
	public void inscribirJugador(Jugador jugador, TipoInscripcion tipoInscripcion)
	{		
		if (!hayVacante())
			throw new NoHayVacantesException("Ya no hay mas lugar para inscribir jugadores");
		
		inscripciones.add(new Inscripcion(jugador, tipoInscripcion));
		
		
		if(inscripciones.size()==10){
			this.notificar10Confirmados();
		}
		
		this.notificarAmigos(jugador);
	}

	// Darse de baja
	
	public void darDeBaja(Jugador jugador) 
	{
		int inscriptosConfirmadosInicial = getInscripcionesJugadoresConfirmados().size();
		
		Inscripcion inscripcion = this.getInscripcionDe(jugador);	
		inscripciones.remove(inscripcion);
		this.infraccionarPorDarseDeBajaSinReemplazo(jugador);
		
		// Inscriptos confirmados inicialmente 10, y ahora 9 -> Avisar al admin
		if(getInscripcionesJugadoresConfirmados().size() == 9 && inscriptosConfirmadosInicial == 10)
			this.notificarYaNo10Confirmados();
	}
	
	/**
	 * Reemplaza a jugadorQueSale con jugadorQueEntra. Mantiene el tipo y posicion de la inscripcion
	 * @param jugadorQueSale
	 * @param jugadorQueEntra
	 */
	public void darDeBajaConReemplazo(Jugador jugadorQueSale, Jugador jugadorQueEntra) 
	{
		Inscripcion inscripcion = this.getInscripcionDe(jugadorQueSale);
		inscripcion.setJugador(jugadorQueEntra);
	}

	public void infraccionarPorDarseDeBajaSinReemplazo(Jugador jugador)
	{
		jugador.recibirInfraccion(new Infraccion("Darse de baja sin reemplazo"));
	}
	
	// Metodos adicionales
	
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

	private boolean hayVacante()
	{
		return getInscriptosDeTipo(Estandar.class).size() < 10;
	}
	
	/**
	 * Devuelve una lista con los jugadores confirmados para el partido hasta el momento
	 * @return
	 */
	private List<Inscripcion> getInscripcionesJugadoresConfirmados()
	{
		return inscripciones
				.stream()
				.filter(unaInscripcion -> unaInscripcion.cumpleCondicion(this))
				.collect(Collectors.toList());
	}
	
	public List<Inscripcion> getInscriptosDeTipo(Class clase) {
		return inscripciones.stream().filter( x -> x.esInstanciaDe(clase)).collect(Collectors.toList());
	}
	
	public long cantidadDeInscriptos(){
		return inscripciones.size();
	}
	
	public void agregarRechazoSugerencia(Rechazo unRechazo)
	{
		rechazosSugerencias.add(unRechazo);
	}

	// Agregar lista de observadores
	
	public void setObsPartidoDescompleto(List<ObsPartidoDescompleto> obsPartidoIncompleto) {
		observadoresDescompleto = obsPartidoIncompleto;
		
	}

	public void setObsPartidoCompleto(List<ObsPartidoCompleto> obsPartidoCompleto) {
		observadoresCompleto = obsPartidoCompleto;
		
	}

	public void setObsPartidoInscripcion(List<ObsPartidoInscripcion> obsPartidoInscripcion) {
		observadoresInscripcion = obsPartidoInscripcion;
	}
	
	// Agregar observadores
	
	public void agregarObservadorCompleto(ObsPartidoCompleto obs){
		observadoresCompleto.add(obs);
	}
	
	public void agregarObservadorIncompleto(ObsPartidoDescompleto obs){
		observadoresDescompleto.add(obs);
	}
	
	public void agregarObservadorInscripcion(ObsPartidoInscripcion obs){
		observadoresInscripcion.add(obs);
	}
	
	// Metodos para notificar
	
	public void notificar10Confirmados(){
		observadoresCompleto.forEach(x-> x.completo());
	}
	
	public void notificarYaNo10Confirmados(){
		observadoresDescompleto.forEach(x-> x.descompleto());
	}

	public void notificarAmigos(Jugador jugador){
		observadoresInscripcion.forEach(x-> x.notificar(jugador.getAmigos(), jugador));
	}
	
	public Boolean jugo(Jugador unJugador){
		return (this.inscripciones.stream().anyMatch( x -> x.getJugador() == unJugador));
		
	}
	
	/* Setters y getters de rechazo */
	
	public List<Rechazo> getRechazados(){
		return rechazosSugerencias;
	}
	
	public void armarEquipos(Criterio unCriterio, Divisor unDivisor){
		inscriptosCalificados = new Hashtable<Jugador, Integer>();
		inscripciones.forEach(x-> inscriptosCalificados.put(x.getJugador(), unCriterio.calificar(x.getJugador())));
		unDivisor.armarEquipos(this.equipo1, this.equipo2, this.inscriptosCalificados);
	}
	
	public Date getFecha(){
		return this.fecha;
	}
}
