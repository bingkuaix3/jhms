package com.jhms.dao.advice;

import java.util.List;

import com.jhms.entity.TAdvice;

public interface IAdviceDao {

	public void save(TAdvice transientInstance);
	
	public void delete(TAdvice persistentInstance);
	
	public TAdvice findById(java.lang.String id);
	
	public List findByExample(TAdvice instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public TAdvice merge(TAdvice detachedInstance);
}
