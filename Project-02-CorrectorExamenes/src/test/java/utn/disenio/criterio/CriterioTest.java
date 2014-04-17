package utn.disenio.criterio;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.number.OrderingComparison.*;

import utn.disenio.criterio.CriterioReglaDeTres;

public class CriterioTest {

	@Test
	public void notaAlumnoMayorIgual1MenorIgual10CriterioReglaDeTres()
	{
		// Precondiciones
		Integer pesoAlumno = 8;
		CriterioReglaDeTres criterio = new CriterioReglaDeTres(10);
		
		// Accion
		Double notaFinal = criterio.calcularNota(pesoAlumno);
		
		// Postcondiciones
		// Compara la nota
		Assert.assertEquals("Nota de alumno distinta a la esperada", 8.0, notaFinal, 1.0);
		
		// La nota mayor o igual a 1 siempre
		Assert.assertThat("Nota alumno igual o inferior a cero", pesoAlumno, greaterThan(1));
		
		// Nota menor o igual a 10 siempre
		Assert.assertThat("Nota alumno mayor a 10", pesoAlumno, lessThan(10));
	}
	
}
