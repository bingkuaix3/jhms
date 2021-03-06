package com.jhms.dao.check;

import java.sql.Timestamp;
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

import com.jhms.entity.TChecks;

/**
 * A data access object (DAO) providing persistence and search support for
 * TChecks entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TChecks
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CheckDao implements ICheckDao{
	private static final Logger log = LoggerFactory.getLogger(CheckDao.class);
	// property constants
	public static final String FFEATURE = "ffeature";
	public static final String FMEDIA_ID = "fmediaId";
	public static final String FMEDIA_RESULT = "fmediaResult";
	public static final String FSCORE = "fscore";
	public static final String FBELONG_SOLUTION_ID = "fbelongSolutionId";
	public static final String FSTATUS = "fstatus";

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

	public void save(TChecks transientInstance) {
		log.debug("saving TChecks instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TChecks persistentInstance) {
		log.debug("deleting TChecks instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TChecks findById(java.lang.String id) {
		log.debug("getting TChecks instance with id: " + id);
		try {
			TChecks instance = (TChecks) getCurrentSession().get(
					"com.jhms.dao.TChecks", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TChecks instance) {
		log.debug("finding TChecks instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TChecks")
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
		log.debug("finding TChecks instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TChecks as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFfeature(Object ffeature) {
		return findByProperty(FFEATURE, ffeature);
	}

	public List findByFmediaId(Object fmediaId) {
		return findByProperty(FMEDIA_ID, fmediaId);
	}

	public List findByFmediaResult(Object fmediaResult) {
		return findByProperty(FMEDIA_RESULT, fmediaResult);
	}

	public List findByFscore(Object fscore) {
		return findByProperty(FSCORE, fscore);
	}

	public List findByFbelongSolutionId(Object fbelongSolutionId) {
		return findByProperty(FBELONG_SOLUTION_ID, fbelongSolutionId);
	}

	public List findByFstatus(Object fstatus) {
		return findByProperty(FSTATUS, fstatus);
	}

	public List findAll() {
		log.debug("finding all TChecks instances");
		try {
			String queryString = "from TChecks";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TChecks merge(TChecks detachedInstance) {
		log.debug("merging TChecks instance");
		try {
			TChecks result = (TChecks) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TChecks instance) {
		log.debug("attaching dirty TChecks instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TChecks instance) {
		log.debug("attaching clean TChecks instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CheckDao getFromApplicationContext(ApplicationContext ctx) {
		return (CheckDao) ctx.getBean("TChecksDAO");
	}
}