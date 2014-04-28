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
	
	public void InscribirJugador (Jugador jugador, TipoInscripcion tipoInscripcion){
		
		Inscripcion inscripcion = new Inscripcion(jugador, tipoInscripcion);
		
		
		/* No inscribimos si ya hay suficientes */
		long inscriptos = inscripciones.stream().filter( x -> x.esEstandar()).count();
		
		if (inscriptos < 10) inscripciones.add(inscripcion);
		
	}
	
	public void OrganizarEquipos(){
		List<Inscripcion> quienesJuegan = new ArrayList<Inscripcion>();
		List<Inscripcion> condicionales = getCondicionalesConfirmados();
		List<Inscripcion> solidarios = getInscriptosSolidarios();
		
		/* Carga todos los estandar */
		quienesJuegan.addAll(getInscriptosEstandar());
		
		/* Carga todos los condicionales que cumplan la condicion */
		for (int i=0; quienesJuegan.stream().count() < 10 || i < condicionales.stream().count(); i++){
			quienesJuegan.add(condicionales.get(i++));
		}
		
		/* Carga todos los solidarios, en orden de inscripcion */
		for (int y=0; quienesJuegan.stream().count() < 10 || y < condicionales.stream().count(); y++){
			quienesJuegan.add(solidarios.get(y));
		}
		
	}
	
	
	/* Obtencion de tipos de inscripciones */
	public List<Inscripcion> getInscriptosEstandar() {
		return inscripciones.stream().filter( x -> x.esEstandar()).collect(Collectors.toList());
	}
	
	public List<Inscripcion> getInscriptosCondicionales() {
		return inscripciones.stream().filter( x -> x.esCondicional()).collect(Collectors.toList());
	}
	
	public List<Inscripcion> getInscriptosSolidarios() {
		return inscripciones.stream().filter( x -> x.esSolidaria()).collect(Collectors.toList());
	}
	
	
	/* Obtencion de inscriptos que cumplen condiciones */
	public List<Inscripcion> getCondicionalesConfirmados() {
		return getInscriptosCondicionales().stream().filter( x -> x.CumpleCondicion(this)).collect(Collectors.toList());
	}
	
	
	/* Distribuir los jugadores en equipos */
	public void ConfirmarEquipos(){
		
	}

}
