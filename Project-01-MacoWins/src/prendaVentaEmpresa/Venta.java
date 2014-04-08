package prendaVentaEmpresa;

import java.util.Date;

public class Venta 
{
	private Date fecha;
	private Prenda prenda;
	private Integer cantidad;
	
	public Venta(Date fecha, Prenda prenda, Integer cantidad) 
	{
		this.fecha = fecha;
		this.prenda = prenda;
		this.cantidad = cantidad;
	}
	
	public Double monto()
	{
		return prenda.precioFinal() * cantidad;
	}
}
