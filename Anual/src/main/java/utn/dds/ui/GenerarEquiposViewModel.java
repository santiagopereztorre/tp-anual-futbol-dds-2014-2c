package utn.dds.ui;
import java.util.Arrays;
import java.util.List;

import utn.dds.criterios.Criterio;
import utn.dds.criterios.Handicap;
import utn.dds.criterios.Mix;
import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.criterios.PromedioUltimasNCalificaciones;
import utn.dds.divisores.Divisor;
import utn.dds.divisores.ParImpar;
import utn.dds.divisores.UnoParaAcaDosParaAllaDosParaAca;
import utn.dds.equipos.*;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

import org.uqbar.commons.utils.Observable;

@Observable
public class GenerarEquiposViewModel {

	public GenerarEquiposViewModel(Partido partido) {
		
		this.partido = partido;
	}
	
	private Divisor divisorSeleccionado;
	private Criterio criterioSeleccionado;
	private List<Jugador> equipo1;
	private List<Jugador> equipo2;
	private Partido partido;
		
	public List<Jugador> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Jugador> equipo1) {
		this.equipo1 = equipo1;
	}

	public List<Jugador> getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(List<Jugador> equipo2) {
		this.equipo2 = equipo2;
	}

	public List<Divisor> getDivisores(){
		return Arrays.asList(new ParImpar(), new UnoParaAcaDosParaAllaDosParaAca());
		//return Arrays.asList("Par/impar", "1,4,5,8,9");
	}
	
	public Divisor getDivisorSeleccionado() {
		return divisorSeleccionado;
	}

	public void setDivisorSeleccionado(Divisor divisorSeleccionado) {
		this.divisorSeleccionado = divisorSeleccionado;
	}

	public Criterio getCriterioSeleccionado() {
		return criterioSeleccionado;
	}

	public void setCriterioSeleccionado(Criterio criterioSeleccionado) {
		this.criterioSeleccionado = criterioSeleccionado;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Criterio> getCriterios(){
		return Arrays.asList( new Handicap(), new PromedioCalificacionesUltimoPartido());
		//return Arrays.asList( new Handicap(), new PromedioCalificacionesUltimoPartido(), new PromedioUltimasNCalificaciones(), new Mix());
	}
	
	public void armarEquipos() {
		partido.armarEquipos(this.criterioSeleccionado, this.divisorSeleccionado);
		this.setEquipo1(this.partido.getEquipo1());
		this.setEquipo2(this.partido.getEquipo2());
	}
	
}
