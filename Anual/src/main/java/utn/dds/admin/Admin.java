package utn.dds.admin;

import java.util.ArrayList;
import java.util.List;

public class Admin 
{
	private List<Sugerencia> sugerencias;
	
	private static Admin instancia = null;
	
	public Admin()

	{
		sugerencias = new ArrayList<Sugerencia>();
	}
	
	public List<Sugerencia> getSugerencias(){
		return sugerencias;
	}
	
	public static Admin getInstancia()
	{
		if(instancia == null)
			instancia = new Admin();
		
		return instancia;
	}
	
	public void sugerir(Sugerencia unaSugerencia)
	{
		sugerencias.add(unaSugerencia);
	}
	
	public void aceptarSugerencia(Sugerencia unaSugerencia)
	{
		unaSugerencia.aceptar();
		sugerencias.remove(unaSugerencia);
	}
	
	public void rechazarSugerencia(Sugerencia unaSugerencia, String motivo)
	{
		unaSugerencia.rechazar(motivo);
		sugerencias.remove(unaSugerencia);
	}
}
