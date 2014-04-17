package utn.disenio.criterio;

import static org.junit.Assert.*;

import java.util.Hashtable;

import static org.hamcrest.number.OrderingComparison.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriterioUsandoTablaTest {

	Hashtable<Integer, Integer> tablaDeNotas;
	Criterio criterio;
	
	@Before
	public void setUp() throws Exception {
		tablaDeNotas = new Hashtable<Integer, Integer>();
		tablaDeNotas.put(16, 10);
		tablaDeNotas.put(14, 9);
		tablaDeNotas.put(10, 6);
		
		criterio = new CriterioUsandoTabla(tablaDeNotas);
	}
	
	@Test
	public void notaAlumnoDentroDeLaTabla()
	{
		Integer pesoAlumno = 16;
		
		Double notaAlumno = criterio.calcularNota(pesoAlumno);
		
		Assert.assertEquals("La nota del alumno es la esperada", 10.0, notaAlumno, 0.01);
	}
	
	@Test (expected = NullPointerException.class)
	public void notaAlumnoNoSeEncuentraEnTabla()
	{
		Integer pesoAlumno = 100;
		
		criterio.calcularNota(pesoAlumno);
	}
	

}
