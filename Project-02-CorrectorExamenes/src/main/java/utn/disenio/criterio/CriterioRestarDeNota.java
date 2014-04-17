package utn.disenio.criterio;

public class CriterioRestarDeNota implements Criterio{
	
	Integer constanteResta;
	
	public CriterioRestarDeNota(Integer constanteResta)
	{
		this.constanteResta = constanteResta;
	}
	
	public Double calcularNota(Integer pesoAlumno) 
	{	
		return (double) pesoAlumno - constanteResta;
	}
}
