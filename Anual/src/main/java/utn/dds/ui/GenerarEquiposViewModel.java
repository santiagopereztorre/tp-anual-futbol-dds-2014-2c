package utn.dds.ui;

import java.util.Arrays;
import java.util.List;

import utn.dds.partido.Partido;
import org.uqbar.commons.utils.Observable;

@Observable
public class GenerarEquiposViewModel {

	public GenerarEquiposViewModel(Partido partido) {

	}
	
	private String criterioSeleccionado;
	private String ordenamientoSeleccionado;
	
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
