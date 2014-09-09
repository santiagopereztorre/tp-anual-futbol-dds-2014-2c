package utn.dds.ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.ui.JugadorViewModel;
import utn.dds.jugador.Jugador;


public class JugadorView extends Window<JugadorViewModel> {

	private static final long serialVersionUID = 1L;
	private static final WindowOwner GenerarEquiposView = null;

	public JugadorView() {
	    super(GenerarEquiposView, new JugadorViewModel(new Jugador()));
	  }

	@Override
	public void createContents(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}
	


}
