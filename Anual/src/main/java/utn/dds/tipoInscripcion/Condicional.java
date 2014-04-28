package utn.dds.tipoInscripcion;

import utn.dds.partido.Partido;

public class Condicional extends TipoInscripcion{
	
	public boolean cumpleCondicion(Partido partido) {
		return condicion.condition(partido);
	}
	
}
