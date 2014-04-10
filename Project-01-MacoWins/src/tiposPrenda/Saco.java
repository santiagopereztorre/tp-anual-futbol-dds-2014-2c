package tiposPrenda;

public class Saco implements TipoPrenda 
{
	private int cantidadBotones;

	public int getcantidadBotones() {
		return cantidadBotones;
	}

	public void setcantidadBotones(int cantBot) {
		this.cantidadBotones = cantBot;
	}

	/**
	 * @inheritDoc
	 */
	public Double precioBase() 
	{
		return 300.0 + 10 * getcantidadBotones();
	}

}
