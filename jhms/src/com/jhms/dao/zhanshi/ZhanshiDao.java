package com.jhms.dao.zhanshi;

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

import com.jhms.entity.TZhanshis;

/**
 * A data access object (DAO) providing persistence and search support for
 * TZhanshis entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TZhanshis
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ZhanshiDao implements IZhanshiDao {
	private static final Logger log = LoggerFactory
			.getLogger(ZhanshiDao.class);
	// property constants
	public static final String FURL = "furl";

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

	public void save(TZhanshis transientInstance) {
		log.debug("saving TZhanshis instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TZhanshis persistentInstance) {
		log.debug("deleting TZhanshis instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TZhanshis findById(java.lang.String id) {
		log.debug("getting TZhanshis instance with id: " + id);
		try {
			TZhanshis instance = (TZhanshis) getCurrentSession().get(
					"com.jhms.dao.TZhanshis", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZhanshis instance) {
		log.debug("finding TZhanshis instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TZhanshis")
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
		log.debug("finding TZhanshis instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TZhanshis as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFurl(Object furl) {
		return findByProperty(FURL, furl);
	}

	public List findAll() {
		log.debug("finding all TZhanshis instances");
		try {
			String queryString = "from TZhanshis";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZhanshis merge(TZhanshis detachedInstance) {
		log.debug("merging TZhanshis instance");
		try {
			TZhanshis result = (TZhanshis) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZhanshis instance) {
		log.debug("attaching dirty TZhanshis instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TZhanshis instance) {
		log.debug("attaching clean TZhanshis instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ZhanshiDao getFromApplicationContext(ApplicationContext ctx) {
		return (ZhanshiDao) ctx.getBean("TZhanshisDAO");
	}
}