package tiposPrenda;

public class Sombrero implements TipoPrenda 
{
	private Double coeficienteMetrosexuality;
	
	public Double getCoeficienteMetrosexuality() {
		return coeficienteMetrosexuality;
	}


	public void setCoeficienteMetrosexuality(Double coefMet) {
		this.coeficienteMetrosexuality = coefMet;
	}


	/**
	 * @inheritDoc
	 */
	public Double precioBase() 
	{
		return 150 + getCoeficienteMetrosexuality();
	}

}
