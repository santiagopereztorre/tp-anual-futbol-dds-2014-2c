package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.MainWindow;

import utn.dds.partido.Partido;

public class GenerarEquiposView extends MainWindow<GenerarEquiposViewModel> {

	public GenerarEquiposView() {
		super(new GenerarEquiposViewModel(new Partido()));
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Generar equipos");
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setWidth(400);

		new Label(mainPanel).setText("Criterio de Seleccion de Jugadores");
		RadioSelector<String> radioSelectorCriterios = new RadioSelector<>(mainPanel);
		radioSelectorCriterios.setWidth(300);
		radioSelectorCriterios.setHeigth(30);
		radioSelectorCriterios.bindValueToProperty("criterioSeleccionado");
		radioSelectorCriterios.bindItemsToProperty("criterios");
		
	//	new Label(mainPanel).setText("Criterio");
	//	new Label(mainPanel).bindValueToProperty("criterioSeleccionado");
		
		new Label(mainPanel).setText("Criterio de Ordenamiento de Jugadores");
		RadioSelector<String> radioSelectorOrdenamiento = new RadioSelector<>(mainPanel);
		radioSelectorOrdenamiento.setWidth(300);
		radioSelectorOrdenamiento.bindValueToProperty("ordenamientoSeleccionado");
		radioSelectorOrdenamiento.bindItemsToProperty("ordenamientos");
		
	//	 new Label(mainPanel).setText("Ordenamiento");
	//	 new Label(mainPanel).bindValueToProperty("ordenamientoSeleccionado");
		
		new Button(mainPanel).setCaption("Generar equipos");
		
		new Label(mainPanel).setText("Resultado:");
		
		new Button(mainPanel).setCaption("Confirmar equipos");
		
		
	}
	
	public static void main(String[] args) {
		 new GenerarEquiposView().startApplication();
	}
}
