package com.jhms.dao.admin;

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
public class AdminDao implements IAdminDao {
	private static final Log log = LogFactory.getLog(AdminDao.class);
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
		log.info("saving TAdmin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TAdmin persistentInstance) {
		log.info("deleting TAdmin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TAdmin findById(java.lang.String id) {
		log.info("getting TAdmin instance with id: " + id);
		try {
			TAdmin instance = (TAdmin) getCurrentSession().get(
					"com.jhms.dao.TAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAdmin instance) {
		log.info("finding TAdmin instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TAdmin")
					.add(Example.create(instance)).list();
			log.info("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.info("finding TAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TAdmin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);

			List results = queryObject.list();
			log.info("find by property successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public TAdmin findByNameAndPwd(String name, String pwd) {
		log.info("finding TAdmin instance with name: " + name + ", pwd: " + pwd);
		try {
			String queryString = "from TAdmin as model where model.fname =? and model.fpwd=?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, name);
			queryObject.setParameter(1, pwd);
			List results = queryObject.list();
			log.info("find by name and pwd successful, result size: " + results.size());
			return (TAdmin) results.get(0);
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			return null;
		}
	}

	public List findByFname(Object fname) {
		return findByProperty(FNAME, fname);
	}

	public List findByFpwd(Object fpwd) {
		return findByProperty(FPWD, fpwd);
	}

	public List findAll() {
		log.info("finding all TAdmin instances");
		try {
			String queryString = "from TAdmin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			List results = queryObject.list();
			log.info("find all successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TAdmin merge(TAdmin detachedInstance) {
		log.info("merging TAdmin instance");
		try {
			TAdmin result = (TAdmin) getCurrentSession()
					.merge(detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAdmin instance) {
		log.info("attaching dirty TAdmin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAdmin instance) {
		log.info("attaching clean TAdmin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static AdminDao getFromApplicationContext(ApplicationContext ctx) {
		return (AdminDao) ctx.getBean("TAdminDAO");
	}
}