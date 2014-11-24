package utn.dds.ui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import utn.dds.calificacion.Calificacion;
import utn.dds.criterios.Criterio;
import utn.dds.criterios.Handicap;
import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.criterios.PromedioUltimasNCalificaciones;
import utn.dds.db.EntityManagerHelper;
import utn.dds.divisores.Divisor;
import utn.dds.divisores.ParImpar;
import utn.dds.divisores.UnoParaAcaDosParaAllaDosParaAca;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;
import utn.dds.partido.Partido;
import utn.dds.partido.PartidoHome;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.Solidaria;
import utn.dds.tipoInscripcion.TipoInscripcion;
import utn.dds.tipoInscripcion.TipoInscripcionHome;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
public class GenerarEquiposViewModel {
	
	public GenerarEquiposViewModel(Partido partido) {
		this.partido = partido;
		
		List<Jugador> jugadores = JugadorHome.getInstancia().getJugadores();
		
		if(jugadores.isEmpty()){
			InicializadorPartidos.inicializar(partido);
		}
		
		jugadores.forEach((Jugador jugador) -> JugadorHome.getInstancia().create(jugador));
		jugadores.forEach((Jugador jugador) -> this.partido.inscribirJugador(jugador, InicializadorPartidos.getEstandar()));	
	}
	
	private Divisor divisorSeleccionado;
	private Criterio criterioSeleccionado;
	private List<Jugador> equipo1;
	private List<Jugador> equipo2;
	private Partido partido;
	private int parametroN;
	private Boolean visibilidadParametroN = false;	
	private Jugador jugadorSeleccionado;
	private GenerarEquiposView wo;
	
	public GenerarEquiposView getWo() {
		return wo;
	}

	public void setWo(GenerarEquiposView wo) {
		this.wo = wo;
	}

	public Jugador getJugadorSeleccionado() {
		return jugadorSeleccionado;
	}

	public void setJugadorSeleccionado(Jugador jugadorSeleccionado) {
		this.jugadorSeleccionado = jugadorSeleccionado;
		new JugadorView(this.abrirJugadorSeleccionado(), getWo()).open();
		
	}

	public int getParametroN() {
		return parametroN;
	}

	public void setParametroN(int parametroN) {
		this.parametroN = parametroN;
	}

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
		Divisor parImpar = new ParImpar();
		this.setDivisorSeleccionado(parImpar);
		return Arrays.asList(parImpar, new UnoParaAcaDosParaAllaDosParaAca());
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
			
		this.setVisibilidadParametroN(criterioSeleccionado.getClass().equals(new PromedioUltimasNCalificaciones().getClass()));
		ObservableUtils.firePropertyChanged(this, "visibilidadParametroN", this.getVisibilidadParametroN());		
	}

	public Boolean getVisibilidadParametroN() {
		return visibilidadParametroN;
	}

	public void setVisibilidadParametroN(Boolean visibilidadParametroN) {
		this.visibilidadParametroN = visibilidadParametroN;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Criterio> getCriterios(){
		Criterio handicap = new Handicap();
		this.setCriterioSeleccionado(handicap);
		return Arrays.asList(handicap, new PromedioCalificacionesUltimoPartido(), new PromedioUltimasNCalificaciones());
	}
	
	public void armarEquipos() {
		EntityManagerHelper.beginTransaction();
		partido.armarEquipos(this.criterioSeleccionado, this.divisorSeleccionado);
		
		this.setEquipo1(this.partido.getEquipo1());
		this.setEquipo2(this.partido.getEquipo2());
		
		
		EntityManagerHelper.commit();
		ObservableUtils.firePropertyChanged(this, "equipo1", getEquipo1());
		ObservableUtils.firePropertyChanged(this, "equipo2", getEquipo2());
	}
	
	public void confirmarEquipos(){
		EntityManagerHelper.beginTransaction();
		PartidoHome.getInstancia().create(partido);
		
		EntityManagerHelper.persist(partido);
		
		EntityManagerHelper.commit();
	}
	
	public Jugador abrirJugadorSeleccionado(){
		return getJugadorSeleccionado();
	}
}
