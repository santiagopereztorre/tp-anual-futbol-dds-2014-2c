package utn.disenio.criterio;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriterioPromedioConjuntoTest {

	CriterioPromedioConjunto criterio;
	
	@Before
	public void setUp() throws Exception {
		criterio = new CriterioPromedioConjunto();
	}
	
	@Test
	public void notaAlumnoConCriterios()
	{
		Integer pesoAlumno = 7;
		Integer pesoParaRestar = 3;
		Integer pesoMaximo = 14;
		Criterio criterio1 = new CriterioReglaDeTres(pesoMaximo);
		Criterio criterio2 = new CriterioRestarDeNota(pesoParaRestar);
		criterio.addCriterio(criterio1);
		criterio.addCriterio(criterio2);
		
		Double notaAlumno = criterio.calcularNota(pesoAlumno);
		
		Assert.assertEquals("La nota promedio es 3.5 ya que es ((5+4)/2)", 4.5, notaAlumno, 0.01);
		
	}
	
	@Test
	public void notaAlumnoConUnSoloCriterio()
	{
		Integer pesoAlumno = 4;
		Integer pesoParaRestar = 1;
		Criterio criterio1 = new CriterioRestarDeNota(pesoParaRestar);
		criterio.addCriterio(criterio1);
		
		Double notaAlumno = criterio.calcularNota(pesoAlumno);
		
		Assert.assertEquals("La nota deberia ser la del unico criterio", 3.0, notaAlumno, 0.01);
	}
	
	@Test (expected = NoSuchElementException.class)
	public void notaAlumnoSinCriterios()
	{
		Integer pesoAlumno = 6;
		
		Double notaAlumno = criterio.calcularNota(pesoAlumno);
	}
}
