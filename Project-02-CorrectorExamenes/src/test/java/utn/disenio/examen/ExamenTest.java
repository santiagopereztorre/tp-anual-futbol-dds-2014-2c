package utn.disenio.examen;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import utn.disenio.consigna.Consigna;
import utn.disenio.consigna.MultipleChoice;
import utn.disenio.consigna.Pregunta;
import utn.disenio.consigna.VoF;
import utn.disenio.criterio.Criterio;
import utn.disenio.criterio.CriterioReglaDeTres;
import utn.disenio.examen.Examen;
import static org.mockito.Mockito.*;

public class ExamenTest 
{
	private static Examen unExamen;
	private static Integer pesoAlumno;
	private static Double notaAlumnoEsperada;
	
	//TODO OBLIGATORIO como test integrador esta buenisimo! pero si rompe que pasa?
	// falló parcial o VoF está devolviendo strings en vez de numeros (por ej)
	// que tan facil es encontrar la falla?? No les parece mejor hacer una
	// clase ficticia que respete la interfaz de Criterio y devuelva el valor
	// que querramos?? 
	// OJO EL TEST NO ESTA MAL pero aca estamos testeando todo a la vez
	// osea este test no es un test unitario, es un test integrador.
	// dejenlo, renombrelo y hagan un verdadero ParcialTest.java
	
	
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
