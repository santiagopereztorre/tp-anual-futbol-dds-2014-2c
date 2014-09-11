package utn.dds.ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;

@SuppressWarnings("serial")
public class BuscarJugadorView  extends Window<BuscarJugadorViewModel>{

	@SuppressWarnings("unused")
	private WindowOwner winOwner;

	public BuscarJugadorView(WindowOwner ventanaPadre, BuscarJugadorViewModel unJugador) {
		super(ventanaPadre, unJugador);
		
		Jugador jugador = new Jugador();
		jugador.setNombre("Santi");
		jugador.setApodo("Diego");
		jugador.setHandicap(5);
		JugadorHome.getInstancia().create(jugador);
		
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
		List<String> listaDeOpciones = new ArrayList<String>();
		listaDeOpciones.add("Desde");
		listaDeOpciones.add("Hasta");
		new Selector<String>(mainPanel).setContents(listaDeOpciones, "description").bindValueToProperty("handicapModificador");
		new TextBox(mainPanel).bindValueToProperty("handicap");
		
		new Label(mainPanel).setText("Promedio del ultimo partido");
		new Selector<String>(mainPanel).setContents(listaDeOpciones, "description").bindValueToProperty("promedioModificador");
		new TextBox(mainPanel).bindValueToProperty("promedio");
		
		new Label(mainPanel).setText("Tuvo infracciones: ");
		new CheckBox(mainPanel).bindValueToProperty("infracciones");
		
		Table<Jugador> table = TablaJugadoresColoreados.armarTabla(mainPanel);
		table.bindItemsToProperty("jugadores");
	}
}
