package com.jhms.dao.denglu;

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

import com.jhms.entity.TDenglus;
import com.jhms.po.graph.DengluDayAmount;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDenglus entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TDenglus
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DengluDao implements IDengluDao{
	private static final Log log = LogFactory.getLog(DengluDao.class);
	// property constants

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

	public void save(TDenglus transientInstance) {
		log.info("saving TDenglus instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TDenglus persistentInstance) {
		log.info("deleting TDenglus instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TDenglus findById(java.lang.String id) {
		log.info("getting TDenglus instance with id: " + id);
		try {
			TDenglus instance = (TDenglus) getCurrentSession().get(
					"com.jhms.dao.TDenglus", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDenglus instance) {
		log.info("finding TDenglus instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TDenglus")
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
		log.info("finding TDenglus instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDenglus as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List<DengluDayAmount> findAmountByDate(String startDate,String endDate){
		log.info("查询用户登陆数据，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select hour(a.fTime) as hr,count(*) as amount"
					+ "from t_denglus a  where a.fTime => ? and a.fTime <= ?"
					+ "group by hour(a.fTime) "
					+ "order by hour(a.fTime) asc";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, startDate);
			queryObject.setParameter(1, endDate);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("查询用户登陆数据失败", re);
			throw re;
		}
	}
	
	public List findAll() {
		log.info("finding all TDenglus instances");
		try {
			String queryString = "from TDenglus";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TDenglus merge(TDenglus detachedInstance) {
		log.info("merging TDenglus instance");
		try {
			TDenglus result = (TDenglus) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDenglus instance) {
		log.info("attaching dirty TDenglus instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDenglus instance) {
		log.info("attaching clean TDenglus instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static DengluDao getFromApplicationContext(ApplicationContext ctx) {
		return (DengluDao) ctx.getBean("TDenglusDAO");
	}
}