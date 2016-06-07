package com.jhms.dao.check;

import java.util.List;

import com.jhms.entity.TChecks;

public interface ICheckDao {
	
	public void save(TChecks transientInstance);
	
	public void delete(TChecks persistentInstance);
	
	public TChecks findById(java.lang.String id);
	
	public List findByExample(TChecks instance);
	
	public List findAll();
	
	public TChecks merge(TChecks detachedInstance);

}
