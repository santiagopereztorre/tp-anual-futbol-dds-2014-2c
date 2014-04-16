package utn.disenio.criterio;

public class CriterioRestarDeNota implements Criterio{
	
	Integer pesoMaximo;
	
	public CriterioRestarDeNota(Integer pesoMaximo)
	{
		this.pesoMaximo = pesoMaximo;
	}
	
	public Integer calcularNota(Integer pesoAlumno) 
	{	
		return pesoMaximo - pesoAlumno;
	}
}
