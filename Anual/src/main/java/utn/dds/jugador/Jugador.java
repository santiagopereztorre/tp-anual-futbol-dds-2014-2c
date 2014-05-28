package utn.dds.jugador;

import java.util.ArrayList;
import java.util.List;

import utn.dds.calificacion.Calificacion;
import utn.dds.infraccion.Infraccion;
import utn.dds.inscripcion.Inscripcion;
import utn.dds.jugador.excepciones.NoJugaronJuntosException;
import utn.dds.partido.*;
import utn.dds.tipoInscripcion.*;


public class Jugador {
	
	private List<Infraccion> infracciones;
	private List<Jugador> amigos;
	private List<Calificacion> calificaciones;
	private String mail;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Jugador(){
		infracciones = new ArrayList<Infraccion>();
		calificaciones = new ArrayList<Calificacion>();
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
	
	public Boolean jugueCon(Jugador unJugador, Partido unPartido)
	{
		return unPartido.jugo(this) && unPartido.jugo(unJugador);
	}
	
	
	public void calificar (Jugador unJugador, Partido unPartido, String unTexto) throws Exception {
		if (!this.jugueCon(unJugador, unPartido)) 
			throw new NoJugaronJuntosException();
		
		unJugador.agregarCalificacion(this, unPartido, unTexto);
	}
	

	public void agregarCalificacion(Jugador otroJugador, Partido unPartido, String unTexto) throws Exception{
		if (this.fuiCalificado(otroJugador, unPartido)) 
			throw new NoJugaronJuntosException();
		
		this.calificaciones.add(new Calificacion(otroJugador, unPartido, unTexto));
	}
	
	public Boolean fuiCalificado(Jugador unJugador, Partido unPartido){
		return (this.calificaciones.stream().filter( x -> x.getCalificador() == unJugador && x.getPartido() == unPartido).count()) > 0; 
	}
}
