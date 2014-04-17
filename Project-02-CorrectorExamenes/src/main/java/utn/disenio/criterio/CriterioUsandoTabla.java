package utn.disenio.criterio;

import java.util.Hashtable;

public class CriterioUsandoTabla implements Criterio{
	
	private Hashtable<Integer, Integer> tablaDeNotas;
	
	public CriterioUsandoTabla(Hashtable<Integer, Integer> tablaDeNotas)
	{
		this.tablaDeNotas = tablaDeNotas;
	}
	
	public Double calcularNota(Integer pesoAlumno)
	{
		return (double) tablaDeNotas.get(pesoAlumno);
	}
}
