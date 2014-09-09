package utn.dds.jugador;

import java.util.Date;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.functors.AndPredicate;
import org.uqbar.commons.model.*;

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
	protected Predicate<Jugador> getCriterio(
			Jugador example) {
		Predicate<Jugador> predicate = this.getCriterioTodas();
		if (example.getNombre() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorNombre(example.getNombre()));
		}
		if (example.getApodo() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorApodo(example.getApodo()));
		}
		if (example.getFechaDeNacimiento() != null) {
			predicate = new AndPredicate<Jugador>(predicate, this.getCriterioPorFechaDeNacimiento(example.getFechaDeNacimiento()));
		}
		return predicate;
	}

	private Predicate<Jugador> getCriterioPorNombre(String nombre) {
		return new Predicate<Jugador>() {
			@Override
			public boolean evaluate(Jugador jugador) {
				return jugador.getNombre().toLowerCase().equals(nombre.toLowerCase());
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
