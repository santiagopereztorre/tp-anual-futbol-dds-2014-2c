package utn.dds.ui;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.jugador.Jugador;

@SuppressWarnings("serial")
public class VerPartidoView extends Window<VerPartidoViewModel>{

	public VerPartidoView(WindowOwner owner, VerPartidoViewModel model) {
		super(owner, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContents(Panel mainPanel) {
		// TODO Auto-generated method stub
		setTitle("Visualizar ultimo partido");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panelPartido = new Panel(mainPanel);
		panelPartido.setLayout(new HorizontalLayout());
		
		new Label(panelPartido).setText("Partido: ");
		Label labelID = new Label(panelPartido);
		labelID.setWidth(100).bindValueToProperty("id_partido");
		labelID.setWidth(20);
		
		new Label(mainPanel).setText("Equipo 1:");
		Table<Jugador> tablita1 = TablaJugadoresColoreados.armarTabla(mainPanel);
		tablita1.bindItemsToProperty("equipo1");
		tablita1.setHeigth(140);
		tablita1.setWidth(400);
		
		new Label(mainPanel).setText("Equipo 2:");
		Table<Jugador> tablita2 = TablaJugadoresColoreados.armarTabla(mainPanel);
		tablita2.bindItemsToProperty("equipo2");
		tablita2.setHeigth(140);
		tablita2.setWidth(400);
	}

}
