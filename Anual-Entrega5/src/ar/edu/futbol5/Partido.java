package ar.edu.futbol5;

import ar.edu.futbol5.distribucionEquipo.DistribucionEquipo;
import ar.edu.futbol5.estadoPartido.*;
import ar.edu.futbol5.excepciones.BusinessException;
import ar.edu.futbol5.excepciones.NoHaySolidariosException;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;

import java.util.ArrayList;
import java.util.List;

public class Partido {

	private List<Jugador> inscriptos;
	private Equipo equipo1;
	private Equipo equipo2;
	private EstadoDelPartido estado;
	private CriterioOrdenamiento criterioOrdenamiento;
	private DistribucionEquipo distribucionEquipos; // 5 es par/impar, 16 = 1,4,5,8,9 vs. 2,3,6,7,10

	public Partido(DistribucionEquipo distribucion, CriterioOrdenamiento ordenamiento) {
		inscriptos = new ArrayList<Jugador>();
		estado = new PartidoAbierto();
		distribucionEquipos = distribucion;
		criterioOrdenamiento = ordenamiento;
	}

	public void generarEquipos() {
		if (estado.validarInscripcion(inscriptos)) {
			throw new BusinessException("Hubo un error");
		}
		this.distribuirEquipos(this.ordenarEquipos());
		estado = new PartidoGenerado();
	}

	private void distribuirEquipos(List<Jugador> jugadores) {
		equipo1 = new Equipo();
		equipo2 = new Equipo();
		
		// Se delega en otro objeto la distribucion de los jugadores en equipos
		distribucionEquipos.distribuirJugadores(jugadores, equipo1, equipo2);
	}

	public List<Jugador> ordenarEquipos() {
		return criterioOrdenamiento.ordenar(this);
	}

	void inscribir(Jugador jugador) {
		if (inscriptos.size() < 10) {
			this.inscriptos.add(jugador);
		} else {
			try {
				this.inscriptos.remove(this.jugadorQueCedeLugar());
				this.inscriptos.add(jugador);
			} catch (NoHaySolidariosException e) {
				throw new BusinessException("No hay más lugar");
			}
		}
	}

	private Jugador jugadorQueCedeLugar() {
		
		for (Jugador inscripto : inscriptos) {
			if(inscripto.dejaLugarAOtro()){
				return inscripto;
			}
		}
		
		throw new NoHaySolidariosException("No Hay Solidarios");
	}

	public void cerrar() {
		estado = new PartidoCerrado();
	}

	public List<Jugador> getInscriptos() {
		return inscriptos;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}
	
}
