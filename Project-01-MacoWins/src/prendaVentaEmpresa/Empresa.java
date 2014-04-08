package prendaVentaEmpresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Empresa {
	
	private Double valorFijo;
	private List<Venta> ventas;
	
	public Empresa (Double valor)
	{
		valorFijo = valor;
		ventas = new ArrayList<Venta>();
	}
	
	public Double getValorFijo()
	{
		return valorFijo;
	}
	
	public void vender(Prenda unaPrenda, Integer unaCant)
	{
		ventas.add(new Venta(new Date(), unaPrenda, unaCant));
	}
	
	public Double gananciaTotal()
	{
		// SUM en Java 8
		return ventas.stream().mapToDouble(Venta::monto).sum();
	}
}

