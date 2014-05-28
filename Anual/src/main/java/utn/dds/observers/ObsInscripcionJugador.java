package utn.dds.observers;

import java.util.List;

import utn.dds.jugador.Jugador;
import utn.dds.mail.Mail;
import utn.dds.sender.Sender;

public class ObsInscripcionJugador implements ObsPartidoInscripcion {

	Sender sistemaDeMensajes;
	
	public ObsInscripcionJugador(Sender sender)
	{
		this.sistemaDeMensajes = sender;
	}
	
	@Override
	public void notificar(List<Jugador> amigos, Jugador jugador) 
	{
		for (Jugador amigo : amigos)
		{
			Mail mail = new Mail(amigo.getMail(), jugador.getMail(), "Me inscribi");
			sistemaDeMensajes.enviar(mail);
		}
		
	}


}
