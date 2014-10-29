package utn.dds.partido;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import utn.dds.jugador.Jugador;

public class PartidoHome extends CollectionBasedHome<Partido>{
	private static PartidoHome instancia;
	

	public Partido createExample() {
		return new Partido();
	}


	public Class<Partido> getEntityType() {
		return Partido.class;
	}
	

	protected Predicate<Partido> getCriterio(Partido example){
		return null;
		
	}
	
	public static PartidoHome getInstancia() {
		if (instancia == null) {
			instancia = new PartidoHome();
		}
		return instancia;
	}
}
