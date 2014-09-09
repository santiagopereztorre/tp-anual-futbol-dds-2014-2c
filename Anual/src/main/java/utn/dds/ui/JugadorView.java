package utn.dds.ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import utn.dds.ui.JugadorViewModel;
import utn.dds.jugador.Jugador;


public class JugadorView extends MainWindow<JugadorViewModel> {

	private static final long serialVersionUID = 1L;

	public JugadorView() {
	    super(new JugadorViewModel(new Jugador()));
	  }
	
	@Override
	public void createContents(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

}
