package utn.dds.jugador;

import java.util.ArrayList;
import java.util.List;

import utn.dds.infraccion.Infraccion;
import utn.dds.inscripcion.Inscripcion;
import utn.dds.partido.*;
import utn.dds.tipoInscripcion.*;


public class Jugador {
	
	private List<Infraccion> infracciones;
	private List<Jugador> amigos;
	private String mail;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Jugador(){
		infracciones = new ArrayList<Infraccion>();
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
	
	
}
