package marcas;

public class Sarkany implements Marca {

	/**
	 * {@inheritDoc}
	 */
	public Double coeficiente(Double unPrecio) 
	{
		return unPrecio > 500 ? 1.35 : 1.1;
	}

}
