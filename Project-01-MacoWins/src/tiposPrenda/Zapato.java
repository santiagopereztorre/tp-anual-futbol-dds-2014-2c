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
		return 400.0 + 5 * getTalle();
	}

}
