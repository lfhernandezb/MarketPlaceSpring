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
 * Home object for domain model class ProveedorSucursalUsuario.
 * @see cl.dsoft.car.marketplace.domain.ProveedorSucursalUsuario
 * @author Hibernate Tools
 */

public class ProveedorSucursalUsuarioHome {

	private static final Log log = LogFactory
			.getLog(ProveedorSucursalUsuarioHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(ProveedorSucursalUsuario transientInstance) {
		log.debug("persisting ProveedorSucursalUsuario instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(ProveedorSucursalUsuario persistentInstance) {
		log.debug("removing ProveedorSucursalUsuario instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProveedorSucursalUsuario merge(
			ProveedorSucursalUsuario detachedInstance) {
		log.debug("merging ProveedorSucursalUsuario instance");
		try {
			ProveedorSucursalUsuario result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProveedorSucursalUsuario findById(Integer id) {
		log.debug("getting ProveedorSucursalUsuario instance with id: " + id);
		try {
			ProveedorSucursalUsuario instance = template.get(
					ProveedorSucursalUsuario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
