package utn.disenio.criterio;

import java.util.List;


public class CriterioNotaMasAltaConjunto implements Criterio {
	private List<Criterio> criterios;
	
	public CriterioNotaMasAltaConjunto(List<Criterio> criterios)
	{
		super();
		this.criterios = criterios;
	}

	
	public Double calcularNota(Integer pesoAlumno) 
	{
		return criterios.stream()
				.mapToInt(criterio -> criterio.calcularNota(pesoAlumno))
				.max()
				.getAsInt();
	}
}
