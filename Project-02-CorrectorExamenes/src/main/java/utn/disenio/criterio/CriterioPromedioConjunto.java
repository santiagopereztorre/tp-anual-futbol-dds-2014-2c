package utn.disenio.criterio;

import java.util.ArrayList;
import java.util.List;

public class CriterioPromedioConjunto implements Criterio {

	private List<Criterio> criterios;
	
	public CriterioPromedioConjunto()
	{
		super();
		criterios = new ArrayList<Criterio>();
	}
	
	public CriterioPromedioConjunto(List<Criterio> criterios)
	{
		super();
		this.criterios = criterios;
	}
	
	public void addCriterio(Criterio criterioNuevo)
	{
		criterios.add(criterioNuevo);
	}

	
	@Override
	public Double calcularNota(Integer pesoAlumno) 
	{
		return criterios.stream()
				.mapToDouble(criterio -> criterio.calcularNota(pesoAlumno))
				.average()
				.getAsDouble();
	}

}
