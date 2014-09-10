package utn.dds.ui;

import org.uqbar.arena.widgets.Container;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import utn.dds.infraccion.Infraccion;
import utn.dds.jugador.Jugador;

public class TablaJugadoresColoreados extends Table<Jugador>{

	public TablaJugadoresColoreados(Container container) {
		super(container);
	}

	public Table<Jugador> armarTabla(Panel mainPanel)
	{
		Table<Jugador> tabla = new Table<Jugador>(mainPanel, Jugador.class);
		
		tabla.setHeigth(200); 
		tabla.setWidth(300);
		
		new Column<Jugador>(tabla)
			.setTitle("Nombre")
			.setFixedSize(100)
			.bindContentsToProperty("nombre");
		
		new Column<Jugador>(tabla)
		.setTitle("Handicap")
		.setFixedSize(100)
		.bindContentsToProperty("handicap");
	//	.setBackground(()-> {if);
		
		
		
		return tabla;
	}
	private static final long serialVersionUID = 1L;

}
