package utn.dds.ui;

import java.util.List;

import javax.persistence.Query;

import org.uqbar.commons.utils.Observable;

import utn.dds.db.EntityManagerHelper;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

@Observable
public class VerPartidoViewModel {

	private int id_partido;
	private List<Jugador> equipo1;
	private List<Jugador> equipo2;

	public void setId_partido(int id_partido) {
		this.id_partido = id_partido;
	}

	public int getId_partido() {
		EntityManagerHelper.beginTransaction();
		
		Query query = EntityManagerHelper.createQuery("from Partido");
		List<Partido> partidos = query.getResultList();
		
		if(!partidos.isEmpty()){
			id_partido = partidos.get(partidos.size()-1).getId();
		}else{
			id_partido = -1;
		}
		
		EntityManagerHelper.commit();
		return id_partido;
	}
	
	public List<Jugador> getEquipo1() {
		EntityManagerHelper.beginTransaction();
		Query query = EntityManagerHelper.createQuery("select equipo1 from Partido p where p.id = ?1");
		query.setParameter(1,getId_partido());
		List<Jugador> jugadores = query.getResultList();
		setEquipo1(jugadores);
		EntityManagerHelper.commit();
		return equipo1;
	}

	public void setEquipo1(List<Jugador> equipo1) {
		this.equipo1 = equipo1;
	}

	public List<Jugador> getEquipo2() {
		EntityManagerHelper.beginTransaction();
		Query query = EntityManagerHelper.createQuery("select equipo2 from Partido p where p.id = ?1");
		query.setParameter(1,getId_partido());
		List<Jugador> jugadores = query.getResultList();
		setEquipo2(jugadores);
		EntityManagerHelper.commit();
		return equipo2;
	}

	public void setEquipo2(List<Jugador> equipo2) {
		this.equipo2 = equipo2;
	}
	
}
