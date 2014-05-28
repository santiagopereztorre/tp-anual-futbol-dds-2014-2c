package utn.dds.observers;

import utn.dds.mail.Mail;
import utn.dds.sender.Sender;

public class ObsAdmBaja10Jugadores implements ObsPartidoDescompleto {

	Sender sistemaDeMensajes;
	String mailAdmin;
	
	public ObsAdmBaja10Jugadores(Sender sistemaDeMensajes, String mailAdmin)
	{
		this.sistemaDeMensajes = sistemaDeMensajes;
		this.mailAdmin = mailAdmin;
	}
	
	@Override
	public void descompleto() 
	{
		Mail mail = new Mail(mailAdmin, "sistema-mail", "Ya no hay 10 jugadores");
		sistemaDeMensajes.enviar(mail);
	}

}
