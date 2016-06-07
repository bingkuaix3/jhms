package com.jhms.dao;

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

import com.jhms.entity.TAdvice;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAdvice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.dao.TAdvice
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TAdviceDAO {
	private static final Logger log = LoggerFactory.getLogger(TAdviceDAO.class);
	// property constants
	public static final String FCONTENT = "fcontent";

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

	public void save(TAdvice transientInstance) {
		log.debug("saving TAdvice instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAdvice persistentInstance) {
		log.debug("deleting TAdvice instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAdvice findById(java.lang.String id) {
		log.debug("getting TAdvice instance with id: " + id);
		try {
			TAdvice instance = (TAdvice) getCurrentSession().get(
					"com.jhms.dao.TAdvice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAdvice instance) {
		log.debug("finding TAdvice instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TAdvice")
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
		log.debug("finding TAdvice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TAdvice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFcontent(Object fcontent) {
		return findByProperty(FCONTENT, fcontent);
	}

	public List findAll() {
		log.debug("finding all TAdvice instances");
		try {
			String queryString = "from TAdvice";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAdvice merge(TAdvice detachedInstance) {
		log.debug("merging TAdvice instance");
		try {
			TAdvice result = (TAdvice) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAdvice instance) {
		log.debug("attaching dirty TAdvice instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAdvice instance) {
		log.debug("attaching clean TAdvice instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAdviceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TAdviceDAO) ctx.getBean("TAdviceDAO");
	}
}