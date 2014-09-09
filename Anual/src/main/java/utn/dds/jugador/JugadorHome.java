package utn.dds.jugador;

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
		return predicate;
	}

	private Predicate<Jugador> getCriterioPorNombre(String nombre) {
		return new Predicate<Jugador>() {

			@Override
			public boolean evaluate(Jugador jugador) {
				if (jugador.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					return true;
				} else {
					return false;
				}
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
