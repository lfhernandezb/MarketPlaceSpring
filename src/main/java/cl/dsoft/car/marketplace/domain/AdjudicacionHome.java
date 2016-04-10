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
 * Home object for domain model class Adjudicacion.
 * @see cl.dsoft.car.marketplace.domain.Adjudicacion
 * @author Hibernate Tools
 */

public class AdjudicacionHome {

	private static final Log log = LogFactory.getLog(AdjudicacionHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(Adjudicacion transientInstance) {
		log.debug("persisting Adjudicacion instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Adjudicacion persistentInstance) {
		log.debug("removing Adjudicacion instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Adjudicacion merge(Adjudicacion detachedInstance) {
		log.debug("merging Adjudicacion instance");
		try {
			Adjudicacion result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Adjudicacion findById(Long id) {
		log.debug("getting Adjudicacion instance with id: " + id);
		try {
			Adjudicacion instance = template.get(Adjudicacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
