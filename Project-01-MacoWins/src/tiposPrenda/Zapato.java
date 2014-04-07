package tiposPrenda;

public class Zapato implements TipoPrenda 
{
	private int talle;	
	
	public int getTalle() {
		return talle;
	}

	public void setTalle(int talle) {
		this.talle = talle;
	}

	/**
	 * @inheritDoc
	 */
	public Double precioBase() 
	{
		return ((Integer)(400 + 5 * getTalle())).doubleValue();
	}

}
