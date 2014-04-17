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
	public Integer getPesoFinal() {
		if (this.respuestaAlumno == this.respuestaCorrecta) return this.peso;
		else return 0;
	}

}
