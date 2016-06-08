package com.jhms.dao.question;

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

import com.jhms.entity.TQuestions;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQuestions entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.entity.TQuestions
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TQuestionsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TQuestionsDAO.class);
	// property constants
	public static final String FBELONG_DEMAND = "fbelongDemand";
	public static final String FCONTENT = "fcontent";

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

	public void save(TQuestions transientInstance) {
		log.debug("saving TQuestions instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQuestions persistentInstance) {
		log.debug("deleting TQuestions instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQuestions findById(java.lang.String id) {
		log.debug("getting TQuestions instance with id: " + id);
		try {
			TQuestions instance = (TQuestions) getCurrentSession().get(
					"com.jhms.dao.TQuestions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TQuestions instance) {
		log.debug("finding TQuestions instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TQuestions")
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
		log.debug("finding TQuestions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TQuestions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFbelongDemand(Object fbelongDemand) {
		return findByProperty(FBELONG_DEMAND, fbelongDemand);
	}

	public List findByFcontent(Object fcontent) {
		return findByProperty(FCONTENT, fcontent);
	}

	public List findAll() {
		log.debug("finding all TQuestions instances");
		try {
			String queryString = "from TQuestions";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQuestions merge(TQuestions detachedInstance) {
		log.debug("merging TQuestions instance");
		try {
			TQuestions result = (TQuestions) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQuestions instance) {
		log.debug("attaching dirty TQuestions instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQuestions instance) {
		log.debug("attaching clean TQuestions instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQuestionsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TQuestionsDAO) ctx.getBean("TQuestionsDAO");
	}
}