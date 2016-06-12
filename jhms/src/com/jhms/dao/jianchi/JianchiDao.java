package com.jhms.dao.jianchi;

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

import com.jhms.entity.TJianchis;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJianchis entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TJianchis
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JianchiDao implements IJianchiDao{
	private static final Log log = LogFactory.getLog(JianchiDao.class);
	// property constants
	public static final String FIMAGE = "fimage";
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

	public void save(TJianchis transientInstance) {
		log.info("saving TJianchis instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TJianchis persistentInstance) {
		log.info("deleting TJianchis instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TJianchis findById(java.lang.String id) {
		log.info("getting TJianchis instance with id: " + id);
		try {
			TJianchis instance = (TJianchis) getCurrentSession().get(
					"com.jhms.dao.TJianchis", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJianchis instance) {
		log.info("finding TJianchis instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TJianchis")
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
		log.info("finding TJianchis instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJianchis as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFimage(Object fimage) {
		return findByProperty(FIMAGE, fimage);
	}

	public List findByFcontent(Object fcontent) {
		return findByProperty(FCONTENT, fcontent);
	}

	public List findAll() {
		log.info("finding all TJianchis instances");
		try {
			String queryString = "from TJianchis";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TJianchis merge(TJianchis detachedInstance) {
		log.info("merging TJianchis instance");
		try {
			TJianchis result = (TJianchis) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJianchis instance) {
		log.info("attaching dirty TJianchis instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJianchis instance) {
		log.info("attaching clean TJianchis instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static JianchiDao getFromApplicationContext(ApplicationContext ctx) {
		return (JianchiDao) ctx.getBean("TJianchisDAO");
	}
}