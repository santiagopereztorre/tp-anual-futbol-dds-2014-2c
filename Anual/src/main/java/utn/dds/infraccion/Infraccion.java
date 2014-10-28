package utn.dds.infraccion;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.uqbar.commons.utils.Observable;

import utn.dds.persistentEntity.PersistentEntity;

@Observable
@Entity
@Table(name="Infracciones")
public class Infraccion extends PersistentEntity{
	
	@Column(name="motivo_infraccion")
	private String motivo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_infraccion")
	private Date fecha;
	
	public Infraccion(String motivo){
		setMotivo(motivo);
		setFecha(new Date());
	}

	public void setFecha(Date unaFecha) {
		fecha = unaFecha;
	}

	public void setMotivo(String unMotivo) {
		motivo = unMotivo;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public String getMotivo(){
		return motivo;
	}
	
}
