package Comite.Administrativo.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Pago")
public class Pago implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_pago")
	private Integer idPago;
	
	@Column(name="fecha_pag")
	private Calendar fecha;
	
	@Column(name="monto_pag")
	private int monto;
	
	@Column(name="observacion_pag")
	private String observacion;
	
	@Column(name="tipo_pag")
	private String tipo;
	
	@JoinColumn(name= "id_persona", referencedColumnName = "id_persona") //Se mapea con una clave foránea
	@ManyToOne
	@JsonIgnore
	private Persona personas;
	
	@JoinColumn(name= "id_disgnatario", nullable = false) 
	@OneToOne(fetch = FetchType.LAZY)
	 //Atrivuto representa la asociacion con la clase dignatario
	private Dignatario dignatarios;
	
	public Pago() {
		super();
	}
	
	public Pago (Integer idPago) {
		super();
		this.idPago = idPago;
	}

	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Persona getPersonas() {
		return personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	public Dignatario getDignatarios() {
		return dignatarios;
	}

	public void setDignatarios(Dignatario dignatarios) {
		this.dignatarios = dignatarios;
	}
	
	
}