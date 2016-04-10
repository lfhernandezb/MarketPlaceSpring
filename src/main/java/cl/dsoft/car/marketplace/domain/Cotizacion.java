package cl.dsoft.car.marketplace.domain;

// Generated Feb 28, 2016 2:15:19 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cotizacion generated by hbm2java
 */
@Entity
@Table(name = "cotizacion", catalog = "marketplace")
public class Cotizacion implements java.io.Serializable {

	private Long idCotizacion;
	private Comuna comuna;
	private Servicio servicio;
	private Vehiculo vehiculo;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Set ofertaCotizacions = new HashSet(0);
	private Set adjudicacions = new HashSet(0);

	public Cotizacion() {
	}

	public Cotizacion(Comuna comuna, Servicio servicio, Vehiculo vehiculo,
			Date fechaCreacion, Date fechaModificacion) {
		this.comuna = comuna;
		this.servicio = servicio;
		this.vehiculo = vehiculo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Cotizacion(Comuna comuna, Servicio servicio, Vehiculo vehiculo,
			String descripcion, Date fechaCreacion, Date fechaModificacion,
			Set ofertaCotizacions, Set adjudicacions) {
		this.comuna = comuna;
		this.servicio = servicio;
		this.vehiculo = vehiculo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.ofertaCotizacions = ofertaCotizacions;
		this.adjudicacions = adjudicacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_cotizacion", unique = true, nullable = false)
	public Long getIdCotizacion() {
		return this.idCotizacion;
	}

	public void setIdCotizacion(Long idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comuna", nullable = false)
	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servicio", nullable = false)
	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehiculo", nullable = false)
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Column(name = "descripcion", length = 65535)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion", nullable = false, length = 19)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotizacion")
	public Set getOfertaCotizacions() {
		return this.ofertaCotizacions;
	}

	public void setOfertaCotizacions(Set ofertaCotizacions) {
		this.ofertaCotizacions = ofertaCotizacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotizacion")
	public Set getAdjudicacions() {
		return this.adjudicacions;
	}

	public void setAdjudicacions(Set adjudicacions) {
		this.adjudicacions = adjudicacions;
	}

}
