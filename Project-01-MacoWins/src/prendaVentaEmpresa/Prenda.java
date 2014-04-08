package prendaVentaEmpresa;

import marcas.Marca;
import tiposOrigen.TipoOrigen;
import tiposPrenda.TipoPrenda;

public class Prenda {
	
	private Marca marca;
	private TipoPrenda tipoPrenda;
	private TipoOrigen tipoOrigen;
	private Empresa empresa;
	
	public Prenda (Marca unaMarca, TipoPrenda unTipoPrenda, TipoOrigen unTipoOrigen, Empresa unaEmpresa)
	{
		marca = unaMarca;
		tipoPrenda = unTipoPrenda;
		tipoOrigen = unTipoOrigen;
		empresa = unaEmpresa;		
	}
	
	public Marca getMarca(){
		return marca;
	}
	
	public TipoPrenda getTipoPrenda(){
		return tipoPrenda;
	}
	
	public TipoOrigen getTipoOrigen(){
		return tipoOrigen;
	}
	
	public Empresa getEmpresa(){
		return empresa;
	}
	
	public Double tasaImportacion(){
		return tipoOrigen.tasa();
	}
	
	/**
	 * Precio parcial de la prenda, sin incluir el Coeficiente de Marca
	 * @return
	 */
	public Double precioParcial()
	{
		return (empresa.getValorFijo() + tipoPrenda.precioBase()) * tasaImportacion();
	}
	
	/**
	 * Precio final de la prenda
	 * @return
	 */
	public Double precioFinal()
	{
		Double precioParcial = precioParcial();
		return precioParcial * marca.coeficiente(precioParcial);
	}
}
