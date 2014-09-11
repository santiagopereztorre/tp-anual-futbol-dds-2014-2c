package utn.dds.ui;

import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.delimitadores.Delimitador;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;

@SuppressWarnings("serial")
public class BuscarJugadorView  extends Window<BuscarJugadorViewModel>{

	@SuppressWarnings("unused")
	private WindowOwner winOwner;

	public BuscarJugadorView(WindowOwner ventanaPadre, BuscarJugadorViewModel unJugador) {
		super(ventanaPadre, unJugador);
		winOwner = ventanaPadre;
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Buscar jugador");
		
		new Label(mainPanel).setText("Nombre comienza por: ");
		new TextBox(mainPanel).bindValueToProperty("nombre");
		
		new Label(mainPanel).setText("Apodo contiene: ");
		new TextBox(mainPanel).bindValueToProperty("apodo");
		
		new Label(mainPanel).setText("Fecha de nacimiento anterior a (dd/mm/aaaa): ");
//		new TextBox(mainPanel);
		
		new Label(mainPanel).setText("Handicap");
		Selector<Delimitador> selectorHandicap = new Selector<Delimitador>(mainPanel);
		selectorHandicap.bindItemsToProperty("delimitadores");
		selectorHandicap.bindValueToProperty("handicapDelimitador");
		new TextBox(mainPanel).bindValueToProperty("handicap");
		
		new Label(mainPanel).setText("Promedio del ultimo partido");
		Selector<Delimitador> selectorPromedio = new Selector<Delimitador>(mainPanel);
		selectorPromedio.bindItemsToProperty("delimitadores");
		selectorPromedio.bindValueToProperty("promedioDelimitador");
		new TextBox(mainPanel).bindValueToProperty("promedio");
		
		new Label(mainPanel).setText("Tuvo infracciones: ");
		new CheckBox(mainPanel).bindValueToProperty("infracciones");
		
		Table<Jugador> table = TablaJugadoresColoreados.armarTabla(mainPanel);
		table.bindItemsToProperty("jugadores");
	}
}
