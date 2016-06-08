package com.jhms.dao.physique;

import java.util.List;

import com.jhms.entity.TPhysiques;

public interface IPhysiqueDao {

	public void save(TPhysiques transientInstance);
	
	public void delete(TPhysiques persistentInstance);
	
	public TPhysiques findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TPhysiques merge(TPhysiques detachedInstance);
}
