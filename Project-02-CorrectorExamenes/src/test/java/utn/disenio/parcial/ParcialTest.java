package utn.disenio.parcial;

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

public class ParcialTest 
{
	private static Parcial unParcial;
	private static Integer pesoAlumno;
	private static Double notaAlumnoEsperada;
	
	@BeforeClass
	public static void init()
	{
		List<Consigna> consignas = new ArrayList<Consigna>();
		consignas.add(new Pregunta(5, "si", "si"));
		consignas.add(new Pregunta(4, "si", "no"));
		consignas.add(new VoF(3, true, true));
		consignas.add(new MultipleChoice(new ArrayList<String>(), 4, 1, 2));
		consignas.add(new VoF(4, false, true));
		
		pesoAlumno = 8;
		
		Criterio unCriterio = new CriterioReglaDeTres(20);
		
		notaAlumnoEsperada = 8.0 * 10 / 20;
		
		unParcial = new Parcial(consignas, unCriterio);
	}
	
	@Test
	public void pesoDelAlumnoEsElCorrecto()
	{
		Assert.assertEquals("Peso del alumno es incorrecto", 
				pesoAlumno, unParcial.pesoDelAlumno());
	}
	
	@Test
	public void notaDeAlumnoEsCorrecta()
	{
		Assert.assertEquals("Nota del alumno no es correcta", 
				notaAlumnoEsperada, unParcial.notaFinal());
	}
}
