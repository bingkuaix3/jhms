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

import com.jhms.entity.TDianjis;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDianjis entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jhms.dao.TDianjis
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TDianjisDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TDianjisDAO.class);
	// property constants
	public static final String FJIANFEI = "fjianfei";
	public static final String FJIANFEI_SOL = "fjianfeiSol";
	public static final String FQUDOU = "fqudou";
	public static final String FQUDOU_SOL = "fqudouSol";
	public static final String FKOUCHOU = "fkouchou";
	public static final String FKOUCHOU_SOL = "fkouchouSol";
	public static final String FYANYAN = "fyanyan";
	public static final String FYANYAN_SOL = "fyanyanSol";
	public static final String FSHIMIAN = "fshimian";
	public static final String FSHIMAIN_SOL = "fshimainSol";
	public static final String FBIANMI = "fbianmi";
	public static final String FBIANMI_SOL = "fbianmiSol";
	public static final String FLILIAO = "fliliao";
	public static final String FLILIAO_SOL = "fliliaoSol";
	public static final String FSHILIAO = "fshiliao";
	public static final String FSHILIAO_SOL = "fshiliaoSol";
	public static final String FJIANCHI = "fjianchi";
	public static final String FSHARE = "fshare";
	public static final String FMENU_BZ = "fmenuBz";
	public static final String FMENU_JC = "fmenuJc";

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

	public void save(TDianjis transientInstance) {
		log.debug("saving TDianjis instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDianjis persistentInstance) {
		log.debug("deleting TDianjis instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDianjis findById(java.lang.String id) {
		log.debug("getting TDianjis instance with id: " + id);
		try {
			TDianjis instance = (TDianjis) getCurrentSession().get(
					"com.jhms.dao.TDianjis", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDianjis instance) {
		log.debug("finding TDianjis instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.jhms.dao.TDianjis")
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
		log.debug("finding TDianjis instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDianjis as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFjianfei(Object fjianfei) {
		return findByProperty(FJIANFEI, fjianfei);
	}

	public List findByFjianfeiSol(Object fjianfeiSol) {
		return findByProperty(FJIANFEI_SOL, fjianfeiSol);
	}

	public List findByFqudou(Object fqudou) {
		return findByProperty(FQUDOU, fqudou);
	}

	public List findByFqudouSol(Object fqudouSol) {
		return findByProperty(FQUDOU_SOL, fqudouSol);
	}

	public List findByFkouchou(Object fkouchou) {
		return findByProperty(FKOUCHOU, fkouchou);
	}

	public List findByFkouchouSol(Object fkouchouSol) {
		return findByProperty(FKOUCHOU_SOL, fkouchouSol);
	}

	public List findByFyanyan(Object fyanyan) {
		return findByProperty(FYANYAN, fyanyan);
	}

	public List findByFyanyanSol(Object fyanyanSol) {
		return findByProperty(FYANYAN_SOL, fyanyanSol);
	}

	public List findByFshimian(Object fshimian) {
		return findByProperty(FSHIMIAN, fshimian);
	}

	public List findByFshimainSol(Object fshimainSol) {
		return findByProperty(FSHIMAIN_SOL, fshimainSol);
	}

	public List findByFbianmi(Object fbianmi) {
		return findByProperty(FBIANMI, fbianmi);
	}

	public List findByFbianmiSol(Object fbianmiSol) {
		return findByProperty(FBIANMI_SOL, fbianmiSol);
	}

	public List findByFliliao(Object fliliao) {
		return findByProperty(FLILIAO, fliliao);
	}

	public List findByFliliaoSol(Object fliliaoSol) {
		return findByProperty(FLILIAO_SOL, fliliaoSol);
	}

	public List findByFshiliao(Object fshiliao) {
		return findByProperty(FSHILIAO, fshiliao);
	}

	public List findByFshiliaoSol(Object fshiliaoSol) {
		return findByProperty(FSHILIAO_SOL, fshiliaoSol);
	}

	public List findByFjianchi(Object fjianchi) {
		return findByProperty(FJIANCHI, fjianchi);
	}

	public List findByFshare(Object fshare) {
		return findByProperty(FSHARE, fshare);
	}

	public List findByFmenuBz(Object fmenuBz) {
		return findByProperty(FMENU_BZ, fmenuBz);
	}

	public List findByFmenuJc(Object fmenuJc) {
		return findByProperty(FMENU_JC, fmenuJc);
	}

	public List findAll() {
		log.debug("finding all TDianjis instances");
		try {
			String queryString = "from TDianjis";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDianjis merge(TDianjis detachedInstance) {
		log.debug("merging TDianjis instance");
		try {
			TDianjis result = (TDianjis) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDianjis instance) {
		log.debug("attaching dirty TDianjis instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDianjis instance) {
		log.debug("attaching clean TDianjis instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDianjisDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TDianjisDAO) ctx.getBean("TDianjisDAO");
	}
}