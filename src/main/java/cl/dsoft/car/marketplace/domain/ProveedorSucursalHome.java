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
 * Home object for domain model class ProveedorSucursal.
 * @see cl.dsoft.car.marketplace.domain.ProveedorSucursal
 * @author Hibernate Tools
 */

public class ProveedorSucursalHome {

	private static final Log log = LogFactory
			.getLog(ProveedorSucursalHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(ProveedorSucursal transientInstance) {
		log.debug("persisting ProveedorSucursal instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(ProveedorSucursal persistentInstance) {
		log.debug("removing ProveedorSucursal instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProveedorSucursal merge(ProveedorSucursal detachedInstance) {
		log.debug("merging ProveedorSucursal instance");
		try {
			ProveedorSucursal result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProveedorSucursal findById(Integer id) {
		log.debug("getting ProveedorSucursal instance with id: " + id);
		try {
			ProveedorSucursal instance = template.get(
					ProveedorSucursal.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
