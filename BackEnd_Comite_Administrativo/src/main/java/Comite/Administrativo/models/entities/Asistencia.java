package Comite.Administrativo.models.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Asistencia")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_aistencia")
	private Integer idAsistencia;
	
	@Column(name="presente_asi")
	private Boolean presente;
	
	@Column(name="observacion_asi")
	private String observacion;
	
	@JoinColumn(name= "id_reunion", referencedColumnName = "id_reunion") //Se mapea con una clave foránea
	@ManyToOne
	private Reunion reuniones;
	
	@JoinColumn(name= "id_persona", nullable = false) 
	@OneToOne(fetch = FetchType.LAZY)
	 //Atrivuto representa la asociacion con la clase persona
	private Persona personas;
	
	
	public Asistencia() {
		super();
	}
	
	public Asistencia (Integer idAsistencia) {
		super();
		this.idAsistencia = idAsistencia;
	}

	public Integer getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Boolean getPresente() {
		return presente;
	}

	public void setPresente(Boolean presente) {
		this.presente = presente;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Reunion getReuniones() {
		return reuniones;
	}

	public void setReuniones(Reunion reuniones) {
		this.reuniones = reuniones;
	}

	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	


}