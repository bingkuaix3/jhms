package com.jhms.dao.dianji;

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

import com.jhms.entity.Dianji;
import com.jhms.po.graph.DianjiAmount;

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
	private static final Log log = LogFactory.getLog(DianjiDao.class);
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
		log.info("saving Dianji instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(Dianji persistentInstance) {
		log.info("deleting Dianji instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public Dianji findById(java.lang.String id) {
		log.info("getting Dianji instance with id: " + id);
		try {
			Dianji instance = (Dianji) getCurrentSession().get(
					"com.jhms.dao.Dianji", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dianji instance) {
		log.info("finding Dianji instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.Dianji")
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
		log.info("finding Dianji instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dianji as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List findByFtype(Object ftype) {
		return findByProperty(FTYPE, ftype);
	}

	public List findByFtypeName(Object ftypeName) {
		return findByProperty(FTYPE_NAME, ftypeName);
	}

	public List<DianjiAmount> findAmountByDate(String typeNo,String startDate,String endDate){
		log.info("查询点击数量数据，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select a.fType as typeNo,a.fTypeName as typeName, count(*) as typeAmount "
					+ "from dianji a  where a.fType = ? and a.fCreateTime => ? and a.fCreateTime <= ?"
					+ "group by a.fType "
					+ "order by a.fType asc";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, typeNo);
			queryObject.setParameter(1, startDate);
			queryObject.setParameter(2, endDate);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("查询点击数量失败", re);
			throw re;
		}
	}
	
	public List findAll() {
		log.info("finding all Dianji instances");
		try {
			String queryString = "from Dianji";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public Dianji merge(Dianji detachedInstance) {
		log.info("merging Dianji instance");
		try {
			Dianji result = (Dianji) getCurrentSession()
					.merge(detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dianji instance) {
		log.info("attaching dirty Dianji instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dianji instance) {
		log.info("attaching clean Dianji instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static DianjiDao getFromApplicationContext(ApplicationContext ctx) {
		return (DianjiDao) ctx.getBean("DianjiDAO");
	}
}