package com.jhms.dao.admin;

import java.util.List;

import com.jhms.entity.TAdmin;

public interface IAdminDao {
	
	public void save(TAdmin transientInstance);
	
	public void delete(TAdmin persistentInstance);
	
	public TAdmin findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public TAdmin findByNameAndPwd(String name, String pwd);
	
	public List findAll();
	
	public TAdmin merge(TAdmin detachedInstance);

}
