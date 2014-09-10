package utn.dds.jugador;

import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("serial")
public class JugadorWrapper extends Jugador{

	public static final int DESDE = 0;
	public static final int HASTA = 1;
	
	private int handicapDesdeOHasta;
	private int promedioDesdeOHasta;
	
	public JugadorWrapper() {
		handicapDesdeOHasta = HASTA;
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
}
