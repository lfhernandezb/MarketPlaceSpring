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
 * Home object for domain model class TipoVehiculo.
 * @see cl.dsoft.car.marketplace.domain.TipoVehiculo
 * @author Hibernate Tools
 */

public class TipoVehiculoHome {

	private static final Log log = LogFactory.getLog(TipoVehiculoHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(TipoVehiculo transientInstance) {
		log.debug("persisting TipoVehiculo instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(TipoVehiculo persistentInstance) {
		log.debug("removing TipoVehiculo instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoVehiculo merge(TipoVehiculo detachedInstance) {
		log.debug("merging TipoVehiculo instance");
		try {
			TipoVehiculo result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoVehiculo findById(short id) {
		log.debug("getting TipoVehiculo instance with id: " + id);
		try {
			TipoVehiculo instance = template.get(TipoVehiculo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
