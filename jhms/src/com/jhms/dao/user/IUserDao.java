package com.jhms.dao.user;

import java.util.List;

import com.jhms.entity.TUsers;

public interface IUserDao {
	
	public void save(TUsers transientInstance);
	
	public void delete(TUsers persistentInstance);
	
	public TUsers findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TUsers merge(TUsers detachedInstance);

}
