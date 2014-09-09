package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.ui.JugadorViewModel;
import utn.dds.jugador.Jugador;
import utn.dds.infraccion.*;

@SuppressWarnings("serial")
public class JugadorView extends Window<JugadorViewModel> {

	//private static final WindowOwner GenerarEquiposView = null;
	private WindowOwner winOwner;

	public JugadorView(Jugador unJugador, WindowOwner ventanaPadre)
	{
		super(ventanaPadre, new JugadorViewModel(unJugador));
		winOwner = ventanaPadre;
	}

	@Override
	public void createContents(Panel mainPanel)
	{
		setTitle("Visualizar Jugador");
		mainPanel.setLayout(new VerticalLayout());

		// Nombre
		new Label(mainPanel).setText("Nombre:");
		new Label(mainPanel).bindValueToProperty("nombre");

		// Apodo
		new Label(mainPanel).setText("Apodo:");
		new Label(mainPanel).bindValueToProperty("apodo");

		// Handicap
		new Label(mainPanel).setText("Handicap:");
		new Label(mainPanel).bindValueToProperty("handicap");

		// Promedio del ultimo partido
		new Label(mainPanel).setText("Promedio ultimo partido:");
		new Label(mainPanel).bindValueToProperty("promedioUltimoPartido");

		// Promedio de todos los partidos
		new Label(mainPanel).setText("Promedio todos los partidos:");
		new Label(mainPanel).bindValueToProperty("promedioGeneral");
		
		// Amigos
		new Label(mainPanel).setText("Amigos:");
		
		// Infracciones
		new Label(mainPanel).setText("Infracciones:");
		Table<Infraccion> table = new Table<Infraccion>(mainPanel, Infraccion.class); 
		table.setHeigth(200); 
		table.setWidth(300); 
		armarTablaInfracciones(table);
		table.bindItemsToProperty("infracciones");
		
		// Cant partidos jugados
		new Label(mainPanel).setText("Cantidad de partidos:");
		new Label(mainPanel).bindValueToProperty("cantidadPartidosJugados");
	}
	
	void armarTablaInfracciones(Table<Infraccion> tabla)
	{
		new Column<Infraccion>(tabla)
			.setTitle("Fecha")
			.setFixedSize(100);

		new Column<Infraccion>(tabla)
			.setTitle("Motivo")
			.setFixedSize(100);
	}
	
	/*public static void main(String[] args)
	{
		Jugador unJugador = new Jugador();
		unJugador.setApodo("Jose");
		unJugador.setNombre("Roberto Carlo");
		unJugador.setHandicap(5);
		
		new JugadorView(unJugador).open();
	}*/

}
