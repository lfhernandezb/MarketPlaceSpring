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
 * Home object for domain model class Vehiculo.
 * @see cl.dsoft.car.marketplace.domain.Vehiculo
 * @author Hibernate Tools
 */

public class VehiculoHome {

	private static final Log log = LogFactory.getLog(VehiculoHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(Vehiculo transientInstance) {
		log.debug("persisting Vehiculo instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Vehiculo persistentInstance) {
		log.debug("removing Vehiculo instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Vehiculo merge(Vehiculo detachedInstance) {
		log.debug("merging Vehiculo instance");
		try {
			Vehiculo result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vehiculo findById(Long id) {
		log.debug("getting Vehiculo instance with id: " + id);
		try {
			Vehiculo instance = template.get(Vehiculo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
