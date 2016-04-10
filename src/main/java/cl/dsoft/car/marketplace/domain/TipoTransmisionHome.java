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
 * Home object for domain model class TipoTransmision.
 * @see cl.dsoft.car.marketplace.domain.TipoTransmision
 * @author Hibernate Tools
 */

public class TipoTransmisionHome {

	private static final Log log = LogFactory.getLog(TipoTransmisionHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(TipoTransmision transientInstance) {
		log.debug("persisting TipoTransmision instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(TipoTransmision persistentInstance) {
		log.debug("removing TipoTransmision instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoTransmision merge(TipoTransmision detachedInstance) {
		log.debug("merging TipoTransmision instance");
		try {
			TipoTransmision result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoTransmision findById(short id) {
		log.debug("getting TipoTransmision instance with id: " + id);
		try {
			TipoTransmision instance = template.get(
					TipoTransmision.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
