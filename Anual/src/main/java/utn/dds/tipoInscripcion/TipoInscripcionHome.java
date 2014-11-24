package utn.dds.tipoInscripcion;

import java.util.List;

import javax.persistence.Query;

import utn.dds.db.EntityManagerHelper;
import utn.dds.jugador.JugadorHome;

public class TipoInscripcionHome {
	
	private static TipoInscripcionHome instancia;
	
	public static TipoInscripcionHome getInstancia() {
		if (instancia == null) {
			instancia = new TipoInscripcionHome();
		}
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoInscripcion> getTiposInscripcion()
	{
		Query queryTipos = EntityManagerHelper.createQuery("from TipoInscripcion");
		return queryTipos.getResultList();
	}

}
