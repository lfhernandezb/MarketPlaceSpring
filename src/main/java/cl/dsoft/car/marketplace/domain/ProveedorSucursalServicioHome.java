package cl.dsoft.car.marketplace.domain;

// Generated Feb 28, 2016 2:15:19 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Home object for domain model class ProveedorSucursalServicio.
 * @see cl.dsoft.car.marketplace.domain.ProveedorSucursalServicio
 * @author Hibernate Tools
 */

public class ProveedorSucursalServicioHome {

	private static final Log log = LogFactory
			.getLog(ProveedorSucursalServicioHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(ProveedorSucursalServicio transientInstance) {
		log.debug("persisting ProveedorSucursalServicio instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(ProveedorSucursalServicio persistentInstance) {
		log.debug("removing ProveedorSucursalServicio instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProveedorSucursalServicio merge(
			ProveedorSucursalServicio detachedInstance) {
		log.debug("merging ProveedorSucursalServicio instance");
		try {
			ProveedorSucursalServicio result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProveedorSucursalServicio findById(Long id) {
		log.debug("getting ProveedorSucursalServicio instance with id: " + id);
		try {
			ProveedorSucursalServicio instance = template.get(
					ProveedorSucursalServicio.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
