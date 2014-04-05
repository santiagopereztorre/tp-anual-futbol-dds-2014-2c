package marcas;

public class Armani implements Marca 
{

	/**
	 * {@inheritDoc}
	 */
	public Double precioFinal(Double unPrecio) 
	{
		return unPrecio * 1.65;
	}

}
