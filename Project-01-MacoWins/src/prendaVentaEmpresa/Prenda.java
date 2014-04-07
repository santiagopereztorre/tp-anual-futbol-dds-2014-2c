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
	
	public Double precioParcial()
	{
		return (empresa.getValorFijo() + tipoPrenda.precioBase()) * tasaImportacion();
	}
	
	public Double precioFinal()
	{
		// ...
		return 4.21; // verdura provisoria solo para que compile
	}
}
