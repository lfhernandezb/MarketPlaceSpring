package cl.dsoft.car.marketplace.domain;

// Generated Feb 21, 2016 1:34:37 PM by Hibernate Tools 3.4.0.CR1

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
 * Home object for domain model class Comuna.
 * @see cl.dsoft.car.marketplace.domain.Comuna
 * @author Hibernate Tools
 */
public class ComunaHome {

	private static final Log log = LogFactory.getLog(ComunaHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(Comuna transientInstance) {
		log.debug("persisting Comuna instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Comuna instance) {
		log.debug("attaching dirty Comuna instance");
		try {
			template.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comuna instance) {
		log.debug("attaching clean Comuna instance");
		try {
			template.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Comuna persistentInstance) {
		log.debug("deleting Comuna instance");
		try {
			template.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comuna merge(Comuna detachedInstance) {
		log.debug("merging Comuna instance");
		try {
			Comuna result = (Comuna) template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Comuna findById(int id) {
		log.debug("getting Comuna instance with id: " + id);
		try {
			Comuna instance = (Comuna) template.get(
					"cl.dsoft.car.marketplace.domain.Comuna", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comuna> findByExample(Comuna instance) {
		log.debug("finding Comuna instance by example");
		try {
			List<Comuna> results = template.findByExample(instance);
			
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Comuna> findByCriteria(DetachedCriteria criteria) {
		log.debug("finding Comuna instance by criteria");
		System.out.println("findByCriteria class: RegionHome, template: " + String.valueOf(this.template));
		try {
			List<Comuna> results = template.findByCriteria(criteria);

			log.debug("find by criteria successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by criteria failed", re);
			throw re;
		}
	}
	
}
