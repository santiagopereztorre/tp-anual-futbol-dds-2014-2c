package utn.dds.tipoInscripcion;

import utn.dds.partido.Partido;

public class Estandar implements TipoInscripcion{

	public boolean cumpleCondicion(Partido partido) {
		return true;
	}
	
}
