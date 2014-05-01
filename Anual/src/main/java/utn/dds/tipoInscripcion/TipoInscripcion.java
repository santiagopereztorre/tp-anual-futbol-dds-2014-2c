package utn.dds.tipoInscripcion;
import utn.dds.partido.Partido;

public interface TipoInscripcion {
	
	public boolean cumpleCondicion(Partido partido);
	
}
