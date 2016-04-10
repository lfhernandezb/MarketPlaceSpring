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
 * Home object for domain model class OfertaCotizacion.
 * @see cl.dsoft.car.marketplace.domain.OfertaCotizacion
 * @author Hibernate Tools
 */

public class OfertaCotizacionHome {

	private static final Log log = LogFactory
			.getLog(OfertaCotizacionHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(OfertaCotizacion transientInstance) {
		log.debug("persisting OfertaCotizacion instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(OfertaCotizacion persistentInstance) {
		log.debug("removing OfertaCotizacion instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OfertaCotizacion merge(OfertaCotizacion detachedInstance) {
		log.debug("merging OfertaCotizacion instance");
		try {
			OfertaCotizacion result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OfertaCotizacion findById(Long id) {
		log.debug("getting OfertaCotizacion instance with id: " + id);
		try {
			OfertaCotizacion instance = template.get(
					OfertaCotizacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
