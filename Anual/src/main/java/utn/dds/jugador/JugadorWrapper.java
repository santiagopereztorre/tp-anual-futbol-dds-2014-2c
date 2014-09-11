package utn.dds.jugador;

import org.uqbar.commons.utils.Observable;

import utn.dds.delimitadores.Delimitador;
import utn.dds.delimitadores.Desde;

@Observable
@SuppressWarnings("serial")
public class JugadorWrapper extends Jugador{

	private Integer promedio;
	private Boolean fueInfraccionado;
	private Delimitador handicapDelimitador;
	private Delimitador promedioDelimitador;

	public JugadorWrapper() {
		handicapDelimitador = new Desde();
		promedioDelimitador = new Desde();
	}

	public Delimitador getHandicapDelimitador() {
		return handicapDelimitador;
	}

	public void setHandicapDelimitador(Delimitador handicapDelimitador) {
		this.handicapDelimitador = handicapDelimitador;
	}

	public Delimitador getPromedioDelimitador() {
		return promedioDelimitador;
	}

	public void setPromedioDelimitador(Delimitador promedioDelimitador) {
		this.promedioDelimitador = promedioDelimitador;
	}

	public Boolean getFueInfraccionado() {
		return fueInfraccionado;
	}

	public void setFueInfraccionado(Boolean fueInfraccionado) {
		this.fueInfraccionado = fueInfraccionado;
	}
	
	public Integer getPromedio() {
		return promedio;
	}
	
	public void setPromedio(Integer promedio) {
		this.promedio = promedio;
	}
	
	
}
