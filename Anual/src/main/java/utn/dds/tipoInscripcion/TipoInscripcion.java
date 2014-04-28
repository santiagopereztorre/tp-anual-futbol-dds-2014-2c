package utn.dds.tipoInscripcion;

import utn.dds.partido.Partido;

public abstract class TipoInscripcion {
	
    public interface Condicion { boolean condition(Partido x); }
    
	public Condicion condicion = x -> true;
	
	public abstract boolean cumpleCondicion(Partido partido);
}
