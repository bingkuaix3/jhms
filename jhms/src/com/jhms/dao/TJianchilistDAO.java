package com.jhms.dao;

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

import com.jhms.entity.TJianchilist;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJianchilist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jhms.dao.TJianchilist
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TJianchilistDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TJianchilistDAO.class);
	// property constants
	public static final String FBELONG_JIANCHI = "fbelongJianchi";
	public static final String FFIRST_USER = "ffirstUser";
	public static final String FFIRST_CONTENT = "ffirstContent";
	public static final String FSECOND_USER = "fsecondUser";
	public static final String FSECOND_CONTENT = "fsecondContent";
	public static final String FTHIRD_USER = "fthirdUser";
	public static final String FTHIRD_CONTENT = "fthirdContent";

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

	public void save(TJianchilist transientInstance) {
		log.debug("saving TJianchilist instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJianchilist persistentInstance) {
		log.debug("deleting TJianchilist instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJianchilist findById(java.lang.String id) {
		log.debug("getting TJianchilist instance with id: " + id);
		try {
			TJianchilist instance = (TJianchilist) getCurrentSession().get(
					"com.jhms.dao.TJianchilist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJianchilist instance) {
		log.debug("finding TJianchilist instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TJianchilist")
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
		log.debug("finding TJianchilist instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TJianchilist as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFbelongJianchi(Object fbelongJianchi) {
		return findByProperty(FBELONG_JIANCHI, fbelongJianchi);
	}

	public List findByFfirstUser(Object ffirstUser) {
		return findByProperty(FFIRST_USER, ffirstUser);
	}

	public List findByFfirstContent(Object ffirstContent) {
		return findByProperty(FFIRST_CONTENT, ffirstContent);
	}

	public List findByFsecondUser(Object fsecondUser) {
		return findByProperty(FSECOND_USER, fsecondUser);
	}

	public List findByFsecondContent(Object fsecondContent) {
		return findByProperty(FSECOND_CONTENT, fsecondContent);
	}

	public List findByFthirdUser(Object fthirdUser) {
		return findByProperty(FTHIRD_USER, fthirdUser);
	}

	public List findByFthirdContent(Object fthirdContent) {
		return findByProperty(FTHIRD_CONTENT, fthirdContent);
	}

	public List findAll() {
		log.debug("finding all TJianchilist instances");
		try {
			String queryString = "from TJianchilist";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJianchilist merge(TJianchilist detachedInstance) {
		log.debug("merging TJianchilist instance");
		try {
			TJianchilist result = (TJianchilist) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJianchilist instance) {
		log.debug("attaching dirty TJianchilist instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJianchilist instance) {
		log.debug("attaching clean TJianchilist instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJianchilistDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TJianchilistDAO) ctx.getBean("TJianchilistDAO");
	}
}