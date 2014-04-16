package utn.disenio.criterio;

import java.util.Hashtable;

public class CriterioUsandoTabla implements Criterio{
	
	private Hashtable tablaDeNotas;
	
	public CriterioUsandoTabla(Hashtable tablaDeNotas)
	{
		this.tablaDeNotas = tablaDeNotas;
	}
	
	public Integer calcularNota(Integer pesoAlumno)
	{
		return (Integer) tablaDeNotas.get(pesoAlumno);
	}

}
