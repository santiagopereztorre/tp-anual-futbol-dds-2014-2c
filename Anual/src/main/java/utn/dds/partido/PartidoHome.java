package utn.dds.partido;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import utn.dds.db.EntityManagerHelper;
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
	
	@SuppressWarnings("unchecked")
	public List<Partido> getPartidos()
	{
		Query query = EntityManagerHelper.createQuery("from Partido");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private List<Jugador> getEquipoPorPartido(String equipo, Integer id)
	{
		Query query = EntityManagerHelper.createQuery("select "+ equipo +" from Partido p where p.id = ?1");
		query.setParameter(1,id);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jugador> getEquipo1PorPartido(Integer id)
	{
		return getEquipoPorPartido("equipo1", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jugador> getEquipo2PorPartido(Integer id)
	{
		return getEquipoPorPartido("equipo2", id);
	}
}
