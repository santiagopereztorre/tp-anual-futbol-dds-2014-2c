package utn.dds.tipoInscripcion;

import java.util.function.Predicate;

import utn.dds.partido.Partido;

public class Condicional implements TipoInscripcion{
	
	private Predicate<Partido> condicion;
	
	public Condicional(){
		this((x -> true));
	}
	
	public Condicional(Predicate<Partido> cond){
		condicion = cond;
	}
	
	public Predicate<Partido> getCondicion() {
		return condicion;
	}

	public void setCondicion(Predicate<Partido> condicion) {
		this.condicion = condicion;
	}
	
	public boolean cumpleCondicion(Partido partido) {
		return this.condicion.test(partido);
	}
	
}
