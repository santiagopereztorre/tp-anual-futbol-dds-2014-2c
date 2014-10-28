package utn.dds.divisores;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorConCalificacion;

@Entity
@Table(name = "Divisores")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "nombre_divisor")
public abstract class Divisor {


	void armarEquipos(List<Jugador> equipo1, List<Jugador> equipo2,
			List<JugadorConCalificacion> jugadoresCalificados){
		
	}
	
/*	
  	default public String toString(){
		return this.getClass().getSimpleName();
	} 
*/
	
}
