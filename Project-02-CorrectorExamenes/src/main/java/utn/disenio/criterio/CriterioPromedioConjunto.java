package utn.disenio.criterio;

import java.util.List;

public class CriterioPromedioConjunto implements Criterio {

	private List<Criterio> criterios;
	
	public CriterioPromedioConjunto(List<Criterio> criterios)
	{
		super();
		this.criterios = criterios;
	}
	
	@Override
	public Double calcularNota(Integer pesoAlumno) {
		return null;
	}

}
