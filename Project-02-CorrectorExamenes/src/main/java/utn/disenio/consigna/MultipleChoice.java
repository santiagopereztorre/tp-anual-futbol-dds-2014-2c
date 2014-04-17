package utn.disenio.consigna;

public class MultipleChoice implements Consigna {

	private Integer peso;
	private String respuestaCorrecta;
	private String respuestaAlumno;
	
	public MultipleChoice(Integer unPeso, String unaRespuestaCorrecta, String unaRespuestaAlumno, Integer cantidadOpciones){
		this.peso = unPeso;
		this.respuestaCorrecta = unaRespuestaCorrecta;
		this.respuestaAlumno = unaRespuestaAlumno;
	}

	@Override
	public Integer getPesoFinal() 
	{
		return (this.respuestaAlumno == this.respuestaCorrecta)?this.peso:0;
	}

}
