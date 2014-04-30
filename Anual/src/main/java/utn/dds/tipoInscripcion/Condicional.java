package utn.dds.tipoInscripcion;

import java.util.function.Predicate;

import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

public class Condicional implements TipoInscripcion{
	
	//public Block condicion;
	private Predicate condicion;
	
	public Predicate getCondicion() {
		return condicion;
	}

	public void setCondicion(Predicate condicion) {
		this.condicion = condicion;
	}
	
	public boolean cumpleCondicion(Partido partido) {
		return this.condicion.test(partido); // bloque.call()
	}
	
}
