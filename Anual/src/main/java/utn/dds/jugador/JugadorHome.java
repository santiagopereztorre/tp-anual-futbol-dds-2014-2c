package utn.dds.jugador;

import java.util.Date;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.functors.AndPredicate;
import org.uqbar.commons.model.*;

import utn.dds.criterios.PromedioCalificacionesUltimoPartido;
import utn.dds.delimitadores.Delimitador;
import utn.dds.jugador.JugadorWrapper;

public class JugadorHome extends CollectionBasedHome<Jugador> {

	private static JugadorHome instancia;
	
	@Override
	public Jugador createExample() {
		return new Jugador();
	}

	@Override
	public Class<Jugador> getEntityType() {
		return Jugador.class;
	}

	@Override
	protected Predicate<Jugador> getCriterio(Jugador example2) {
		JugadorWrapper example = (JugadorWrapper) example2;
		Predicate<Jugador> predicate = this.getCriterioTodas();
		if (example.getNombre() != null && !example.getNombre().equals("")) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorNombre(example.getNombre()));
		}
		if (example.getApodo() != null && !example.getApodo().equals("")) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorApodo(example.getApodo()));
		}
		if (example.getFechaDeNacimiento() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorFechaDeNacimiento(example.getFechaDeNacimiento()));
		}
		if (example.getHandicap() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorHandicap1(example.getHandicapDelimitador(), example.getHandicap()));
		}
		if (example.getPromedio() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorPromedio1(example.getPromedioDelimitador(), example.getPromedio()));
		}
		if (example.getFueInfraccionado() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorInfracciones(example.getFueInfraccionado()));
		}
		return predicate;
	}

	private Predicate<? super Jugador> getCriterioPorPromedio1(Delimitador delimitador, Integer promedio) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				PromedioCalificacionesUltimoPartido criterio = new PromedioCalificacionesUltimoPartido();
				Integer promedioDelJugador = criterio.calificar(jugador);
				return delimitador.cumpleCondicion(promedioDelJugador, promedio);
			}
		};
	}

	private Predicate<? super Jugador> getCriterioPorHandicap1(Delimitador delimitador, Integer handicap) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				return delimitador.cumpleCondicion(jugador.getHandicap(), handicap);
			}
		};
	}

	private Predicate<Jugador> getCriterioPorNombre(String nombre) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				return jugador.getNombre().toLowerCase().startsWith(nombre.toLowerCase());
			}
		};
	}

	private Predicate<Jugador> getCriterioPorApodo(String apodo) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				return jugador.getApodo().toLowerCase().contains(apodo.toLowerCase());
			}
		};
	}
	
	private Predicate<Jugador> getCriterioPorFechaDeNacimiento(Date fechaDeNacimiento) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				return fechaDeNacimiento.after(jugador.getFechaDeNacimiento());
			}
		};
	}
	
	private Predicate<? super Jugador> getCriterioPorInfracciones(Boolean fueInfraccionado) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				return jugador.getInfracciones().isEmpty() != fueInfraccionado;
			}
		};
	}

	public static JugadorHome getInstancia() {
		if (instancia == null) {
			instancia = new JugadorHome();
		}
		return instancia;
	}
	
}
