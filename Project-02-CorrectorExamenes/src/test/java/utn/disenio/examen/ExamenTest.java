package utn.disenio.examen;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import utn.disenio.consigna.Consigna;
import utn.disenio.criterio.Criterio;
import utn.disenio.criterio.CriterioReglaDeTres;

public class ExamenTest 
{
	private static Examen unExamen;
	private static Integer pesoAlumno;
	private static Double notaAlumnoEsperada;	
	
	@BeforeClass
	public static void init()
	{
		List<Consigna> consignas = new ArrayList<Consigna>();
		
		Consigna mockConsigna1 = mock(Consigna.class);
		when(mockConsigna1.getPesoFinal()).thenReturn(5);
		consignas.add(mockConsigna1);
		
		Consigna mockConsigna2 = mock(Consigna.class);
		when(mockConsigna2.getPesoFinal()).thenReturn(0);
		consignas.add(mockConsigna2);
		
		Consigna mockConsigna3 = mock(Consigna.class);
		when(mockConsigna3.getPesoFinal()).thenReturn(3);
		consignas.add(mockConsigna3);
		
		Consigna mockConsigna4 = mock(Consigna.class);
		when(mockConsigna4.getPesoFinal()).thenReturn(0);
		consignas.add(mockConsigna4);
		
		Consigna mockConsigna5 = mock(Consigna.class);
		when(mockConsigna5.getPesoFinal()).thenReturn(0);
		consignas.add(mockConsigna5);
		
		pesoAlumno = 8;
		
		Criterio unCriterio = new CriterioReglaDeTres(20);
		
		notaAlumnoEsperada = 8.0 * 10 / 20;
		
		unExamen = new Examen(consignas, unCriterio);
	}
	
	@Test
	public void pesoDelAlumnoEsElCorrecto()
	{
		Assert.assertEquals("Peso del alumno es incorrecto", 
				pesoAlumno, unExamen.pesoDelAlumno());
	}
	
	@Test
	public void notaDeAlumnoEsCorrecta()
	{
		Assert.assertEquals("Nota del alumno no es correcta", 
				notaAlumnoEsperada, unExamen.notaFinal());
	}
}
