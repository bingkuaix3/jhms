package com.jhms.dao.check;

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
	private static final Log log = LogFactory.getLog(CheckDao.class);
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
		log.info("saving TChecks instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TChecks persistentInstance) {
		log.info("deleting TChecks instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TChecks findById(java.lang.String id) {
		log.info("getting TChecks instance with id: " + id);
		try {
			TChecks instance = (TChecks) getCurrentSession().get(
					"com.jhms.dao.TChecks", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TChecks instance) {
		log.info("finding TChecks instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TChecks")
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
		log.info("finding TChecks instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TChecks as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
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
		log.info("finding all TChecks instances");
		try {
			String queryString = "from TChecks";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TChecks merge(TChecks detachedInstance) {
		log.info("merging TChecks instance");
		try {
			TChecks result = (TChecks) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TChecks instance) {
		log.info("attaching dirty TChecks instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TChecks instance) {
		log.info("attaching clean TChecks instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static CheckDao getFromApplicationContext(ApplicationContext ctx) {
		return (CheckDao) ctx.getBean("TChecksDAO");
	}
}