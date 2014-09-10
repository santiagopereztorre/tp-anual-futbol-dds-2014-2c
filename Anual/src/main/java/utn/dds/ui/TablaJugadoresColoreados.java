package utn.dds.ui;

import java.awt.Color;

import org.uqbar.arena.widgets.Container;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import com.uqbar.commons.collections.Transformer;

import utn.dds.jugador.Jugador;

public class TablaJugadoresColoreados extends Table<Jugador>{

	public TablaJugadoresColoreados(Container container) {
		super(container);
	}

	public static Table<Jugador> armarTabla(Panel mainPanel)
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
		.bindContentsToProperty("handicap")
		.bindBackground("handicap", new Transformer<Integer, Color>() {
			@Override
			public Color transform(Integer hand) {
				if(hand > 8){
					return Color.BLUE;
				}else
				{
					return Color.WHITE;
				}
			}
		});
		
		return tabla;
	}
	private static final long serialVersionUID = 1L;

}
