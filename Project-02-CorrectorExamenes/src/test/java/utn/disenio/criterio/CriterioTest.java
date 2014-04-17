package utn.disenio.criterio;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;
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
