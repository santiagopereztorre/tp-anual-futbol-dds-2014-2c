package utn.dds.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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



//import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

import utn.dds.admin.Admin;
import utn.dds.admin.Sugerencia;
import utn.dds.calificacion.Calificacion;
import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.infraccion.Infraccion;
import utn.dds.jugador.excepciones.JugadorNoJugoElPartidoException;
import utn.dds.jugador.excepciones.NoEsAmigoException;
import utn.dds.jugador.excepciones.NoJugaronJuntosException;
import utn.dds.jugador.excepciones.NoPodesCalificarteAVosMismoException;
import utn.dds.jugador.excepciones.YaFueCalificadoException;
import utn.dds.partido.*;
import utn.dds.tipoInscripcion.TipoInscripcion;

@Observable
@Entity
@Table(name="Jugadores")
public class Jugador extends org.uqbar.commons.model.Entity{
	
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}
	
	@OneToMany
	@JoinColumn(name="id_jugador")
	private List<Infraccion> infracciones;
	
	@ManyToMany
	@JoinTable(name="Amigos",
	  joinColumns={@JoinColumn(name="Jugadores_id_jugador1")},
	  inverseJoinColumns={@JoinColumn(name="Jugadores_id_jugador2")})
	private List<Jugador> amigos;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_calificado")
	private List<Calificacion> calificaciones;
	
	@Column(name="mail_jugador")
	private String mail;
	
	@Column(name="handicap_jugador")
	private Integer handicap;
	
	@Column(name="nombre_jugador")
	private String nombre;
	
	@Column(name="apodo_jugador")
	private String apodo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_nac_jugador")
	private Date fechaDeNacimiento;
	
	public Jugador(){
		infracciones = new ArrayList<Infraccion>();
		calificaciones = new ArrayList<Calificacion>();
		amigos = new ArrayList<Jugador>();
		this.handicap = -1;
		fechaDeNacimiento = new Date();
	}
	
	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApodo()
	{
		return apodo;
	}

	public void setApodo(String apodo)
	{
		this.apodo = apodo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void agregarAmigo(Jugador unAmigo){
		amigos.add(unAmigo);
	}
	
	public void recibirInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}
	
	public int cantidadInfracciones() {
		return infracciones.size();
	}
	
	public List<Jugador> getAmigos(){
		return amigos;
	}
	
	public List<Infraccion> getInfracciones()
	{
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones)
	{
		this.infracciones = infracciones;
	}
	
	/**
	 * Evalua si dos jugadores participaron del mismo partido
	 * @param unJugador
	 * @param unPartido
	 * @return True cuando jugaron juntos en unPartido
	 */
	public Boolean jugueCon(Jugador unJugador, Partido unPartido)
	{
		return unPartido.jugo(unJugador);
	}
	
	/**
	 * Califica a unJugador por su participacion en unPartido
	 * @param unJugador
	 * @param unPartido
	 * @param unTexto
	 * @throws Exception
	 */
	public void calificar(Jugador unJugador, Partido unPartido, Integer unPuntaje, String unTexto)
	{
		if (this == unJugador)
			throw new NoPodesCalificarteAVosMismoException();
		
		if (!unPartido.jugo(this))
			throw new JugadorNoJugoElPartidoException();
		
		if (!this.jugueCon(unJugador, unPartido)) 
			throw new NoJugaronJuntosException("Los jugadores no jugaron juntos el partido indicado");
		
		Calificacion calificacion = new Calificacion(this, unJugador, unPartido, unPuntaje, unTexto);
		
		unJugador.agregarCalificacion(calificacion);
	}
	
	public void agregarCalificacion(Calificacion calificacion)
	{
		if (this.fuiCalificado(calificacion.getCalificador(), calificacion.getPartido())) 
			throw new YaFueCalificadoException();
		
		this.calificaciones.add(calificacion);
	}
	
	public Boolean fuiCalificado(Jugador unJugador, Partido unPartido){
		return (this.calificaciones.stream().filter( x -> x.getCalificador() == unJugador && x.getPartido() == unPartido).count()) > 0; 
	}
	
	/**
	 * Sugiere amigos al administrador de sistema.
	 * 
	 */
	 
	public void sugerirAmigo(Jugador unAmigo, Partido unPartido, TipoInscripcion insc)
	{
		/* Se fija que sea un amigo suyo */
		if (!esAmigo(unAmigo))
			throw new NoEsAmigoException("El jugador no es amigo");
		
		Admin.getInstancia().sugerir(new Sugerencia(unAmigo, unPartido, insc));
			
	}
	
	public Boolean esAmigo(Jugador unJugador){		// TODO HACER UN TEST?
		
		return amigos.contains(unJugador);
	}

	public int cantidadCalificaciones() {
		return this.calificaciones.size();
	}
	
	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}
	
	public Integer getHandicap(){
		return this.handicap;
	}
	
	public void setHandicap(Integer unHandicap){
		this.handicap = unHandicap;
	}
	
	public String toString(){
		return this.nombre;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Integer getPromedio() {
		PromedioCalificacionesUltimoPartido criterio = new PromedioCalificacionesUltimoPartido();
		return criterio.calificar(this);
	}
}
