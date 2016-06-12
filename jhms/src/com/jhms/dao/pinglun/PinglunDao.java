package com.jhms.dao.pinglun;

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

import com.jhms.entity.TPingluns;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPingluns entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TPingluns
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PinglunDao implements IPinglunDao{
	private static final Log log = LogFactory.getLog(PinglunDao.class);
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

	public void save(TPingluns transientInstance) {
		log.info("saving TPingluns instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TPingluns persistentInstance) {
		log.info("deleting TPingluns instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TPingluns findById(java.lang.String id) {
		log.info("getting TPingluns instance with id: " + id);
		try {
			TPingluns instance = (TPingluns) getCurrentSession().get(
					"com.jhms.dao.TPingluns", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPingluns instance) {
		log.info("finding TPingluns instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TPingluns")
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
		log.info("finding TPingluns instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPingluns as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFcontent(Object fcontent) {
		return findByProperty(FCONTENT, fcontent);
	}

	public List findAll() {
		log.info("finding all TPingluns instances");
		try {
			String queryString = "from TPingluns";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TPingluns merge(TPingluns detachedInstance) {
		log.info("merging TPingluns instance");
		try {
			TPingluns result = (TPingluns) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPingluns instance) {
		log.info("attaching dirty TPingluns instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPingluns instance) {
		log.info("attaching clean TPingluns instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static PinglunDao getFromApplicationContext(ApplicationContext ctx) {
		return (PinglunDao) ctx.getBean("TPinglunsDAO");
	}
}