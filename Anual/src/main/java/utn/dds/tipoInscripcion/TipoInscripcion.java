package utn.dds.tipoInscripcion;
import utn.dds.partido.Partido;

public interface TipoInscripcion {
	
	
	/* Esto no me copa, ¿xq todos los tipos de inscripcion 
	 * 					deberian entender el metodo cumpleCondicion?
	 * Solo el condicional lo usa.
	 * Lo puse en otro branch
	 *  Firma: Fer
	 */
	
	public boolean cumpleCondicion(Partido partido);
	
}
