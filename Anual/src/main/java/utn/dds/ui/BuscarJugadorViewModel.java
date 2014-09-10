package utn.dds.ui;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;
import utn.dds.jugador.JugadorWrapper;

@Observable
public class BuscarJugadorViewModel {
	
	private Jugador jugador;
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
	
	public String getHandicap()
	{
		return jugador.getApodo();
	}

	public void setHandicap(String handicap)
	{
		jugador.setApodo(handicap);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public List<Jugador> getJugadores() {
		jugadores = JugadorHome.getInstancia().searchByExample(jugador);
		return jugadores;
	}
}
