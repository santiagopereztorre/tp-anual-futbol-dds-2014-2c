package utn.dds.jugador.excepciones;

@SuppressWarnings("serial")
public class NoEsAmigoException extends RuntimeException {
	
	public NoEsAmigoException()
	{
		super();
	}

	public NoEsAmigoException(String message)
	{
		super(message);
	}

}
