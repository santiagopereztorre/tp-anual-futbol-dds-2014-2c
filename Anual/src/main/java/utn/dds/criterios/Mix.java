package utn.dds.criterios;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import utn.dds.jugador.Jugador;

@Entity
@DiscriminatorValue("Mix")
public class Mix extends Criterio{

	@OneToMany
	private List<Criterio> criterios;
	
	public Mix(){
		
	}
	
	public Mix (List<Criterio> criterios){
		this.criterios = criterios;
	}
	
	@Override
	public Integer calificar(Jugador unJugador) {
		Integer sumPuntajesCriterios = this.criterios.stream().mapToInt(x -> x.calificar(unJugador)).sum();
			
		return sumPuntajesCriterios / unJugador.cantidadCalificaciones();
	}
	
	public String toString(){
		return "Mixto";
	}
	
}
