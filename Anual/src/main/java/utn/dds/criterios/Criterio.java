package utn.dds.criterios;


import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import utn.dds.jugador.Jugador;
import utn.dds.persistentEntity.PersistentEntity;

@Entity
@Table(name = "Criterios")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "nombre_criterio")
public abstract class Criterio extends PersistentEntity{
	public Integer calificar(Jugador unJugador){
		return 0;
	}
}
