package utn.dds.ui;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.criterios.PromedioUltimasNCalificaciones;
import utn.dds.infraccion.Infraccion;
import utn.dds.jugador.Jugador;
import utn.dds.partido.PartidoHome;

@Observable
public class JugadorViewModel {
	
	private Jugador jugador;
	
	public JugadorViewModel(Jugador jugador)
	{
		this.jugador = jugador;
	}
	
	public String getNombre()
	{
		return jugador.getNombre();
	}
	
	public String getApodo()
	{
		return jugador.getApodo();
	}
	
	public String getHandicap()
	{
		return jugador.getHandicap().toString();
	}
	
	public List<Infraccion> getInfracciones()
	{
		return jugador.getInfracciones();
	}
	
	public List<Jugador> getAmigos()
	{
		return jugador.getAmigos();
	}
	
	public Long getCantidadPartidosJugados()
	{
		return PartidoHome.getInstancia().allInstances()
			.stream().filter(unPartido -> unPartido.jugoPartido(jugador)).count();
	}
	
	public String getPromedioUltimoPartido()
	{
		return new PromedioCalificacionesUltimoPartido().calificar(jugador).toString();
	}
	
	public String getPromedioGeneral()
	{
		return new PromedioUltimasNCalificaciones(PromedioUltimasNCalificaciones.TODAS)
					.calificar(jugador)
					.toString();
	}

}
