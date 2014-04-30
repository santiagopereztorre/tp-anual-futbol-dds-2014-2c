package utn.dds.tipoInscripcion;

import java.util.function.Predicate;

import utn.dds.partido.Partido;

public class Condicional implements TipoInscripcion{
	
	//public Block condicion;
	private Predicate<Partido> condicion;
	
	public Predicate<Partido> getCondicion() {
		return condicion;
	}

	public void setCondicion(Predicate<Partido> condicion) {
		this.condicion = condicion;
	}
	
	public boolean cumpleCondicion(Partido partido) {
		return this.condicion.test(partido); // bloque.call()
	}
	
}
