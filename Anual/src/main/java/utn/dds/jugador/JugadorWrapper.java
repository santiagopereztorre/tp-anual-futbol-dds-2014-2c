package utn.dds.jugador;

import org.uqbar.commons.utils.Observable;

import utn.dds.delimitadores.Delimitador;
import utn.dds.delimitadores.Desde;
import utn.dds.delimitadores.Hasta;

@Observable
@SuppressWarnings("serial")
public class JugadorWrapper extends Jugador{

	public static final int DESDE = 0;
	public static final int HASTA = 1;
	
	private int handicapDesdeOHasta;
	private int promedioDesdeOHasta;
	private Integer promedio;
	private Boolean fueInfraccionado;
	
	private Delimitador handicapDelimitador;
	private Delimitador promedioDelimitador;

	public Boolean getFueInfraccionado() {
		return fueInfraccionado;
	}

	public void setFueInfraccionado(Boolean fueInfraccionado) {
		this.fueInfraccionado = fueInfraccionado;
	}

	public JugadorWrapper() {
		handicapDesdeOHasta = DESDE;
		promedioDesdeOHasta = DESDE;
		handicapDelimitador = new Desde();
		promedioDelimitador = new Hasta();
	}
	
	public Integer getPromedio() {
		return promedio;
	}
	public void setPromedio(Integer promedio) {
		this.promedio = promedio;
	}
	public int getHandicapDesdeOHasta() {
		return handicapDesdeOHasta;
	}
	public void setHandicapDesdeOHasta(int handicapDesdeOHasta) {
		this.handicapDesdeOHasta = handicapDesdeOHasta;
	}
	public int getPromedioDesdeOHasta() {
		return promedioDesdeOHasta;
	}
	public void setPromedioDesdeOHasta(int promedioDesdeOHasta) {
		this.promedioDesdeOHasta = promedioDesdeOHasta;
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
	
	
}
