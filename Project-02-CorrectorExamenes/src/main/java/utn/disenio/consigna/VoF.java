package utn.disenio.consigna;

public class VoF implements Consigna {

	private Integer peso;
	private String respuestaCorrecta;
	private String respuestaAlumno;
	
	public VoF(Integer unPeso, String unaRespuestaCorrecta, String unaRespuestaAlumno){
		this.peso = unPeso;
		this.respuestaCorrecta = unaRespuestaCorrecta;
		this.respuestaAlumno = unaRespuestaAlumno;
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


}
