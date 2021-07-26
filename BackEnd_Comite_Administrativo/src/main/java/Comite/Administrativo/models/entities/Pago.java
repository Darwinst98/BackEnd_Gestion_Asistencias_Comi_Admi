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
@Table(name="Pago")
public class Pago {
	
	
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
}