package utn.dds.tipoInscripcion;

import utn.dds.partido.Partido;

public class Estandar extends TipoInscripcion{

	public boolean cumpleCondicion(Partido partido) {
		return true;
	}
}
