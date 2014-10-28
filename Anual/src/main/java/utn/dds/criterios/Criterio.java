package utn.dds.criterios;


import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import utn.dds.jugador.Jugador;

@Entity
@Table(name = "Criterios")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "nombre_criterio")
public abstract class Criterio {
	public Integer calificar(Jugador unJugador){
		return 0;
	}
}
