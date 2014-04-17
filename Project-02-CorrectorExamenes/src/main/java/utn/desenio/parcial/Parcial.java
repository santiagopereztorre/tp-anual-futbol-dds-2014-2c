package utn.desenio.parcial;

import java.util.ArrayList;

import utn.disenio.consigna.Consigna;

public class Parcial {


	private ArrayList<Consigna> consignas;
	
	public Parcial()
	{
		super();
		consignas = new ArrayList();
	}
	
	public Parcial(ArrayList<Consigna> consignas)
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
		Integer sumatoriaDePuntajes = 0;
		for(Consigna consigna : consignas)
		{
			sumatoriaDePuntajes += consigna.getPesoFinal();
		}
		return sumatoriaDePuntajes;
	}
}
