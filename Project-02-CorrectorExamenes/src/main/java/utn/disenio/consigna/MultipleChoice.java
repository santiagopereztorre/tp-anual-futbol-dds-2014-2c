package utn.disenio.consigna;

public class MultipleChoice implements Consigna {

	private Integer peso;
	private String respuestaCorrecta;
	private String respuestaAlumno;
	private Integer opciones;
	
	public MultipleChoice(Integer unPeso, String unaRespuestaCorrecta, String unaRespuestaAlumno, Integer cantidadOpciones){
		this.peso = unPeso;
		this.respuestaCorrecta = unaRespuestaCorrecta;
		this.respuestaAlumno = unaRespuestaAlumno;
		this.opciones = cantidadOpciones;
	}
		
	public Integer getPeso() {
		return peso;
	}

	@Override
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	@Override
	public String getRespuestaAlumno() {
		return respuestaAlumno;
	}
	
	public Integer cantidadDeOpciones(){
		return opciones;
	}

}
