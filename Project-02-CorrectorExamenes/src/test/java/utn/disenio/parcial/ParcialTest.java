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
	@BeforeClass
	public void init()
	{
		List<Consigna> consignas = new ArrayList<Consigna>();
		consignas.add(new Pregunta(5, "si", "si"));
		consignas.add(new Pregunta(4, "si", "no"));
		consignas.add(new VoF(3, true, true));
		consignas.add(new MultipleChoice(new ArrayList<String>(), 4, 1, 2));
		consignas.add(new VoF(4, false, true));
		
		Criterio unCriterio = new CriterioReglaDeTres(20);
		
		Parcial unParcial = new Parcial(consignas, unCriterio);
	}
	
	
}
