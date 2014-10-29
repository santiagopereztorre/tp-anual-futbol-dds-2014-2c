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

	public void setId_partido(int id_partido) {
		this.id_partido = id_partido;
	}

	public int getId_partido() {
		EntityManagerHelper.beginTransaction();
		Query query = EntityManagerHelper.createQuery("from Partido");
		List<Partido> partidos = query.getResultList();
		id_partido = partidos.get(partidos.size()).getId();
		EntityManagerHelper.commit();
		return id_partido;
	}
	
	
}
