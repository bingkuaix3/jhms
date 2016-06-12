package com.jhms.dao.solution;

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

import com.jhms.entity.TSolutions;

/**
 * A data access object (DAO) providing persistence and search support for
 * TSolutions entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TSolutions
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SolutionDao implements ISolutionDao {
	private static final Log log = LogFactory.getLog(SolutionDao.class);
	// property constants
	public static final String FBELONG_PHYSIQUE = "fbelongPhysique";
	public static final String FSCORE_UP = "fscoreUp";
	public static final String FSCORE_DOWN = "fscoreDown";
	public static final String FCHAYIN = "fchayin";
	public static final String FBAGUAN = "fbaguan";
	public static final String FAIJIU = "faijiu";
	public static final String FTIEFU = "ftiefu";
	public static final String FZUYU = "fzuyu";

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

	public void save(TSolutions transientInstance) {
		log.info("saving TSolutions instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TSolutions persistentInstance) {
		log.info("deleting TSolutions instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TSolutions findById(java.lang.String id) {
		log.info("getting TSolutions instance with id: " + id);
		try {
			TSolutions instance = (TSolutions) getCurrentSession().get(
					"com.jhms.dao.TSolutions", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TSolutions instance) {
		log.info("finding TSolutions instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TSolutions")
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
		log.info("finding TSolutions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TSolutions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFbelongPhysique(Object fbelongPhysique) {
		return findByProperty(FBELONG_PHYSIQUE, fbelongPhysique);
	}

	public List findByFscoreUp(Object fscoreUp) {
		return findByProperty(FSCORE_UP, fscoreUp);
	}

	public List findByFscoreDown(Object fscoreDown) {
		return findByProperty(FSCORE_DOWN, fscoreDown);
	}

	public List findByFchayin(Object fchayin) {
		return findByProperty(FCHAYIN, fchayin);
	}

	public List findByFbaguan(Object fbaguan) {
		return findByProperty(FBAGUAN, fbaguan);
	}

	public List findByFaijiu(Object faijiu) {
		return findByProperty(FAIJIU, faijiu);
	}

	public List findByFtiefu(Object ftiefu) {
		return findByProperty(FTIEFU, ftiefu);
	}

	public List findByFzuyu(Object fzuyu) {
		return findByProperty(FZUYU, fzuyu);
	}

	public List findAll() {
		log.info("finding all TSolutions instances");
		try {
			String queryString = "from TSolutions";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TSolutions merge(TSolutions detachedInstance) {
		log.info("merging TSolutions instance");
		try {
			TSolutions result = (TSolutions) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TSolutions instance) {
		log.info("attaching dirty TSolutions instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TSolutions instance) {
		log.info("attaching clean TSolutions instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static SolutionDao getFromApplicationContext(ApplicationContext ctx) {
		return (SolutionDao) ctx.getBean("solutionDao");
	}
}