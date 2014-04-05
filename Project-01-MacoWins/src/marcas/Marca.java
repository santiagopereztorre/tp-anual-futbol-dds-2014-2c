package marcas;

public interface Marca 
{
	/**
	 * Calcula el precio final de una prenda aplicando el coeficiente de marca
	 * @param unPrecio
	 * @return precio de la prenda con coeficiente de marca incluido
	 */
	public Double precioFinal(Double unPrecio);
}
