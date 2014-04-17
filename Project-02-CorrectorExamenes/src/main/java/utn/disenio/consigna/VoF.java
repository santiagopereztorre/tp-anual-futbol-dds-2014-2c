package utn.disenio.consigna;

public class VoF implements Consigna {

	private Integer peso;
	private boolean respuestaCorrecta;
	private boolean respuestaAlumno;
	
	public VoF(boolean unaRespuestaCorrecta, boolean unaRespuestaAlumno, Integer unPeso){
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
		return esCorrectaLaRta()?this.peso:0;
	}



}
