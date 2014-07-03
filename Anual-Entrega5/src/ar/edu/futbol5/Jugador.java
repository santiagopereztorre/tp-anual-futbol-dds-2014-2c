package ar.edu.futbol5;

import ar.edu.futbol5.inscripcion.CriterioInscripcion;
import ar.edu.futbol5.inscripcion.ModoSolidario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.futbol5.inscripcion.ModoEstandar;

public class Jugador {

	private String nombre;
	private Double calificacion;
	private List<Double> puntajes;
	CriterioInscripcion criterioInscripcion;
	
	public Jugador() {
		this.puntajes = new ArrayList<Double>();
		this.criterioInscripcion = new ModoEstandar();
		this.nombre = "";
	}
	
	public Jugador(String nombre, double calificacion, List<Double> puntajes) {
		this.calificacion = calificacion;
		this.puntajes = puntajes;
		this.criterioInscripcion = new ModoEstandar();
		this.nombre = nombre;
	}
	
	void modoSolidario() {
		criterioInscripcion = new ModoSolidario();
	}
	
	boolean dejaLugarAOtro() {
		return criterioInscripcion instanceof ModoSolidario;
	}

	public String toString() {
		//"Jugador (" + calificacion + ") - modo " + criterioInscripcion.toString()
		return nombre;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public List<Double> getPuntajes() {
		return puntajes;
	}
	
	public Double obtenerUnPuntaje(int pos){
		try{
			return puntajes.get(pos);
		} 
		catch (NoSuchElementException e){
			// No hay elementos en esa posicion.
			return (double) 0;
		}
		
	}
}

