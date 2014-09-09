package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.MainWindow;

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
		RadioSelector<String> radioSelectorCriterios = new RadioSelector<>(mainPanel);
		radioSelectorCriterios.setWidth(300);
		radioSelectorCriterios.setHeigth(30);
		radioSelectorCriterios.bindValueToProperty("divisorSeleccionado");
		radioSelectorCriterios.bindItemsToProperty("divisores");
		
	//	new Label(mainPanel).setText("Criterio");
	//	new Label(mainPanel).bindValueToProperty("criterioSeleccionado");
		
		new Label(mainPanel).setText("Criterio de Ordenamiento de Jugadores");
		RadioSelector<String> radioSelectorOrdenamiento = new RadioSelector<>(mainPanel);
		radioSelectorOrdenamiento.setWidth(300);
		radioSelectorOrdenamiento.bindValueToProperty("criterioSeleccionado");
		radioSelectorOrdenamiento.bindItemsToProperty("criterios");
		
	//	 new Label(mainPanel).setText("Ordenamiento");
	//	 new Label(mainPanel).bindValueToProperty("ordenamientoSeleccionado");
		
		new Button(mainPanel).setCaption("Generar equipos");
		
		new Label(mainPanel).setText("Resultado:");
		
		new Label(mainPanel).setText("Equipo 1:");
		new List<Jugador>(mainPanel).bindItemsToProperty("equipo1");
		
		new Label(mainPanel).setText("Equipo 2:");
		new List<Jugador>(mainPanel).bindItemsToProperty("equipo2");
		
		new Button(mainPanel)
			.setCaption("Confirmar equipos")
			.onClick(() -> getModelObject().armarEquipos());
		
	}
	
	public static void main(String[] args) {
		 new GenerarEquiposView().startApplication();
	}
}
