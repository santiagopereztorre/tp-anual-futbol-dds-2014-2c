package utn.disenio.consigna;

public class Pregunta implements Consigna {
	
	private Integer peso;
	private String respuestaCorrecta;
	private String respuestaAlumno;
	
	public Pregunta(Integer unPeso, String unaRespuestaCorrecta, String unaRespuestaAlumno){
		this.peso = unPeso;
		this.respuestaCorrecta = unaRespuestaCorrecta;
		this.respuestaAlumno = unaRespuestaAlumno;
	}
	
	@Override
	public boolean esCorrectaLaRta() {
		return (this.respuestaAlumno == this.respuestaCorrecta);
	}
	
	@Override
	public Integer getPesoFinal() 
	{
		return (esCorrectaLaRta())?this.peso:0;
	}

	

}
