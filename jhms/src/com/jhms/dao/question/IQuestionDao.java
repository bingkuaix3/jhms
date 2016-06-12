package com.jhms.dao.question;

import java.util.List;

import com.jhms.entity.TQuestions;

public interface IQuestionDao {
	
	public void save(TQuestions transientInstance);
	
	public void delete(TQuestions persistentInstance);
	
	public TQuestions findById(java.lang.String id);
	
	public List findByExample(TQuestions instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TQuestions merge(TQuestions detachedInstance);

}
