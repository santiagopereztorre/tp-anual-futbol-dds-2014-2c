package marcas;

public class Sarkany implements Marca {

	/**
	 * {@inheritDoc}
	 */
	public Double precioFinal(Double unPrecio) 
	{
		return unPrecio > 500 ? unPrecio * 1.35 : unPrecio * 1.1;
	}

}
