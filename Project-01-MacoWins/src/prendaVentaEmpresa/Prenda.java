package prendaVentaEmpresa;

public class Prenda {
	
	marcas.Marca marca;
	tiposPrenda.TipoPrenda tipoPrenda;
	tiposOrigen.TipoOrigen tipoOrigen;
	Empresa empresa;
	
	public Prenda (marcas.Marca unaMarca, tiposPrenda.TipoPrenda unTipoPrenda, tiposOrigen.TipoOrigen unTipoOrigen, Empresa unaEmpresa){
		marca = unaMarca;
		tipoPrenda = unTipoPrenda;
		tipoOrigen = unTipoOrigen;
		empresa = unaEmpresa;		
	}
	
	public marcas.Marca getMarca(){
		return marca;
	}
	
	public tiposPrenda.TipoPrenda getTipoPrenda(){
		return tipoPrenda;
	}
	
	public tiposOrigen.TipoOrigen getTipoOrigen(){
		return tipoOrigen;
	}
	
	public Empresa getEmpresa(){
		return empresa;
	}
	
	public Double tasaImportacion(){
		return tipoOrigen.tasa();
	}
	
	public Double precioParcial(){
		Double precio = (empresa.getValorFijo() + tipoPrenda.precioBase()) * tasaImportacion();
		return precio;
	}
	
	public Double precioFinal(){
		// ...
		return 4.21; // verdura provisoria solo para que compile
	}
}
