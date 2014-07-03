package ar.edu.futbol5.excepciones;

import java.lang.RuntimeException;

public class NoHaySolidariosException extends RuntimeException {

	public NoHaySolidariosException(String msg){
		super(msg);
	}	
	
}