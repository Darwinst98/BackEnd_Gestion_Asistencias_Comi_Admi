package Comite.Administrativo.models.entities;


import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Directiva")
public class Directiva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_directiva")
	private Integer idDirectiva;
	
	@Column(name="fecha_inicio_dir")
	private Date fechaInicio;
	
	@Column(name="fecha_fin_dir")
	private Date fechaFin;
	
	public Directiva() {
		super();
	}
	
	public Directiva (Integer idDirectiva) {
		super();
		this.idDirectiva = idDirectiva;
	}

	public Integer getIdDirectiva() {
		return idDirectiva;
	}

	public void setIdDirectiva(Integer idDirectiva) {
		this.idDirectiva = idDirectiva;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	

	
	

}