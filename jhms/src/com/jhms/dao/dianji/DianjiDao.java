package com.jhms.dao.dianji;

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

import com.jhms.entity.Dianji;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dianji entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.Dianji
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DianjiDao implements IDianjiDao {
	private static final Logger log = LoggerFactory.getLogger(DianjiDao.class);
	// property constants
	public static final String FTYPE = "ftype";
	public static final String FTYPE_NAME = "ftypeName";

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

	public void save(Dianji transientInstance) {
		log.debug("saving Dianji instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dianji persistentInstance) {
		log.debug("deleting Dianji instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dianji findById(java.lang.String id) {
		log.debug("getting Dianji instance with id: " + id);
		try {
			Dianji instance = (Dianji) getCurrentSession().get(
					"com.jhms.dao.Dianji", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dianji instance) {
		log.debug("finding Dianji instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.Dianji")
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
		log.debug("finding Dianji instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dianji as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFtype(Object ftype) {
		return findByProperty(FTYPE, ftype);
	}

	public List findByFtypeName(Object ftypeName) {
		return findByProperty(FTYPE_NAME, ftypeName);
	}

	public List findAll() {
		log.debug("finding all Dianji instances");
		try {
			String queryString = "from Dianji";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dianji merge(Dianji detachedInstance) {
		log.debug("merging Dianji instance");
		try {
			Dianji result = (Dianji) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dianji instance) {
		log.debug("attaching dirty Dianji instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dianji instance) {
		log.debug("attaching clean Dianji instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DianjiDao getFromApplicationContext(ApplicationContext ctx) {
		return (DianjiDao) ctx.getBean("DianjiDAO");
	}
}