package utn.dds.tipoInscripcion;

import utn.dds.partido.Partido;

public class Solidaria implements TipoInscripcion{

	public boolean cumpleCondicion(Partido partido) {
		return true;
	}
}
