package utn.dds.ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.jugador.Jugador;

public class BuscarJugadorView  extends Window<BuscarJugadorViewModel>{

	public BuscarJugadorView(WindowOwner ventanaPadre, BuscarJugadorViewModel unJugador) {
		super(ventanaPadre, unJugador);
		winOwner = ventanaPadre;
	}

	private static final long serialVersionUID = 1L;
	private WindowOwner winOwner;
	
	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Buscar jugador");
		
	}

}
