package com.jhms.dao.pinglun;

import java.util.List;

import com.jhms.entity.TPingluns;

public interface IPinglunDao {
	
	public void save(TPingluns transientInstance);
	
	public void delete(TPingluns persistentInstance);
	
	public TPingluns findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TPingluns merge(TPingluns detachedInstance);

}
