package utn.disenio.criterio;

public class CriterioRestarDeNota implements Criterio{
	
	Integer constanteResta;
	
	public CriterioRestarDeNota(Integer constanteResta)
	{
		this.constanteResta = constanteResta;
	}
	
	public Double calcularNota(Integer pesoAlumno) 
	{	
		Double nota = (double) pesoAlumno - constanteResta;
		return (nota > 1)?nota:1.0;
	}
}
