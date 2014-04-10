package workspace;

import marcas.Marca;
import marcas.Armani;
import marcas.Sarkany;

import prendaVentaEmpresa.Empresa;
import prendaVentaEmpresa.Venta;
import prendaVentaEmpresa.Prenda;

import tiposOrigen.TipoOrigen;
import tiposOrigen.Nacional;
import tiposOrigen.Importado;

import tiposPrenda.TipoPrenda;
import tiposPrenda.Camisa;
import tiposPrenda.Saco;
import tiposPrenda.Pantalon;
import tiposPrenda.Sombrero;
import tiposPrenda.Zapato;


public class Prueba {
	
	public static void main(String[] args) { 
		
		Empresa macowins = new Empresa(5.8);
		
		Marca armani = new Armani();
		Marca sarkany = new Sarkany();
		
		TipoOrigen nacional = new Nacional();
		TipoOrigen importado = new Importado();
		
		TipoPrenda camisa = new Camisa();
		TipoPrenda pantalon = new Pantalon();
		TipoPrenda saco = new Saco();
		TipoPrenda sombrero = new Sombrero();
		TipoPrenda zapato = new Zapato();
		
		Prenda camisita = new Prenda(armani, camisa, nacional, macowins);
		Prenda jean = new Prenda(armani, pantalon, importado, macowins);
		Prenda llantas = new Prenda(sarkany, zapato, nacional, macowins);
		
		macowins.vender(jean, 10);
		macowins.vender(llantas, 4);
		macowins.vender(camisita, 7);
		
		double gananciaDeEmpresa = macowins.gananciaTotal();
		
		System.out.println("La ganancia total de la empresa es $" + gananciaDeEmpresa );
		
	}
}
