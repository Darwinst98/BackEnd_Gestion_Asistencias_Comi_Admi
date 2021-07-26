package Comite.Administrativo.models.entities;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Reunion")
public class Reunion {
	
	
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
	
	
	
	

}
