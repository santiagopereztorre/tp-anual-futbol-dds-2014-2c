package utn.dds.partido.exceptions;

@SuppressWarnings("serial")
public class NoHayVacantesException extends RuntimeException {

	public NoHayVacantesException(String message){
        super(message);
	}
}
