package utn.dds.partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

//import org.uqbar.commons.model.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import utn.dds.observers.ObsPartidoCompleto;
import utn.dds.observers.ObsPartidoDescompleto;
import utn.dds.observers.ObsPartidoInscripcion;
import utn.dds.partido.exceptions.NoHayVacantesException;
import utn.dds.persistentEntity.PersistentEntity;
import utn.dds.tipoInscripcion.*;
import utn.dds.admin.Rechazo;
import utn.dds.criterios.Criterio;
import utn.dds.divisores.Divisor;
import utn.dds.infraccion.Infraccion;
import utn.dds.inscripcion.*;
import utn.dds.jugador.*;


@Entity
@Table(name="Partidos")
public class Partido extends org.uqbar.commons.model.Entity{
	
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_partido")
	private List<Inscripcion> inscripciones;

	@ManyToMany
	@JoinTable(name="Jugadores_x_Partidos_1",
	  joinColumns={@JoinColumn(name="Partidos_id_partido")},
	  inverseJoinColumns={@JoinColumn(name="Jugadores_id_jugador")})
	private List<Jugador> equipo1;
	
	@ManyToMany
	@JoinTable(name="Jugadores_x_Partidos_2",
	  joinColumns={@JoinColumn(name="Partidos_id_partido")},
	  inverseJoinColumns={@JoinColumn(name="Jugadores_id_jugador")})
	private List<Jugador> equipo2;
	
	@Transient
	private ArrayList<JugadorConCalificacion> inscriptosCalificados;
	
	@Transient
	private List<ObsPartidoCompleto> observadoresCompleto;
	@Transient
	private List<ObsPartidoDescompleto> observadoresDescompleto;
	@Transient
	private List<ObsPartidoInscripcion> observadoresInscripcion;
	
	@OneToMany
	@JoinColumn(name="id_partido")
	private List<Rechazo> rechazosSugerencias;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_partido")
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
		equipo1 = new ArrayList<Jugador>();
		equipo2 = new ArrayList<Jugador>();
		inscriptosCalificados = new ArrayList<JugadorConCalificacion>();
		rechazosSugerencias = new ArrayList<Rechazo>();
	}
	// Inscripcion de jugadores
	
	public void inscribirJugador(Jugador jugador, TipoInscripcion tipoInscripcion)
	{		
		if (!hayVacante())
			throw new NoHayVacantesException("Ya no hay mas lugar para inscribir jugadores");
		
		inscripciones.add(new Inscripcion(jugador, this, tipoInscripcion));
		
		
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
	
	public List<Inscripcion> getInscriptosDeTipo(Class<?> clase) {
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
		inscriptosCalificados = new ArrayList<JugadorConCalificacion>();
		inscripciones.forEach(x-> agregarACalificados(x.getJugador(), unCriterio.calificar(x.getJugador()),  inscriptosCalificados));
		unDivisor.armarEquipos(this.equipo1, this.equipo2, this.inscriptosCalificados);
	}

	private void agregarACalificados(Jugador jugador, Integer calificacion,
			ArrayList<JugadorConCalificacion> inscriptosCalificados) {
		JugadorConCalificacion jugadorConCalificacion = new JugadorConCalificacion();
		jugadorConCalificacion.setJugador(jugador);
		jugadorConCalificacion.setCalificacion(calificacion);
		inscriptosCalificados.add(jugadorConCalificacion);
	}

	public Date getFecha(){
		return this.fecha;
	}
	
	public List<Jugador> getEquipo1(){
		return this.equipo1;
	}
	
	public List<Jugador> getEquipo2(){
		return this.equipo2;
	}
	
	/**
	 * Evalua si unJugador jugo este partido
	 * @param unJugador
	 * @return True si unJugador jugo el partido. Falso caso contrario
	 */
	public Boolean jugoPartido(Jugador unJugador)
	{
		return equipo1.contains(unJugador) || equipo2.contains(unJugador);
	}
}
