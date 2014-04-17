package utn.disenio.criterio;

import java.util.ArrayList;
import java.util.List;


public class CriterioNotaMasAltaConjunto implements Criterio {
	private List<Criterio> criterios;
	
	public CriterioNotaMasAltaConjunto()
	{
		this.criterios = new ArrayList<Criterio>();
	}
	
	public CriterioNotaMasAltaConjunto(List<Criterio> criterios)
	{
		super();
		this.criterios = criterios;
	}
	
	public void addCriterio(Criterio criterioNuevo)
	{
		criterios.add(criterioNuevo);
	}

	
	public Double calcularNota(Integer pesoAlumno) 
	{
		return criterios.stream()
				.mapToDouble(criterio -> criterio.calcularNota(pesoAlumno))
				.max()
				.getAsDouble();
	}
}
