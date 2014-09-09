package utn.dds.ui;

import java.util.List;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;

@SuppressWarnings("serial")
public class BuscarJugadorView  extends Window<BuscarJugadorViewModel>{

	private WindowOwner winOwner;

	public BuscarJugadorView(WindowOwner ventanaPadre, BuscarJugadorViewModel unJugador) {
		super(ventanaPadre, unJugador);

		Jugador jugador = new Jugador();
		jugador.setNombre("santi");
		JugadorHome.getInstancia().create(jugador);
		
		winOwner = ventanaPadre;
	}

	
	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Buscar jugador");
		
		Jugador jugador = new Jugador();
		jugador.setNombre("santi");		
		List<Jugador> jugadores = JugadorHome.getInstancia().searchByExample(jugador);
		
		new Label(mainPanel).setText("Esta vacio: " + jugadores.isEmpty());
		new Label(mainPanel).setText("El nombre es: " + jugadores.get(0).getNombre());
	}

}
