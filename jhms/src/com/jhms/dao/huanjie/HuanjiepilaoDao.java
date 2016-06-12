package com.jhms.dao.huanjie;

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

import com.jhms.entity.THuanjiepilaos;

/**
 * A data access object (DAO) providing persistence and search support for
 * THuanjiepilaos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jhms.entity.THuanjiepilaos
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HuanjiepilaoDao implements IHuanjiepilaoDao{
	private static final Log log = LogFactory.getLog(HuanjiepilaoDao.class);
	// property constants
	public static final String FTYPEB = "ftypeb";
	public static final String FTYPEB_NAME = "ftypebName";
	public static final String FTYPEM = "ftypem";
	public static final String FTYPEM_NAME = "ftypemName";
	public static final String FTYPES = "ftypes";
	public static final String FTYPES_NAME = "ftypesName";
	public static final String FIMG = "fimg";
	public static final String FTITLE1 = "ftitle1";
	public static final String FCONTENT1 = "fcontent1";
	public static final String FTITLE2 = "ftitle2";
	public static final String FCONTENT2 = "fcontent2";
	public static final String FTITLE3 = "ftitle3";
	public static final String FCONTENT3 = "fcontent3";

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

	public void save(THuanjiepilaos transientInstance) {
		log.info("saving THuanjiepilaos instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(THuanjiepilaos persistentInstance) {
		log.info("deleting THuanjiepilaos instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public THuanjiepilaos findById(java.lang.String id) {
		log.info("getting THuanjiepilaos instance with id: " + id);
		try {
			THuanjiepilaos instance = (THuanjiepilaos) getCurrentSession().get(
					"com.jhms.dao.THuanjiepilaos", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(THuanjiepilaos instance) {
		log.info("finding THuanjiepilaos instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.THuanjiepilaos")
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
		log.info("finding THuanjiepilaos instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from THuanjiepilaos as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFtypeb(Object ftypeb) {
		return findByProperty(FTYPEB, ftypeb);
	}

	public List findByFtypebName(Object ftypebName) {
		return findByProperty(FTYPEB_NAME, ftypebName);
	}

	public List findByFtypem(Object ftypem) {
		return findByProperty(FTYPEM, ftypem);
	}

	public List findByFtypemName(Object ftypemName) {
		return findByProperty(FTYPEM_NAME, ftypemName);
	}

	public List findByFtypes(Object ftypes) {
		return findByProperty(FTYPES, ftypes);
	}

	public List findByFtypesName(Object ftypesName) {
		return findByProperty(FTYPES_NAME, ftypesName);
	}

	public List findByFimg(Object fimg) {
		return findByProperty(FIMG, fimg);
	}

	public List findByFtitle1(Object ftitle1) {
		return findByProperty(FTITLE1, ftitle1);
	}

	public List findByFcontent1(Object fcontent1) {
		return findByProperty(FCONTENT1, fcontent1);
	}

	public List findByFtitle2(Object ftitle2) {
		return findByProperty(FTITLE2, ftitle2);
	}

	public List findByFcontent2(Object fcontent2) {
		return findByProperty(FCONTENT2, fcontent2);
	}

	public List findByFtitle3(Object ftitle3) {
		return findByProperty(FTITLE3, ftitle3);
	}

	public List findByFcontent3(Object fcontent3) {
		return findByProperty(FCONTENT3, fcontent3);
	}

	public List findAll() {
		log.info("finding all THuanjiepilaos instances");
		try {
			String queryString = "from THuanjiepilaos";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public THuanjiepilaos merge(THuanjiepilaos detachedInstance) {
		log.info("merging THuanjiepilaos instance");
		try {
			THuanjiepilaos result = (THuanjiepilaos) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(THuanjiepilaos instance) {
		log.info("attaching dirty THuanjiepilaos instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(THuanjiepilaos instance) {
		log.info("attaching clean THuanjiepilaos instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static HuanjiepilaoDao getFromApplicationContext(
			ApplicationContext ctx) {
		return (HuanjiepilaoDao) ctx.getBean("THuanjiepilaosDAO");
	}
}