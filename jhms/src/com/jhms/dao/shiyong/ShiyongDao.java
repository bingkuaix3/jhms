package com.jhms.dao.shiyong;

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

import com.jhms.entity.TShiyongs;

/**
 * A data access object (DAO) providing persistence and search support for
 * TShiyongs entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TShiyongs
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ShiyongDao implements IShiyongDao{
	private static final Log log = LogFactory.getLog(ShiyongDao.class);
	// property constants
	public static final String FCHA = "fcha";
	public static final String FBAGUAN = "fbaguan";
	public static final String FTIEFU = "ftiefu";
	public static final String FZUYU = "fzuyu";
	public static final String FAIJIU = "faijiu";

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

	public void save(TShiyongs transientInstance) {
		log.info("saving TShiyongs instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TShiyongs persistentInstance) {
		log.info("deleting TShiyongs instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TShiyongs findById(java.lang.String id) {
		log.info("getting TShiyongs instance with id: " + id);
		try {
			TShiyongs instance = (TShiyongs) getCurrentSession().get(
					"com.jhms.dao.TShiyongs", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShiyongs instance) {
		log.info("finding TShiyongs instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TShiyongs")
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
		log.info("finding TShiyongs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TShiyongs as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFcha(Object fcha) {
		return findByProperty(FCHA, fcha);
	}

	public List findByFbaguan(Object fbaguan) {
		return findByProperty(FBAGUAN, fbaguan);
	}

	public List findByFtiefu(Object ftiefu) {
		return findByProperty(FTIEFU, ftiefu);
	}

	public List findByFzuyu(Object fzuyu) {
		return findByProperty(FZUYU, fzuyu);
	}

	public List findByFaijiu(Object faijiu) {
		return findByProperty(FAIJIU, faijiu);
	}

	public List findAll() {
		log.info("finding all TShiyongs instances");
		try {
			String queryString = "from TShiyongs";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TShiyongs merge(TShiyongs detachedInstance) {
		log.info("merging TShiyongs instance");
		try {
			TShiyongs result = (TShiyongs) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShiyongs instance) {
		log.info("attaching dirty TShiyongs instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TShiyongs instance) {
		log.info("attaching clean TShiyongs instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static ShiyongDao getFromApplicationContext(ApplicationContext ctx) {
		return (ShiyongDao) ctx.getBean("shiyongDao");
	}
}