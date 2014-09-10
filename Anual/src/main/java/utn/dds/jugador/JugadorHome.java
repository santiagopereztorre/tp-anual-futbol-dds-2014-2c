package utn.dds.jugador;

import java.util.Date;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.functors.AndPredicate;
import org.uqbar.commons.model.*;

public class JugadorHome extends CollectionBasedHome<Jugador> {

	public static final int DESDE = 0;
	public static final int HASTA = 1;
	
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
		if (example.getHandicapDesdeOHasta() != -1 && example.getHandicap() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorHandicap(example.getHandicapDesdeOHasta(), example.getHandicap()));
		}
		return predicate;
	}

	private Predicate<? super Jugador> getCriterioPorHandicap(int handicapDesdeOHasta, Integer handicap) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				if (handicapDesdeOHasta == DESDE) {
					return jugador.getHandicap() < handicap;
				} else if (handicapDesdeOHasta == HASTA) {
					return jugador.getHandicap() > handicap;
				} else {
					return false;
				}
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

	public static JugadorHome getInstancia() {
		if (instancia == null) {
			instancia = new JugadorHome();
		}
		return instancia;
	}
	
}
