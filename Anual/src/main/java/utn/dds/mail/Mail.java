package utn.dds.mail;

public class Mail {
	
	String destinatario;
	String origen;
	String mensaje;

	public Mail(String destino, String origen, String mensaje)
	{
		this.destinatario = destino;
		this.origen = origen;
		this.mensaje = mensaje;
	}
	
}
