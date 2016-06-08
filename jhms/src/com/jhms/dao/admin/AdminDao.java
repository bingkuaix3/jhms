package com.jhms.dao.admin;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.jhms.entity.TAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TAdmin
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AdminDao implements IAdminDao{
	private static final Logger log = LoggerFactory.getLogger(AdminDao.class);
	// property constants
	public static final String FNAME = "fname";
	public static final String FPWD = "fpwd";

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

	public void save(TAdmin transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAdmin persistentInstance) {
		log.debug("deleting TAdmin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAdmin findById(java.lang.String id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			TAdmin instance = (TAdmin) getCurrentSession().get(
					"com.jhms.dao.TAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAdmin instance) {
		log.debug("finding TAdmin instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TAdmin")
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
		log.debug("finding TAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TAdmin as model where model."
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

	public List findByFpwd(Object fpwd) {
		return findByProperty(FPWD, fpwd);
	}

	public List findAll() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from TAdmin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAdmin merge(TAdmin detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			TAdmin result = (TAdmin) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAdmin instance) {
		log.debug("attaching dirty TAdmin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAdmin instance) {
		log.debug("attaching clean TAdmin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminDao getFromApplicationContext(ApplicationContext ctx) {
		return (AdminDao) ctx.getBean("TAdminDAO");
	}
}