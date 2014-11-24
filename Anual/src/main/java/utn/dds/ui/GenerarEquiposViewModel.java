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

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
public class GenerarEquiposViewModel {
	
	private Estandar estandar;
	private Condicional condicional;
	private Solidaria solidaria;
	
	private void inicializarPartido(){
		EntityManagerHelper.beginTransaction();
		
		Jugador juan = new Jugador();
		juan.setNombre("juan");
		JugadorHome.getInstancia().create(juan);
		
		Jugador lalo = new Jugador();
		lalo.setNombre("lalo");
		JugadorHome.getInstancia().create(lalo);
		
		Jugador juancho = new Jugador();
		juancho.setNombre("juancho");
		JugadorHome.getInstancia().create(juancho);
		
		Jugador carlos = new Jugador();
		carlos.setNombre("carlos");
		JugadorHome.getInstancia().create(carlos);
		
		Jugador pepito = new Jugador();
		pepito.setNombre("pepito");
		JugadorHome.getInstancia().create(pepito);
		
		Jugador martin = new Jugador();
		martin.setNombre("martin");
		JugadorHome.getInstancia().create(martin);
		
		Jugador lucas = new Jugador();
		lucas.setNombre("lucas");
		JugadorHome.getInstancia().create(lucas);
		
		Jugador pato = new Jugador();
		pato.setNombre("pato");
		JugadorHome.getInstancia().create(pato);
		
		Jugador marcelo = new Jugador();
		marcelo.setNombre("marcelo");
		JugadorHome.getInstancia().create(marcelo);
		
		Jugador leandro = new Jugador();
		leandro.setNombre("leandro");
		JugadorHome.getInstancia().create(leandro);
		
		juan.setHandicap(10);
		pepito.setHandicap(1);
		marcelo.setHandicap(4);
		leandro.setHandicap(5);
		martin.setHandicap(6);
		juancho.setHandicap(7);
		carlos.setHandicap(2);
		pato.setHandicap(8);
		lalo.setHandicap(3);
		lucas.setHandicap(9);
		
		juan.setApodo("Tato");
		pepito.setApodo("Enano");
		marcelo.setApodo("Micho");
		leandro.setApodo("Tito");
		martin.setApodo("Pelado");
		juancho.setApodo("Negrito");
		carlos.setApodo("Gordo");
		pato.setApodo("Cabezon");
		lalo.setApodo("Colo");
		lucas.setApodo("Lucho");
		
		EntityManagerHelper.persist(leandro);
		EntityManagerHelper.persist(juan);
		EntityManagerHelper.persist(marcelo);
		EntityManagerHelper.persist(pepito);
		EntityManagerHelper.persist(martin);
		EntityManagerHelper.persist(juancho);
		EntityManagerHelper.persist(pato);
		EntityManagerHelper.persist(lalo);
		EntityManagerHelper.persist(lucas);
		EntityManagerHelper.persist(carlos);
		
		Partido riverboca = new Partido(new Date());
		
		this.estandar = new Estandar();
		this.condicional = new Condicional();
		this.solidaria = new Solidaria();
		
		riverboca.inscribirJugador(carlos, estandar);
		riverboca.inscribirJugador(juancho, estandar);
		riverboca.inscribirJugador(juan, estandar);
		riverboca.inscribirJugador(lucas, estandar);
		riverboca.inscribirJugador(pato, estandar);
		riverboca.inscribirJugador(martin, estandar);
		riverboca.inscribirJugador(leandro, estandar);
		riverboca.inscribirJugador(marcelo, estandar);
		riverboca.inscribirJugador(lalo, estandar);
		riverboca.inscribirJugador(pepito, estandar);
		
		EntityManagerHelper.persist(estandar);
		EntityManagerHelper.persist(condicional);
		EntityManagerHelper.persist(solidaria);
		
		EntityManagerHelper.persist(riverboca);
		
		carlos.calificar(juancho, riverboca, 2, "Es horrible");
		carlos.calificar(juan, riverboca, 3, "Arquero manco");
		carlos.calificar(pato, riverboca, 1, "Es ma malo que el cigarro");
		carlos.calificar(lucas, riverboca, 6, "Jugo bien");
		carlos.calificar(martin, riverboca, 10, "La estrella");
		carlos.calificar(marcelo, riverboca, 9, "Sabella marcelito es argentino");
		carlos.calificar(lalo, riverboca, 5, "Regular");
		carlos.calificar(pepito, riverboca, 7, "Lateral con proyeccion");
		carlos.calificar(leandro, riverboca, 4, "Defensor rustico");
		martin.calificar(carlos, riverboca, 8, "Un volante con magia");
		
		
		partido = new Partido(new Date());
		partido.inscribirJugador(lalo, solidaria);
		partido.inscribirJugador(juan, estandar);
		partido.inscribirJugador(lucas, solidaria);
		partido.inscribirJugador(pepito, condicional);
		partido.inscribirJugador(martin, condicional);
		partido.inscribirJugador(juancho, estandar);
		partido.inscribirJugador(carlos, estandar);
		partido.inscribirJugador(marcelo, condicional);
		partido.inscribirJugador(leandro, estandar);
		partido.inscribirJugador(pato, estandar);		
		

		EntityManagerHelper.commit();		
	}
	
	public GenerarEquiposViewModel(Partido partido) {
		this.partido = partido;
		
		EntityManagerHelper.beginTransaction();
		List<Jugador> jugadores = JugadorHome.getInstancia().getJugadores();
		
		if(jugadores.isEmpty()){
			this.inicializarPartido();
		}
		
		Query queryTipos = EntityManagerHelper.createQuery("from TipoInscripcion");
		List<TipoInscripcion> tipos = queryTipos.getResultList();
		
		this.estandar = (Estandar)tipos.get(0);
		this.condicional = (Condicional)tipos.get(1);
		this.solidaria = (Solidaria)tipos.get(2);
		
		jugadores.forEach((Jugador jugador) -> JugadorHome.getInstancia().create(jugador));
		jugadores.forEach((Jugador jugador) -> this.partido.inscribirJugador(jugador, this.estandar));	
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
