package utn.dds.ui;
import java.util.Arrays;
import java.util.List;

import utn.dds.equipos.*;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

import org.uqbar.commons.utils.Observable;

@Observable
public class GenerarEquiposViewModel {

	public GenerarEquiposViewModel(Partido partido) {
		
	}
	
	private String criterioSeleccionado;
	private String ordenamientoSeleccionado;
	private List<Jugador> equipo1;
	private List<Jugador> equipo2;
	
	public List<Jugador> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Jugador> equipo1) {
		this.equipo1 = equipo1;
	}

	public List<Jugador> getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(List<Jugador> equipo2) {
		this.equipo2 = equipo2;
	}

	public String getOrdenamientoSeleccionado() {
		return ordenamientoSeleccionado;
	}

	public void setOrdenamientoSeleccionado(String ordenamientoSeleccionado) {
		this.ordenamientoSeleccionado = ordenamientoSeleccionado;
	}

	public String getCriterioSeleccionado() {
		return criterioSeleccionado;
	}

	public void setCriterioSeleccionado(String criterioSeleccionado) {
		this.criterioSeleccionado = criterioSeleccionado;
	}	
	
	public List<String> getCriterios(){
		return Arrays.asList("Par/impar", "1,4,5,8,9");
	}
	
	public List<String> getOrdenamientos(){
		return Arrays.asList("Por hándicap", "Por promedio de notas del último partido", "Por promedio de notas de los últimos n partidos", "Mixto");
	}
	
}
