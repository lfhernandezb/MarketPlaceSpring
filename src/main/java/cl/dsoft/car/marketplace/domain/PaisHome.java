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
 * Home object for domain model class Pais.
 * @see cl.dsoft.car.marketplace.domain.Pais
 * @author Hibernate Tools
 */

public class PaisHome {

	private static final Log log = LogFactory.getLog(PaisHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(Pais transientInstance) {
		log.debug("persisting Pais instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Pais persistentInstance) {
		log.debug("removing Pais instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Pais merge(Pais detachedInstance) {
		log.debug("merging Pais instance");
		try {
			Pais result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pais findById(int id) {
		log.debug("getting Pais instance with id: " + id);
		try {
			Pais instance = template.get(Pais.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
