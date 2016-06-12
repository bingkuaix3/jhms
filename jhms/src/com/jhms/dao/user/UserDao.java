package com.jhms.dao.user;

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

import com.jhms.entity.TUsers;
import com.jhms.po.graph.UserAgeAmount;
import com.jhms.po.graph.UserRegisterAmount;
import com.jhms.po.graph.UserSexRatio;
import com.jhms.po.graph.UserSourceRatio;

/**
 * A data access object (DAO) providing persistence and search support for
 * TUsers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TUsers
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDao implements IUserDao {
	private static final Log log = LogFactory.getLog(UserDao.class);
	// property constants
	public static final String FID = "fid";
	public static final String FNAME = "fname";
	public static final String FPWD = "fpwd";
	public static final String FTYPE = "ftype";
	public static final String FAGE = "fage";
	public static final String FSEX = "fsex";
	public static final String FHEIGHT = "fheight";
	public static final String FCOUNTRY = "fcountry";
	public static final String FPROVINCE = "fprovince";
	public static final String FCITY = "fcity";
	public static final String FHEAD = "fhead";

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

	public void save(TUsers transientInstance) {
		log.info("saving TUsers instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed", re);
			throw re;
		}
	}

	public void delete(TUsers persistentInstance) {
		log.info("deleting TUsers instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.info("delete failed", re);
			throw re;
		}
	}

	public TUsers findById(java.lang.String id) {
		log.info("getting TUsers instance with id: " + id);
		try {
			TUsers instance = (TUsers) getCurrentSession().get(
					"com.jhms.dao.TUsers", id);
			return instance;
		} catch (RuntimeException re) {
			log.info("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUsers instance) {
		log.info("finding TUsers instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TUsers")
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
		log.info("finding TUsers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUsers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find by property name failed", re);
			throw re;
		}
	}

	public List<UserRegisterAmount> findRegisterByDate(String startDate, String endDate) {
		log.info("查询用户注册量数据，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select CONCAT(year(a.fCreateTime),'-',month(a.fCreateTime),'-',day(a.fCreateTime)) as registerDate, count(*) as registerDate "
					+ "from t_users a  where a.fCreateTime => ? and a.fCreateTime <= ?"
					+ "group by year(a.fCreateTime),  month(a.fCreateTime), day(a.fCreateTime) "
					+ "order by year(a.fCreateTime),  month(a.fCreateTime), day(a.fCreateTime) asc";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, startDate);
			queryObject.setParameter(1, endDate);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("查询用户注册量数据失败", re);
			throw re;
		}
	}

	public List<UserSexRatio> findSexByDate(String startDate, String endDate) {
		log.info("查询用户性别比例数据，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select a.fSex as sexType, count(*) as sexAmount "
					+ "from t_users a where a.fCreateTime => ? and a.fCreateTime <= ?"
					+ "group by a.fSex "
					+ "order by a.fSex asc";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, startDate);
			queryObject.setParameter(1, endDate);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("查询用户性别比例数据失败", re);
			throw re;
		}
	}
	
	public List<UserSourceRatio> findSourceByDate(String startDate, String endDate) {
		log.info("查询用户来源比例数据，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select a.fType as sourceType, count(*) as sourceAmount "
					+ "from t_users a where a.fCreateTime => ? and a.fCreateTime <= ?"
					+ "group by a.fType "
					+ "order by a.fType asc";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, startDate);
			queryObject.setParameter(1, endDate);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("查询用户来源比例数据失败", re);
			throw re;
		}
	}
	
	public int findCountByDate(String startDate, String endDate){
		log.info("查询用户数量，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select count(*) as sourceAmount "
					+ "from t_users a  where a.fCreateTime => ? and a.fCreateTime <= ?";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, startDate);
			queryObject.setParameter(1, endDate);
			return (int)queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.info("查询用户数量失败", re);
			throw re;
		}
	}
	
	public List<UserAgeAmount> findAgeByDate(String startDate, String endDate) {
		log.info("查询用户年龄数量数据，时间范围：" + startDate + "至" + endDate);
		try {
			String queryString = "select a.fAge as age, count(*) as amount "
					+ "from t_users a  where a.fCreateTime => ? and a.fCreateTime <= ?"
					+ "group by a.fAge "
					+ "order by a.fAge asc";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setParameter(0, startDate);
			queryObject.setParameter(1, endDate);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("查询用户年龄数量数据失败", re);
			throw re;
		}
	}
	
	public List findByFid(Object fid) {
		return findByProperty(FID, fid);
	}

	public List findByFname(Object fname) {
		return findByProperty(FNAME, fname);
	}

	public List findByFpwd(Object fpwd) {
		return findByProperty(FPWD, fpwd);
	}

	public List findByFtype(Object ftype) {
		return findByProperty(FTYPE, ftype);
	}

	public List findByFage(Object fage) {
		return findByProperty(FAGE, fage);
	}

	public List findByFsex(Object fsex) {
		return findByProperty(FSEX, fsex);
	}

	public List findByFheight(Object fheight) {
		return findByProperty(FHEIGHT, fheight);
	}

	public List findByFcountry(Object fcountry) {
		return findByProperty(FCOUNTRY, fcountry);
	}

	public List findByFprovince(Object fprovince) {
		return findByProperty(FPROVINCE, fprovince);
	}

	public List findByFcity(Object fcity) {
		return findByProperty(FCITY, fcity);
	}

	public List findByFhead(Object fhead) {
		return findByProperty(FHEAD, fhead);
	}

	public List findAll() {
		log.info("finding all TUsers instances");
		try {
			String queryString = "from TUsers";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.info("find all failed", re);
			throw re;
		}
	}

	public TUsers merge(TUsers detachedInstance) {
		log.info("merging TUsers instance");
		try {
			TUsers result = (TUsers) getCurrentSession()
					.merge(detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.info("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUsers instance) {
		log.info("attaching dirty TUsers instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUsers instance) {
		log.info("attaching clean TUsers instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.info("attach failed", re);
			throw re;
		}
	}

	public static UserDao getFromApplicationContext(ApplicationContext ctx) {
		return (UserDao) ctx.getBean("TUsersDAO");
	}
}