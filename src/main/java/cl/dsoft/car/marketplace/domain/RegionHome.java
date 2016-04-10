package cl.dsoft.car.marketplace.domain;

// Generated Feb 21, 2016 1:34:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

/**
 * Home object for domain model class Region.
 * @see cl.dsoft.car.marketplace.domain.Region
 * @author Hibernate Tools
 */

public class RegionHome extends HibernateDaoSupport {
	
	private static final Log log = LogFactory.getLog(RegionHome.class);
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
		System.out.println("setTemplate class: RegionHome, template: " + String.valueOf(template));
	    setHibernateTemplate(template);
	}  	
	
	public void persist(Region transientInstance) {
		log.debug("persisting Region instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Region instance) {
		log.debug("attaching dirty Region instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(Region instance) {
		log.debug("attaching clean Region instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void delete(Region persistentInstance) {
		log.debug("deleting Region instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Region merge(Region detachedInstance) {
		log.debug("merging Region instance");
		try {
			Region result = (Region) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Region findById(int id) {
		log.debug("getting Region instance with id: " + id);
		try {
			Region instance = (Region) getHibernateTemplate().get(
					"cl.dsoft.car.marketplace.domain.Region", id);
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
	
	public List<Region> findByExample(Region instance) {
		log.debug("finding Region instance by example");
		try {
			List<Region> results = getHibernateTemplate().findByExample(instance);

			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Region> findByCriteria(DetachedCriteria criteria) {
		log.debug("finding Region instance by criteria");
		//System.out.println("findByCriteria class: RegionHome, template: " + String.valueOf(this.template));
		try {
			List<Region> results = getHibernateTemplate().findByCriteria(criteria);

			log.debug("find by criteria successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by criteria failed", re);
			throw re;
		}
	}
	
	public Region getRegionWithComunas(int idRegion) {
		log.debug("finding Comunas");
		try {
			Region region = getHibernateTemplate().get(Region.class, idRegion);
			
			//getHibernateTemplate().initialize(region.getComunas());

			//log.debug("find comunas successful, result size: " + region.getComunas().size());
			return region;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
