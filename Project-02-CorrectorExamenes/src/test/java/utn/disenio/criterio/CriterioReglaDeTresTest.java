package utn.disenio.criterio;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.number.OrderingComparison.*;
import utn.disenio.criterio.CriterioReglaDeTres;
import utn.disenio.exceptions.PesoAlumnoNoValidoException;

public class CriterioReglaDeTresTest {

	//TODO OBLIGATORIO Porque en un solo test? Si falla el test es facil saber por que falla??
	// Si falla en el primer assert sigue probando el resto o pierden esa posibilidad
	// de saber que falla en el 1 y en el 3 pero no en el 2??
	@Test
	public void notaAlumnoCriterioReglaDeTresEsLaEsperada() throws PesoAlumnoNoValidoException
	{
		// Precondiciones
		Integer pesoAlumno = 6;
		Integer notaMaxima = 12;
		CriterioReglaDeTres criterio = new CriterioReglaDeTres(notaMaxima);
		Double notaEsperada = pesoAlumno * 10. / notaMaxima;
		
		// Accion
		Double notaFinal = criterio.calcularNota(pesoAlumno);
		
		// Postcondiciones
		Assert.assertEquals("Nota de alumno distinta a la esperada", notaEsperada, notaFinal, 1.0);
	}
	
}
