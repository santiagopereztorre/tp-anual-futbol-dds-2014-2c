package utn.dds.tipoInscripcion;
import utn.dds.partido.Partido;

public interface TipoInscripcion {
	
	
	/* Esto no me copa, ¿xq todos los tipos de inscripcion 
	 * 					deberian entender el metodo cumpleCondicion?
	 * Solo el condicional lo usa.
	 * Voto por meter un if, aunque no nos guste usar ifs.
	 *  Firma: Fer
	 */
	
	public boolean cumpleCondicion(Partido partido);
	
}
