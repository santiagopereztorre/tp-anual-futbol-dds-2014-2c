package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.Action;

import utn.dds.criterios.Criterio;
import utn.dds.divisores.Divisor;
import utn.dds.jugador.Jugador;
import utn.dds.partido.Partido;

@SuppressWarnings("serial")
public class GenerarEquiposView extends MainWindow<GenerarEquiposViewModel> {

	public GenerarEquiposView() {
		super(new GenerarEquiposViewModel(new Partido()));
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Generar equipos");
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setWidth(400);

		new Label(mainPanel).setText("Criterio de Seleccion de Jugadores");
		RadioSelector<Divisor> radioSelectorDivisores = new RadioSelector<>(mainPanel);
		radioSelectorDivisores.setWidth(300);
		radioSelectorDivisores.setHeigth(60);
		radioSelectorDivisores.bindValueToProperty("divisorSeleccionado");
		radioSelectorDivisores.bindItemsToProperty("divisores");

		//	new Label(mainPanel).setText("Criterio");
	//	new Label(mainPanel).bindValueToProperty("criterioSeleccionado");
		
		new Label(mainPanel).setText("Criterio de Ordenamiento de Jugadores");
		RadioSelector<Criterio> radioSelectorCriteriosOrdenamiento = new RadioSelector<>(mainPanel);
		radioSelectorCriteriosOrdenamiento.setWidth(300);
		radioSelectorCriteriosOrdenamiento.bindValueToProperty("criterioSeleccionado");
		radioSelectorCriteriosOrdenamiento.bindItemsToProperty("criterios");
		
	//	 new Label(mainPanel).setText("Ordenamiento");
	//	 new Label(mainPanel).bindValueToProperty("ordenamientoSeleccionado");
		
		new Button(mainPanel)
			.setCaption("Generar equipos")
			.onClick(() -> getModelObject().armarEquipos());
		
		new Label(mainPanel).setText("Resultado:");
		
		new Label(mainPanel).setText("Equipo 1:");
		new List<Jugador>(mainPanel).bindItemsToProperty("equipo1");
		
		new Label(mainPanel).setText("Equipo 2:");
		new List<Jugador>(mainPanel).bindItemsToProperty("equipo2");
		
		new Button(mainPanel).setCaption("Buscar jugador").onClick(()-> new BuscarJugadorView(this, new BuscarJugadorViewModel()).open());

		new Button(mainPanel).setCaption("Confirmar equipos");
			
		
	}
	
	public static void main(String[] args) {
		 new GenerarEquiposView().startApplication();
	}
}
