package tiposprenda;

public class Sombrero implements TipoPrenda 
{
	private double coefMet;
	
	public double getCoefMet() {
		return coefMet;
	}


	public void setCoefMet(double coefMet) {
		this.coefMet = coefMet;
	}


	/**
	 * @inheritDoc
	 */
	public Double precioBase() 
	{
		return 150 + getCoefMet();
	}

}
