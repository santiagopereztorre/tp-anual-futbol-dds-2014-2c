package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.MainWindow;

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
		
		new RadioSelector<>(mainPanel);
	}
	
	public static void main(String[] args) {
		 new GenerarEquiposView().startApplication();
	}
}
