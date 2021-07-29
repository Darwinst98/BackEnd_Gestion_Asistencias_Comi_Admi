package Comite.Administrativo.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Reunion")
public class Reunion implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_reunion")
	private Integer idReunion;
	
	@Column(name="fecha_reu")
	private Calendar fecha;
	
	@Column(name="hora_reu")
	private Calendar hora;
	
	@Column(name="tema_reu")
	private String tema;
	
	@OneToMany(mappedBy="reuniones", fetch = FetchType.LAZY)//mappedBy va el nombre del atributo de esta clase en la clase asociada
	private List<Asistencia> asistencias;
	
	@JoinColumn(name= "id_dignatario", nullable = false) 
	@OneToOne(fetch = FetchType.LAZY)
	 //Atrivuto representa la asociacion con la clase persona
	private Dignatario dignatarios;
	
	public Reunion() {
		super();
	}
	
	public Reunion (Integer idReunion) {
		super();
		this.idReunion = idReunion;
	}

	public Integer getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(Integer idReunion) {
		this.idReunion = idReunion;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Dignatario getDignatarios() {
		return dignatarios;
	}

	public void setDignatarios(Dignatario dignatarios) {
		this.dignatarios = dignatarios;
	}
	
	
	
	

}
