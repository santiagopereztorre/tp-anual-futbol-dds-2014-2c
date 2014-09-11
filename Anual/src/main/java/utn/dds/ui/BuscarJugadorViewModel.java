package utn.dds.ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import utn.dds.delimitadores.Delimitador;
import utn.dds.delimitadores.Desde;
import utn.dds.delimitadores.Hasta;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;
import utn.dds.jugador.JugadorWrapper;

@Observable
public class BuscarJugadorViewModel {

	private JugadorWrapper jugador;
	private List<Jugador> jugadores;
	private List<Delimitador> delimitadores;
	private Delimitador desde;
	private Delimitador hasta;
	
	public BuscarJugadorViewModel()
	{
		jugador = new JugadorWrapper();
		jugador.setFechaDeNacimiento(null);
		delimitadores = new ArrayList<Delimitador>();
		desde = new Desde();
		hasta = new Hasta();
		delimitadores.add(desde);
		delimitadores.add(hasta);
	}
	
	public String getNombre()
	{
		return jugador.getNombre();
	}
	
	public void setNombre(String nombre)
	{
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
	
	public Delimitador getHandicapDelimitador()
	{
		return desde;
	}
	
	public void setHandicapDelimitador(Delimitador delimitador)
	{
		jugador.setHandicapDelimitador(delimitador);
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
	
	public Delimitador getPromedioDelimitador()
	{
		return desde;
	}
	
	public void setPromedioDelimitador(Delimitador delimitador)
	{
		jugador.setPromedioDelimitador(delimitador);
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
	
	public Boolean getInfracciones()
	{
		return jugador.getFueInfraccionado();
	}
	
	public void setInfracciones(Boolean fueInfraccionado)
	{
		jugador.setFueInfraccionado(fueInfraccionado);
		ObservableUtils.firePropertyChanged(this, "jugadores", getJugadores());
	}
	
	public List<Delimitador> getDelimitadores()
	{
		return delimitadores;
	}
	
	public List<Jugador> getJugadores()
	{
		jugadores = JugadorHome.getInstancia().searchByExample(jugador);
		return jugadores;
	}
}
