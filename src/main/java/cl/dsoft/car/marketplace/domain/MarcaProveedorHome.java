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
 * Home object for domain model class MarcaProveedor.
 * @see cl.dsoft.car.marketplace.domain.MarcaProveedor
 * @author Hibernate Tools
 */

public class MarcaProveedorHome {

	private static final Log log = LogFactory.getLog(MarcaProveedorHome.class);

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  	

	public void persist(MarcaProveedor transientInstance) {
		log.debug("persisting MarcaProveedor instance");
		try {
			template.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(MarcaProveedor persistentInstance) {
		log.debug("removing MarcaProveedor instance");
		try {
			template.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MarcaProveedor merge(MarcaProveedor detachedInstance) {
		log.debug("merging MarcaProveedor instance");
		try {
			MarcaProveedor result = template.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MarcaProveedor findById(int id) {
		log.debug("getting MarcaProveedor instance with id: " + id);
		try {
			MarcaProveedor instance = template.get(MarcaProveedor.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
