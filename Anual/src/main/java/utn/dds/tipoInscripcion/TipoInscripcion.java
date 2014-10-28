package utn.dds.tipoInscripcion;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import utn.dds.partido.Partido;
import utn.dds.persistentEntity.PersistentEntity;

@Entity
@Table(name="Tipos_incripcion")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="nombre_tipo_inscripcion")
public abstract class TipoInscripcion  extends PersistentEntity{
	
	public boolean cumpleCondicion(Partido partido){
		return true;
	}
	
}
