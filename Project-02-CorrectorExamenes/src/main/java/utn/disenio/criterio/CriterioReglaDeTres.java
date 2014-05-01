package utn.disenio.criterio;

import utn.disenio.exceptions.PesoAlumnoNoValidoException;

public class CriterioReglaDeTres implements Criterio{

	private Integer pesoMaximo;
	
	public CriterioReglaDeTres(Integer pesoMaximo)
	{
		this.pesoMaximo = pesoMaximo;
	}
	
	@Override
	public Double calcularNota(Integer pesoAlumno)
	{
		return (double) pesoAlumno * 10 / pesoMaximo;
	}

}
