package utn.dds.observers;

import utn.dds.mail.Mail;
import utn.dds.sender.Sender;

public class ObsAdm10Conf implements ObsPartidoCompleto {

	Sender sistemaDeMensajes;
	String mailAdmin;
	
	public ObsAdm10Conf(Sender sistemaDeMensajes, String mailAdmin)
	{
		this.sistemaDeMensajes = sistemaDeMensajes;
		this.mailAdmin = mailAdmin;
	}
	
	@Override
	public void completo() 
	{
		Mail mail = new Mail(mailAdmin, "sistema-mail", "Ya hay 10 jugadores");
		sistemaDeMensajes.enviar(mail);
	}

}
