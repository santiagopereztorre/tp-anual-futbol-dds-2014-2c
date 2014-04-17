package utn.desenio.parcial;

import java.util.ArrayList;
import java.util.List;

import utn.disenio.consigna.Consigna;

public class Parcial {


	private List<Consigna> consignas;
	
	public Parcial()
	{
		super();
		consignas = new ArrayList<Consigna>();
	}
	
	public Parcial(List<Consigna> consignas)
	{
		super();
		this.consignas = consignas;
	}
	
	public void addConsigna(Consigna consigna)
	{
		consignas.add(consigna);
	}

	public Integer puntajeDelParcial()
	{
		return consignas.stream()
				.mapToInt(consigna -> consigna.getPesoFinal())
				.sum();
	}
}
