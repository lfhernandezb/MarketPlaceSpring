package cl.dsoft.car.marketplace.domain;

// Generated Feb 28, 2016 2:15:19 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BloqueoProveedor generated by hbm2java
 */
@Entity
@Table(name = "bloqueo_proveedor", catalog = "marketplace")
public class BloqueoProveedor implements java.io.Serializable {

	private short idBloqueoProveedor;
	private String descripcion;
	private Set proveedors = new HashSet(0);

	public BloqueoProveedor() {
	}

	public BloqueoProveedor(short idBloqueoProveedor, String descripcion) {
		this.idBloqueoProveedor = idBloqueoProveedor;
		this.descripcion = descripcion;
	}

	public BloqueoProveedor(short idBloqueoProveedor, String descripcion,
			Set proveedors) {
		this.idBloqueoProveedor = idBloqueoProveedor;
		this.descripcion = descripcion;
		this.proveedors = proveedors;
	}

	@Id
	@Column(name = "id_bloqueo_proveedor", unique = true, nullable = false)
	public short getIdBloqueoProveedor() {
		return this.idBloqueoProveedor;
	}

	public void setIdBloqueoProveedor(short idBloqueoProveedor) {
		this.idBloqueoProveedor = idBloqueoProveedor;
	}

	@Column(name = "descripcion", nullable = false, length = 32)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bloqueoProveedor")
	public Set getProveedors() {
		return this.proveedors;
	}

	public void setProveedors(Set proveedors) {
		this.proveedors = proveedors;
	}

}
