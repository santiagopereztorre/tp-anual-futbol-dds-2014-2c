package utn.dds.delimitadores;

public class Hasta implements Delimitador {

	@Override
	public Boolean cumpleCondicion(Integer jugador, Integer example) {
		return jugador <= example;
	}
	
	@Override
	public String toString() {
		return "Hasta";
	}

}
