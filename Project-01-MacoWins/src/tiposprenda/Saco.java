package tiposprenda;

public class Saco implements TipoPrenda 
{
	private int cantBot;

	public int getCantBot() {
		return cantBot;
	}

	public void setCantBot(int cantBot) {
		this.cantBot = cantBot;
	}

	/**
	 * @inheritDoc
	 */
	public Double precioBase() 
	{
		return ((Integer)(300 + 10 * getCantBot())).doubleValue();
	}

}
