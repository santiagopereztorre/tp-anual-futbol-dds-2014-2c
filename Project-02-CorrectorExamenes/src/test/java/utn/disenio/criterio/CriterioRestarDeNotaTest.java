package utn.disenio.criterio;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.number.OrderingComparison.*;
import utn.disenio.criterio.CriterioRestarDeNota;

public class CriterioRestarDeNotaTest 
{
	@Test
	public void notaAlumnoMayorOIgualA1()
	{
		Criterio criterio = new CriterioRestarDeNota(5);
		Integer pesoAlumno = 0;
		
		Assert.assertThat("Nota alumno menor a 1", 
				criterio.calcularNota(pesoAlumno), greaterThanOrEqualTo(1.0));
	}
	
	@Test
	public void notaAlumnoMenorOIgualA10()
	{
		Criterio criterio = new CriterioRestarDeNota(5);
		Integer pesoAlumno = 15;
		
		Assert.assertThat("Nota alumno mayor a 10", 
				criterio.calcularNota(pesoAlumno), lessThanOrEqualTo(10.0));
	}
	
	@Test
	public void notaAlumnoEsLaEsperada()
	{
		Criterio criterio = new CriterioRestarDeNota(5);
		Integer pesoAlumno = 14;
		
		Assert.assertEquals("La nota del alumno no es la esperada", 9.0, 
				criterio.calcularNota(pesoAlumno), 0.1);
	}
}
