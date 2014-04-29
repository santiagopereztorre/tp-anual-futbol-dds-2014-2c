package utn.disenio.criterio;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.number.OrderingComparison.*;

import utn.disenio.criterio.CriterioReglaDeTres;

public class CriterioReglaDeTresTest {

	//TODO OBLIGATORIO Porque en un solo test? Si falla el test es facil saber por que falla??
	// Si falla en el primer assert sigue probando el resto o pierden esa posibilidad
	// de saber que falla en el 1 y en el 3 pero no en el 2??
	@Test
	public void notaAlumnoMayorIgual1MenorIgual10CriterioReglaDeTres()
	{
		// Precondiciones
		Integer pesoAlumno = 10;
		CriterioReglaDeTres criterio = new CriterioReglaDeTres(10);
		
		// Accion
		Double notaFinal = criterio.calcularNota(pesoAlumno);
		
		// Postcondiciones
		// Compara la nota
		Assert.assertEquals("Nota de alumno distinta a la esperada", 10.0, notaFinal, 1.0);
		
		// La nota mayor o igual a 1 siempre
		Assert.assertThat("Nota alumno igual o inferior a cero", pesoAlumno, greaterThanOrEqualTo(1));
		
		// Nota menor o igual a 10 siempre
		Assert.assertThat("Nota alumno mayor a 10", pesoAlumno, lessThanOrEqualTo(10));
	}
	
}
