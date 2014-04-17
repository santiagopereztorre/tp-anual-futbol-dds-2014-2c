package utn.disenio.criterio;

public class CriterioReglaDeTres implements Criterio{

	private Integer pesoMaximo;
	
	public CriterioReglaDeTres(Integer pesoMaximo)
	{
		this.pesoMaximo = pesoMaximo;
	}
	
	@Override
	public Double calcularNota(Integer pesoAlumno) 
	{
		return (double) pesoMaximo * 10 / pesoAlumno;
	}

}
