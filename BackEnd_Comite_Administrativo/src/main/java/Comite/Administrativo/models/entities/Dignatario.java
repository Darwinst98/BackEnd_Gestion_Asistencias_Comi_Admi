package Comite.Administrativo.models.entities;

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
public class Dignatario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_dignatario")
	private Integer idDignatario;
	
	@Column(name="rol_dig")
	private String rol;
	
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
	
	
	
	
}
