package utn.disenio.criterio;

public class CriterioReglaDeTres implements Criterio{

	private Integer pesoMaximo;
	
	public CriterioReglaDeTres(Integer pesoMaximo)
	{
		this.pesoMaximo = pesoMaximo;
	}
	
	@Override
	public Integer calcularNota(Integer pesoAlumno) 
	{
		return pesoMaximo * 10 / pesoAlumno;
	}

}
