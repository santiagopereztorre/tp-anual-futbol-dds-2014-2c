package utn.dds.delimitadores;

public class Desde implements Delimitador{

	@Override
	public Boolean cumpleCondicion(Integer jugador, Integer example) {
		return jugador >= example;
	}

}
