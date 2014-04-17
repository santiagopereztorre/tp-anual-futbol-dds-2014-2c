package utn.disenio.criterio;

import org.junit.Assert;
import org.junit.Test;

import utn.disenio.criterio.CriterioReglaDeTres;

public class CriterioTest {

	@Test
	public void CriterioReglaDeTresConValorMenorAlPesoAlumnoYMayorACero()
	{
		// Precondiciones
		Integer pesoAlumno = 8;
		CriterioReglaDeTres criterio = new CriterioReglaDeTres(10);
		
		// Accion
		Double notaFinal = criterio.calcularNota(pesoAlumno);
		
		// Postcondiciones
		Assert.assertEquals(8.0, notaFinal, 1.0);
	}
	
}
