package com.jhms.dao.chanpin;

import java.util.List;

import com.jhms.entity.TChanpins;

public interface IChanpinDao {

	public void save(TChanpins transientInstance);
	
	public void delete(TChanpins persistentInstance);
	
	public TChanpins findById(java.lang.String id);
	
	public List findByExample(TChanpins instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TChanpins merge(TChanpins detachedInstance);
}
