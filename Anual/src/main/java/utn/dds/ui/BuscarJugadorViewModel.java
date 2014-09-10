package utn.dds.ui;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;
import utn.dds.jugador.JugadorWrapper;

@Observable
public class BuscarJugadorViewModel {

	public static final int DESDE = 0;
	public static final int HASTA = 1;
	
	private JugadorWrapper jugador;
	private List<Jugador> jugadores;
	
	public BuscarJugadorViewModel() {
		jugador = new JugadorWrapper();
		jugador.setFechaDeNacimiento(null);
	}
	
	public String getNombre() {
		return jugador.getNombre();
	}
	
	public void setNombre(String nombre) {
		jugador.setNombre(nombre);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public String getApodo()
	{
		return jugador.getApodo();
	}

	public void setApodo(String apodo)
	{
		jugador.setApodo(apodo);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public String getHandicapModificador() {
		return jugador.getHandicapDesdeOHasta() == DESDE ? "Desde" : "Hasta";
	}
	
	public void setHandicapModificador(String modificador) {
		jugador.setHandicapDesdeOHasta(modificador.equals("Desde") ? DESDE : HASTA);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public String getHandicap()
	{
		if (jugador.getHandicap() == -1) {
			return "";
		} else {
			return jugador.getHandicap().toString();
		}
	}

	public void setHandicap(String handicap)
	{
		if (handicap.equals("")) {
			jugador.setHandicap(-1);
		} else {
			jugador.setHandicap(Integer.parseInt(handicap));
		}
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public String getPromedioModificador() {
		return jugador.getPromedioDesdeOHasta() == DESDE ? "Desde" : "Hasta";
	}
	
	public void setPromedioModificador(String modificador) {
		jugador.setPromedioDesdeOHasta(modificador.equals("Desde") ? DESDE : HASTA);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public String getPromedio()
	{
		if (jugador.getPromedio() == null) {
			return "";
		} else {
			return Integer.toString(jugador.getPromedio());
		}
	}

	public void setPromedio(String promedio)
	{
		if (promedio.equals("")) {
			jugador.setPromedio(null);
		} else {
			jugador.setPromedio(Integer.parseInt(promedio));
		}
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public Boolean getInfracciones() {
		return jugador.getFueInfraccionado();
	}
	
	public void setInfracciones(Boolean fueInfraccionado) {
		jugador.setFueInfraccionado(fueInfraccionado);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public List<Jugador> getJugadores() {
		jugadores = JugadorHome.getInstancia().searchByExample(jugador);
		return jugadores;
	}
}
