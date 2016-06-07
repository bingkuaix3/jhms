package com.jhms.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @see com.jhms.dao.TDemands
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TDemandsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TDemandsDAO.class);
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
		log.debug("saving TDemands instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDemands persistentInstance) {
		log.debug("deleting TDemands instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDemands findById(java.lang.String id) {
		log.debug("getting TDemands instance with id: " + id);
		try {
			TDemands instance = (TDemands) getCurrentSession().get(
					"com.jhms.dao.TDemands", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDemands instance) {
		log.debug("finding TDemands instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TDemands")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TDemands instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDemands as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
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
		log.debug("finding all TDemands instances");
		try {
			String queryString = "from TDemands";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDemands merge(TDemands detachedInstance) {
		log.debug("merging TDemands instance");
		try {
			TDemands result = (TDemands) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDemands instance) {
		log.debug("attaching dirty TDemands instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDemands instance) {
		log.debug("attaching clean TDemands instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDemandsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TDemandsDAO) ctx.getBean("TDemandsDAO");
	}
}