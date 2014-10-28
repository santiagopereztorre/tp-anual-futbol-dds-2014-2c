package utn.dds.tipoInscripcion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utn.dds.partido.Partido;

@Entity
@DiscriminatorValue("Solidaria")
public class Solidaria extends TipoInscripcion{

	public boolean cumpleCondicion(Partido partido) {
		return true;
	}
}
