package com.jhms.dao.demand;

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

import com.jhms.entity.TDemands;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDemands entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TDemands
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DemandDao implements IDemandDao{
	private static final Log log = LogFactory.getLog(DemandDao.class);
	// property constants
	public static final String FNAME = "fname";
	public static final String FSECOND_NAME = "fsecondName";

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

	public void save(TDemands transientInstance) {
		log.info("saving TDemands instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TDemands persistentInstance) {
		log.info("deleting TDemands instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TDemands findById(java.lang.String id) {
		log.info("getting TDemands instance with id: " + id);
		try {
			TDemands instance = (TDemands) getCurrentSession().get(
					"com.jhms.dao.TDemands", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDemands instance) {
		log.info("finding TDemands instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TDemands")
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
		log.info("finding TDemands instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDemands as model where model."
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

	public List findByFsecondName(Object fsecondName) {
		return findByProperty(FSECOND_NAME, fsecondName);
	}

	public List findAll() {
		log.info("finding all TDemands instances");
		try {
			String queryString = "from TDemands";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TDemands merge(TDemands detachedInstance) {
		log.info("merging TDemands instance");
		try {
			TDemands result = (TDemands) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDemands instance) {
		log.info("attaching dirty TDemands instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDemands instance) {
		log.info("attaching clean TDemands instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static DemandDao getFromApplicationContext(ApplicationContext ctx) {
		return (DemandDao) ctx.getBean("TDemandsDAO");
	}
}