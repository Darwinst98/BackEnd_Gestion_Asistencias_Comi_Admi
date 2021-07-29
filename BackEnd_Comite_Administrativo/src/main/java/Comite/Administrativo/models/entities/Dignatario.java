package Comite.Administrativo.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Dignatario")
public class Dignatario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_dignatario")
	private Integer idDignatario;
	
	@Column(name="rol_dig")
	private String rol;
	
	@Column(name="nombre_dig")
	private String nombre;
	
	@Column(name="apellido_dig")
	private String apellido;
	
	@Column(name="cedula_dig")
	private String cedula;
	
	@JoinColumn(name= "id_directiva", referencedColumnName = "id_directiva") //Se mapea con una clave foránea
	@ManyToOne
	private Directiva directiva;
	
	@OneToOne(mappedBy ="dignatarios")
	private Pago pagos;
	
	@OneToOne(mappedBy ="dignatarios")
	private Reunion reuniones;
	
	public Dignatario() {
		super();
	}
	
	public Dignatario (Integer idDignatario) {
		super();
		this.idDignatario = idDignatario;
	}

	public Integer getIdDignatario() {
		return idDignatario;
	}

	public void setIdDignatario(Integer idDignatario) {
		this.idDignatario = idDignatario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Directiva getDirectiva() {
		return directiva;
	}

	public void setDirectiva(Directiva directiva) {
		this.directiva = directiva;
	}

	public Pago getPagos() {
		return pagos;
	}

	public void setPagos(Pago pagos) {
		this.pagos = pagos;
	}

	public Reunion getReuniones() {
		return reuniones;
	}

	public void setReuniones(Reunion reuniones) {
		this.reuniones = reuniones;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
	
}
