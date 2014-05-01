package utn.disenio.criterio;

import utn.disenio.exceptions.PesoAlumnoNoValidoException;

public interface Criterio {
	
	public Double calcularNota(Integer pesoAlumno) throws PesoAlumnoNoValidoException;
}
