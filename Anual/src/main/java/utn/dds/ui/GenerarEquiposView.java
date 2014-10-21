package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;

import utn.dds.criterios.Criterio;
import utn.dds.divisores.Divisor;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;
import utn.dds.partido.PartidoHome;

@SuppressWarnings("serial")
public class GenerarEquiposView extends MainWindow<GenerarEquiposViewModel> {

	public GenerarEquiposView() {
		super(new GenerarEquiposViewModel(new Partido()));
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.getModelObject().setWo(this);
		
		setTitle("Generar equipos");
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setWidth(400);
		
		new Label(mainPanel).setText("Criterio de Seleccion de Jugadores");
		RadioSelector<Divisor> radioSelectorDivisores = new RadioSelector<>(mainPanel);
		radioSelectorDivisores.setWidth(300);
		radioSelectorDivisores.bindValueToProperty("divisorSeleccionado");
		radioSelectorDivisores.bindItemsToProperty("divisores");

		new Label(mainPanel).setText("Criterio de Ordenamiento de Jugadores");
		RadioSelector<Criterio> radioSelectorCriteriosOrdenamiento = new RadioSelector<>(mainPanel);
		radioSelectorCriteriosOrdenamiento.setWidth(300);
		radioSelectorCriteriosOrdenamiento.bindValueToProperty("criterioSeleccionado");
		radioSelectorCriteriosOrdenamiento.bindItemsToProperty("criterios");
		
		TextBox parametro = new TextBox(mainPanel);
		parametro.bindValueToProperty("parametroN");
		parametro.bindVisibleToProperty("visibilidadParametroN");
		
		new Button(mainPanel)
			.setCaption("Generar equipos")
			.onClick(() -> getModelObject().armarEquipos());
		
		new Label(mainPanel).setText("Resultado:");
		
		new Label(mainPanel).setText("Equipo 1:");
		Table<Jugador> tablita = TablaJugadoresColoreados.armarTabla(mainPanel);
		tablita.bindItemsToProperty("equipo1");
		tablita.bindValueToProperty("jugadorSeleccionado");
		tablita.setHeigth(120);
		
		new Label(mainPanel).setText("Equipo 2:");
		Table<Jugador> tablita2 = TablaJugadoresColoreados.armarTabla(mainPanel);
		tablita2.bindItemsToProperty("equipo2");
		tablita2.bindValueToProperty("jugadorSeleccionado");
		tablita2.setHeigth(120);
		
		new Button(mainPanel).setCaption("Buscar jugador").onClick(
				()-> new BuscarJugadorView(this, new BuscarJugadorViewModel()).open());

		new Button(mainPanel).setCaption("Confirmar equipos").onClick(
				()-> getModelObject().confirmarEquipos());
	}
	
	public static void main(String[] args) {
		 new GenerarEquiposView().startApplication();
		 java.util.List<Partido> listaDePartidos = PartidoHome.getInstancia().allInstances();
		 listaDePartidos.forEach(System.out::println);
	}
}
