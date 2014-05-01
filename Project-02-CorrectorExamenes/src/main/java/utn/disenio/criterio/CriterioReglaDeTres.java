package utn.disenio.criterio;

import utn.disenio.exceptions.PesoAlumnoNoValidoException;

public class CriterioReglaDeTres implements Criterio{

	private Integer pesoMaximo;
	
	public CriterioReglaDeTres(Integer pesoMaximo)
	{
		this.pesoMaximo = pesoMaximo;
	}
	
	@Override
	public Double calcularNota(Integer pesoAlumno) throws PesoAlumnoNoValidoException 
	{
		Double nota = (double) pesoAlumno * 10 / pesoMaximo;
		if (nota > 10)
		{
			throw new PesoAlumnoNoValidoException();
		}
		if (nota < 1)
		{
			throw new PesoAlumnoNoValidoException();
		}
		return nota;
	}

}
