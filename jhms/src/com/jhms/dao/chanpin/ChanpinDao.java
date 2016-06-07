package com.jhms.dao.chanpin;

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

import com.jhms.entity.TChanpins;

/**
 * A data access object (DAO) providing persistence and search support for
 * TChanpins entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.dao.TChanpins
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ChanpinDao implements IChanpinDao{
	private static final Logger log = LoggerFactory
			.getLogger(ChanpinDao.class);
	// property constants
	public static final String FNAME = "fname";
	public static final String FIMAGE = "fimage";
	public static final String FZONE = "fzone";
	public static final String FAMOUNT = "famount";
	public static final String FINTRODUCE = "fintroduce";
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

	public void save(TChanpins transientInstance) {
		log.debug("saving TChanpins instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TChanpins persistentInstance) {
		log.debug("deleting TChanpins instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TChanpins findById(java.lang.String id) {
		log.debug("getting TChanpins instance with id: " + id);
		try {
			TChanpins instance = (TChanpins) getCurrentSession().get(
					"com.jhms.dao.TChanpins", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TChanpins instance) {
		log.debug("finding TChanpins instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TChanpins")
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
		log.debug("finding TChanpins instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TChanpins as model where model."
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

	public List findByFimage(Object fimage) {
		return findByProperty(FIMAGE, fimage);
	}

	public List findByFzone(Object fzone) {
		return findByProperty(FZONE, fzone);
	}

	public List findByFamount(Object famount) {
		return findByProperty(FAMOUNT, famount);
	}

	public List findByFintroduce(Object fintroduce) {
		return findByProperty(FINTRODUCE, fintroduce);
	}

	public List findByFurl(Object furl) {
		return findByProperty(FURL, furl);
	}

	public List findAll() {
		log.debug("finding all TChanpins instances");
		try {
			String queryString = "from TChanpins";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TChanpins merge(TChanpins detachedInstance) {
		log.debug("merging TChanpins instance");
		try {
			TChanpins result = (TChanpins) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TChanpins instance) {
		log.debug("attaching dirty TChanpins instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TChanpins instance) {
		log.debug("attaching clean TChanpins instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ChanpinDao getFromApplicationContext(ApplicationContext ctx) {
		return (ChanpinDao) ctx.getBean("TChanpinsDAO");
	}
}