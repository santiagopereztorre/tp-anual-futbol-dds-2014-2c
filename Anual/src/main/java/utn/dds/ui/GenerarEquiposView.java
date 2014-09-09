package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.MainWindow;

public class GenerarEquiposView extends MainWindow<GenerarEquiposViewModel> {

	public GenerarEquiposView(GenerarEquiposViewModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Generar equipos");
		mainPanel.setLayout(new VerticalLayout());
		
		new RadioSelector<>(mainPanel);
	}
	
}
