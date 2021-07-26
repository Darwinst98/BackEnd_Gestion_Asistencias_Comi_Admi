package Comite.Administrativo.models.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
}
