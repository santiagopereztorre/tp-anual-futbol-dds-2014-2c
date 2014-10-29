package utn.dds.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class VerPartidoView extends Window<VerPartidoViewModel>{

	public VerPartidoView(WindowOwner owner, VerPartidoViewModel model) {
		super(owner, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContents(Panel mainPanel) {
		// TODO Auto-generated method stub
		setTitle("Visualizar ultimo partido");
		mainPanel.setLayout(new VerticalLayout());
	}

}
