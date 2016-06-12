package com.jhms.dao.physique;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.jhms.entity.TPhysiques;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPhysiques entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TPhysiques
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PhysiqueDao implements IPhysiqueDao{
	private static final Log log = LogFactory.getLog(PhysiqueDao.class);
	// property constants
	public static final String FNAME = "fname";
	public static final String FGUANLIAN = "fguanlian";
	public static final String FINTRODUCE = "fintroduce";
	public static final String FREASON = "freason";
	public static final String FLEAD = "flead";
	public static final String FCHARACTOR = "fcharactor";
	public static final String FIMAGE = "fimage";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(TPhysiques transientInstance) {
		log.info("saving TPhysiques instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TPhysiques persistentInstance) {
		log.info("deleting TPhysiques instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TPhysiques findById(java.lang.String id) {
		log.info("getting TPhysiques instance with id: " + id);
		try {
			TPhysiques instance = (TPhysiques) getCurrentSession().get(
					"com.jhms.dao.TPhysiques", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPhysiques instance) {
		log.info("finding TPhysiques instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TPhysiques")
					.add(Example.create(instance)).list();
			log.info("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.info("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.info("finding TPhysiques instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPhysiques as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFname(Object fname) {
		return findByProperty(FNAME, fname);
	}

	public List findByFguanlian(Object fguanlian) {
		return findByProperty(FGUANLIAN, fguanlian);
	}

	public List findByFintroduce(Object fintroduce) {
		return findByProperty(FINTRODUCE, fintroduce);
	}

	public List findByFreason(Object freason) {
		return findByProperty(FREASON, freason);
	}

	public List findByFlead(Object flead) {
		return findByProperty(FLEAD, flead);
	}

	public List findByFcharactor(Object fcharactor) {
		return findByProperty(FCHARACTOR, fcharactor);
	}

	public List findByFimage(Object fimage) {
		return findByProperty(FIMAGE, fimage);
	}

	public List findAll() {
		log.info("finding all TPhysiques instances");
		try {
			String queryString = "from TPhysiques";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TPhysiques merge(TPhysiques detachedInstance) {
		log.info("merging TPhysiques instance");
		try {
			TPhysiques result = (TPhysiques) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPhysiques instance) {
		log.info("attaching dirty TPhysiques instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPhysiques instance) {
		log.info("attaching clean TPhysiques instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static PhysiqueDao getFromApplicationContext(ApplicationContext ctx) {
		return (PhysiqueDao) ctx.getBean("TPhysiquesDAO");
	}
}