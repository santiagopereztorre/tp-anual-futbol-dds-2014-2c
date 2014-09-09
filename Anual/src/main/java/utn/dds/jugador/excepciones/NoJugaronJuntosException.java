package utn.dds.jugador.excepciones;

@SuppressWarnings("serial")
public class NoJugaronJuntosException extends RuntimeException {

	public NoJugaronJuntosException()
	{
		super();
	}

	public NoJugaronJuntosException(String message)
	{
		super(message);
	}
}
