package utn.disenio.examen;

import java.util.ArrayList;
import java.util.List;

import utn.disenio.consigna.Consigna;
import utn.disenio.criterio.Criterio;

public class Examen {

	private Criterio criterio;
	private List<Consigna> consignas;
	
	
	// TODO que se gana haciendo distintos constructores segun el objeto que recibe??
	// sirve lo que se gana?? Que pierden?? Que pasa si se quiere hacer otro
	// constructor que tambien reciba un Criterio, pero es otro atributo??
	// Es consistente hacer un constructor por cada atributo?? es posible??
	
	public Examen(Criterio unCriterio)
	{
		super();
		consignas = new ArrayList<Consigna>();
		criterio = unCriterio;
	}
	
	public Examen(List<Consigna> consignas)
	{
		super();
		this.consignas = consignas;
	}
	
	public Examen(List<Consigna> consignas, Criterio unCriterio)
	{
		this.consignas = consignas;
		criterio = unCriterio;
	}
	
	public void addConsigna(Consigna consigna)
	{
		consignas.add(consigna);
	}

	public Integer pesoDelAlumno()
	{
		return consignas.stream()
				.mapToInt(consigna -> consigna.getPesoFinal())
				.sum();
	}
	
	public Double notaFinal()
	{
		return criterio.calcularNota(pesoDelAlumno());
	}
}
