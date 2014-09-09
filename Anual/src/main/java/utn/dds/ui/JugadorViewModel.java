package utn.dds.ui;

import java.util.List;

import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.criterios.PromedioUltimasNCalificaciones;
import utn.dds.infraccion.Infraccion;
import utn.dds.jugador.Jugador;

public class JugadorViewModel {
	
	Jugador jugador;
	
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
	
	public List<Infraccion> getInfracciones()
	{
		return jugador.getInfracciones();
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
