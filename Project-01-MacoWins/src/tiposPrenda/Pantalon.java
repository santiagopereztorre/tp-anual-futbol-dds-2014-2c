package tiposPrenda;

public class Pantalon implements TipoPrenda 
{
	private int cmTela;
	
	
	public int getCmTela() {
		return cmTela;
	}


	public void setCmTela(int cmTela) {
		this.cmTela = cmTela;
	}


	/**
	 * @inheritDoc
	 */
	public Double precioBase() 
	{
		return  250.0 + cmTela;
	}
	
}
