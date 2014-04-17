package utn.diseno.criterio;

import junit.framework.Assert;

import org.junit.Test;

import utn.disenio.criterio.CriterioReglaDeTres;

public class CriterioTest {

	@Test
	public void CriterioReglaDeTresConValorMenorAlPesoAlumnoYMayorACero()
	{
		// Precondiciones
		Integer pesoAlumno = 12;
		CriterioReglaDeTres criterio = new CriterioReglaDeTres(2);
		
		// Accion
		Double notaFinal = criterio.calcularNota(pesoAlumno);
		
		// Postcondiciones
		Assert.assertEquals(10, notaFinal);
	}
}
