package utn.diseno.criterio;

import junit.framework.Assert;
import junit.framework.TestCase;
import utn.disenio.criterio.CriterioReglaDeTres;

public class CriterioTest extends TestCase {

	
	public void testCriterioReglaDeTresConValorMenorAlPesoAlumnoYMayorACero()
	{
		// Precondiciones
		Integer pesoAlumno = 8;
		CriterioReglaDeTres criterio = new CriterioReglaDeTres(10);
		
		// Accion
		Double notaFinal = criterio.calcularNota(pesoAlumno);
		
		// Postcondiciones
		Assert.assertEquals(8.0, notaFinal);
	}
	
}
