package Comite.Administrativo.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_persona")
	private Integer idpersona;
	
	@Column(name="nombre_per")
	private String nombre;
	
	@Column(name="apellido_per")
	private String apellido;
	
	@Column(name="numero_per")
	private Number numero;
	
	@Column(name="cedula_per")
	private String cedula;
			
	@OneToMany(mappedBy="personas", fetch = FetchType.LAZY)//mappedBy va el nombre del atributo de esta clase en la clase asociada
	private List<Pago> pagos;
	
	@OneToOne(mappedBy ="personas")
	private Asistencia asistencias;
	
	public Persona() {
		super();
	}
	
	public Persona (Integer idpersona) {
		super();
		this.idpersona = idpersona;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Number getNumero() {
		return numero;
	}

	public void setNumero(Number numero) {
		this.numero = numero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Asistencia getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Asistencia asistencias) {
		this.asistencias = asistencias;
	}

	
	
	

}

